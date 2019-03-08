/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import org.opencv.core.KeyPoint;

//import java.util.ArrayList;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.MyVisionPipeline;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class AutoDrive extends Command {
    




  public AutoDrive() { // Use requires() here to declare subsystem dependencies
   // eg. requires(chassis); requires(Robot.DriveTrain);
   
   
  }
    
    // Called just before this Command runs the first time
    
  @Override protected void initialize() {
    
    Robot.DriveTrain.setDrive(0, 0); // may need to comment this line out
    if (Robot.autoDriveOn) {

      Robot.autoDriveOn = false;

    } else if (!Robot.autoDriveOn) {

      Robot.autoDriveOn = true;

    }
    
  }
    
    // Called repeatedly when this Command is scheduled to run
    
  @Override protected void execute() {
    
    //Sets the joystick //Movement Algorithms
  
    System.out.println("AimAssist Activated"); 
    KeyPoint[] aMat = Robot.MyVisionPipeline.findBlobsOutput().toArray();
    double[][] targetLocation = new double[4][2];
    for(int i = 0; i < aMat.length; i++){
        targetLocation[i][0] = aMat[i].pt.x;
        targetLocation[i][1] = aMat[i].pt.y;
    } 
    int numBlocks = aMat.length;
    double avgX;
    final int centerScreen = 0; //Center of Screen
    
    if (!(targetLocation[0][0] == -1)) {
      System.out.println("x: " + (targetLocation[0][0])); 
      SmartDashboard.putString("DB/String 0", Double.toString(targetLocation[0][0]));
      SmartDashboard.putString("DB/String 8", Integer.toString(numBlocks));
      System.out.println("y: " + (targetLocation[0][1])); 
    } 
    else {
      Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 1);
      Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 1); 
    }
    if(targetLocation[0][0] == 1){ 
      if(numBlocks == 1){ 
        if(targetLocation[0][0] > centerScreen){
        System.out.println("Turning Right (1 Block w/ Alignment)"); 
        } 
        else if(targetLocation[0][0] < centerScreen){
          System.out.println("Turning Left (1 Block w/ Alignment)"); } 
        else {
          System.out.println("No Idea");
          Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 1);
          Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 1); 
        } 
      } 
      else if(numBlocks == 2){
        avgX = (targetLocation[0][0] + targetLocation[1][0])/ 2; 
        if(avgX < centerScreen){ 
          System.out.println("Turning Right (2 Blocks w/ Alignment)"); 
        }
        else if(avgX > centerScreen){
          System.out.println("Turning Left (2 Blocks w/ Alignment)"); 
        } 
        else {
          System.out.println("No Idea");
          Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 1);
          Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 1); 
        } 
      } 
     else{ 
        System.out.println("Too Many Blocks");
        Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 1);
        Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 1); 
      } 
    }  
  }
    
    
  // Make this return true when this Command no longer needs to run execute()
   
  @Override protected boolean isFinished() {
   
    //if (Robot.autoDriveOn) {

      //return true;

    //4}

    if (Math.abs(Robot.oi.leftJoystick.getY()) > .15) {

      return true;

    } else if (Math.abs(Robot.oi.rightJoystick.getY()) > .15) {

      return true;

    }

    return false;
   
  }

   // Called once after isFinished returns true
   
  @Override protected void end() {
   
  }
   
   // Called when another command which requires one or more of the same 
   // subsystems is scheduled to run
   
  @Override protected void interrupted() { 
    System.out.println("Auto DriveTrain interrupted a.k.a. Ryan deleted the autons"); 
  }
}