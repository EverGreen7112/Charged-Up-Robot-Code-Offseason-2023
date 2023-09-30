package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Claw;

public class Open extends CommandBase {

    public void initialize() {
        if (Claw.getlimitSwitchOpenBool()) {
            Claw.getIntance().open();
        }
    }

    public boolean isFinished() {
        return !Claw.getlimitSwitchOpenBool();
    }

    public void end() {
        Claw.getIntance().stop();
    }
}
