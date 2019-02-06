/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
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
  public Joystick arduinoThing = new Joystick(4);

  // Buttons
  public Button lb3 = new JoystickButton(leftJoystick, 3), 
  xboxStart = new JoystickButton(xbox, 8), 
  xboxB = new JoystickButton(xbox, 2),
  xboxA = new JoystickButton(xbox, 1),
  xboxY = new JoystickButton(xbox, 4),
  xboxX = new JoystickButton(xbox, 3),
  xboxBLeft = new JoystickButton(xbox, 5),
  xboxBRight = new JoystickButton(xbox, 6),

  //Left Joystick
  ljoystick2 = new JoystickButton(leftJoystick, 2),
  ljoystick6 = new JoystickButton(leftJoystick, 6),
  ljoystick7 = new JoystickButton(leftJoystick, 7),
  ljoystick10 = new JoystickButton(leftJoystick, 10),
  ljoystick11 = new JoystickButton(leftJoystick, 11),
  


  //Right Joystick
  rjoystick1 = new JoystickButton(rightJoystick, 1),
  rjoystick2 = new JoystickButton(rightJoystick, 2),
  rjoystick3 = new JoystickButton(rightJoystick, 3),
  rjoystick4 = new JoystickButton(rightJoystick, 4),
  rjoystick5 = new JoystickButton(rightJoystick, 5),
  rjoystick6 = new JoystickButton(rightJoystick, 6),
  rjoystick7 = new JoystickButton(rightJoystick, 7),
  rjoystick8 = new JoystickButton(rightJoystick, 8);

  


  public OI() {

    //DriveTrain
    xboxStart.whenPressed(new AutoDrive());

    //Turning off xbox runble
    xboxB.whenPressed(new StopRumble());

    //Vacuum w/ Solenoid
    //xboxA.whileHeld(new Vacuum());

    //Scissor Lift
    xboxY.whileHeld(new ScissorUp());
    xboxX.whileHeld(new ScissorDown());

    //Elevator
    xboxBLeft.whileHeld(new ElevatorUp());
    xboxBRight.whileHeld(new ElevatorDown());

    //Ball Intake
    ljoystick6.whileHeld(new BallIntakeIn());
    ljoystick7.whileHeld(new BallIntakeOut());

    //Arm
    ljoystick10.whileHeld(new ArmDown());
    ljoystick11.whileHeld(new ArmUp());

    //Compressor

    rjoystick4.whenPressed(new CompressorOn());
    rjoystick5.whenPressed(new CompressorStop());

  }

}
