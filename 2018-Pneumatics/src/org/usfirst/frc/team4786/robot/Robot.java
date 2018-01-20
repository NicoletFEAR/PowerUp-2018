package org.usfirst.frc.team4786.robot;

import org.usfirst.frc.team4786.robot.commands.PistonIn;
import org.usfirst.frc.team4786.robot.commands.PistonOut;
import org.usfirst.frc.team4786.robot.commands.QueryCompressorStatus;
//import org.usfirst.frc.team4786.robot.subsystems.AirCompressor;
import org.usfirst.frc.team4786.robot.subsystems.AirCompressor;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	//public final static DoubleSolenoid arm = new DoubleSolenoid(RobotMap.armmoduleNumber, RobotMap.armforwardChannel,RobotMap.armreverseChannel);
	
	public static OI oi;
	public static AirCompressor c;
	
	Command teleopcommandc;
	Command teleopcommandin;
	Command teleopcommandout;
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		
		oi = new OI();
		c= new AirCompressor(RobotMap.compressormodule);
		
		
		SmartDashboard.putData("Auto choices", chooser);
		SmartDashboard.putBoolean("The Compressor is on", AirCompressor.c.enabled());
		SmartDashboard.putBoolean ("The Compressor is on control mode", AirCompressor.c.getClosedLoopControl());
		SmartDashboard.putBoolean("The pressure is low", AirCompressor.c.getPressureSwitchValue());
		SmartDashboard.putNumber("The current pressure in amps:", AirCompressor.c.getCompressorCurrent());
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		autoSelected = chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		switch (autoSelected) {
		case customAuto:
			// Put custom auto code here
			break;
		case defaultAuto:
		default:
			// Put default auto code here
			break;
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		teleopcommandc = new QueryCompressorStatus();
		teleopcommandin = new PistonIn();
		teleopcommandout= new PistonOut();
		if(teleopcommandc != null && teleopcommandin!=null && teleopcommandout!=null ){
			teleopcommandc.start();
			teleopcommandin.start();
			teleopcommandout.start();
		}
		
		
	}
	

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	
	}
	public void disabledPeriodic(){
		//AirCompressor.c.setClosedLoopControl(true);
		if(teleopcommandc != null && teleopcommandin!=null && teleopcommandout!=null ){
			teleopcommandc.start();
			teleopcommandin.start();
			teleopcommandout.start();
		}
	}
}

