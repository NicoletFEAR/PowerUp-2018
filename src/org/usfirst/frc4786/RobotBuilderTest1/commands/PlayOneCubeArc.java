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
//    				addSequential(new CubeLaunch());
    				break;
    			case B:
    				addSequential(new DriveToPosition(110, .85));
//    				addSequential(new CubeLaunch());
    				break;
    			case C:
    				//          DriveArc(direction, outsideArcDistance, leftSpeed, rightSpeed)
    				//addSequential(new DriveArc("left", 32.25, 42, .4786));
    				//addSequential(new DriveArc("right", 32.25, 42, .4786));
    				addSequential(new DriveArc("left", 77.32, .354, .6));
    				//lets try slowing down at the end in order to stop straighter and better
    				addSequential(new DriveArc("right", 46, .6, .354));
    				addSequential(new DriveArc("right", 14.768, .3, 0.177));
    				addSequential(new DriveArc("right", 13, .15, (0.177)/2)); // slows down near the end of arc
//    				addSequential(new CubeLaunch());
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
    				addSequential(new DriveArc("right", 70, .6, .372));
    				//lets try slowing down at the end in order to stop straighter and better
    				addSequential(new DriveArc("left", 46, .372, 0.6));
    				addSequential(new DriveArc("left", 12, .186, 0.3));
    				addSequential(new DriveArc("left", 12, .093, 0.15));
    				addSequential(new CubeLaunch());
    				break;
    			case D:
    				addSequential(new DriveToPosition(110, .85));
//    				addSequential(new CubeLaunch()); 
        			break;
    	 
    			case E:
    				addSequential(new DriveToPosition(150, .85));
    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(36, .5));
//    				addSequential(new CubeLaunch());
    				break;
        	}
    	}    	
    }
}