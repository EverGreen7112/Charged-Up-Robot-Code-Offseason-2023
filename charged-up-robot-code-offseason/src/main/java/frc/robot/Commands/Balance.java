package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;

public class Balance extends CommandBase {
    private double m_lastPitch = Chassis.getInstance().getNavX().getPitch();
    public Balance(double targetMeters) {

    }

    @Override
    public void initialize() {
        addRequirements(Chassis.getInstance());

    }

    @Override
    public void execute() {

        double m_currentPitch = Chassis.getInstance().getNavX().getPitch();
        double offSet = 0 - m_currentPitch;
        double d = m_currentPitch - m_lastPitch;
        double pidOutput = (offSet * Consts.ChassisConsts.TURN_KP) - (d * Consts.ChassisConsts.TURN_KD);
        Chassis.getInstance().driveTank(pidOutput, pidOutput);// turn
        m_lastPitch = m_currentPitch;


    }

    @Override
    public boolean isFinished() {
        return (Math.abs(Chassis.getInstance().getNavX().getPitch()) < Consts.ChassisConsts.PITCH_ANGLE_THRESHOLD); 

    }

    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().stop();
    }
}
