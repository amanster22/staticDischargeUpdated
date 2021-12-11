package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.teamcode.botconfigs.StaticDischargeBot1;

import java.util.List;
@Autonomous(name = "Blue StorageUnit")
public class BlueStorageUnit extends LinearOpMode {

    public StaticDischargeBot1 bot;
    public DcMotor carouselWheel = null;
    //    public Servo leftLatchServo=null;
    public Servo rightLatchServo = null;
    public DcMotor arm = null;
    public Servo flickerServo = null;
    public Servo paddleServo = null;
    //public Servo cameraServo = null;
//    private static final String TFOD_MODEL_ASSET = "FreightFrenzy_BCDM.tflite";
//    private static final String[] LABELS = {
//            "Ball",
//            "Cube",
//            "Duck",
//            "Marker"
//    };
//    private static final String VUFORIA_KEY =
//            "Ae+gmGj/////AAABmWz20p9iPUvOnbOi93QfB7sXbfkCt0bYRo0ZsF9MfCnyyqSzGT50iAvJq63Zsze7uk3efapcDwvsUKu7VS7cI0PKl2NJjJc3WzUzZw66E7qNLah2J06uP5XNWi262fa0EcXDFRazWernOoMDrdd2Rh6W1l5Wo9m6TWPDXeToJWbxoEAlURg7wosy4dIU5tGFcQNZ8B9ZODO+FxzYKUz7HOQmZ2FVHF7kGtWJsk+7ikLsh80gtIQFs6M9qY8gvTyhUPZJKzzvTGSvbbotaVzpzWd4Brvl1w00NXnGy/rVVr/cvN+6bBIN2/S/Qrxx4OhFF01r5eTNDshoiQV9xTJQ2Zvcl7eVB1C8lqe1RdtM8I1L";
//
//    /**
//     * {@link #vuforia} is the variable we will use to store our instance of the Vuforia
//     * localization engine.
//     */
//    private VuforiaLocalizer vuforia;
//
//    /**
//     * {@link #tfod} is the variable we will use to store our instance of the TensorFlow Object
//     * Detection engine.
//     */
//    private TFObjectDetector tfod;

//    public Servo flipServo = null;
//    public ElapsedTime runtime = new ElapsedTime();

    public void path3() {
        bot.driveTrain.moveEncoders(11.5, 0, 0, 0.2);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -27.25, 0, 0.3);
        sleep(500);

        bot.driveTrain.moveEncoders(-3, 0, 0, 0.3);
        sleep(500);
        carouselWheel.setPower(-0.5);
        sleep(3000);
        carouselWheel.setPower(0);
        bot.driveTrain.moveEncoders(32, 0, 0, 0.6);
        sleep(500);
//        bot.driveTrain.moveEncoders(0, 0, 0.03, 0.8);
//        sleep(200);
        bot.driveTrain.moveEncoders(0, 24.5, 0, 0.6);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 0, 0.66, 0.6);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -6, 0, 0.2);
        sleep(500);
        arm.setPower(-0.5);
        sleep(1000);
        arm.setPower(0.0);
        sleep(1000);
        flickerServo.setPosition(-0.5);
        sleep(1000);
        flickerServo.setPosition(0.5);
        sleep(500);
        arm.setPower(0.3);
        sleep(500);
        //bot.driveTrain.moveEncoders(0, 0, 0.02, 0.5);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 30, 0, 0.3);
        sleep(500);

        bot.driveTrain.moveEncoders(13.5, 0, 0, 0.3);
        sleep(500);
    }

    public void path2() {
        bot.driveTrain.moveEncoders(11.5, 0, 0, 0.2);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -27.25, 0, 0.3);
        sleep(500);

        bot.driveTrain.moveEncoders(-2.76, 0, 0, 0.3);
        sleep(500);
        carouselWheel.setPower(-0.5);
        sleep(3000);
        carouselWheel.setPower(0);
        bot.driveTrain.moveEncoders(32, 0, 0, 0.6);
        sleep(500);
//        bot.driveTrain.moveEncoders(0, 0, 0.03, 0.8);
//        sleep(200);
        bot.driveTrain.moveEncoders(0, 24.5, 0, 0.6);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 0, 0.66, 0.6);
        sleep(500);
//        bot.driveTrain.moveEncoders(0, -2, 0, 0.2);
//        sleep(500);
        arm.setPower(-0.5);
        sleep(1000);
        arm.setPower(0.0);
        sleep(1000);
        flickerServo.setPosition(-0.5);
        sleep(1000);
        flickerServo.setPosition(0.5);
        sleep(500);
        arm.setPower(0.3);
        sleep(500);
        //bot.driveTrain.moveEncoders(0, 0, 0.02, 0.5);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 28, 0, 0.3);
        sleep(500);

        bot.driveTrain.moveEncoders(13.25, 0, 0, 0.3);
        sleep(500);
    }

    public void path1() {
        bot.driveTrain.moveEncoders(11.5, 0, 0, 0.2);
        sleep(500);
        bot.driveTrain.moveEncoders(0, -27.25, 0, 0.3);
        sleep(500);

        bot.driveTrain.moveEncoders(-2.76, 0, 0, 0.3);
        sleep(500);
        carouselWheel.setPower(-0.5);
        sleep(3000);
        carouselWheel.setPower(0);
        bot.driveTrain.moveEncoders(32, 0, 0, 0.6);
        sleep(500);
//        bot.driveTrain.moveEncoders(0, 0, 0.03, 0.8);
//        sleep(200);
        bot.driveTrain.moveEncoders(0, 24.5, 0, 0.6);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 0, 0.66, 0.6);

//        bot.driveTrain.moveEncoders(0, -2, 0, 0.2);
//        sleep(500);
        flickerServo.setPosition(-0.5);
        sleep(500);
        flickerServo.setPosition(0.5);
        sleep(100);
        arm.setPower(-0.5);
        sleep(600);
        arm.setPower(0.0);
        sleep(1000);

        paddleServo.setPosition(-0.5);
        sleep(1000);


        arm.setPower(0.3);
        sleep(500);
        //bot.driveTrain.moveEncoders(0, 0, 0.02, 0.5);
        sleep(500);
        bot.driveTrain.moveEncoders(0, 22, 0, 0.3);
        sleep(500);

        bot.driveTrain.moveEncoders(13.25, 0, 0, 0.3);
        sleep(500);
    }

    public void runOpMode() {
//        initVuforia();
//        initTfod();
        bot = new StaticDischargeBot1(telemetry, hardwareMap);
        carouselWheel = hardwareMap.dcMotor.get("wheel");
        rightLatchServo = hardwareMap.servo.get("rightlatch");
//        leftLatchServo = hardwareMap.servo.get("leftlatch");
        arm = hardwareMap.dcMotor.get("arm");
        //cameraServo = hardwareMap.servo.get("camera");
        flickerServo = hardwareMap.servo.get("flicker");
        paddleServo = hardwareMap.servo.get("paddle");
        rightLatchServo.setPosition(0.5);
        paddleServo.setPosition(0.35);
        flickerServo.setPosition(0.5);
        //cameraServo.setPosition(-0.4);

//        if (tfod != null) {
//            tfod.activate();
//
//            // The TensorFlow software will scale the input images from the camera to a lower resolution.
//            // This can result in lower detection accuracy at longer distances (> 55cm or 22").
//            // If your target is at distance greater than 50 cm (20") you can adjust the magnification value
//            // to artificially zoom in to the center of image.  For best results, the "aspectRatio" argument
//            // should be set to the value of the images used to create the TensorFlow Object Detection model
//            // (typically 16/9).
//            tfod.setZoom(2.5, 16.0/9.0);
//        }

        waitForStart();
        path3();

//        /**
//         * Activate TensorFlow Object Detection before we wait for the start command.
//         * Do it here so that the Camera Stream window will have the TensorFlow annotations visible.
//         **/
//
//
//        boolean duckDetected1 = false;
//        boolean duckDetected2 = false;
//        boolean duckDetected3 = false;
//
//        if (opModeIsActive()) {
//            while (opModeIsActive()) {
//                if (tfod != null) {
//
//                    // getUpdatedRecognitions() will return null if no new information is available since
//                    // the last time that call was made.
//                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
//                    int i = 0;
//                    for (Recognition recognition : updatedRecognitions) {
//                        telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
//
//                        i++;
//
//                        // check label to see if the camera now sees a Duck         ** ADDED **
//                        if (recognition.getLabel().equals("Duck")) {            //  ** ADDED **
//                            duckDetected1 = true;                             //  ** ADDED **
//                            telemetry.addData("Object Detected", "Duck");      //  ** ADDED **
//                        } else {                                               //  ** ADDED **
//                            duckDetected1 = false;                            //  ** ADDED **
//                        }                                                      //  ** ADDED **
//                    }
//                    telemetry.update();
//
//
//                    cameraServo.setPosition(0.5);
//                    if (duckDetected1 == true) {
//                        break;}
//
//                    for (int j = 0; i < 10; j++) {
//                        if (updatedRecognitions != null) {
//                            telemetry.addData("DuckDetection2", "path2");
//                            duckDetected2 = true;
//                            path2();
//                            break;
//                        }
//                    }
//                    if (duckDetected2 == true) {
//                        break;}
////
//////                    cameraServo.setPosition(0.3);
//                    }
//
//////                    path3();
//////                    break;
////
//                        // telemetry.update();
//                    }
//                }
//
//            }
//
//
//
//        //Detect and add if statements for which path to take (path1, path2, path3)
//
//
//    private void initVuforia() {
//        /*
//         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
//         */
//        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
//
//        parameters.vuforiaLicenseKey = VUFORIA_KEY;
//        parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");
//
//        //  Instantiate the Vuforia engine
//        vuforia = ClassFactory.getInstance().createVuforia(parameters);
//
//        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
//    }
//
//    /**
//     * Initialize the TensorFlow Object Detection engine.
//     */
//    private void initTfod() {
//        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
//                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
//        tfodParameters.minResultConfidence = 0.8f;
//        tfodParameters.isModelTensorFlow2 = true;
//        tfodParameters.inputSize = 320;
//        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
//        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);
//    }
    }
}


