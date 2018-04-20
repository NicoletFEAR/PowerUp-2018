package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CubeMechDrop extends InstantCommand {

    public CubeMechDrop() {
        super();
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.cubeMech);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cubeMech.lower();
    }

}