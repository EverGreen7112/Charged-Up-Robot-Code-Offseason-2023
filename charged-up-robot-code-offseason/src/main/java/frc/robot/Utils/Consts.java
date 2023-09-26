package frc.robot.Utils;

import java.util.ArrayList;

public class Consts {
    public class ChassisConsts{
        public static final int LEFT_FORWARD_ID = 0;
        public static final int LEFT_MID_ID = 0;
        public static final int LEFT_BACK_ID = 0;
        public static final int RIGHT_FORWARD_ID = 0;
        public static final int RIGHT_MID_ID = 0;
        public static final int RIGHT_BACK_ID = 0;
    }
    
    public class ArmConsts{
        public static final int FIRST_ARM_ID = 0;
        public static final int SECOND_ARM_ID = 0;

        public static final double FIRST_ARM_GEAR_RATIO =  0; // 1 / number
        public static final int SECOND_ARM_GEAR_RATIO = 0;// 1 / number

        public static final double MAX_ANGLE_RANGE = 170;
        public static final double MIN_ANGLE_RANGE = -170;

        public static final double FIRST_ARM_KP = 0;
        public static final double FIRST_ARM_KI = 0;
        public static final double FIRST_ARM_KD = 0;
        public static final double FIRST_ARM_KF = 0;

        public static final double SECOND_ARM_KP = 0;
        public static final double SECOND_ARM_KI = 0;
        public static final double SECOND_ARM_KD = 0;
        public static final double SECOND_ARM_KF = 0;

        public static final double SECOND_ARM_OPEN_ANGLE_THRESHOLD = 10; // threshold to start moving second arm
    }

}
