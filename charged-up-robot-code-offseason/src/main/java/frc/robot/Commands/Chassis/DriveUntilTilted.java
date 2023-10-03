package frc.robot.Commands.Chassis;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        return (Math.abs(Chassis.getInstance().getNavX().getRoll()) > Math.abs(Consts.ChassisConsts.MIN_TILTED) && Math.abs(Chassis.getInstance().getNavX().getRoll()) < Math.abs(Consts.ChassisConsts.MAX_TILTED));

    }
    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().driveTank(0, 0);
        //Chassis.getInstance().setIdleMode(IdleMode.kBrake);
    }
}
