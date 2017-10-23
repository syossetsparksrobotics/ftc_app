package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "motor_control")
public class motor_control extends OpMode {

    private DcMotor motorleft;
    private DcMotor motorright;
    private DcMotor motorvertical;
    @Override
    public void init(){
        motorleft = hardwareMap.dcMotor.get("motorleft");
        motorright = hardwareMap.dcMotor.get("motorright");
        motorvertical = hardwareMap.dcMotor.get("motorvertical");
        motorleft.setDirection(DcMotor.Direction.REVERSE);

    }
    public void loop() {
        motorleft.setPower(gamepad1.left_stick_y);
        motorright.setPower(gamepad1.right_stick_y);
        while(gamepad1.dpad_up){
            motorvertical.setPower(1);
        }
        while(gamepad1.dpad_down){
            motorvertical.setPower(-1);
        }
        }
    }
