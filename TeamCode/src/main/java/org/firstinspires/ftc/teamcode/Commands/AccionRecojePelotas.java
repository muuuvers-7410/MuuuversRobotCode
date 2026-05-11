package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.MainSystem;
import org.firstinspires.ftc.teamcode.Subsystems.RecojePelotas;

public class AccionRecojePelotas extends MainSystem {
    private Gamepad Gamepad;

    public AccionRecojePelotas(RecojePelotas recojePelotas, Gamepad gamepad) {
        this.Gamepad = gamepad;
    }


    public void execute() {

        boolean recojePelotas = Gamepad.a && Gamepad.b;
    }
}