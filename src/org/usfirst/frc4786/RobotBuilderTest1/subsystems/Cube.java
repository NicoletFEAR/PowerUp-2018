package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Cube extends Subsystem {

	private final DoubleSolenoid cubeLiftLeft = new DoubleSolenoid(RobotMap.module0, RobotMap.cForwardChannel,
			RobotMap.cReverseChannel);
	private final DoubleSolenoid cubeLiftRight = new DoubleSolenoid(RobotMap.module0, RobotMap.dForwardChannel,
			RobotMap.dReverseChannel);
	private final DoubleSolenoid cubePunch = new DoubleSolenoid(RobotMap.module0, RobotMap.bForwardChannel,
			RobotMap.bReverseChannel);

	public void initDefaultCommand() {
		
	}

	public void cubeFlywheelBackward() {
		RobotMap.flyWheelLeft.set(ControlMode.PercentOutput, RobotMap.FLY_WHEEL_SPEED);
		RobotMap.flyWheelRight.set(ControlMode.PercentOutput, -RobotMap.FLY_WHEEL_SPEED);
	}

	public void cubeFlywheelForward() {
		RobotMap.flyWheelLeft.set(ControlMode.PercentOutput, -RobotMap.FLY_WHEEL_SPEED);
		RobotMap.flyWheelRight.set(ControlMode.PercentOutput, RobotMap.FLY_WHEEL_SPEED);
	}

	public void cubeFlywheelStop() {
		RobotMap.flyWheelLeft.set(ControlMode.PercentOutput, 0);
		RobotMap.flyWheelRight.set(ControlMode.PercentOutput, 0);
	}

	public void raise() {
		cubeLiftLeft.set(DoubleSolenoid.Value.kReverse);
		cubeLiftRight.set(DoubleSolenoid.Value.kReverse);
	}

	public void lower() {
		cubeLiftLeft.set(DoubleSolenoid.Value.kForward);
		cubeLiftRight.set(DoubleSolenoid.Value.kForward);
	}

	public void extend() { // extends arm to push cube out
		cubePunch.set(DoubleSolenoid.Value.kForward);
	}

	public void retract() {
		cubePunch.set(DoubleSolenoid.Value.kReverse);
	}

	public void lift() {
		if (cubeLiftLeft.get() == DoubleSolenoid.Value.kForward) {
			raise();
		} else {
			lower();
		}
	}

}