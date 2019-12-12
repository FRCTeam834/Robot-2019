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
    public static final double SYSTEM_TIME_START = 0;

    // Camera and Vision constants
    public static final int IMAGE_WIDTH = 1280;
    public static final int IMAGE_HEIGHT = 720;

    // Arm Motor
    public static final int ARM_MOTOR_PORT = 8;
    public static final int ARM_LIMIT_SWITCH_PORT = 4;
    public static final double ARM_UP_SPEED = -.8;
    public static final double ARM_DOWN_SPEED = .8;
    public static final double ARM_STOP_SPEED = 0;
    public static final double ARM_HOLD_SPEED = 0;

    // Ball Intake
    public static final int BALL_INTAKE_MOTOR_PORT = 9;
    public static final double BALL_INTAKE_IN_SPEED = 1;
    public static final double BALL_INTAKE_OUT_SPEED = -1;
    public static final double BALL_INTAKE_STOP_SPEED = 0;

    // Compressor is not here because we no longer use it

    // Drive Train
    public static final int LEFT_DRIVE1_PORT = 4;
    public static final int LEFT_DRIVE2_PORT = 5;
    public static final int LEFT_DRIVE3_PORT = 6;
    public static final int RIGHT_DRIVE1_PORT = 1;
    public static final int RIGHT_DRIVE2_PORT = 2;
    public static final int RIGHT_DRIVE3_PORT = 3;
    public static final boolean IS_RIGHT_DRIVE_INVERTED = true;
    public static final boolean IS_LEFT_DRIVE_INVERTED = false;

    // Elevator
    public static final int ELEVATOR_MOTOR_PORT = 7;
    public static final int ELEVATOR_ENCODER_PORT_A = 0;
    public static final int ELEVATOR_ENCODER_PORT_B = 1;
    public static final int ELEVATOR_LIMIT_SWITCH_BOTTOM_PORT = 3;
    public static final int ELEVATOR_LIMIT_SWITCH_TOP_PORT = 2;
    public static final int ELEVATOR_ENCODER_DISTANCE_PER_PULSE = 1;
    public static final double ELEVATOR_UP_SPEED = 1.0;
    public static final double ELEVATOR_DOWN_SPEED = -.75;
    public static final double ELEVATOR_HOLD_SPEED = .15;
    public static final double ELEVATOR_STOP_SPEED = 0;

    // Lead Screw
    public static final int LEAD_SCREW_MOTOR_PORT = 14;
    public static final int LEAD_SCREW_LIMIT_SWITCH_PORT = 8;
    public static final double LEAD_SCREW_MOTOR_DOWN_SPEED = 1;
    public static final double LEAD_SCREW_MOTOR_UP_SPEED = -1;
    public static final double LEAD_SCREW_STOPPED_SPEED = 0;

    // Back Screw (no longer a scissor tho)
    public static final int BACK_SCREW_MOTOR_PORT = 12;
    public static final int BACK_SCREW_LIMIT_SWITCH_BOTTOM_PORT = 6;
    public static final int backScrewLimitSwitchTopPort = 7;
    public static final double BACK_SCREW_HOLD_SPEED = .15;
    public static final double BACK_SCREW_STOP_SPEED = 0;
    public static final int BACK_SCREW_WHEELS_MOTOR_PORT = 13;
    public static final double BACK_SCREW_WHEELS_FORWARD_SPEED = 1;
    public static final double BACK_SCREW_WHEELS_BACKWARDS_SPEED = -1;
    public static final double BACK_SCREW_WHEELS_STOP_SPEED = 0;

    // LED Values (for style)
    public static final double LAVA_RAINBOW = -.87;
    public static final double STROBE_RED = -.11;
    public static final double PARTY = -.43;
    public static final double PINK = .57;
    public static final double GLITTER_RAINBOW = -.89;
    public static final double OCEAN = -.95;
    public static final double WHITE_HB = .25;
    public static final double BLUE_VIOLET = .89;
    public static final double SKY_BLUE = .83;
    //public static final double
    //public static final double
}
