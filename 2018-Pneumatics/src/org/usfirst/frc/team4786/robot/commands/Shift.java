package org.usfirst.frc.team4786.robot.commands;

import org.usfirst.frc.team4786.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Shift extends InstantCommand {

    public Shift() {
        super("Shift");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.shifter);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.shifter.shift();
    }

}
