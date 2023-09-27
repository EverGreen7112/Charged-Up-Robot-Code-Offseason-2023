package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Arm.ArmNumber;
import frc.robot.Utils.Consts;
import frc.robot.Utils.MathUtils;

public class MoveArmByAngle extends CommandBase{

    private ArmNumber m_armNum;
    private double m_degrees;

    /**
     * @param armNumber - which arm to move(1 is the bigger arm 2 is the smaller arm)
     * @param degrees - the amount of degrees to move from current angle
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
            double targetAngle = MathUtils.clamp(Arm.getInstance().getFirstAngle() + m_degrees, Consts.ArmConsts.MIN_FIRST_ANGLE_RANGE, Consts.ArmConsts.MAX_FIRST_ANGLE_RANGE);
            //take care of other forces on the first arm
        Arm.getInstance().setF(ArmNumber.FIRST_ARM, Consts.ArmConsts.FIRST_ARM_KF * Math.sin(Math.toRadians(targetAngle)));

            Arm.getInstance().turnFirstTo(targetAngle);
        }
        else if(m_armNum == ArmNumber.SECOND_ARM){
            //angle range
            double targetAngle =  MathUtils.clamp(Arm.getInstance().getSecondAngle() + m_degrees, Consts.ArmConsts.MIN_SECOND_ANGLE_RANGE, Consts.ArmConsts.MAX_SECOND_ANGLE_RANGE);
            Arm.getInstance().turnSecondTo(targetAngle);
        }
    }
}
