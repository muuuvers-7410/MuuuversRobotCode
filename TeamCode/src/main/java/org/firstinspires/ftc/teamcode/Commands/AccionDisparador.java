package org.firstinspires.ftc.teamcode.Commands;


import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.Subsystems.Disparador;

public class AccionDisparador extends CommandBase {

    private final Gamepad Gamepad;

    double DisparadorPower;

    public AccionDisparador(Disparador disparador, Gamepad Gamepad) {this.Gamepad = Gamepad;}

        @Override
        public void execute() {

            if (Gamepad.right_bumper){
                DisparadorPower = (1.0);}

            else if (Gamepad.left_bumper){
                DisparadorPower = (0.0);}
        }
    }