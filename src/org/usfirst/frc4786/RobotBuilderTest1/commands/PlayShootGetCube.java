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
    	requires(Robot.cubeMech);
    	
     	switch (Robot.myPosition)
    	{
    		case A:
    			if (Robot.teamSwitchSide.equals("L")) {
		    		addSequential(new PlayOneCubeArc());
					
					addSequential(new TurnToAngle(90));               // turn 90 degrees clockwise to face drivers
					addSequential(new DriveToPosition(-64, .5));      // drive backwards 64 inches
					addSequential(new TurnToAngle(-37));              // turn anti-clockwise toward first home row cube
					addSequential(new CubeMechDrop());                // Lower cube mech
		    		addSequential(new StartCubeFlywheelIn(1));        // start running the intake to get cube!
					addSequential(new DriveToPosition(20, .4));       // drive forward slowly with mech running inward
		    		addSequential(new StopCubeFlywheel());            // stop running the intake wheels
					addSequential(new DriveToPosition(-10, .4));      // back up 10 inches
					addSequential(new CubeMechRaise());               // raise the cube mech
					addSequential(new DriveToPosition(10, .4));       // drive forward 10 inches
					addSequential(new DriveArc("right", 19, .4, .1)); // drive in a right arc to end flush with switch

					addSequential(new CubeLaunch());                  // cube launch 2
					
					addSequential(new WaitCommand(.2));
					
					addSequential(new DriveToPosition(-20, .4));      // back up from switch 20 inches
					addSequential(new CubeMechDrop());                // Lower cube mech
					addSequential(new TurnToAngle(-37));              // turn anti-clockwise toward second home row cube 37 degrees
		    		addSequential(new StartCubeFlywheelIn(1));        // start running the intake to get cube!
					addSequential(new DriveToPosition(23, .4));       // drive forward slowly with mech running inward
		    		addSequential(new StopCubeFlywheel());            // stop running the intake wheels
					addSequential(new DriveToPosition(-23, .4));      // back up 23 inches from switch
					addSequential(new TurnToAngle(37));               // turn clockwise toward switch 37 degrees 
					addSequential(new CubeMechRaise());               // raise the cube mech
					addSequential(new DriveToPosition(23, .4));       // drive forward to touch switch
					addSequential(new CubeLaunch());                  // cube launch 3
     			}
    			else
    			{
    				addSequential(new PlayBaseline());
    			}
    			break;
	    	case C: 
	    		if (Robot.teamSwitchSide.equals("L")) {
	    			/*
		    		//addSequential(new PlayOneCubeArc()); // ends at switch
    				//addSequential(new DriveArc("left", 32.25, 42, .4786));
    				//addSequential(new DriveArc("right", 32.25, 42, .4786));
    				addSequential(new DriveArc("left", 73.7676685323, .397901804448, .6));
    				//lets try slowing down at the end in order to stop straighter and better
    				addSequential(new DriveArc("right", 46, .6, .397901804448));
    				addSequential(new DriveArc("right", 14.7676685323, .3, 0.19895090224));
    				addSequential(new DriveArc("right", 13, .15, (0.19895090224)/2));
		//    		addSequencial(new CubeLaunch()); */
		    		
	    			addSequential(new PlayOneCubeAngle());
	    			
/*		    		RobotMap.frontLeft.set(ControlMode.PercentOutput, 0);
		    		RobotMap.frontRight.set(ControlMode.PercentOutput, 0);
		    		RobotMap.backLeft.set(ControlMode.PercentOutput, 0);
		    		RobotMap.backRight.set(ControlMode.PercentOutput, 0);
		    		RobotMap.midLeft.set(ControlMode.PercentOutput, 0);
		    		RobotMap.midRight.set(ControlMode.PercentOutput, 0);
*/		    		
		    		addSequential(new DriveToPosition(-77, 0.3));     // back up from switch to get cube #2
		    		addSequential(new TurnToAngle(45));
					addSequential(new CubeMechDrop());                // Lower cube mech
		    		addSequential(new DriveToPosition(35, 0.4));
		    		addSequential(new StartCubeFlywheelIn(1));        // start running intake wheels in
		    		addSequential(new DriveToPosition(9.9, .3));
		    		addSequential(new StopCubeFlywheel());            // stop running the intake wheels
		    		addSequential(new WaitCommand(0.2));
		
		    		addSequential(new StartCubeFlywheelIn(1));        // start running the intake to hold in that cube!
		    		addSequential(new DriveToPosition(-35, .3));
		    		addSequential(new StopCubeFlywheel());
		    		addSequential(new TurnToAngle(-45));
					addSequential(new CubeMechRaise());               // raise the cube mech
		    		addSequential(new DriveToPosition(77, .3));

		    		addSequential(new CubeLaunch());                 // launch cube #2
		    		
		
		    		addSequential(new DriveToPosition(-52, .3));     // back up to get third cube!
		    		addSequential(new TurnToAngle(40));
					addSequential(new CubeMechDrop());               // Lower cube mech
		    		addSequential(new DriveToPosition(26, .3));
		    		addSequential(new StartCubeFlywheelIn(1));       // start running intake wheels in
		    		addSequential(new DriveToPosition(17.71, .3));
		    		addSequential(new StartCubeFlywheelIn(.3));      // stop the intake mech!!!
		    		addSequential(new WaitCommand(0.2));
		    		
		    	    addSequential(new StartCubeFlywheelIn(1));       // start running the intake to hold in that cube!
		    		addSequential(new DriveToPosition(-33, .3));     // back up from pile
		    		addSequential(new StopCubeFlywheel());
		    		addSequential(new TurnToAngle(-40));
					addSequential(new CubeMechRaise());              // raise the cube mech
		    		addSequential(new DriveToPosition(52, .3));

		    		addSequential(new CubeLaunch());                 // shoots cube #3
		    		
		    	} else if (Robot.teamSwitchSide.equals("R")) {
		    		/*
		    		//addSequential(new PlayOneCubeArc()); // ends at switch
	    			//	addSequential(new DriveArc("right", 70, 31.25, .4786));
	    			//	addSequential(new DriveArc("left", 70, 31.25, .4786));
	    			addSequential(new DriveArc("right", 70, .6, .28));
	    			//lets try slowing down at the end in order to stop straighter and better
	    			addSequential(new DriveArc("left", 46, .28, 0.6));
	    			addSequential(new DriveArc("left", 12, .14, 0.3));
	    			addSequential(new DriveArc("left", 12, .07, 0.15));
		//    		addSequencial(new CubeLaunch());
		 */
	    			
	    			addSequential(new PlayOneCubeAngle());
	    			
/*		    		RobotMap.frontLeft.set(ControlMode.PercentOutput, 0);
		    		RobotMap.frontRight.set(ControlMode.PercentOutput, 0);
		    		RobotMap.backLeft.set(ControlMode.PercentOutput, 0);
		    		RobotMap.backRight.set(ControlMode.PercentOutput, 0);
		    		RobotMap.midLeft.set(ControlMode.PercentOutput, 0);
		    		RobotMap.midRight.set(ControlMode.PercentOutput, 0);
*/		    		
		    		addSequential(new DriveToPosition(-77, 0.3));     // back up from switch to get cube #2
		    		addSequential(new TurnToAngle(-45));
					addSequential(new CubeMechDrop());                // Lower cube mech
		    		addSequential(new DriveToPosition(35, 0.4));
		    		addSequential(new StartCubeFlywheelIn(1));        // start running intake wheels in
		    		addSequential(new DriveToPosition(9.9, .3));
		    		addSequential(new StopCubeFlywheel());            // stop running the intake wheels
		    		addSequential(new WaitCommand(0.2));
		
		    		addSequential(new StartCubeFlywheelIn(1));        // start running the intake to hold in that cube!
		    		addSequential(new DriveToPosition(-35, .3));
		    		addSequential(new StopCubeFlywheel());
		    		addSequential(new TurnToAngle(45));
					addSequential(new CubeMechRaise());               // raise the cube mech
		    		addSequential(new DriveToPosition(77, .3));
		    		addSequential(new CubeLaunch());                  // launch cube #2
		    		
		
		    		addSequential(new DriveToPosition(-52, .3));      // back up to get third cube!
		    		addSequential(new TurnToAngle(-40));
					addSequential(new CubeMechDrop());                // Lower cube mech
		    		addSequential(new DriveToPosition(26, .3));
		    		addSequential(new StartCubeFlywheelIn(1));        // start running intake wheels in
		    		addSequential(new DriveToPosition(17.71, .3));
		    		addSequential(new StartCubeFlywheelIn(.3));       // stop the intake mech!!!
		    		addSequential(new WaitCommand(0.2));
		    		
		    	    addSequential(new StartCubeFlywheelIn(1));        // start running the intake to hold in that cube!
		    		addSequential(new DriveToPosition(-33, .3));      // back up from pile
		    		addSequential(new StopCubeFlywheel());
		    		addSequential(new TurnToAngle(40));
					addSequential(new CubeMechRaise());               // raise the cube mech
		    		addSequential(new DriveToPosition(52, .3));
		    		addSequential(new CubeLaunch());                  // shoots cube #3
	    			
		    	} 
		    	break;
	    	case E:
    			if (Robot.teamSwitchSide.equals("R")) {
		    		addSequential(new PlayOneCubeArc());
					
					addSequential(new TurnToAngle(-90));              // turn 90 degrees anti-clockwise to face drivers
					addSequential(new DriveToPosition(-64, .5));      // drive backwards 64 inches
					addSequential(new TurnToAngle(37));               // turn clockwise toward first home row cube
					addSequential(new CubeMechDrop());                // Lower cube mech
		    		addSequential(new StartCubeFlywheelIn(1));        // start running the intake to get cube!
					addSequential(new DriveToPosition(20, .4));       // drive forward slowly with mech running inward
		    		addSequential(new StopCubeFlywheel());            // stop running the intake wheels
					addSequential(new DriveToPosition(-10, .4));      // back up 10 inches
					addSequential(new CubeMechRaise());               // raise the cube mech
					addSequential(new DriveToPosition(10, .4));       // drive forward 10 inches
					addSequential(new DriveArc("left", 19, .1, .4));  // drive in a right arc to end flush with switch

					addSequential(new CubeLaunch());                  // cube launch 2
					
					addSequential(new WaitCommand(.2));
					
					addSequential(new DriveToPosition(-20, .4));      // back up from switch 20 inches
					addSequential(new CubeMechDrop());                // Lower cube mech
					addSequential(new TurnToAngle(37));               // turn clockwise toward second home row cube 37 degrees
		    		addSequential(new StartCubeFlywheelIn(1));        // start running the intake to get cube!
					addSequential(new DriveToPosition(23, .4));       // drive forward slowly with mech running inward
		    		addSequential(new StopCubeFlywheel());            // stop running the intake wheels
					addSequential(new DriveToPosition(-23, .4));      // back up 23 inches from switch
					addSequential(new TurnToAngle(-37));              // turn anti-clockwise toward switch 37 degrees 
					addSequential(new CubeMechRaise());               // raise the cube mech
					addSequential(new DriveToPosition(23, .4));       // drive forward to touch switch
					addSequential(new CubeLaunch());                  // cube launch 3
    			}
    			else
    			{
    				addSequential(new PlayBaseline());
    			}
    			break;
	    	}
    	}
    }
