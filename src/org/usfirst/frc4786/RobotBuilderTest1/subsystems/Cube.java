package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Cube extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 public DifferentialDrive flyWheelDrive = new DifferentialDrive(RobotMap.frontLeft, RobotMap.frontRight);
	 private final DoubleSolenoid cubeLiftLeft = new DoubleSolenoid(RobotMap.aForwardChannel,RobotMap.aReverseChannel);
	 private final DoubleSolenoid cubeLiftRight = new DoubleSolenoid(RobotMap.bForwardChannel, RobotMap.bReverseChannel);
	 private final DoubleSolenoid pushArm = new DoubleSolenoid(RobotMap.cForwardChannel, RobotMap.cReverseChannel);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	flyWheelDrive.setSafetyEnabled(false);
//        flyWheelDrive.setExpiration(1);
        flyWheelDrive.setMaxOutput(1.0);

    }
    
    public void cubeIntake() {
    	flyWheelDrive.tankDrive(1, -1);
    }
    
    public void cubeFlywheelForward() {
    	flyWheelDrive.tankDrive(1, -1);
    }
    
    public void cubeFlywheelStop(){
    	flyWheelDrive.tankDrive(0, 0);
    }
    
    public void cubeFlywheelBack() {
    	flyWheelDrive.tankDrive(-1, 1);
    }
    
    public void raise() {
    	cubeLiftLeft.set(DoubleSolenoid.Value.kForward);
    	cubeLiftRight.set(DoubleSolenoid.Value.kForward);
    }
    
    public void lower() {
    	cubeLiftLeft.set(DoubleSolenoid.Value.kReverse);
    	cubeLiftRight.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void extend() { // extends arm to push cube out
    	pushArm.set(DoubleSolenoid.Value.kForward);
    }
    
    public void retract() {
    	pushArm.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void lift() {
    	if (cubeLiftLeft.get()==DoubleSolenoid.Value.kForward){
			lower();
		}else {
			raise();
		}
    }
    
}

