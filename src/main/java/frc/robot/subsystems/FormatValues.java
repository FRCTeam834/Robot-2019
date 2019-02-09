/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class FormatValues extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public int[][] format(PixyWrapper[] blocks){
    int[][] targetLocation = new int[blocks.length][4];
    for(int i = 0; i < blocks.length; i++){
      targetLocation[i][0] = blocks[i].X;
      targetLocation[i][1] = blocks[i].Y;
      targetLocation[i][2] = blocks[i].Height;
      targetLocation[i][3] = blocks[i].Width;
    }
    return targetLocation;
  }
}
