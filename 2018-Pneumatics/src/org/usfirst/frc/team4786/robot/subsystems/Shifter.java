package org.usfirst.frc.team4786.robot.subsystems;

import org.usfirst.frc.team4786.robot.RobotMap;
//import org.usfirst.frc.team4786.robot.commands.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shifter extends Subsystem {
	private final  DoubleSolenoid leftShifter = new DoubleSolenoid(RobotMap.aForwardChannel,RobotMap.aReverseChannel);
	private final DoubleSolenoid rightShifter = new DoubleSolenoid(RobotMap.bForwardChannel, RobotMap.bReverseChannel);
	
	public void shiftup() {
		leftShifter.set(DoubleSolenoid.Value.kForward);
		rightShifter.set(DoubleSolenoid.Value.kForward);
	}
	
	public void shiftdown (){
		leftShifter.set(DoubleSolenoid.Value.kReverse);
		rightShifter.set(DoubleSolenoid.Value.kReverse);
	}
	// shift the gearbox to the opposite state
	public void shift (){
		if (leftShifter.get()==DoubleSolenoid.Value.kForward){
			shiftdown();
		}else {
			shiftup();
		}
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	// make sure the pistons are closed at first
    public void initDefaultCommand() {
    	shiftdown();
 
    }
}

