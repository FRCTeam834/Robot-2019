/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ScrewIn extends Command {
  public ScrewIn() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.LeadScrew);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.LeadScrew.screwYourself();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.LeadScrew.screwYourself();

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    return false;
    
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Robot.LeadScrew.screwHer_IBarelyKnowHer();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    Robot.LeadScrew.screwHer_IBarelyKnowHer();

  }
}
