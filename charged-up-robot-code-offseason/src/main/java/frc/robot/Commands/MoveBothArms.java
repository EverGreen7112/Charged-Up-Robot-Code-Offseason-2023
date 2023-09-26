package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;
import frc.robot.Utils.Consts;
import frc.robot.Utils.MathUtils;

public class MoveBothArms extends CommandBase{
    
    private double m_firstTargetAngle, m_secondTargetAngle;
    
    /**
     * @param firstTargetAngle - target angle of the first arm(in degrees)
     * @param secondTargetAngle - target angle of the second arm(in degrees)
     */
    public MoveBothArms(double firstTargetAngle, double secondTargetAngle){
        m_firstTargetAngle = firstTargetAngle;
        m_secondTargetAngle = secondTargetAngle;
    }

    @Override
    public void initialize() {
        addRequirements(Arm.getInstance());

        //angle range
        double firstTargetAngle = MathUtils.clamp(m_firstTargetAngle, Consts.ArmConsts.MIN_FIRST_ANGLE_RANGE, Consts.ArmConsts.MAX_FIRST_ANGLE_RANGE);
        Arm.getInstance().turnFirstTo(firstTargetAngle);
    }

    @Override
    public void execute() {
        //angle range
        double firstTargetAngle = MathUtils.clamp(m_firstTargetAngle, Consts.ArmConsts.MIN_FIRST_ANGLE_RANGE, Consts.ArmConsts.MAX_FIRST_ANGLE_RANGE);
        if(Math.abs(firstTargetAngle - Arm.getInstance().getFirstAngle()) < Consts.ArmConsts.SECOND_ARM_OPEN_ANGLE_THRESHOLD){
            Arm.getInstance().turnSecondTo(m_secondTargetAngle);
        }
        else{
            Arm.getInstance().turnSecondTo(0);
        }
    }
}
