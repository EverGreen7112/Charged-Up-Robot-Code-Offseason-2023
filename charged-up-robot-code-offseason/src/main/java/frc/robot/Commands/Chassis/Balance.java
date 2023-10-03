package frc.robot.Commands.Chassis;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;

public class Balance extends CommandBase {
    public double lastRoll; 
    public double kFMultiplicator;
    public Balance() {
    }

    @Override
    public void initialize() {
        kFMultiplicator = Consts.ChassisConsts.BALANCE_KF;
        lastRoll = Chassis.getInstance().getNavX().getRoll();

        addRequirements(Chassis.getInstance());
    }

    @Override
    public void execute() {
        SmartDashboard.putBoolean("is in balance", true);
        double currentRoll = Chassis.getInstance().getNavX().getRoll();
        double p = currentRoll; // target is roll 0
        double motorInput = p * Consts.ChassisConsts.BALANCE_KP;
        Chassis.getInstance().driveTank(motorInput, motorInput);
        if ((lastRoll > 0 && currentRoll < 0) || (lastRoll < 0 && currentRoll > 0)){
            kFMultiplicator /= 2;
        }
        lastRoll = currentRoll;
    }

    @Override
    public boolean isFinished() {
        return ((Math.abs(Chassis.getInstance().getNavX().getRoll())) < 5);

    }

    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().driveTank(0, 0);
        //Chassis.getInstance().setIdleMode(IdleMode.kBrake);
    }
}
