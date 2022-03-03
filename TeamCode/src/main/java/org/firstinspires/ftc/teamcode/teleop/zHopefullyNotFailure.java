package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Avneesh Testing", group = "Linear OpMode")
public class zHopefullyNotFailure extends OpMode {

//    public DcMotor capping = null;
//    public Servo cappingServo = null;
    public DcMotor intakeStars = null;
    public DcMotor armWheels = null;
    public DcMotor intakeTop = null;
    public Servo upperRoller = null;
    double potato = 0;

    @Override
    public void init() {

//        capping = hardwareMap.dcMotor.get("cap");
//        cappingServo = hardwareMap.servo.get("capServo");
        armWheels = hardwareMap.dcMotor.get("armWheels");
        intakeStars = hardwareMap.dcMotor.get("stars");
        intakeTop = hardwareMap.dcMotor.get("inTop");
        upperRoller = hardwareMap.servo.get("upper");


}

    @Override
    public void loop() {

//        capping.setPower(.4 * gamepad2.right_stick_y);

        telemetry.addData("Value=", potato);
        telemetry.update();

//        if (gamepad2.right_bumper) {
//            cappingServo.setPosition(1);
//            potato = 1;
//        } else if (gamepad2.left_bumper) {
//            cappingServo.setPosition(.8);
//            potato = -1;
//        } //capping claw

        if (gamepad1.a) {//intake on
            intakeStars.setPower(0.5);
            armWheels.setPower(-.75);
            intakeTop.setPower(-.75);
            upperRoller.setPosition(0);
            //lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
            telemetry.addData("Intake:", true);


        }
        if(gamepad1.b){//intake reverse
            intakeStars.setPower(-0.5);
            armWheels.setPower(1);
            //rollerServo.setPosition(0);
            upperRoller.setPosition(1);
            telemetry.addData("Intake:", false);
         //   lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.HOT_PINK);
        }
        if(gamepad1.x){//intake off
            intakeStars.setPower(0);
            armWheels.setPower(0);
            upperRoller.setPosition(-0.5);
            telemetry.addData("Intake:", false);
        }
        }//the loop ends here
    }

