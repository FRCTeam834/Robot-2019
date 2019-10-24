/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;

public class DriveRamp extends Command {

  private double initTime = 0;
  private double timeToRamp = 2;
  private boolean isRamped = false;

  public DriveRamp() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.DriveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    initTime = RobotController.getFPGATime() / 1000000; // This gets microseconds from the FPGA, then converts it into
                                                        // seconds.

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double currentTime = RobotController.getFPGATime() / 1000000; // Current time in seconds
    double timeDifference = currentTime - initTime; // Time passed since start of command
    if (timeDifference >= timeToRamp) {

      isRamped = true;
      isFinished();

    }

    double leftSpeed = Robot.oi.leftJoystick.getY();
    double rightSpeed = Robot.oi.rightJoystick.getY();

    leftSpeed = (Math.abs(leftSpeed) < 0.15) ? 0 : leftSpeed;
    rightSpeed = (Math.abs(rightSpeed) < 0.15) ? 0 : rightSpeed;

    double multiplier = 0;
    multiplier = (.5 / timeToRamp) * currentTime;

    if (currentTime >= timeToRamp) {

      multiplier = .5;

    }

    Robot.DriveTrain.setDrive((leftSpeed * (.25 + multiplier)), (rightSpeed * (.25 + multiplier)));

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    return isRamped;

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Robot.Drive.start();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    Robot.DriveTrain.stop();

  }
}
