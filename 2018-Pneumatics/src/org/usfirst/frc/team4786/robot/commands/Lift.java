package org.usfirst.frc.team4786.robot.commands;

import org.usfirst.frc.team4786.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Lift extends InstantCommand {

    public Lift() {
        super("Lift");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (Robot.gamemech);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.gamemech.lift();
    }

}
