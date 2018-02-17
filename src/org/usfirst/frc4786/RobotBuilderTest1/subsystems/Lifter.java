package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lifter extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private final DoubleSolenoid rampLiftLeft = new DoubleSolenoid(RobotMap.module1, RobotMap.fForwardChannel, RobotMap.fReverseChannel);
	private final DoubleSolenoid rampLiftRight = new DoubleSolenoid(RobotMap.module1, RobotMap.gForwardChannel, RobotMap.gReverseChannel);
	
	private final DoubleSolenoid rampRealease = new DoubleSolenoid(RobotMap.module1, RobotMap.eForwardChannel, RobotMap.eReverseChannel);

	public void ascend() {
		rampLiftLeft.set(DoubleSolenoid.Value.kForward);
		rampLiftRight.set(DoubleSolenoid.Value.kForward);
	}

	public void descend() {
		rampLiftLeft.set(DoubleSolenoid.Value.kReverse);
		rampLiftRight.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void release() {
		rampRealease.set(DoubleSolenoid.Value.kReverse);
	}

	public void lift() {
		if (rampLiftLeft.get()==DoubleSolenoid.Value.kForward){
			descend();
		} else {
			ascend();
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		rampLiftLeft.set(DoubleSolenoid.Value.kReverse);
		rampLiftRight.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stop(){
		rampLiftLeft.set(DoubleSolenoid.Value.kOff);
		rampLiftRight.set(DoubleSolenoid.Value.kOff);
	}
}
