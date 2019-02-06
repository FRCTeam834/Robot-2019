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

  public NavX() {
    try {
      NavXMXP = new AHRS(SPI.Port.kMXP);
    }
    catch( RuntimeException ex ) {
      System.out.println("NavX start failed");
    }
    
    //NavXMXP.enableBoardlevelYawReset(false);
  }
  
  public boolean isConnection() {
    boolean isConnected = NavXMXP.isConnected();
    return isConnected;

  }
  
  public boolean isCalibrating() {
    boolean isCalibrating = NavXMXP.isCalibrating();
    return isCalibrating;
  }

  public float pitch() {
    float pitch = NavXMXP.getPitch();
    return pitch;
  }


  public float yaw() {
    float yaw = NavXMXP.getYaw();
    return yaw;
  }

  public float roll() {
    float roll = NavXMXP.getRoll();
    return roll;
  }

  public void reset() {
    //NavXMXP.enableBoardlevelYawReset(true);
    NavXMXP.reset();
    //NavXMXP.enableBoardlevelYawReset(false);
   }

}
