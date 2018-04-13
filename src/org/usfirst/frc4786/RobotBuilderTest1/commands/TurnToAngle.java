 package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.command.Command;


public class TurnToAngle extends Command {

	private double targetAngle;
	
    public TurnToAngle(double angle) {
        requires(Robot.driveTrain);
//      requires(Robot.shifter);
        targetAngle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.shifter.shiftdown();
    	if (RobotMap.godSwitch.get())
    	{
    		 RobotMap.TurnP = 0.06;
    	} else {
    		 RobotMap.TurnP = 0.05;
    	}
    	
    	RobotMap.navX.reset();
    	Robot.driveTrain.turnToAngleInit(targetAngle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.turnToAngleExecute();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.turnToAngleIsFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.navX.reset();
    	RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
    	RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
