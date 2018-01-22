package org.usfirst.frc.team4786.robot.subsystems;

import org.usfirst.frc.team4786.robot.RobotMap;
//import org.usfirst.frc.team4786.robot.commands.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSolenoid extends Subsystem {
	private final  DoubleSolenoid arm = new DoubleSolenoid(RobotMap.armmoduleNumber, RobotMap.armforwardChannel,RobotMap.armreverseChannel);
	boolean tube1out = false;
	
	public void  firearmdoublesolenoid() {
		arm.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retractarmdoublesolenoid (){
		arm.set(DoubleSolenoid.Value.kReverse);
	}
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
 /*   	if (tube1out=true) {
    		arm.set(DoubleSolenoid.Value.kReverse);
    	}
    	else if (tube1out=false) {
    		
    	}*/
    }
}

