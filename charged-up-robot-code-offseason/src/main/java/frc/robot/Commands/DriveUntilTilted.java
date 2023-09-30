package frc.robot.Commands;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;

public class DriveUntilTilted extends CommandBase{
    @Override
    public void initialize() {
        addRequirements(Chassis.getInstance());
    }
    @Override
    public void execute() {
        Chassis.getInstance().driveTank(Consts.ChassisConsts.DRIVE_UNTIL_TILTED_SPEED, Consts.ChassisConsts.DRIVE_UNTIL_TILTED_SPEED);
    }
    @Override
    public boolean isFinished() {
        return (Math.abs(Chassis.getInstance().getNavX().getRoll()) > Consts.ChassisConsts.TILTED_THRESH_HOLD);
    }
    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().setIdleMode(IdleMode.kBrake);
    }
}
