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
import org.usfirst.frc4786.RobotBuilderTest1.commands.LiftRamp;
import org.usfirst.frc4786.RobotBuilderTest1.commands.*;
import org.usfirst.frc4786.RobotBuilderTest1.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;
//import edu.wpi.first.wpilibj.interfaces.Potentiometer;

//import org.usfirst.frc4786.RobotBuilderTest1.subsystems.*;
//import org.usfirst.frc4786.RobotBuilderTest1.subsystems.DriveTrain;


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


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
//    private JoystickButton leftJoystickButton1;
//    private Joystick leftJoystick;
//    private JoystickButton rightJoystickButton1;
//    private Joystick rightJoystick;
//  private Button xbox1StartButton;
	
	public XboxController xbox1; // the drive controller
	private Button xbox1LeftStick;
	private Button xbox1RightStick;
    private Button xbox1ButtonX;
    private Button xbox1Start;
    
    private XboxController xbox2; // the game mech controller
    private Button xbox2Start;
    private Button xbox2Back;
    private Button xbox2X;
    private Button xbox2Y;
    private Button xbox2B;
    private Button xbox2A;
    private Button xbox2LTrig;
    private Button xbox2RTrig;
    
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

//       rightJoystick = new Joystick(1);        
//        rightJoystickButton1 = new JoystickButton(rightJoystick, 1);
//        rightJoystickButton1.whileHeld(new SwitchFront());

//        leftJoystick = new Joystick(0);        
//        leftJoystickButton1 = new JoystickButton(leftJoystick, 1);
//        leftJoystickButton1.whileHeld(new SwitchFront());
//       xbox1StartButton = new JoystickButton(xbox1,8);

    	
    	 // create our buttons
         xbox1 = new XboxController(0);
         
         xbox1ButtonX = new JoystickButton(xbox1, 3);
         xbox1LeftStick = new JoystickButton(xbox1, 9);
         xbox1RightStick = new JoystickButton(xbox1, 10);
         xbox1Start = new JoystickButton(xbox1, 8);
         
         xbox2 = new XboxController(1);
         
         xbox2Start = new JoystickButton(xbox2, 8);
         xbox2Back = new JoystickButton(xbox2, 7);
         xbox2X = new JoystickButton(xbox2, 3);
         xbox2Y = new JoystickButton(xbox2, 4);
         xbox2B = new JoystickButton(xbox2, 2);
         xbox2A = new JoystickButton(xbox2, 1);
         xbox2LTrig = new JoystickButton(xbox2, 5);
         xbox2RTrig = new JoystickButton(xbox2, 6);
         
         // tie commands to buttons
         //xbox1ButtonX.whenPressed(new Shift());
         xbox1LeftStick.whenPressed(new SwitchFront());
         xbox1RightStick.whenPressed(new SwitchFront());
         xbox1Start.whenPressed(new RampPush());
         
     	 xbox2Start.whenPressed(new LiftRamp());// these ones haven't quite been added yet
     	 xbox2Back.whenPressed(new RampRelease());         
     	 xbox2X.whenPressed(new CubeMechLift());          
     	 xbox2Y.whenPressed(new CubeLaunch());
     	 xbox2B.whileHeld(new CubeFlywheelForwardButton());
     	 xbox2A.whileHeld(new CubeFlywheelBackward());
     	 xbox2LTrig.whenPressed(new CubePistonRetract());
     	 xbox2RTrig.whenPressed(new CubePistonExtend());
        
        // SmartDashboard Buttons
        SmartDashboard.putData("SwitchFront", new SwitchFront());
        SmartDashboard.putData("Lift Ramp", new LiftRamp());
        //SmartDashboard.putData("Lift Ramp", new NTableValueSet());
        //SmartDashboard.putData("Lift Ramp", new CubeStuff());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    public XboxController getXbox1() {
		return xbox1;
	}
    
    public XboxController getXbox2() {
    	return xbox2;
    }


	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
 //   public Joystick getLeftJoystick() {
 //       return leftJoystick;
 //   }

  //  public Joystick getRightJoystick() {
  //     return rightJoystick;
 //   }



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

