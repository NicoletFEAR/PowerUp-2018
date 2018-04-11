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
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SPI;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static boolean cubeLaunch;
    public static TalonSRX frontLeft;
    public static TalonSRX frontRight;
    public static TalonSRX midLeft;
    public static TalonSRX midRight;
    public static TalonSRX backLeft;
    public static TalonSRX backRight;
    public static TalonSRX flyWheelLeft;
    public static TalonSRX flyWheelRight;
    
    public static double leftMotorScaling = 0.89;
    public static double rightMotorScaling = 0.89;
    public static double wheelDistance = 21;
    public static double arcSpeedScaling = .5;
    
    public static int module0 = 0;
	public static int aForwardChannel = 0;
	public static int aReverseChannel = 1;
	public static int bForwardChannel = 2;
	public static int bReverseChannel = 3;
	public static int cForwardChannel = 4;
	public static int cReverseChannel = 5;
	public static int dForwardChannel = 6;
	public static int dReverseChannel = 7;
	
	public static int module1 = 1;
	public static int eForwardChannel = 0;
	public static int eReverseChannel = 1;
	public static int fForwardChannel = 2;
	public static int fReverseChannel = 3;
	public static int gForwardChannel = 4;
	public static int gReverseChannel = 5;
	
	public static int compressormodule = 0;
	
	//NavX turn PID Constants
	public static double TurnP = 0.06;
	public static double TurnI = 0.00;
	public static double TurnD = 0.0;
	public static double TurnF = 0.0;
	
	//PID Constants
	public static final double driveToPositionError = .75; // rotations
	public static final double ERROR_CONSTANT_LEFT = 0.0;
	public static final double ERROR_CONSTANT_RIGHT = 0.0;
	public static final int ALLOWABLE_ERROR_CONSTANT_LEFT = 0;
	public static final int ALLOWABLE_ERROR_CONSTANT_RIGHT = 0;
	public static final int ALLOWABLE_TURN_ERROR = 2; //In degrees
	public static final double WHEEL_RADIUS = 3; //Inches
	public static final double fudgeFactor = 1.0;
	public static final int PIDSLOT = 0;
	public static final double CLOSED_LOOP_RAMP_RATE = 0.015625;
	public static final int IZONE = 0;
	public static final double FLY_WHEEL_SPEED = .5;
	
	//Left PIDF
	public static final double LeftP = 0.0001;
	public static final double LeftI = 0.0;
	public static final double LeftD = 0.0;
	public static final double LeftF = 0.0;
	//Right PIDF
	public static final double RightP = 0.0001;
	public static final double RightI = 0.0;
	public static final double RightD = 0.0;
	public static final double RightF = 0.0;
	
	public static AHRS navX;

    public static DigitalInput godSwitch;
    
    public static DigitalInput cubeLeftSwitch;
    public static DigitalInput cubeRightSwitch;

	public static AnalogPotentiometer playKnob;
	public static AnalogPotentiometer positionKnob;
	
	public static int cubeCount = 0;
		
	public enum AutoPosition {
    	A, B, C, D, E
    }
    public enum AutoPlay {
    	ONE, TWO, THREE, FOUR, FIVE, SIX
    }
    
    public static void init() {
        frontLeft = new TalonSRX(13);
        frontRight = new TalonSRX(14);
        midLeft = new TalonSRX(15);
        midRight = new TalonSRX(16);
        backLeft = new TalonSRX(17);
        backRight = new TalonSRX(18);
        
        flyWheelLeft = new TalonSRX(21);
        flyWheelRight = new TalonSRX(22);
        
        positionKnob = new AnalogPotentiometer(1, 5);
        playKnob = new AnalogPotentiometer(2, 6);
        
        godSwitch = new DigitalInput(0);
        
        cubeLeftSwitch = new DigitalInput(1);
        cubeRightSwitch = new DigitalInput(2);
        
    	cubeLaunch = false;
        
        navX = new AHRS(SPI.Port.kMXP);
    }    
}
