package frc.robot.subsystems;

//imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.XboxController;

public class flywheelSubsystems extends SubsystemBase {

    private final XboxController controller; 
    private final WPI_TalonSRX flywheelMotor;
    
    public flywheelSubsystems() {
        controller = new XboxController(0); //controllers

        //motors
        flywheelMotor = new WPI_TalonSRX(10); //change port
    }
}