package com.phantommentalists.Twenty15;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDController;

/*
 */
public class PhantomOne extends SampleRobot {

    private Drive drive;
    public GameMech gameMech;
    private Gyro gyro;
    private Odometer odometer;
    private PIDController driveController;
    private PIDController turnController;

  public void autonomous() {
  }

  public void operatorControl() {
  }

}