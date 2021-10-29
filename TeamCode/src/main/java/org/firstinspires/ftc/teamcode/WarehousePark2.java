package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.botconfigs.StaticDischargeBot1;

@Autonomous(name = "WarehousePark2")
public class WarehousePark2 extends LinearOpMode {

    public StaticDischargeBot1 bot;

    public void runOpMode() {

        bot = new StaticDischargeBot1(telemetry, hardwareMap);

        waitForStart();

        bot.driveTrain.moveEncoders(8, 0, 0, 1);
        bot.driveTrain.moveEncoders(0, 37, 0, 1);
    }
}
