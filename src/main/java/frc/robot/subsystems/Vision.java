package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonTrackedTarget;

public class Vision implements Subsystem {
    private final PhotonCamera camera = new PhotonCamera(Constants.Vision.CAMERA_NAME);

    private Rotation2d lastAngleOfTarget = Rotation2d.fromDegrees(180);

    public Rotation2d calculateRobotOffsetToTargetCenter(Rotation2d robotYaw) {
        var results = camera.getAllUnreadResults();
        if (results.isEmpty()) {
            return lastAngleOfTarget;
        }
        var result = results.get(results.size() - 1);
        if (!result.hasTargets()) {
            return lastAngleOfTarget;
        }

        for (PhotonTrackedTarget target : result.getTargets()) {
            if (target.getFiducialId() == Constants.FieldConstants.TARGET_ID) {
                double targetYaw = robotYaw.getDegrees() - target.getYaw();

                targetYaw = ((targetYaw + 180) % 360) - 180;

                Rotation2d toAimAt = Rotation2d.fromDegrees(targetYaw);

                SmartDashboard.putNumber("Aiming to: ", toAimAt.getDegrees());
                SmartDashboard.putNumber("Tag Yaw: ", target.getYaw());
                SmartDashboard.putNumber("Tag Distance: ", PhotonUtils
                .calculateDistanceToTargetMeters(0.02413, 1.4986, Units.degreesToRadians(30), Units.degreesToRadians(target.getPitch())));

                lastAngleOfTarget = toAimAt;

                return toAimAt;
            }
        }

        return lastAngleOfTarget;
    }

    @Override
    public void periodic() {

    }
}
