package org.usfirst.frc.team4786.robot.subsystems;

import org.usfirst.frc.team4786.robot.RobotMap;
//import org.usfirst.frc.team4786.robot.commands.*;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GameMech extends Subsystem {
	private final  DoubleSolenoid lift = new DoubleSolenoid(RobotMap.cForwardChannel,RobotMap.cReverseChannel);
	private final DoubleSolenoid grab = new DoubleSolenoid(RobotMap.dForwardChannel, RobotMap.dReverseChannel);
	public static AnalogInput switch0 = new AnalogInput(0);
	public static AnalogInput switch1 = new AnalogInput(1);
	public static DigitalInput testSwitch =  new DigitalInput(0);

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
	
	
	
	
	
	//potentiometer goes 4020
	public int groupVal(double options, AnalogInput mySwitch) {
		double range = 4020;
		double currentValue = mySwitch.getValue()-4;
		if (currentValue == 0.0) {
			currentValue++;
		}
		double preNumber = (currentValue)/(range/(options-1));
		return (int) Math.ceil(preNumber);
		
	}
	
	public String autonomousMode(){
		
		int prePosition = groupVal(4, switch1);
		int preMovement = groupVal(4, switch0);
		String position = null;
		String movement = null;
		if (prePosition == 1){
			position = "A";
		} else if (prePosition == 2){
			position = "B";
		} else if (prePosition == 3){
			position = "C";
		} else if (prePosition == 4){
			position = "D";
		} 
		
		if (preMovement == 1){
			movement = "Up";
		} else if (preMovement == 2){
			movement = "Right";
		} else if (preMovement == 3){
			movement = "Down";
		} else if (preMovement == 4){
			movement = "Left";
		} 
		
		return ("Position" + position + " and Move" + movement);
		}
	
	
	
	public boolean testVal() {
		return testSwitch.get();
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	open();
    	liftdown();
    }
}

