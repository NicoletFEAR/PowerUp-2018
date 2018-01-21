package org.usfirst.frc.team4786.robot.subsystems;

import org.usfirst.frc.team4786.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HeadSolenoid extends Subsystem {
	private final  DoubleSolenoid head = new DoubleSolenoid(RobotMap.headmoduleNumber, RobotMap.headforwardChannel,RobotMap.headreverseChannel);
	
	public void  fireheaddoublesolenoid() {
		head.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retractheaddoublesolenoid (){
		head.set(DoubleSolenoid.Value.kReverse);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

