// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team6429.robot;


import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

/** 
 * All Robot Constants 
*/
public class Constants {

    //Drive Motor Ports with "VictorSPX"
    public static final int driveOneLeftMotorID = 1;
    public static final int driveTwoLeftMotorID = 2;
    public static final int driveOneRightMotorID = 3;
    public static final int driveTwoRightMotorID = 4;

    //Drive Motor Ports with "TalonFX"
    public static final int rightOneMotorID = 0;
    public static final int rightTwoMotorID = 0;

    public static final int leftOneMotorID = 0;
    public static final int leftTwoMotorID = 0;

    //Other Subsystems Motor Ports and IDs
    public static final int intakeMotorID = 0;
    public static final int conveyorMotorID = 0;

    public static final int dumperMotorID = 0;

    //public static final int hangMotorPort = 0;
    public static final int hangMotorID = 0;

    //Solenoid Ports
    public static final int shifterPort = 15; //Single Solenoid for REVPH
    public static final int ptoPort = 14; //Single Solenoid for REVPH
    public static final int pivotPistonChannel = 13; //Single Solenoid for REVPH
    public static final int pivotPistonsForwardChannel = 13; //Double Solenoid for REVPH 
    public static final int pivotPistonsReverseChannel = 12; //Double Solenoid for REVPH

    public static final int shifter1Port = 0; //Single Solenoid for CTREPCM
    public static final int pto1Port = 1; //Single Solenoid for CTREPCM
    public static final int pivotPiston1Channel = 4; //Single Solenoid for CTREPCM
    public static final int pivotPistons1ForwardChannel = 2; //Double Solenoid for CTREPCM
    public static final int pivotPistons1ReverseChannel = 3; //Double Solenoid for CTREPCM

    //Pigeon port 
    public static final int pigeonID = 1;
    
    //PID Constants
    public static final double kDriveP = 0;
    public static final double kDriveI = 0;
    public static final double kDriveD = 0;

    //Feedforward Constants
    public static final double kDriveS = 0;
    public static final double kDriveV = 0;
    public static final double kDriveA = 0;

    public static final double maxVoltageInput = 12;

    //CANcoder Ports
    public static final int leftCANcoderID = 0;
    public static final int rightCANcoderID = 0;

    public static final int hangCANcoderID = 0;

    //Ultrasonic Constants
    public static final int higherUltrasonicPingChannel = 0;
    public static final int higherUltrasonicEchoChannel = 0;

    public static final int lowerUltrasonicPingChannel = 0;
    public static final int lowerUltrasonicEchoChannel = 0;
    
 
    //Drive Constants
    public static final double kTrackWidth = 0;
    public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(kTrackWidth);
    public static final double kMaxSpeed = 0;
    public static final double kMaxAcceleration = 0;
    public static final double kRamseteB = 0;
    public static final double kRamseteZeta = 0;
    public static final double kTrajectoryP = 0;

    public static final double shifterPulseDuration = 1;
    public static final double ptoPulseDuration = 1;
    public static final double pivotPulseDuration = 1; //for Single Solenoid

    //Gamepad and Drivepanel Constants
    public static final int gamepadJoystick = 0;
    public static final int panel1Joystick = 1;
    public static final int panel2Joystick = 2;

    //---Gamepad---
    public static final int axis_forward = 3;
    public static final int axis_reverse = 2;
    public static final int axis_steering = 0;
    public static final int axis_sensetiveSteering = 4;

    public static final int shifterButton = 6;
    public static final int shifterOneButton = 0;
    public static final int shifterTwoButton = 0;

    public static final int ptoButton = 5;

    public static final int customIndexerOnButtonGamepad = 0;
    public static final int customIndexerOffButtonGamepad = 0;

    public static final int intakeOnButtonGamepad = 0;
    public static final int intakeReverseButtonGamepad = 0;

    public static final int conveyorOnButtonGamepad = 0;
    public static final int conveyorReverseButtonGamepad = 0;

    public static final int dumperButtonGamepad = 0;
    public static final int dumperOppositeButtonGamepad = 0;

    //---Drivepanel---
    public static final int pivotUpButtonDrivepanel = 2;
    public static final int pivotDownButtonDrivepanel = 3;

    public static final int indexerOnButtonDrivepanel = 4;
    public static final int indexerReverseButtonDrivepanel = 7;

    public static final int intakeOnButtonDrivepanel = 0;
    public static final int intakeReverseButtonDrivepanel = 0;

    public static final int conveyorOnButtonDrivepanel = 0;
    public static final int conveyorReverseButtonDrivepanel = 0;

    //Distance Values
    public static final double ultrasonicDistanceAcross = 50.5;
    public static final double degreeCoefficientCANcoder = 0.087890625;
    public static final double wheelPerimeter = 0.31918581360472299303;
    public static final double canCoderCPR = 4096;
    
    //Necessary Constants
    public static final double traversalAngle = 0;
   
}

