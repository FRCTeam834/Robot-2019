/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.ArmHold;

/**
 * Add your docs here.
 */

public class Arm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //WPI_TalonSRX arm = new WPI_TalonSRX(11);
  WPI_VictorSPX arm = new WPI_VictorSPX(Constants.ARM_MOTOR_PORT);
  DigitalInput armLimit = new DigitalInput(Constants.ARM_LIMIT_SWITCH_PORT);
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ArmHold());
  }
  


  public void armUp() {

    arm.set(Constants.ARM_UP_SPEED);
    

  }

  public void armDown() {

    arm.set(Constants.ARM_DOWN_SPEED);

  }

  public void armStop() {

    arm.set(Constants.ARM_STOP_SPEED);

  }

  public void armHold() {

    arm.set(Constants.ARM_HOLD_SPEED);
  }

  public void setArm(double speed) {

    arm.set(speed);

  }

  public boolean isArmDown() {

    return !(armLimit.get());

  }


}
