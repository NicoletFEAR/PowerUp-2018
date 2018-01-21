package org.usfirst.frc.team4786.robot;

import org.usfirst.frc.team4786.robot.commands.*;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 */
public class OI {
	/* public static Joystick gameMech;
	public static Button aButton;
    public static Button bButton;
    public static Button xButton;
    public static Button yButton;
    public static Button rightBumper;
    public static Button leftBumper;
    public static Button start;*/
    private XboxController xbox1;
    private Button xbox1XButton;
    private Button xbox1YButton;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public OI(){
//	gameMech = new Joystick(1);
/*	aButton = new JoystickButton(gameMech , org.usfirst.frc.team4786.robot.xbox.Buttons.A);
	bButton = new JoystickButton(gameMech , org.usfirst.frc.team4786.robot.xbox.Buttons.B);
	yButton = new JoystickButton(gameMech , org.usfirst.frc.team4786.robot.xbox.Buttons.Y);
	xButton = new JoystickButton(gameMech , org.usfirst.frc.team4786.robot.xbox.Buttons.X);
	rightBumper = new JoystickButton(gameMech ,  org.usfirst.frc.team4786.robot.xbox.Buttons.RightBump);
	leftBumper = new JoystickButton(gameMech ,  org.usfirst.frc.team4786.robot.xbox.Buttons.LeftBump);
	start = new JoystickButton(gameMech , org.usfirst.frc.team4786.robot.xbox.Buttons.Start);
	aButton.whileHeld(new PistonIn());
	bButton.whileHeld(new PistonIn());
	yButton.whileHeld(new PistonOut());
	xButton.whileHeld(new PistonOut());*/
//	leftBumper.whenPressed(new PistonIn());
//	rightBumper.whenPressed(new PistonOut());
	
	xbox1 = new XboxController(4);
	
	xbox1XButton = new JoystickButton(xbox1,3);
	xbox1YButton = new JoystickButton (xbox1,4);
	
	xbox1XButton.whenPressed(new PistonOut());
	xbox1YButton.whenPressed(new PistonIn());
	
}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

