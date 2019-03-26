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
import frc.robot.commands.ArmHold;

/**
 * Add your docs here.
 */

public class Arm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //WPI_TalonSRX arm = new WPI_TalonSRX(11);
  WPI_VictorSPX arm = new WPI_VictorSPX(8);
  DigitalInput armLimit = new DigitalInput(4);


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ArmHold());
  }
  


  public void armUp() {

    arm.set(-.8);
    

  }

  public void armDown() {

    arm.set(.8);

  }

  public void armStop() {

    arm.set(0);

  }

  public void armHold() {

    arm.set(0);
  }

  public void setArm(double speed) {

    arm.set(speed);

  }

  public boolean isArmDown() {

    return !(armLimit.get());

  }


}
