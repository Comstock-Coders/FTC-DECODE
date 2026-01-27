package org.firstinspires.ftc.teamcode.comstockcoders.teamcode.teleop.main;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

// 4 wheels
@TeleOp(name = "Main", group = "Teleop")
public class Main extends OpMode {
    DcMotor leftBack, rightBack, LauncherPush;
    Servo Close;
    private boolean ServoClosingState = false;
    private boolean launchingYesOrNo = false;
    private IMU imu;
    public float launchSpeed = 1.0f;

    @Override
    public void init() {
        leftBack = hardwareMap.get(DcMotor .class, "leftBack");

        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        LauncherPush = hardwareMap.get(DcMotor.class, "PushLaunch");
        Close = hardwareMap.get(Servo .class, "Close");

        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

        /*imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.LEFT, RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD));
        imu.initialize(parameters);*/
    }

    @Override
    public void loop() {
        drive();
        Launch();
        LaunchTelemetry();
    }

    public void drive() {
        float leftStickY = gamepad1.left_stick_y;
        float rightStickX = gamepad1.right_stick_x;

        rightBack.setPower(rightStickX + leftStickY);
        leftBack.setPower(-rightStickX + leftStickY);
    }

    public void Launch() {
        if (gamepad2.a) {
            if (!ServoClosingState) {
                Close.setPosition(1);
                ServoClosingState = true;
            } else {
                Close.setPosition(0);
                ServoClosingState = false;
            }
        }
        if (gamepad2.b) {
            LauncherPush.setPower(launchSpeed);
            launchingYesOrNo = true;
        } else {
            LauncherPush.setPower(0);
            launchingYesOrNo = false;
        }
        /*if (gamepad2.dpad_down) {
            if (launchSpeed <= 0) {
                return;
            } else {
                float x = launchSpeed - 0.1f;
                launchSpeed = x;
            }
        }
        if (gamepad2.dpad_up) {
            if (launchSpeed >= 1) {
                return;
            } else {
                float x = launchSpeed + 0.1f;
                launchSpeed = x;
            }
        }*/
    }

    public void LaunchTelemetry() {
        // telemetry.addData("Launch Motor Speed", launchSpeed);
        telemetry.addData("Is Launch Motor On", launchingYesOrNo);
    }
}
