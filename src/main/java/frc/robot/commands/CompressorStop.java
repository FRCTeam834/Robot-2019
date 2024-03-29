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

public class CompressorStop extends Command {
  public CompressorStop() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Compressor);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.Compressor.compressorStop();
    Robot.Compressor.vacuumRelease();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.Compressor.compressorStop();
    Robot.Compressor.vacuumRelease();
    //System.out.println(Robot.Compressor.getPressure());
    //SmartDashboard.putString("DB/String 3", "CompOff:" + Double.toString(Robot.Compressor.getPressure()));
    Robot.isSucced = false;
    Robot.firstIsSucc = true;

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Robot.Compressor.compressorStop();
    Robot.Compressor.vacuumRelease();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    Robot.Compressor.compressorStop();
    Robot.Compressor.vacuumRelease();
    
  }
}
