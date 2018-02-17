package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shifter extends Subsystem {
	private final DoubleSolenoid shifty = new DoubleSolenoid(RobotMap.module0, RobotMap.aForwardChannel,
			RobotMap.aReverseChannel);
	public static boolean nomatterwhat = false;

	public void shiftup() {
		shifty.set(DoubleSolenoid.Value.kForward);
	}

	public void shiftdown() {
		shifty.set(DoubleSolenoid.Value.kReverse);
	}

	// shift the gearbox to the opposite state
	public void shift() {
		if (shifty.get() == DoubleSolenoid.Value.kForward) {
			shiftdown();
		} else {
			shiftup();
		}
	}

	public void stop() {
		shifty.set(DoubleSolenoid.Value.kOff);
	}

	public boolean getNoMatterWhat() {
		return nomatterwhat;
	}

	public void setNoMatterWhat() {
		nomatterwhat = !nomatterwhat;
		SmartDashboard.putBoolean("Start button hit", Robot.shifter.getNoMatterWhat());
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	// make sure the pistons are closed at first
	public void initDefaultCommand() {
		
	}
}
