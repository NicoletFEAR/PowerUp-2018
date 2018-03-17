package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubeFlywheelVariable extends Command {

    public CubeFlywheelVariable() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.cubeMech);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double forward = Robot.oi.getXbox2().getTriggerAxis(Hand.kLeft);
    	double reverse = Robot.oi.getXbox2().getTriggerAxis(Hand.kRight);
    	double output = forward-reverse;
    	RobotMap.flyWheelLeft.set(ControlMode.PercentOutput, output);
    	RobotMap.flyWheelRight.set(ControlMode.PercentOutput, -output);
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
