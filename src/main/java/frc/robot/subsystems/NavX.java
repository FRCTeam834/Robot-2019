/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

//import java.lang.Object;
//import edu.wpi.first.wpilibj.SendableBase;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.navx.frc.AHRS;

/**
 * Add your docs here.
 */
public class NavX extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  AHRS NavXMXP;
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  protected void initialize() {
    NavXMXP = new AHRS(SPI.Port.kMXP);
    //NavXMXP.enableBoardlevelYawReset(false);
  }
  /*
  @Override
  public boolean lookupConnection() {

    return NavX.isConnected();

  }
  */

  public boolean isCalibrating() {

    return NavXMXP.isCalibrating();
  }

  public float pitch() {

    return NavXMXP.getPitch();
  }

  public float yaw() {

    return NavXMXP.getYaw();
  }

  public float roll() {

    return NavXMXP.getRoll();
  }

  public void reset() {
    //NavXMXP.enableBoardlevelYawReset(true);
    NavXMXP.reset();
    //NavXMXP.enableBoardlevelYawReset(false);
   }

}
