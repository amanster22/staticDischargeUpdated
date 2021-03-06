package org.firstinspires.ftc.teamcode.autos;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
@Autonomous(name = "CanBot Auto")
public class zMecanumAuto extends LinearOpMode {

    DcMotor FrontLeftMotor = null;
    DcMotor FrontRightMotor = null;
    DcMotor BackLeftMotor = null;
    DcMotor BackRightMotor = null;
    Servo claw = null;
    DcMotor lift = null;

    double ticksPerRotation = 100;
    double wheelDiameter = 3;
    double wheelCircumference = wheelDiameter * Math.PI;
    double ticksPerInch = ticksPerRotation / wheelCircumference;

    @Override
    public void runOpMode() throws InterruptedException {

        ElapsedTime runtime = new ElapsedTime();

        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("1");
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("2");
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("0");
        DcMotor motorBackRight = hardwareMap.dcMotor.get("4");
        claw = hardwareMap.servo.get("claw");
        lift = hardwareMap.dcMotor.get("lift");

        waitForStart();

        encoderMoveLinear(0, 10, 1);

    }

    public void encoderMove(double rf, double lf, double rb, double lb, double speed) {

        // set motor distances
        FrontRightMotor.setTargetPosition(FrontRightMotor.getCurrentPosition() + (int)(rf * ticksPerInch));
        FrontLeftMotor.setTargetPosition(FrontLeftMotor.getCurrentPosition() + (int)(lf * ticksPerInch));
        BackRightMotor.setTargetPosition(BackRightMotor.getCurrentPosition() + (int)(rb * ticksPerInch));
        BackLeftMotor.setTargetPosition(BackLeftMotor.getCurrentPosition() + (int)(lb * ticksPerInch));

        // set motor mode to begin motion
        FrontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // set motor speeds
        FrontRightMotor.setPower(speed);
        FrontLeftMotor.setPower(speed);
        BackRightMotor.setPower(speed);
        BackLeftMotor.setPower(speed);

        while ((FrontLeftMotor.isBusy() || FrontRightMotor.isBusy() || BackLeftMotor.isBusy() || BackRightMotor.isBusy()) && opModeIsActive()) {}

        FrontRightMotor.setPower(0);
        FrontLeftMotor.setPower(0);
        BackRightMotor.setPower(0);
        BackLeftMotor.setPower(0);
    }

    public void encoderMoveLinear(double x, double y, double speed) {
        encoderMove(y - x, y + x, y + x, y - x, speed);
    }
}
