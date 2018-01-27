package org.usfirst.frc.team4786.robot;

import org.usfirst.frc.team4786.robot.subsystems.AirCompressor;
import org.usfirst.frc.team4786.robot.subsystems.GameMech;
import org.usfirst.frc.team4786.robot.subsystems.Shifter;
import org.usfirst.frc.team4786.robot.commands.*;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
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

	public static Shifter shifter = new Shifter();
	
	public static GameMech gameMech = new GameMech();
	
	public static OI oi;

	

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
		
		oi = new OI();
		
		
		SmartDashboard.putData("Auto choices", chooser);
		SmartDashboard.putBoolean("The Compressor is on", AirCompressor.c.enabled());
		SmartDashboard.putBoolean ("The Compressor is on control mode", AirCompressor.c.getClosedLoopControl());
		SmartDashboard.putBoolean("The pressure is enough", AirCompressor.c.getPressureSwitchValue());
		SmartDashboard.putNumber("Pressure (amps):", AirCompressor.c.getCompressorCurrent());
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

	public void teleopInit(){
//		Command shiftUp = new ShiftUp();
//		shiftUp.start();
	}
	
	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putBoolean("The Compressor is on", AirCompressor.c.enabled());
		SmartDashboard.putBoolean ("The Compressor is on control mode", AirCompressor.c.getClosedLoopControl());
		SmartDashboard.putBoolean("The pressure is low", AirCompressor.c.getPressureSwitchValue());
		SmartDashboard.putNumber("Pressure (amps):", AirCompressor.c.getCompressorCurrent());
		
		Scheduler.getInstance().run();
	}
	

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		
	
	}
	public void disabledPeriodic(){
		AirCompressor.c.setClosedLoopControl(true);

		
		}
	}



