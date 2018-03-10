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
		boolean isFinished;
		
	public CubeVisionDrive() {
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void initialize() {	
		
		isFinished = false;
		myTable = NetworkTable.getTable("GRIP/myContoursReport"); // makes the table myTable properly what it should be
		myTable.setUpdateRate(0.05);
		SmartDashboard.putNumber("CubeVisionDriveNum", 1);
		
	}
	
	@Override
	protected void execute() {
		
		double centreX = myTable.getNumber("centerX", 0);
		double centreY = myTable.getNumber("centerY", 0);
		double boxWidth = myTable.getNumber("boxWidth", 0);

			
		
		if (boxWidth < 600) {	// the cube is a reasonable distance away
		    
			if (centreX < 50) { // the cube is far left
				Robot.driveTrain.takeStickInputValues(0.3, 0.9);
			} else if (centreX > 590) { // the cube is far right
				Robot.driveTrain.takeStickInputValues(0.9, 0.3);
			} else if (centreX < 315) { // the cube is left
				Robot.driveTrain.takeStickInputValues(0.3, 0.6);
			} else if (centreX > 325) { // the cube is right
				Robot.driveTrain.takeStickInputValues(0.6, 0.3);
			} else {
				Robot.driveTrain.takeStickInputValues(.4, .4);
			}
		} else { // when the cube is super close
			
			isFinished = true; // This ends the command!! Done! Terminated! you will have to change this to actually pick up the cube
			end();
		}
			
			
	}
	public void finish() {
		
		
		
	}
	
	@Override
	protected boolean isFinished() {
		return isFinished;
	}
	
    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.driveTrain.stop();
    }
	
	@Override
	protected void interrupted() {
		end();
	}
}
