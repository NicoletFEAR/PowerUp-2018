package org.usfirst.frc.team4786.robot.commands;

import org.usfirst.frc.team4786.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftBig extends Command {

    public ShiftBig() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	  // Use requires() here to declare subsystem dependencies
        requires(Robot.shifterBig);
        this.setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shifterBig.shift();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
