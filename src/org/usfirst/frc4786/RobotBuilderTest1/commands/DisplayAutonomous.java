package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DisplayAutonomous extends Command {
	
	String connection = "Bad";

    public DisplayAutonomous() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.arduinoLCDInterface);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arduinoLCDInterface.writeStringData("init");
    	System.out.println("Attempting to Connect to Arduino");
    	while (connection != "Ok")
    		connection = Robot.arduinoLCDInterface.readStringData();
    	System.out.println("Connected to Arduino! :D");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arduinoLCDInterface.writeStringData("1, " + Robot.autoChooser.getPlayString());
    	Robot.arduinoLCDInterface.writeStringData("2, " + Robot.autoChooser.getPositionString());
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
