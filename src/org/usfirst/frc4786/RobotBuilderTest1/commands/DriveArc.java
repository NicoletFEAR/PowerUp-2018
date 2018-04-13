package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveArc extends Command {

	public String direction;
	public double distance;
	public double leftSpeed;
	public double rightSpeed;
	double[] initReturn = new double[4];
	public double targetInsideRatio;
	public double currentInsideRatio;
	public boolean isFinishedVar;
	
    public DriveArc(String turnDirection, double outsideArcDistance, double leftSpeedIn, double rightSpeedIn) {
    	requires(Robot.driveTrain);
    	direction = turnDirection;
    	distance = outsideArcDistance;
    	leftSpeed = leftSpeedIn;
    	rightSpeed = rightSpeedIn;
    	isFinishedVar = false;
    }
	
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.driveArcInit(direction, distance, leftSpeed, rightSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveArcExecute();
  	
/*
    	RobotMap.frontLeft.set(ControlMode.PercentOutput, -1 * leftSpeed);
		RobotMap.midLeft.set(ControlMode.PercentOutput, -1 * leftSpeed);
		RobotMap.backLeft.set(ControlMode.PercentOutput, -1 * leftSpeed);
		RobotMap.frontRight.set(ControlMode.PercentOutput, rightSpeed);
		RobotMap.midRight.set(ControlMode.PercentOutput, rightSpeed);
		RobotMap.backRight.set(ControlMode.PercentOutput, rightSpeed);
*/
        }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return  Robot.driveTrain.driveArcIsFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}