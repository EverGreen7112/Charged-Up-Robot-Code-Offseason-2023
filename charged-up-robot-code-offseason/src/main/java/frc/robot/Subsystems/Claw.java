package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Utils.Consts;

public class Claw extends SubsystemBase {

    public TalonSRX m_clawMotor;
    private CANSparkMax m_clawRollers;

    private static DigitalInput m_limitSwitchOpen;
    private static DigitalInput m_limitSwitchCube;
    private static DigitalInput m_limitSwitchCone;

    private static Claw m_instance;

    public Claw() {
        m_clawMotor = new TalonSRX(Consts.ClawConsts.CLAW_MOTOR_ID);
        m_clawRollers = new CANSparkMax(Consts.ClawConsts.CLAW_ROLLERS_ID, MotorType.kBrushless);

        // m_limitSwitchOpen = new DigitalInput(Consts.ClawConsts.OPEN_SENSOR_CHANNEL);
        // m_limitSwitchCube = new
        // DigitalInput(Consts.ClawConsts.CLOSE_TO_CUBE_SENSOR_CHANNEL);
        // m_limitSwitchCone = new
        // DigitalInput(Consts.ClawConsts.CLOSE_TO_CONE_SENSOR_CHANNEL);
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

    public void rollInside() {
        m_clawRollers.set(Consts.ClawConsts.ROLLERS_POWER);
    }

    public void rollOutside() {
        m_clawRollers.set(-Consts.ClawConsts.ROLLERS_POWER);
    }

    public void stopRollers() {
        m_clawRollers.set(0);
    }

    public static Boolean getlimitSwitchOpenBool() {
        // return m_limitSwitchOpen.get();
        return true;
    }

    public static Boolean getlimitSwitchCubeBool() {
        // return m_limitSwitchCube.get();
        return true;
    }

    public static Boolean getlimitSwitchConeBool() {
        // return m_limitSwitchCone.get();
        return true;
    }

}
