package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import android.widget.Button;

import com.qualcomm.robotcore.hardware.Gamepad;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;

import org.firstinspires.ftc.teamcode.Subsystems.Chasis;
import org.firstinspires.ftc.teamcode.Subsystems.Disparador;
import org.firstinspires.ftc.teamcode.Subsystems.RecojePelotas;

import org.firstinspires.ftc.teamcode.Commands.Move;
import org.firstinspires.ftc.teamcode.Commands.AccionRecojePelotas;
import org.firstinspires.ftc.teamcode.Commands.AccionDisparador;

import java.sql.Driver;


public class MainSystem {

    double DisparadorPower;
    double RecojePelotasPower;


    @TeleOp
    public class MainSystem extends LinearOpMode { }
        @Override
        public void runOpMode() {
            CommandScheduler.getInstance().reset();

            //Declaracion del subsistema

            Chasis Chasis = new Chasis(new HardwareMap());
            RecojePelotas recojePelotas = new RecojePelotas(new HardwareMap());
            Disparador disparador = new Disparador(new HardwareMap());

            //Gamepad Declaration

            Gamepad driver = new Gamepad(gamepad1);
            Gamepad operator = new Gamepad(gamepad2);

            /*COMMAND DECLARATION*/
            //CHASIS

            Chasis.setDefaultCommand(new Driver(Chasis, gamepad1));

            // Disparador

            if (gamepad1.right_bumper) {
                DisparadorPower = 1.0;}

            else if (gamepad1.left_bumper){
                DisparadorPower = 0.0;}


            //Recoje Pelotas

            if (gamepad1.a) {
                RecojePelotasPower = 1.0;}
            else if (gamepad1.b) {
                RecojePelotasPower = 0.0;}



            waitForStart();
            chasis.reset(new Pose2d(0,0, Rotation2d.fromDegrees(0)));
            while (opModeIsActive()) {
                CommandScheduler.getInstance().run();
                Pose2d pose = chasis.getPose();

                // -- ODOMETRY TELEMETRY -- //

                telemetry.addData("X", pose.getX()); //This will display the telemetry on the DriverHub
                telemetry.addData("Y", pose.getY());
                telemetry.addData("Heading", pose.getRotation().getDegrees());
                telemetry.addData("RightDistance", chasis.rightDistance());
                telemetry.addData("LeftDistance", chasis.leftDistance());
                telemetry.addLine("---- MEASUREMENTS ---");


                telemetry.addData(" LIMIT SWITCH PRESSED", arm.isLimitReached());

                // -- UPDATE TELEMETRY -- //
                telemetry.update();
            }
        }
}