/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BallIntakeAll extends Command {

  public BallIntakeAll() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.BallIntake);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.BallIntake.ballIntakeStop();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    if ((Robot.oi.xbox.getRawAxis(3)) > .75) {

      if (Robot.BallIntake.haveBall()) {

        Robot.haveBall = true;
        Robot.BallIntake.ballIntakeStop();

      } else {

        Robot.haveBall = false;
        Robot.firstHaveBall = false;
        Robot.BallIntake.ballIntakeIn();

      }


    } else if ((Robot.oi.xbox.getRawAxis(2)) > .75) {

      Robot.BallIntake.ballIntakeOut();

      if (Robot.BallIntake.haveBall()) {

        Robot.haveBall = true;

      } else {

        Robot.haveBall = false;

      }

    } else {

      Robot.BallIntake.ballIntakeStop();

      if (Robot.BallIntake.haveBall()) {

        Robot.haveBall = true;

      } else {

        Robot.haveBall = false;

      }

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

    Robot.BallIntake.ballIntakeStop();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    
  }
}
