package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.botconfigs.StaticDischargeBot1;

//place to try out Auto functions
@Disabled
@Autonomous(name = "Auto Testing")
public class zRobotAutoTesting extends LinearOpMode {
    public StaticDischargeBot1 bot;
    public ElapsedTime runtime = new ElapsedTime();
    public void runOpMode() {

        bot = new StaticDischargeBot1(telemetry, hardwareMap);


        waitForStart();
        bot.driveTrain.moveEncoders(0, -3, 0, 1);
        sleep(200);
        bot.driveTrain.moveEncoders(0, 0, 0.01, 0.8);
        bot.driveTrain.moveEncoders(0,-5,0,1);



    }
}
