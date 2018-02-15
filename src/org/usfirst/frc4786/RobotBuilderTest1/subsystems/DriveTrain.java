// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.OI;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;
import org.usfirst.frc4786.RobotBuilderTest1.commands.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import edu.wpi.first.wpilibj.drive.*;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends Subsystem {

//	private static DriveTrain instance1 = new DriveTrain();
	
//	public static DriveTrain getInstance() {
//		return instance1;
//	}
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	private boolean reversed;
	
    //SpeedControllerGroup leftSide = new SpeedControllerGroup(RobotMap.driveTrainTalonSRX13);
    //SpeedControllerGroup rightSide = new SpeedControllerGroup(RobotMap.driveTrainTalonSRX15);
    SpeedControllerGroup leftSide = new SpeedControllerGroup(RobotMap.frontLeft, RobotMap.midLeft, RobotMap.backLeft);
    SpeedControllerGroup rightSide = new SpeedControllerGroup(RobotMap.frontRight, RobotMap.midRight, RobotMap.backRight);
    public DifferentialDrive robotDrive = new DifferentialDrive(leftSide, rightSide);    
    
    public double leftSideSwitchSide;
    public double rightSideSwitchSide;
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new OpenLoopDrive());
        robotDrive.setSafetyEnabled(true);
        robotDrive.setExpiration(0.1);
        robotDrive.setMaxOutput(1.0);
    }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    

    public void takeJoystickInputs(Joystick left, Joystick right) {
    	robotDrive.tankDrive(left.getY(), right.getY());
    }
    public void takeStickInputValues(double leftStickV, double rightStickV) {
    	if (!reversed) {
    		robotDrive.tankDrive(leftStickV, rightStickV);
    		SmartDashboard.putData("Drive Train", robotDrive);
    		SmartDashboard.putNumber("Left Side", leftSide.get());
    		SmartDashboard.putNumber("Right Side", rightSide.get());
    	} else {
    		robotDrive.tankDrive(rightStickV, leftStickV);
    		SmartDashboard.putData("Drive Train", robotDrive);
    		SmartDashboard.putNumber("Left Side Robot Speed", leftSide.get());
    		SmartDashboard.putNumber("Right Side Robot Speed", rightSide.get());
    	}
    	
    }
    

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void stop () {
    	robotDrive.tankDrive(0, 0);
    }
    
    public boolean isReversed(){
		return reversed;
	}
    
    public void switchFront(){
		leftSide.setInverted(!leftSide.getInverted());
		rightSide.setInverted(!rightSide.getInverted());
		reversed = !reversed;
	}
     // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

