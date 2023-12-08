package frc.robot.subsystems;

//imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
public class FlywheelSubsystem extends SubsystemBase {
    //motor
    private final CANSparkMax flywheelMotor;

    public FlywheelSubsystem() {
        //motor
        flywheelMotor = new CANSparkMax(0, MotorType.kBrushless);
    }

    public void setMotorSpeed(double speed){
        flywheelMotor.set(speed);
    }
}