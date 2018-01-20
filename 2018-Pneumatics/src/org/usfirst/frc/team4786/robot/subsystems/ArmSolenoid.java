package org.usfirst.frc.team4786.robot.subsystems;

import org.usfirst.frc.team4786.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSolenoid extends Subsystem {
	public final static DoubleSolenoid arm = new DoubleSolenoid(RobotMap.armmoduleNumber, RobotMap.armforwardChannel,RobotMap.armreverseChannel);
	public ArmSolenoid(int moduleNumber, int forwardChannel, int reverseChannel) {
		
		// TODO Auto-generated constructor stub. We tried taking this out and it yelled at us.
		//it only wants ONE number in the super line, 2 or 3 and it gets angry saying that super must be the first line.
	
		

//instantiate the arm solenoid is in the commands.
	}
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

