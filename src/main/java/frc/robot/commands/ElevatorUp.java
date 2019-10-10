/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElevatorUp extends Command {
  public ElevatorUp() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Elevator);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    

    if (Robot.Elevator.getLimitTop()) {

      Robot.elevTop = true;
      Robot.firstElevBottom = true;

      Robot.Elevator.elevatorHold();

    } /*else if (Robot.Elevator.getLimitBottom()) {

      Robot.Elevator.elevatorUp();
      Robot.elevBottom = true;
      Robot.firstElevTop = true;
      
    } */ else {

      Robot.Elevator.elevatorUp();
      Robot.elevBottom = false;
      Robot.elevTop = false;
      Robot.firstElevTop = true;
      Robot.firstElevBottom = true;

    }
  
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

    Robot.Elevator.elevatorStop();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    
    Robot.Elevator.elevatorStop();

  }
}
