package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Claw;

public class RollersOutside extends CommandBase {

    public void initialize() {
        Claw.getIntance().rollOutside();
    }

    public void end() {
        Claw.getIntance().stopRollers();
    }

}
