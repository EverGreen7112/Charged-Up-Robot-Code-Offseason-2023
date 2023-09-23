package frc.robot.Commands;

import com.revrobotics.SparkMaxAbsoluteEncoder;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;

public class driveMeter extends CommandBase {
    private double m_startingMeters;
    private double m_targetMeters;
    
    public driveMeter(double targetMeters){
        addRequirements(Chassis.getInstance());
        m_targetMeters = targetMeters;
    }
    @Override
    public void initialize() {
        m_startingMeters = Chassis.getInstance().getChassisMeters();
    }

    @Override
    public void execute() {
        Chassis.getInstance().driveTank(0.1,0.1);
    }

    @Override
    public boolean isFinished() {
        return Math.abs((Chassis.getInstance().getChassisMeters() - m_startingMeters) - m_targetMeters) < Consts.ChassisConsts.DRIVE_METERS_THRESHOLD;
    }

    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().stop();
    }

}
