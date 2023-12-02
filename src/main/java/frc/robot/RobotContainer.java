// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.FlywheelSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.PnuematicSubsystem;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final FlywheelSubsystem flywheelSubsystem = new FlywheelSubsystem();
  private final PnuematicSubsystem pnuematic = new PnuematicSubsystem();

  //controller (more like CONTROLSLOLOL)
  private final XboxController controller; 

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    controller = new XboxController(0);
  }

  private void configureBindings() {

    drivetrainSubsystem.setDefaultCommand(new RunCommand( () -> {
      double y = -controller.getLeftY(); //x-box joystick axis is flipped for y-axis 
      double x = controller.getRightX();
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.

      //values lie between -2 <= x <= 2
      drivetrainSubsystem.setSpeeds(y - x, x + y);
      
    } , drivetrainSubsystem));

    flywheelSubsystem.setDefaultCommand(new RunCommand( () -> {
      double triggerAxis = controller.getRightTriggerAxis();
      boolean clicked = false;
 
      if(triggerAxis != 0){
        clicked = true;
        flywheelSubsystem.setMotorSpeed(0.57); //double check what way motors spin
      } else {
        clicked = false;
        flywheelSubsystem.setMotorSpeed(0);
      }

    } , flywheelSubsystem));
    
    pnuematic.setDefaultCommand(new RunCommand(() -> {
      
      //press A to extend the pnuematic and B to retract it
      if(controller.getAButtonPressed()){
        pnuematic.liftPnuem();
      } else if(controller.getBButtonPressed()){
        pnuematic.lowerPnuem();
      }

    }, pnuematic));
    
    flywheelSubsystem.setDefaultCommand(new RunCommand( () -> {
      double triggerAxis = controller.getRightTriggerAxis();
     
      boolean clicked = false;
 
 
      if(triggerAxis != 0){
        clicked = true;
      } else {
        clicked = false;
      }
 
 
      if(clicked == true){
          flywheelSubsystem.setMotorSpeed(0.8);; //double check what way motors spin
      } //sets the motor speed to 0.8, maybe golbalize variable?
     
    } , flywheelSubsystem));

  }
}
