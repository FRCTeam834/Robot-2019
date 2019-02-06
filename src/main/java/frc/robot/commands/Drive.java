/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Drive extends Command {

  public Drive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.DriveTrain);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.DriveTrain.setDrive(0, 0);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double leftSpeed = Robot.oi.leftJoystick.getY();
    double rightSpeed = Robot.oi.rightJoystick.getY();

   // if (Math.abs(Robot.NavX.roll()) < 45) {
      // Alex
      // leftSpeed = (Math.abs(leftSpeed) < 0.15)? 0 : leftSpeed;
      // rightSpeed = (Math.abs(rightSpeed)< 0.15)? 0 : rightSpeed;

      // Christian
      leftSpeed = (Math.abs(leftSpeed) < 0.15) ? 0 : leftSpeed;
      rightSpeed = (Math.abs(rightSpeed) < 0.15) ? 0 : rightSpeed;
        /*
        if (leftSpeed >= 0) {
          leftSpeed = (Math.abs(leftSpeed) < 0.15) ? 0 : ((20/17) * leftSpeed) - (3/17) / 4;
        }
        else {
          leftSpeed = (Math.abs(leftSpeed) < 0.15) ? 0 : ((20/17) * leftSpeed) + (3/17) / 4;
        }
        if (rightSpeed >= 0) {
          rightSpeed = (Math.abs(rightSpeed) < 0.15) ? 0 : ((20/17) * rightSpeed) - (3/17) / 4;
        }
        else {
          rightSpeed = (Math.abs(rightSpeed) < 0.15) ? 0 : ((20/17) * rightSpeed) + (3/17) / 4;
        }
        */
      //Experimental
      if (Math.abs(Robot.NavX.pitch()) <= 25) {
        Robot.DriveTrain.setDrive(leftSpeed, rightSpeed);
      }
      else {
        Robot.DriveTrain.setDrive((leftSpeed * -1), (rightSpeed * -1));
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
    System.out.println("DriveTrain interrupted a.k.a. Ryan deleted the autons");
  }
}
