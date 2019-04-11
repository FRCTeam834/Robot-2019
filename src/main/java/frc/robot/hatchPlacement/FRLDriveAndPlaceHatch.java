/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hatchPlacement;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FRLDriveAndPlaceHatch extends Command {

  public double motorSpeed = .25;

  public boolean success = false;
  public boolean tookStartingEncoder = false;
  public boolean finalEncoderDiff = false;
  public double startingEncoderValue = 0;
  public double endingEncoderValue = 0;
  public double encoderChange = 0;

  public FRLDriveAndPlaceHatch() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.DriveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.DriveTrain.stop();
    Robot.Arm.armStop();
    Robot.Elevator.elevatorHold();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.DriveTrain.setDrive(motorSpeed, motorSpeed);

    /* EXPERIMENTAL, WOULD NOT WORK
    
    if (!tookStartingEncoder) {

      startingEncoderValue = Robot.DriveTrain.getLeftEncoder();
      tookStartingEncoder = true;
      finalEncoderDiff = true;

    }

    if (finalEncoderDiff) {

      endingEncoderValue = Robot.DriveTrain.getLeftEncoder();
      encoderChange = endingEncoderValue - startingEncoderValue;

    }

    */

    if (Robot.oi.xboxLB.get()) { //Once they see the hatch is in the correct position, it continues on.

      success = true;

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

    //This command should end with the back left button on the xbox controller.

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    //This command can be overridden

  }
}
