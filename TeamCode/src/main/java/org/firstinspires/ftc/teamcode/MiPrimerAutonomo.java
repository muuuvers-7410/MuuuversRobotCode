
package org.firstinspires.ftc.teamcode;

//cambios
//cambios2
//Librerias

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

    @Autonomous(name="MiPrimerAutonomo")
    public class MiPrimerAutonomo  extends LinearOpMode {

        DcMotor leftDrive;
        DcMotor rightDrive;

        @Override
        public void runOpMode() {

            leftDrive.setDirection(DcMotor.Direction.REVERSE);
            rightDrive.setDirection(DcMotor.Direction.FORWARD);

            double leftPower;
            double rightPower;

            rightDrive = hardwareMap.dcMotor.get("right_Drive");
            leftDrive = hardwareMap.dcMotor.get("left_Drive");
            waitForStart();
            if (opModeIsActive()) {

                rightDrive.setPower(1.0);
                leftDrive.setPower(1.0);
                sleep(5000);

                rightDrive.setPower(0.0);
                leftDrive.setPower(0.0);
                sleep(5000);

                rightDrive.setPower(-1.0);
                leftDrive.setPower(1.0);
                sleep(5000);

                rightDrive.setPower(0.0);
                leftDrive.setPower(0.0);
                sleep(5000);

            }

        }
    }