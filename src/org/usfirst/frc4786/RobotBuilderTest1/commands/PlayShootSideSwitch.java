package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlayShootSideSwitch extends CommandGroup {

    public PlayShootSideSwitch() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	requires(Robot.driveTrain);
    	requires(Robot.cubeMech);
    	
    	if (Robot.teamSwitchSide.equals("L"))
    	{
    		switch (Robot.myPosition)
    		{
    			case A:
    				addSequential(new DriveToPosition(4));
//    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(5));
//    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(6));
    				addSequential(new CubeLaunch());
    			case B:
    				addSequential(new DriveToPosition(4));
//    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(2));
//    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(6));
    				addSequential(new CubeLaunch());
    			case C:
    				addSequential(new DriveToPosition(4));
//    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(10));
//    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(6));
    				addSequential(new CubeLaunch());
    			case D:
    				addSequential(new DriveToPosition(4));
//    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(13));
//    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(6));
    				addSequential(new CubeLaunch());	
    			case E:
    				addSequential(new DriveToPosition(4));
//    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(16));
//    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(6));
    				addSequential(new CubeLaunch());
    		}
    	} else {
    		switch (Robot.myPosition)
    		{
    			case A:
    				addSequential(new DriveToPosition(4));
//    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(20));
//    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(6));
    				addSequential(new CubeLaunch());
    			case B:
    				addSequential(new DriveToPosition(4));
//    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(16));
//    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(6));
    				addSequential(new CubeLaunch());
    			case C:
    				addSequential(new DriveToPosition(4));
//    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(7));
//    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(6));
    				addSequential(new CubeLaunch());
    			case D:
    				addSequential(new DriveToPosition(10));
    				addSequential(new CubeLaunch());
    			case E:
    				addSequential(new DriveToPosition(4));
//    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(16));
//    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(6));
    				addSequential(new CubeLaunch());
    		}
    		
    	}
    	
    }
}
