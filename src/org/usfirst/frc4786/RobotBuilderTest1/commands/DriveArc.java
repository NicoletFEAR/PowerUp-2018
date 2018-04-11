package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveArc extends Command {

	public String direction;
	public double distance;
	public double leftSpeed;
	public double rightSpeed;
	double[] initReturn = new double[4];
	public double targetInsideRatio;
	public double currentInsideRatio;
	
    public DriveArc(String turnDirection, double sideWidth, double driveLength, double driveSpeed) {
    	requires(Robot.driveTrain);
    	direction = turnDirection;
    	distance = sideWidth;
    	leftSpeed = driveLength;
    	rightSpeed = driveSpeed;
    }

/*	public DriveArc(String arcDirection, double arcOutsideDistance, double arcOutsideSpeed, double arcInsideSpeed){
		 direction = arcDirection;
		 outsideDistance = arcOutsideDistance;
		 outsideSpeed = arcOutsideSpeed;
		 insideSpeed = arcInsideSpeed;
	}
*/	
    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
//    	initReturn = Robot.driveTrain.driveArcInit(direction, width, length, speed, RobotMap.wheelDistance);
/*    	if (direction.equals("left")){
        	initReturn[0] = outsideSpeed;
        	initReturn[1] = insideSpeed;
    		 
    	} else {
    		initReturn[0] = insideSpeed;
        	initReturn[1] = outsideSpeed;
    	}
    	initReturn[2] = 58;
*/
//    	targetInsideRatio = initReturn[4];
		if (direction.equals("left")) {
			targetInsideRatio = 0.66;
		} else {
			targetInsideRatio = 0.69;
		}
    	
    	RobotMap.midLeft.follow(RobotMap.frontLeft);
		RobotMap.backLeft.follow(RobotMap.frontLeft);
		RobotMap.midRight.follow(RobotMap.frontRight);
		RobotMap.backRight.follow(RobotMap.frontRight);
    		    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

// RAW not sure we want to do the follower instructions every execute loop ( CAN and roborio expense)
    	
		RobotMap.frontLeft.set(ControlMode.PercentOutput, -1 * leftSpeed);
		RobotMap.frontRight.set(ControlMode.PercentOutput, rightSpeed);

// make a 10% adjustment on the inside motor speed based on current distance ratio versus target ratio
		double leftEncoderValue = RobotMap.frontLeft.getSelectedSensorPosition(0);
		double rightEncoderValue = RobotMap.frontRight.getSelectedSensorPosition(0);
		if (direction.equals("left")) {
			currentInsideRatio = leftEncoderValue/rightEncoderValue;
			if (currentInsideRatio > targetInsideRatio) {
				leftSpeed = leftSpeed * 0.95;
			} else {
				leftSpeed = leftSpeed * 1.05;
			};
		} else { // turning right
			currentInsideRatio = rightEncoderValue/leftEncoderValue;
			if (currentInsideRatio > targetInsideRatio) {
				rightSpeed = rightSpeed * 0.95;
			} else {
				rightSpeed = rightSpeed * 1.05;
			};
		}
	
		
/*    	if (direction.equals("left")) {
    		RobotMap.frontLeft.set(ControlMode.PercentOutput, -1 * insideSpeed);
    		RobotMap.frontRight.set(ControlMode.PercentOutput, outsideSpeed);
    	} else {
    		RobotMap.frontLeft.set(ControlMode.PercentOutput, -1 * outsideSpeed);
    		RobotMap.frontRight.set(ControlMode.PercentOutput, insideSpeed);
    	} */
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.driveArcIsFinished(distance, direction);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}