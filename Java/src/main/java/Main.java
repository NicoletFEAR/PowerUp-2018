

 import java.util.ArrayList;
import edu.wpi.first.wpilibj.networktables.*;
import edu.wpi.first.wpilibj.tables.*;
import edu.wpi.cscore.*;
import org.opencv.imgproc.Imgproc;
import java.util.List;
import org.opencv.core.*;
//end added imports

public class Main {
  public static void main(String[] args) {
    // Loads our OpenCV library. This MUST be included
    System.loadLibrary("opencv_java310");

    // Connect NetworkTables, and get access to the publishing table
    NetworkTable.setClientMode();
    // Set your team number here
    NetworkTable.setTeam(4786);

    NetworkTable.initialize();
    
    int bigCubeIndex = 0;
    
    NetworkTable myTable;
    
    myTable = NetworkTable.getTable("GRIP/myContoursReport");
    
   // This is the network port you want to stream the raw received image to
    // By rules, this has to be between 1180 and 1190, so 1185 is a good choice
    int streamPort = 1185;
    // This stores our reference to our mjpeg server for streaming the input image
    MjpegServer inputStream = new MjpegServer("MJPEG Server", streamPort);


	//Outputs
	Mat hsvThresholdOutput = new Mat();
	ArrayList<MatOfPoint> findContoursOutput = new ArrayList<MatOfPoint>();
	ArrayList<MatOfPoint> filterContoursOutput = new ArrayList<MatOfPoint>();
	ArrayList<MatOfPoint> convexHullsOutput = new ArrayList<MatOfPoint>();
	double centerX = 0;
	double centerY = 0;
	double boxSizeWidth = 2.0;


    // USB Camera
   
    // This gets the image from a USB camera 
    // Usually this will be on device 0, but there are other overloads
    // that can be used if multiple cameras use 0, 1 ,2 , ...)
    UsbCamera camera = setUsbCamera(0, inputStream);
    // Set the resolution for our camera, since this is over USB
    camera.setResolution(640,480);
    
    // STops camera from changing its settings
//    camera.setExposureManual(1);
//    camera.setWhiteBalanceManual(1);
  

    // This creates a CvSink for us to use. This grabs images from our selected camera, 
    // and will allow us to use those images in opencv
    CvSink imageSink = new CvSink("CV Image Grabber");
    imageSink.setSource(camera);

    // This creates a CvSource to use. This will take in a Mat image that has had OpenCV operations
    // operations 
    CvSource imageSource = new CvSource("CV Image Source", VideoMode.PixelFormat.kMJPEG, 640, 480, 30);

    // ****** raw maybe we could diagnose by output the result to find contours step to second mjpg stream
    // do not want processed image stream for now //    
    MjpegServer cvStream = new MjpegServer("CV Image Stream", 1186);
    cvStream.setSource(imageSource);

    // All Mats and Lists should be stored outside the loop to avoid allocations
    // as they are expensive to create
    Mat inputImage = new Mat();
  
    
    //our stuff!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    Integer i = new Integer(0);
    
    
    
    while (!myTable.isConnected()){
    
    //HSV_Threshold tuning with network tables   these reset network table to defaults they must be removed if tuning capabilities are wanted
    //myTable.putNumber("hsvHueMin", 0);
    //myTable.putNumber("hsvHueMax", 57);
    //myTable.putNumber("hsvSatMin", 0.0);
    //myTable.putNumber("hsvSatMax", 99);
    //myTable.putNumber("hsvValMin", 175);
    //myTable.putNumber("hsvValMax", 255.0);
    
    //Filter contours 
    //myTable.putNumber("contourAreaMin", 5000.0); 
    
    }
    
    
    // HSV_Threshold
    double[] hsvThresholdHue = {30, 57};
	double[] hsvThresholdSaturation = {0.0, 100};
	double[] hsvThresholdValue = {175, 255.0};
//
// lets add reading updated configuration from the network table
		
	// Filter_Contours
	double filterContoursMinArea = 1000.0;
	double filterContoursMinPerimeter = 0.0;
	double filterContoursMinWidth = 0;
	double filterContoursMaxWidth = 10000.0;
	double filterContoursMinHeight = 0.0;
	double filterContoursMaxHeight = 10000.0;
	double[] filterContoursSolidity = {77, 100};
	double filterContoursMaxVertices = 10000.0;
	double filterContoursMinVertices = 0.0;
	double filterContoursMinRatio = 0;
	double filterContoursMaxRatio = 4.0;
	
	
	
	  // Getting the network table values for the first time
	
	  // HSV_Threshold re-checking network table values
      hsvThresholdHue[0] = myTable.getNumber("hsvHueMin", 26);
      hsvThresholdHue[1] = myTable.getNumber("hsvHueMax", 36);
      hsvThresholdSaturation[0] = myTable.getNumber("hsvSatMin", 80);
      hsvThresholdSaturation[1] = myTable.getNumber("hsvSatMax", 199);
      hsvThresholdValue[0] = myTable.getNumber("hsvValMin", 126);
      hsvThresholdValue[1] = myTable.getNumber("hsvValMax", 255);
      
      // HSV_Threshold re-checking network table values
      filterContoursMinArea = myTable.getNumber("contourAreaMin", 1000);
      
      // Solidity and ratio network table check for tuning! It is important to update e often. The second values are defaults
      filterContoursSolidity[0] = myTable.getNumber("solidityMin", 77);
      filterContoursSolidity[1] = myTable.getNumber("solidityMax", 100);
      filterContoursMinRatio = myTable.getNumber("ratioMin", 0);
      filterContoursMaxRatio = myTable.getNumber("ratioMax", 2);
      
      
     
      
      
      
    // Infinitely process image
    while (true) {
      // Grab a frame. If it has a frame time of 0, there was an error.
      // Just skip and continue
      long frameTime = imageSink.grabFrame(inputImage);
      if (frameTime == 0) continue;
      i++;
      if (i > 30) { 	  
    	  System.out.println("procesing image");
    	  System.out.println("contours found #");
    	  System.out.println(findContoursOutput.size());
    	  System.out.println("contours filtered #");
    	  System.out.println(filterContoursOutput.size());
    	  
    	  
    	  // Getting the network table values again for tuning purposes
    	  // HSV_Threshold re-checking network table values
          hsvThresholdHue[0] = myTable.getNumber("hsvHueMin", 26);
          hsvThresholdHue[1] = myTable.getNumber("hsvHueMax", 36);
          hsvThresholdSaturation[0] = myTable.getNumber("hsvSatMin", 80);
          hsvThresholdSaturation[1] = myTable.getNumber("hsvSatMax", 199);
          hsvThresholdValue[0] = myTable.getNumber("hsvValMin", 126);
          hsvThresholdValue[1] = myTable.getNumber("hsvValMax", 255);
          
          // HSV_Threshold re-checking network table values
          filterContoursMinArea = myTable.getNumber("contourAreaMin", 1000);
          
          // Solidity and ratio network table check for tuning!
          filterContoursSolidity[0] = myTable.getNumber("solidityMin", 77);
          filterContoursSolidity[1] = myTable.getNumber("solidityMax", 100);
          filterContoursMinRatio = myTable.getNumber("ratioMin", 0);
          filterContoursMaxRatio = myTable.getNumber("ratioMax", 2);
    	  
          System.out.println(filterContoursMinArea);
          
    	  i = 0;
      }
      
      myTable.putNumber("imageFrame", i);
      
      
           
      
      // LAW added GRIP Pipeline
      
      // Step HSV_Threshold
      hsvThreshold(inputImage, hsvThresholdHue, hsvThresholdSaturation, hsvThresholdValue, hsvThresholdOutput);
      // output the result of hsv threshold to the second video stream on port 1186 
      imageSource.putFrame(hsvThresholdOutput);
 
      
      // Step Find_Contours     
      findContours(hsvThresholdOutput, false, findContoursOutput);
      myTable.putNumber("foundContours", findContoursOutput.size()   );
     
		
      // Step Filter_Contours      
 	    filterContours(findContoursOutput, filterContoursMinArea, filterContoursMinPerimeter, filterContoursMinWidth, filterContoursMaxWidth, filterContoursMinHeight, filterContoursMaxHeight, filterContoursSolidity, filterContoursMaxVertices, filterContoursMinVertices, filterContoursMinRatio, filterContoursMaxRatio, filterContoursOutput);
	    //filterContours(findContoursOutput, filterContoursMinArea, 10, 10, 5000, 10, 5000, filterContoursSolidity, 10000000, 4, 0, 1000, filterContoursOutput);
		myTable.putNumber("filteredContours", filterContoursOutput.size()   );
      
      // Step Convex_Hulls0      
        convexHulls(filterContoursOutput, convexHullsOutput);
		myTable.putNumber("Hulls", convexHullsOutput.size()   );
  
		// for each output contour call LAWPublish to write values to nttables
		if (convexHullsOutput.size() > 0) {
//			LAWPublish(convexHullsOutput.get(0),0, centerX, centerY);
			// gets the index of largest cube
			
			if (bigCubeIndex >= convexHullsOutput.size()) {
				bigCubeIndex = 0;
			}
			
			for (int k = 0; k < convexHullsOutput.size(); k++) {
				org.opencv.core.Rect newRect = Imgproc.boundingRect(convexHullsOutput.get(k));
				org.opencv.core.Rect oldRect = Imgproc.boundingRect(convexHullsOutput.get(bigCubeIndex));
				if (newRect.width > oldRect.width) {
					bigCubeIndex = k;
				}
			}
			
			org.opencv.core.Rect myRect = Imgproc.boundingRect(convexHullsOutput.get(bigCubeIndex));
			centerX = myRect.x + myRect.width/2;
			centerY = myRect.y - myRect.height/2;  
			boxSizeWidth = myRect.width;
			
			//System.out.print("center coordinates: ");
			//System.out.println(centerX);
			myTable.putNumber("centerX", centerX);
			myTable.putNumber("centerY", centerY);


			myTable.putNumber("boxWidth", boxSizeWidth);

			myTable.putNumber("testNumber", 11111);
			
		} else {
			myTable.putNumber("nothingFound", i);
		}
    }
  }

    private static UsbCamera setUsbCamera(int cameraId, MjpegServer server) {
    // This gets the image from a USB camera 
    // Usually this will be on device 0, but there are other overloads
    // that can be used
    UsbCamera camera = new UsbCamera("CoprocessorCamera", cameraId);
    server.setSource(camera);
    return camera;
  }
  
	/**
	 * Segment an image based on hue, saturation, and value ranges.
	 *
	 * @param input The image on which to perform the HSL threshold.
	 * @param hue The min and max hue
	 * @param sat The min and max saturation
	 * @param val The min and max value
	 * @param output The image in which to store the output.
	 */
	private static void hsvThreshold(Mat input, double[] hue, double[] sat, double[] val,
	    Mat out) {
		Imgproc.cvtColor(input, out, Imgproc.COLOR_RGB2HSV);
//		out = input;
		Core.inRange(out, new Scalar(hue[0], sat[0], val[0]),
			new Scalar(hue[1], sat[1], val[1]), out);
	}

	/**
	 * Sets the values of pixels in a binary image to their distance to the nearest black pixel.
	 * @param input The image on which to perform the Distance Transform.
	 * @param type The Transform.
	 * @param maskSize the size of the mask.
	 * @param output The image in which to store the output.
	 */	

	private static void findContours(Mat input, boolean externalOnly,
		List<MatOfPoint> contours) {
		Mat hierarchy = new Mat();
		contours.clear();
		int mode;
		if (externalOnly) {
			mode = Imgproc.RETR_EXTERNAL;
		}
		else {
			mode = Imgproc.RETR_LIST;
		}
		int method = Imgproc.CHAIN_APPROX_SIMPLE;
		Imgproc.findContours(input, contours, hierarchy, mode, method);
	}


	/**
	 * Filters out contours that do not meet certain criteria.
	 * @param inputContours is the input list of contours
	 * @param output is the the output list of contours
	 * @param minArea is the minimum area of a contour that will be kept
	 * @param minPerimeter is the minimum perimeter of a contour that will be kept
	 * @param minWidth minimum width of a contour
	 * @param maxWidth maximum width
	 * @param minHeight minimum height
	 * @param maxHeight maximimum height
	 * @param Solidity the minimum and maximum solidity of a contour
	 * @param minVertexCount minimum vertex Count of the contours
	 * @param maxVertexCount maximum vertex Count
	 * @param minRatio minimum ratio of width to height
	 * @param maxRatio maximum ratio of width to height
	 */
	private static void filterContours(List<MatOfPoint> inputContours, double minArea,
		double minPerimeter, double minWidth, double maxWidth, double minHeight, double
		maxHeight, double[] solidity, double maxVertexCount, double minVertexCount, double
		minRatio, double maxRatio, List<MatOfPoint> output) {
		final MatOfInt hull = new MatOfInt();
		output.clear();
		//operation
		for (int i = 0; i < inputContours.size(); i++) {
			final MatOfPoint contour = inputContours.get(i);
			final Rect bb = Imgproc.boundingRect(contour);
			if (bb.width < minWidth || bb.width > maxWidth) continue;
			if (bb.height < minHeight || bb.height > maxHeight) continue;
			final double area = Imgproc.contourArea(contour);
			if (area < minArea) continue;
			if (Imgproc.arcLength(new MatOfPoint2f(contour.toArray()), true) < minPerimeter) continue;
			Imgproc.convexHull(contour, hull);
			MatOfPoint mopHull = new MatOfPoint();
			mopHull.create((int) hull.size().height, 1, CvType.CV_32SC2);
			for (int j = 0; j < hull.size().height; j++) {
				int index = (int)hull.get(j, 0)[0];
				double[] point = new double[] { contour.get(index, 0)[0], contour.get(index, 0)[1]};
				mopHull.put(j, 0, point);
			}
			final double solid = 100 * area / Imgproc.contourArea(mopHull);
			if (solid < solidity[0] || solid > solidity[1]) continue;
			if (contour.rows() < minVertexCount || contour.rows() > maxVertexCount)	continue;
			final double ratio = bb.width / (double)bb.height;
			if (ratio < minRatio || ratio > maxRatio) continue;
			output.add(contour);
		}
	}

	/**
	 * Compute the convex hulls of contours.
	 * @param inputContours The contours on which to perform the operation.
	 * @param outputContours The contours where the output will be stored.
	 */
	private static void convexHulls(List<MatOfPoint> inputContours,
		ArrayList<MatOfPoint> outputContours) {
		final MatOfInt hull = new MatOfInt();
		outputContours.clear();
		for (int i = 0; i < inputContours.size(); i++) {
			final MatOfPoint contour = inputContours.get(i);
			final MatOfPoint mopHull = new MatOfPoint();
			Imgproc.convexHull(contour, hull);
			mopHull.create((int) hull.size().height, 1, CvType.CV_32SC2);
			for (int j = 0; j < hull.size().height; j++) {
				int index = (int) hull.get(j, 0)[0];
				double[] point = new double[] {contour.get(index, 0)[0], contour.get(index, 0)[1]};
				mopHull.put(j, 0, point);
			}
			outputContours.add(mopHull);
		}
	}
	
	// end added methods
  
/*
	private static void LAWPublish(MatOfPoint input, int arrayIndex, double centerX, double centerY) {
	   
	  org.opencv.core.Rect myRect = Imgproc.boundingRect(input);
	  centerX = myRect.x + myRect.width/2;
	  centerY = myRect.y - myRect.height/2;  
	  System.out.println("center coordinates");
	  System.out.println(centerX);
   }
*/
	
	
	
	
	
	
	
  
  
  
}