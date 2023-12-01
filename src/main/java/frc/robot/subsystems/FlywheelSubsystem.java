package frc.robot.subsystems;

//imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class FlywheelSubsystem extends SubsystemBase {

    //motors
    private final WPI_TalonSRX flywheelMotor;
    
    public FlywheelSubsystem() {
        //motors
        flywheelMotor = new WPI_TalonSRX(10); //change port
    }

    public void setMotorSpeed(double speed){
        flywheelMotor.set(speed);
    }
}