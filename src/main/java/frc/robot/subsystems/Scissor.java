/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.ScissorStop;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/*
 * Add your docs here.
 */
public class Scissor extends Subsystem {

  // WPI_TalonSRX scissor = new WPI_TalonSRX(7);
  WPI_VictorSPX scissor = new WPI_VictorSPX(Constants.BACK_SCREW_MOTOR_PORT);
  DigitalInput scissorBottom = new DigitalInput(Constants.BACK_SCREW_LIMIT_SWITCH_BOTTOM_PORT);
  DigitalInput scissorTop = new DigitalInput(Constants.backScrewLimitSwitchTopPort);

  @Override
  public void initDefaultCommand() {

    setDefaultCommand(new ScissorStop());
    // Set the default command for a subsystem here.
  }

  public void setScissor(double speed) {

    scissor.set(speed);

  }

  public void stop() {

    setScissor(Constants.BACK_SCREW_STOP_SPEED);

  }

  public boolean scissorsClosed() {

    return !(scissorTop.get());

  }

  public boolean scissorsOpened() {

    return !(scissorBottom.get());

  }

  public void scissorHold() {

    scissor.set(Constants.BACK_SCREW_HOLD_SPEED);

  }

}
