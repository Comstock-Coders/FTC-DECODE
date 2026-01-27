package org.firstinspires.ftc.teamcode.comstockcoders.teamcode.auto.main;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Close Auto", group = "Autonomous")
public class AutoClose extends LinearOpMode {
    DcMotor leftFront, rightFront, leftBack, rightBack, LauncherPush;
    Servo Close;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        LauncherPush = hardwareMap.get(DcMotor.class, "PushLaunch");
        Close = hardwareMap.get(Servo.class, "Close");

        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

        if (opModeIsActive()) {
            leftBack.setPower(1);
            rightBack.setPower(1);
            sleep(250);
            leftBack.setPower(0);
            rightBack.setPower(0);
            terminateOpModeNow();
        }
    }
}
