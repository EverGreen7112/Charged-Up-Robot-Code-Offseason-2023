package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;
import frc.robot.Utils.MathUtils;

public class TurnToAngle extends CommandBase { // CR_NOTE: where documentation????
    private double m_targetAngle;
    private double m_lastAngle = Chassis.getInstance().getChassisAngle();

    public TurnToAngle(double targetAngle) {
        this.m_targetAngle = targetAngle;
    }

    @Override
    public void initialize() {
        addRequirements(Chassis.getInstance());

    }

    @Override
    public void execute() {
        double currentAngle = Chassis.getInstance().getChassisAngle();
        double clockWiseOffset = MathUtils.trueModulu(currentAngle - m_targetAngle, 360);
        double counterClockWise = currentAngle - 360;
        double offSet = clockWiseOffset <= (-1 * counterClockWise) ? clockWiseOffset : counterClockWise;
        double d = currentAngle - m_lastAngle;
        double pidOutput = (offSet * Consts.ChassisConsts.TURN_KP) - (d * Consts.ChassisConsts.TURN_KD);
        Chassis.getInstance().driveTank(pidOutput, -pidOutput);// turn
        m_lastAngle = currentAngle;
    }

    @Override
    public boolean isFinished() {
        // if you reached within TURN_ANGLE_THRESHOLD
        return Math.abs(
                m_targetAngle - Chassis.getInstance().getChassisAngle()) < Consts.ChassisConsts.TURN_ANGLE_THRESHOLD;
    }

    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().stop();
    }

}
