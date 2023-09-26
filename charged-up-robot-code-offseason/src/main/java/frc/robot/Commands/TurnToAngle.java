package frc.robot.Commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;
import frc.robot.Utils.MathUtils;

import com.kauailabs.navx.frc.AHRS;

public class TurnToAngle extends CommandBase {
    private double m_currentAngle;
    private boolean m_rightOrLeft;
    private double m_targetGyroAngle;
    public TurnToAngle(double m_targetGyroAngle){
        this.m_targetGyroAngle = m_targetGyroAngle;
    }
    @Override
    public void initialize() {  
        if(Math.abs(MathUtils.trueModulu(m_targetGyroAngle - m_currentAngle,360)) >= ((Math.abs(MathUtils.trueModulu(m_targetGyroAngle - m_currentAngle,360))) - 360)){
            m_rightOrLeft = true;
        }
        else {
            m_rightOrLeft = false;
        }

    }

    @Override
    public void execute() {
        double lastAngle = Chassis.getInstance().getChassisAngle();
        double P = m_targetGyroAngle - m_currentAngle;
        double D = m_currentAngle - lastAngle;
        double PIDOutput = (P * Consts.ChassisConsts.TURN_KP) - (D * Consts.ChassisConsts.TURN_KD);
        if (m_rightOrLeft == true){
            Chassis.getInstance().driveTank(PIDOutput, -PIDOutput);
        }
        else{
            Chassis.getInstance().driveTank(PIDOutput ,-PIDOutput);
        }
    }

    @Override
    public boolean isFinished() {
        return (m_currentAngle- m_targetGyroAngle) < Consts.ChassisConsts.TURN_ANGLE_THRESHOLD;
    }

    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().stop();

    }

}
