//package org.usfirst.frc4786.RobotBuilderTest1.commands;
//
//import org.usfirst.frc4786.RobotBuilderTest1.Robot;
//import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;
//
//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
//
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//
///**
// *
// */
//public class Piddrive extends Command {
//
//    public Piddrive() {
//        // Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//	
//    	/* choose the sensor and sensor direction */
//		RobotMap.myLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
//		RobotMap.myMid.follow(RobotMap.myLeft);
//		RobotMap.myBack.follow(RobotMap.myLeft);
//
//		/* choose to ensure sensor is positive when output is positive */
//		RobotMap.myLeft.setSensorPhase(true);
//
//		/* choose based on what direction you want forward/positive to be.
//		 * This does not affect sensor phase. */ 
//		RobotMap.myLeft.setInverted(true);
//
////		/* set the peak and nominal outputs, 12V means full */
//		RobotMap.myLeft.configNominalOutputForward(0, 10);
//		RobotMap.myLeft.configNominalOutputReverse(0, 10);
//		RobotMap.myLeft.configPeakOutputForward(1, 10);
//		RobotMap.myLeft.configPeakOutputReverse(-1, 10);
//		/*
//		 * set the allowable closed-loop error, Closed-Loop output will be
//		 * neutral within this range. See Table in Section 17.2.1 for native
//		 * units per rotation.
//		 */
//		RobotMap.myLeft.configAllowableClosedloopError(0, 0, 10);
//
//		/* set closed loop gains in slot0, typically kF stays zero. */
//		RobotMap.myLeft.config_kF(0, 0.0, 10);
//		RobotMap.myLeft.config_kP(0, 0.1, 10);
//		RobotMap.myLeft.config_kI(0, 0.0, 10);
//		RobotMap.myLeft.config_kD(0, 0.0, 10);
//
//		/*
//		 * lets grab the 360 degree position of the MagEncoder's absolute
//		 * position, and intitally set the relative sensor to match.
//		 */
////		int absolutePosition = RobotMap.myLeft.getSensorCollection().getPulseWidthPosition();
////		/* mask out overflows, keep bottom 12 bits */
////		absolutePosition &= 0xFFF;
////		if (Constants.kSensorPhase)
////			absolutePosition *= -1;
////		if (Constants.kMotorInvert)
////			absolutePosition *= -1;
//		/* set the quadrature (relative) sensor to match absolute */
//		RobotMap.myLeft.setSelectedSensorPosition(0, 0, 10);
//    	
//    	
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	RobotMap.myLeft.set(ControlMode.Position, 4096.0);
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//    	SmartDashboard.putNumber("finished", -(RobotMap.myLeft.getSelectedSensorPosition(0)));
//    	if (-(RobotMap.myLeft.getSelectedSensorPosition(0)) >= 4096.0){
//    		return true;
//    	}
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	RobotMap.myLeft.set(ControlMode.PercentOutput, 0);
//    	
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
