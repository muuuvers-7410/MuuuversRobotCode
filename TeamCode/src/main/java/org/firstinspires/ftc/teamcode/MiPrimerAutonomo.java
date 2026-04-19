
package org.firstinspires.ftc.teamcode;

//Librerias

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

//Este codigo es para el Autonomo
@Autonomous(name = "MiPrimerAutonomo")
public class MiPrimerAutonomo extends LinearOpMode {

        DcMotor rightDrive;
        DcMotor leftDrive;

        @Override
        public void runOpMode() {

            rightDrive = hardwareMap.dcMotor.get("right_Drive");
            leftDrive = hardwareMap.dcMotor.get("left_Drive");



            waitForStart();

            //If a diferencia de While solo se va a repetir una sola vez


            if (opModeIsActive()) {


                rightDrive.setPower(1);
                leftDrive.setPower(1);

                sleep(5000);

                rightDrive.setPower(0);
                leftDrive.setPower(0);

                sleep(2000);

                rightDrive.setPower(1);
                leftDrive.setPower(-1);

                sleep(3000);

                rightDrive.setPower(0);
                leftDrive.setPower(0);

            }
        }
    }