 // RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4786.RobotBuilderTest1;

import org.usfirst.frc4786.RobotBuilderTest1.commands.SwitchFront;
import org.usfirst.frc4786.RobotBuilderTest1.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    private Button xbox1RightStick;
    private Button xbox1LeftStick;
    private Button xbox1ButtonX;
    private Button xbox1StartButton;
    private Button xbox1XButton;
    private Button xbox1XButton2;
    private Button xbox1XButton3;
    private XboxController xbox1;

    public OI() {
         xbox1 = new XboxController(2);
         xbox1ButtonX = new JoystickButton(xbox1, 3);
         xbox1StartButton = new JoystickButton(xbox1,8);
         xbox1LeftStick = new JoystickButton(xbox1, 9);
         xbox1RightStick = new JoystickButton(xbox1, 10);
         
         
         
     	 xbox1ButtonX.whenPressed(new SwitchFront());
     	 xbox1StartButton.whenPressed(new NoMatterWhat());
     	 xbox1LeftStick.whenPressed(new Shift());
     	 xbox1RightStick.whenPressed(new SwitchFront());

        // SmartDashboard Buttons
        SmartDashboard.putData("SwitchFront", new SwitchFront());
    }

    public XboxController getXbox1() {
		return xbox1;
	}

    public Button getXbox1XButton() {
		return xbox1XButton;
	}
}

