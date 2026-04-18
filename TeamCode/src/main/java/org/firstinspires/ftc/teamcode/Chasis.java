

package org.firstinspires.ftc.teamcode;

//cambios
//cambios2
//Librerias
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
    private DcMotor leftDrive; //Este sera conectado en el PIN 0 del Control Hub
    private DcMotor upDrive; //Este sera conectado en el PIN 2 del Control Hub
    private DcMotor rightDrive; //Este sera conectado en el PIN 1 del Control Hub
    private DcMotor delmedio; //Este sera conectado en el PIN 3 del Control Hub

//Valor que tendran los motores

    double leftPower;
    double rightPower;
    double upPower;
    double delmedioPower;

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //Como los motores tendran que ser escritos en el Driver Hub

        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        upDrive = hardwareMap.get(DcMotor.class, "Up_drive");
        delmedio = hardwareMap.get(DcMotor.class, "del_medio");

//Esta sera la dirreccion a la que girara el motor

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        upDrive.setDirection(DcMotor.Direction.FORWARD);
        delmedio.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();


        while (opModeIsActive()) {

            double drive = gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

//Los motores se controlan los joystick izquierdo y derecho; respectivamente

            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive - turn, -1.0, 1.0);

            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);

//Si presionas a se encendera el Recoje Pelotas, y si despues de eso presionas b se apagara
            if (gamepad1.a) {
                delmedioPower = 1.0;
            }  else if (gamepad1.b){
                delmedioPower = 0.0;
            }
//Si presionas la cruceta de arriba se encedera el Disparador, y si despues presionas la cruceta de bajo se apagara
                if (gamepad1.dpad_up) {
                    upPower = 1.0;
                }  else if (gamepad1.dpad_down){
                    upPower = 0.0;
            }
                upDrive.setPower(upPower);
                delmedio.setPower(delmedioPower);

        }

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors",  "left (%1.0f), right (%1.0f) Up (%1.0f), delmedio (%1.0)", leftPower, rightPower, upPower, delmedioPower);
            telemetry.addData("voltage", "leftDriveMotor(1.0f), rightDriveMotor(%1.0f) UpDriveMotor(%1.0f) , delmedioMotor(%1.0f)", leftPower, rightPower, upPower, delmedioPower);
            telemetry.addLine("status inicializado");
            telemetry.addData("Poder motor", "upDrive.getPower(), delmedio.getPower!()");
            telemetry.update();
        }
    }
