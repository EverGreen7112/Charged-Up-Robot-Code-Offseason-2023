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
        public static final int FIRST_ARM_ID = 13;
        public static final int SECOND_ARM_ID = 15;

        public static final double FIRST_ARM_GEAR_RATIO =  14 / 50;
        public static final int SECOND_ARM_GEAR_RATIO = 14 / 50;

        public static final double MAX_FIRST_ANGLE_RANGE = 170; //max angle the first arm can move to
        public static final double MIN_FIRST_ANGLE_RANGE = -170; //min angle the first arm can move to

        public static final double MAX_SECOND_ANGLE_RANGE = 180; //max angle the second arm can move to
        public static final double MIN_SECOND_ANGLE_RANGE = -180; //min angle the second arm can move to

        public static final double FIRST_ARM_KP = 0.009;
        public static final double FIRST_ARM_KI = 0;
        public static final double FIRST_ARM_KD = 0.025;
        public static final double FIRST_ARM_KF = 0.053;

        public static final double SECOND_ARM_KP = 0.006;
        public static final double SECOND_ARM_KI = 0;
        public static final double SECOND_ARM_KD = 0;
        public static final double SECOND_ARM_KF = 0;

        public static final double SECOND_ARM_OPEN_ANGLE_THRESHOLD = 10; // threshold to start moving second arm (in degrees)
    }

}
