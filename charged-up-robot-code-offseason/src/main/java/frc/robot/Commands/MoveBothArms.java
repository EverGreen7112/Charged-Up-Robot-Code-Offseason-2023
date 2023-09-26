package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;
import frc.robot.Utils.Consts;

public class MoveBothArms extends CommandBase{
    
    private double m_firstTargetAngle, m_secondTargetAngle;
    
    public MoveBothArms(double firstTargetAngle, double secondTargetAngle){
        m_firstTargetAngle = firstTargetAngle;
        m_secondTargetAngle = secondTargetAngle;
    }

    @Override
    public void initialize() {
        Arm.getInstance().turnFirstTo(m_firstTargetAngle);
    }

    @Override
    public void execute() {
        if(Math.abs(m_firstTargetAngle - Arm.getInstance().getFirstAngle()) < Consts.ArmConsts.SECOND_ARM_OPEN_ANGLE_THRESHOLD){
            Arm.getInstance().turnSecondTo(m_secondTargetAngle);
        }
        else{
            Arm.getInstance().turnSecondTo(0);
        }
    }
}
