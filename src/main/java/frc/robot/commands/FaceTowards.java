/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FaceTowards extends Command {

  public double values[][];

  public FaceTowards() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.EVSNetworkTables);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("HI!");
    values = Robot.EVSNetworkTables.getHatches();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    values = Robot.EVSNetworkTables.getHatches();
    System.out.println(values[0][1] + ", " + values[0][2]);
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
