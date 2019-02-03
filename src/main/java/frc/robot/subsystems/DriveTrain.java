/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Drive;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;

//import edu.wpi.first.wpilibj.Spark;
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


  CANSparkMax leftDrive1 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushed);
  CANSparkMax leftDrive2 = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushed);
  CANSparkMax leftDrive3 = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushed);
  CANSparkMax rightDrive1 = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushed);
  CANSparkMax rightDrive2 = new CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushed);
  CANSparkMax rightDrive3 = new CANSparkMax(6, CANSparkMaxLowLevel.MotorType.kBrushed);  

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

  CANSparkMax leftDrive1 = new CANSparkMax(1, CANSparkMax.MotorType.kBrushless);
  CANSparkMax leftDrive2 = new CANSparkMax(2, CANSparkMax.MotorType.kBrushless);
  CANSparkMax leftDrive3 = new CANSparkMax(3, CANSparkMax.MotorType.kBrushless);
  CANSparkMax rightDrive1 = new CANSparkMax(4, CANSparkMax.MotorType.kBrushless);
  CANSparkMax rightDrive2 = new CANSparkMax(5, CANSparkMax.MotorType.kBrushless);
  CANSparkMax rightDrive3 = new CANSparkMax(6, CANSparkMax.MotorType.kBrushless);
  //WPI_TalonSRX lefSrx = new WPI_TalonSRX(7);
  //WPI_TalonSRX ballIntakeSrx = new WPI_TalonSRX(8);

  /*
  //Future motor assignments
  WPI_TalonSRX name = new WPI_TalonSRX(10);
  WPI_TalonSRX name = new WPI_TalonSRX(11);
  WPI_TalonSRX name = new WPI_TalonSRX(12);
  */

  SpeedControllerGroup leftDriveGroup = new SpeedControllerGroup(leftDrive1, leftDrive2, leftDrive3);
  SpeedControllerGroup rightDriveGroup = new SpeedControllerGroup(rightDrive1, rightDrive2, rightDrive3);
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Drive());
  }

  public void leftDrive(double speed) {
    leftDriveGroup.set(speed);

  }

  public void rightDrive(double speed) {

    rightDriveGroup.setInverted(true);
    rightDriveGroup.set(speed);

  }

  public void setDrive(double leftSpeed, double rightSpeed) {
    
    leftDrive(leftSpeed);
    rightDrive(rightSpeed);

  }

  public void stop() {

    leftDrive(0);
    rightDrive(0);

  }

  public double getLeftEncoder() {

    return (leftDrive1.getEncoder().getPosition() + leftDrive2.getEncoder().getPosition() + leftDrive3.getEncoder().getPosition()) / 3;

  }

  public double getRightEncoder() {

     return (rightDrive1.getEncoder().getPosition() + rightDrive2.getEncoder().getPosition() + rightDrive3.getEncoder().getPosition()) / 3;

  }












}
