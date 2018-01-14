package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="POV_Drive_Final")

public class Messi_Magic extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motorfrontleft = null;
    private DcMotor motorfrontright = null;
    private DcMotor motorbackleft = null;
    private DcMotor motorbackright = null;
    private DcMotor motorvertical = null;
    private Servo servograbber = null;
    private Servo servoarm = null;
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        motorfrontleft = hardwareMap.get(DcMotor.class, "motorfrontleft");
        motorfrontright = hardwareMap.get(DcMotor.class, "motorfrontright");
        motorbackleft = hardwareMap.get(DcMotor.class, "motorbackleft");
        motorbackright = hardwareMap.get(DcMotor.class, "motorbackright");
        motorvertical = hardwareMap.get(DcMotor.class, "motorvertical");
        servograbber = hardwareMap.get(Servo.class, "servograbber");
        servoarm = hardwareMap.servo.get("servoarm");
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        motorfrontleft.setDirection(DcMotor.Direction.FORWARD);
        motorbackleft.setDirection(DcMotor.Direction.FORWARD);
        motorfrontright.setDirection(DcMotor.Direction.REVERSE);
        motorbackright.setDirection(DcMotor.Direction.REVERSE);
        motorvertical.setPower(1);
        sleep(5000);
        servograbber.setPosition(1);
        motorvertical.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //Drive Components
            double frontleft;
            double frontright;
            double backleft;
            double backright;
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            frontleft = Range.clip(drive + turn, -1.0, 1.0);
            backleft = Range.clip(drive + turn, -1.0, 1.0);
            frontright = Range.clip(drive - turn, -1.0, 1.0);
            backright = Range.clip(drive - turn, -1.0, 1.0);
            motorfrontleft.setPower(frontleft);
            motorfrontright.setPower(frontright);
            motorbackleft.setPower(backleft);
            motorbackright.setPower(backright);
            //Servo Code
            if (gamepad1.left_bumper){
                servograbber.setPosition(1);
            }
            if (gamepad1.right_bumper){
                servograbber.setPosition(0);
            }
            if(gamepad2.right_bumper){
                servoarm.setPosition(1);
            }
            if (gamepad2.left_bumper){
                servoarm.setPosition(0);
            }


            //Encoded Motors
            if (gamepad1.a){
                lift(2500);
            }
            if (gamepad1.b){
                lift(5000);
            }
            if (gamepad1.x){
                lift(0);
            }
            if (gamepad1.y){
                lift(7000);
            }



            //DataCollection
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("DriveMotors", "frontleft (%.2f), frontright (%.2f), backleft (%.2f), backright (%.2f)", frontleft, frontright, backleft, backright);
            telemetry.addData("VerticalMotors", "vertical (%.2f)", vertical);
            telemetry.update();
        }
    }
    public void lift(int distance){

        while(motorvertical.getCurrentPosition() < distance){
            motorvertical.setTargetPosition(distance);
            vertical = 1;
            motorvertical.setPower(vertical);
            motorvertical.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        while(motorvertical.getCurrentPosition() > distance){
            motorvertical.setTargetPosition(distance);
            vertical = -1;
            motorvertical.setPower(vertical);
            motorvertical.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }
    public double vertical;

}