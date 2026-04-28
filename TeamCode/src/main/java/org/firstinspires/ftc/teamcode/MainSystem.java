package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;


import org.firstinspires.ftc.teamcode.Subsystems.Chasis;
import org.firstinspires.ftc.teamcode.Subsystems.Disparador;
import org.firstinspires.ftc.teamcode.Subsystems.RecojePelotas;

import org.firstinspires.ftc.teamcode.Commands.Move;
import org.firstinspires.ftc.teamcode.Commands.AccionRecojePelotas;
import org.firstinspires.ftc.teamcode.Commands.AccionDisparador;


public class MainSystem {

    @TeleOp
    public class MainSystem extends LinearOpMode {

    }
        @Override
        public void runOpMode() {
            CommandScheduler.getInstance().reset();

            //Declaracion del subsistema

            Chasis Chasis = new Chasis(new HardwareMap());
            RecojePelotas recojePelotas = new RecojePelotas(new HardwareMap());
            Disparador disparador = new Disparador(new HardwareMap());

            //Gamepad Declaration
            Gamepad driver = new Gamepad (gamepad1);
            Gamepad turn = new Gamepad(gamepad1);

            /*COMMAND DECLARATION*/
            //CHASIS










            waitForStart();
            chassis.reset(new Pose2d(0,0, Rotation2d.fromDegrees(0)));
            while (opModeIsActive()) {
                CommandScheduler.getInstance().run();
                Pose2d pose = chassis.getPose();

                // -- ODOMETRY TELEMETRY -- //

                telemetry.addData("X", pose.getX()); //This will display the telemetry on the DriverHub
                telemetry.addData("Y", pose.getY());
                telemetry.addData("Heading", pose.getRotation().getDegrees());
                telemetry.addData("RightDistance", chassis.rightDistance());
                telemetry.addData("LeftDistance", chassis.leftDistance());
                telemetry.addLine("---- MEASUREMENTS ---");
                telemetry.addData("Elevator Distance", elevator.getHeight());
                telemetry.addData("Elevator Target", elevator.target);
                telemetry.addData("Arm Position", arm.getPosition());
                telemetry.addData("Right Servo:", wrist.getRightServoPosition());
                telemetry.addData("Left Servo:", wrist.getLeftServoPosition());

                telemetry.addData(" LIMIT SWITCH PRESSED", arm.isLimitReached());

                // -- UPDATE TELEMETRY -- //
                telemetry.update();
            }
        }
}