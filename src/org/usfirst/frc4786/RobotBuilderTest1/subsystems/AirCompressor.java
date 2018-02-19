package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class AirCompressor extends Subsystem{
	public static final  Compressor c = new Compressor(RobotMap.compressormodule);
	public AirCompressor (int CompressorModule) {
	
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public void periodic(){
		// Put code here to be run every loop
	}



	public Compressor getC() {
		return c;
	}
}
