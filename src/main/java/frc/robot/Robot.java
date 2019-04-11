/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;

//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.MyVisionPipeline;
import frc.robot.subsystems.NavX;
import frc.robot.subsystems.Scissor;
import frc.robot.subsystems.ScrewWheels;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.LeadScrew;
import frc.robot.subsystems.Compressor;
import frc.robot.auton.Baseline;
import frc.robot.commands.Drive;
import frc.robot.commands.RunAuton;

//Driver Input Imports
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;

import edu.wpi.first.vision.VisionThread;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  // Subsystems and Commands
  public static DriveTrain DriveTrain;
  public static OI oi;
  public static NavX NavX;
  public static Scissor Scissor;
  public static Elevator Elevator;
  public static BallIntake BallIntake;
  public static Arm Arm;
  public static Compressor Compressor;
  public static LeadScrew LeadScrew;
  public static ScrewWheels ScrewWheels;
  public static MyVisionPipeline MyVisionPipeline;
  public static RunAuton RunAuton;
  public static Baseline Baseline;
  public static Drive Drive;

  // Camera Things
  private static final int IMG_WIDTH = 320;
  private static final int IMG_HEIGHT = 240;
  public VisionThread visionThread;
  public double centerX = 0.0;
  private boolean recordStatus = false;
  private int cycleCount;
  private boolean[][] motorValues = new boolean[8][1500];
  private double[][] driveTrainSpeed = new double[2][1500];
  public UsbCamera camera;
  CvSink cvSink;
  CvSource outputStream;
  Mat source;
  Mat output;
  KeyPoint[] mat;

  // DriverInput things
  private double systemTimeStart = 0;
  public static boolean autoDriveOn = false;
  private final Object imgLock = new Object();

  // Other Stuff
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  Solenoid vacuumSensor;

  // Variables for Arduino
  public static boolean isSucced = false;
  public static boolean firstIsSucc = false;
  public static boolean elevTop = false;
  public static boolean firstElevTop = false;
  public static boolean elevBottom = false;
  public static boolean firstElevBottom = false;
  public static boolean haveBall = false;
  public static boolean firstHaveBall = false;
  public static boolean armDown = false;
  public static boolean firstArmDown = false;

  // LED's
  public static double lights = -.45;
  Spark led;

  //NavX Variables (To Be Used Everywhere) //MAKE SURE TO OMNIMOUNT THE NAVX
  public static float YAW = 0;
  public static float xDisplacement = 0;
  public static float yDisplacement = 0;
  public static float zDisplacement = 0;
  public static float degreeHeading = 0;
  public static boolean onTape = false;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  @Override
  public void robotInit() {

    vacuumSensor = new Solenoid(11, 6);
    vacuumSensor.set(true);

    camera = CameraServer.getInstance().startAutomaticCapture();

    DriverStation.reportError("Ryan deleted some autons.", true);

    // camera.setResolution(IMG_WIDTH, IMG_HEIGHT);

    /*
     * visionThread = new VisionThread(camera, new MyVisionPipeline(), pipeline -> {
     * //if (!(pipeline.findBlobsOutput() == null)) { Rect r =
     * Imgproc.boundingRect(pipeline.findBlobsOutput()); synchronized (imgLock) {
     * centerX = r.x + (r.width / 2); //} } }); visionThread.start();
     * 
     */

    // m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);

    DriveTrain = new DriveTrain();
    Scissor = new Scissor();
    Elevator = new Elevator();
    BallIntake = new BallIntake();
    Arm = new Arm();
    Compressor = new Compressor();
    MyVisionPipeline = new MyVisionPipeline();
    RunAuton = new RunAuton();
    led = new Spark(9);
    ScrewWheels = new ScrewWheels();
    LeadScrew = new LeadScrew();
    NavX = new NavX();

    // OI MUST BE CREATED LAST!!!!!!!!!!
    oi = new OI();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */

  @Override
  public void autonomousInit() {

    DriverStation.reportError("Ryan deleted some autons.", false);

    teleopPeriodic();
    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand123(); break; case "Default Auto": default: autonomousCommand =
     * new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    /*
     * if (m_autonomousCommand != null) { m_autonomousCommand.start(); }
     */

    /*
     * String auton = SmartDashboard.getString("DB/String 0", "baseline"); String
     * autonType = SmartDashboard.getString("DB/String 1", "baseline");
     * 
     * if (auton.equalsIgnoreCase("baseline")) {
     * 
     * Baseline.start();
     * 
     * } else if (autonType.equalsIgnoreCase("driverInput")) {
     * 
     * RunAuton.start();
     * 
     * } else {
     * 
     * //Scheduler.getInstance().run();
     * 
     * 
     * }
     */

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    teleopPeriodic();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    // MyVisionPipeline = new MyVisionPipeline();

    recordStatus = false;
    systemTimeStart = 0;

  }

  // led.set(lights);
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

    vacuumSensor.set(true);
    led.set(lights);

    if (Robot.oi.BGTL.get()) {

      lights = -.87; // Rainbow, Lava Palette

    }

    if (Robot.oi.BGTR.get()) {

      lights = -.11; // ABORT ABORT (Strobe Red) WE GOIN MAX SPEED BOIS

    }

    if (Robot.oi.BGMM.get()) {

      lights = -.43; // We climbing, so lets partyyyyy

    }

    if (Robot.oi.BGBR.get()) {

      lights = .57; // Wheels going back makes robot hot pink

    }

    if (Robot.oi.BGTM.get()) {

      lights = -.89; // Glitter Rainbow(I Think)

    }

    if (Robot.oi.xboxY.get()) {

      lights = -.95; // Ocean Palette

    }

    if (Robot.oi.xboxX.get()) {

      lights = .25; // Color 1 pattern - heartbeat (white)

    }

    if (Robot.oi.xboxA.get()) {

      lights = .89; // Blue Violet

    }

    if (Robot.oi.xboxB.get()) {

      lights = .83; // Sky Blue

    }

    // System.out.println(recordStatus);
    // System.out.println(SmartDashboard.getString("DB/String 1", ""));

    // Robot.oi.arduinoThing.setOutput(72, true);

    // double blockPos = centerX - (IMG_WIDTH / 2);

    // cvSink.grabFrame(source);
    // outputStream.putFrame(source);

    Scheduler.getInstance().run();

    // Record Systems: Start Recording
    if (SmartDashboard.getString("DB/String 1", "").equalsIgnoreCase("Record") && !recordStatus) {
      recordStatus = true;
      systemTimeStart = System.currentTimeMillis() / 1000;
      System.out.println("Recording");
    }
    // Record Systems: Record
    double systemTimeCurrent = System.currentTimeMillis() / 1000;
    if (recordStatus && systemTimeStart + 15 >= systemTimeCurrent) {
      driveTrainSpeed[0][cycleCount] = Robot.oi.leftJoystick.getY();
      driveTrainSpeed[1][cycleCount] = Robot.oi.rightJoystick.getY();
      motorValues[0][cycleCount] = Robot.oi.xbox.getRawButton(4); // Elevator Up
      motorValues[1][cycleCount] = Robot.oi.xbox.getRawButton(3); // Elevator Down
      motorValues[2][cycleCount] = Robot.oi.xbox.getRawButton(8); // Intake In
      motorValues[3][cycleCount] = Robot.oi.xbox.getRawButton(7); // Intake Out
      motorValues[4][cycleCount] = Robot.oi.xbox.getRawButton(2); // Arm Up
      motorValues[5][cycleCount] = Robot.oi.xbox.getRawButton(1); // Arm Down
      motorValues[6][cycleCount] = Robot.oi.xbox.getRawButton(5); // Compressor On
      motorValues[7][cycleCount] = Robot.oi.xbox.getRawButton(6); // Compressor Off
      cycleCount++;
      // Maybe Add Elevator Presets in the Future
    }
    // Record System: End Recording
    if (recordStatus && systemTimeStart + 15 <= systemTimeCurrent) {
      cycleCount = 0;
      save(new File(SmartDashboard.getString("DB/String 0", "")));
      recordStatus = false;
      SmartDashboard.putString("DB/String 1", "");
    }

    // Arduino Code

    else if (elevTop && firstElevTop) {
      SmartDashboard.putString("DB/String 8", "u");
    } else if (elevBottom && firstElevBottom) {
      SmartDashboard.putString("DB/String 8", "d");
    } else if (isSucced && firstIsSucc) {
      SmartDashboard.putString("DB/String 8", "c");
    } else if (armDown && firstArmDown) {
      SmartDashboard.putString("DB/String 8", "a");
    } else {
      SmartDashboard.putString("DB/String 8", "n");
    }

    /*
     * public static boolean isSucced = false; public static boolean elevTop =
     * false; public static boolean elevBottom = false; public static boolean
     * haveBall = false; public static boolean armDown = false;
     */

  }

  public void save(File file) {
    try {
      ObjectOutputStream oos = new ObjectOutputStream(
          new BufferedOutputStream(new FileOutputStream("/home/lvuser/" + file)));
      oos.writeObject(motorValues);
      oos.writeObject(driveTrainSpeed);
      oos.close();
      FileInputStream inputStream = new FileInputStream(file);

      byte[] buffer = new byte[(int) file.length()];
      inputStream.read(buffer);

      URL url = new URL("ftp://anonymous@roborio-" + 834 + "-frc.local/home/lvuser/" + file);
      URLConnection conn = url.openConnection();

      conn.getOutputStream().write(buffer);
      conn.getOutputStream().close();
      inputStream.close();

      file.delete();
    } catch (Exception e1) {
      e1.printStackTrace();
    }

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    // LiveWindow.run();
  }
}
