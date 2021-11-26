package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Static Discharge TeleOp", group = "Pushbot")
//@Disabled
public class
staticDischargeTeleOp extends OpMode {

    public DcMotor frontLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor backRightMotor = null;
    public DcMotor carouselWheel = null;
    public DcMotor intakeStars = null;
    public DcMotor armWheels = null;
    public DcMotor arm = null;
    public Servo rollerServo = null;
    public Servo leftLatchServo=null;
    public Servo rightLatchServo=null;
    public Servo paddleServo=null;
    double starSpeed=0.5;
    double carouselWheelSpeed = 0;
    double aWheelSpeed = 0.8;
    boolean lastUp = true;
    boolean lastDown = true;
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
        rollerServo = hardwareMap.servo.get("roller");
        rightLatchServo = hardwareMap.servo.get("rightlatch");
        leftLatchServo = hardwareMap.servo.get("leftlatch");
        arm = hardwareMap.dcMotor.get("arm");
        paddleServo = hardwareMap.servo.get("paddle");

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Aman and Daniel. I'm ready!");    //
    }
    /*     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {

    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        rightLatchServo.setPosition(-0.5);
        leftLatchServo.setPosition(-0.5);
        paddleServo.setPosition(0.5);
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
        }
        else if (gamepad1.left_bumper){
            speedUpdate = 1;
            telemetry.addData("Say", "Speed:normal");
        }
        if (gamepad2.dpad_down){
            arm.setPower(0.3);

        }

        if(gamepad2.dpad_up){
            arm.setPower(-0.5);
        }
//Paddle Servo
        if(gamepad2.right_trigger == 1){
            paddleServo.setPosition(-0.5);
        }
        else if (gamepad2.right_trigger == 0) {
            paddleServo.setPosition(0.5);
        }


        carouselWheel.setPower(.9 * gamepad2.left_stick_y);
        telemetry.addData("speed", carouselWheel);
        telemetry.update();

        lastUp = gamepad1.dpad_up;
        lastDown = gamepad1.dpad_down;

        if (gamepad1.a) {//intake on
//            starSpeed=starSpeed*-1;
            aWheelSpeed=aWheelSpeed;
            intakeStars.setPower(-0.5);
            armWheels.setPower(aWheelSpeed);
            //rollerServo.setDirection(Servo.Direction.FORWARD);
            rollerServo.setPosition(0);
            telemetry.addData("Intake:", true);


        }
        if(gamepad1.b){//intake off
            intakeStars.setPower(1);
            armWheels.setPower(-1);
            rollerServo.setPosition(1);
            telemetry.addData("Intake:", false);
        }
        if(gamepad1.x){//intake off
            intakeStars.setPower(0);
            armWheels.setPower(0);
            rollerServo.setPosition(0.5);
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
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}


