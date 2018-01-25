package org.usfirst.frc.team4786.robot;

import org.usfirst.frc.team4786.robot.commands.*;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 */
public class OI {
	XboxController xbox1= new XboxController(0);
    
	Button AButton = new JoystickButton(xbox1, 0);
	Button BButton = new JoystickButton(xbox1,1);
	Button XButton = new JoystickButton(xbox1,3);
	Button YButton = new JoystickButton(xbox1,4);
	Button LeftBump = new JoystickButton(xbox1,5);
	Button RightBump = new JoystickButton(xbox1,6);
	Button Back = new JoystickButton(xbox1,7);
	Button Start = new JoystickButton(xbox1,8);
	Button LeftStick = new JoystickButton(xbox1,9);
	Button RightStick = new JoystickButton(xbox1,10);
	//Still need for Triggers
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public OI(){
	AButton.whenPressed(new Lift());
	BButton.whenPressed(new OpennClose());
	XButton.whenPressed(new Shift());
	
	
//	xbox1 = new XboxController(4);
	
//	xbox1XButton = new JoystickButton(xbox1,3);
//	xbox1YButton = new JoystickButton (xbox1,4);
	
	
	
}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

