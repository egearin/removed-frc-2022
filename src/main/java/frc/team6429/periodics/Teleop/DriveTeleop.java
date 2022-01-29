// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team6429.periodics.Teleop;


import frc.robot.Subsystems.Drive;
import frc.robot.Subsystems.Gamepad;

/** Teleop: Robot Drive*/
public class DriveTeleop {

    private static DriveTeleop mInstance = new DriveTeleop();
    
    public static DriveTeleop getInstance(){
        return mInstance;
    }

    private Gamepad mGamepad;
    private Drive mDrive;
    double rotation;
    
    public DriveTeleop(){
        mGamepad = Gamepad.getInstance();
        mDrive = Drive.getInstance();
    }
    
    public void driveTeleop(){
    double speed = mGamepad.getForward() - mGamepad.getReverse();
    if (Math.abs(mGamepad.getSensetiveSteering()) > 0.2){
      rotation = mGamepad.getSensetiveSteering() * 0.5;
    }
    else{
      rotation = mGamepad.getSteering() * 0.75;
    }
    mDrive.robotDrive(speed, rotation);
    mGamepad.forceFeedback(speed, rotation);
  }
}
