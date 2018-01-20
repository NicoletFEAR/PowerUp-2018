package org.usfirst.frc.team4786.robot.commands;
import org.usfirst.frc.team4786.robot.Robot;
import org.usfirst.frc.team4786.robot.subsystems.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PistonIn extends Command {
    public PistonIn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.armsolenoid);
    	requires(Robot.eyesolenoid);
    	requires(Robot.headsolenoid);
    	requires(Robot.legsolenoid);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	ArmSolenoid.arm.set(DoubleSolenoid.Value.kReverse);
    	EyeSolenoid.eye.set(DoubleSolenoid.Value.kReverse);
    	HeadSolenoid.head.set(DoubleSolenoid.Value.kReverse);
    	LegSolenoid.leg.set(DoubleSolenoid.Value.kReverse);
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
