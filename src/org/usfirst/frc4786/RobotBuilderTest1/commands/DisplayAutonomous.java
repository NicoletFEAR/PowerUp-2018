package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DisplayAutonomous extends Command {

    public DisplayAutonomous() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.arduinoLCDInterface);
        requires(Robot.autoChooser);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arduinoLCDInterface.connectToArduino();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.autoChooser.autonomousMode();
    	SmartDashboard.putString("Selected Play:", Robot.autoChooser.getPlayString());
    	System.out.println(Robot.autoChooser.getPlayString());
    	SmartDashboard.putString("Selected Position:", Robot.autoChooser.getPositionString());
    	System.out.print(Robot.autoChooser.getPositionString());
    	Robot.arduinoLCDInterface.sendPlayToArduino();
    	Robot.arduinoLCDInterface.sendPosToArduino();
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
    	end();
    }
}
