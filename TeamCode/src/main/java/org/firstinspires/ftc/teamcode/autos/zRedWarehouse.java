package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.botconfigs.StaticDischargeBot1;
@Disabled
@Autonomous(name = "Red Warehouse")
public class zRedWarehouse extends LinearOpMode {

    public StaticDischargeBot1 bot;
    public DcMotor carouselWheel = null;
//    public Servo leftLatchServo = null;
    public Servo rightLatchServo = null;
    public ElapsedTime runtime = new ElapsedTime();
    public void runOpMode() {

        bot = new StaticDischargeBot1(telemetry, hardwareMap);
        carouselWheel = hardwareMap.dcMotor.get("wheel");
        rightLatchServo = hardwareMap.servo.get("rightlatch");
//        leftLatchServo = hardwareMap.servo.get("leftlatch");

        rightLatchServo.setPosition(0.5);
//        leftLatchServo.setPosition(0.5);


        waitForStart();
        bot.driveTrain.moveEncoders(-11, 0, 0, 1);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 29, 0, 1);

    }
}
