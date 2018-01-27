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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static WPI_TalonSRX driveTrainTalonSRX13;
    public static WPI_TalonSRX driveTrainTalonSRX14;
    public static WPI_TalonSRX driveTrainTalonSRX15;
    public static WPI_TalonSRX driveTrainTalonSRX16;
    public static WPI_TalonSRX driveTrainTalonSRX17;
    public static WPI_TalonSRX driveTrainTalonSRX18;
    public static DifferentialDrive driveTrainRobotDrive1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainTalonSRX13 = new WPI_TalonSRX(13);        
        driveTrainTalonSRX14 = new WPI_TalonSRX(14);
        driveTrainTalonSRX15 = new WPI_TalonSRX(15);
        driveTrainTalonSRX16 = new WPI_TalonSRX(16);
        driveTrainTalonSRX15 = new WPI_TalonSRX(17);
        driveTrainTalonSRX16 = new WPI_TalonSRX(18);
        
        /*
        //Autonomous Switcher Stuff!
        Potentiometer pot;
     	pot = new AnalogPotentiometer(0, 360, 30);
     	AnalogInput ai = new AnalogInput(1);
     	pot = new AnalogPotentiometer(ai, 360, 30);
        
     	//Auto Switcher Button (coded as limit switch)
     	DigitalInput autoButton;
     	autoButton = new DigitalInput(1);
     	
        SpeedControllerGroup m_left = new SpeedControllerGroup(driveTrainTalonSRX13, driveTrainTalonSRX15);
        SpeedControllerGroup m_right = new SpeedControllerGroup(driveTrainTalonSRX14, driveTrainTalonSRX16);

       DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);              
        m_drive.setSafetyEnabled(true);
        m_drive.setExpiration(0.1);
        m_drive.setMaxOutput(1.0);
       */
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
