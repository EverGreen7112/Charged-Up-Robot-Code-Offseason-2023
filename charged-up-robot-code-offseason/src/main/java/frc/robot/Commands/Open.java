package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Claw;

public class Open extends CommandBase {
    public Open() {
    }

    public void initialize() {
        Claw.getIntance().open();
    }

    public void execute() {
    }

    public boolean isFinished() {
        return !Claw.getlimitSwitchOpenBool();
    }

    public void end() {
        Claw.getIntance().stop();
    }

    public void interrupted() {
    }
}
