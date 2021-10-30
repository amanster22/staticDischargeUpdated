package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.botconfigs.StaticDischargeBot1;

@Autonomous(name = "Blue Warehouse")
public class BlueWarehouse extends LinearOpMode {
//Edmond Says hi
    public StaticDischargeBot1 bot;
    public DcMotor carouselWheel = null;
    public ElapsedTime runtime = new ElapsedTime();
    public void runOpMode() {

        bot = new StaticDischargeBot1(telemetry, hardwareMap);
        carouselWheel = hardwareMap.dcMotor.get("wheel");

        waitForStart();
        bot.driveTrain.moveEncoders(11, 0, 0, 1);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 35, 0, 1);

    }
}
