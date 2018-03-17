package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class PlayBaseline extends CommandGroup {

	public PlayBaseline() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
		requires(Robot.driveTrain);

		switch (Robot.myPosition) {
		case A:
			addSequential(new DriveToPosition(100, 1));
			break;
		case B:
			if (Robot.teamSwitchSide.equals("L")) {
				addSequential(new DriveToPosition(100, .7));
		    	addSequential(new WaitCommand(1));
//		    	addParallel(new CubeFlywheelForward());
//		    	addSequential(new WaitCommand(1));
//		    	addSequential(new CubePistonExtend());
//		    	addSequential(new WaitCommand(.5));
//		    	addSequential(new CubeFlywheelStop());
//		    	addSequential(new CubePistonRetract());
				break;
			} else {
				addSequential(new DriveToPosition(100, 1));
				break;
			}
		case C:
			addSequential(new DriveToPosition(36, .7));
			addSequential(new TurnToAngle(45));
			addSequential(new DriveToPosition(100, .7));
			break;
		case D:
			if (Robot.teamSwitchSide.equals("R")) {
				addSequential(new DriveToPosition(100, .7));
		    	addSequential(new WaitCommand(1));
//		    	addParallel(new CubeFlywheelForward());
//		    	addSequential(new WaitCommand(1));
//		    	addSequential(new CubePistonExtend());
//		    	addSequential(new WaitCommand(.5));
//		    	addSequential(new CubeFlywheelStop());
//		    	addSequential(new CubePistonRetract());
				break;
			} else {
				addSequential(new DriveToPosition(100, 1));
				break;
			}
		case E:
			addSequential(new DriveToPosition(100, 1));
			break;
		}
	}
}
