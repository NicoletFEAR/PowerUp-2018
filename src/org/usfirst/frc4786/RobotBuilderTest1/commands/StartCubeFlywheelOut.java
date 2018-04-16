package org.usfirst.frc4786.RobotBuilderTest1.commands;

import org.usfirst.frc4786.RobotBuilderTest1.Robot;
import org.usfirst.frc4786.RobotBuilderTest1.subsystems.Cube;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class StartCubeFlywheelOut extends InstantCommand {

	public double speed;
	
    public StartCubeFlywheelOut(double inSpeed) {
        super();
        // Use requires() here to declare subsystem dependencies
        requires(Robot.cubeMech);
        speed = inSpeed;
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.cubeMech.cubeFlywheelOutSpeed(speed);
    }

}
