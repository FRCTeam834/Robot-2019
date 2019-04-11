/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Make sure to run NavX AutoCalibration with Omnimount:
// https://pdocs.kauailabs.com/navx-mxp/installation/omnimount/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.NavXUpdator;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SPI;
import com.kauailabs.navx.frc.AHRS;

/**
 * Add your docs here.
 */
public class NavX extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  AHRS ahrs = new AHRS(SPI.Port.kMXP);
  //DigitalInput tapeSensor = new DigitalInput(20);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new NavXUpdator());
  }

  public float getYaw() {

    return ahrs.getYaw();

  }

  public float getRoll() {

    return ahrs.getRoll();

  }

  public float getPitch() {

    return ahrs.getPitch();

  }

  public float getDisplacementX() {

    return ahrs.getDisplacementX();

  }

  public float getDisplacementY() {

    return ahrs.getDisplacementY();

  }

  public float getDisplacementZ() {

    return ahrs.getDisplacementZ();

  }

  public float getCurrentDegrees() {

    return ahrs.getCompassHeading();

  }

  public void resetYaw() {

    ahrs.reset();

  }

  public void resetDisplacement() {

    ahrs.resetDisplacement();

  }

  public boolean getTape() {

    return tapeSensor.get(); // Are we on top of white tape?

  }

}
