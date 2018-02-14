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

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
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
    public static TalonSRX frontLeft;
    public static TalonSRX frontRight;
    public static TalonSRX midLeft;
    public static TalonSRX midRight;
    public static TalonSRX backLeft;
    public static TalonSRX backRight;
    
    public static DifferentialDrive robotDrive;
	public static int aForwardChannel = 0;
	public static int aReverseChannel = 1;
	public static int bForwardChannel = 2;
	public static int bReverseChannel = 3;
	public static int cForwardChannel = 4;
	public static int cReverseChannel = 5;
	public static int compressormodule = 0;
	
	//PID Constants
	public static double ERROR_CONSTANT_LEFT = 0.0;
	public static double ERROR_CONSTANT_RIGHT = 0.0;
	public static double WHEEL_RADIUS = 3.125; //Inches
	public static double WHEEL_SEPARATION = 5.0; //Inches

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        frontLeft = new TalonSRX(13);
        frontRight = new TalonSRX(14);
        midLeft = new TalonSRX(15);
        midRight = new TalonSRX(16);
        backLeft = new TalonSRX(17);
        backRight = new TalonSRX(18);
        
        /*
        //Autonomous Switcher Stuff!
        Potentiometer pot;
     	pot = new AnalogPotentiometer(0, 360, 30);
     	AnalogInput ai = new AnalogInput(1);
     	pot = new AnalogPotentiometer(ai, 360, 30);
        
     	//Auto Switcher Button (coded as limit switch)
     	DigitalInput autoButton;
     	autoButton = new DigitalInput(1);
     	
     	*/
        /*
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
