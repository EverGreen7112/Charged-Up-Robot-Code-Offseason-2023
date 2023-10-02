package frc.robot.Utils;

public class Consts {
    public class ChassisConsts {
        public static final int LEFT_FORWARD_ID = 14;
        public static final int LEFT_MID_ID = 1;
        public static final int LEFT_BACK_ID = 2;
        public static final int RIGHT_FORWARD_ID = 12;
        public static final int RIGHT_MID_ID = 3;
        public static final int RIGHT_BACK_ID = 4;

        public static final double SPEED = 0.3;
        public static final double JOYSTICK_THRESHOLD = 0.2;
        public static final double DISTANCE_PER_ROTATION = 2 * Math.PI * 0.076; // wheel perimeter(in meters)
        public static final double CHASSIS_WHEEL_GEAR_RATIO = 1 / 4.128326627;

        public static final double DRIVE_METERS_THRESHOLD = 0.1;
        public static final double TURN_ANGLE_THRESHOLD = 2;

        public static final double TURN_KP = 0;
        public static final double TURN_KD = 0;

        public static final double MOVE_KP = 0;
        public static final double MOVE_KD = 0;

        public static final double PITCH_ANGLE_THRESHOLD = 2;

        public final static double ROTATE_KP = 0.05 / 40;
        public final static double ROTATE_KI = 0.001 / 20;
        public final static double ROTATE_KD = 0.003 / 20;
        public final static double ROTATE_P_TOLERANCE = 2;
        public final static double ROTATE_V_TOLERANCE = 10;

        public final static double DRIVE_KP = 0;
        public final static double DRIVE_KI = 0;
        public final static double DRIVE_KD = 0;

        public final static double BALANCE_COMMAND_TOLERANCE = 0;

        public static final double TILTED_THRESH_HOLD = 1;
        public static final double DRIVE_UNTIL_TILTED_SPEED = 0.1;

    }

    public class ArmConsts {
        public static final int FIRST_ARM_ID = 13;
        public static final int SECOND_ARM_ID = 15;

        public static final double FIRST_ARM_GEAR_RATIO = 1 / 178.3928569921875; // 14 / 50 / 3;
        public static final double SECOND_ARM_GEAR_RATIO = 1 / 97.2; // 14 / 50 / 3;

        public static final double MAX_FIRST_ANGLE_RANGE = 170; // max angle the first arm can move to
        public static final double MIN_FIRST_ANGLE_RANGE = -170; // min angle the first arm can move to

        public static final double MAX_SECOND_ANGLE_RANGE = 180; // max angle the second arm can move to
        public static final double MIN_SECOND_ANGLE_RANGE = -180; // min angle the second arm can move to

        public static final double FIRST_ARM_KP = 0.013;
        public static final double FIRST_ARM_KI = 0;
        public static final double FIRST_ARM_KD = 0;
        public static final double FIRST_ARM_KF = 0.000948;

        public static final double SECOND_ARM_KP = 0.0075; //0.0055
        public static final double SECOND_ARM_KI = 0.000001;
        public static final double SECOND_ARM_KD = 0.0002;
        public static final double SECOND_ARM_KF = 0.00; //0.002

        public static final double SECOND_ARM_OPEN_ANGLE_THRESHOLD = 4; // threshold to start moving second arm (in
                                                                        // degrees)
        public static final double FIRST_ARM_OPEN_ANGLE_THRESHOLD = 8; // threshold for first arm to start moving (in
                                                                       // degrees)
    }

    public class ClawConsts {
        public static final int CLAW_MOTOR_ID = 1;
        public static final int CLAW_LEFT_ROLLERS_ID = 10;
        public static final int CLAW_RIGHT_ROLLERS_ID = 21;

        public static final int OPEN_SENSOR_CHANNEL = 6;
        public static final int CLOSE_TO_CUBE_SENSOR_CHANNEL = 9;
        public static final int CLOSE_TO_CONE_SENSOR_CHANNEL = 8;

        public static final double CLAW_POWER = -0.3;
        public static final double ROLLERS_POWER = 0.3;
        public static final double HOLD_GAME_PIECE_POWER = 0.05;
    }

    public static class ButtonPorts {
        public static final int X = 1,
                A = 2,
                B = 3,
                Y = 4,
                LB = 5,
                RB = 6,
                LT = 7,
                RT = 8,
                BACK = 9,
                START = 10,
                LEFT_JOYSTICK = 11,
                RIGHT_JOYSTICK = 12,
                OPERATOR_LEFT_JOYSTICK_X = 0,
                OPERATOR_LEFT_JOYSTICK_Y = 1,
                OPERATOR_RIGHT_JOYSTICK_X = 2,
                OPERATOR_RIGHT_JOYSTICK_Y = 3;
    }

    public class JoysticksConsts {
        public static final int OPERATOR = 2,
                LEFT_JOYSTICK = 1,
                RIGHT_JOYSTICK = 0;

    }
}
