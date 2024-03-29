/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ScissorStop extends Command {
  
  public ScissorStop() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Scissor);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

      Robot.Scissor.setScissor(0);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    if (Robot.holdScissor) {

      Robot.Scissor.scissorHold();

    }

    if (!Robot.holdScissor) {

      Robot.Scissor.stop();

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
    Robot.Scissor.setScissor(0);
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.Scissor.setScissor(0);
    System.out.println("ScissorUp interrupted");
  }
}
