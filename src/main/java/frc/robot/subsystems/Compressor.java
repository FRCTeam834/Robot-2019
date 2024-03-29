/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Compressor extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //WPI_TalonSRX compressor = new WPI_TalonSRX(8);
  WPI_VictorSPX compressor = new WPI_VictorSPX(10);
  Solenoid vacuumSol = new Solenoid(11, 0);
  //Solenoid vacuumSensor = new Solenoid(10, 6);
  AnalogInput pressureSensor = new AnalogInput(0);


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
  }

    public void compressorStop() {

      
      compressor.set(0);
      

    }

    public void vacuumRelease() {

      vacuumSol.set(true);

    }

    public void compressorOn() {

      
      compressor.set(1);
      vacuumSol.set(false);

    }

    public void vacuumSucc() {

      vacuumSol.set(false);

    }

    public double getPressure() {

      pressureSensor.setOversampleBits(50);
      pressureSensor.setAverageBits(50);
      return pressureSensor.getVoltage();

    }
    
}
