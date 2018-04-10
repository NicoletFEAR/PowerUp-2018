package org.usfirst.frc4786.RobotBuilderTest1.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import edu.wpi.first.wpilibj.GenericHID;

public class OpenLoopDrive extends Command {

    public OpenLoopDrive() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	// for xbox controller     
    	double rightStickValue = Robot.oi.getXbox1().getY(GenericHID.Hand.kRight);   	
    	double leftStickValue = Robot.oi.getXbox1().getY(GenericHID.Hand.kLeft);
    	Robot.driveTrain.takeJoystickInputsValues(leftStickValue , rightStickValue);
     }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}
