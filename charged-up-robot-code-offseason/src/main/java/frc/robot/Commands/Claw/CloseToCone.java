package frc.robot.Commands.Claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Claw;

public class CloseToCone extends CommandBase {

    @Override
    public void initialize() {
        addRequirements(Claw.getIntance());

        if (Claw.getlimitSwitchConeBool()) {
            Claw.getIntance().close();
        }
    }

    @Override
    public boolean isFinished() {
        return !Claw.getlimitSwitchConeBool();
    }

    @Override
    public void end(boolean interrupted) {
        Claw.getIntance().stop();
    }

}
