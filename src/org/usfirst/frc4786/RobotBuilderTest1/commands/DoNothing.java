package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DoNothing extends Command {

    public DoNothing() {
        // We just need...a hammock to do nothing
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// I said DO NOTHING!
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Make sure we do nothing
    	Robot.driveTrain.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//You can never be too lazy ;)
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Just one more nap...
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
