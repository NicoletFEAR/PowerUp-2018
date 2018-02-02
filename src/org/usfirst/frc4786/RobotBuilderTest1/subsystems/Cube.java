package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;
import org.usfirst.frc4786.RobotBuilderTest1.commands.CubeMech;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
        flyWheelDrive.setSafetyEnabled(true);
        flyWheelDrive.setExpiration(1);
        flyWheelDrive.setMaxOutput(1.0);
    }
    
    public void cubeIntake() {
    	double cubePower = SmartDashboard.getNumber("Cube Mech Power (%)", 100);
    	cubePower = cubePower / 100;
    	flyWheelDrive.tankDrive(cubePower, -(cubePower));
    }
    
    public void cubeOuttake() {
    	double cubePower = SmartDashboard.getNumber("Cube Mech Power (%)", 100);
    	cubePower = cubePower / 100;
    	flyWheelDrive.tankDrive(-(cubePower), cubePower);
    }
}

