/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/*
Naming Convention:

FRTurnonTape
FR = Front Rocket

*/

package frc.robot.hatchPlacement;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FRLTurnOnTape extends Command {

  public boolean success = false;

  public FRLTurnOnTape() {
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

    Robot.DriveTrain.snapToAngle(-45);

    /* Just in case
     * if (Robot.YAW > -45 && Robot.YAW < 90) { // Right Turn
     * 
     * Robot.DriveTrain.pointTurnRight();
     * 
     * if (Robot.YAW == -45) {
     * 
     * Robot.DriveTrain.stop(); success = true;
     * 
     * }
     * 
     * } // Right Turn
     * 
     * else { // Left Turn
     * 
     * Robot.DriveTrain.pointTurnLeft();
     * 
     * if (Robot.YAW == -45) {
     * 
     * Robot.DriveTrain.stop(); success = true;
     * 
     * }
     * 
     * } // Left Turn
     */

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    if (!Robot.onTape) {

      return true;

    }

    if (success) {

      return true;

    }

    if (Robot.YAW == -45) {

      return true;

    }

    return false;

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    success = false;

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    success = false;

  }
}
