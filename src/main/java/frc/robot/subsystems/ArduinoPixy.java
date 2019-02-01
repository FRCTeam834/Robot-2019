/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

//import java.util.ArrayList;

import edu.wpi.first.wpilibj.SerialPort;


/**
 * Arduino returns:
 * x: (x value of box) y: (y value of box) w: (width of box) h: (height)
 * If no blocks are detected, then it will return "None"
 */
public class ArduinoPixy extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  int i;
  public static SerialPort.Port kOnboard;
  SerialPort pixyPort = new SerialPort(9600, kOnboard);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }      




  public int[][] returnValues() {

    String data = pixyPort.readString();
   // ArrayList<String> targetLoc = new ArrayList<String>();
    int[][] targetLoc = new int[10][10];

    
      targetLoc[0][0] = 0;
      int totalBlocks = Integer.parseInt(data.substring(1, 1));
      
      for (int i = 0; i < totalBlocks; i++) {
        
        data = pixyPort.readString();

        if (data.charAt(0) == 'x') {
        
          int blockNumber = Integer.parseInt(data.substring(2, 2));
          int xPos = Integer.parseInt(data.substring(3, 5));
          int yPos = Integer.parseInt(data.substring(6, 8));
          int width = Integer.parseInt(data.substring(9, 11));
          int height = Integer.parseInt(data.substring(12, 14));

          targetLoc[blockNumber][0] = blockNumber;
          targetLoc[blockNumber][1] = xPos;
          targetLoc[blockNumber][2] = yPos;
          targetLoc[blockNumber][3] = width;
          targetLoc[blockNumber][4] = height;
        }
        
        else {
        targetLoc[0][0] = -1;
        }
      }

    return targetLoc;
  
  }
}
