package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "motor_control")
public class motor_control extends OpMode {

    private DcMotor motorleft;
    private DcMotor motorright;
    private DcMotor motorvertical;
    private DcMotor motorgrabber;


    private void verticalup(){
        motorvertical.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorvertical.setTargetPosition(1120);
        motorvertical.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorvertical.setPower(0.5);
        motorvertical.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    private void verticaldown(){
        motorvertical.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorvertical.setTargetPosition(-1120);
        motorvertical.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorvertical.setPower(-0.5);
        motorvertical.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    private void grabberclose() {
        motorgrabber.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorgrabber.setTargetPosition(-1120);
        motorgrabber.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorgrabber.setPower(-0.5);
        motorgrabber.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    private void grabberopen() {
        motorgrabber.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorgrabber.setTargetPosition(1120);
        motorgrabber.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorgrabber.setPower(0.5);
        motorgrabber.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void init(){
        motorleft = hardwareMap.dcMotor.get("motorleft");
        motorright = hardwareMap.dcMotor.get("motorright");
        motorvertical = hardwareMap.dcMotor.get("motorvertical");
        motorgrabber = hardwareMap.dcMotor.get("motorgrabber");
        motorright.setDirection(DcMotor.Direction.REVERSE);
        motorgrabber.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorvertical.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorvertical.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorgrabber.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void loop() {
        motorleft.setPower(gamepad1.left_stick_y);
        motorright.setPower(gamepad1.right_stick_y);
        while(gamepad1.left_bumper){
            grabberclose();
        }
        while(gamepad1.left_bumper){
            grabberopen();
        }
        if(gamepad1.y){
            verticalup();
        }
        if(gamepad1.a){
            verticaldown();
        }
        }
    }
