/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ScissorDown extends Command {
  
  public ScissorDown() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Scissor);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    if (Robot.Scissor.scissorsClosed()) {

      Robot.Scissor.stop();

    } else {

    Robot.Scissor.setScissor(0.82);

    }

    //Robot.Scissor.setScissor(1);

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
    System.out.println("ScissorDown interrupted");
  }
}
