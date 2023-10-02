package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Claw;

public class RollersOutside extends CommandBase {

    public void initialize() {
        addRequirements(Claw.getIntance());
        Claw.getIntance().rollOutside();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    public void end() {
        Claw.getIntance().stopRollers();
    }

}
