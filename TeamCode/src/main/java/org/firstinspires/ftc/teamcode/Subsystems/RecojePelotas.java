package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.MainSystem;

public class RecojePelotas extends MainSystem {

    private DcMotor RecojePelotas;

    public RecojePelotas(HardwareMap hardwareMap) {

        RecojePelotas = hardwareMap.get(DcMotor.class, "del_medio");
        RecojePelotas.setDirection(DcMotor.Direction.FORWARD);

    }
}
