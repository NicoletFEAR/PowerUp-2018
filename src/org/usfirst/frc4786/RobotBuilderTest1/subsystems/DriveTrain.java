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

import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;
import org.usfirst.frc4786.RobotBuilderTest1.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private boolean reversed;
	
    SpeedControllerGroup leftSide = new SpeedControllerGroup(RobotMap.frontLeft, RobotMap.midLeft, RobotMap.backLeft);
    SpeedControllerGroup rightSide = new SpeedControllerGroup(RobotMap.frontRight, RobotMap.midRight, RobotMap.backRight);
    
    public DifferentialDrive robotDrive = new DifferentialDrive(leftSide, rightSide);  
    
    public double leftSideSwitchSide;
    public double rightSideSwitchSide;
    
    //Setup our timed drive
    double currentTime = 0.0;
    double endTime = 0.0;

    @Override
    public void initDefaultCommand() {
    	
        setDefaultCommand(new OpenLoopDrive());
        initPID();
        robotDrive.setSafetyEnabled(true);
        robotDrive.setExpiration(0.1);
        robotDrive.setMaxOutput(1.0);
    }
    
    public void initPID()
    {
    	RobotMap.frontLeft.configAllowableClosedloopError(RobotMap.PIDSLOT, RobotMap.ALLOWABLE_ERROR_CONSTANT_LEFT, 10);
		RobotMap.frontRight.configAllowableClosedloopError(RobotMap.PIDSLOT, RobotMap.ALLOWABLE_ERROR_CONSTANT_RIGHT, 10);
		
		//Make sure the CANTalons are looking at the right stored PID values with the Profile
		//Set our PID Values
		
		RobotMap.frontLeft.config_kP(RobotMap.PIDSLOT, RobotMap.LeftP, 10);
		RobotMap.frontLeft.config_kI(RobotMap.PIDSLOT, RobotMap.LeftI, 10);
		RobotMap.frontLeft.config_kD(RobotMap.PIDSLOT, RobotMap.LeftD, 10);
		RobotMap.frontLeft.config_kF(RobotMap.PIDSLOT, RobotMap.LeftF, 10);
		RobotMap.frontLeft.config_IntegralZone(RobotMap.PIDSLOT, RobotMap.IZONE, 10);
		/* Set how fast of a rate the robot will accelerate
		   Do not remove or you get a fabulous prize of a
		   Flipping robot - CLOSED_LOOP_RAMP_RATE */
		RobotMap.frontLeft.configClosedloopRamp(RobotMap.CLOSED_LOOP_RAMP_RATE, 10);
		
		RobotMap.frontRight.config_kP(RobotMap.PIDSLOT, RobotMap.RightP, 10);
		RobotMap.frontRight.config_kI(RobotMap.PIDSLOT, RobotMap.RightI, 10);
		RobotMap.frontRight.config_kD(RobotMap.PIDSLOT, RobotMap.RightD, 10);
		RobotMap.frontRight.config_kF(RobotMap.PIDSLOT, RobotMap.RightF, 10);
		RobotMap.frontRight.config_IntegralZone(RobotMap.PIDSLOT, RobotMap.IZONE, 10);
		/* Set how fast of a rate the robot will accelerate
		   Do not remove or you get a fabulous prize of a
		   Flipping robot - CLOSED_LOOP_RAMP_RATE */
		RobotMap.frontRight.configClosedloopRamp(RobotMap.CLOSED_LOOP_RAMP_RATE, 10);
    }

    public void takeJoystickInputs(Joystick left, Joystick right) {
    	robotDrive.tankDrive(left.getY(), right.getY());
    }
    
    public void takeStickInputValues(double leftStickV, double rightStickV) {
    	if (!reversed) {
    		robotDrive.tankDrive(leftStickV, rightStickV);
    	} else {
    		robotDrive.tankDrive(rightStickV, leftStickV);
    	}
    	
    	SmartDashboard.putData("Drive Train", robotDrive);
		SmartDashboard.putNumber("Left Side", leftSide.get());
		SmartDashboard.putNumber("Right Side", rightSide.get());
		
		SensorCollection sensor = RobotMap.frontRight.getSensorCollection();
		
		SmartDashboard.putNumber("sensor analogin", sensor.getAnalogIn());
		SmartDashboard.putNumber("sensor analoginraw", sensor.getAnalogInRaw());
		SmartDashboard.putNumber("sensor analongvel", sensor.getAnalogInVel());
		SmartDashboard.putNumber("sensor widthpos", sensor.getPulseWidthPosition());
		SmartDashboard.putNumber("sensor velocity", sensor.getQuadratureVelocity());
    }
    
  //Welcome to the Amazing World of PID! (Population: 3, just P, I, and D)
	
    private double convertToRotations(double distanceInFeet){
		return (distanceInFeet)/(Math.PI * (RobotMap.WHEEL_RADIUS * 2));
    }
    
    public void driveForSeconds(double seconds, double leftInput, double rightInput) {
   		currentTime = System.currentTimeMillis();
    	endTime = System.currentTimeMillis() + (seconds * 1000);
    	while (currentTime < endTime) {
        	currentTime = System.currentTimeMillis();
        	robotDrive.tankDrive(leftInput, rightInput);
    	}
    	stop();
    }
    
  	public void driveToPositionInit(double distanceToDrive){
  		//Change Talon modes to "position" just in case
  		//they were in another mode before
		RobotMap.frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		RobotMap.frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		
    	RobotMap.frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		RobotMap.frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		
		//Set our encoders' positions to 0, we haven't moved yet!
		RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
  		
  		//Run convertToRotations function
  		double rot = convertToRotations(distanceToDrive);
  		
  		//Make motors drive number of rotations
  		//calculated before by convertToRotations()
  		RobotMap.frontLeft.set(ControlMode.Position, rot);
  		RobotMap.frontRight.set(ControlMode.Position, rot);
  		try {
  			Thread.sleep(10);
  		} catch (InterruptedException e) {
  			e.printStackTrace();
  		}
  		//Make sure we inverse this right side,
  		//otherwise, you have a spinning robot on your hands
  		RobotMap.frontLeft.set(ControlMode.Position, rot);
  		RobotMap.frontRight.set(ControlMode.Position, rot);

  		
  		SmartDashboard.putNumber("Rotations Calculated", rot);
  	}
  	
  	public void driveArcInit(double horizontalDist, double theta){
  		//Set Encoder Position to 0
		RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
  		try {
  			Thread.sleep(10);
  		} catch (InterruptedException e) {
  			e.printStackTrace();
  		}
		RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
  		
  		//Calculate arc lengths
  		theta = Math.toRadians(theta);
  		double radius = horizontalDist / (1 - Math.cos(theta));
  		double leftArcLength = theta * (radius + RobotMap.WHEEL_SEPARATION / 2);
  		double rightArcLength = theta * (radius - RobotMap.WHEEL_SEPARATION / 2);
  		if(horizontalDist < 0){
  			leftArcLength *= -1;
  			rightArcLength *= -1;
  		}
  		
  		//Run convertToRotations functions
  		double leftRot = convertToRotations(leftArcLength);
  		double rightRot = convertToRotations(rightArcLength);
  		
  		//Make motors drive number of rotations
  		//calculated before by convertToRotations()
  		RobotMap.frontLeft.set(leftRot/* * RobotMap.turnFudgeFactor*/);
  		//Make sure we inverse this right side,
  		//otherwise, you have a spinning robot on your hands
  		RobotMap.frontRight.set(-rightRot/* * RobotMap.turnFudgeFactor*/);
  	}
  	
  	public void driveArcSpeedInit(double leftSpeed, double rightSpeed){
  		//Set Encoder Position to 0
		RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
  		try {
  			Thread.sleep(10);
  		} catch (InterruptedException e) {
  			e.printStackTrace();
  		}
		RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
  		
  		RobotMap.frontLeft.set(ControlMode.PercentOutput, -leftSpeed);
  		RobotMap.frontRight.set(ControlMode.PercentOutput, -rightSpeed);
  	}
  	
  	public void driveArcSpeedEnd(){
  		RobotMap.frontLeft.set(0);
  		RobotMap.frontRight.set(0);
  	}
  	
  	//Some special isFinished() command stuff to not stop before the robot has even moved

  	public boolean driveToPositionIsFinished() {
  		return Math.abs(RobotMap.frontLeft.getClosedLoopError(0)) <= RobotMap.ALLOWABLE_ERROR_CONSTANT_LEFT && Math.abs(RobotMap.frontRight.getClosedLoopError(10)) <= RobotMap.ALLOWABLE_ERROR_CONSTANT_RIGHT;
  	}

  	public void driveToPositionEnd(){
		RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
  	}
  	
  	public double getLeftEncoderPosition()
  	{
  		return RobotMap.frontLeft.getSelectedSensorPosition(0);
  	}
  	
  	public double getRightEncoderPosition()
  	{
  		//Make sure graph isn't upside down (The stocks are going into the toilet!!)
  		return -(RobotMap.frontRight.getSelectedSensorPosition(0));
  	}
  	
  	public double getLeftEncoderVelocity()
  	{
  		return RobotMap.frontLeft.getSelectedSensorVelocity(0);
  	}
  	
  	public double getRightEncoderVelocity()
  	{
  		//Make sure graph isn't upside down (The stocks are going into the toilet!!)
  		return -(RobotMap.frontRight.getSelectedSensorVelocity(0));
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

