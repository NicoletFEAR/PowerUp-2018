package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap.AutoPlay;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap.AutoPosition;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutoChooser extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
//    	setDefaultCommand(new DisplayAutonomous());
    }

    public void autonomousMode() {
    	double prePosition = Math.ceil(RobotMap.positionKnob.get());
		double preMovement = Math.ceil(RobotMap.playKnob.get());
		if (prePosition == 1.0){
			Robot.myPosition = AutoPosition.A;
		} else if (prePosition == 2.0){
			Robot.myPosition = AutoPosition.B;
		} else if (prePosition == 3.0){
			Robot.myPosition = AutoPosition.C;
		} else if (prePosition == 4.0){
			Robot.myPosition = AutoPosition.D;
		} else if (prePosition == 5.0) {
			Robot.myPosition = AutoPosition.E;
		}
		
		if (preMovement == 1.0){
			Robot.myPlay = AutoPlay.ONE;
		} else if (preMovement == 2.0){
			Robot.myPlay = AutoPlay.TWO;
		} else if (preMovement == 3.0){
			Robot.myPlay = AutoPlay.THREE;
		} else if (preMovement == 4.0){
			Robot.myPlay = AutoPlay.FOUR;
		} else if (preMovement == 5.0){
			Robot.myPlay = AutoPlay.FIVE;
		} else if (preMovement == 6.0){
			Robot.myPlay = AutoPlay.SIX;
		}
		
		return;
	}
    
    public String getPlayString()
    {
    	String playString = "";
    	
    	switch (Robot.myPlay) {
    		case ONE:
    			playString = "1";
    			break;
    		case TWO:
    			playString = "2";
    			break;
    		case THREE:
    			playString = "3";
    			break;
    		case FOUR:
    			playString = "4";
    			break;
    		case FIVE:
    			playString = "5";
    			break;
    		case SIX :
    			playString = "6";
    			break;
    		default:
    			playString = "?";
    			break;
    	}
    	
    	return playString;
    }
    
    public String getPositionString()
    {
    	String positionString = "";
    	switch (Robot.myPosition) {
    		case A:
    			positionString = "A";
    			break;
    		case B:
    			positionString = "B";
    			break;
    		case C:
    			positionString = "C";
    			break;
    		case D:
    			positionString = "D";
    			break;
    		case E:
    			positionString = "E";
    			break;
    		default:
    			positionString = "?";
    			break;
    	}

    	return positionString;
    }
}
