// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DrivetrainSubsystem extends SubsystemBase {
  
  //motors
  private final WPI_TalonSRX rightMotor;
  private final WPI_TalonSRX rightFollower; 
  private final WPI_TalonSRX leftMotor; 
  private final WPI_TalonSRX leftFollower; 

  //scalar for slowing motor speed
  private final double motorScalar = 0.5;

  /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {
    //right motors
    rightMotor = new WPI_TalonSRX(0);
    rightFollower = new WPI_TalonSRX(1);
    rightFollower.follow(rightMotor);

    //inverting
    rightFollower.setInverted(true);
    rightMotor.setInverted(true); 

    //left motors
    leftMotor = new WPI_TalonSRX(2);
    leftFollower = new WPI_TalonSRX(3);
    leftFollower.follow(leftMotor);

  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  public void setSpeeds(double right, double left){
    right = right * motorScalar;
    left = left * motorScalar; //lowers speeds by scalar

    rightMotor.set(right);
    leftMotor.set(left);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}