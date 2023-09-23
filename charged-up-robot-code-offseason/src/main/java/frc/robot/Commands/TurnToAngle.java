package frc.robot.Commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;

import com.kauailabs.navx.frc.AHRS;

public class TurnToAngle extends CommandBase {
    private double m_startingGyroAngle;
    private double m_targetGyroAngle;
    @Override
    public void initialize() {
        m_startingGyroAngle = Chassis.getInstance().getChassisAngle();
    }

    @Override
    public void execute() {
        Chassis.getInstance().driveTank(0.1, 0.1);
    }

    @Override
    public boolean isFinished() {
        return Math.abs(Chassis.getInstance().getChassisAngle() - m_startingGyroAngle )- m_targetGyroAngle < Consts.ChassisConsts.TURN_ANGLE_THRESHOLD;

    }

    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().stop();

    }

}
