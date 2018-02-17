package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;
import org.usfirst.frc4786.RobotBuilderTest1.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Lifter extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private final DoubleSolenoid leftDS = new DoubleSolenoid(RobotMap.module1, RobotMap.bForwardChannel, RobotMap.bReverseChannel);
	private final DoubleSolenoid rightDS = new DoubleSolenoid(RobotMap.module1, RobotMap.cForwardChannel, RobotMap.cReverseChannel);

	public void ascend() {
		leftDS.set(DoubleSolenoid.Value.kForward);
		rightDS.set(DoubleSolenoid.Value.kForward);
	}

	public void descend() {
		leftDS.set(DoubleSolenoid.Value.kReverse);
		rightDS.set(DoubleSolenoid.Value.kReverse);
	}

	public void lift() {
		if (leftDS.get() == DoubleSolenoid.Value.kForward) {
			descend();
		} else {
			ascend();
		}s
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		descend();
	}

	public void stop() {
		leftDS.set(DoubleSolenoid.Value.kOff);
		rightDS.set(DoubleSolenoid.Value.kOff);
	}
}
