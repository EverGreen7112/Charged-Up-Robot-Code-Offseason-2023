package frc.robot.Utils;

public class Consts {
    public class ChassisConsts{
        public static final int LEFT_FORWARD_ID = 14;
        public static final int LEFT_MID_ID = 1;
        public static final int LEFT_BACK_ID = 2;
        public static final int RIGHT_FORWARD_ID = 12;
        public static final int RIGHT_MID_ID = 3;
        public static final int RIGHT_BACK_ID = 4;

        public static final double SPEED = 0.3;
        public static final double JOYSTICK_THRESHOLD = 0.2;
        public static final double DISTANCE_PER_ROTATION = 2 * Math.PI * 0.076; //wheel perimeter(in meters)
        public static final double CHASSIS_WHEEL_GEAR_RATIO = 1 / 4.128326627;

        public static final double DISTANCE_PER_ROTATION = 2 * Math.PI * 0.076; //wheel perimeter(in meters)
        public static final double CHASSIS_WHEEL_GEAR_RATIO = 1 / 4.128326627;

        public static final double DRIVE_METERS_THRESHOLD = 0.1;
        public static final double TURN_ANGLE_THRESHOLD = 2;

        public static final double TURN_KP = 0;
        public static final double TURN_KD = 0;

        public static final double MOVE_KP = 0;
        public static final double MOVE_KD = 0;

        public static final double PITCH_ANGLE_THRESHOLD = 2;

        public static final double BALANCE_KP = 0;
        public static final double BALANCE_KF = 0;

        public static final double TILTED_THRESH_HOLD = 1;
        public static final double DRIVE_UNTIL_TILTED_SPEED = 0.1;

    }
    
}
