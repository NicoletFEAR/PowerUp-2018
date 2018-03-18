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

import org.usfirst.frc4786.RobotBuilderTest1.commands.CubeFlywheelBackward;
import org.usfirst.frc4786.RobotBuilderTest1.commands.CubeFlywheelForwardButton;
import org.usfirst.frc4786.RobotBuilderTest1.commands.CubeLaunch;
//import org.usfirst.frc4786.RobotBuilderTest1.commands.CubeMechLift;
import org.usfirst.frc4786.RobotBuilderTest1.commands.CubeVisionDrive;
//import org.usfirst.frc4786.RobotBuilderTest1.commands.LiftRamp;
import org.usfirst.frc4786.RobotBuilderTest1.commands.NoDrivey;
//import org.usfirst.frc4786.RobotBuilderTest1.commands.RampPush;
//import org.usfirst.frc4786.RobotBuilderTest1.commands.RampRelease;
import org.usfirst.frc4786.RobotBuilderTest1.commands.VisionNTableValueSet;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
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

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public XboxController xbox1; // the drive controller
	private Button xbox1LeftStick;
	private Button xbox1RightStick;
	public Button xbox1Start;
	private Button xbox1X;
	private Button xbox1B;

	private XboxController xbox2; // the game mech controller
	private Button xbox2Start;
	private Button xbox2Back;
	private Button xbox2X;
	private Button xbox2Y;
	private Button xbox2B;
	private Button xbox2A;

	public OI() {
		// create our buttons
		xbox1 = new XboxController(0);

		xbox1X = new JoystickButton(xbox1, 3);
		xbox1LeftStick = new JoystickButton(xbox1, 9);
		xbox1RightStick = new JoystickButton(xbox1, 10);
		xbox1Start = new JoystickButton(xbox1, 8);
		xbox1B = new JoystickButton(xbox1, 2);

		xbox2 = new XboxController(1);

		xbox2Start = new JoystickButton(xbox2, 8);
		xbox2Back = new JoystickButton(xbox2, 7);
		xbox2X = new JoystickButton(xbox2, 3);
		xbox2Y = new JoystickButton(xbox2, 4);
		xbox2B = new JoystickButton(xbox2, 2);
		xbox2A = new JoystickButton(xbox2, 1);

		// tie commands to buttons
		// xbox1ButtonX.whenPressed(new Shift());
		//xbox1LeftStick.whenPressed(new SwitchFront());
		//xbox1RightStick.whenPressed(new SwitchFront());
//		xbox1Start.whenPressed(new RampPush());
		xbox1B.whileHeld(new NoDrivey());

		// xbox1XButton4.whenPressed(new VisionNTableValueSet());
		// xbox1ButtonB.whenPressed(new CubeVisionDrive());
		// xbox1ButtonY.whenPressed(new CubeVisionDrive());

//		xbox2Start.whenPressed(new LiftRamp());// these ones haven't quite been
//												 added yet
//		xbox2Back.whenPressed(new RampRelease());
//		xbox2X.whenPressed(new CubeMechLift());
		xbox2Y.whenPressed(new CubeLaunch());
		xbox2B.whileHeld(new CubeFlywheelForwardButton());
		xbox2A.whileHeld(new CubeFlywheelBackward());

		// SmartDashboard Buttons
		//SmartDashboard.putData("SwitchFront", new SwitchFront());
		SmartDashboard.putData("VisionNTableValueSet", new VisionNTableValueSet());
		SmartDashboard.putData("CubeVisionDriver", new CubeVisionDrive());
	}

	public XboxController getXbox1() {
		return xbox1;
	}

	public XboxController getXbox2() {
		return xbox2;
	}

}
