package frc.robot.Commands.Chassis.old;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;
import frc.robot.Utils.Vector2d;

public class OldDriveUntilIsTilted extends CommandBase {

    PIDController _anglePID;
    double _initYaw;
    int dir;

    public OldDriveUntilIsTilted(int dir){
        this.dir = dir;
    }

    @Override
    public void initialize() {
        _initYaw = Chassis.getInstance().getNavX().getAngle();
        _anglePID = new PIDController(Consts.ChassisConsts.ROTATE_KP, Consts.ChassisConsts.ROTATE_KI,
                Consts.ChassisConsts.ROTATE_KD);
    }

    @Override
    public void execute() {
        double speed = dir * 0.45;
        double angleSpeed = _anglePID.calculate(Chassis.getInstance().getNavX().getAngle(), _initYaw);
        Vector2d v = new Vector2d(speed + angleSpeed, speed - angleSpeed);
        v.normalise();
        Chassis.getInstance().driveTank(v.x * Math.abs(speed), v.y * Math.abs(speed));
    }

    @Override
    public boolean isFinished() {
        return Math.abs(Chassis.getInstance().getNavX().getRoll()) > 16;
    }
}
