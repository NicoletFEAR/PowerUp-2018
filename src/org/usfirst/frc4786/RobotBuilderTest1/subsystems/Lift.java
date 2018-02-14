package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private final DoubleSolenoid leftDS = new DoubleSolenoid(RobotMap.bForwardChannel, RobotMap.bReverseChannel);
	private final DoubleSolenoid rightDS = new DoubleSolenoid(RobotMap.cForwardChannel, RobotMap.cReverseChannel);

	public void ascend() {
		leftDS.set(DoubleSolenoid.Value.kForward);
		rightDS.set(DoubleSolenoid.Value.kForward);
	}

	public void descend() {
		leftDS.set(DoubleSolenoid.Value.kReverse);
		rightDS.set(DoubleSolenoid.Value.kReverse);
	}

	public void lift() {
		if (leftDS.get()==DoubleSolenoid.Value.kForward){
			ascend();
		} else {
			descend();
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
//		leftDS.set(DoubleSolenoid.Value.kOff);
//		rightDS.set(DoubleSolenoid.Value.kOff);
	}
}
