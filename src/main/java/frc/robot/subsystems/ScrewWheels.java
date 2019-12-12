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
import frc.robot.Constants;
import frc.robot.commands.ScrewWheelsStop;

/**
 * Add your docs here.
 */
public class ScrewWheels extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_VictorSPX screwWheels = new WPI_VictorSPX(Constants.BACK_SCREW_WHEELS_MOTOR_PORT);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ScrewWheelsStop());
  }

  public void screwTheFront() {

    screwWheels.set(Constants.BACK_SCREW_WHEELS_FORWARD_SPEED);

  }

  public void screwTheBack() {

    screwWheels.set(Constants.BACK_SCREW_WHEELS_BACKWARDS_SPEED);

  }

  public void screwStandingStill() {

    screwWheels.set(Constants.BACK_SCREW_WHEELS_STOP_SPEED);

  }
}
