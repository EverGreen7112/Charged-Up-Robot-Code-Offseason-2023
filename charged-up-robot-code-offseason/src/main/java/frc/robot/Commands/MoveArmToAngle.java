package frc.robot.Commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Arm.ArmNumber;
import frc.robot.Utils.Consts;
import frc.robot.Utils.MathUtils;

public class MoveArmToAngle extends CommandBase{
    
    private ArmNumber m_armNumber;
    private double m_targetAngle;

    /**
     * @param armNumber - which arm to move(1 is the bigger arm 2 is the smaller arm)
     * @param targetAngle - target angle of arm(in degrees)
     */
    public MoveArmToAngle(ArmNumber armNumber, double targetAngle){
        m_armNumber = armNumber;
        m_targetAngle = targetAngle;
    }

    @Override
    public void initialize() {
        addRequirements(Arm.getInstance());

        if(m_armNumber == ArmNumber.FIRST_ARM){
            //take care of other forces on the first arm
            Arm.getInstance().setF(ArmNumber.FIRST_ARM, Consts.ArmConsts.FIRST_ARM_KF * Math.sin(Math.toRadians(m_targetAngle)));

            //angle range
            m_targetAngle = MathUtils.clamp(m_targetAngle, Consts.ArmConsts.MIN_FIRST_ANGLE_RANGE, Consts.ArmConsts.MAX_FIRST_ANGLE_RANGE);
            Arm.getInstance().turnFirstTo(m_targetAngle);
        }
        else if(m_armNumber == ArmNumber.SECOND_ARM){
             //angle range
             m_targetAngle = MathUtils.clamp(m_targetAngle, Consts.ArmConsts.MIN_FIRST_ANGLE_RANGE, Consts.ArmConsts.MAX_FIRST_ANGLE_RANGE);
             
            //second arm does not have a physical range
            Arm.getInstance().turnSecondTo(m_targetAngle);
        }
    }
}
