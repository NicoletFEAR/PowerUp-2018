package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlayShootGetCube extends CommandGroup {

    public PlayShootGetCube() {
    	requires(Robot.driveTrain);
//    	requires(Robot.cubeMech);
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
    	addSequential(new PlayShootSideSwitch());
    	if (Robot.teamSwitchSide.equals("L") && Robot.myPosition.equals("A")) {
    		addSequential(new DriveToPosition(-36, .85));
    		addSequential(new TurnToAngle(-90));
    		addSequential(new DriveToPosition(48, .85));
    		addSequential(new TurnToAngle(90));
    		addSequential(new DriveToPosition(36, .85));
    		addSequential(new TurnToAngle(90));
//    		addSequential(new CubeVisionDrive());
//    		addParallel(new CubeFlywheelBackward());
    		addSequential(new DriveToPosition(24, .85));
//    		addSequential(new CubeFlywheelStop());
    	} else if (Robot.teamSwitchSide.equals("L") && Robot.myPosition.equals("C")) {
    		addSequential(new PlayOneCubeArc()); // ends at switch
    		
    		addSequential(new DriveToPosition(-95.5, .85)); // get and shoot cube!
    		addSequential(new TurnToAngle(45));
//    		addParallel(new Robot.cubeMech.lower());
    		addSequential(new DriveToPosition(70, .85));
//    		addParallel(new CubeFlywheelBackward()); // cube mech!!!
    		addSequential(new DriveToPosition(9.9, .3));
//    		addSequential(new CubeFlywheelStop()); // cube mech!!!
    		addSequential(new DriveToPosition(-79.9, .85));
//    		addParallel(new Robot.cubeMech.raise());
    		addSequential(new TurnToAngle(-45));
    		addSequential(new DriveToPosition(95.5, .85));
//    		addSequencial(new CubeLaunch());
    		

    		addSequential(new DriveToPosition(-76, .85)); // third cube!
    		addSequential(new TurnToAngle(45));
//    		addParallel(new Robot.cubeMech.lower());
    		addSequential(new DriveToPosition(60, .85));
//    		addParallel(new CubeFlywheelBackward()); // cube mech!!!
    		addSequential(new DriveToPosition(10.71, .3));
//    		addSequential(new CubeFlywheelStop()); // cube mech!!!
    		addSequential(new DriveToPosition(-70.71, .85));
//    		addParallel(new Robot.cubeMech.raise());
    		addSequential(new TurnToAngle(-45));
    		addSequential(new DriveToPosition(76, .85));
//    		addSequencial(new CubeLaunch());
    		
    	} else if (Robot.teamSwitchSide.equals("R") && Robot.myPosition.equals("C")) {
    		addSequential(new PlayOneCubeArc()); // ends at switch
    		
    		addSequential(new DriveToPosition(-95.5, .85)); // get and shoot cube!
    		addSequential(new TurnToAngle(-45));
//    		addParallel(new Robot.cubeMech.lower());
    		addSequential(new DriveToPosition(70, .85));
//    		addParallel(new CubeFlywheelBackward()); // cube mech!!!
    		addSequential(new DriveToPosition(9.9, .3));
//    		addSequential(new CubeFlywheelStop()); // cube mech!!!
    		addSequential(new DriveToPosition(-79.9, .85));
//    		addParallel(new Robot.cubeMech.raise());
    		addSequential(new TurnToAngle(45));
    		addSequential(new DriveToPosition(95.5, .85));
//    		addSequencial(new CubeLaunch());
    		

    		addSequential(new DriveToPosition(-76, .85)); // third cube!
    		addSequential(new TurnToAngle(-45));
//    		addParallel(new Robot.cubeMech.lower());
    		addSequential(new DriveToPosition(60, .85));
//    		addParallel(new CubeFlywheelBackward()); // cube mech!!!
    		addSequential(new DriveToPosition(10.71, .3));
//    		addSequential(new CubeFlywheelStop()); // cube mech!!!
    		addSequential(new DriveToPosition(-70.71, .85));
//    		addParallel(new Robot.cubeMech.raise());
    		addSequential(new TurnToAngle(45));
    		addSequential(new DriveToPosition(76, .85));
//    		addSequencial(new CubeLaunch());
    		
    	} else if (Robot.myPosition.equals("E")) {
    		addSequential(new DriveToPosition(-36, .85));
    		addSequential(new TurnToAngle(90));
    		addSequential(new DriveToPosition(48, .85));
    		addSequential(new TurnToAngle(-90));
    		addSequential(new DriveToPosition(36, .85));
    		addSequential(new TurnToAngle(-90));
//    		addSequential(new CubeVisionDrive());
//    		addParallel(new CubeFlywheelBackward());
    		addSequential(new DriveToPosition(24, .5));
//    		addSequential(new CubeFlywheelStop());
    	}
    }
}