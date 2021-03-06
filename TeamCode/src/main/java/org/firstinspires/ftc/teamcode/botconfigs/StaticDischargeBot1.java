package org.firstinspires.ftc.teamcode.botconfigs;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardwaresystems.MechDriveTrain;
import org.firstinspires.ftc.teamcode.hardwarewrap.DcMotorWrap;
import org.firstinspires.ftc.teamcode.hardwarewrap.ServoWrap;

public class StaticDischargeBot1 {

    public MechDriveTrain driveTrain;
    public ServoWrap latchServo;

    public StaticDischargeBot1(Telemetry tele, HardwareMap map) {
        DcMotorWrap frontRightMotor = new DcMotorWrap(tele, map, "0", 3, 1, 0.8, 420);
        DcMotorWrap backRightMotor = new DcMotorWrap(tele, map, "3", 3, 1, 0.8, 420);
        DcMotorWrap frontLeftMotor = new DcMotorWrap(tele, map, "1", 3, 1, 0.8, 420);
        DcMotorWrap backLeftMotor = new DcMotorWrap(tele, map, "2", 3, 1, 0.8, 420);
//        DcMotorWrap carouselWheel = new DcMotorWrap(tele, map, "carouselWheel", 1, 1, 1, 1120);
        DcMotorWrap[] allMotors = new DcMotorWrap[]{frontRightMotor, backRightMotor, frontLeftMotor, backLeftMotor};
        driveTrain = new MechDriveTrain(tele, allMotors, 1, 1, 20, 1);

//        latchServo = new ServoWrap(tele, map, "latch", 0, 1);

    }
}
