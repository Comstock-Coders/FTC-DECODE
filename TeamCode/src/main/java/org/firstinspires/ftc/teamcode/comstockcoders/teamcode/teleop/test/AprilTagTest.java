package org.firstinspires.ftc.teamcode.comstockcoders.teamcode.teleop.test;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "AprilTagTest")
public class AprilTagTest extends OpMode {
    private Limelight3A limelight3A;

    @Override
    public void init() {
        limelight3A = hardwareMap.get(Limelight3A.class, "Limelight3A");
    }

    @Override
    public void loop() {

    }
}
