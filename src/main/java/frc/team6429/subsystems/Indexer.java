// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team6429.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team6429.robot.Constants;
import frc.team6429.util.Sensors;
import frc.team6429.util.Utils;

/** Add your docs here. */
public class Indexer {

    private static Indexer mInstance = new Indexer();

    public static Indexer getInstance(){
        return mInstance;
    }

    //VictorSPX
    public WPI_VictorSPX intakeMotor;
    public WPI_VictorSPX conveyorMotor;

    //Speed
    public double intake_speed;
    public double conveyor_speed;

    //Solenoid 
    public DoubleSolenoid pivotPistons;
    //public Solenoid pivotPiston;
    
    //Solenoid States
    public Value kOff;
    public Value kForward;
    public Value kReverse;

    //Sensors
    public Sensors mSensors;


    public Indexer(){
        //intakeMotor = new WPI_VictorSPX(Constants.intakeMotorID);
        intakeMotor = Utils.makeVictorSPX(Constants.intakeMotorID, false);
        //conveyorMotor = new WPI_VictorSPX(Constants.conveyorMotorID);
        conveyorMotor = Utils.makeVictorSPX(Constants.conveyorMotorID, false);

        pivotPistons = new DoubleSolenoid(PneumaticsModuleType.REVPH, Constants.pivotPistonsForwardChannel, Constants.pivotPistonsReverseChannel);
        //pivotPiston = new Solenoid(PneumaticsModuleType.REVPH, Constants.pivotPistonChannel);

        //pivotPiston = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.pivotPiston1Channel);
        //pivotPistons = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.pivotPistons1ForwardChannel, Constants.pivotPistons1ReverseChannel);

        kOff = Value.kOff;
        kForward = Value.kForward;
        kReverse = Value.kReverse;
        //pivotPistons.set(kOff);

        mSensors = new Sensors();
    }

    //Default Indexer
    /**
     * Sets Intake and Conveyor On 
     * @param intakeSpeed
     * @param conveyorSpeed
     */
    public void indexerOn(double intakeSpeed, double conveyorSpeed){
        intakeMotor.set(intakeSpeed);
        conveyorMotor.set(conveyorSpeed);

    }

    /**
     * Sets Intake and Conveyor Reverse
     * @param intakeSpeed
     * @param conveyorSpeed
     */
    public void indexerReverse(double intakeSpeed, double conveyorSpeed){
        intakeMotor.set(-intakeSpeed);
        conveyorMotor.set(-conveyorSpeed);
    }

     /**
     * Stops Intake and Conveyor Motor
     */
    public void indexerStop(){
        intakeMotor.stopMotor();
        conveyorMotor.stopMotor();
    }   

    /**
     * Intake Pivot Up Function Using DoubleSolenoid: pivotPistons
     */
    public void pivotUp(){
        pivotPistons.set(kReverse);
    }

    /**
     * Intake Pivot Down Function Using DoubleSolenoid: pivotPistons
     */
    public void pivotDown(){
        pivotPistons.set(kForward);
    }

    /**
     * Intake Pivot Stall Function Using DoubleSolenoid: pivotPistons
     */
    public void pivotStall(){
        pivotPistons.set(kOff);
    }

    /**
     * Sets Only Conveyor On
     */
    public void conveyorOn(){
        conveyorMotor.set(1);
    }

    /** 
     * Sets Only Conveyor Reverse
     */
    public void conveyorReverse(){
        conveyorMotor.set(-1);
    }

    /**
     * Sets Only Conveyor Off
     */
    public void conveyorStop(){
        conveyorMotor.stopMotor();
    }

    /**
     * Sets Only Intake On
     */
    public void intakeOn(double speed){
        intakeMotor.set(speed);
    }

    /**
     * Sets Only Intake Reverse
     */
    public void intakeReverse(double speed){
        intakeMotor.set(-speed);
    }

    /**
     * Sets Only Intake Off
     */
    public void intakeStop(){
        intakeMotor.stopMotor();
    }
    
    //Custom Indexer
    /**
     * Custom Indexer On Function: Releases Intake Pivot, sets Intake Motor and Conveyor Motor On (indexer on and pivot down)
     */
    public void customIndexerOn(){
        pivotDown();
        indexerOn(1, 0.2);
    }

    /**
     * Custom Indexer Off Function: Lifts Intake Pivot, sets Intake Motor and Conveyor Motor Off (indexer off and pivot up)
     */
    public void customIndexerOff(){
        pivotUp();
        indexerStop();
    }

    /**
     * Will be used when the first cargo ball is detected, sets Conveyor Motor Off and Intake Motor On 
     */
    public void customIntakeFirstSection(){
        conveyorStop();
        intakeOn(1);
    }

    /**
     * Will be used when the second cargo ball is detected, sets Conveyor Motor and Intake Motor Off (indexer off)
     */
    public void customIntakeFinish(){
        indexerStop();
    }

    public void runWithBallCount(double intakeSpeed, double conveyorSpeed){
        double ballCount;
        ballCount = mSensors.getBallCount();

        indexerOn(intakeSpeed, conveyorSpeed);
        if(ballCount == 2){
            indexerStop();
        }
        else if(ballCount == 1){
            conveyorStop();
        }
        else{

        }
    }
}
