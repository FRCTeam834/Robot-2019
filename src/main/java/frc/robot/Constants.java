/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class Constants {

    //Here we will hold all of our constants for anything robot related

    //System constants
    public static final double systemTimeStart = 0;

    //Camera and Vision constants
    public static final int imageWidth = 1280;
    public static final int imageHeight = 720;

    //Arm Motor
    public static final int armMotorPort = 8;
    public static final int armLimitSwitchPort = 4;
    public static final double armUpSpeed = -.8;
    public static final double armDownSpeed = .8;
    public static final double armStopSpeed = 0;
    public static final double armHoldSpeed = 0;

    //Ball Intake
    public static final int ballIntakeMotorPort = 9;
    public static final double ballIntakeInSpeed = 1;
    public static final double ballIntakeOutSpeed = -1;
    public static final double ballIntakeStopSpeed = 0;

    //Compressor is not here because we no longer use it

    //Drive Train
    public static final int leftDrive1 = 4;
    public static final int leftDrive2 = 5;
    public static final int leftDrive3 = 6;
    public static final int rightDrive1 = 1;
    public static final int rightDrive2 = 2;
    public static final int rightDrive3 = 3;



}
