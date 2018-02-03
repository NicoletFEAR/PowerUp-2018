package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap.AutoPlay;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap.AutoPosition;
import org.usfirst.frc4786.RobotBuilderTest1.commands.DisplayAutonomous;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutoChooser extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new DisplayAutonomous());
    }
    
/*
	public int groupVal(double options, AnalogInput mySwitch) {
		double range = 4020;
		double currentValue = mySwitch.getValue()-4;
		if (currentValue == 0.0) {
			currentValue++;
		}
		double preNumber = (currentValue)/(range/(options-1));
		return (int) Math.ceil(preNumber);	
	}
*/    
    public void autonomousMode() {
//		int prePosition = groupVal(5, RobotMap.positionKnob);
    	double prePosition = RobotMap.positionKnob.get();
		System.out.println(prePosition);
//		int preMovement = groupVal(6, RobotMap.playKnob);
		double preMovement = RobotMap.playKnob.get();
		System.out.println(preMovement);
		if (prePosition == 1){
			Robot.myPosition = AutoPosition.A;
		} else if (prePosition == 2){
			Robot.myPosition = AutoPosition.B;
		} else if (prePosition == 3){
			Robot.myPosition = AutoPosition.C;
		} else if (prePosition == 4){
			Robot.myPosition = AutoPosition.D;
		} else if (prePosition == 5) {
			Robot.myPosition = AutoPosition.E;
		} else {
			Robot.myPosition = AutoPosition.A;
    	}
		
		if (preMovement == 1){
			Robot.myPlay = AutoPlay.ONE;
		} else if (preMovement == 2){
			Robot.myPlay = AutoPlay.TWO;
		} else if (preMovement == 3){
			Robot.myPlay = AutoPlay.THREE;
		} else if (preMovement == 4){
			Robot.myPlay = AutoPlay.FOUR;
		} else if (preMovement == 5){
			Robot.myPlay = AutoPlay.FIVE;
		} else if (preMovement == 6){
			Robot.myPlay = AutoPlay.SIX;
		} else {
			Robot.myPlay = AutoPlay.ONE;
    	}
		
		return;
	}
    
    public String getPlayString()
    {
    	String playString = "";
    	
    	switch (Robot.myPlay) {
    		case ONE:
    			playString = "1";
    		case TWO:
    			playString = "2";
    		case THREE:
    			playString = "3";
    		case FOUR:
    			playString = "4";
    		case FIVE:
    			playString = "5";
    		case SIX :
    			playString = "6";
    		default:
    			playString = "?";
    	}
    	
    	return playString;
    }
    
    public String getPositionString()
    {
    	String positionString = "";
    	switch (Robot.myPosition) {
    		case A:
    			positionString = "A";
    		case B:
    			positionString = "B";
    		case C:
    			positionString = "C";
    		case D:
    			positionString = "D";
    		case E:
    			positionString = "E";
    		default:
    			positionString = "?";
    	}

    	return positionString;
    }
}

