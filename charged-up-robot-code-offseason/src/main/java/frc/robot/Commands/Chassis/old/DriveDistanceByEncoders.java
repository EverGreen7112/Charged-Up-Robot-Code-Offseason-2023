package frc.robot.Commands.Chassis.old;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;
import frc.robot.Utils.MathUtils;
import frc.robot.Utils.Vector2d;

public class DriveDistanceByEncoders extends CommandBase {
    private double _targetDistance;
    private double _distance, _feedForward = 0;
    private PIDController _distancePID;
    private PIDController _anglePID;

    /*
     *
     * / *
     * /**
     *
     * @param distance the distance to drive in meters
     *
     * @param distanceTolerance the error tolerance for the PID in meters
     */
    public DriveDistanceByEncoders(double distance, double distanceTolerance) {
        addRequirements(Chassis.getInstance());
        _distance = distance;
        _distancePID = new PIDController(Consts.ChassisConsts.DRIVE_KP,
        Consts.ChassisConsts.DRIVE_KI, Consts.ChassisConsts.DRIVE_KD);
        _distancePID.setTolerance(distanceTolerance);

        // _anglePID = new PIDController(Consts.ChassisConsts.ROTATE_KP,
        //     Consts.ChassisConsts.ROTATE_KI, Consts.ChassisConsts.ROTATE_KD);
        _anglePID = new PIDController(0, 0, 0); //turn off angle pid
    }

    /**
     * @param distance  the distance to drive in meters
     * @param tolerance the error tolerance for the PID in meters
     */
    public DriveDistanceByEncoders(double distance, double tolerance, double kf) {
        addRequirements(Chassis.getInstance());
        _distance = distance;
        _distancePID = new PIDController(Consts.ChassisConsts.DRIVE_KP,
            Consts.ChassisConsts.DRIVE_KI, Consts.ChassisConsts.DRIVE_KD);
        _feedForward = kf * distance;
        _distancePID.setTolerance(tolerance);

        _anglePID = new PIDController(Consts.ChassisConsts.ROTATE_KP,
        Consts.ChassisConsts.ROTATE_KI, Consts.ChassisConsts.ROTATE_KD);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        _targetDistance = Chassis.getInstance().getMeters() + _distance;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // SmartDashboard.putNumber("distance", Chassis.getEncodersDist() -
        // (_targetDistance - _distance));
        // SmartDashboard.putNumber("angle: ", Chassis.getRobotAngle());
        double distanceSpeed = _feedForward +
                (_distancePID.calculate(Chassis.getInstance().getMeters(), _targetDistance));
        double angleSpeed = _anglePID.calculate(Chassis.getInstance().getNavX().getAngle(), 0);
        Vector2d v = new Vector2d(MathUtils.clamp(distanceSpeed - angleSpeed, -1.0,
                1.0),
                MathUtils.clamp(distanceSpeed + angleSpeed, -1.0, 1.0));
        v.normalise();
        v.mul(Math.abs(distanceSpeed) * Math.sqrt(2));
        // Chassis.driveTank(v.x * (Math.signum(_distance)), v.y *
        // (Math.signum(_distance)));
        Chassis.getInstance().driveTank(v.x, v.y);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return _distancePID.atSetpoint();
    }
}
