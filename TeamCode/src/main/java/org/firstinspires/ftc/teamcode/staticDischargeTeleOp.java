package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "Static Discharge Testing", group = "Pushbot")
//@Disabled


public class staticDischargeTeleOp extends OpMode {

    /* Declare OpMode members. */
//    HardwarePushbot robot       = new HardwarePushbot(); // use the class created to define a Pushbot's hardware
//    double          clawOffset  = 0.0 ;                  // Servo mid position
//    final double    CLAW_SPEED  = 0.02 ;                 // sets rate to move servo
    public DcMotor frontLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor backRightMotor = null;
    public DcMotor carouselWheel = null;
    public DcMotor intakeStars = null;
    public DcMotor intakeBase = null;
    public DcMotor armWheels = null;
    double starSpeed=0.5;
    double carouselWheelSpeed = 0;
    double aWheelSpeed = 0.8;
    boolean lastUp = true;
    boolean lastDown = true;

//    public DcMotor lift = null;

//    public Servo claw = null;
//    public DcMotor hexMotor = null;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */

        frontLeftMotor = hardwareMap.dcMotor.get("1");
        frontRightMotor = hardwareMap.dcMotor.get("0");
        backLeftMotor = hardwareMap.dcMotor.get("2");
        backRightMotor = hardwareMap.dcMotor.get("3");
        carouselWheel = hardwareMap.dcMotor.get("wheel");
        intakeStars = hardwareMap.dcMotor.get("stars");
        armWheels = hardwareMap.dcMotor.get("armwheel");
//        lift=hardwareMap.dcMotor.get("lift");
//        claw  = hardwareMap.servo.get("claw");
//        hexMotor = hardwareMap.dcMotor.get("hex");


        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Aman");    //
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {

    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {

    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
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
        } else {
            telemetry.addData("Say", "Speed:normal");
        }




        carouselWheel.setPower(.9 * gamepad2.left_stick_y);


        telemetry.addData("speed", carouselWheel);
        telemetry.update();

        lastUp = gamepad1.dpad_up;
        lastDown = gamepad1.dpad_down;

        if (gamepad1.a) {
            starSpeed=starSpeed*-1;
            intakeStars.setPower(starSpeed);
            armWheels.setPower(aWheelSpeed);
        }
        if(gamepad1.b){
            intakeStars.setPower(0);
            armWheels.setPower(0);
        }


        frontLeftMotor.setPower(-speedUpdate * (vert + hori + turn));
        backLeftMotor.setPower(-speedUpdate * (vert - hori + turn));
        frontRightMotor.setPower(speedUpdate * (vert - hori - turn));
        backRightMotor.setPower(speedUpdate * (vert + hori - turn));




    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}





