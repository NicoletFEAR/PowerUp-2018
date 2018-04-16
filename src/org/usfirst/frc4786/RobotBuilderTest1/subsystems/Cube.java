package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;
import org.usfirst.frc4786.RobotBuilderTest1.commands.*;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Cube extends Subsystem {
//
//	private final DoubleSolenoid cubeLiftLeft = new DoubleSolenoid(RobotMap.module0, RobotMap.cForwardChannel,
//			RobotMap.cReverseChannel);
//	private final DoubleSolenoid cubeLiftRight = new DoubleSolenoid(RobotMap.module0, RobotMap.dForwardChannel,
//			RobotMap.dReverseChannel);

	public void initDefaultCommand() {
		setDefaultCommand(new CubeFlywheelVariable());
	}

	public void cubeFlywheelBackward() {
		RobotMap.flyWheelLeft.set(ControlMode.PercentOutput, 1);
		RobotMap.flyWheelRight.set(ControlMode.PercentOutput, -1);
	}

	public void cubeFlywheelForward() {
		RobotMap.flyWheelLeft.set(ControlMode.PercentOutput, -0.75);
		RobotMap.flyWheelRight.set(ControlMode.PercentOutput, 0.75);
	}
	
	public void cubeFlywheelOutSpeed(double speed) {
		RobotMap.flyWheelLeft.set(ControlMode.PercentOutput, -speed);
		RobotMap.flyWheelRight.set(ControlMode.PercentOutput, speed);
	}
	
	public void cubeFlywheelInSpeed(double speed) {
		RobotMap.flyWheelLeft.set(ControlMode.PercentOutput, speed);
		RobotMap.flyWheelRight.set(ControlMode.PercentOutput, -speed);
	}

	public void cubeFlywheelStop() {
		RobotMap.flyWheelLeft.set(ControlMode.PercentOutput, 0);
		RobotMap.flyWheelRight.set(ControlMode.PercentOutput, 0);
	}

//	public void raise() {
//		cubeLiftLeft.set(DoubleSolenoid.Value.kReverse);
//		cubeLiftRight.set(DoubleSolenoid.Value.kReverse);
//	}
//
//	public void lower() {
//		cubeLiftLeft.set(DoubleSolenoid.Value.kForward);
//		cubeLiftRight.set(DoubleSolenoid.Value.kForward);
//	}
//
//	public void lift() {
//		if (cubeLiftLeft.get() == DoubleSolenoid.Value.kForward) {
//			raise();
//		} else {
//			lower();
//		}
//	}

}