/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.commands.ElevatorHold;

/**
 * Add your docs here.
 */

public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  double pi = 3.14159265358979323846264338327950288;

  WPI_TalonSRX elevator = new WPI_TalonSRX(9);
  Encoder elevEncoder = new Encoder(8, 9);
  
  //double spoolCircumference = (pi * 4); // Fix with actual calculations
  

  public Elevator() {
    elevEncoder.reset();
    elevEncoder.setDistancePerPulse(1); //Might need to be set
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ElevatorHold());
  }

  public void elevatorUp() {

    elevator.set(1.0);

  }

  public void elevatorDown() {

    elevator.set(-1.0);

  }

  public void elevatorStop() {

    elevator.set(0);

  }

  public void elevatorHold() {

    elevator.set(.1);
  }

  public void setElevator(double speed) {

    elevator.set(speed);

  }

  public double getElevatorHeight() {

    double value = elevEncoder.getDistance(); //Encoder value is flipped to positive

    value = value * -1;

    return value;

  }

  public void encoderReset() {

    elevEncoder.reset();

  }

  public boolean getLimitTop() {

    return false;

  }

  public boolean getLimitBottom() {

    return false;

  }



}
