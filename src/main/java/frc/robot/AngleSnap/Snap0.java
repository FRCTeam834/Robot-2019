/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.AngleSnap;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot; 

public class Snap0 extends Command {

  boolean success = false;

  public Snap0() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.DriveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    /*if (Robot.YAW >= 0) { // Right Turn

      Robot.DriveTrain.pointTurnRight();

      if ((Robot.YAW < (3)) && (Robot.YAW > (-3))) {

        Robot.DriveTrain.stop();
        success = true;

      }

    } // Right Turn

    

    else if (Robot.YAW < 0) { // Left Turn

      Robot.DriveTrain.pointTurnLeft();

      if ((Robot.YAW < (3)) && (Robot.YAW > (-3))) {

        Robot.DriveTrain.stop();
        success = true;

      } 

    }*/

    Robot.DriveTrain.snapToAngle(0);


  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    if (success) {

      return true;

    }

    if (Robot.oi.xboxBack.get()) {

      return true;
      
    }

    if ((Robot.YAW < (3)) && (Robot.YAW > (-3))) {

      return true;

    }

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
  }
}
