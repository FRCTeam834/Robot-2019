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

    //Pushing code
    /*
    double lMorePower = leftSpeed * 1; //Factor to increase by
    double rMorePower = rightSpeed * 1; //Factor to increase by

    int speedThreshold = 1; //Needs testing to find perfect value

    if (Math.abs(leftSpeed) > 0.05 || Math.abs(rightSpeed) > 0.05) {

      double lSpeed = 1; //Do some stuff to figure out encoder changes
      double rSpeed = 1;

      if (leftSpeed > 0.05 && lSpeed < leftSpeed * speedThreshold) { //If set speed is on and motor has resistance
        //increase value
        leftSpeed = leftSpeed + lMorePower;

        if (leftSpeed < 1){ //Makes sure the set speed doesn't go past 1
          leftSpeed = 1;
        }
      }
      else if (leftSpeed < 0.05 && lSpeed * -1 > leftSpeed * speedThreshold) { //If set speed is on and motor has resistance
        //decrease value
        leftSpeed = leftSpeed - lMorePower;

        if (leftSpeed < -1){  //Makes sure the set speed doesn't go past -1
          leftSpeed = -1;
        }
      }

      if (rightSpeed > 0.05 && rSpeed < rightSpeed * speedThreshold) { //If set speed is on and motor has resistance
        //increase value
        rightSpeed = rightSpeed + rMorePower;

        if (rightSpeed > 1){  //Makes sure the set speed doesn't go past 1
          rightSpeed = 1;
        }
      }
      else if (rightSpeed < 0.05 && rSpeed * -1 > rightSpeed * speedThreshold){ //If set speed is on and motor has resistance
        //decrease value
        rightSpeed = rightSpeed - rMorePower;

        if (rightSpeed < -1){  //Makes sure the set speed doesn't go past -1
          rightSpeed = -1;
        }
      }


      Robot.DriveTrain.setDrive((leftSpeed * .75), (rightSpeed * .75));

    }
    */

    Robot.DriveTrain.setDrive((leftSpeed * .75), (rightSpeed * .75));

   // }    

    
    //System.out.println(roll);

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
