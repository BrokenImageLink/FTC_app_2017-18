package org.firstinspires.ftc.teamcode.Old;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.BILAutonomousCommon;

/**
 * Created by mikab_000 on 1/9/2018.
 */

@Autonomous(name="Encoder Test", group="Test")
public class BILEncoderTest extends BILAutonomousCommon {

    @Override public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

        robot.motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.motorFrontLeft.setPower(0.2);
        delayWithTelemetry(5000, "Front Left Encoder Position", robot.motorFrontLeft.getCurrentPosition());
        setAllDriveMotors(0);
        delay(1000);

        robot.motorFrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.motorFrontLeft.setPower(0.2);
        delayWithTelemetry(5000, "Front Left Encoder Position", robot.motorFrontLeft.getCurrentPosition());
        setAllDriveMotors(0);
        delay(1000);

        robot.motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.motorBackLeft.setPower(0.2);
        delayWithTelemetry(5000, "Back Left Encoder Position", robot.motorBackLeft.getCurrentPosition());
        setAllDriveMotors(0);
        delay(1000);

        robot.motorBackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.motorBackLeft.setPower(0.2);
        delayWithTelemetry(5000, "Back Left Encoder Position", robot.motorBackLeft.getCurrentPosition());
        setAllDriveMotors(0);
        delay(1000);

        robot.motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.motorFrontRight.setPower(0.2);
        delayWithTelemetry(5000, "Front Right Encoder Position", robot.motorFrontRight.getCurrentPosition());
        setAllDriveMotors(0);
        delay(1000);

        robot.motorFrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.motorFrontRight.setPower(0.2);
        delayWithTelemetry(5000, "Front Right Encoder Position", robot.motorFrontRight.getCurrentPosition());
        setAllDriveMotors(0);
        delay(1000);

        robot.motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.motorBackRight.setPower(0.2);
        delayWithTelemetry(5000, "Back Right Encoder Position", robot.motorBackRight.getCurrentPosition());
        setAllDriveMotors(0);
        delay(1000);

        robot.motorBackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.motorBackRight.setPower(0.2);
        delayWithTelemetry(5000, "Back Right Encoder Position", robot.motorBackRight.getCurrentPosition());
        setAllDriveMotors(0);
    }

    private void delayWithTelemetry(int milliseconds, String caption, Object val) {
        time.reset();
        while(time.milliseconds() < milliseconds && !isStopRequested()){
            telemetry.addData(caption, val);
            telemetry.update();
            idle();
        }
    }
}