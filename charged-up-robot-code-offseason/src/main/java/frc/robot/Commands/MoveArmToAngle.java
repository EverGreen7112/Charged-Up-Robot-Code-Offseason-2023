package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;
import frc.robot.Utils.Consts;
import frc.robot.Utils.MathExtras;

public class MoveArmToAngle extends CommandBase{
    
    private int m_armNumber;
    private double m_targetAngle;

    /**
     * @param armNumber - which arm to move(1 is the bigger arm 2 is the smaller arm)
     * @param targetAngle - target angle of arm(in degrees)
     */
    public MoveArmToAngle(int armNumber, double targetAngle){
        m_armNumber = armNumber;
        m_targetAngle = targetAngle;
    }

    @Override
    public void initialize() {
        super.initialize();

        //angle range
        double targetAngle = MathExtras.clamp(m_targetAngle, Consts.ArmConsts.MIN_ANGLE_RANGE, Consts.ArmConsts.MAX_ANGLE_RANGE);

        if(m_armNumber == 1){
            Arm.getInstance().turnFirstTo(targetAngle);
        }
        else if(m_armNumber == 2){
            Arm.getInstance().turnSecondTo(targetAngle);
        }
    }

}
