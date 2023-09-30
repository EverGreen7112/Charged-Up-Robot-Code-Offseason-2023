package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Arm.ArmNumber;
import frc.robot.Utils.Consts;
import frc.robot.Utils.MathUtils;

public class MoveBothArms extends CommandBase{
    
    private double m_firstTargetAngle, m_secondTargetAngle;
    
    /**
     * Move the first arm and then the second.
     * @param firstTargetAngle target angle of the first arm(in degrees)
     * @param secondTargetAngle target angle of the second arm(in degrees)
     */
    public MoveBothArms(double firstTargetAngle, double secondTargetAngle){
        m_firstTargetAngle = MathUtils.clamp(firstTargetAngle, Consts.ArmConsts.MIN_FIRST_ANGLE_RANGE, Consts.ArmConsts.MAX_FIRST_ANGLE_RANGE);
        m_secondTargetAngle = MathUtils.clamp(secondTargetAngle, Consts.ArmConsts.MIN_SECOND_ANGLE_RANGE, Consts.ArmConsts.MAX_SECOND_ANGLE_RANGE);
    }

    @Override
    public void initialize() {
        addRequirements(Arm.getInstance());

        //take care of other forces on the first arm
        Arm.getInstance().setF(ArmNumber.FIRST_ARM, Consts.ArmConsts.FIRST_ARM_KF * Math.sin(Math.toRadians(m_firstTargetAngle)));
        Arm.getInstance().turnFirstTo(m_firstTargetAngle);
    }

    @Override
    public void execute() {        
        //start moving the second arm in threshold 
        if(Math.abs(m_firstTargetAngle - Arm.getInstance().getFirstAngle()) < Consts.ArmConsts.SECOND_ARM_OPEN_ANGLE_THRESHOLD){
            Arm.getInstance().turnSecondTo(m_secondTargetAngle);
        }
        else{
            Arm.getInstance().turnSecondTo(0);
        }
        
    }
}
