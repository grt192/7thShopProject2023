// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ExampleSubsystem extends SubsystemBase {
  
  //motors
  private final WPI_TalonSRX rightMotor;
  private final WPI_TalonSRX rightFollower; 
  private final WPI_TalonSRX leftMotor; 
  private final WPI_TalonSRX leftFollower; 

  //controller (more like CONTROLSLOLOL)
  private final XboxController controller; 

  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    rightMotor = new WPI_TalonSRX(0);
    rightFollower = new WPI_TalonSRX(1);
    rightFollower.follow(rightMotor);
    rightFollower.setInverted(true);
    rightMotor.setInverted(true); 


    leftMotor = new WPI_TalonSRX(2);
    leftFollower = new WPI_TalonSRX(3);
    leftFollower.follow(leftMotor);

    controller = new XboxController(0); //change port #
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

  public void forwardBackward(double speed){
    speed = speed * 0.2;
    rightMotor.set(speed);
    leftMotor.set(speed);
  }

  public void rightLeft(double speed, double magnitutde){
    speed = speed * 0.2;
   
    rightMotor.set(magnitutde * -1 * speed);
    leftMotor.set(speed);
  }

  public void bothSticksPressed(double speed, double magnitutde){
    speed = speed * 0.2;
    double dir = Math.signum(controller.getRightX());

    rightMotor.set(magnitutde * -1 * speed);
    leftMotor.set(speed * dir);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    if(controller.getRightX() == 0){
      forwardBackward(controller.getLeftY());
    } else if(controller.getLeftY() == 0){
      rightLeft(controller.getRightX(), 1.0);
    } else {
      bothSticksPressed(controller.getLeftY(), 1-Math.abs(controller.getRightX()));
    }

    //rightLeft(controller.getLeftY(), 1-controller.getRightX());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
