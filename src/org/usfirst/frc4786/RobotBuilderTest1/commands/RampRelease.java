package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RampRelease extends Command {

    public RampRelease() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.lifty);
    	requires(Robot.cubeMech);
    	this.setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//if (Robot.pressureSensor.getPressure()>40){
    		Robot.lifty.release();
    		Robot.cubeMech.lower();
    	//}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true; // true makes it run once
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
