package org.usfirst.frc.team4786.robot.subsystems;

import org.usfirst.frc.team4786.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LegSolenoid extends Subsystem {
	private final  DoubleSolenoid leg = new DoubleSolenoid(RobotMap.legmoduleNumber, RobotMap.legforwardChannel,RobotMap.legreverseChannel);
	
	public void  firelegdoublesolenoid() {
		leg.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retractlegdoublesolenoid (){
		leg.set(DoubleSolenoid.Value.kReverse);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

