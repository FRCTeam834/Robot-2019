/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class NavXUpdator extends Command {
  public NavXUpdator() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.NavX);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.NavX.resetDisplacement();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.YAW = Robot.NavX.getYaw();
    Robot.xDisplacement = Robot.NavX.getDisplacementX();
    Robot.yDisplacement = Robot.NavX.getDisplacementY();
    Robot.zDisplacement = Robot.NavX.getDisplacementZ();
    Robot.degreeHeading = Robot.NavX.getCurrentDegrees();
    //Robot.onTape = Robot.NavX.getTape();

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    return false; // SHOULD NEVER FINISH

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    // SHOULD NEVER END

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    // SHOULD NEVER BE INTERRUPTED

  }
}
