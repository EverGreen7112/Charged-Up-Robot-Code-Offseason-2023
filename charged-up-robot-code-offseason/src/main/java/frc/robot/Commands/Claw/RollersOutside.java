package frc.robot.Commands.Claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Claw;
import frc.robot.Utils.Consts;

public class RollersOutside extends CommandBase {

    private double m_speed;

    public RollersOutside(double speed){
        m_speed = speed;
    }

    public void initialize() {
        addRequirements(Claw.getIntance());
        Claw.getIntance().roll(-m_speed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Claw.getIntance().stopRollers();
    }

}
