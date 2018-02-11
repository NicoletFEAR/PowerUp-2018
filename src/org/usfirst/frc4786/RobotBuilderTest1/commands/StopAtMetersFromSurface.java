package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopAtMetersFromSurface extends Command {

	double currentMilimeters = 0.0;
	double targetMilimeters = 0.0;
	double speed = 0.0;
	
    public StopAtMetersFromSurface(double metersFromSurface, double speedToDrive) {
        targetMilimeters = (metersFromSurface * 1000);
        speed = speedToDrive;
    	requires(Robot.proximitySensor);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentMilimeters = Robot.proximitySensor.getDistance();
    	RobotMap.robotDrive.tankDrive(speed, speed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return targetMilimeters >= currentMilimeters;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}