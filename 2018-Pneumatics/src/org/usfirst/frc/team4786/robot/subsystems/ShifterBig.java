package org.usfirst.frc.team4786.robot.subsystems;

import org.usfirst.frc.team4786.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShifterBig extends Subsystem {
	private final DoubleSolenoid rightShifter = new DoubleSolenoid(RobotMap.bForwardChannel, RobotMap.bReverseChannel);
	
    public ShifterBig() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    public void shiftup() {
	
		rightShifter.set(DoubleSolenoid.Value.kForward);
	}
	
	public void shiftdown (){
		
		rightShifter.set(DoubleSolenoid.Value.kReverse);
	}
	// shift the gearbox to the opposite state
	public void shift (){
		if (rightShifter.get()==DoubleSolenoid.Value.kForward){
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