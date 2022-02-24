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


    @Override
    public void init() {

        capping = hardwareMap.dcMotor.get("cap");
        cappingServo = hardwareMap.servo.get("capServo");

    }

    @Override
    public void loop() {
        double stick = gamepad2.left_stick_y;
        capping.setPower(.4 * gamepad2.right_stick_y);

        telemetry.addData("Value", stick);
        telemetry.update();
        cappingServo.setPosition(gamepad2.left_stick_y);

    }//the loop ends here
}
