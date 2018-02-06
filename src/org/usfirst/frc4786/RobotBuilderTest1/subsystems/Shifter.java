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
	private final  DoubleSolenoid leftShifter = new DoubleSolenoid(RobotMap.aForwardChannel,RobotMap.aReverseChannel);
//	private final DoubleSolenoid rightShifter = new DoubleSolenoid(RobotMap.bForwardChannel, RobotMap.bReverseChannel);
	public static boolean nomatterwhat=false;
	
	public void shiftup() {
		leftShifter.set(DoubleSolenoid.Value.kForward);
		//rightShifter.set(DoubleSolenoid.Value.kForward);
	}
	
	public void shiftdown (){
		leftShifter.set(DoubleSolenoid.Value.kReverse);
		//rightShifter.set(DoubleSolenoid.Value.kReverse);
	}
	// shift the gearbox to the opposite state
	public void shift (){
		if (leftShifter.get()==DoubleSolenoid.Value.kForward){
			shiftdown();
		}else {
			shiftup();
		}
	
	}
	
	public void stop(){
		leftShifter.set(DoubleSolenoid.Value.kOff);
	}
	
	public boolean getNoMatterWhat(){
		return nomatterwhat;
		
	}
	
	public void setNoMatterWhat(){
		nomatterwhat=!nomatterwhat;
	    SmartDashboard.putBoolean("Start button hit", Robot.shifter.getNoMatterWhat());
	    
        
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	// make sure the pistons are closed at first
    public void initDefaultCommand() {
    	shiftdown();
 
    }
}
