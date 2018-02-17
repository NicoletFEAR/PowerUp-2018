package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

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
		RobotMap.flyWheelLeft.set(ControlMode.PercentOutput, 1);
		RobotMap.flyWheelRight.set(ControlMode.PercentOutput, -1);
	}

	public void cubeFlywheelForward() {
		RobotMap.flyWheelLeft.set(ControlMode.PercentOutput, -1);
		RobotMap.flyWheelRight.set(ControlMode.PercentOutput, 1);
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