package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.linearOpMode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.Gamepad;

import android.widget.Button;

import com.qualcomm.robotcore.hardware.Gamepad;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import org.firstinspires.ftc.teamcode.Subsystems.Chasis;
import org.firstinspires.ftc.teamcode.Subsystems.Disparador;
import org.firstinspires.ftc.teamcode.Subsystems.RecojePelotas;

import org.firstinspires.ftc.teamcode.Commands.Move;
import org.firstinspires.ftc.teamcode.Commands.AccionRecojePelotas;
import org.firstinspires.ftc.teamcode.Commands.AccionDisparador;

import java.sql.Driver;

@TeleOp(name = "TeleOp")
public class MainSystem extends LinearOpMode{

    double DisparadorPower;
    double RecojePelotasPower;

    
    public void runOpMode() {

        //Declaracion del subsistema

        ElapsedTime runtime = new ElapsedTime();
        Chasis chasis = new Chasis(new HardwareMap());
        RecojePelotas recojePelotas = new RecojePelotas(new HardwareMap());
        Disparador disparador = new Disparador(new HardwareMap());

        //Gamepad Declaration

        Gamepad driver = new Gamepad();
        Gamepad operator = new Gamepad();


            /*COMMAND DECLARATION*/
            //CHASIS

            Chasis(new driver(chasis,gamepad1));

            // Disparador
            AccionDisparador(new operator(disparador, gamepad1));

            if (gamepad1.right_bumper) {
                DisparadorPower = 1.0;
            } else if (gamepad1.left_bumper) {
                DisparadorPower = 0.0;
            }

            //Recoje Pelotas
            AccionDisparador(new operator(recojePelotas, gamepad1));

            if (gamepad1.a) {
                RecojePelotasPower = 1.0;
            } else if (gamepad1.b) {
                RecojePelotasPower = 0.0;
            }

            // -- ODOMETRY TELEMETRY -- //

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%1.0f), right (%1.0f), Up (%1.0f) ,delmedio (%1.0f)", DisparadorPower, RecojePelotasPower);
            telemetry.addLine("status inicializado");
            telemetry.addData("Poder motor", "upDrive.getPower(), delmedio.getPower()");
            // -- UPDATE TELEMETRY -- //
            telemetry.update();
        }
    }