// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4786.RobotBuilderTest1;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4786.RobotBuilderTest1.commands.*;
import org.usfirst.frc4786.RobotBuilderTest1.subsystems.*;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    Command disabledCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();
    
	public static DriverStation.Alliance alliance;
	public static String allianceColorVal = "";

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static AutoChooser autoChooser;
    public static ArduinoInterface arduinoLCDInterface;
    public static Cube cubeMech;
    public static Lifter lifty;
//    public static ArduinoInterface arduinoLEDInterface;
//    public static ArduinoInterface arduinoCameraInterface;
    
    public static RobotMap.AutoPlay myPlay = RobotMap.AutoPlay.ONE;
	public static RobotMap.AutoPosition myPosition = RobotMap.AutoPosition.A;
    public static Shifter shifter = new Shifter();
    public static PressureSensor pressureSensor = new PressureSensor();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.init();

        driveTrain = new DriveTrain();
        autoChooser =  new AutoChooser();
        arduinoLCDInterface = new ArduinoInterface(8);
        new DisplayAutonomous();
        cubeMech = new Cube();
        lifty = new Lifter();
        //arduinoLEDInterface = new ArduinoInterface(7);
        //arduinoCameraInterface = new ArduinoInterface(6);
        
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();
        
        CameraServer camera = CameraServer.getInstance();
        camera.startAutomaticCapture("cam0", 50);
        camera.startAutomaticCapture();
        
        

        SmartDashboard.putData("Auto mode", chooser);
        
        //Camera stuff
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit() {
    	disabledCommand = new DisplayAutonomous();
    	disabledCommand.setRunWhenDisabled(true);
    }

    @Override
    public void disabledPeriodic() {
    	disabledCommand.start();
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
    	/* Once we have a working 2nd Arduino + LED System
    	//send correct alliance data to arduino
		alliance = DriverStation.getInstance().getAlliance();
    	
    	if(alliance.toString().equalsIgnoreCase("blue")){
    		allianceColorVal = "bluelight";
    		arduinoLEDInterface.writeStringData(allianceColorVal);
   		}else if(alliance.toString().equalsIgnoreCase("red")){
   			allianceColorVal = "redlight";
   			arduinoLEDInterface.writeStringData(allianceColorVal);
    	}else{
    		allianceColorVal = "purplelight";
    		arduinoLEDInterface.writeStringData(allianceColorVal);
    	}
    	SmartDashboard.putString("Alliance", allianceColorVal);
    	*/
        
//        driveTrain.robotDrive.setSafetyEnabled(true);
//        driveTrain.robotDrive.setExpiration(1);
//        driveTrain.robotDrive.setMaxOutput(1.0);
        
        if (disabledCommand != null) disabledCommand.cancel();
        autoChooser.autonomousMode();

        new DisplayAutonomous();
        //myPlay = RobotMap.AutoPlay.ONE;
        switch (myPlay) {
        	case ONE:
        		//autonomousCommand = new DriveToPosition(2);
        		driveTrain.driveForSeconds(4, -0.4, 0.7);
        	case TWO:
        		driveTrain.driveForSeconds(4, -0.5, 0.5);
        		new CubeLaunch();
        	case THREE:
        		driveTrain.driveForSeconds(4, -0.5, 0.5);
//        		autonomousCommand = new Play3();
        	case FOUR:
        		driveTrain.driveForSeconds(4, -0.5, 0.5);
        		new CubeLaunch();
//        		autonomousCommand = new Play4();
        	case FIVE:
//        		autonomousCommand = new Play5();
        	case SIX:
//        		autonomousCommand = new Play6();
        	default:
//        		autonomousCommand = new AutoLine();
        }
		
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        pressureSensor.getPressure();
        
        double velocityRight = Robot.driveTrain.getRightEncoderVelocity();
        double velocityLeft = Robot.driveTrain.getLeftEncoderVelocity();
		SmartDashboard.putNumber("velR", velocityRight);
		SmartDashboard.putNumber("velL", velocityLeft);
		
		SmartDashboard.putNumber("Left Encoder: ", Robot.driveTrain.getLeftEncoderPosition());
		SmartDashboard.putNumber("Right Encoder: ", Robot.driveTrain.getRightEncoderPosition());
    }
}
