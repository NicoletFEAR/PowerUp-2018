package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class PathfinderTestCommand extends Command {
	private static EncoderFollower leftEnc;
	private static EncoderFollower rightEnc;
    public PathfinderTestCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0);
        Waypoint[] points = new Waypoint[] {
                new Waypoint(-4, -1, Pathfinder.d2r(-45)),
                new Waypoint(-2, -2, 0),
                new Waypoint(0, 0, 0)
        };
        System.out.println("Pathfinder T");
        Trajectory trajectory = Pathfinder.generate(points, config);

        // Wheelbase Width = 0.5m
        TankModifier modifier = new TankModifier(trajectory).modify(0.5);

        // Do something with the new Trajectories...
        Trajectory left = modifier.getLeftTrajectory();
        Trajectory right = modifier.getRightTrajectory();
        
        leftEnc = new EncoderFollower(left);
        rightEnc = new EncoderFollower(right);
        
        leftEnc.configureEncoder(RobotMap.frontLeft.getSelectedSensorPosition(0), 1000, .1524);
        rightEnc.configureEncoder(RobotMap.frontRight.getSelectedSensorPosition(0), 1000, .1524);
        leftEnc.configurePIDVA(1.0, 0.0, 0.0, 1 / 1.7, 0);
        rightEnc.configurePIDVA(1.0, 0.0, 0.0, 1 / 1.7, 0);
        Robot.ahrs.reset();
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double l = leftEnc.calculate(RobotMap.frontLeft.getSelectedSensorPosition(0));
    	double r = rightEnc.calculate(RobotMap.frontRight.getSelectedSensorPosition(0));

    	double gyro_heading = Robot.ahrs.getAngle();   // Assuming the gyro is giving a value in degrees
    	double desired_heading = Pathfinder.r2d(leftEnc.getHeading());  // Should also be in degrees

    	double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
    	double turn = 0.8 * (-1.0/80.0) * angleDifference;

    	RobotMap.frontLeft.set(ControlMode.PercentOutput, l + turn);
    	RobotMap.frontRight.set(ControlMode.PercentOutput, r + turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (leftEnc.isFinished() && rightEnc.isFinished()) {
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.frontLeft.stopMotor();
    	RobotMap.frontRight.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
