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
    public Servo rightLatchServo=null;
    public DcMotor arm = null;
//    public Servo flipServo = null;
//    public ElapsedTime runtime = new ElapsedTime();
    public void runOpMode() {

        bot = new StaticDischargeBot1(telemetry, hardwareMap);
        carouselWheel = hardwareMap.dcMotor.get("wheel");
        rightLatchServo = hardwareMap.servo.get("rightlatch");
//        leftLatchServo = hardwareMap.servo.get("leftlatch");
        arm = hardwareMap.dcMotor.get("arm");
        rightLatchServo.setPosition(0.5);
//        leftLatchServo.setPosition(0.5);

        waitForStart();
        bot.driveTrain.moveEncoders(12, 0, 0, 0.3);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -27.25, 0, 0.8);
        sleep(500);

        bot.driveTrain.moveEncoders(-3,0,0,1);
        sleep(500);
        carouselWheel.setPower(-0.55);
        sleep(3000);
        carouselWheel.setPower(0);
        bot.driveTrain.moveEncoders(32, 0, 0, 1);
        sleep(500);
//        bot.driveTrain.moveEncoders(0, 0, 0.03, 0.8);
//        sleep(200);
        bot.driveTrain.moveEncoders(0, 24, 0, 1);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 0, 0.65, 1);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -1, 0, 1);
        sleep(500);
        arm.setPower(-0.5);
        sleep(1600);
        arm.setPower(0.3);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 0, 0.03, 0.5);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 25, 0, 0.7);
        sleep(500);

        bot.driveTrain.moveEncoders(10, 0, 0, 0.7);
        sleep(500);



//        flipServo.setPosition(0.5);
//        bot.driveTrain.moveEncoders(0,-1,0,0.5);


    }
}
