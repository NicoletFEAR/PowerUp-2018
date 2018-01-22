package org.usfirst.frc.team4786.robot.subsystems;

import org.usfirst.frc.team4786.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class EyeSolenoid extends Subsystem {
	private final  DoubleSolenoid eye = new DoubleSolenoid(RobotMap.eyemoduleNumber, RobotMap.eyeforwardChannel,RobotMap.eyereverseChannel);
	boolean tube2out=false;
	
	
	public void  fireeyedoublesolenoid() {
		eye.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retracteyedoublesolenoid (){
		eye.set(DoubleSolenoid.Value.kReverse);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
   /* 	if (tube2out=true) {
    		eye.set(DoubleSolenoid.Value.kReverse);
    	}
    	else if (tube2out=false) {
    		
    	}*/
    	
    }
}

