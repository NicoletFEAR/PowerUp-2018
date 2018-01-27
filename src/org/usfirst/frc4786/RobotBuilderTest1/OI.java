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
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

import org.usfirst.frc4786.RobotBuilderTest1.subsystems.*;
import org.usfirst.frc4786.RobotBuilderTest1.subsystems.DriveTrain;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private Button xbox1XButton;
    private Button xbox1XButton2;
    private Button xbox1XButton3;
    private XboxController xbox1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
         xbox1 = new XboxController(2);
         xbox1XButton = new JoystickButton(xbox1, 10);
         xbox1XButton2 = new JoystickButton(xbox1, 9);
         xbox1XButton3 = new JoystickButton(xbox1, 3);
         
     	 xbox1XButton.whenPressed(new SwitchFront());
     	 xbox1XButton2.whenPressed(new SwitchFront());
     	 xbox1XButton3.whenPressed(new SwitchFront());
        
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("SwitchFront", new SwitchFront());
    }

    public XboxController getXbox1() {
		return xbox1;
	}

    public Button getXbox1XButton() {
		return xbox1XButton;
	}
}

