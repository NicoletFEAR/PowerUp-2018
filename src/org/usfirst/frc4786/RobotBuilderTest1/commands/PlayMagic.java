package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PlayMagic extends CommandGroup {

    public PlayMagic() {
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
//    	requires(Robot.cubeMech);
    	
    	if (Robot.teamSwitchSide.equals("L"))
    	{
    		switch (Robot.myPosition)
    		{
    			case A:
    				addSequential(new PlayOneCubeArc());
    				break;
    			case B:
    				addSequential(new PlayOneCubeAngle());
    				break;
    			case C:
    				addSequential(new DriveToPosition(36, .85));
    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(33, .85));
    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(36, .85));
    				addSequential(new CubeMechDrop());
    				addSequential(new CubeLaunch());
    				addSequential(new DriveToPosition(-110, .85));
    				break;
    			case D:
    				addSequential(new DriveToPosition(36, .85));
    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(110, .85));
    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(74, .85));
    				addSequential(new CubeLaunch());
    				break;
    			case E:
    				addSequential(new DriveToPosition(230, .85));
    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(230, .85));
    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(54, .85));
    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(36, .85));
    				addSequential(new CubeLaunch());
    				break;
    		}
    	} else {
    		switch (Robot.myPosition)
    		{
    			case A:
    				addSequential(new DriveToPosition(230, .85));
    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(230, .85));
    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(54, .85));
    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(36, .85));
    				addSequential(new CubeLaunch());
    				break;
    			case B:
    				addSequential(new DriveToPosition(36, .85));
    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(110, .85));
    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(74, .85));
    				addSequential(new CubeLaunch());
    				break;
    			case C:
    				addSequential(new DriveToPosition(36, .85));
    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(33, .85));
    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(36, .85));
    				addSequential(new CubeMechDrop());
    				addSequential(new CubeLaunch());
    				addSequential(new DriveToPosition(-110, .85));
    				break;
    			case D:
    				addSequential(new PlayOneCubeAngle());
    				break;
    			case E:
    				addSequential(new PlayOneCubeArc());
    				break;
    		}
    	}
    }
}