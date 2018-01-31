package org.usfirst.frc4786.RobotBuilderTest1.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.subsystems.DriveTrain;
import org.usfirst.frc4786.RobotBuilderTest1.OI;
import org.usfirst.frc4786.RobotBuilderTest1.commands.VisionNTableValueSet;

public class CubeVisionDrive extends Command {
	
	
		NetworkTable myTable;
		
	public CubeVisionDrive() {
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void initialize() {	
		
		myTable = NetworkTable.getTable("GRIP/myContoursReport"); // makes the table myTable properly what it should be
		myTable.setUpdateRate(0.05);
		SmartDashboard.putNumber("CubeVisionDriveNum", 1);
		
	}
	
	@Override
	protected void execute() {
		
		double centreX = myTable.getNumber("centerX", 0);
		double centreY = myTable.getNumber("centerY", 0);
		double boxWidth = myTable.getNumber("boxWidth", 0);
		
		if (boxWidth < 640) {
			if (centreX < 315) {
				Robot.driveTrain.takeJoystickInputsValues(0.6, 0.4);

				SmartDashboard.putNumber("CubeVisionDriveNum", 3);
			} else if (centreX > 325) {
				Robot.driveTrain.takeJoystickInputsValues(0.2, 0.1);
				SmartDashboard.putNumber("CubeVisionDriveNum", 4);
			} else {
				Robot.driveTrain.takeJoystickInputsValues(.3, .3);

				SmartDashboard.putNumber("CubeVisionDriveNum", 0);
			}
		} else {
			Robot.driveTrain.takeJoystickInputsValues(1, 1);
		}
    	
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void interrupted() {
		end();
	}
}
