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

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;
import org.usfirst.frc4786.RobotBuilderTest1.commands.OpenLoopDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends PIDSubsystem {

	private boolean reversed;

	// SpeedControllerGroup leftSide = new
	// SpeedControllerGroup(RobotMap.frontLeft, RobotMap.midLeft,
	// RobotMap.backLeft);
	// SpeedControllerGroup rightSide = new
	// SpeedControllerGroup(RobotMap.frontRight, RobotMap.midRight,
	// RobotMap.backRight);
	//
	// public DifferentialDrive robotDrive = new DifferentialDrive(leftSide,
	// rightSide);

	public double leftSideSwitchSide;
	public double rightSideSwitchSide;

	// Setup our timed drive
	double currentTime = 0.0;
	double endTime = 0.0;
	
	private double turnToAngleRate = 0.0;
	private double currentTargetAngle = 0.0;

	
	public DriveTrain()
	{
		super(RobotMap.TurnP, RobotMap.TurnI, RobotMap.TurnD, 0.01, RobotMap.TurnF);
		initPID();
		RobotMap.midLeft.follow(RobotMap.frontLeft);
		RobotMap.backLeft.follow(RobotMap.frontLeft);
		RobotMap.midRight.follow(RobotMap.frontLeft);
		RobotMap.backRight.follow(RobotMap.frontLeft);
	}
	
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new OpenLoopDrive());
	}

	public void initPID() {
		System.out.println("Starting Up PID!");
		//Turning Angle Setup
		RobotMap.navX.reset();
		getPIDController().setInputRange(-180.0f,  180.0f);
		getPIDController().setOutputRange(-1.0, 1.0);
		getPIDController().setAbsoluteTolerance(RobotMap.ALLOWABLE_TURN_ERROR);
		getPIDController().setContinuous(true);
		
		RobotMap.frontLeft.configAllowableClosedloopError(RobotMap.PIDSLOT,
															RobotMap.ALLOWABLE_ERROR_CONSTANT_LEFT, 10);
		RobotMap.frontRight.configAllowableClosedloopError(RobotMap.PIDSLOT, 
															RobotMap.ALLOWABLE_ERROR_CONSTANT_RIGHT, 10);

		// Make sure the CANTalons are looking at the right stored PID values
		// with the Profile
		// Set our PID Values

		RobotMap.frontLeft.config_kP(RobotMap.PIDSLOT, RobotMap.LeftP, 10);
		RobotMap.frontLeft.config_kI(RobotMap.PIDSLOT, RobotMap.LeftI, 10);
		RobotMap.frontLeft.config_kD(RobotMap.PIDSLOT, RobotMap.LeftD, 10);
		RobotMap.frontLeft.config_kF(RobotMap.PIDSLOT, RobotMap.LeftF, 10);
		RobotMap.frontLeft.config_IntegralZone(RobotMap.PIDSLOT, RobotMap.IZONE, 10);
		/*
		 * Set how fast of a rate the robot will accelerate Do not remove or you
		 * get a fabulous prize of a Flipping robot - CLOSED_LOOP_RAMP_RATE
		 */
		RobotMap.frontLeft.configClosedloopRamp(RobotMap.CLOSED_LOOP_RAMP_RATE, 10);

		RobotMap.frontRight.config_kP(RobotMap.PIDSLOT, RobotMap.RightP, 10);
		RobotMap.frontRight.config_kI(RobotMap.PIDSLOT, RobotMap.RightI, 10);
		RobotMap.frontRight.config_kD(RobotMap.PIDSLOT, RobotMap.RightD, 10);
		RobotMap.frontRight.config_kF(RobotMap.PIDSLOT, RobotMap.RightF, 10);
		RobotMap.frontRight.config_IntegralZone(RobotMap.PIDSLOT, RobotMap.IZONE, 10);
		/*
		 * Set how fast of a rate the robot will accelerate Do not remove or you
		 * get a fabulous prize of a Flipping robot - CLOSED_LOOP_RAMP_RATE
		 */
		RobotMap.frontRight.configClosedloopRamp(RobotMap.CLOSED_LOOP_RAMP_RATE, 10);
		System.out.println("PID has started up!");
	}

	public void takeJoystickInputs(Joystick left, Joystick right) { // tank drive
		RobotMap.frontLeft.set(ControlMode.PercentOutput, left.getY());
		RobotMap.midLeft.follow(RobotMap.frontLeft);
		RobotMap.backLeft.follow(RobotMap.frontLeft);
		RobotMap.frontRight.set(ControlMode.PercentOutput, right.getY());
		RobotMap.midRight.follow(RobotMap.frontRight);
		RobotMap.backRight.follow(RobotMap.frontRight);
	}

	public void takeStickInputValues(double leftStickV, double rightStickV) { // arcade drive
		if (!reversed) {
			RobotMap.frontLeft.set(ControlMode.PercentOutput, -leftStickV);
			RobotMap.midLeft.follow(RobotMap.frontLeft);
			RobotMap.backLeft.follow(RobotMap.frontLeft);
			RobotMap.frontRight.set(ControlMode.PercentOutput, rightStickV);
			RobotMap.midRight.follow(RobotMap.frontRight);
			RobotMap.backRight.follow(RobotMap.frontRight);
		} else {
			RobotMap.frontLeft.set(ControlMode.PercentOutput, -rightStickV);
			RobotMap.midLeft.follow(RobotMap.frontLeft);
			RobotMap.backLeft.follow(RobotMap.frontLeft);
			RobotMap.frontRight.set(ControlMode.PercentOutput, leftStickV);
			RobotMap.midRight.follow(RobotMap.frontRight);
			RobotMap.backRight.follow(RobotMap.frontRight);
		}

		// SmartDashboard.putData("Drive Train", robotDrive);
		// SmartDashboard.putNumber("Left Side", leftSide.get());
		// SmartDashboard.putNumber("Right Side", rightSide.get());

		SensorCollection sensor = RobotMap.frontRight.getSensorCollection();

		SmartDashboard.putNumber("sensor analogin", sensor.getAnalogIn());
		SmartDashboard.putNumber("sensor analoginraw", sensor.getAnalogInRaw());
		SmartDashboard.putNumber("sensor analongvel", sensor.getAnalogInVel());
		SmartDashboard.putNumber("sensor widthpos", sensor.getPulseWidthPosition());
		SmartDashboard.putNumber("sensor velocity", sensor.getQuadratureVelocity());	
	}
	
	public void ArcadeDrive(double robotOutput, double turnAmount) {
		if (!reversed) {

			SmartDashboard.putNumber("turnamount", turnAmount);
			RobotMap.frontLeft.set(ControlMode.PercentOutput, (-robotOutput * RobotMap.leftMotorScaling) - turnAmount);
			RobotMap.midLeft.follow(RobotMap.frontLeft);
			RobotMap.backLeft.follow(RobotMap.frontLeft);
			RobotMap.frontRight.set(ControlMode.PercentOutput, robotOutput - turnAmount);
			RobotMap.midRight.follow(RobotMap.frontRight);
			RobotMap.backRight.follow(RobotMap.frontRight);
		} else {
			RobotMap.frontLeft.set(ControlMode.PercentOutput, (robotOutput * RobotMap.leftMotorScaling) + turnAmount);
			RobotMap.midLeft.follow(RobotMap.frontLeft);
			RobotMap.backLeft.follow(RobotMap.frontLeft);
			RobotMap.frontRight.set(ControlMode.PercentOutput, -robotOutput + turnAmount);
			RobotMap.midRight.follow(RobotMap.frontRight);
			RobotMap.backRight.follow(RobotMap.frontRight);
		}

		SensorCollection sensorRight = RobotMap.frontRight.getSensorCollection();
		SensorCollection sensorLeft = RobotMap.frontLeft.getSensorCollection();

		SmartDashboard.putNumber("sensor analogin", sensorRight.getAnalogIn());
		SmartDashboard.putNumber("sensor analoginraw", sensorRight.getAnalogInRaw());
		SmartDashboard.putNumber("sensor analongvel", sensorRight.getAnalogInVel());
		SmartDashboard.putNumber("sensor widthpos", sensorRight.getPulseWidthPosition());
		SmartDashboard.putNumber("sensor velocity", sensorRight.getQuadratureVelocity());
		
		// shifting
//		double averageVelocity = (Math.abs(sensorRight.getQuadratureVelocity()) + Math.abs(sensorLeft.getQuadratureVelocity()))/2;
		double averageVelocity = Math.abs(sensorRight.getQuadratureVelocity());
		SmartDashboard.putNumber("averageVelocity", averageVelocity);
/*	
	if (!(Robot.oi.xbox1.getStartButton())) {
		if (averageVelocity < 2000) { // if not in low, switch to low
			if (Robot.shifter.shifty.get() != DoubleSolenoid.Value.kForward) {
				Robot.shifter.shiftdown();
			}
		} else if (averageVelocity < 2300) {
			//DO NOTHING
		} else { // if in low, switch to high
			if (Robot.shifter.shifty.get() == DoubleSolenoid.Value.kForward) {
				Robot.shifter.shiftup();
			}
		}
	} else {
		if (Robot.shifter.shifty.get() != DoubleSolenoid.Value.kForward) {
			Robot.shifter.shiftdown();
		}
	}
*/	
	}
	
	// Welcome to the Amazing World of PID! (Population: 3, just P, I, and D)

	private double convertToRotations(double distanceInFeet) {
		return (distanceInFeet) / (Math.PI * (RobotMap.WHEEL_RADIUS * 2));
	}

	public void driveForSeconds(double seconds, double leftInput, double rightInput) {
		currentTime = System.currentTimeMillis();
		endTime = System.currentTimeMillis() + (seconds * 1000);
		while (currentTime < endTime) {
			currentTime = System.currentTimeMillis();
			// robotDrive.tankDrive(leftInput, rightInput);
			RobotMap.frontLeft.set(ControlMode.PercentOutput, leftInput);
			RobotMap.frontRight.set(ControlMode.PercentOutput, rightInput);
		}
		stop();
	}

	public void driveToPositionInit(double distanceToDrive) {
		// Change Talon modes to "position" just in case
		// they were in another mode before
		RobotMap.frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		RobotMap.frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);

		RobotMap.frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		RobotMap.frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);

		// Set our encoders' positions to 0, we haven't moved yet!
		RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);

		// Run convertToRotations function
		double rot = convertToRotations(distanceToDrive);

		// Make motors drive number of rotations
		// calculated before by convertToRotations()
		RobotMap.frontLeft.set(ControlMode.Position, rot);
		RobotMap.frontRight.set(ControlMode.Position, rot);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Make sure we inverse this right side,
		// otherwise, you have a spinning robot on your hands
		RobotMap.frontLeft.set(ControlMode.Position, rot);
		RobotMap.frontRight.set(ControlMode.Position, rot);

		SmartDashboard.putNumber("Rotations Calculated", rot);
		this.driveToPositionIsFinished();
	}

	//Methods called by TurnToAngle
	public void turnToAngleInit(double targetAngle){
		//Initialize turnController and set the target
		currentTargetAngle = targetAngle;
		RobotMap.navX.reset();
		getPIDController().enable();
		getPIDController().setSetpoint(currentTargetAngle);
		System.out.println("Finished Init of TurnToAngle");
	}
	
	public void turnToAngleExecute(){
		//Set the CANTalons to the speed calculated by PIDController
		/* PIDController calculates a rate of motor output,
		 * so the CANTalons need to be in PercentOutput mode */
		System.out.println("The target is " + currentTargetAngle);
		
		RobotMap.frontLeft.set(ControlMode.PercentOutput, -turnToAngleRate);
		RobotMap.frontRight.set(ControlMode.PercentOutput, -turnToAngleRate);
		
		SmartDashboard.putNumber("NavX Angle", RobotMap.navX.getAngle());
		SmartDashboard.putNumber("NavX Turn Rate", RobotMap.navX.getRate());
	}
	
	//Another weird variable check for if turning should stop
	public boolean turnToAngleIsFinished(){
		return getPIDController().onTarget();
	}
	
	public void turnToAngleEnd(){
		getPIDController().disable();
		Robot.driveTrain.stop();
}

	// Some special isFinished() command stuff to not stop before the robot has
	// even moved

	public boolean driveToPositionIsFinished() {
		return Math.abs(RobotMap.frontLeft.getClosedLoopError(0)) <= RobotMap.ALLOWABLE_ERROR_CONSTANT_LEFT
				&& Math.abs(RobotMap.frontRight.getClosedLoopError(10)) <= RobotMap.ALLOWABLE_ERROR_CONSTANT_RIGHT;
	}

	public void driveToPositionEnd() {
		RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
	}

	public double getLeftEncoderPosition() {
		return (RobotMap.frontLeft.getSelectedSensorPosition(0));
	}

	public double getRightEncoderPosition() {
		// Make sure graph isn't upside down (The stocks are going into the
		// toilet!!)
		return (RobotMap.frontRight.getSelectedSensorPosition(0));
	}

	public double getLeftEncoderVelocity() {
		return RobotMap.frontLeft.getSelectedSensorVelocity(0);
	}

	public double getRightEncoderVelocity() {
		// Make sure graph isn't upside down (The stocks are going into the
		// toilet!!)
		return -(RobotMap.frontRight.getSelectedSensorVelocity(0));
	}

	@Override
	public void periodic() {
		SmartDashboard.putNumber("Left Encoder: ", Robot.driveTrain.getLeftEncoderPosition());
		SmartDashboard.putNumber("Right Encoder: ", Robot.driveTrain.getRightEncoderPosition());
	}

	public void stop() {

		RobotMap.frontLeft.set(ControlMode.PercentOutput, 0);
		RobotMap.frontRight.set(ControlMode.PercentOutput, 0);
		RobotMap.backLeft.set(ControlMode.PercentOutput, 0);
		RobotMap.backRight.set(ControlMode.PercentOutput, 0);
		RobotMap.midLeft.set(ControlMode.PercentOutput, 0);
		RobotMap.midRight.set(ControlMode.PercentOutput, 0);
	}

	public boolean isReversed() {
		return reversed;
	}

	public void switchFront() {
		RobotMap.frontLeft.setInverted(!RobotMap.frontLeft.getInverted());
		RobotMap.midLeft.setInverted(!RobotMap.midLeft.getInverted());
		RobotMap.backLeft.setInverted(!RobotMap.backLeft.getInverted());
		RobotMap.frontRight.setInverted(!RobotMap.frontRight.getInverted());
		RobotMap.midRight.setInverted(!RobotMap.midRight.getInverted());
		RobotMap.backRight.setInverted(!RobotMap.backRight.getInverted());
		reversed = !reversed;
	}

	@Override
	protected double returnPIDInput() {
		return RobotMap.navX.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		turnToAngleRate = output;
		System.out.println("Value Written: " + output);
	}

}
