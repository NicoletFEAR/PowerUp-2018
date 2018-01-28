package org.usfirst.frc.team4786.robot;

//import org.usfirst.frc.team4786.robot.commands.*;

import edu.wpi.first.wpilibj.XboxController;

import org.usfirst.frc.team4786.robot.commands.Grab;
import org.usfirst.frc.team4786.robot.commands.Lift;
import org.usfirst.frc.team4786.robot.commands.Shift;
import org.usfirst.frc.team4786.robot.xbox.Buttons;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

/**
 *
 */
public class OI {
    private XboxController xbox2;
	public Button xboxLeftStick;
	//xbox controller
	public static final int A = 1;
	public static final int B = 2;
	public static final int X = 3;
	public static final int Y = 4;
	public static final int LeftBump = 5;
	public static final int RightBump = 6;
	public static final int Back = 7;
	public static final int Start = 8;
	public static final int LeftStick = 9;
	public static final int RightStick = 10;
	private static Button rightBumper;
	private static Button leftBumper;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public OI(){
	xbox2 = new XboxController(0);
	rightBumper = new JoystickButton(xbox2, Buttons.RightBump);
	leftBumper = new JoystickButton(xbox2, Buttons.LeftBump);
	xboxLeftStick = new JoystickButton(xbox2, 9);
	xboxLeftStick.whenPressed(new Shift());
	rightBumper.whenPressed(new Lift());
	leftBumper.whenPressed(new Grab());	
	
}
	
	public XboxController getXbox2()
	{
		return xbox2;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

