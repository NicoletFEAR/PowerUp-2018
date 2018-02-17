package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CubeLaunch extends CommandGroup {

    public CubeLaunch() {
    	addSequential(new CubeFlywheelForward());
    	addSequential(new WaitCommand(1));
    	addSequential(new CubePistonExtend());
    	addSequential(new WaitCommand(1));
    	addSequential(new CubeFlywheelStop());
    	addSequential(new CubePistonRetract());
    }
}
