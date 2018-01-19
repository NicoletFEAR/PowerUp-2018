package org.usfirst.frc.team4786.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.tables.ITable;

import org.usfirst.frc.team4786.robot.RobotMap;

/**
 *
 */
public class ArmSolenoid {
	public final static DoubleSolenoid arm = new DoubleSolenoid(RobotMap.armmoduleNumber, RobotMap.armforwardChannel,RobotMap.armreverseChannel);
	public ArmSolenoid(int moduleNumber, int forwardChannel, int reverseChannel) {
		
		// TODO Auto-generated constructor stub. We tried taking this out and it yelled at us.
		//it only wants ONE number in the super line, 2 or 3 and it gets angry saying that super must be the first line.
	
		

//instantiate the arm solenoid is in the commands.
	}


/*	public void initTable(ITable subtable) {
		// TODO Auto-generated method stub
		
	}




	public ITable getTable() {
		// TODO Auto-generated method stub
		return null;
	}




	public String getSmartDashboardType() {
		// TODO Auto-generated method stub
		return null;	} */
	
	}


