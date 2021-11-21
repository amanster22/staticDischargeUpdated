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
    public Servo latchServo = null;
    public DcMotor arm = null;
//    public Servo flipServo = null;
//    public ElapsedTime runtime = new ElapsedTime();
    public void runOpMode() {

        bot = new StaticDischargeBot1(telemetry, hardwareMap);
        carouselWheel = hardwareMap.dcMotor.get("wheel");
        latchServo = hardwareMap.servo.get("latch");
        arm = hardwareMap.dcMotor.get("arm");
        latchServo.setPosition(0.5);

        waitForStart();
        bot.driveTrain.moveEncoders(9.75, 0, 0, 0.2);
        sleep(200);
        bot.driveTrain.moveEncoders(0, -28.5, 0, 0.8);
        sleep(200);

        bot.driveTrain.moveEncoders(-1.25,0,0,1);
        sleep(200);
        carouselWheel.setPower(-0.55);
        sleep(3000);
        carouselWheel.setPower(0);
        bot.driveTrain.moveEncoders(32, 0, 0, 1);
        sleep(200);
//        bot.driveTrain.moveEncoders(0, 0, 0.03, 0.8);
//        sleep(200);
        bot.driveTrain.moveEncoders(0, 23, 0, 1);
        sleep(200);
        bot.driveTrain.moveEncoders(0, 0, 0.67, 1);
        sleep(200);
        bot.driveTrain.moveEncoders(0, -2, 0, 1);
        sleep(200);
        arm.setPower(-0.5);
        sleep(1600);
        arm.setPower(0.3);
        sleep(200);
        bot.driveTrain.moveEncoders(0, 24.9, 0, 0.7);
        sleep(200);
        bot.driveTrain.moveEncoders(0, 0, 0.01, 0.5);
        sleep(200);
        bot.driveTrain.moveEncoders(10.25, 0, 0, 0.7);
        sleep(200);



//        flipServo.setPosition(0.5);
//        bot.driveTrain.moveEncoders(0,-1,0,0.5);


    }
}
