package frc.robot.Commands.Claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Claw;
import frc.robot.Utils.Consts;

public class RollersInside extends CommandBase {

    public void initialize() {
        addRequirements(Claw.getIntance());
        Claw.getIntance().rollInside(Consts.ClawConsts.ROLLERS_POWER);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Claw.getIntance().stopRollers();
    }

}
