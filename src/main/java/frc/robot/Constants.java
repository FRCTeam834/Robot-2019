/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.I2C.Port;

/**
 * Add your docs here.
 */
public class Constants {

    // Here we will hold all of our constants for anything robot related

    // System constants
    public static final double systemTimeStart = 0;

    // Camera and Vision constants
    public static final int imageWidth = 1280;
    public static final int imageHeight = 720;

    // Arm Motor
    public static final int armMotorPort = 8;
    public static final int armLimitSwitchPort = 4;
    public static final double armUpSpeed = -.8;
    public static final double armDownSpeed = .8;
    public static final double armStopSpeed = 0;
    public static final double armHoldSpeed = 0;

    // Ball Intake
    public static final int ballIntakeMotorPort = 9;
    public static final double ballIntakeInSpeed = 1;
    public static final double ballIntakeOutSpeed = -1;
    public static final double ballIntakeStopSpeed = 0;

    // Compressor is not here because we no longer use it

    // Drive Train
    public static final int leftDrive1Port = 4;
    public static final int leftDrive2Port = 5;
    public static final int leftDrive3Port = 6;
    public static final int rightDrive1Port = 1;
    public static final int rightDrive2Port = 2;
    public static final int rightDrive3Port = 3;
    public static final boolean isRightDriveInverted = true;
    public static final boolean isLeftDriveInverted = false;

    // Elevator
    public static final int elevatorMotorPort = 7;
    public static final int elevatorEncoderPortA = 0;
    public static final int elevatorEncoderPortB = 1;
    public static final int elevatorLimitSwitchBottomPort = 3;
    public static final int elevatorLimitSwitchTopPort = 2;
    public static final int elevatorEncoderDistancePerPulse = 1;
    public static final double elevatorUpSpeed = 1.0;
    public static final double elevatorDownSpeed = -.75;
    public static final double elevatorHoldSpeed = .15;
    public static final double elevatorStopSpeed = 0;

    // Lead Screw
    public static final int leadScrewMotorPort = 14;
    public static final int leadScrewLimitSwitchPort = 8;
    public static final double leadScrewMotorDownSpeed = 1;
    public static final double leadScrewMotorUpSpeed = -1;
    public static final double leadScrewStoppedSpeed = 0;

    // Back Screw (no longer a scissor tho)
    public static final int backScrewMotorPort = 12;
    public static final int backScrewLimitSwitchBottomPort = 6;
    public static final int backScrewLimitSwitchTopPort = 7;
    public static final double backScrewHoldSpeed = .15;
    public static final double backScrewStopSpeed = 0;
    public static final int backScrewWheelsMotorPort = 13;
    public static final double backScrewWheelsForwardSpeed = 1;
    public static final double backScrewWheelsBackwardSpeed = -1;
    public static final double backScrewWheelsStopSpeed = 0;

}
