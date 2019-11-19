/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.ScrewStop;

/**
 * Add your docs here.
 */
public class LeadScrew extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_VictorSPX theScrewer = new WPI_VictorSPX(Constants.leadScrewMotorPort);
  DigitalInput screwDown = new DigitalInput(Constants.leadScrewLimitSwitchPort);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ScrewStop());
  }

  public void screwHer() {

    theScrewer.set(Constants.leadScrewMotorDownSpeed);

  }

  public void screwYourself() {

    theScrewer.set(Constants.leadScrewMotorUpSpeed);

  }

  public boolean screwDown() {

    return !(screwDown.get());

  }

  public void screwHer_IBarelyKnowHer() {

    theScrewer.set(Constants.leadScrewStoppedSpeed);

  }

}
