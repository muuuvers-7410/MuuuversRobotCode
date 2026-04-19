

package org.firstinspires.ftc.teamcode;

//cambios
//cambios2
//Librerias

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Chasis")
public class Chasis extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive; //Este va conectado al PIN 0
    private DcMotor rightDrive; //Este va conectado al PIN 1
    private DcMotor upDrive; //Este va conectado al PIN 2
    private DcMotor  delmedio; //Este va conectado al PIN 3


    double leftPower;
    double rightPower;
    double upPower;
    double delmedioPower;


    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        upDrive = hardwareMap.get(DcMotor.class, "Up_drive");
        delmedio = hardwareMap.get(DcMotor.class, "del_medio");



        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        upDrive.setDirection(DcMotor.Direction.FORWARD);
        delmedio.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();


        while (opModeIsActive()) {

            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            //Los motores de conduccion se controlaran con los joysticks derecho e izquierdo respectivamene

            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive - turn, -1.0, 1.0);


            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);

            //Si se persiona "a" se encendera el Recoje Pelotas, y si se presiona "b" se apagara

            if (gamepad1.a) {
                delmedioPower = 1.0;}

             else if (gamepad1.b) {
                delmedioPower = 0.0;}

            //Si se presiona el "R1" se encendera el disparador, y si se presiona "R2" se apagara

                if (gamepad1.right_bumper) {
                    upPower = 1.0;}

                 else if (gamepad1.left_bumper){
                    upPower = 0.0;}

            upDrive.setPower(upPower);
            delmedio.setPower(delmedioPower);


            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%1.0f), right (%1.0f), Up (%1.0f) ,delmedio (%1.0f)", leftPower, rightPower, upPower, delmedioPower);
            telemetry.addData("voltage", "leftDriveMotor(%1.0f), rightDriveMotor(%1.0f), UpDriveMotor(%1.0f ), delmedioMotor(%1.0f)", leftDrive, leftPower, rightPower, upPower, delmedioPower);
            telemetry.addLine("status inicializado");
            telemetry.addData("Poder motor", "upDrive.getPower(), delmedio.getPower()");
            telemetry.update();
        }
    }
}
//Que vivan las chivas