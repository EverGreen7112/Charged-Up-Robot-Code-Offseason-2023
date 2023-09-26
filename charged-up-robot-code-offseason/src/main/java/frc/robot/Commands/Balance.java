package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;

public class Balance extends CommandBase {
    private double m_lastPitch = Chassis.getInstance().getNavX().getRoll();
    private double m_targetPitch;

    public Balance(double targetPitch) {
        this.m_targetPitch = targetPitch;
    }

    @Override
    public void initialize() {
        addRequirements(Chassis.getInstance());
    }

    @Override
    public void execute() {
        double currentPitch = Chassis.getInstance().getNavX().getRoll();
        double p = m_targetPitch - currentPitch;
        Chassis.getInstance().driveTank(p * Consts.ChassisConsts.BALANCE_KP, p * Consts.ChassisConsts.BALANCE_KP);

    }

    @Override
    public boolean isFinished() {
        return (Math.abs(Chassis.getInstance().getNavX().getRoll()) < Consts.ChassisConsts.PITCH_ANGLE_THRESHOLD); 

    }

    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().stop();
    }
}
