package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Arm.ArmNumber;
import frc.robot.Utils.Consts;
import frc.robot.Utils.MathUtils;

public class MoveArmByAngle extends CommandBase{

    ArmNumber m_armNum;
    private double m_degrees;

    /**
     * @param armNumber - which arm to move(1 is the bigger arm 2 is the smaller arm)
     * @param targetAngle - target angle of arm(in degrees)
     */
    public MoveArmByAngle(ArmNumber armNum, double degrees){
        m_degrees = degrees;
        m_armNum = armNum;
    }

    @Override
    public void initialize() {
        addRequirements(Arm.getInstance());
        
        if(m_armNum == ArmNumber.FIRST_ARM){
            //angle range
            m_degrees = MathUtils.clamp(m_degrees, Consts.ArmConsts.MIN_FIRST_ANGLE_RANGE, Consts.ArmConsts.MAX_FIRST_ANGLE_RANGE);
            Arm.getInstance().turnFirstTo(Arm.getInstance().getFirstAngle() + m_degrees);
        }
        else if(m_armNum == ArmNumber.SECOND_ARM){
            m_degrees = MathUtils.clamp(m_degrees, Consts.ArmConsts.MIN_SECOND_ANGLE_RANGE, Consts.ArmConsts.MAX_SECOND_ANGLE_RANGE);
            Arm.getInstance().turnSecondTo(Arm.getInstance().getSecondAngle() + m_degrees);
        }
    }
}
