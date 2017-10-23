package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;



@TeleOp(name = "motorcontrollerlinear")
public class motorcontrollinear extends LinearOpMode {
    private DcMotor motorleft;
    private DcMotor motorright;
    private DcMotor motorvertical;
    @Override
    public void runOpMode()throws InterruptedException{
        motorleft = hardwareMap.dcMotor.get("motorleft");
        motorright = hardwareMap.dcMotor.get("motorright");
        motorvertical = hardwareMap.dcMotor.get("motorvertical");
        motorleft.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();
        while(opModeIsActive()){
            motorleft.setPower(gamepad1.left_stick_y);
            motorright.setPower(gamepad1.right_stick_y);
            while(gamepad1.dpad_up){
                motorvertical.setPower(1);
            }
            while(gamepad1.dpad_down){
                motorvertical.setPower(-1);
            }

            idle();
        }
    }
}
