package frc.robot.Commands;

import com.revrobotics.SparkMaxAbsoluteEncoder;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;

public class driveMeter extends CommandBase {
    private double m_startingMeters;
    private double m_targetMeters;

    public driveMeter(double targetMeters) {
        addRequirements(Chassis.getInstance());
        m_targetMeters = targetMeters;
    }

    @Override
    public void initialize() {
        m_startingMeters = Chassis.getInstance().getChassisMeters();
    }

    @Override
    public void execute() {
        double lastMeter = Chassis.getInstance().getChassisMeters();
        double P = m_targetMeters - (Chassis.getInstance().getChassisMeters());
        double D = (Chassis.getInstance().getChassisMeters()) - lastMeter;
        double PIDOutput = (P * Consts.ChassisConsts.TURN_KP) - (D * Consts.ChassisConsts.TURN_KD);

        Chassis.getInstance().driveTank(PIDOutput, PIDOutput);
    }

    @Override
    public boolean isFinished() {
        double metersDriven = Math.abs(Chassis.getInstance().getChassisMeters() - m_startingMeters);
        return (metersDriven - m_targetMeters) < Consts.ChassisConsts.DRIVE_METERS_THRESHOLD;
        // if reached within 10 cm of target stop
    }

    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().stop();
    }

}
