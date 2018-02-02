package org.usfirst.frc4786.RobotBuilderTest1.subsystems;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.RobotMap;
import org.usfirst.frc4786.RobotBuilderTest1.commands.DisplayAutonomous;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArduinoInterface extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static I2C wire;
	//if we have multiple arduinos, they could have different ports
	public ArduinoInterface(int port){
		wire = new I2C(Port.kOnboard, port);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    public void connectToArduino()
    {	
    	Robot.arduinoLCDInterface.writeStringData("init");
    	// Arduino my love, Wakey, Wakey!
    	System.out.println("Wake Up Arduino!");
    	// Senpai has noticed me! XD
    }
    
    public void writeStringData(String writeable){
    	String WriteString = writeable;
    	char[] CharArray;
    	CharArray = WriteString.toCharArray();
    	byte[] WriteData = new byte[CharArray.length];
    	for (int i = 0; i < CharArray.length; i++) {
    		WriteData[i] = (byte) CharArray[i];
    	}
    	wire.writeBulk(WriteData);
    	WriteData = null;
    }
    
    /* Doesn't Work at The Moment
    public String readStringData(){
    	byte[] data = new byte[8];
    	char[] charArray = new char[8];
    	wire.read(8, 8, data);
    	for(int i = 0; i < 8; i++){
    		charArray[i] = (char) data[i];
    	}
    	String result = String.copyValueOf(charArray);
    	return result;
    }
    */
    
    public void sendPlayToArduino()
    {
       	Robot.arduinoLCDInterface.writeStringData("0, " + Robot.autoChooser.getPlayString());
    }
    
    public void sendPosToArduino()
    {
    	Robot.arduinoLCDInterface.writeStringData("1, " + Robot.autoChooser.getPositionString());
    }
    
}

