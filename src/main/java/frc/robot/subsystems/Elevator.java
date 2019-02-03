/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ElevatorStop;

/**
 * Add your docs here.
 */

public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX elevator = new WPI_TalonSRX(9);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ElevatorStop());
  }
  


  public void elevatorUp() {

    elevator.set(.75);

  }

  public void elevatorDown() {

    elevator.set(-.75);

  }

  public void elevatorStop() {

    elevator.set(0);

  }

  public void setElevator(double speed) {

    elevator.set(speed);

  }


}
