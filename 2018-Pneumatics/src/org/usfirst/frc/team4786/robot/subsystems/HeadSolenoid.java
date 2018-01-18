package org.usfirst.frc.team4786.robot.subsystems;

import org.usfirst.frc.team4786.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HeadSolenoid extends Subsystem {
	public final static DoubleSolenoid head = new DoubleSolenoid(RobotMap.headmoduleNumber, RobotMap.headforwardChannel,RobotMap.headreverseChannel);
	public HeadSolenoid(int moduleNumber, int forwardChannel, int reverseChannel) {
		
		
		

//instantiate the arm solenoid is in the commands.
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

