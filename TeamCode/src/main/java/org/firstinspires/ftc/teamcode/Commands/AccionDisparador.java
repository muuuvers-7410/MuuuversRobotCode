package org.firstinspires.ftc.teamcode.Commands;


import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.MainSystem;
import org.firstinspires.ftc.teamcode.Subsystems.Disparador;
import org.firstinspires.ftc.teamcode.Subsystems.RecojePelotas;

public class AccionDisparador extends MainSystem {

    private final Gamepad Gamepad;


    public AccionDisparador(Disparador disparador, Gamepad gamepad) {
        this.Gamepad = gamepad;
    }

        public void execute() {

         boolean disparador = Gamepad.right_bumper && Gamepad.left_bumper;
        }
    }