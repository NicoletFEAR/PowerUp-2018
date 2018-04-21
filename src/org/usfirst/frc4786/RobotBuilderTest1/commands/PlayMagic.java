package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

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
    				addSequential(new PlayShootGetCube());
    				break;
    			case B:
    				addSequential(new PlayOneCubeAngle());
    				break;
    			case C:
    				addSequential(new PlayShootGetCube());
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
    				addSequential(new DriveToPosition(216, .85));
    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(168, .85));
    				addSequential(new TurnToAngle(-90));
    				addSequential(new DriveToPosition(8, .4));
    				addSequential(new CubeLaunch());
    				
    				addSequential (new DriveToPosition(-12, .4));
    				addSequential (new TurnToAngle(30));
    				addSequential(new CubeMechDrop());
    				addSequential(new StartCubeFlywheelIn(1));
    				addSequential(new DriveToPosition(20, .4));
    				addSequential(new WaitCommand(.2));
    				addSequential(new DriveToPosition(-20, .4));
    				addSequential(new StopCubeFlywheel());
    				addSequential(new TurnToAngle(-30));
    				addSequential(new CubeMechRaise());
    				addSequential(new DriveToPosition(12, .4));
    				addSequential(new CubeLaunch());
    				
    				addSequential (new DriveToPosition(-12, .4));
    				addSequential (new TurnToAngle(-30));
    				addSequential(new CubeMechDrop());
    				addSequential(new StartCubeFlywheelIn(1));
    				addSequential(new DriveToPosition(20, .4));
    				addSequential(new WaitCommand(.2));
    				addSequential(new DriveToPosition(-20, .4));
    				addSequential(new StopCubeFlywheel());
    				addSequential(new TurnToAngle(30));
    				addSequential(new CubeMechRaise());
    				addSequential(new DriveToPosition(25, .4));
    				addSequential(new CubeLaunch());
    				break;
    		}
    	} else {
    		switch (Robot.myPosition)
    		{
    			case A:
    				addSequential(new DriveToPosition(216, .85));
    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(168, .85));
    				addSequential(new TurnToAngle(90));
    				addSequential(new DriveToPosition(8, .4));
    				addSequential(new CubeLaunch());
    				
    				addSequential (new DriveToPosition(-12, .4));
    				addSequential (new TurnToAngle(-30));
    				addSequential(new CubeMechDrop());
    				addSequential(new StartCubeFlywheelIn(1));
    				addSequential(new DriveToPosition(20, .4));
    				addSequential(new WaitCommand(.2));
    				addSequential(new DriveToPosition(-20, .4));
    				addSequential(new StopCubeFlywheel());
    				addSequential(new TurnToAngle(30));
    				addSequential(new CubeMechRaise());
    				addSequential(new DriveToPosition(12, .4));
    				addSequential(new CubeLaunch());
    				
    				addSequential (new DriveToPosition(-12, .4));
    				addSequential (new TurnToAngle(30));
    				addSequential(new CubeMechDrop());
    				addSequential(new StartCubeFlywheelIn(1));
    				addSequential(new DriveToPosition(20, .4));
    				addSequential(new WaitCommand(.2));
    				addSequential(new DriveToPosition(-20, .4));
    				addSequential(new StopCubeFlywheel());
    				addSequential(new TurnToAngle(-30));
    				addSequential(new CubeMechRaise());
    				addSequential(new DriveToPosition(25, .4));
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
    				addSequential(new PlayShootGetCube());
    				break;
    			case D:
    				addSequential(new PlayOneCubeAngle());
    				break;
    			case E:
    				addSequential(new PlayShootGetCube());
    				break;
    		}
    	}
    }
}