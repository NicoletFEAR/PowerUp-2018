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

import org.usfirst.frc4786.RobotBuilderTest1.commands.DisplayAutonomous;
import org.usfirst.frc4786.RobotBuilderTest1.commands.PlayDoNothing;
import org.usfirst.frc4786.RobotBuilderTest1.commands.PlayDriveForward;
import org.usfirst.frc4786.RobotBuilderTest1.commands.PlayDriveToNULL;
import org.usfirst.frc4786.RobotBuilderTest1.commands.PlayDriveToSideSwitch;
import org.usfirst.frc4786.RobotBuilderTest1.commands.PlayShootGetCube;
import org.usfirst.frc4786.RobotBuilderTest1.commands.PlayShootNearSwitch;
import org.usfirst.frc4786.RobotBuilderTest1.commands.TurnToAngle;
import org.usfirst.frc4786.RobotBuilderTest1.subsystems.ArduinoInterface;
import org.usfirst.frc4786.RobotBuilderTest1.subsystems.AutoChooser;
import org.usfirst.frc4786.RobotBuilderTest1.subsystems.Cube;
import org.usfirst.frc4786.RobotBuilderTest1.subsystems.DriveTrain;
import org.usfirst.frc4786.RobotBuilderTest1.subsystems.Lifter;
import org.usfirst.frc4786.RobotBuilderTest1.subsystems.PressureSensor;
import org.usfirst.frc4786.RobotBuilderTest1.subsystems.Shifter;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4786.RobotBuilderTest1.commands.VisionNTableValueSet;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	Command VisionNTableValueSet;
	Command CubeVisionDrive;
	Command autonomousCommand;
	Command disabledCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	public static DriverStation.Alliance alliance;
	public static String allianceColorVal = "";

	public static OI oi;
	public static DriveTrain driveTrain;
	public static AutoChooser autoChooser;
	public static ArduinoInterface arduinoLCDInterface;

	public static RobotMap.AutoPlay myPlay = RobotMap.AutoPlay.ONE;
	public static RobotMap.AutoPosition myPosition = RobotMap.AutoPosition.A;
	public static String teamSwitchSide;
	public static Cube cubeMech;
	public static Lifter lifty;
	public static Shifter shifter = new Shifter();
	public static PressureSensor pressureSensor = new PressureSensor();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@SuppressWarnings("deprecation")

	// We are using the old network tables code because it makes a lot more
	// sense! (so deprecation warnings are OK!)
	NetworkTable myTable; // starts myTable (We think that you have to put this
							// and make a table to access the data in all of the
							// different places that you want the data to be
							// used in (same for the myTable = one!))
	// myTable is the table you use to put the data from the GRIP Contours
	// Report into

	@SuppressWarnings("deprecation")
	@Override
	public void robotInit() {
		double vNum = .04;

		RobotMap.init();
		RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);

		driveTrain = new DriveTrain();
		autoChooser = new AutoChooser();
		arduinoLCDInterface = new ArduinoInterface(8);
		cubeMech = new Cube();
		lifty = new Lifter();
		// arduinoLEDInterface = new ArduinoInterface(7);
		// arduinoCameraInterface = new ArduinoInterface(6);

		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		CameraServer camera = CameraServer.getInstance();
		camera.startAutomaticCapture("cam0", 50);
		camera.startAutomaticCapture();

		lifty.rampReset();
		cubeMech.raise();
		lifty.descend();

		System.out.println("Loading version " + vNum);
		SmartDashboard.putNumber("Version #", vNum);

		// Using old deprecated code on purpose - it still works!
		myTable = NetworkTable.getTable("GRIP/myContoursReport"); // makes the
																	// table
																	// myTable
																	// properly
																	// what it
																	// should be
		NetworkTable.setUpdateRate(0.05);
		/*
		 * myTable.putNumber("hsvHueMin", 31); myTable.putNumber("hsvHueMax",
		 * 69); myTable.putNumber("hsvSatMin", 71);
		 * myTable.putNumber("hsvSatMax", 182); myTable.putNumber("hsvValMin",
		 * 102); myTable.putNumber("hsvValMax", 255);
		 * myTable.putNumber("contourAreaMin", 1000);
		 * 
		 * myTable.putNumber("solidityMin", 77);
		 * myTable.putNumber("solidityMax", 100); myTable.putNumber("ratioMin",
		 * 0); myTable.putNumber("ratioMax", 4);
		 */
		myTable.setPersistent("hsvHueMin");
		myTable.setPersistent("hsvHueMax");
		myTable.setPersistent("hsvSatMin");
		myTable.setPersistent("hsvSatMax");
		myTable.setPersistent("hsvValMin");
		myTable.setPersistent("hsvValMax");
		myTable.setPersistent("contourAreaMin");

		myTable.setPersistent("solidityMin");
		myTable.setPersistent("solidityMax");
		myTable.setPersistent("ratioMin");
		myTable.setPersistent("ratioMax");

		SmartDashboard.putData("Auto mode", chooser);

		// Camera stuff

	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
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
		lifty.rampReset();

		lifty.descend();
		/*
		 * Once we have a working 2nd Arduino + LED System //send correct
		 * alliance data to arduino alliance =
		 * DriverStation.getInstance().getAlliance();
		 * 
		 * if(alliance.toString().equalsIgnoreCase("blue")){ allianceColorVal =
		 * "bluelight"; arduinoLEDInterface.writeStringData(allianceColorVal);
		 * }else if(alliance.toString().equalsIgnoreCase("red")){
		 * allianceColorVal = "redlight";
		 * arduinoLEDInterface.writeStringData(allianceColorVal); }else{
		 * allianceColorVal = "purplelight";
		 * arduinoLEDInterface.writeStringData(allianceColorVal); }
		 * SmartDashboard.putString("Alliance", allianceColorVal);
		 */

		// driveTrain.robotDrive.setSafetyEnabled(true);
		// driveTrain.robotDrive.setExpiration(1);
		// driveTrain.robotDrive.setMaxOutput(1.0);

		if (disabledCommand != null)
			disabledCommand.cancel();
		RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);

		teamSwitchSide = DriverStation.getInstance().getGameSpecificMessage().substring(0, 1);

		autoChooser.autonomousMode();

		new DisplayAutonomous();

		switch (myPlay) {
		case ONE:
			autonomousCommand = new PlayDoNothing();
			// driveTrain.driveForSeconds(4, .5, -.5);
			break;
		case TWO:
			autonomousCommand = new PlayDriveForward();
			break;
		case THREE:
			autonomousCommand = new PlayShootNearSwitch();
			break;
		case FOUR:
			autonomousCommand = new PlayDriveToNULL();
			break;
		case FIVE:
			autonomousCommand = new PlayShootGetCube();
			break;
		case SIX:
			autonomousCommand = new PlayDriveToSideSwitch();
			break;
		default:
			autonomousCommand = new PlayDoNothing();
			break;
		}
		autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
        lifty.rampReset();

	}

	@Override
	public void testInit() {

		// SmartDashboard.putNumber("valuetest", 555);

		new VisionNTableValueSet();
		// This will override the persistent values!!! Be careful!
		new VisionNTableValueSet(); // sets new values for the first time
	}

	@Override
	public void testPeriodic() {

		// SmartDashboard.putNumber("hsvHueMin", myTable.getDouble("hsvHueMin",
		// 0));

		// This will override the persistent values!!! Be careful!
		// new VisionNTableValueSet(); // sets new values for the first time
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
	}
}
