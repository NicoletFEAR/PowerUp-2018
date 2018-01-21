package org.usfirst.frc.team4786.robot.commands;


import org.usfirst.frc.team4786.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class PistonOut extends InstantCommand {

    public PistonOut() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.armsolenoid);
        requires(Robot.eyesolenoid);
        requires(Robot.headsolenoid);
        requires(Robot.legsolenoid); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.armsolenoid.firearmdoublesolenoid();
    	Robot.eyesolenoid.fireeyedoublesolenoid();
    	Robot.headsolenoid.fireheaddoublesolenoid();
    	Robot.legsolenoid.firelegdoublesolenoid();
    }
}
