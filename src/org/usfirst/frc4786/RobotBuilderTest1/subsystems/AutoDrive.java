package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutoDrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void goForward(int ticks){
		RobotMap.frontLeft.set(ControlMode.Position, 10);
		RobotMap.midLeft.follow(RobotMap.frontLeft);
		RobotMap.backLeft.follow(RobotMap.backLeft);
		RobotMap.frontRight.set(ControlMode.Position, 10);
		RobotMap.midRight.follow(RobotMap.frontRight);
		RobotMap.backRight.follow(RobotMap.frontRight);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

