package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Utils.Consts;

public class Arm extends SubsystemBase {

    private CANSparkMax m_firstArmMotor, m_secondArmMotor;
    private static Arm m_instance;

    public static enum ArmNumber {
        FIRST_ARM,
        SECOND_ARM
    }

    public Arm() {

        m_firstArmMotor = new CANSparkMax(Consts.ArmConsts.FIRST_ARM_ID, MotorType.kBrushless);
        m_secondArmMotor = new CANSparkMax(Consts.ArmConsts.SECOND_ARM_ID, MotorType.kBrushless);

        // config factory defaults in motor controllers
        m_firstArmMotor.restoreFactoryDefaults();
        m_secondArmMotor.restoreFactoryDefaults();

        // config pid values of motor controllers
        m_firstArmMotor.getPIDController().setP(Consts.ArmConsts.FIRST_ARM_KP);
        m_firstArmMotor.getPIDController().setI(Consts.ArmConsts.FIRST_ARM_KI);
        m_firstArmMotor.getPIDController().setD(Consts.ArmConsts.FIRST_ARM_KD);
        m_firstArmMotor.getPIDController().setFF(Consts.ArmConsts.FIRST_ARM_KF);

        m_secondArmMotor.getPIDController().setP(Consts.ArmConsts.SECOND_ARM_KP);
        m_secondArmMotor.getPIDController().setI(Consts.ArmConsts.SECOND_ARM_KI);
        m_secondArmMotor.getPIDController().setD(Consts.ArmConsts.SECOND_ARM_KD);
        m_secondArmMotor.getPIDController().setFF(Consts.ArmConsts.SECOND_ARM_KF);

        // convert rotation motor position value to degrees and take care of gear ratio
        m_firstArmMotor.getEncoder().setPositionConversionFactor(Consts.ArmConsts.FIRST_ARM_GEAR_RATIO * 360);
        m_secondArmMotor.getEncoder().setPositionConversionFactor(Consts.ArmConsts.SECOND_ARM_GEAR_RATIO * 360);

        // lock second arm
        m_secondArmMotor.setIdleMode(IdleMode.kBrake);
    }

    /**
     * @return the only instance of Arm
     */
    public static Arm getInstance() {
        if (m_instance == null) {
            m_instance = new Arm();
        }
        return m_instance;
    }

    @Override
    public void periodic() {
    }

    /**
     * @param angle target angle of the first arm in degrees(-180 - 180).
     */
    public void turnFirstTo(double angle) {
        m_firstArmMotor.getPIDController().setReference(angle, ControlType.kPosition);
    }

    /**
     * @param angle target angle of the second arm in degrees(-180 - 180).
     */
    public void turnSecondTo(double angle) {
        m_secondArmMotor.getPIDController().setReference(angle, ControlType.kPosition);
    }

    /**
     * @return current angle of first arm
     */
    public double getFirstAngle() {
        return m_firstArmMotor.getEncoder().getPosition();
    }

    /**
     * @return current angle of second arm
     */
    public double getSecondAngle() {
        return m_secondArmMotor.getEncoder().getPosition();
    }

    /**
     * @param armNumber - which arm to move(1 is the bigger arm 2 is the smaller
     *                  arm)
     * @param kf        - new value to assign to f.
     */
    public void setF(ArmNumber armNumber, double kf) {
        if (armNumber == ArmNumber.FIRST_ARM) {
            this.m_firstArmMotor.getPIDController().setFF(kf);
        } else if (armNumber == ArmNumber.SECOND_ARM) {
            this.m_secondArmMotor.getPIDController().setFF(kf);
        }
    }
}
