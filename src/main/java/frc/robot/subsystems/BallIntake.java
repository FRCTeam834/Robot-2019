/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.BallIntakeAll;

/**
 * Add your docs here.
 */

public class BallIntake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //WPI_TalonSRX ballIntake = new WPI_TalonSRX(12);
  WPI_VictorSPX ballIntake = new WPI_VictorSPX(Constants.BALL_INTAKE_MOTOR_PORT);
  //DigitalInput photoEye = new DigitalInput(4);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new BallIntakeAll());
  }
  


  public void ballIntakeIn() {

    ballIntake.set(Constants.BALL_INTAKE_IN_SPEED);

  }

  public void ballIntakeOut() {

    ballIntake.set(Constants.BALL_INTAKE_OUT_SPEED);

  }

  public void ballIntakeStop() {

    ballIntake.set(Constants.BALL_INTAKE_STOP_SPEED);
  }

  public void setBallIntake(double speed) {

    ballIntake.set(speed);

  }

  //public boolean haveBall() {

    //return !(photoEye.get());

  //}
  


}
