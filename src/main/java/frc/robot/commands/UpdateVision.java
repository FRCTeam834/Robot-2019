/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.MyVisionPipeline;

import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;

import edu.wpi.first.vision.VisionThread;

public class UpdateVision extends Command {
  public static MyVisionPipeline MyVisionPipeline;
  private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	public VisionThread visionThread;
  public double centerX = 0.0;
  public UsbCamera camera;
  CvSink cvSink;
  CvSource outputStream;
  Mat source;
  Mat output;
  KeyPoint[] mat;

  private final Object imgLock = new Object();

  public UpdateVision() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    //requires(Robot.MyVisionPipeline);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
    Robot.DriveTrain.stop();

    //Vision stuff
    cvSink = CameraServer.getInstance().getVideo();
    //outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
    source = new Mat();
    output = new Mat();
    cvSink.grabFrame(source);

    MyVisionPipeline = new MyVisionPipeline();
 
    MyVisionPipeline.process(source);

    SmartDashboard.putString("DB/String 8", "BlobsTotal:" + Long.toString(MyVisionPipeline.findBlobsOutput().total()));

    //SmartDashboard.putString("DB/String 7", "BlockPos:" + Integer.toString(MyVisionPipeline.findBlobsOutput().toArray().length));
    //SmartDashboard.putString("DB/String 8", Double.toString(centerX));

    if (MyVisionPipeline.findBlobsOutput().toArray() == null) {

        System.out.println("Ahh it's null!");

    } //else {  

      //mat = MyVisionPipeline.findBlobsOutput().toArray();
      //System.out.println(mat.length);
      /*
      if(mat.length != 0) {
        
        //System.out.println(mat[0]);
      }
      else {
        System.out.println("Caracoles! Something didn't work :(");
      }
      //System.out.println("It's not null...");
      //System.out.println(MyVisionPipeline.findBlobsOutput().toArray().toString());
      */

    //}
    //System.out.println(GroundEye.findTape());
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
