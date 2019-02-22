/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class ElevatorHold extends Command {
  public ElevatorHold() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
    Robot.Elevator.elevatorHold();
    //System.out.println("Elevator Hold Command Initialized");

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    SmartDashboard.putString("DB/String 2", "Left:" + Double.toString(Robot.Elevator.getElevatorHeight()));
    
    if (Robot.Elevator.getLimitTop()) {

      Robot.elevTop = true;

    } else if (Robot.Elevator.getLimitBottom()) {

      Robot.elevBottom = true;

    } else {

      Robot.elevBottom = false;
      Robot.elevTop = false;

    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    //System.out.println("The encoder value for the elevator is..." + Robot.Elevator.getElevatorHeight());
    Robot.Elevator.elevatorHold();;

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    Robot.Elevator.elevatorStop();

  }
}
