package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CubeLaunch extends CommandGroup {
	public CubeLaunch() { // sequence of commands that launches a cube
		addSequential(new StartCubeFlywheelOut(0.75));
    	addSequential(new WaitCommand(0.5));
    	addSequential(new StopCubeFlywheel());
    }
}
