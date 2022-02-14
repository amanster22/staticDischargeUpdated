package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name = "Static Discharge Official TeleOp", group = "Pushbot")

public class StaticDischargeOfficialTeleOp extends LinearOpMode {

    public DcMotor frontLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor backRightMotor = null;
    //public DcMotor carouselWheel = null;
    public DcMotor intakeStars = null;
    public DcMotor armWheels = null;
    public DcMotor arm = null;
    public Servo rollerServo = null;
    public Servo cameraServo=null;
    public Servo upperRoller = null;
    //    public Servo leftLatchServo=null;
//    public Servo rightLatchServo=null;
    public Servo paddleServo=null;
    public Servo flickerServo=null;
    public CRServo carouselWheel = null;
    //public DcMotor carouselWheel = null;
    double starSpeed=0.5;
    double carouselWheelSpeed = 0;
    double aWheelSpeed = -0.75;
    boolean lastUp = true;
    boolean lastDown = true;
    public ElapsedTime Runtime = new ElapsedTime();
    private DistanceSensor sensorRange;
    public RevBlinkinLedDriver lights;
    /*
     * Code to run ONCE when the driver hits INIT
     */
    public void initRobot() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        lights=hardwareMap.get(RevBlinkinLedDriver.class,"lights");
        frontLeftMotor = hardwareMap.dcMotor.get("1");
        frontRightMotor = hardwareMap.dcMotor.get("0");
        backLeftMotor = hardwareMap.dcMotor.get("2");
        backRightMotor = hardwareMap.dcMotor.get("3");
        carouselWheel = hardwareMap.get(CRServo.class, "wheel");
        //carouselWheel = hardwareMap.dcMotor.get("wheel");
        intakeStars = hardwareMap.dcMotor.get("stars");
        armWheels = hardwareMap.dcMotor.get("armwheel");
        rollerServo = hardwareMap.servo.get("rollerS");
//        rightLatchServo = hardwareMap.servo.get("rightlatch");
//        leftLatchServo = hardwareMap.servo.get("leftlatch");
        sensorRange = hardwareMap.get(DistanceSensor.class, "range");
        arm = hardwareMap.dcMotor.get("arm");
        paddleServo = hardwareMap.servo.get("paddle");
        flickerServo = hardwareMap.servo.get("flicker");
        cameraServo=hardwareMap.servo.get("camera");
        upperRoller=hardwareMap.servo.get("roller2");
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hey Avneesh and Daniel. Lets go!");    //
        telemetry.addData("Servo Pos", paddleServo.getPosition());
        telemetry.update();
        lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
    }
    /*     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    public void initloopRobot() {
//        rightLatchServo.setPosition(-0.8);

        paddleServo.setPosition(0.5);
        cameraServo.setPosition(-1);
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    public void startRobot() {
        intakeStars.setPower(1);
        sleep(1000);
        intakeStars.setPower(0);
//        leftLatchServo.setPosition(-0.5);
        paddleServo.setPosition(0.5);
        flickerServo.setPosition(0.5);
        Runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    public void loopRobot() {
        if (Runtime.time() >= 40)
        {
            telemetry.addData("20 seconds left until End Game", "YAY!");
            lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.HOT_PINK);
        }
        double vert = 0;
        double hori = 0;
        double turn = 0;
        double speedUpdate = 1;
        telemetry.addData("Speed:", carouselWheelSpeed);

        boolean clawOpen = false;
        boolean clawClose = false;

        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        vert = gamepad1.left_stick_y;
        hori = -gamepad1.left_stick_x;
        turn = -1 * gamepad1.right_stick_x;


//        clawOpen = gamepad2.right_bumper;
//        clawClose = gamepad2.left_bumper;


        if (gamepad1.right_bumper) {
            speedUpdate = 0.2;
            telemetry.addData("Say", "Speed:slow");
        }
        else if (gamepad1.left_bumper){
            speedUpdate = 1;
            telemetry.addData("Say", "Speed:normal");
        }

        if(gamepad2.dpad_up){
            lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_OCEAN_PALETTE);
            frontLeftMotor.setPower(0);
            frontRightMotor.setPower(0);
            backLeftMotor.setPower(0);
            backRightMotor.setPower(0);
            arm.setPower(-0.5);
            sleep(700);
            arm.setPower(0.0);
            //automated
            flickerServo.setPosition(-0.7);
            sleep(500);
            flickerServo.setPosition(0.5);
            sleep(700);
            arm.setPower(0.6);
            sleep(600);
            arm.setPower(0.0);


        }
//Paddle Servo
        if(gamepad2.right_trigger == 1){
            paddleServo.setPosition(-0.5);
        }
        else if (gamepad2.right_trigger == 0) {
            paddleServo.setPosition(0.5);
        }
//Flicker Servo
        if(gamepad2.left_trigger == 1){
            flickerServo.setPosition(-0.5);
        }
        else if (gamepad2.left_trigger == 0) {
            flickerServo.setPosition(0.5);
        }

        if (gamepad2.dpad_down) {
            arm.setPower(-0.5);
            sleep(200);
            arm.setPower(0.4);
            arm.setPower(0);
        }

        carouselWheel.setPower(.6 * gamepad2.left_stick_y);
        lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.YELLOW);
        telemetry.addData("speed", carouselWheel.getPower());
        telemetry.update();

        lastUp = gamepad1.dpad_up;
        lastDown = gamepad1.dpad_down;

        if (gamepad1.a) {//intake on
//            starSpeed=starSpeed*-1;
            intakeStars.setPower(0.5);
            armWheels.setPower(aWheelSpeed);
            //rollerServo.setDirection(Servo.Direction.FORWARD);
            rollerServo.setPosition(1);
            upperRoller.setPosition(0);
            lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
            telemetry.addData("Intake:", true);


        }
        if(gamepad1.b){//intake reverse
            intakeStars.setPower(1);
            armWheels.setPower(1);
            rollerServo.setPosition(0);
            upperRoller.setPosition(1);
            telemetry.addData("Intake:", false);
            lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.HOT_PINK);
        }
        if(gamepad1.x){//intake off
            intakeStars.setPower(0);
            armWheels.setPower(0);
            rollerServo.setPosition(-0.5);
            upperRoller.setPosition(-0.5);
            telemetry.addData("Intake:", false);
        }

//        if(gamepad1.x){
//            latchServo.setPosition(0.5);
//        }
//        if(gamepad1.y){
//            latchServo.setPosition(-0.5);
//        }
        //Holonomic Drivetrain code
        frontLeftMotor.setPower(-speedUpdate * (vert + hori + turn));
        backLeftMotor.setPower(-speedUpdate * (vert - hori + turn));
        frontRightMotor.setPower(speedUpdate * (vert - hori - turn));
        backRightMotor.setPower(speedUpdate * (vert + hori - turn));
        telemetry.addData("range", String.format("%.01f cm", sensorRange.getDistance(DistanceUnit.CM)));

        if(sensorRange.getDistance(DistanceUnit.CM)<10){
            lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);

        }
        else if((sensorRange.getDistance(DistanceUnit.CM)<13)&&(sensorRange.getDistance(DistanceUnit.CM)>11)){
            lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.ORANGE);

        }
        else if (sensorRange.getDistance(DistanceUnit.CM)>13){
            lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.CONFETTI);

        }

    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    public void stopRobot() {
    }

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        initloopRobot();
        waitForStart();
        startRobot();
        while (opModeIsActive()) {
            loopRobot();
        }
        stopRobot();
    }
}



