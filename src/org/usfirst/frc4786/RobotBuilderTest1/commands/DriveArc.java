package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveArc extends Command {

	public String direction;
	public double width;
	public double length;
	public double speed;
	double[] initReturn = new double[4];
	
    public DriveArc(String turnDirection, double sideWidth, double driveLength, double driveSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	direction = turnDirection;
    	width = sideWidth;
    	length = driveLength;
    	speed = driveSpeed * RobotMap.arcSpeedScaling;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initReturn = Robot.driveTrain.driveArcInit(direction, width, length, speed, RobotMap.wheelDistance);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveArcExecute(initReturn[0], initReturn[1]);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.driveArcIsFinished(initReturn[2], direction);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
