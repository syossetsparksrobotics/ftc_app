package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Test_Color")
public class Test_Color extends LinearOpMode{
    public ColorSensor color_sensor;
    public DcMotor motorfrontleft;
    public DcMotor motorfrontright;
    public DcMotor motorbackleft;
    public DcMotor motorbackright;
    public Servo servoarm;
    public ElapsedTime runtime = new ElapsedTime();
@Override
        public void runOpMode(){
            color_sensor = hardwareMap.colorSensor.get("color_sensor");
            motorfrontleft = hardwareMap.dcMotor.get("motorfrontleft");
            motorfrontright = hardwareMap.dcMotor.get("motorfrontright");
            motorbackleft = hardwareMap.dcMotor.get("motorbackleft");
            motorbackright = hardwareMap.dcMotor.get("motorbackright");
            servoarm = hardwareMap.servo.get("servoarm");
            telemetry.addData("Status", "Initialized");
            telemetry.update();

            waitForStart();
            runtime.reset();

        while (opModeIsActive()){
            servoarm.setPosition(1);
            color_sensor.enableLed(true);
            sleep(500);

            if (color_sensor.red() > 150){
                rotate(0, 2500);
            }
            else{
                rotate(0, -2500);
            }
            sleep(2500);
                if (motorfrontleft.getCurrentPosition() > 2400){
                    rotate(2500, 0);
                }
                else if (motorfrontleft.getCurrentPosition() < 2400){
                    rotate(-2500,0);
                }
            motorfrontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorfrontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorbackright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorbackleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            sleep(1000);
            move(0, 4000);
            rotate(0, 5000);
            motorfrontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorfrontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorbackright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorbackleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            move(0, -2000);
        }
    }
    public void rotate(int rotations, int target){
            while (rotations < target){
                motorfrontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                motorfrontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                motorbackright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                motorbackleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                motorfrontright.setTargetPosition(target);
                motorfrontleft.setTargetPosition(target);
                motorbackright.setTargetPosition(target);
                motorbackleft.setTargetPosition(target);
                motorbackleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                motorbackright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                motorfrontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                motorfrontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                motorbackleft.setPower(-1);
                motorbackright.setPower(-1);
                motorfrontleft.setPower(-1);
                motorfrontright.setPower(-1);

            }
            while (rotations > target){
                motorfrontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                motorfrontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                motorbackright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                motorbackleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                motorfrontright.setTargetPosition(target);
                motorfrontleft.setTargetPosition(target);
                motorbackright.setTargetPosition(target);
                motorbackleft.setTargetPosition(target);
                motorbackleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                motorbackright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                motorfrontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                motorfrontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                motorbackleft.setPower(1);
                motorbackright.setPower(1);
                motorfrontleft.setPower(1);
                motorfrontright.setPower(1);

            }
    }
    public void move(int rotations, int target){
        while (rotations < target){
            motorfrontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorfrontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorbackright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorbackleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorfrontright.setTargetPosition(target);
            motorfrontleft.setTargetPosition(target);
            motorbackright.setTargetPosition(target);
            motorbackleft.setTargetPosition(target);
            motorbackleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorbackright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorfrontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorfrontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorbackleft.setPower(1);
            motorbackright.setPower(-1);
            motorfrontleft.setPower(1);
            motorfrontright.setPower(-1);
            motorfrontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorfrontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorbackright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorbackleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
        while (rotations > target){
            motorfrontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorfrontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorbackright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorbackleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorfrontright.setTargetPosition(target);
            motorfrontleft.setTargetPosition(target);
            motorbackright.setTargetPosition(target);
            motorbackleft.setTargetPosition(target);
            motorbackleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorbackright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorfrontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorfrontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorbackleft.setPower(-1);
            motorbackright.setPower(1);
            motorfrontleft.setPower(-1);
            motorfrontright.setPower(1);
            motorfrontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorfrontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorbackright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorbackleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
    }
}
