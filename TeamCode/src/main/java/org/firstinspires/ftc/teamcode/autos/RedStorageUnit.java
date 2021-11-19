package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.botconfigs.StaticDischargeBot1;

@Autonomous(name = "Red StorageUnit")
public class RedStorageUnit extends LinearOpMode {

    public StaticDischargeBot1 bot;
    public DcMotor carouselWheel = null;
    public Servo latchServo = null;
    public DcMotor arm =null;
    public ElapsedTime runtime = new ElapsedTime();
    public void runOpMode() {

        bot = new StaticDischargeBot1(telemetry, hardwareMap);
        carouselWheel = hardwareMap.dcMotor.get("wheel");
        latchServo = hardwareMap.servo.get("latch");
        arm=hardwareMap.dcMotor.get("arm");
        latchServo.setPosition(0.5);

        waitForStart();
        bot.driveTrain.moveEncoders(0, 12, 0, 0.8);
        sleep(200);
        bot.driveTrain.moveEncoders(-18, 0, 0, 0.5);
        sleep(200);
        bot.driveTrain.moveEncoders(0, -7.5, 0, 0.4);
        sleep(200);
        carouselWheel.setPower(0.5);
        sleep(3500);
        carouselWheel.setPower(0);

        sleep(500);
        bot.driveTrain.moveEncoders(0, 24, 0, 0.8);
        sleep(200);
        bot.driveTrain.moveEncoders(4.5, 0, 0, 0.5);
        bot.driveTrain.moveEncoders(0,0,-0.4,1);
        bot.driveTrain.moveEncoders(0,-15,0,1);
        arm.setPower(-0.5);
        sleep(1600);
        arm.setPower(0.3);
        sleep(500);
        bot.driveTrain.moveEncoders(0,15.5,0,1);

        //sleep(100);
        //bot.driveTrain.moveEncoders(0,-5,0,0.5);


    }
}
