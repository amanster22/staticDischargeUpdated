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
    public Servo flipServo = null;
//    public ElapsedTime runtime = new ElapsedTime();
    public void runOpMode() {

        bot = new StaticDischargeBot1(telemetry, hardwareMap);
        carouselWheel = hardwareMap.dcMotor.get("wheel");

        waitForStart();
        bot.driveTrain.moveEncoders(9, 0, 0, 0.2);
        sleep(200);
        bot.driveTrain.moveEncoders(0, -29, 0, 0.8);
        sleep(200);
        carouselWheel.setPower(-0.55);
        sleep(2300);
        carouselWheel.setPower(0);
        bot.driveTrain.moveEncoders(11.5, 0, 0, 1);
        sleep(100);
        flipServo.setPosition(0.5);

        bot.driveTrain.moveEncoders(0,-1,0,0.5);


    }
}
