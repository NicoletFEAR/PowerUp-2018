package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;
import org.usfirst.frc4786.RobotBuilderTest1.commands.CubeMech;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Cube extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	 SpeedControllerGroup flyLeftSide = new SpeedControllerGroup(RobotMap.frontLeft, RobotMap.backLeft);
	 SpeedControllerGroup flyRightSide = new SpeedControllerGroup(RobotMap.frontRight, RobotMap.backRight);
	 public DifferentialDrive flyWheelDrive = new DifferentialDrive(flyLeftSide, flyRightSide);    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CubeMech());

    }
    
    public void takeBumperInputs(XboxController xbox) {
        flyWheelDrive.setSafetyEnabled(true);
        flyWheelDrive.setExpiration(1);
        flyWheelDrive.setMaxOutput(1.0);
    	if (xbox.getBumper(Hand.kLeft)== true)
    		flyWheelDrive.tankDrive(1, -1);
    	else if (xbox.getBumper(Hand.kRight) == true)
    		flyWheelDrive.tankDrive(-1, 1);
    }
}

