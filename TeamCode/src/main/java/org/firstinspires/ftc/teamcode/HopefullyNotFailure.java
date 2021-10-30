package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
@Disabled
@TeleOp(name = "Avneesh Testing", group = "Linear OpMode")
public class HopefullyNotFailure extends OpMode {

    public Servo dumping = null; //does this work
    public DcMotor spinny = null;
    public DcMotor intakeStars = null;
    public DcMotor intakeBase = null;
    double whichSpeed = 1.0;

    boolean lastUp = true;
    boolean lastDown = true;

    @Override
    public void init() {
        //dumping = (Servo) hardwareMap.get("arm");
        spinny = (DcMotor) hardwareMap.get("flywheel");
        intakeStars = (DcMotor) hardwareMap.get("inStar");
        intakeBase = (DcMotor) hardwareMap.get("inBelt");

    }

    @Override
    public void loop() {
//        if (gamepad1.a) {
//            dumping.setPosition(0);
//        } else if (gamepad1.b)
//        {
//            dumping.setPosition(.6);
//        }
        spinny.setPower(gamepad1.left_stick_y * whichSpeed);

        if (gamepad1.dpad_up && !lastUp) {
            whichSpeed = (whichSpeed + .1);
        }
        if (gamepad1.dpad_down && !lastDown) {
            whichSpeed = (whichSpeed - .1);
        }

        telemetry.addData("speed", whichSpeed);
        telemetry.update();

        lastUp = gamepad1.dpad_up;
        lastDown = gamepad1.dpad_down;

        if (gamepad2.a) {
            intakeBase.setPower(1);
            intakeStars.setPower(1);
        }
        if (gamepad2.b) {
            intakeBase.setPower(0);
            intakeStars.setPower(-0);
        }
    }//the loop ends here
}
