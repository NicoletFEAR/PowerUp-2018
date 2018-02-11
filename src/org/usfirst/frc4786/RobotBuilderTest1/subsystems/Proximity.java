package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;
import org.usfirst.frc4786.RobotBuilderTest1.commands.StopAtMetersFromSurface;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Proximity extends Subsystem {

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new StopAtDistanceFromSurface());
    }
    
    public double getDistance()
    {
    	double rawVolts = RobotMap.proximity.getVoltage();
    	double finalDistance = rawVolts * RobotMap.proxmitySensorScaling;
    	return finalDistance;
    }
    
    public void sendToDashboard()
    {
    	SmartDashboard.putNumber("Detected Distance", getDistance());
    }
}
