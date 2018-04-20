package org.usfirst.frc4786.RobotBuilderTest1.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GrabNShoot extends CommandGroup {

    public GrabNShoot(String direction, double driveSpeed) {
    	if (direction.equalsIgnoreCase("left"))
    	{addSequential(new TurnToAngle(-40));}
    	else
    	{addSequential(new TurnToAngle(40));}
    	
    	addSequential(new ReachForCube());
    	//addSequential(new CubeMechLift());
    	addSequential(new DriveToPosition(40, driveSpeed));
    	//addSequential(new CubeLaunch());
    	addSequential(new DriveToPosition(-20, driveSpeed));
    	//addSequential(new CubeMechLift());
    }
}
