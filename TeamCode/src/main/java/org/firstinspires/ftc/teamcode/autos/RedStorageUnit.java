package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.botconfigs.StaticDischargeBot1;

@Disabled
@Autonomous(name = "Red StorageUnit")
public class RedStorageUnit extends LinearOpMode {

    public StaticDischargeBot1 bot;
    public DcMotor carouselWheel = null;
    public Servo rightLatchServo = null;
    public Servo paddleServo = null;
    //    public Servo leftLatchServo = null;
    public DcMotor arm = null;
    public Servo flickerServo = null;
    public ElapsedTime runtime = new ElapsedTime();

    public void path3() {
        bot.driveTrain.moveEncoders(0, 12, 0, 0.3);
        sleep(500);
        bot.driveTrain.moveEncoders(-16.75, 0, 0, 0.3);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -7.1, 0, 0.3);
        sleep(500);
        carouselWheel.setPower(0.475);
        sleep(3200);
        carouselWheel.setPower(0);
        sleep(500);

        bot.driveTrain.moveEncoders(0, 32.4, 0, 0.4);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 0, -0.326, 0.4);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -26, 0, 0.4);
        sleep(500);
        arm.setPower(-0.5);
        sleep(1600);
        flickerServo.setPosition(-0.5);
        sleep(1000);
        flickerServo.setPosition(0.5);
        sleep(500);
        arm.setPower(0.3);
        sleep(700);
        bot.driveTrain.moveEncoders(0, 28.75, 0, 0.3);
        sleep(500);
        bot.driveTrain.moveEncoders(-14, 0, 0, 0.3);
        sleep(500);


    }

    public void path2() {
        bot.driveTrain.moveEncoders(0, 12, 0, 0.6);
        sleep(500);
        bot.driveTrain.moveEncoders(-16.75, 0, 0, 0.4);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -6.8, 0, 0.4);
        sleep(500);
        carouselWheel.setPower(0.475);
        sleep(3200);
        carouselWheel.setPower(0);
        sleep(500);

        bot.driveTrain.moveEncoders(0, 32.4, 0, 0.4);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 0, -0.325, 0.4);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -23, 0, 0.4);
        sleep(500);
        arm.setPower(-0.5);
        sleep(1600);
        flickerServo.setPosition(-0.5);
        sleep(1000);
        flickerServo.setPosition(0.5);
        sleep(500);
        arm.setPower(0.3);
        sleep(700);
        bot.driveTrain.moveEncoders(0, 28.75, 0, 0.4);
        sleep(500);
        bot.driveTrain.moveEncoders(-11.5, 0, 0, 0.4);
        sleep(500);
    }

    public void path1() {
        bot.driveTrain.moveEncoders(0, 12, 0, 0.6);
        sleep(500);
        bot.driveTrain.moveEncoders(-16.75, 0, 0, 0.4);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -6.8, 0, 0.4);
        sleep(500);
        carouselWheel.setPower(0.475);
        sleep(3200);
        carouselWheel.setPower(0);
        sleep(500);

        bot.driveTrain.moveEncoders(0, 32.4, 0, 0.4);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 0, -0.325, 0.4);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -23, 0, 0.4);
        sleep(500);
        flickerServo.setPosition(-0.5);
        sleep(500);
        flickerServo.setPosition(0.5);
        sleep(100);
        arm.setPower(-0.5);
        sleep(600);
        arm.setPower(0.0);
        sleep(1000);
        bot.driveTrain.moveEncoders(0, -3, 0, 0.3);
        sleep(300);
        paddleServo.setPosition(-0.5);
        sleep(1000);
        arm.setPower(0.3);
        sleep(700);
        bot.driveTrain.moveEncoders(0, 28.75, 0, 0.4);
        sleep(500);
        bot.driveTrain.moveEncoders(-11.5, 0, 0, 0.4);
        sleep(500);
    }

    public void runOpMode() {

        bot = new StaticDischargeBot1(telemetry, hardwareMap);
        carouselWheel = hardwareMap.dcMotor.get("wheel");
        rightLatchServo = hardwareMap.servo.get("rightlatch");
        flickerServo = hardwareMap.servo.get("flicker");
//        leftLatchServo = hardwareMap.servo.get("leftlatch");
        arm = hardwareMap.dcMotor.get("arm");
        paddleServo = hardwareMap.servo.get("paddle");

        rightLatchServo.setPosition(0.5);
        paddleServo.setPosition(0.35);
//        leftLatchServo.setPosition(0.5);

        waitForStart();
        path3();
    }
}
