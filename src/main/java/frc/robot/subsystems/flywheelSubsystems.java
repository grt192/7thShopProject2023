package frc.robot.subsystems;

//imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class flywheelSubsystems extends SubsystemBase {
    //controllers
    private final XboxController controller;

    //motor
    private final WPI_TalonSRX flywheelMotor;

    public flywheelSubsystems() {
        //controllors
        controller = new XboxController(0); 

        //motor
        flywheelMotor = new WPI_TalonSRX(1);
    }

}