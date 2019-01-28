/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoDrive extends Command {
  
  public AutoDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.DriveTrain);
    requires(Robot.ArduinoPixy);
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.DriveTrain.setDrive(0, 0); // may need to comment this line out
    

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    //Sets the joystick

   
        System.out.println("AimAssist Activated");

        ArrayList<String> targetLocation = Robot.ArduinoPixy.returnValues();
        
      if (!(targetLocation.get(1).equalsIgnoreCase("x"))) {

        System.out.println("x: " + Integer.parseInt(targetLocation.get(1)));
        System.out.println("y: " + Integer.parseInt(targetLocation.get(2)));
        System.out.println("width: " + Integer.parseInt(targetLocation.get(3)));
        System.out.println("height: " + Integer.parseInt(targetLocation.get(4)));

      } else if ((targetLocation.get(1).equalsIgnoreCase("no"))) {

        Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 1);
        Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 1);
      }

      



  }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    
    return false;

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    System.out.println("Auto DriveTrain interrupted a.k.a. Ryan deleted the autons");
  }
}
