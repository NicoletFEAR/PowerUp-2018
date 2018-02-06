package org.usfirst.frc4786.RobotBuilderTest1.commands;


import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionNTableValueSet extends Command {
	
	// We are using the old network tables code because it makes a lot more sense! (so deprecation warnings are OK!)
	NetworkTable myTable; // starts myTable (We think that you have to put this and make a table to access the data in all of the different places that you want the data to be used in (same for the myTable = one!))
	// myTable is the table you use to put the data from the GRIP Contours Report into
	    
	public VisionNTableValueSet() {
    	//requires(Robot.driveTrain);
    	this.setInterruptible(false);
    }
	
	
	@SuppressWarnings("deprecation")
	@Override
	protected void initialize() {

		
    	SmartDashboard.putNumber("jaehtshfs", 4567890);
    	SmartDashboard.putNumber("valuecommandinit", 444);
    	
		myTable = NetworkTable.getTable("GRIP/myContoursReport"); // makes the table myTable properly what it should be
		NetworkTable.setUpdateRate(0.05);
		 
     myTable.putNumber("hsvHueMin", 60);
	 myTable.putNumber("hsvHueMax", 220);
	 myTable.putNumber("hsvSatMin", 168);
	 myTable.putNumber("hsvSatMax", 255);
	 myTable.putNumber("hsvValMin", 100);
	 myTable.putNumber("hsvValMax", 185);
	 myTable.putNumber("contourAreaMin", 6000);
	 
	 myTable.putNumber("solidityMin", 77);
	 myTable.putNumber("solidityMax", 100);
	 myTable.putNumber("ratioMin", 0);
	 myTable.putNumber("ratioMax", 2);
	
	 myTable.setPersistent("hsvHueMin");
	 myTable.setPersistent("hsvHueMax");
	 myTable.setPersistent("hsvSatMin");
	 myTable.setPersistent("hsvSatMax");
	 myTable.setPersistent("hsvValMin");
	 myTable.setPersistent("hsvValMax");
	 myTable.setPersistent("contourAreaMin");
	

	 myTable.setPersistent("solidityMin");
	 myTable.setPersistent("solidityMax");
	 myTable.setPersistent("ratioMin");
	 myTable.setPersistent("ratioMax");
	 

		myTable.putNumber("centerX", 0);
		myTable.putNumber("centerY", 0);
		myTable.putNumber("boxWidth", 0);
		 myTable.setPersistent("centerX");
		 myTable.setPersistent("centerY");
		 myTable.setPersistent("boxWidth");
		
    }
	 
	 
	 
	 @Override
	    protected void execute() {

	    	//SmartDashboard.putNumber("value", 333);
	    	
	    }
	 
	 
     @Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}  
     
     @Override
     protected void end() {
    	 SmartDashboard.putNumber("valueendtest", 888);
     }
     
     @Override
     protected void interrupted() {
     }
     
     
}
