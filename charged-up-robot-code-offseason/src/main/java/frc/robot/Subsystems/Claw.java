package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Utils.Consts;

public class Claw extends SubsystemBase {

    public TalonSRX m_clawMotor;
    private CANSparkMax m_clawLeftRollers;
    private CANSparkMax m_clawRightRollers;

    private static DigitalInput m_limitSwitchOpen;
    private static DigitalInput m_limitSwitchCube;
    private static DigitalInput m_limitSwitchCone;

    private static Claw m_instance;

    public Claw() {
        m_clawMotor = new TalonSRX(Consts.ClawConsts.CLAW_MOTOR_ID);
        m_clawLeftRollers = new CANSparkMax(Consts.ClawConsts.CLAW_LEFT_ROLLERS_ID, MotorType.kBrushless);
        m_clawRightRollers = new CANSparkMax(Consts.ClawConsts.CLAW_RIGHT_ROLLERS_ID, MotorType.kBrushless);

        m_limitSwitchOpen = new DigitalInput(Consts.ClawConsts.OPEN_SENSOR_CHANNEL);
        m_limitSwitchCube = new DigitalInput(Consts.ClawConsts.CLOSE_TO_CUBE_SENSOR_CHANNEL);
        m_limitSwitchCone = new DigitalInput(Consts.ClawConsts.CLOSE_TO_CONE_SENSOR_CHANNEL);

        m_clawLeftRollers.setIdleMode(IdleMode.kBrake);
        m_clawRightRollers.setIdleMode(IdleMode.kBrake);

        m_clawLeftRollers.setInverted(true);
    }

    public static Claw getIntance() {
        if (m_instance == null) {
            m_instance = new Claw();
        }
        return m_instance;
    }

    public void open() {
        m_clawMotor.set(ControlMode.PercentOutput, Consts.ClawConsts.CLAW_POWER);
    }

    public void close() {
        m_clawMotor.set(ControlMode.PercentOutput, -Consts.ClawConsts.CLAW_POWER);
    }

    public void stop() {
        m_clawMotor.set(ControlMode.PercentOutput, 0);
    }

    public void rollInside(double power) {
        m_clawLeftRollers.set(power);
        m_clawRightRollers.set(power);
    }

    public void stopRollers() {
        m_clawLeftRollers.set(0);
        m_clawRightRollers.set(0);
    }

    public static Boolean getlimitSwitchOpenBool() {
        return m_limitSwitchOpen.get();
    }

    public static Boolean getlimitSwitchCubeBool() {
        return m_limitSwitchCube.get();
    }

    public static Boolean getlimitSwitchConeBool() {
        return m_limitSwitchCone.get();
    }

}
