package org.usfirst.frc.team4786.robot.commands;
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
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	ArmSolenoid.arm.set(DoubleSolenoid.Value.kForward);
    	EyeSolenoid.eye.set(DoubleSolenoid.Value.kForward);
    	HeadSolenoid.head.set(DoubleSolenoid.Value.kForward);
    	LegSolenoid.leg.set(DoubleSolenoid.Value.kForward);
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
