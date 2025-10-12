package frc.robot;

import frc.robot.generated.TunerConstants;

import static edu.wpi.first.units.Units.*;

public final class Constants {
    public static final class Operator {
        public static final int CONTROLLER_PORT = 1;
    }

    public static final class DriveTrain {
        public static final double MaxSpeed = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond); // kSpeedAt12Volts desired top speed
        public static final double MaxAngularRate = RotationsPerSecond.of(0.75).in(RadiansPerSecond); // 3/4 of a rotation per second max angular velocity
    }

}
