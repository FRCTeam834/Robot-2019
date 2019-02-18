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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class RunAuton extends Command{
    private boolean[][] motorValues = new boolean[8][1500];
    private double[][] driveTrainSpeed = new double[2][1500];
    private int cycleCount = 0;
    public RunAuton(){
        requires(Robot.DriveTrain);
        requires(Robot.Arm);
        requires(Robot.BallIntake);
        requires(Robot.Elevator);
        requires(Robot.Compressor);
    }
    @Override
    protected void initialize(){
        Robot.Arm.setArm(0);
        Robot.BallIntake.setBallIntake(0);
        Robot.DriveTrain.setDrive(0, 0);
        Robot.Elevator.setElevator(0);
        cycleCount = 0;
        String file = SmartDashboard.getString("DB/String 0", "");
        try {
			File fileGet = new File("/home/lvuser/" + file);
			System.out.println(fileGet.getName());
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileGet)));
            motorValues = (boolean[][]) ois.readObject();
            driveTrainSpeed = (double[][]) ois.readObject();
			ois.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }
    @Override
    protected void execute(){
        Robot.DriveTrain.setDrive(driveTrainSpeed[0][cycleCount], driveTrainSpeed[1][cycleCount]);
        //Elevator
        if(motorValues[0][cycleCount]){
            new ElevatorUp();
        }
        else if (motorValues[1][cycleCount]){
            new ElevatorDown();
        }
        else{
            new ElevatorHold();
        }
        //Intake
        if(motorValues[2][cycleCount]){
            new BallIntakeIn();
        }
        else if (motorValues[3][cycleCount]){
            new BallIntakeOut();
        }
        else{
            new BallIntakeStop();
        }
        //Arm
        if(motorValues[4][cycleCount]){
            new ArmUp();
        }
        else if (motorValues[5][cycleCount]){
            new ArmDown();
        }
        else{
            new ArmHold();
        }
        //Compressor
        if(motorValues[6][cycleCount]){
            new CompressorOn();
        }
        else if (motorValues[7][cycleCount]){
            new CompressorStop();
        }
        //Maybe Add Elevator Presets in the Future
	}
    @Override
    protected boolean isFinished(){
        return false;
    }
    @Override
    protected void end(){
        Robot.Arm.setArm(0);
        Robot.BallIntake.setBallIntake(0);
        Robot.DriveTrain.setDrive(0, 0);
        Robot.Elevator.setElevator(0);
    }
    @Override
    protected void interrupted(){
        System.out.println("Auton Interrupted");
    }
}
