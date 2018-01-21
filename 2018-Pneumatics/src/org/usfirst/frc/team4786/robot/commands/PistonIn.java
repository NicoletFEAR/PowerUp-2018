package org.usfirst.frc.team4786.robot.commands;
import org.usfirst.frc.team4786.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class PistonIn extends InstantCommand {
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
    	Robot.armsolenoid.retractarmdoublesolenoid();
    	Robot.eyesolenoid.retracteyedoublesolenoid();
    	Robot.headsolenoid.retractheaddoublesolenoid();
    	Robot.legsolenoid.retractlegdoublesolenoid();
    }
}
