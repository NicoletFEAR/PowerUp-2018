package org.usfirst.frc.team4786.robot.subsystems;

import org.usfirst.frc.team4786.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LegSolenoid extends Subsystem {
	public final static DoubleSolenoid leg = new DoubleSolenoid(RobotMap.legmoduleNumber, RobotMap.legforwardChannel,RobotMap.legreverseChannel);
	public LegSolenoid(int moduleNumber, int forwardChannel, int reverseChannel) {
		
		
	
		

//instantiate the arm solenoid is in the commands.
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

