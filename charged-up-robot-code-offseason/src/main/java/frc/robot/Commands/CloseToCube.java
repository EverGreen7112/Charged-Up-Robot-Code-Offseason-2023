package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Claw;

public class CloseToCube extends CommandBase {

    public void initialize() {
        if (Claw.getlimitSwitchCubeBool()) {
            Claw.getIntance().close();
        }
    }

    public boolean isFinished() {
        return !Claw.getlimitSwitchCubeBool();
    }

    public void end() {
        Claw.getIntance().stop();
    }

}
