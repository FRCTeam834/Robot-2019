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

public class ElevatorPreset6 extends Command {
  
  boolean success = false;
  final double TARGETHEIGHT = 150; //Change to wanted height

  public ElevatorPreset6() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.Elevator.elevatorStop();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    SmartDashboard.putString("DB/String 1", "Elev:" + Double.toString(Robot.Elevator.getElevatorHeight()));
    
    if (((Robot.Elevator.getElevatorHeight()) > TARGETHEIGHT - 10 ) && ((Robot.Elevator.getElevatorHeight()) < TARGETHEIGHT + 10)) {

      success = true;
      isFinished();

    } else if ((Robot.Elevator.getElevatorHeight()) > TARGETHEIGHT ) {

      Robot.Elevator.elevatorDown();
      success = false;

    } else if ((Robot.Elevator.getElevatorHeight() < TARGETHEIGHT)) {

      Robot.Elevator.elevatorUp();










      success = false;

    }

    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    if (success) {

      return true;

    }

    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Robot.Elevator.elevatorHold();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    Robot.Elevator.elevatorHold();

  }

}
