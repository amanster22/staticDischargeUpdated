package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.botconfigs.StaticDischargeBot1;

@Autonomous(name = "Red StorageUnit")
public class RedStorageUnit extends LinearOpMode {

    public StaticDischargeBot1 bot;
    public DcMotor carouselWheel = null;
    public ElapsedTime runtime = new ElapsedTime();
    public void runOpMode() {

        bot = new StaticDischargeBot1(telemetry, hardwareMap);
        carouselWheel = hardwareMap.dcMotor.get("wheel");

        waitForStart();
        bot.driveTrain.moveEncoders(0, 12, 0, 0.8);
        sleep(200);
        bot.driveTrain.moveEncoders(-8, 0, 0, 0.5);
        sleep(200);
        bot.driveTrain.moveEncoders(0, -11, 0, 0.8);
        sleep(200);
        carouselWheel.setPower(-0.35);
        sleep(3500);
        carouselWheel.setPower(0);

//        sleep(3000);
//
//        runtime.reset();
//        while (opModeIsActive() && (runtime.seconds() < 1.3)) {
//            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
//            telemetry.update();
//        }

        sleep(500);
        bot.driveTrain.moveEncoders(0, 9.75, 0, 0.8);
        sleep(200);
        bot.driveTrain.moveEncoders(0,0,-0.03,0.5);
        sleep(200);
        bot.driveTrain.moveEncoders(-4.5, 0, 0, 0.5);
        //sleep(100);
        //bot.driveTrain.moveEncoders(0,-5,0,0.5);


    }
}
