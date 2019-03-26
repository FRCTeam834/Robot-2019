/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StopAllClimbing extends Command {
  public StopAllClimbing() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.LeadScrew);
    requires(Robot.ScrewWheels);
    requires(Robot.Scissor);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.LeadScrew.screwHer_IBarelyKnowHer();
    Robot.ScrewWheels.screwStandingStill();
    Robot.Scissor.stop();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.LeadScrew.screwHer_IBarelyKnowHer();
    Robot.ScrewWheels.screwStandingStill();
    Robot.Scissor.stop();
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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
