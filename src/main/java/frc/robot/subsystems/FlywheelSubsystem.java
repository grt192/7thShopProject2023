package frc.robot.subsystems;

//imports
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;

public class FlywheelSubsystem extends SubsystemBase {
    //controller
    private final XboxController controller;

    //motor
    private final CANSparkMax flywheelMotor;

    public FlywheelSubsystem() {
        //controllor 
        controller = new XboxController(0); 

        //motor
        flywheelMotor = new CANSparkMax(0, MotorType.kBrushless);
    }
}