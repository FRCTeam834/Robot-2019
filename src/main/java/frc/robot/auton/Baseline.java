/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Baseline extends Command {

  final double DISTANCEFORWARD = 200;

  public Baseline() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.DriveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.DriveTrain.stop();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.DriveTrain.setDrive(.5, .5);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    if ((Robot.DriveTrain.getLeftEncoder() > DISTANCEFORWARD) && (Robot.DriveTrain.getRightEncoder() > DISTANCEFORWARD)) {

      return true;

    }

    return false;

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Robot.DriveTrain.stop();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    Robot.DriveTrain.stop();

  }

}
