package org.usfirst.frc.team4786.robot;

import org.usfirst.frc.team4786.robot.commands.PistonIn;
import org.usfirst.frc.team4786.robot.commands.PistonOut;
import org.usfirst.frc.team4786.robot.commands.QueryCompressorStatus;
//import org.usfirst.frc.team4786.robot.subsystems.AirCompressor;
import org.usfirst.frc.team4786.robot.subsystems.AirCompressor;
import org.usfirst.frc.team4786.robot.subsystems.ArmSolenoid;
import org.usfirst.frc.team4786.robot.subsystems.EyeSolenoid;
import org.usfirst.frc.team4786.robot.subsystems.HeadSolenoid;
import org.usfirst.frc.team4786.robot.subsystems.LegSolenoid;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
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
	
	
	public static AirCompressor aircompressor;
	public static ArmSolenoid armsolenoid;
	public static EyeSolenoid eyesolenoid;
	public static HeadSolenoid headsolenoid;
	public static LegSolenoid legsolenoid;
	public static OI oi;
	
	XboxController xbox2 = new XboxController(0);
	boolean ATube = false;
	
	Command teleopcommandc;
	Command teleopcommandin;
	Command teleopcommandout;
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		
		
		aircompressor= new AirCompressor(RobotMap.compressormodule);
		armsolenoid = new ArmSolenoid();
		eyesolenoid = new EyeSolenoid();
		headsolenoid = new HeadSolenoid();
		legsolenoid = new LegSolenoid();
		oi = new OI();
		
		SmartDashboard.putData("Auto choices", chooser);
//		SmartDashboard.putBoolean("The Compressor is on", AirCompressor.c.enabled());
	//	SmartDashboard.putBoolean ("The Compressor is on control mode", AirCompressor.c.getClosedLoopControl());
		//SmartDashboard.putBoolean("The pressure is low", AirCompressor.c.getPressureSwitchValue());
	//	SmartDashboard.putNumber("Pressure (amps):", AirCompressor.c.getCompressorCurrent());
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
		/*PistonOut firepiston = new PistonOut();
		firepiston.start();*/
		
		PistonIn retractpiston = new PistonIn();
		retractpiston.start();
	/*	armsolenoid.retractarmdoublesolenoid();
		eyesolenoid.retracteyedoublesolenoid();
		headsolenoid.retractheaddoublesolenoid();
		legsolenoid.retractlegdoublesolenoid(); 
		
		boolean fire = 
		
		if ()
		armsolenoid.firearmdoublesolenoid();
		eyesolenoid.fireeyedoublesolenoid();
		headsolenoid.fireheaddoublesolenoid();
		legsolenoid.firelegdoublesolenoid(); */
		//eyesolenoid.fireeyedoublesolenoid();
		
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
		/*SmartDashboard.putBoolean("The Compressor is on", AirCompressor.c.enabled());
		SmartDashboard.putBoolean ("The Compressor is on control mode", AirCompressor.c.getClosedLoopControl());
		SmartDashboard.putBoolean("The pressure is low", AirCompressor.c.getPressureSwitchValue());
		SmartDashboard.putNumber("Pressure (amps):", AirCompressor.c.getCompressorCurrent());
		teleopcommandc = new QueryCompressorStatus();
		teleopcommandin = new PistonIn();
		teleopcommandout= new PistonOut();
		if(teleopcommandc != null && teleopcommandin!=null && teleopcommandout!=null ){
			teleopcommandc.start();
			teleopcommandin.start();
			teleopcommandout.start(); */
		
		
		
		if (xbox2.getAButtonPressed()){
			ATube = !ATube;
		}
		
		if (ATube) {
			armsolenoid.firearmdoublesolenoid();
		} else {
			armsolenoid.retractarmdoublesolenoid();
		}
		
		
		if (xbox2.getYButtonPressed()) {
		armsolenoid.firearmdoublesolenoid();
		eyesolenoid.fireeyedoublesolenoid();
		headsolenoid.fireheaddoublesolenoid();
		legsolenoid.firelegdoublesolenoid(); 
		//eyesolenoid.fireeyedoublesolenoid();
		} else if (xbox2.getXButtonPressed()) {
			armsolenoid.retractarmdoublesolenoid();
			eyesolenoid.retracteyedoublesolenoid();
			headsolenoid.retractheaddoublesolenoid();
			legsolenoid.retractlegdoublesolenoid();
		} else {
			
		}
		
		
	}
	

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		
	
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

