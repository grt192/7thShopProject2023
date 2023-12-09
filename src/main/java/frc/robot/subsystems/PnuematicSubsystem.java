// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;

public class PnuematicSubsystem extends SubsystemBase {

  private final Solenoid chuteSolenoid;
  
  public PnuematicSubsystem() {
    chuteSolenoid = new Solenoid(null, 0);
  }

  //extends pnuematic
  public void liftPnuem(){ 
    chuteSolenoid.set(true);
  }

  //retracts pnuematic
  public void lowerPnuem(){
    chuteSolenoid.set(false);
  }
}
