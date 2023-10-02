package frc.robot.Commands.Claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Claw;

public class CloseToCube extends CommandBase {

    public void initialize() {
        addRequirements(Claw.getIntance());

        if (Claw.getlimitSwitchCubeBool()) {
            Claw.getIntance().close();
        }
    }

    public boolean isFinished() {
        return !Claw.getlimitSwitchCubeBool();
    }

    @Override
    public void end(boolean interrupted) {
        Claw.getIntance().stop();

    }
}
