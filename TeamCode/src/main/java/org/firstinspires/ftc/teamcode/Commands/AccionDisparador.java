package org.firstinspires.ftc.teamcode.Commands;


import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.Subsystems.Disparador;

public class AccionDisparador extends CommandBase {

    private final Gamepad Gamepad;

    double DisparadorPower;

    public AccionDisparador(Disparador disparador, Gamepad DisparadorGamepad) {this.Gamepad = DisparadorGamepad;}

        @Override
        public void execute() {

         double Disparador = Gamepad.right_bumper;

         double Disparador = Gamepad = Gamepad.left_bumper;
        }
    }