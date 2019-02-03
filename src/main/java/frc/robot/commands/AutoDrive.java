/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

//import java.util.ArrayList;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoDrive extends Command {
  
  public AutoDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.DriveTrain);
    requires(Robot.ArduinoPixy);
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.DriveTrain.setDrive(0, 0); // may need to comment this line out
    

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    //Sets the joystick
    //Movement Algorithms
   
        System.out.println("AimAssist Activated");

        int[][] targetLocation = Robot.ArduinoPixy.returnValues();
        boolean alignment = Robot.GroundEye.findTape();
        int numBlocks = Robot.ArduinoPixy.returnTotalBlocks(); //Placeholder
        int avgX;
        int centerPixy = 160; //Center of Pixy
        
      if (!(targetLocation[0][0] == -1)) {

        System.out.println("x: " + (targetLocation[0][1]));
        System.out.println("y: " + (targetLocation[0][2]));
        System.out.println("width: " + (targetLocation[0][3]));
        System.out.println("height: " + (targetLocation[0][4]));

      } else {

        Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 1);
        Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 1);
      }

      if(alignment){
        if(numBlocks == 1){
          if(targetLocation[0][1] > centerPixy){
            System.out.println("Turning Right (1 Block w/ Alignment)");
          }
          else if(targetLocation[0][1] < centerPixy){
            System.out.println("Turning Left (1 Block w/ Alignment)");
          }
          else{
            System.out.println("No Idea");
            Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 1);
            Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 1);
          }
        }
        if(numBlocks == 2){
          avgX = (targetLocation[0][1] + targetLocation[1][1])/ 2;
          if(avgX < centerPixy){
            System.out.println("Turning Right (2 Blocks w/ Alignment)");
          }
          else if(avgX > centerPixy){
            System.out.println("Turning Left (2 Blocks w/ Alignment)");
          }
          else {
            System.out.println("No Idea");
            Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 1);
            Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 1);
          }
        }
        if(numBlocks == 3 || numBlocks == 4){
          System.out.println("Too Many Blocks");
          Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 1);
          Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 1);
        }
      }
      else if(!alignment){
        if(numBlocks == 1){
          if(targetLocation[0][1] > centerPixy){
            System.out.println("Turning Right (1 Block No Alignment)");
          }
          else if(targetLocation[0][1] < centerPixy){
            System.out.println("Turning Left (1 Block No Alignment)");
          }
          else{
            System.out.println("No Idea"); //Do Nothing
            Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 1);
            Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 1);
          }
        }
        if(numBlocks == 2){
          avgX = (targetLocation[0][1] + targetLocation[1][1])/ 2;
          if(avgX < centerPixy){
            System.out.println("Turning Right (2 Blocks No Alignment)");
          }
          else if(avgX > centerPixy){
            System.out.println("Turning Left (2 Blocks No Alignment)");
          }
          else {
            System.out.println("No Idea"); //Do Nothing
            Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 1);
            Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 1);
          }
        }
        if(numBlocks == 3 || numBlocks == 4){
          
          System.out.println("Too Many Blocks");
          Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 1);
          Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 1);
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
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    System.out.println("Auto DriveTrain interrupted a.k.a. Ryan deleted the autons");
  }
}
