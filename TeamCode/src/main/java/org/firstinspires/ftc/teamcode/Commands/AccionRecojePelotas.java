package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.Subsystems.RecojePelotas;

public class AccionRecojePelotas extends CommandBase {

    private final Gamepad Gamepad;
    double RecojePelotasPower;


    public AccionRecojePelotas(RecojePelotas recojePelotas, Gamepad Gamepad) {this.Gamepad = Gamepad;}
        @Override
        public void execute() {

            if (Gamepad.a) {
                RecojePelotasPower = (1.0);}

            else if (Gamepad.b) {
                RecojePelotasPower = (0.0);}
        }
    }
