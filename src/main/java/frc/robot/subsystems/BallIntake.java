/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.BallIntakeStop;

/**
 * Add your docs here.
 */

public class BallIntake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX ballIntake = new WPI_TalonSRX(12);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new BallIntakeStop());
  }
  


  public void ballIntakeIn() {

    ballIntake.set(1);

  }

  public void ballIntakeOut() {

    ballIntake.set(-1);

  }

  public void ballIntakeStop() {

    ballIntake.set(0);
  }

  public void setBallIntake(double speed) {

    ballIntake.set(speed);

  }


}
