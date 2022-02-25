package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Avneesh Testing", group = "Linear OpMode")
public class zHopefullyNotFailure extends OpMode {

    public DcMotor capping = null;
    public Servo cappingServo = null;
    public DcMotor inLeft = null;
    public DcMotor inRight = null;

    @Override
    public void init() {

        capping = hardwareMap.dcMotor.get("cap");
        cappingServo = hardwareMap.servo.get("capServo");
        inLeft = hardwareMap.dcMotor.get("left");
        inRight = hardwareMap.dcMotor.get("right");

    }

    @Override
    public void loop() {
        double stick = gamepad2.left_stick_y;
        capping.setPower(.4 * gamepad2.right_stick_y);

        telemetry.addData("Value", stick);
        telemetry.update();

        if (gamepad2.right_bumper) {
            cappingServo.setPosition(1);
        } else if (gamepad2.left_bumper) {
            cappingServo.setPosition(.8);
        } //capping claw

        if (gamepad2.a) {
            inLeft.setPower(.5);
            inRight.setPower(-.5);
        }

        if (gamepad2.b) {
            inLeft.setPower(-.5);
            inRight.setPower(.5);
        }

        if (gamepad2.y) {
            inLeft.setPower(-.5);
            inRight.setPower(-.5);
        }

        if (gamepad2.x) {
            inLeft.setPower(.5);
            inRight.setPower(.5);
        }
        //all possibilities of intake

        if (gamepad1.dpad_down) {
            inRight.setPower(0);
            inLeft.setPower(0);
        }

        }//the loop ends here
    }

