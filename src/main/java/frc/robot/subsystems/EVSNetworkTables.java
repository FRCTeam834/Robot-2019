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

/**
 * Data structure for returned arrays is as follows:
 * - Each column (first value) represents a space to store object values
 * The data structure of the rows is as follows:
 * - 0 or -1, with -1 being not used and 0 being used (meaning data is valid and should be considered)
 * - centerX - the x cordinate of the center
 * - centerY - the y cordinate of the center
 * - endX - the x cordinate of the bottom right corner of the bounding box
 * - endY - the y cordinate of the bottom right corner of the counding box
 * - area - the area of the bounding box
 * - confidence - the confidence level of the neural network that the object is indeed what it is tagged as
 */
public class EVSNetworkTables extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  String inUse = "inUse";
  String centerX = "centerX";
  String centerY = "centerY";
  String endX = "endX";
  String endY = "endY";
  String area = "area";
  String confidence = "confidence";


  NetworkTableInstance n = NetworkTableInstance.getDefault();
  NetworkTable visionValues;

  // Create and assign hatch tables
  NetworkTable hatch0 = visionValues.getSubTable("Hatch0");
  NetworkTable hatch1 = visionValues.getSubTable("Hatch1");
  NetworkTable hatch2 = visionValues.getSubTable("Hatch2");

  NetworkTableEntry hatch_inUse0;
  NetworkTableEntry hatch_centerX0;
  NetworkTableEntry hatch_centerY0;
  NetworkTableEntry hatch_endX0;
  NetworkTableEntry hatch_endY0;
  NetworkTableEntry hatch_area0;
  NetworkTableEntry hatch_confidence0;

  NetworkTableEntry hatch_inUse1;
  NetworkTableEntry hatch_centerX1;
  NetworkTableEntry hatch_centerY1;
  NetworkTableEntry hatch_endX1;
  NetworkTableEntry hatch_endY1;
  NetworkTableEntry hatch_area1;
  NetworkTableEntry hatch_confidence1;

  NetworkTableEntry hatch_inUse2;
  NetworkTableEntry hatch_centerX2;
  NetworkTableEntry hatch_centerY2;
  NetworkTableEntry hatch_endX2;
  NetworkTableEntry hatch_endY2;
  NetworkTableEntry hatch_area2;
  NetworkTableEntry hatch_confidence2;

  // Create and assign ball values
  NetworkTable ball0 = visionValues.getSubTable("Ball0");
  NetworkTable ball1 = visionValues.getSubTable("Ball1");
  NetworkTable ball2 = visionValues.getSubTable("Ball2");
  
  NetworkTableEntry ball_inUse0;
  NetworkTableEntry ball_centerX0;
  NetworkTableEntry ball_centerY0;
  NetworkTableEntry ball_endX0;
  NetworkTableEntry ball_endY0;
  NetworkTableEntry ball_area0;
  NetworkTableEntry ball_confidence0;

  NetworkTableEntry ball_inUse1;
  NetworkTableEntry ball_centerX1;
  NetworkTableEntry ball_centerY1;
  NetworkTableEntry ball_endX1;
  NetworkTableEntry ball_endY1;
  NetworkTableEntry ball_area1;
  NetworkTableEntry ball_confidence1;

  NetworkTableEntry ball_inUse2;
  NetworkTableEntry ball_centerX2;
  NetworkTableEntry ball_centerY2;
  NetworkTableEntry ball_endX2;
  NetworkTableEntry ball_endY2;
  NetworkTableEntry ball_area2;
  NetworkTableEntry ball_confidence2;

  // Create and assign ball values
  NetworkTable tape0 = visionValues.getSubTable("Tape0");
  NetworkTable tape1 = visionValues.getSubTable("Tape1");
  NetworkTable tape2 = visionValues.getSubTable("Tape2");
  NetworkTable tape3 = visionValues.getSubTable("Tape3");
  NetworkTable tape4 = visionValues.getSubTable("Tape4");
  NetworkTable tape5 = visionValues.getSubTable("Tape5");
  
  NetworkTableEntry tape_inUse0;
  NetworkTableEntry tape_centerX0;
  NetworkTableEntry tape_centerY0;
  NetworkTableEntry tape_endX0;
  NetworkTableEntry tape_endY0;
  NetworkTableEntry tape_area0;
  NetworkTableEntry tape_confidence0;

  NetworkTableEntry tape_inUse1;
  NetworkTableEntry tape_centerX1;
  NetworkTableEntry tape_centerY1;
  NetworkTableEntry tape_endX1;
  NetworkTableEntry tape_endY1;
  NetworkTableEntry tape_area1;
  NetworkTableEntry tape_confidence1;

  NetworkTableEntry tape_inUse2;
  NetworkTableEntry tape_centerX2;
  NetworkTableEntry tape_centerY2;
  NetworkTableEntry tape_endX2;
  NetworkTableEntry tape_endY2;
  NetworkTableEntry tape_area2;
  NetworkTableEntry tape_confidence2;

  NetworkTableEntry tape_inUse3;
  NetworkTableEntry tape_centerX3;
  NetworkTableEntry tape_centerY3;
  NetworkTableEntry tape_endX3;
  NetworkTableEntry tape_endY3;
  NetworkTableEntry tape_area3;
  NetworkTableEntry tape_confidence3;

  NetworkTableEntry tape_inUse4;
  NetworkTableEntry tape_centerX4;
  NetworkTableEntry tape_centerY4;
  NetworkTableEntry tape_endX4;
  NetworkTableEntry tape_endY4;
  NetworkTableEntry tape_area4;
  NetworkTableEntry tape_confidence4;

  NetworkTableEntry tape_inUse5;
  NetworkTableEntry tape_centerX5;
  NetworkTableEntry tape_centerY5;
  NetworkTableEntry tape_endX5;
  NetworkTableEntry tape_endY5;
  NetworkTableEntry tape_area5;
  NetworkTableEntry tape_confidence5;

  
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

    hatch_inUse0 = hatch0.getEntry(inUse);
    hatch_centerX0 = hatch0.getEntry(centerX);
    hatch_centerY0 = hatch0.getEntry(centerY);
    hatch_endX0 = hatch0.getEntry(endX);
    hatch_endY0 = hatch0.getEntry(endY);
    hatch_area0 = hatch0.getEntry(area);
    hatch_confidence0 = hatch0.getEntry(confidence);

    hatch_inUse1 = hatch1.getEntry(inUse);
    hatch_centerX1 = hatch1.getEntry(centerX);
    hatch_centerY1 = hatch1.getEntry(centerY);
    hatch_endX1 = hatch1.getEntry(endX);
    hatch_endY1 = hatch1.getEntry(endY);
    hatch_area1 = hatch1.getEntry(area);
    hatch_confidence1 = hatch1.getEntry(confidence);

    hatch_inUse2 = hatch2.getEntry(inUse);
    hatch_centerX2 = hatch2.getEntry(centerX);
    hatch_centerY2 = hatch2.getEntry(centerY);
    hatch_endX2 = hatch2.getEntry(endX);
    hatch_endY2 = hatch2.getEntry(endY);
    hatch_area2 = hatch2.getEntry(area);
    hatch_confidence2 = hatch2.getEntry(confidence);

    double[][] hatchValues = new double[3][7];
    // if inUse is true, store values and check next table
  
  
    if (hatch_inUse0.getBoolean(false) == true) 
      {

        hatchValues[0][0] = 0;
        hatchValues[0][1] = hatch_centerX0.getDouble(-1);
        hatchValues[0][2] = hatch_centerY0.getDouble(-1);
        hatchValues[0][3] = hatch_endX0.getDouble(-1);
        hatchValues[0][4] = hatch_endY0.getDouble(-1);
        hatchValues[0][5] = hatch_area0.getDouble(-1);
        hatchValues[0][6] = hatch_confidence0.getDouble(-1);

        if (hatch_inUse1.getBoolean(false) == true) 
          {

            hatchValues[1][0] = 0;
            hatchValues[1][1] = hatch_centerX1.getDouble(-1);
            hatchValues[1][2] = hatch_centerY1.getDouble(-1);
            hatchValues[1][3] = hatch_endX1.getDouble(-1);
            hatchValues[1][4] = hatch_endY1.getDouble(-1);
            hatchValues[1][5] = hatch_area1.getDouble(-1);
            hatchValues[1][6] = hatch_confidence1.getDouble(-1);

            if (hatch_inUse2.getBoolean(false) == true) 
              {
    
                hatchValues[2][0] = 0;
                hatchValues[2][1] = hatch_centerX2.getDouble(-1);
                hatchValues[2][2] = hatch_centerY2.getDouble(-1);
                hatchValues[2][3] = hatch_endX2.getDouble(-1);
                hatchValues[2][4] = hatch_endY2.getDouble(-1);
                hatchValues[2][5] = hatch_area2.getDouble(-1);
                hatchValues[2][6] = hatch_confidence2.getDouble(-1);
            }
            else 
            {
              hatchValues[2][0] = -1;
            }

        }
        else 
        {
          hatchValues[1][0] = -1;
          hatchValues[2][0] = -1;
        }

    }
    else 
    {
      hatchValues[0][0] = -1;
      hatchValues[1][0] = -1;
      hatchValues[2][0] = -1;
    }

    return hatchValues;

  }


  public double[][] getBalls() 
  {

    ball_inUse0 = ball0.getEntry(inUse);
    ball_centerX0 = ball0.getEntry(centerX);
    ball_centerY0 = ball0.getEntry(centerY);
    ball_endX0 = ball0.getEntry(endX);
    ball_endY0 = ball0.getEntry(endY);
    ball_area0 = ball0.getEntry(area);
    ball_confidence0 = ball0.getEntry(confidence);

    ball_inUse1 = ball1.getEntry(inUse);
    ball_centerX1 = ball1.getEntry(centerX);
    ball_centerY1 = ball1.getEntry(centerY);
    ball_endX1 = ball1.getEntry(endX);
    ball_endY1 = ball1.getEntry(endY);
    ball_area1 = ball1.getEntry(area);
    ball_confidence1 = ball1.getEntry(confidence);

    ball_inUse2 = ball2.getEntry(inUse);
    ball_centerX2 = ball2.getEntry(centerX);
    ball_centerY2 = ball2.getEntry(centerY);
    ball_endX2 = ball2.getEntry(endX);
    ball_endY2 = ball2.getEntry(endY);
    ball_area2 = ball2.getEntry(area);
    ball_confidence2 = ball2.getEntry(confidence);

    double[][] ballValues = new double[3][7];
    // if inUse is true, store values and check next table
  
  
    if (ball_inUse0.getBoolean(false) == true) 
      {

        ballValues[0][0] = 0;
        ballValues[0][1] = ball_centerX0.getDouble(-1);
        ballValues[0][2] = ball_centerY0.getDouble(-1);
        ballValues[0][3] = ball_endX0.getDouble(-1);
        ballValues[0][4] = ball_endY0.getDouble(-1);
        ballValues[0][5] = ball_area0.getDouble(-1);
        ballValues[0][6] = ball_confidence0.getDouble(-1);

        if (ball_inUse1.getBoolean(false) == true) 
          {

            ballValues[1][0] = 0;
            ballValues[1][1] = ball_centerX1.getDouble(-1);
            ballValues[1][2] = ball_centerY1.getDouble(-1);
            ballValues[1][3] = ball_endX1.getDouble(-1);
            ballValues[1][4] = ball_endY1.getDouble(-1);
            ballValues[1][5] = ball_area1.getDouble(-1);
            ballValues[1][6] = ball_confidence1.getDouble(-1);

            if (ball_inUse2.getBoolean(false) == true) 
              {
    
                ballValues[2][0] = 0;
                ballValues[2][1] = ball_centerX2.getDouble(-1);
                ballValues[2][2] = ball_centerY2.getDouble(-1);
                ballValues[2][3] = ball_endX2.getDouble(-1);
                ballValues[2][4] = ball_endY2.getDouble(-1);
                ballValues[2][5] = ball_area2.getDouble(-1);
                ballValues[2][6] = ball_confidence2.getDouble(-1);

            }
            else 
            {
              ballValues[2][0] = -1;
            }

        }
        else 
        {
          ballValues[1][0] = -1;
          ballValues[2][0] = -1;
        }

    }
    else 
    {
      ballValues[0][0] = -1;
      ballValues[1][0] = -1;
      ballValues[2][0] = -1;
    }
    

    return ballValues;

  }

  public double[][] getTape() 
  {

    tape_inUse0 = tape0.getEntry(inUse);
    tape_centerX0 = tape0.getEntry(centerX);
    tape_centerY0 = tape0.getEntry(centerY);
    tape_endX0 = tape0.getEntry(endX);
    tape_endY0 = tape0.getEntry(endY);
    tape_area0 = tape0.getEntry(area);
    tape_confidence0 = tape0.getEntry(confidence);

    tape_inUse1 = tape1.getEntry(inUse);
    tape_centerX1 = tape1.getEntry(centerX);
    tape_centerY1 = tape1.getEntry(centerY);
    tape_endX1 = tape1.getEntry(endX);
    tape_endY1 = tape1.getEntry(endY);
    tape_area1 = tape1.getEntry(area);
    tape_confidence1 = tape1.getEntry(confidence);

    tape_inUse2 = tape2.getEntry(inUse);
    tape_centerX2 = tape2.getEntry(centerX);
    tape_centerY2 = tape2.getEntry(centerY);
    tape_endX2 = tape2.getEntry(endX);
    tape_endY2 = tape2.getEntry(endY);
    tape_area2 = tape2.getEntry(area);
    tape_confidence2 = tape2.getEntry(confidence);

    tape_inUse3 = tape3.getEntry(inUse);
    tape_centerX3 = tape3.getEntry(centerX);
    tape_centerY3 = tape3.getEntry(centerY);
    tape_endX3 = tape3.getEntry(endX);
    tape_endY3 = tape3.getEntry(endY);
    tape_area3 = tape3.getEntry(area);
    tape_confidence3 = tape3.getEntry(confidence);

    tape_inUse4 = tape4.getEntry(inUse);
    tape_centerX4 = tape4.getEntry(centerX);
    tape_centerY4 = tape4.getEntry(centerY);
    tape_endX4 = tape4.getEntry(endX);
    tape_endY4 = tape4.getEntry(endY);
    tape_area4 = tape4.getEntry(area);
    tape_confidence4 = tape4.getEntry(confidence);

    tape_inUse5 = tape5.getEntry(inUse);
    tape_centerX5 = tape5.getEntry(centerX);
    tape_centerY5 = tape5.getEntry(centerY);
    tape_endX5 = tape5.getEntry(endX);
    tape_endY5 = tape5.getEntry(endY);
    tape_area5 = tape5.getEntry(area);
    tape_confidence2 = tape5.getEntry(confidence);

    double[][] tapeValues = new double[3][7];
    // if inUse is true, store values and check next table
  
  
    if (tape_inUse0.getBoolean(false) == true) 
      {

        tapeValues[0][0] = 0;
        tapeValues[0][1] = tape_centerX0.getDouble(-1);
        tapeValues[0][2] = tape_centerY0.getDouble(-1);
        tapeValues[0][3] = tape_endX0.getDouble(-1);
        tapeValues[0][4] = tape_endY0.getDouble(-1);
        tapeValues[0][5] = tape_area0.getDouble(-1);
        tapeValues[0][6] = tape_confidence0.getDouble(-1);

        if (tape_inUse1.getBoolean(false) == true) 
          {

            tapeValues[1][0] = 0;
            tapeValues[1][1] = tape_centerX1.getDouble(-1);
            tapeValues[1][2] = tape_centerY1.getDouble(-1);
            tapeValues[1][3] = tape_endX1.getDouble(-1);
            tapeValues[1][4] = tape_endY1.getDouble(-1);
            tapeValues[1][5] = tape_area1.getDouble(-1);
            tapeValues[1][6] = tape_confidence1.getDouble(-1);

            if (tape_inUse2.getBoolean(false) == true) 
              {
    
                tapeValues[2][0] = 0;
                tapeValues[2][1] = tape_centerX2.getDouble(-1);
                tapeValues[2][2] = tape_centerY2.getDouble(-1);
                tapeValues[2][3] = tape_endX2.getDouble(-1);
                tapeValues[2][4] = tape_endY2.getDouble(-1);
                tapeValues[2][5] = tape_area2.getDouble(-1);
                tapeValues[2][6] = tape_confidence2.getDouble(-1);

                if (tape_inUse3.getBoolean(false) == true) 
                {
    
                  tapeValues[3][0] = 0;
                  tapeValues[3][1] = tape_centerX3.getDouble(-1);
                  tapeValues[3][2] = tape_centerY3.getDouble(-1);
                  tapeValues[3][3] = tape_endX3.getDouble(-1);
                  tapeValues[3][4] = tape_endY3.getDouble(-1);
                  tapeValues[3][5] = tape_area3.getDouble(-1);
                  tapeValues[3][6] = tape_confidence3.getDouble(-1);

                  if (tape_inUse3.getBoolean(false) == true) 
                    {
    
                    tapeValues[3][0] = 0;
                    tapeValues[3][1] = tape_centerX3.getDouble(-1);
                    tapeValues[3][2] = tape_centerY3.getDouble(-1);
                    tapeValues[3][3] = tape_endX3.getDouble(-1);
                    tapeValues[3][4] = tape_endY3.getDouble(-1);
                    tapeValues[3][5] = tape_area3.getDouble(-1);
                    tapeValues[3][6] = tape_confidence3.getDouble(-1);

                      if (tape_inUse4.getBoolean(false) == true) 
                      {
    
                      tapeValues[4][0] = 0;
                      tapeValues[4][1] = tape_centerX4.getDouble(-1);
                      tapeValues[4][2] = tape_centerY4.getDouble(-1);
                      tapeValues[4][3] = tape_endX4.getDouble(-1);
                      tapeValues[4][4] = tape_endY4.getDouble(-1);
                      tapeValues[4][5] = tape_area4.getDouble(-1);
                      tapeValues[4][6] = tape_confidence4.getDouble(-1);

                        if (tape_inUse5.getBoolean(false) == true) 
                        {
    
                        tapeValues[5][0] = 0;
                        tapeValues[5][1] = tape_centerX5.getDouble(-1);
                        tapeValues[5][2] = tape_centerY5.getDouble(-1);
                        tapeValues[5][3] = tape_endX5.getDouble(-1);
                        tapeValues[5][4] = tape_endY5.getDouble(-1);
                        tapeValues[5][5] = tape_area5.getDouble(-1);
                        tapeValues[5][6] = tape_confidence5.getDouble(-1);

                        }
                        else 
                        {
                          tapeValues[5][0] = -1;
                        }

                      }
                      else 
                      {
                        tapeValues[4][0] = -1;
                        tapeValues[5][0] = -1;
                      }

                    }
                    else 
                    {
                      tapeValues[3][0] = -1;
                      tapeValues[4][0] = -1;
                      tapeValues[5][0] = -1;
                    }
                }
                else 
                {
                  tapeValues[3][0] = -1;
                  tapeValues[4][0] = -1;
                  tapeValues[5][0] = -1;

                }
            }
            else 
            {
              tapeValues[2][0] = -1;
              tapeValues[3][0] = -1;
              tapeValues[4][0] = -1;
              tapeValues[5][0] = -1;
            }

        }
        else 
        {
          tapeValues[1][0] = -1;
          tapeValues[2][0] = -1;
          tapeValues[3][0] = -1;
          tapeValues[4][0] = -1;
          tapeValues[5][0] = -1;
        }

    }

    else 
    {
      tapeValues[0][0] = -1;
      tapeValues[1][0] = -1;
      tapeValues[2][0] = -1;
      tapeValues[3][0] = -1;
      tapeValues[4][0] = -1;
      tapeValues[5][0] = -1;
    }
    

    return tapeValues;

  }

}
