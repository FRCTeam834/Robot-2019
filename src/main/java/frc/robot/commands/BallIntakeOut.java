/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/








//WE ARE NOT USING THIS COMMAND











package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BallIntakeOut extends Command {
  public BallIntakeOut() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.BallIntake);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.BallIntake.ballIntakeOut();
  
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {


  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.BallIntake.ballIntakeStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    
    Robot.BallIntake.ballIntakeStop();

  }
}
