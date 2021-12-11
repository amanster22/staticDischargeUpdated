package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.botconfigs.StaticDischargeBot1;
@Disabled
@Autonomous(name = "")
public class WarehousePark2 extends LinearOpMode {

    public StaticDischargeBot1 bot;

    public void runOpMode() {

        bot = new StaticDischargeBot1(telemetry, hardwareMap);

        waitForStart();

        bot.driveTrain.moveEncoders(0,20,0,0.7);
        bot.driveTrain.moveEncoders(0,0,0.1,0.7);
    }
}
