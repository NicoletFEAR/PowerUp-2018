package org.usfirst.frc.team4786.robot;

import org.usfirst.frc.team4786.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 */
public class OI {
	 public static Joystick gameMech;
	public static Button aButton;
    public static Button bButton;
    public static Button xButton;
    public static Button yButton;
    public static Button rightBumper;
    public static Button leftBumper;
    public static Button start;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public OI(){
	gameMech = new Joystick(2);
	aButton = new JoystickButton(gameMech , org.usfirst.frc.team4786.robot.xbox.Buttons.A);
	bButton = new JoystickButton(gameMech , org.usfirst.frc.team4786.robot.xbox.Buttons.B);
	yButton = new JoystickButton(gameMech , org.usfirst.frc.team4786.robot.xbox.Buttons.Y);
	xButton = new JoystickButton(gameMech , org.usfirst.frc.team4786.robot.xbox.Buttons.X);
	rightBumper = new JoystickButton(gameMech ,  org.usfirst.frc.team4786.robot.xbox.Buttons.RightBump);
	leftBumper = new JoystickButton(gameMech ,  org.usfirst.frc.team4786.robot.xbox.Buttons.LeftBump);
	start = new JoystickButton(gameMech , org.usfirst.frc.team4786.robot.xbox.Buttons.Start);
	//aButton.whileHeld(new ());
	//bButton.whileHeld(new PassCommand());
	//yButton.whileHeld(new ShootCommand());
	//xButton.whileHeld(new RaisePortcullis());
	leftBumper.whenPressed(new PistonIn());
	rightBumper.whenPressed(new PistonOut());
}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

