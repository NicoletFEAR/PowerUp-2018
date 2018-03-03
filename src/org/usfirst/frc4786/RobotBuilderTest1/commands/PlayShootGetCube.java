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
    	addSequential(new PlayDriveToSideSwitch());
    	if (Robot.teamSwitchSide.equals("L")) {
    		addSequential(new DriveToPosition(-36, .85));
    		addSequential(new TurnToAngle(-90));
    	} else {
    		addSequential(new DriveToPosition(-36, .85));
    		addSequential(new TurnToAngle(90));
    	}
    	//ADD VISION
    }
}
