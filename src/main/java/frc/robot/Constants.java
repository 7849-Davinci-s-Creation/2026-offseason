package frc.robot;

import frc.robot.generated.TunerConstants;

import static edu.wpi.first.units.Units.*;

public final class Constants {
    public static final class Operator {
        public static final int CONTROLLER_PORT = 1;
    }

    public static final class DriveTrain {
        public static final double MAX_SPEED = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond); // kSpeedAt12Volts desired top speed
        public static final double MAX_ANGULAR_RATE = RotationsPerSecond.of(0.75d).in(RadiansPerSecond); // 3/4 of a rotation per second max angular velocity

        public static final double DRIVE_DEADBAND = 0.1d;
        public static final double ROTATE_DEADBAND = 0.1d;

        public static final double AIM_ROTATE_DEADBAND = 0.5d;

        public static final double AIM_P = 10d;
        public static final double AIM_I = 0d;
        public static final double AIM_D = 0.3d;
    }

    public static final class Vision {
        public static final String CAMERA_NAME = "Arducam_OV9281_USB_Camera";
    }

    public static final class FieldConstants {
        public static final int TARGET_ID = 13;
    }

}
