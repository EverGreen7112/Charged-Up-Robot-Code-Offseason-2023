package frc.robot.Commands.Chassis.old;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;
import frc.robot.Utils.Vector2d;

public class OldBalance extends CommandBase {
    private double m_gyroValue;
    private double kp = 0.11/12, kd = 0.1, lastVal = 0;
    private PIDController _anglePID;
    private double _initYaw;
   

    @Override
    public void initialize() {
        _anglePID = new PIDController(Consts.ChassisConsts.ROTATE_KP, Consts.ChassisConsts.ROTATE_KI, Consts.ChassisConsts.ROTATE_KD);
        _initYaw = Chassis.getInstance().getNavX().getAngle();
        // Chassis.setMode(IdleMode.kCoast);
        Chassis.getInstance().setIdleMode(IdleMode.kBrake);
    }
    @Override
    public void execute() {
        if(Math.abs(Chassis.getInstance().getNavX().getRoll()) <= Consts.ChassisConsts.BALANCE_COMMAND_TOLERANCE){
            Chassis.getInstance().stop();
        }
        else{
            // Chassis.setMode(IdleMode.kCoast);
            m_gyroValue = -1 * Chassis.getInstance().getNavX().getRoll();
            if (Math.signum(lastVal) != Math.signum(m_gyroValue)) {
                kp *= 0.7;
                kd *= 0.4;
            }
            double distanceSpeed = kp * m_gyroValue - kd * (m_gyroValue - lastVal);
            lastVal = m_gyroValue;
        double angleSpeed = _anglePID.calculate(Chassis.getInstance().getNavX().getAngle(), _initYaw);
        Vector2d v = new Vector2d( distanceSpeed - angleSpeed, distanceSpeed + angleSpeed);
        v.normalise();
        Chassis.getInstance().driveTank(MathUtil.clamp(Math.abs(v.x) * Math.sqrt(2)* distanceSpeed, -12 * kp, 12 * kp),
        MathUtil.clamp(Math.abs(v.y) * Math.sqrt(2) *  distanceSpeed, -12 * kp, 12 * kp));
        }
        
        // SmartDashboard.putNumber("gyro value", m_gyroValue);
    }

    public boolean isFinished(){
   //     return 
        return false;
}
    @Override
    public void end(boolean interrupted) {
        // Chassis.setMode(IdleMode.kCoast);
        Chassis.getInstance().stop();
    }

}
