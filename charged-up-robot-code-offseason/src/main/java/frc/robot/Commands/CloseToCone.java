package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Claw;

public class CloseToCone extends CommandBase {

    public void initialize() {
        addRequirements(Claw.getIntance());

        if (Claw.getlimitSwitchConeBool()) {
            Claw.getIntance().close();
        }
    }

    public boolean isFinished() {
        return !Claw.getlimitSwitchConeBool();
    }

    public void end() {
        Claw.getIntance().stop();
    }

}
