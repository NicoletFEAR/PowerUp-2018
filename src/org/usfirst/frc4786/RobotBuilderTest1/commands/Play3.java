package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Play3 extends Command {


	
    public Play3() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	 String gameData;
 		gameData = DriverStation.getInstance().getGameSpecificMessage();
 		if(gameData.substring(0, 1) == "LR" && Robot.myPosition == RobotMap.AutoPosition.A) {
 			
 		} else if(gameData.substring(0, 1) == "LR" && Robot.myPosition == RobotMap.AutoPosition.B) {
 			
 		} else if(gameData.substring(0, 1) == "LR" && Robot.myPosition == RobotMap.AutoPosition.C) {
 			
 		} else if(gameData.substring(0, 1) == "LR" && Robot.myPosition == RobotMap.AutoPosition.D) {
 			
 		} else if(gameData.substring(0, 1) == "LR" && Robot.myPosition == RobotMap.AutoPosition.E) {
 			
 		} else if(gameData.substring(0, 1) == "LL" && Robot.myPosition == RobotMap.AutoPosition.A) {
 			
 		} else if(gameData.substring(0, 1) == "LL" && Robot.myPosition == RobotMap.AutoPosition.B) {
 			
 		} else if(gameData.substring(0, 1) == "LL" && Robot.myPosition == RobotMap.AutoPosition.C) {
 			
 		} else if(gameData.substring(0, 1) == "LL" && Robot.myPosition == RobotMap.AutoPosition.D) {
 			
 		} else if(gameData.substring(0, 1) == "LL" && Robot.myPosition == RobotMap.AutoPosition.E) {
 			
 		} else if(gameData.substring(0, 1) == "RR" && Robot.myPosition == RobotMap.AutoPosition.A) {
 			
 		} else if(gameData.substring(0, 1) == "RR" && Robot.myPosition == RobotMap.AutoPosition.B) {
 			
 		} else if(gameData.substring(0, 1) == "RR" && Robot.myPosition == RobotMap.AutoPosition.C) {
 			
 		} else if(gameData.substring(0, 1) == "RR" && Robot.myPosition == RobotMap.AutoPosition.D) {
 			
 		} else if(gameData.substring(0, 1) == "RR" && Robot.myPosition == RobotMap.AutoPosition.E) {
 			
 		} else if(gameData.substring(0, 1) == "RL" && Robot.myPosition == RobotMap.AutoPosition.A) {
 			
 		} else if(gameData.substring(0, 1) == "RL" && Robot.myPosition == RobotMap.AutoPosition.B) {
 			
 		} else if(gameData.substring(0, 1) == "RL" && Robot.myPosition == RobotMap.AutoPosition.C) {
 			
 		} else if(gameData.substring(0, 1) == "RL" && Robot.myPosition == RobotMap.AutoPosition.D) {
 			
 		} else if(gameData.substring(0, 1) == "RL" && Robot.myPosition == RobotMap.AutoPosition.E) {
 			
 		} else {
 			
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
