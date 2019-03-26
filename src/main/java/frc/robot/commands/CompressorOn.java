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

public class CompressorOn extends Command {
  public CompressorOn() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Compressor);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.Compressor.compressorOn();
    Robot.Compressor.vacuumSucc();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    //Robot.lights = .85;

    double pressureReading = Robot.Compressor.getPressure();

    if (pressureReading >= 3.9) {

      Robot.Compressor.compressorOn();
      Robot.isSucced = false;
      Robot.firstIsSucc = true;
      SmartDashboard.putString("DB/String 5", "Sucking");
      Robot.lights = 0.69;

    } else if (pressureReading < 3.9) {

      //Robot.Compressor.compressorStop();
      Robot.isSucced = true;
      SmartDashboard.putString("DB/String 5", "Hatch Acquired");
      Robot.lights = 0.87;
    }

    Robot.Compressor.vacuumSucc();
    //System.out.println(Robot.Compressor.getPressure());
    //SmartDashboard.putString("DB/String 4", "CompOn:" + Double.toString(Robot.Compressor.getPressure()));

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Robot.Compressor.compressorOn();
    Robot.Compressor.vacuumSucc();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    Robot.Compressor.compressorOn();
    Robot.Compressor.vacuumSucc();

  }
}
