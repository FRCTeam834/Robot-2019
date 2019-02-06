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
import frc.robot.commands.ElevatorStop;

/**
 * Add your docs here.
 */

public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX elevator = new WPI_TalonSRX(9);
  Encoder elevEncoder = new Encoder(0, 1);
  float spoolCircumference = (PI * 4); // Fix with actual calculations

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ElevatorHold());
  }

  public void elevatorUp() {

    elevator.set(.75);

  }

  public void elevatorDown() {

    elevator.set(-.25);

  }

  public void elevatorStop() {

    elevator.set(0);

  }

  public void elevatorHold() {

    elevator.set(.15);
  }

  public void setElevator(double speed) {

    elevator.set(speed);

  }

  public double elevatorHeight() {
    double position = elevEncoder.getDistance();
    // Math to find height
    double currentHeight = position * spoolCircumference;
    return currentHeight;
  }

  public void moveToLocation(double desiredHeight) {

    double position = elevEncoder.getDistance();
    // Math to find height
    double currentHeight = position * spoolCircumference;
    double maxElevatorSpeed = .75; // Maximum movement speed

    if (currentHeight != desiredHeight) {
      if (currentHeight < desiredHeight) {
        // Set height is higher than current
        elevator.set(maxElevatorSpeed); // Both of these statements neeed to be fixed because the motor will ony be set
                                        // once
      } else if (currentHeight > desiredHeight) {
        // Set height is lower than current
        elevator.set(-1 * maxElevatorSpeed);
      } else {
        elevatorHold();
        System.out.println("Movement error, already at height");
      }

    }
  }

}
