// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.FlywheelSubsystem;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.PnuematicSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final FlywheelSubsystem flywheelSubsystem = new FlywheelSubsystem();
  private final PnuematicSubsystem pnuematic = new PnuematicSubsystem();

  //controller (more like CONTROLSLOLOL)
  private final XboxController controller; 
  private final XboxController DTcontroller; 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    controller = new XboxController(1); //controllers
    DTcontroller = new XboxController(0);

    // Configure the trigger bindings
    configureBindings();
    
  }

  private void configureBindings() {

    drivetrainSubsystem.setDefaultCommand(new RunCommand( () -> {
      double y = -DTcontroller.getLeftY(); //x-box joystick axis is flipped for y-axis 
      double x = DTcontroller.getRightX();
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
        flywheelSubsystem.setMotorSpeed(0.575); //double check what way motors spin
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

  }
}
