//package org.usfirst.frc4786.RobotBuilderTest1.subsystems;
//
//import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;
//
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.command.PIDSubsystem;
//
///**
// *
// */
//public class PIDSub extends PIDSubsystem {
////	private final WPI_TalonSRX tal13 = RobotMap.frontLeft;
////	private final WPI_TalonSRX tal15 = RobotMap.midLeft;
////	private final WPI_TalonSRX tal17 = RobotMap.backLeft;
////	private final Encoder enc13 = RobotMap.encoder13;
////	private final Encoder enc14 = RobotMap.encoder14;
//	// Initialize your subsystem here
//	public PIDSub() {
//		// Use these to get going:
//		// setSetpoint() - Sets where the PID controller should move the system
//		// to
//		// enable() - Enables the PID controller.
//		super("PIDSub", 1.0, 0.0, 0.0);
//		setAbsoluteTolerance(0.3);
//		getPIDController().setContinuous(true);
//		
//	}
//
//	public void initDefaultCommand() {
//		// Set the default command for a subsystem here.
//		// setDefaultCommand(new MySpecialCommand());
//	}
//
//	protected double returnPIDInput() {
//		// Return your input value for the PID loop
//		// e.g. a sensor, like a potentiometer:
//		// yourPot.getAverageVoltage() / kYourMaxVoltage;
//		return enc13.pidGet();
//	}
//
//	protected void usePIDOutput(double output) {
//		// Use output to drive your system, like a motor
//		// e.g. yourMotor.set(output);
////		tal13.pidWrite(output);
//	}
//}
