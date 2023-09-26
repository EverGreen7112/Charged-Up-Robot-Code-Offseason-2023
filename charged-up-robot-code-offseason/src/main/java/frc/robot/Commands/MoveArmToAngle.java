package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Arm.ArmNumber;
import frc.robot.Utils.Consts;
import frc.robot.Utils.MathExtras;

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
        super.initialize();

        //angle range
        double targetAngle = MathExtras.clamp(m_targetAngle, Consts.ArmConsts.MIN_FIRST_ANGLE_RANGE, Consts.ArmConsts.MAX_FIRST_ANGLE_RANGE);

        if(m_armNumber == ArmNumber.FIRST_ARM){
            Arm.getInstance().turnFirstTo(targetAngle);
        }
        else if(m_armNumber == ArmNumber.SECOND_ARM){
            Arm.getInstance().turnSecondTo(m_targetAngle);
        }
    }

}