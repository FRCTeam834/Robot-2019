/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

/**
 * Add your docs here.
 */
public class NavX extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  AHRS NavX = new AHRS(SPI.Port.kMXP);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  protected void initialize() {
    NavX.enableBoardlevelYawReset(false);
  }

  @Override
  public boolean lookupConnection() {

    return NavX.isConnected();

  }

  public boolean isCalibrating() {

    return NavX.isCalibrating();
  }

  public int pitch() {

    return NavX.getPitch();
  }

  public int yaw() {

    return NavX.getYaw();
  }

  public int roll() {

    return NavX.getRoll;
  }

  public void reset() {
    NavX.enableBoardlevelYawReset(true);
    NavX.reset;
    NavX.enableBoardlevelYawReset(false);
   }

}
