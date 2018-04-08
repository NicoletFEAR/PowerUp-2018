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
	public double outsideDistance;
	public double outsideSpeed;
	public double insideSpeed;
	double[] initReturn = new double[4];
	
//    public DriveArc(String turnDirection, double sideWidth, double driveLength, double driveSpeed) {
//        // Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    	requires(Robot.driveTrain);
//    	direction = turnDirection;
//    	width = sideWidth;
//    	length = driveLength;
//    	speed = driveSpeed;
//    }

	public DriveArc(String arcDirection, double arcOutsideDistance, double arcOutsideSpeed, double arcInsideSpeed){
		 direction = arcDirection;
		 outsideDistance = arcOutsideDistance;
		 outsideSpeed = arcOutsideSpeed;
		 insideSpeed = arcInsideSpeed;
	}
	
    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
/*    	initReturn = Robot.driveTrain.driveArcInit(direction, width, length, speed, RobotMap.wheelDistance);
    	if (direction.equals("left")){
        	initReturn[0] = outsideSpeed;
        	initReturn[1] = insideSpeed;
    		
    	} else {
    		initReturn[0] = insideSpeed;
        	initReturn[1] = outsideSpeed;
    	}
    	initReturn[2] = 58; */
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.midLeft.follow(RobotMap.frontLeft);
		RobotMap.backLeft.follow(RobotMap.frontLeft);
		RobotMap.midRight.follow(RobotMap.frontRight);
		RobotMap.backRight.follow(RobotMap.frontRight);
    	if (direction.equals("left")) {
    		RobotMap.frontLeft.set(ControlMode.PercentOutput, -1 * insideSpeed);
    		RobotMap.frontRight.set(ControlMode.PercentOutput, outsideSpeed);
    	} else {
    		RobotMap.frontLeft.set(ControlMode.PercentOutput, -1 * outsideSpeed);
    		RobotMap.frontRight.set(ControlMode.PercentOutput, insideSpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.driveArcIsFinished(outsideDistance, direction);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}