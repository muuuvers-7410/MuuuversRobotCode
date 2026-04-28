

package org.firstinspires.ftc.teamcode.Subsystems;

//cambios
//cambios2
//Libreria


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
public class Chasis extends Subsystems {

    private DcMotor leftDrive; //Este va conectado al PIN 0
    private DcMotor rightDrive; //Este va conectado al PIN 1

    private final double TICKS_PER_METER = 28.0;
    private final double TRACK_WIDTH = 0.09;
    private final double REDUCTION = 20.0;

    private DifferentialDriveOdometry differentialDriveOdometry;
    private IMU imu;
    private double leftOffset = 0.0;
    private double rightOffset = 0.0;

    public Chasis(HardwareMap hardwareMap) {

        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        leftDrive.setDirection(DcMotorEx.Direction.REVERSE);
        rightDrive.setDirection(DcMotorEx.Direction.FORWARD);



        differentialDriveOdometry = new DifferentialDriveOdometry(new Rotation2d());
        imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters imuParemeters = new IMU.Parameters(new
                RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.LEFT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP));
        imu.initialize(imuParemeters);
        imu.resetYaw();
    }

    public void setVelocity(double linearVelocity, double angularVelocity) {
        leftDrive.setPower(linearVelocity - angularVelocity);
        rightDrive.setPower(linearVelocity + angularVelocity);
    }
    public double leftDistance() {
        return ((leftDrive.getCurrentPosition() / TICKS_PER_METER) * TRACK_WIDTH * Math.PI) / REDUCTION;
    }

    public double rightDistance() {
        return ((rightDrive.getCurrentPosition() / TICKS_PER_METER) * TRACK_WIDTH * Math.PI) / REDUCTION;
    }


    public void reset(Pose2d pose2d) {
        leftOffset = leftDrive.getCurrentPosition();
        rightOffset = rightDrive.getCurrentPosition();
        differentialDriveOdometry.resetPosition(pose2d, getIMUHeading());
    }

    public Pose2d getPose() {
        return differentialDriveOdometry.getPoseMeters();
    }

    @Override
    public void periodic() {
        differentialDriveOdometry.update(getIMUHeading(), leftDistance(), rightDistance());
    }

    private Rotation2d getIMUHeading() {
        YawPitchRollAngles robotOrientation;
        robotOrientation = imu.getRobotYawPitchRollAngles();
        return Rotation2d.fromDegrees(robotOrientation.getYaw(AngleUnit.DEGREES));
    }
}