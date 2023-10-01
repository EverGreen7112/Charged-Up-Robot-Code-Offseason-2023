package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Claw;

public class RollersInside extends CommandBase {

    public void initialize() {
        Claw.getIntance().rollInside();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    public void end() {
        Claw.getIntance().stopRollers();
    }

}
