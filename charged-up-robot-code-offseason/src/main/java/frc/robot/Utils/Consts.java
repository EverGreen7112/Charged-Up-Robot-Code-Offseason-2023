package frc.robot.Utils;

import java.util.ArrayList;

public class Consts {
    public class ChassisConsts {
        public static final int LEFT_FORWARD_ID = 0;
        public static final int LEFT_MID_ID = 0;
        public static final int LEFT_BACK_ID = 0;
        public static final int RIGHT_FORWARD_ID = 0;
        public static final int RIGHT_MID_ID = 0;
        public static final int RIGHT_BACK_ID = 0;
    }

    public class ClawConsts {
        public static final int CLAW_MOTOR_ID = 1;
        public static final int CLAW_ROLLERS_ID = 10;

        public static final int OPEN_SENSOR_CHANNEL = 0;
        public static final int CLOSE_TO_CUBE_SENSOR_CHANNEL = 0;
        public static final int CLOSE_TO_CONE_SENSOR_CHANNEL = 0;

        public static final double CLAW_POWER = -0.4;
        public static final double ROLLERS_POWER = 0.3;
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
        public static final int OPERATOR = 2;
    }
}
