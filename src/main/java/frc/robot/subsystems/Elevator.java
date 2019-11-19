/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Constants;
import frc.robot.commands.ElevatorHold;

/**
 * Add your docs here.
 */

public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // WPI_TalonSRX elevator = new WPI_TalonSRX(9);
  WPI_VictorSPX elevator = new WPI_VictorSPX(Constants.elevatorMotorPort);
  Encoder elevEncoder = new Encoder(Constants.elevatorEncoderPortA, Constants.elevatorEncoderPortB);
  // DigitalInput photoEye = new DigitalInput(2);
  DigitalInput limitBottom = new DigitalInput(Constants.elevatorLimitSwitchBottomPort);
  DigitalInput limitTop = new DigitalInput(Constants.elevatorLimitSwitchTopPort);

  // double spoolCircumference = (pi * 4); // Fix with actual calculations

  public Elevator() {
    elevEncoder.reset();
    elevEncoder.setDistancePerPulse(1); // Might need to be set
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ElevatorHold());
  }

  public void elevatorUp() {

    elevator.set(Constants.elevatorUpSpeed);

  }

  public void elevatorDown() {

    elevator.set(Constants.elevatorDownSpeed);

  }

  public void elevatorStop() {

    elevator.set(Constants.elevatorStopSpeed);

  }

  public void elevatorHold() {

    elevator.set(Constants.elevatorHoldSpeed);
  }

  public void setElevator(double speed) {

    elevator.set(speed);

  }

  public double getElevatorHeight() {

    double value = elevEncoder.getDistance(); // Encoder value is flipped to positive

    value = value * -1;

    return value;

  }

  public void encoderReset() {

    elevEncoder.reset();

  }

  public boolean getLimitBottom() {

    return !(limitBottom.get());

  }

  public boolean getLimitTop() {

    return (limitTop.get());

  }

}
