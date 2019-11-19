/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.*;

/**
 * Add your docs here.
 */
public class EVSNetworkTables extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  NetworkTableInstance n = NetworkTableInstance.getDefault();
  NetworkTable visionValues;

  NetworkTableEntry inUse0;
  NetworkTableEntry centerX0;
  NetworkTableEntry centerY0;
  NetworkTableEntry endX0;
  NetworkTableEntry endY0;
  NetworkTableEntry area0;
  NetworkTableEntry confidence0;

  NetworkTableEntry inUse1;
  NetworkTableEntry centerX1;
  NetworkTableEntry centerY1;
  NetworkTableEntry endX1;
  NetworkTableEntry endY1;
  NetworkTableEntry area1;
  NetworkTableEntry confidence1;

  NetworkTableEntry inUse2;
  NetworkTableEntry centerX2;
  NetworkTableEntry centerY2;
  NetworkTableEntry endX2;
  NetworkTableEntry endY2;
  NetworkTableEntry area2;
  NetworkTableEntry confidence2;

  NetworkTable hatch0 = visionValues.getSubTable("Hatch0");
  NetworkTable hatch1 = visionValues.getSubTable("Hatch1");
  NetworkTable hatch2 = visionValues.getSubTable("Hatch2");
  

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    // setDefaultCommand(new VisionUpdater());

  }

  public void getVisionNetworkTable() 
  {

    visionValues = n.getTable("VisionValues");

  }

  /*
   * public NetworkTable getSubTable(String tableName) {
   * 
   * return visionValues.getSubTable(tableName);
   * 
   * }
   */

  public double[][] getHatches() 
  {

    inUse0 = hatch0.getEntry("inUse");
    centerX0 = hatch0.getEntry("centerX");
    centerY0 = hatch0.getEntry("centerY");
    endX0 = hatch0.getEntry("endX");
    endY0 = hatch0.getEntry("endY");
    area0 = hatch0.getEntry("area");
    confidence0 = hatch0.getEntry("confidence");

    inUse1 = hatch1.getEntry("inUse");
    centerX1 = hatch0.getEntry("centerX");
    centerY1 = hatch0.getEntry("centerY");
    endX1 = hatch0.getEntry("endX");
    endY1 = hatch0.getEntry("endY");
    area1 = hatch0.getEntry("area");
    confidence1 = hatch0.getEntry("confidence");

    inUse2 = hatch2.getEntry("inUse");
    centerX2 = hatch0.getEntry("centerX");
    centerY2 = hatch0.getEntry("centerY");
    endX2 = hatch0.getEntry("endX");
    endY2 = hatch0.getEntry("endY");
    area2 = hatch0.getEntry("area");
    confidence2 = hatch0.getEntry("confidence");

    double[][] hatchValues = new double[3][7];
    // if inUse is true, store values and check next table
  
  
    if (inUse0.getBoolean(false) == true) 
      {

      hatchValues[0][0] = 0;
      hatchValues[0][1] = centerX0.getDouble(-1);
      hatchValues[0][2] = centerY0.getDouble(-1);
      hatchValues[0][3] = endX0.getDouble(-1);
      hatchValues[0][4] = endY0.getDouble(-1);
      hatchValues[0][5] = area0.getDouble(-1);
      hatchValues[0][6] = confidence0.getDouble(-1);

        if (inUse1.getBoolean(false) == true) 
          {

            hatchValues[1][0] = 0;
            hatchValues[1][1] = centerX1.getDouble(-1);
            hatchValues[1][2] = centerY1.getDouble(-1);
            hatchValues[1][3] = endX1.getDouble(-1);
            hatchValues[1][4] = endY1.getDouble(-1);
            hatchValues[1][5] = area1.getDouble(-1);
            hatchValues[1][6] = confidence1.getDouble(-1);

            if (inUse2.getBoolean(false) == true) 
              {
    
                hatchValues[2][0] = 0;
                hatchValues[2][1] = centerX2.getDouble(-1);
                hatchValues[2][2] = centerY2.getDouble(-1);
                hatchValues[2][3] = endX2.getDouble(-1);
                hatchValues[2][4] = endY2.getDouble(-1);
                hatchValues[2][5] = area2.getDouble(-1);
                hatchValues[2][6] = confidence2.getDouble(-1);
            }

        }

    }

    return hatchValues;

  }

}
