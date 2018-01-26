package org.usfirst.frc4786.RobotBuilderTest1.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;  
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;

public class VisionNTableValueSet {

	NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("datatable");
    NetworkTableEntry xEntry = table.getEntry("x");
    NetworkTableEntry yEntry = table.getEntry("y");
    
    double x = xEntry.getDouble(0.0);
    double y = yEntry.getDouble(0.0);
    //System.out.println("X: " + x + " Y: " + y);
    
    
}
