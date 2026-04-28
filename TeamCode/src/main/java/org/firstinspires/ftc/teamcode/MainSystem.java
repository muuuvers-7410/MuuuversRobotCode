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

        }
    }
}