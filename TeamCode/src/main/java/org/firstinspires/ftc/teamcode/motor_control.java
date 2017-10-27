package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "motor_control")
public class motor_control extends OpMode {

    private DcMotor motorleft;
    private DcMotor motorright;
    private DcMotor motorvertical;


    public void verticalup(){
        motorvertical.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorvertical.setTargetPosition(1120);
        motorvertical.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void verticaldown(){
        motorvertical.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorvertical.setTargetPosition(-1120);
        motorvertical.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void init(){
        motorleft = hardwareMap.dcMotor.get("motorleft");
        motorright = hardwareMap.dcMotor.get("motorright");
        motorvertical = hardwareMap.dcMotor.get("motorvertical");
        motorright.setDirection(DcMotor.Direction.REVERSE);
        motorvertical.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    public void loop() {
        motorleft.setPower(gamepad1.left_stick_y);
        motorright.setPower(gamepad1.right_stick_y);
        if(gamepad1.a){
            verticalup();
        }
        if(gamepad1.b){
            verticaldown();
        }
        }
    }
