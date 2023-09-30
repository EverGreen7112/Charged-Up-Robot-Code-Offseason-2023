package frc.robot.Utils;

public class MathUtils{
    /**
    * Clamps a value to be within a specified range.
    *
    * @param val The value to be clamped.
    * @param min The minimum value that val should not be less than.
    * @param max The maximum value that val should not exceed.
    * @return The clamped value, which is guaranteed to be between min and max.
    */
    public static double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }


    public static double trueModulu(double a, double b){
        return ((a % b + b) % b);
    }
}