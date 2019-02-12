/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  // Joysticks
  public Joystick leftJoystick = new Joystick(0);
  public Joystick rightJoystick = new Joystick(1);
  public XboxController xbox = new XboxController(2);
  public Joystick launchpad = new Joystick(3);
  //public Joystick launchpad = new Joystick(3);

  // Buttons
  public Button lb3 = new JoystickButton(leftJoystick, 3),
  xboxStart = new JoystickButton(xbox, 8),
  xboxBack = new JoystickButton(xbox, 7), 
  xboxB = new JoystickButton(xbox, 2),
  xboxA = new JoystickButton(xbox, 1), 
  xboxY = new JoystickButton(xbox, 4), 
  xboxX = new JoystickButton(xbox, 3),
  xboxLB = new JoystickButton(xbox, 5), 
  xboxRB = new JoystickButton(xbox, 6),

      // Left Joystick
      lJoystick1 = new JoystickButton(leftJoystick, 1), 
      lJoystick2 = new JoystickButton(leftJoystick, 2),
      lJoystick3 = new JoystickButton(leftJoystick, 3), 
      lJoystick4 = new JoystickButton(leftJoystick, 4),
      lJoystick5 = new JoystickButton(leftJoystick, 5), 
      lJoystick6 = new JoystickButton(leftJoystick, 6),
      lJoystick7 = new JoystickButton(leftJoystick, 7), 
      lJoystick8 = new JoystickButton(leftJoystick, 8),
      lJoystick9 = new JoystickButton(leftJoystick, 9), 
      lJoystick10 = new JoystickButton(leftJoystick, 10),
      lJoystick11 = new JoystickButton(leftJoystick, 11),

      // Right Joystick
      rJoystick1 = new JoystickButton(rightJoystick, 1), 
      rJoystick2 = new JoystickButton(rightJoystick, 2),
      rJoystick3 = new JoystickButton(rightJoystick, 3), 
      rJoystick4 = new JoystickButton(rightJoystick, 4),
      rJoystick5 = new JoystickButton(rightJoystick, 5), 
      rJoystick6 = new JoystickButton(rightJoystick, 6),
      rJoystick7 = new JoystickButton(rightJoystick, 7), 
      rJoystick8 = new JoystickButton(rightJoystick, 8),
      rJoystick9 = new JoystickButton(rightJoystick, 9), 
      rJoystick10 = new JoystickButton(rightJoystick, 10),
      rJoystick11 = new JoystickButton(rightJoystick, 11),

      //Triggers
      //xbox.getBumperPressed(GenericHID.Hand.kLeft);
      //xbox.getBumperPressed(GenericHID.Hand.kRight);
      
      //Arcade Buttons
      //Syntax: BG = Button Group 
      //Ex. BGTL = Button Group Top Left
      BGTL = new JoystickButton(launchpad, 10), 
      BGTM = new JoystickButton(launchpad, 9),
      BGTR = new JoystickButton(launchpad, 8), 
      BGML = new JoystickButton(launchpad, 7),
      BGMM = new JoystickButton(launchpad, 6), 
      BGMR = new JoystickButton(launchpad, 4),
      BGBL = new JoystickButton(launchpad, 3), 
      BGBM = new JoystickButton(launchpad, 2),
      BGBR = new JoystickButton(launchpad, 1);

  // Button Array on Driver's Station
  /*
   * Row 1: 10 9  8 
   * Row 2: 7  6  4 
   * Row 3: 3  2  1
   */

  public OI() {

    // DriveTrain
    lJoystick1.whenPressed(new Drive());
    rJoystick1.whenPressed(new DriveSlow());
    lJoystick3.whenPressed(new DriveStraightFast());
    rJoystick3.whenPressed(new DriveStraightSlow());

    // Scissor Lift
    BGBM.whileHeld(new ScissorUp());
    BGTM.whileHeld(new ScissorDown());

    // Elevator
    xboxY.whileHeld(new ElevatorUp());
    xboxX.whileHeld(new ElevatorDown());
    BGBL.whenPressed(new ElevatorPreset1());
    BGML.whenPressed(new ElevatorPreset2());
    BGTL.whenPressed(new ElevatorPreset3());
    BGBR.whenPressed(new ElevatorPreset4());
    BGMR.whenPressed(new ElevatorPreset5());
    BGTR.whenPressed(new ElevatorPreset6());
    BGMM.whenPressed(new ResetElevEncoder());

    // Ball Intake
    xboxStart.whileHeld(new BallIntakeIn());
    xboxBack.whileHeld(new BallIntakeOut());

    // Arm
    xboxA.whileHeld(new ArmDown());
    xboxB.whileHeld(new ArmUp());

    // Compressor
    xboxLB.whenPressed(new CompressorOn());
    xboxRB.whenPressed(new CompressorStop());

    // Turning off xbox rumble
    lJoystick1.whenPressed(new StopRumble());

    //Climbing Arms
    

    
  }

}
