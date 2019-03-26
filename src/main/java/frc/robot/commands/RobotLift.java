/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RobotLift extends Command {
  public RobotLift() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Scissor);
    requires(Robot.LeadScrew);
    requires(Robot.ScrewWheels);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.Scissor.stop();
    Robot.LeadScrew.screwHer_IBarelyKnowHer();
    Robot.ScrewWheels.screwStandingStill();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.ScrewWheels.screwStandingStill();
    Robot.LeadScrew.screwHer();
    Robot.Scissor.setScissor(1);

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


    
  }
}
