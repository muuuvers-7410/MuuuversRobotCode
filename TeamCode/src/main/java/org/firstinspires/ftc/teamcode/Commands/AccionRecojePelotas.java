package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.Subsystems.RecojePelotas;

public class AccionRecojePelotas extends CommandBase {
    private Gamepad Gamepad;

    public AccionRecojePelotas(RecojePelotas recojePelotas, Gamepad gamepad) {
        this.Gamepad = gamepad;
    }

    @Override
    public void execute() {

        boolean recojePelotas = Gamepad.a && Gamepad.b;
    }
}