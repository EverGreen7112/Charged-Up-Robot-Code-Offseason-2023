package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Utils.Consts;

public class Chassis extends SubsystemBase {
    private CANSparkMax rightForward, rightMid, rightBack, leftForward, leftMid, leftBack;
    private MotorControllerGroup rightMotors, leftMotors;

    private static Chassis m_chassis;

    public Chassis() {
        rightForward = new CANSparkMax(Consts.ChassisConsts.LEFT_FORWARD_ID, MotorType.kBrushless);
        rightMid = new CANSparkMax(Consts.ChassisConsts.LEFT_MID_ID, MotorType.kBrushless);
        rightBack = new CANSparkMax(Consts.ChassisConsts.LEFT_BACK_ID, MotorType.kBrushless);
        leftForward = new CANSparkMax(Consts.ChassisConsts.RIGHT_FORWARD_ID, MotorType.kBrushless);
        leftMid = new CANSparkMax(Consts.ChassisConsts.RIGHT_MID_ID, MotorType.kBrushless);
        leftBack = new CANSparkMax(Consts.ChassisConsts.RIGHT_BACK_ID, MotorType.kBrushless);

        rightMotors = new MotorControllerGroup(leftBack, leftMid, leftForward);
        leftMotors = new MotorControllerGroup(rightBack, rightMid, rightForward);
    
    }
    public static Chassis getInstance(){
        if(m_chassis == null){
            m_chassis = new Chassis();
        }
        return m_chassis;
    }
    public void SetChassis(double rightMotorSpeed, double leftMotorSpeed){
        this.rightMotors.set(rightMotorSpeed);
        this.leftMotors.set(leftMotorSpeed);
    }
    public void driveTank(double lSpeed, double rSpeed){
        rightMotors.set(rSpeed);
        leftMotors.set(lSpeed);
    }
    public void stop(){
        driveTank(0.0, 0.0);
    }

}
