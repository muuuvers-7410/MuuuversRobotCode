package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RecojePelotas extends SubsystemBase {

    private DcMotor RecojePelotas;

    public RecojePelotas(HardwareMap hardwareMap) {

        RecojePelotas = hardwareMap.get(DcMotor.class, "del_medio");
        RecojePelotas.setDirection(DcMotor.Direction.FORWARD);

    }
}
