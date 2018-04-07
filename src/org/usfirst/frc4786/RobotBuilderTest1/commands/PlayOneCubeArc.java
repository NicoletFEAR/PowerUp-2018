package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PlayOneCubeArc extends CommandGroup {

    public PlayOneCubeArc() {
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
    	
    	if (Robot.teamSwitchSide.equals("L"))
    	{
    		switch (Robot.myPosition)
    		{
    			case A:
    				addSequential(new DriveToPosition(150, .85));
    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(36, .5));
    				addSequential(new CubeLaunch());
    				break;
    			case B:
    				addSequential(new DriveToPosition(110, .85));
    				addSequential(new CubeLaunch());
    				break;
    			case C:
    				addSequential(new DriveArc("left", 32.25, 54, 1));
    				addSequential(new DriveArc("right", 32.25, 54, 1));
    				break;
    			case D:
        			addSequential(new PlayBaseline());
        			break;
        		case E:
        			addSequential(new PlayBaseline());
        			break;
    		}
    	} else {
    		switch (Robot.myPosition)
        	{
        		case A:
        			addSequential(new PlayBaseline());
        			break;
        		case B:
    				addSequential(new PlayBaseline());
    				break;
    			case C:
    				addSequential(new DriveArc("right", 26.25, 54, 1));
    				addSequential(new DriveArc("left", 26.25, 54, 1));
    				break;
    			case D:
    				addSequential(new DriveToPosition(110, .85));
    				addSequential(new CubeLaunch());
        			break;
    			case E:
    				addSequential(new DriveToPosition(150, .85));
    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(36, .5));
    				addSequential(new CubeLaunch());
    				break;
        	}
    	}
    	
    	/*switch (Robot.myPosition)
    	{
    		case A:
    			addSequential(new DriveToPosition(260, .85));
    			break;
    		case B:
    			addSequential(new DriveToPosition(36, .85));
    			addSequential(new TurnToAngle(-45));
    			addSequential(new DriveToPosition(80, .7));
    			addSequential(new TurnToAngle(45));
    			addSequential(new DriveToPosition(180, .85));
    			break;
    		case C:
    			addSequential(new DriveToPosition(36, .85));
    			addSequential(new TurnToAngle(45));
    			addSequential(new DriveToPosition(100, .7));
    			addSequential(new TurnToAngle(-45));
    			addSequential(new DriveToPosition(180, .85));
    			break;
    		case D:
    			addSequential(new DriveToPosition(36, .85));
    			addSequential(new TurnToAngle(45));
    			addSequential(new DriveToPosition(80, .7));
    			addSequential(new TurnToAngle(-45));
    			addSequential(new DriveToPosition(180, .85));
    			break;
    		case E:
    			addSequential(new DriveToPosition(260, .85));
    			break;
    	}*/
    }
}
