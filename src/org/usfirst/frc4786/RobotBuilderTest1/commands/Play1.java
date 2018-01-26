package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Play1 extends Command {

    public Play1() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	 String gameData;
 		gameData = DriverStation.getInstance().getGameSpecificMessage();
 		if((gameData == "LRL" || gameData == "LRR"))
 		{
 			
 		} else if (gameData == "LLR" || gameData == "LLL") {
 			
 		} else if (gameData == "RRL" || gameData == "RRR") {
 			
 		} else if (gameData == "RLL" || gameData == "RLR"){
 			
 		} else {
 			Robot.driveTrain.driveForSeconds(5, .75, .75);
 		}
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
