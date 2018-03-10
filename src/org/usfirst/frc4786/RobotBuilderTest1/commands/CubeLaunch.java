package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CubeLaunch extends CommandGroup {
	public CubeLaunch() { // sequence of commands that launches a cube
    	RobotMap.cubeLaunch = true;
		addParallel(new CubeFlywheelForward());
    	addSequential(new WaitCommand(1));
    	addSequential(new CubePistonExtend());
    	addSequential(new WaitCommand(1));
    	addSequential(new CubeFlywheelStop());
    	addSequential(new CubePistonRetract());
    	RobotMap.cubeLaunch = false;
    }
}
