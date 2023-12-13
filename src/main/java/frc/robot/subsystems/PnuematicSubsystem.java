// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class PnuematicSubsystem extends SubsystemBase {

  DoubleSolenoid chuteSolenoid; 
  
  public PnuematicSubsystem() {
    chuteSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 7);
    chuteSolenoid.set(kReverse);
  }

  //extends pnuematic
  public void liftPnuem(){ 
    chuteSolenoid.set(kForward);
  }

  //retracts pnuematic
  public void lowerPnuem(){
    chuteSolenoid.set(kReverse);
  }
}