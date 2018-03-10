package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class NoDrivey extends Command {
	double error = 0.25;

	public NoDrivey() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double leftEncPos = Robot.driveTrain.getLeftEncoderPosition();
		double rightEncPos = Robot.driveTrain.getRightEncoderPosition();

		double leftDist = (leftEncPos / 7160) * (Math.PI * (RobotMap.WHEEL_RADIUS * 2));
		double rightDist = (rightEncPos / 7160) * (Math.PI * (RobotMap.WHEEL_RADIUS * 2));

		double averDist = (leftDist + rightDist) / 2;

		if (averDist > error) {
			new DriveToPosition(-averDist, 1);
		} else if (averDist < -error) {
			new DriveToPosition(averDist, 1);
		} else {
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.driveToPositionEnd();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
