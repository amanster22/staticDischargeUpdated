package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.botconfigs.StaticDischargeBot1;

@Autonomous(name = "Blue Warehouse")
public class BlueWarehouse extends LinearOpMode {
//Daniel
// Says hi
    public StaticDischargeBot1 bot;
    public DcMotor carouselWheel = null;
    public Servo blockDropper = null;
    public ElapsedTime runtime = new ElapsedTime();
    public void runOpMode() {

        bot = new StaticDischargeBot1(telemetry, hardwareMap);
        carouselWheel = hardwareMap.dcMotor.get("wheel");
//hello
        waitForStart();
        bot.driveTrain.moveEncoders(0,20,0,0.7);
        sleep(200);
        bot.driveTrain.moveEncoders(0,0,0.2,0.7);
        sleep(200);
        bot.driveTrain.moveEncoders(0,8,0,0.5);
        blockDropper.setPosition(0.5);

    }
}
