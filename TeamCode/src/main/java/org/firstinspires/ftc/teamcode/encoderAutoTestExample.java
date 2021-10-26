package org.firstinspires.ftc.teamcode;

import android.provider.Telephony;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;


@Autonomous(name = "EncoderHolonomicDrive", group = "StaticDischarge")
@Disabled
public class encoderAutoTestExample extends LinearOpMode {
//hi
    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();

    static final double COUNTS_PER_MOTOR_REV = 560;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 1.0;     // This is < 1.0 if geared UP
    static final double WHEEL_DIAMETER_INCHES = 3.0;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double DRIVE_SPEED = 0.6;
    static final double TURN_SPEED = 0.5;

    public DcMotor frontLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor backRightMotor = null;
//    public DcMotor hexMotor = null;
//    public Servo claw=null;


//    //Cam Vision
//    private static final String TFOD_MODEL_ASSET = "UltimateGoal.tflite";
//    private static final String LABEL_FIRST_ELEMENT = "Quad";
//    private static final String LABEL_SECOND_ELEMENT = "Single";
//    private static final String VUFORIA_KEY =
//            "AQTNK6//////AAABmS6GiCaA0E3ctlsVLLhhe7cu9F0RyBP6S9U9NFFmNEOub8rkZyhWrx7HboBko3/TCRxyiVIE7fNShuP0GmXi22NCtRA2rNDWNnUCT187l+Ocfr78ZbXx3eTNug23il7uZQUftyN9oby8kITPJTNlY2N07NMUmNuWw+FiiKo807axbrt/yQoM4w96seUTfVogx3CQeazZ42UaCReEjSpRoYsrZPmbF3GsoypQXHsezzEBbp6K1z7cJKe4ctYCjTd53CbgB2Y1NJcyZRm8jaNr1jRzt1Z0CmsVYCeZN6C/1JvFRP8PAmyQdzEfGR3ox1Ti8V3x6QKiWt84DdMfOcUGDoZ2NQCXhFHMjG68zW1EXWtl";
//    private VuforiaLocalizer vuforia;
//    private TFObjectDetector tfod;
    int target=1;

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         */
        frontLeftMotor = hardwareMap.dcMotor.get("1");
        frontRightMotor = hardwareMap.dcMotor.get("0");
        backLeftMotor = hardwareMap.dcMotor.get("2");
        backRightMotor = hardwareMap.dcMotor.get("3");
//        hexMotor=hardwareMap.dcMotor.get("arm");
//        claw=hardwareMap.servo.get("claw");


        // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
        // first.
//        initVuforia();
//        initTfod();
//        claw.setPosition(0);

        /**
         * Activate TensorFlow Object Detection before we wait for the start command.
         * Do it here so that the Camera Stream window will have the TensorFlow annotations visible.
         **/




//        if (tfod != null) {
//            tfod.activate();
//
//            // The TensorFlow software will scale the input images from the camera to a lower resolution.
//            // This can result in lower detection accuracy at longer distances (> 55cm or 22").
//            // If your target is at distance greater than 50 cm (20") you can adjust the magnification value
//            // to artificially zoom in to the center of image.  For best results, the "aspectRatio" argument
//            // should be set to the value of the images used to create the TensorFlow Object Detection model
//            // (typically 16/9).
//            tfod.setZoom(2.5, 16.0 / 9.0);
//        }
        telemetry.addData(">", "Press Play to start op mode");
        telemetry.update();


        //*********************************************PLAY BUTTON IS PRESSED*********************************************
        waitForStart();



        /** Wait for the game to begin */





//set target----------------------------
        target=1;
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Resetting Encoders");    //
        telemetry.update();
        encoderReset();
        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Path0", "Starting at %7d :%7d",
                backLeftMotor.getCurrentPosition(),
                backRightMotor.getCurrentPosition());
        telemetry.update();


//Motion Begins

        if (target == 3) {
            encoderHolonomicDrive(DRIVE_SPEED, 110, 110, 0, 5.0);  // S1: Forward 47 Inches with 5 Sec timeout
            encoderReset();
            encoderHolonomicDrive(0.3, 0, 0, 30, 3);
//            claw.setPosition(0.5);
        }
        else if (target == 2) {
            encoderHolonomicDrive(DRIVE_SPEED, 90, 90, 0, 5);
            encoderReset();
            encoderHolonomicDrive(DRIVE_SPEED, 0, 0,  8, 4);
//            claw.setPosition(0.5);
        }
        else if (target == 1) {
            encoderHolonomicDrive(DRIVE_SPEED, 70, 70, 0, 4);
            encoderReset();
            encoderHolonomicDrive(DRIVE_SPEED, 0, 0, 30, 4);
//            claw.setPosition(0.5);


        } else {
            encoderHolonomicDrive(0.8, 60, 60, 0, 4);
//            claw.setPosition(0.5);
        }

        sleep(1000);     // pause for servos to move

        telemetry.addData("Path", "Complete");
        telemetry.update();
    }

    //Methods
    public void encoderHolonomicDrive(double speed, double leftInches, double rightInches, double horiInches, double timeoutS) {
        int newLeftTarget;
        int newRightTarget;
        int newSideTarget = 0;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftTarget = frontLeftMotor.getCurrentPosition() + (int) (-leftInches * -COUNTS_PER_INCH);
            newRightTarget = frontRightMotor.getCurrentPosition() + (int) (-rightInches * COUNTS_PER_INCH);

            if (horiInches != 0) {
                newLeftTarget = 0;
                newRightTarget = 0;
                newSideTarget = (int) (-horiInches * COUNTS_PER_INCH);

                frontLeftMotor.setTargetPosition(newLeftTarget + newSideTarget);//updated
                backLeftMotor.setTargetPosition(newLeftTarget + newSideTarget);
                frontRightMotor.setTargetPosition(newRightTarget + newSideTarget);//updated
                backRightMotor.setTargetPosition(newRightTarget + newSideTarget);
            }
            frontLeftMotor.setTargetPosition(newLeftTarget - newSideTarget);
            backLeftMotor.setTargetPosition(newLeftTarget + newSideTarget);
            frontRightMotor.setTargetPosition(newRightTarget - newSideTarget);
            backRightMotor.setTargetPosition(newRightTarget + newSideTarget);


            // Turn On RUN_TO_POSITION
            frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();

            frontLeftMotor.setPower(Math.abs(speed));
            frontRightMotor.setPower(Math.abs(speed));
            backLeftMotor.setPower(Math.abs(speed));
            backRightMotor.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (frontLeftMotor.isBusy() && frontRightMotor.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Path1", "Running to %7d :%7d", newLeftTarget, newRightTarget);
                telemetry.addData("Path2", "Running at %7d :%7d",
                        frontLeftMotor.getCurrentPosition(),
                        frontRightMotor.getCurrentPosition());
                telemetry.update();
            }

            // Stop all motion;
            frontLeftMotor.setPower(0);
            frontRightMotor.setPower(0);
            backLeftMotor.setPower(0);
            backRightMotor.setPower(0);

            // Turn off RUN_TO_POSITION
            frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
        }
    }

    /*
    private void initVuforia() {
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
    }

    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.8f;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
    }
    */

    public void encoderReset() {
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(500);
    }
}


