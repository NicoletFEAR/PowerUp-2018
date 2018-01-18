package org.usfirst.frc.team4786.robot.commands;

import org.usfirst.frc.team4786.robot.subsystems.AirCompressor;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class QueryCompressor extends IterativeRobot{
	public void robotInit() {
		
		SmartDashboard.putBoolean("The Compressor is on", AirCompressor.c.enabled());
		AirCompressor.c.start();
	}
	
	public void autonomousInit() {
		
		
	}
	
	public void autonomousPeriodic() {
		SmartDashboard.putBoolean("The pressure is low", AirCompressor.c.getPressureSwitchValue());
		SmartDashboard.putNumber("The current pressure in amps:", AirCompressor.c.getCompressorCurrent());
		
	
	
	}
	
	public void teleopPeriodic() {
	

	SmartDashboard.putBoolean("The pressure is low", AirCompressor.c.getPressureSwitchValue());
	SmartDashboard.putNumber("The current pressure in amps:", AirCompressor.c.getCompressorCurrent());
	
	}
	public void testPeriodic() {
	}
}
	
	
	
	
	
	
	
	
	

