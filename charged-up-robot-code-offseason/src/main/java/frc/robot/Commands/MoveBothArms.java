package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;
import frc.robot.Utils.Consts;
import frc.robot.Utils.MathExtras;

public class MoveBothArms extends CommandBase{
    
    private double m_firstTargetAngle, m_secondTargetAngle;
    
    public MoveBothArms(double firstTargetAngle, double secondTargetAngle){
        m_firstTargetAngle = firstTargetAngle;
        m_secondTargetAngle = secondTargetAngle;
    }

    @Override
    public void initialize() {
        //angle range
        double firstTargetAngle = MathExtras.clamp(m_firstTargetAngle, Consts.ArmConsts.MIN_FIRST_ANGLE_RANGE, Consts.ArmConsts.MAX_FIRST_ANGLE_RANGE);
        Arm.getInstance().turnFirstTo(firstTargetAngle);
    }

    @Override
    public void execute() {
        //angle range
        double firstTargetAngle = MathExtras.clamp(m_firstTargetAngle, Consts.ArmConsts.MIN_FIRST_ANGLE_RANGE, Consts.ArmConsts.MAX_FIRST_ANGLE_RANGE);
        if(Math.abs(firstTargetAngle - Arm.getInstance().getFirstAngle()) < Consts.ArmConsts.SECOND_ARM_OPEN_ANGLE_THRESHOLD){
            Arm.getInstance().turnSecondTo(m_secondTargetAngle);
        }
        else{
            Arm.getInstance().turnSecondTo(0);
        }
    }
}
