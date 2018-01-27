package org.usfirst.frc.team4786.robot.subsystems;

import org.usfirst.frc.team4786.robot.RobotMap;
//import org.usfirst.frc.team4786.robot.commands.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GameMech extends Subsystem {
	private final  DoubleSolenoid lift = new DoubleSolenoid(RobotMap.cForwardChannel,RobotMap.cReverseChannel);
	private final DoubleSolenoid grab = new DoubleSolenoid(RobotMap.dForwardChannel, RobotMap.dReverseChannel);
	
	public void  liftup() {
		lift.set(DoubleSolenoid.Value.kForward);
		
	}
	
	public void liftdown (){
		lift.set(DoubleSolenoid.Value.kReverse);
		
	}
	
	public void lift() {
		if(lift.get()==DoubleSolenoid.Value.kForward==true){
			liftdown();
		}else if (lift.get()==DoubleSolenoid.Value.kForward==false) {
			liftup();
		}
	}
	
	public void close(){
		grab.set(DoubleSolenoid.Value.kForward);
	}
	
	public void open(){
		grab.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void gate() {
		if (grab.get()==DoubleSolenoid.Value.kForward) {
			open();
		}else if (grab.get()==DoubleSolenoid.Value.kReverse) {
			close();
		}
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	open();
    	liftdown();
    }
}

