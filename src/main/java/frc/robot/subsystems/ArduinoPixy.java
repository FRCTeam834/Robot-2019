/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.SerialPort;

/**
 * Arduino returns:
 * x: (x value of box) y: (y value of box) w: (width of box) h: (height)
 * If no blocks are detected, then it will return "None"
 */
public class ArduinoPixy extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static SerialPort.Port kUSB;
  SerialPort pixyPort = new SerialPort(9600, kUSB);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }      




  public ArrayList<String> returnValues() {

    String data = pixyPort.readString();
    ArrayList<String> targetLoc = new ArrayList<String>();
    targetLoc.set(0, "yes");

    if (data.charAt(0) == 'x') {

      String xPos = data.substring(1, 3);
      String yPos = data.substring(4, 6);
      String width = data.substring(7, 9);
      String height = data.substring(10, 12);
      
      targetLoc.set(1, xPos);
      targetLoc.set(2, yPos);
      targetLoc.set(3, width);
      targetLoc.set(4, height);

    } else {

      targetLoc.set(0, "no");


    }

    return targetLoc;
  
  }    

}
