package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

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
    	switch (Robot.myPosition)
    	{
    		case A:
    	if (Robot.teamSwitchSide.equals("L")) {
    		addSequential(new PlayOneCubeAngle());
    		addSequential(new DriveToPosition(-36, 0.444));
    		addSequential(new TurnToAngle(-90));
    		addSequential(new DriveToPosition(48, 0.444));
    		addSequential(new TurnToAngle(90));
    		addSequential(new DriveToPosition(36, 0.444));
    		addSequential(new TurnToAngle(90));
//    		addSequential(new CubeVisionDrive());
//    		addParallel(new CubeFlywheelBackward());
    		addSequential(new DriveToPosition(24, 0.444));
//    		addSequential(new CubeFlywheelStop());
    	}
    		break;
    	case C: 
    		if (Robot.teamSwitchSide.equals("L")) {
    		//addSequential(new PlayOneCubeArc()); // ends at switch
			addSequential(new DriveArc("left", 73, .26, .6));
			//lets try slowing down at the end in order to stop straighter and better
			addSequential(new DriveArc("right", 63, .6, .26));
			addSequential(new DriveArc("right", 5, .3, .13));
			addSequential(new DriveArc("right", 5, .15, .065));
        	addSequential(new WaitCommand(0.25));
//    		addSequencial(new CubeLaunch());
    		
    		RobotMap.frontLeft.set(ControlMode.PercentOutput, 0);
    		RobotMap.frontRight.set(ControlMode.PercentOutput, 0);
    		RobotMap.backLeft.set(ControlMode.PercentOutput, 0);
    		RobotMap.backRight.set(ControlMode.PercentOutput, 0);
    		RobotMap.midLeft.set(ControlMode.PercentOutput, 0);
    		RobotMap.midRight.set(ControlMode.PercentOutput, 0);
    		
        	addSequential(new WaitCommand(10));

    		addSequential(new DriveToPosition(-95.5, 0.444)); // get and shoot cube!
    		addSequential(new TurnToAngle(45));
//    		addParallel(new Robot.cubeMech.lower());
    		addSequential(new DriveToPosition(70, 0.444));
//    		addParallel(new CubeFlywheelBackward()); // cube mech!!!
    		addSequential(new DriveToPosition(9.9, .3));
//    		addSequential(new CubeFlywheelStop()); // cube mech!!!
    		addSequential(new WaitCommand(1));

    		addSequential(new DriveToPosition(-79.9, 0.444));
//    		addParallel(new Robot.cubeMech.raise());
    		addSequential(new TurnToAngle(-45));
    		addSequential(new DriveToPosition(95.5, 0.444));
//    		addSequencial(new CubeLaunch());
    		

    		addSequential(new DriveToPosition(-76, 0.444)); // third cube!
    		addSequential(new TurnToAngle(45));
//    		addParallel(new Robot.cubeMech.lower());
    		addSequential(new DriveToPosition(60, 0.444));
//    		addParallel(new CubeFlywheelBackward()); // cube mech!!!
    		addSequential(new DriveToPosition(10.71, .3));
//    		addSequential(new CubeFlywheelStop()); // cube mech!!!
    		addSequential(new DriveToPosition(-70.71, 0.444));
    		addSequential(new WaitCommand(1));

//    		addParallel(new Robot.cubeMech.raise());
    		addSequential(new TurnToAngle(-45));
    		addSequential(new DriveToPosition(76, 0.444));
//    		addSequencial(new CubeLaunch());
    		
    	} else if (Robot.teamSwitchSide.equals("R")) {
    		//addSequential(new PlayOneCubeArc()); // ends at switch
			addSequential(new DriveArc("right", 70, .6, .28));
			//lets try slowing down at the end in order to stop straighter and better
			addSequential(new DriveArc("left", 60, .28, 0.6));
			addSequential(new DriveArc("left", 5, .14, 0.3));
			addSequential(new DriveArc("left", 5, .07, 0.15));
        	addSequential(new WaitCommand(0.25));
//    		addSequencial(new CubeLaunch());
 
    		RobotMap.frontLeft.set(ControlMode.PercentOutput, 0);
    		RobotMap.frontRight.set(ControlMode.PercentOutput, 0);
    		RobotMap.backLeft.set(ControlMode.PercentOutput, 0);
    		RobotMap.backRight.set(ControlMode.PercentOutput, 0);
    		RobotMap.midLeft.set(ControlMode.PercentOutput, 0);
    		RobotMap.midRight.set(ControlMode.PercentOutput, 0);
    		
    		
        	addSequential(new WaitCommand(10));
    		addSequential(new DriveToPosition(-95.5, 0.444)); // get and shoot cube!
    		addSequential(new TurnToAngle(-45));
//    		addParallel(new Robot.cubeMech.lower());
    		addSequential(new DriveToPosition(70, 0.444));
//    		addParallel(new CubeFlywheelBackward()); // cube mech!!!
    		addSequential(new DriveToPosition(9.9, .3));
//    		addSequential(new CubeFlywheelStop()); // cube mech!!!

    		addSequential(new WaitCommand(1));
    		addSequential(new DriveToPosition(-79.9, 0.444));
//    		addParallel(new Robot.cubeMech.raise());
    		addSequential(new TurnToAngle(45));
    		addSequential(new DriveToPosition(95.5, 0.444));
//    		addSequencial(new CubeLaunch());

    		addSequential(new WaitCommand(1));

    		addSequential(new DriveToPosition(-76, 0.444)); // third cube!
    		addSequential(new TurnToAngle(-45));
//    		addParallel(new Robot.cubeMech.lower());
    		addSequential(new DriveToPosition(60, 0.444));
//    		addParallel(new CubeFlywheelBackward()); // cube mech!!!
    		addSequential(new DriveToPosition(10.71, .3));
//    		addSequential(new CubeFlywheelStop()); // cube mech!!!
    		addSequential(new DriveToPosition(-70.71, 0.444));
//    		addParallel(new Robot.cubeMech.raise());
    		addSequential(new TurnToAngle(45));
    		addSequential(new DriveToPosition(76, 0.444));
//    		addSequencial(new CubeLaunch());
    		
    	} 
    	break;
    	case E:
    		addSequential(new DriveToPosition(-36, 0.444));
    		addSequential(new TurnToAngle(90));
    		addSequential(new DriveToPosition(48, 0.444));
    		addSequential(new TurnToAngle(-90));
    		addSequential(new DriveToPosition(36, 0.444));
    		addSequential(new TurnToAngle(-90));
//    		addSequential(new CubeVisionDrive());
//    		addParallel(new CubeFlywheelBackward());
    		addSequential(new DriveToPosition(24, .5));
//    		addSequential(new CubeFlywheelStop());
    		break;
    	}
    	}
    }
