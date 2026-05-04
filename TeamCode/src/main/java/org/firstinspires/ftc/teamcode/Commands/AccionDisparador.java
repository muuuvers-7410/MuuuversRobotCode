package org.firstinspires.ftc.teamcode.Commands;


import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.Subsystems.Disparador;

public class AccionDisparador extends CommandBase {

    private final Gamepad Gamepad;


    public AccionDisparador(Disparador disparador, Gamepad DisparadorGamepad) {this.Gamepad = DisparadorGamepad;}

        @Override
        public void execute() {

         boolean Disparador = Gamepad.right_bumper && Gamepad.left_bumper;
        }
    }