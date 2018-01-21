package org.usfirst.frc.team4786.robot;

import org.usfirst.frc.team4786.robot.subsystems.AirCompressor;
import org.usfirst.frc.team4786.robot.subsystems.ArmSolenoid;
import org.usfirst.frc.team4786.robot.subsystems.EyeSolenoid;
import org.usfirst.frc.team4786.robot.subsystems.HeadSolenoid;
import org.usfirst.frc.team4786.robot.subsystems.LegSolenoid;
/**
 *
 */

//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
public class RobotMap {
	
	public  static int armmoduleNumber = 0;
	public  static int armforwardChannel = 0;
	public  static int armreverseChannel = 1;
	
	public  static int eyemoduleNumber = 0;
	public  static int eyeforwardChannel = 2;
	public  static int eyereverseChannel = 3;
	
	public  static int headmoduleNumber = 0;
	public  static int headforwardChannel = 4;
	public  static int headreverseChannel = 5;
	
	public  static int legmoduleNumber = 0;
	public  static int legforwardChannel = 6;
	public  static int legreverseChannel = 7;
	
	public  static int compressormodule =0;
	
	
	public static void init(){
	}

	{

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

      //setDefaultCommand(new MySpecialCommand());
    }
}

