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
    
    //float roll = Robot.NavX.roll();

    //if (roll >= 45) {
       //Alex
       //leftSpeed = (Math.abs(leftSpeed) < 0.15)? 0 : leftSpeed;
       //rightSpeed = (Math.abs(rightSpeed)< 0.15)? 0  : rightSpeed;

     // leftSpeed = -.6;
      //rightSpeed = -.6;
    
   // }
    //else if (roll <= -45) {

     // leftSpeed = .6;
     // rightSpeed = .6;

   // } else {
      
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
