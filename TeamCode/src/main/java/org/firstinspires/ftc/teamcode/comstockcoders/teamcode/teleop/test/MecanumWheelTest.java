package org.firstinspires.ftc.teamcode.comstockcoders.teamcode.teleop.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "MecanumWheelTest")
public class MecanumWheelTest extends OpMode {
    DcMotor leftFront, rightFront, leftBack, rightBack;

    @Override
    public void init() {
        leftBack = hardwareMap.get(DcMotor.class, "LeftBack");
        leftFront = hardwareMap.get(DcMotor.class, "LeftFront");
        rightBack = hardwareMap.get(DcMotor.class, "RightBack");
        rightFront = hardwareMap.get(DcMotor.class, "RightFront");
    }

    @Override
    public void loop() {
        // ------------------------------------------------
        // Used code here from https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html
        // I'll make my own code later this is temp and here is for testing
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x * 1.1;
        double rx = gamepad1.right_stick_x;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        leftFront.setPower(frontLeftPower);
        leftBack.setPower(backLeftPower);
        rightFront.setPower(frontRightPower);
        rightBack.setPower(backRightPower);
        // ------------------------------------------------
    }
}
