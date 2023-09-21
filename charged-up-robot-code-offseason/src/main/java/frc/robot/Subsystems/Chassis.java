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


}
