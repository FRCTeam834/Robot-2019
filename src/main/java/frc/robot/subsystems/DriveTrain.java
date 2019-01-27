/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Drive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;



/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  /*
  TalonSRX stuff
  WPI_TalonSRX leftDrive1 = new WPI_TalonSRX(1);
  WPI_TalonSRX leftDrive2 = new WPI_TalonSRX(2);
  WPI_TalonSRX leftDrive3 = new WPI_TalonSRX(3);
  WPI_TalonSRX rightDrive1 = new WPI_TalonSRX(4);
  WPI_TalonSRX rightDrive2 = new WPI_TalonSRX(5);
  WPI_TalonSRX rightDrive3 = new WPI_TalonSRX(6);


  8 wheel bot sparks
  Spark leftDrive1 = new Spark(1);
  Spark leftDrive2 = new Spark(2);
  Spark leftDrive3 = new Spark(3);
  Spark rightDrive1 = new Spark(4);
  Spark rightDrive2 = new Spark(5);
  Spark rightDrive3 = new Spark(6);


  SpeedControllerGroup leftDriveGroup = new SpeedControllerGroup(leftDrive1, leftDrive2, leftDrive3);
  SpeedControllerGroup rightDriveGroup = new SpeedControllerGroup(rightDrive1, rightDrive2, rightDrive3);

  
  WPI_TalonSRX leftDrive1 = new WPI_TalonSRX(0);
  WPI_TalonSRX leftDrive2 = new WPI_TalonSRX(1);
  WPI_TalonSRX rightDrive1 = new WPI_TalonSRX(2);
  WPI_TalonSRX rightDrive2 = new WPI_TalonSRX(3); 

*/
  Spark leftDrive1 = new Spark(1);
  Spark leftDrive2 = new Spark(2);
  Spark leftDrive3 = new Spark(3);
  Spark rightDrive1 = new Spark(4);
  Spark rightDrive2 = new Spark(5);
  Spark rightDrive3 = new Spark(6);

  SpeedControllerGroup leftDriveGroup = new SpeedControllerGroup(leftDrive1, leftDrive2);
  SpeedControllerGroup rightDriveGroup = new SpeedControllerGroup(rightDrive1, rightDrive2);

  @Override
  public void initDefaultCommand() {
    leftDriveGroup.setInverted(true);
    // Set the default command for a subsystem here.
    setDefaultCommand(new Drive());
  }

  public void leftDrive(double speed) {

    leftDriveGroup.set(speed);

  }

  public void rightDrive(double speed) {

    rightDriveGroup.set(speed);

  }

  public void setDrive(double leftSpeed, double rightSpeed) {

    leftDriveGroup.set(leftSpeed);
    rightDriveGroup.set(rightSpeed);

  }

  public void stop() {

    leftDriveGroup.set(0);
    rightDriveGroup.set(0);

  }

  public double getLeftEncoder() {

    double average = (leftDrive1.getPosition() + leftDrive2.getPosition() + leftDrive3.getPosition()) / 3;
  
    return average;

  }

  public double getRightEncoder() {

    double average = (rightDrive1.getPosition() + rightDrive2.getPosition() + rightDrive3.getPosition()) / 3;
  
    return average;

  }












}
