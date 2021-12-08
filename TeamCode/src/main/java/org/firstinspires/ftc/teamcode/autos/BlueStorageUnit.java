package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.botconfigs.StaticDischargeBot1;

@Autonomous(name = "Blue StorageUnit")
public class BlueStorageUnit extends LinearOpMode {

    public StaticDischargeBot1 bot;
    public DcMotor carouselWheel = null;
    //    public Servo leftLatchServo=null;
    public Servo rightLatchServo = null;
    public DcMotor arm = null;
    public Servo flickerServo = null;
    public Servo paddleServo = null;
//    public Servo flipServo = null;
//    public ElapsedTime runtime = new ElapsedTime();

    public void path1() {
        bot.driveTrain.moveEncoders(11.5, 0, 0, 0.2);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -27.25, 0, 0.3);
        sleep(500);

        bot.driveTrain.moveEncoders(-2.76, 0, 0, 0.3);
        sleep(500);
        carouselWheel.setPower(-0.5);
        sleep(3000);
        carouselWheel.setPower(0);
        bot.driveTrain.moveEncoders(32, 0, 0, 0.6);
        sleep(500);
//        bot.driveTrain.moveEncoders(0, 0, 0.03, 0.8);
//        sleep(200);
        bot.driveTrain.moveEncoders(0, 24.5, 0, 0.6);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 0, 0.66, 0.6);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -6, 0, 0.2);
        sleep(500);
        arm.setPower(-0.5);
        sleep(1000);
        arm.setPower(0.0);
        sleep(1000);
        flickerServo.setPosition(-0.5);
        sleep(1000);
        flickerServo.setPosition(0.5);
        sleep(500);
        arm.setPower(0.3);
        sleep(500);
        //bot.driveTrain.moveEncoders(0, 0, 0.02, 0.5);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 30, 0, 0.3);
        sleep(500);

        bot.driveTrain.moveEncoders(13.25, 0, 0, 0.3);
        sleep(500);
    }

    public void path2() {
        bot.driveTrain.moveEncoders(11.5, 0, 0, 0.2);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -27.25, 0, 0.3);
        sleep(500);

        bot.driveTrain.moveEncoders(-2.76, 0, 0, 0.3);
        sleep(500);
        carouselWheel.setPower(-0.5);
        sleep(3000);
        carouselWheel.setPower(0);
        bot.driveTrain.moveEncoders(32, 0, 0, 0.6);
        sleep(500);
//        bot.driveTrain.moveEncoders(0, 0, 0.03, 0.8);
//        sleep(200);
        bot.driveTrain.moveEncoders(0, 24.5, 0, 0.6);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 0, 0.66, 0.6);
        sleep(500);
//        bot.driveTrain.moveEncoders(0, -2, 0, 0.2);
//        sleep(500);
        arm.setPower(-0.5);
        sleep(1000);
        arm.setPower(0.0);
        sleep(1000);
        flickerServo.setPosition(-0.5);
        sleep(1000);
        flickerServo.setPosition(0.5);
        sleep(500);
        arm.setPower(0.3);
        sleep(500);
        //bot.driveTrain.moveEncoders(0, 0, 0.02, 0.5);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 28, 0, 0.3);
        sleep(500);

        bot.driveTrain.moveEncoders(13.25, 0, 0, 0.3);
        sleep(500);
    }

    public void path3(){
        bot.driveTrain.moveEncoders(11.5, 0, 0, 0.2);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -27.25, 0, 0.3);
        sleep(500);

        bot.driveTrain.moveEncoders(-2.76, 0, 0, 0.3);
        sleep(500);
        carouselWheel.setPower(-0.5);
        sleep(3000);
        carouselWheel.setPower(0);
        bot.driveTrain.moveEncoders(32, 0, 0, 0.6);
        sleep(500);
//        bot.driveTrain.moveEncoders(0, 0, 0.03, 0.8);
//        sleep(200);
        bot.driveTrain.moveEncoders(0, 24.5, 0, 0.6);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 0, 0.66, 0.6);

//        bot.driveTrain.moveEncoders(0, -2, 0, 0.2);
//        sleep(500);
        flickerServo.setPosition(-0.5);
        sleep(500);
        flickerServo.setPosition(0.5);
        sleep(100);
        arm.setPower(-0.5);
        sleep(600);
        arm.setPower(0.0);
        sleep(1000);

        paddleServo.setPosition(-0.5);
        sleep(1000);


        arm.setPower(0.3);
        sleep(500);
        //bot.driveTrain.moveEncoders(0, 0, 0.02, 0.5);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 22, 0, 0.3);
        sleep(500);

        bot.driveTrain.moveEncoders(13.25, 0, 0, 0.3);
        sleep(500);
    }

    public void runOpMode() {

        bot = new StaticDischargeBot1(telemetry, hardwareMap);
        carouselWheel = hardwareMap.dcMotor.get("wheel");
        rightLatchServo = hardwareMap.servo.get("rightlatch");
//        leftLatchServo = hardwareMap.servo.get("leftlatch");
        arm = hardwareMap.dcMotor.get("arm");
        flickerServo = hardwareMap.servo.get("flicker");
        paddleServo = hardwareMap.servo.get("paddle");
        rightLatchServo.setPosition(0.5);
        paddleServo.setPosition(0.35);
        flickerServo.setPosition(0.5);

        waitForStart();

        //Detect and add if statements for which path to take (path1, path2, path3)
        path3();
    }
}
