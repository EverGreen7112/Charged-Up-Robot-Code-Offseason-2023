package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Claw;

public class CloseToCube extends CommandBase {
    public CloseToCube() {
    }

    public void initialize() {
        Claw.getIntance().close();
    }

    public void execute() {
    }

    public boolean isFinished() {
        return !Claw.getlimitSwitchCubeBool();
    }

    public void end() {
        Claw.getIntance().stop();
    }

    public void interrupted() {
    }
}
