

package org.firstinspires.ftc.teamcode;

//cambios
//cambios2

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;


@TeleOp(name="Chasis")
public class Chasis extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive;
    private DcMotor upDrive;
    private DcMotor rightDrive;
    private DcMotor delmedio;

    double leftPower;
    double rightPower;
    double upPower;
    double delmedioPower;
    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        upDrive = hardwareMap.get(DcMotor.class, "Up_drive");
        delmedio = hardwareMap.get(DcMotor.class, "del_medio");


        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        upDrive.setDirection(DcMotor.Direction.FORWARD);
        delmedio . setDirection(DcMotor.Direction.FORWARD);
        waitForStart();
        runtime.reset();


        while (opModeIsActive()) {

            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            double  up = gamepad1.right_trigger;

            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive - turn, -1.0, 1.0);
            upPower = Range.clip( up ,-0.0,  1.0);

            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);
            upDrive.setPower(upPower);

            if (gamepad1.a) {
                delmedioPower = 1.0;
            }  else if (gamepad1.b){
                delmedioPower = 0.0;
            }
            delmedio.setPower(delmedioPower);

//aqui deberia de encender el motor disparador pulsando la cruceta de arriba y apagarse pulsando la cruceta de abajo

            if (gamepad1.dpad_up) {
                upDrive.setPower(upPower);
            } else if (gamepad1.dpad_down) {
                upDrive.setPower(0);

            }
        }

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors",  "left (%1.0f), right (%1.0f) Up (%1.0f)", leftPower, rightPower, upPower, delmedioPower);
            telemetry.addData("voltage", "leftDriveMotor(%1.0f), rightDriveMotor(%1.0f) UpDriveMotor(%1.0f) , delmedioMotor(%1.0f)", leftPower, rightPower, upPower, delmedioPower);
            telemetry.addLine("status inicializado");
            telemetry.addData("Poder motor", "upDrive.getPower()");
            telemetry.update();
        }
    }
