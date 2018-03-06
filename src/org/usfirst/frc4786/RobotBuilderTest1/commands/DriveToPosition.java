package org.usfirst.frc4786.RobotBuilderTest1.commands;


import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToPosition extends Command {

	private double targetPosition;
	private double speed;
	
    public DriveToPosition(double distance, double inputSpeed) {
    	//We require the driveTrain to drive, obviously!!!!
    	requires(Robot.driveTrain);
    	
    	//So we can use this variable in the execute() function
    	targetPosition = distance * RobotMap.fudgeFactor;
    	speed = inputSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		RobotMap.navX.reset();
    	//Let's drive!
    	Robot.driveTrain.driveToPositionInit(targetPosition, speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {	
    	Robot.driveTrain.driveToPositionExecute(targetPosition, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double rotations = Robot.driveTrain.convertToRotations(targetPosition);
        return Robot.driveTrain.driveToPositionIsFinished(rotations);
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.navX.reset();
    	RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
    	RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}