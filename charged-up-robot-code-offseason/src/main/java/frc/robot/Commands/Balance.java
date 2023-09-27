package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;

public class Balance extends CommandBase {
    public double lastPitch; 
    public double kFMultiplicator;
    public Balance() {
    }

    @Override
    public void initialize() {
        kFMultiplicator = Consts.ChassisConsts.BALANCE_KF;
        lastPitch = Chassis.getInstance().getNavX().getRoll();

        addRequirements(Chassis.getInstance());
    }

    @Override
    public void execute() {
        double currentPitch = Chassis.getInstance().getNavX().getRoll();
        double p = currentPitch; // target is roll 0
        Chassis.getInstance().driveTank(p * Consts.ChassisConsts.BALANCE_KP + kFMultiplicator, p * Consts.ChassisConsts.BALANCE_KP + kFMultiplicator);
        if ((lastPitch > 0 && currentPitch < 0) || (lastPitch < 0 && currentPitch > 0)){
            kFMultiplicator /= 2;
        }
        lastPitch = currentPitch;
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
