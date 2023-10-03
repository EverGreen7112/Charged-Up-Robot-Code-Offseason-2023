package frc.robot.Subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Utils.Consts;
import frc.robot.Utils.MathUtils;

public class Chassis extends SubsystemBase {
    public CANSparkMax m_rightForward, m_rightMid, m_rightBack, m_leftForward, m_leftMid, m_leftBack;
    private MotorControllerGroup m_rightMotors, m_leftMotors;
    private AHRS m_navX;
    private static Chassis m_chassis;

    public Chassis() {

        m_rightForward = new CANSparkMax(Consts.ChassisConsts.LEFT_FORWARD_ID, MotorType.kBrushless);
        m_rightMid = new CANSparkMax(Consts.ChassisConsts.LEFT_MID_ID, MotorType.kBrushless);
        m_rightBack = new CANSparkMax(Consts.ChassisConsts.LEFT_BACK_ID, MotorType.kBrushless);
        m_leftForward = new CANSparkMax(Consts.ChassisConsts.RIGHT_FORWARD_ID, MotorType.kBrushless);
        m_leftMid = new CANSparkMax(Consts.ChassisConsts.RIGHT_MID_ID, MotorType.kBrushless);
        m_leftBack = new CANSparkMax(Consts.ChassisConsts.RIGHT_BACK_ID, MotorType.kBrushless);

        m_rightMotors = new MotorControllerGroup(m_leftBack, m_leftMid, m_leftForward);
        m_leftMotors = new MotorControllerGroup(m_rightBack, m_rightMid, m_rightForward);

        m_rightMotors.setInverted(true);
        
        m_navX = new AHRS(SPI.Port.kMXP);
    }

    public static Chassis getInstance() {
        if (m_chassis == null) {
            m_chassis = new Chassis();
        }
        return m_chassis;
    }

    public void driveTank(double lSpeed, double rSpeed) {
        m_rightMotors.set(rSpeed);
        m_leftMotors.set(lSpeed);
    }

    public void stop() {
        driveTank(0.0, 0.0);
    }

    public double getRightChassisMeters() {
        return Math.abs(m_rightForward.getEncoder().getPosition() * Consts.ChassisConsts.DISTANCE_PER_TICK);
    }

    public double getLeftChassisMeters() {
        return Math.abs(m_leftForward.getEncoder().getPosition() * Consts.ChassisConsts.DISTANCE_PER_TICK);
    }

    public double getMeters(){
        return (getLeftChassisMeters() + getRightChassisMeters()) / 2;
    }

    public double getChassisAngle() {
        return MathUtils.trueModulu(m_navX.getAngle(), 360);
    }

    public double getRawChassisAngle() {
        return m_navX.getAngle();
    }

    public AHRS getNavX() {
        return m_navX;
    }

    public void setIdleMode(IdleMode mode) {
        this.m_rightForward.setIdleMode(mode);
        this.m_rightMid.setIdleMode(mode);
        this.m_rightBack.setIdleMode(mode);
        this.m_leftForward.setIdleMode(mode);
        this.m_leftMid.setIdleMode(mode);
        this.m_leftBack.setIdleMode(mode);

    }

    @Override
    public void periodic() {
    }
}
