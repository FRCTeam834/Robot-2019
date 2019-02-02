/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ScissorStop;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



/**
 * Add your docs here.
 */
public class Scissor extends Subsystem {

 WPI_TalonSRX scissor = new WPI_TalonSRX(7);

    @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ScissorStop());
    // Set the default command for a subsystem here.
  }


  public void setScissor(double speed) {
    
    scissor.set(speed);

  }

  public void stop() {

    setScissor(0);

  }



}
