package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;

public class TurnToAngle extends CommandBase {
    private double m_currentAngle;
    private boolean m_direction; // true is right
    private double m_targetAngle;

    public TurnToAngle(double targetAngle) {
        this.m_targetAngle = targetAngle;
    }

    @Override
    public void initialize() {
        double deltaAngle = m_targetAngle - m_currentAngle;
        if (deltaAngle >= 0) {
            m_direction = true;
        }
    }

    @Override
    public void execute() {
        double lastAngle = Chassis.getInstance().getChassisAngle();
        double P = m_targetAngle - m_currentAngle;
        double D = m_currentAngle - lastAngle;
        double PIDOutput = (P * Consts.ChassisConsts.TURN_KP) - (D * Consts.ChassisConsts.TURN_KD);
        if (m_direction == true) {
            Chassis.getInstance().driveTank(PIDOutput, -PIDOutput);// turn right
        } else {
            Chassis.getInstance().driveTank(-PIDOutput, PIDOutput);// turn left
        }
    }

    @Override
    public boolean isFinished() {
        // if you reached within TURN_ANGLE_THRESHOLD
        return (m_currentAngle - m_targetAngle) < Consts.ChassisConsts.TURN_ANGLE_THRESHOLD;
    }

    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().stop();
    }

}
