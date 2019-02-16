/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.I2C;

/**
 * Add your docs here.
 */
public class PixyPull extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private I2C pullPixy;
  private byte[] rawData;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public byte[] pullData(int length) {
    pullPixy = Robot.pixyI2C;
    rawData = new byte[length];
    try{
      pullPixy.readOnly(rawData, length);
    }
    catch (RuntimeException e){
      throw e;
    }
    if(rawData.length < length){
      return null;
    }
    return rawData;
  }
  public int cvt(byte upper, byte lower) {
		return (((int) upper & 0xff) << 8) | ((int) lower & 0xff);
	}
  public PixyWrapper read(int check){
    byte[] data = pullData(14);
    PixyWrapper block = new PixyWrapper();
    if(findStart()){
      block.Signature = cvt(data[5], data[4]);
      block.X = cvt(data[7], data[6]);
		  block.Y = cvt(data[9], data[8]);
		  block.Width = cvt(data[11], data[10]);
      block.Height = cvt(data[13], data[12]);
    }
    if(cvt(data[3], data[2]) == block.Signature + block.X + block.Y + block.Width + block.Height){
      return block;
    }
    return null;
  }
  public boolean findStart(){
    int sync = 0xaa55;
    byte[] startWord = pullData(2);
    while(cvt(startWord[1], startWord[0]) != sync){
      startWord = pullData(2);
    }
    return true;
  }
  public PixyWrapper[] placeBlockData(){
    int maxBlocks = 4;
    int slashArray = 3;
    PixyWrapper[] blocks0 = new PixyWrapper[maxBlocks];
    PixyWrapper block = new PixyWrapper();
    PixyWrapper[] blocks;
    block.X = -2;
    block.Y = -2;
    block.Height = -2;
    block.Width = -2;
    block.Signature = -2;
		for (int i = 0; i < maxBlocks; i++) {
			// Should we set to empty PixyPacket? To avoid having to check for
			// null in callers?
			blocks0[i] = block;
			try{
        blocks0[i] = read(i);
      }
      catch (Exception e){
        blocks0[i] = block;
        throw e;
      }
    }
    try{
     for (int j = maxBlocks - 1; j >= 0; j--){
       System.out.println(j);
        if(blocks0[j].Signature != 1){
          slashArray = j;
        }
      }
      blocks = new PixyWrapper[slashArray + 1];
      for(int k = 0; k < blocks.length; k++){
        blocks[k] = blocks0[k];
      }
    }
    catch (NullPointerException e){
      blocks = new PixyWrapper[0];
    }
		return blocks;
  }
  public int[][] format(PixyWrapper[] blocks){
    int[][] targetLocation = new int[blocks.length + 1][4];
    if(blocks.length == 0){
      targetLocation[0][0] = -1;
    }
    else{
      targetLocation[0][0] = 1;
    }
    try{
      for(int i = 1; i < blocks.length; i++){
        targetLocation[i][0] = blocks[i - 1].X;
        targetLocation[i][1] = blocks[i - 1].Y;
        targetLocation[i][2] = blocks[i - 1].Height;
        targetLocation[i][3] = blocks[i - 1].Width;
      }
     return targetLocation;
    }
    catch (NullPointerException e) {
      throw e;
    }
  }
}
