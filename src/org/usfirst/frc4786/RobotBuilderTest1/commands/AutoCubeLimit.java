package org.usfirst.frc4786.RobotBuilderTest1.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoCubeLimit extends Command {

    public AutoCubeLimit() {
        // Use requires() here to declare subsystem dependencies
//    	requires(Robot.cubeMech);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.cubeMech.cubeFlywheelBackward();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
