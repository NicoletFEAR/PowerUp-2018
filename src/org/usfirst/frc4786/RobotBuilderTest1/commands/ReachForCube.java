package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReachForCube extends Command {

    public ReachForCube() {
    	requires(Robot.driveTrain);
    	//requires(Robot.cubeMech);
    }

    // Called just before this Command runs the first time
    protected void initialize() {		
    	RobotMap.frontLeft.set(ControlMode.PercentOutput, 0.25);
    	RobotMap.frontRight.set(ControlMode.PercentOutput, 0.25);
    	//RobotMap.cubeMech.cubeFlywheelBackward();
    	
    	double leftEncoderValue = RobotMap.frontLeft.getSelectedSensorPosition(0);
		double leftRotations = leftEncoderValue / 7610;
		
		RobotMap.extraInches = Robot.driveTrain.convertToInches(leftRotations);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (RobotMap.cubeCount >= 5)
        {return true;}
        else
        {return false;}
    }

    // Called once after isFinished returns true
    protected void end() {
       	RobotMap.frontLeft.set(ControlMode.PercentOutput, 0.0);
    	RobotMap.frontRight.set(ControlMode.PercentOutput, 0.0);
    	//RobotMap.cubeMech.CubeFlyWheelStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
