package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import static org.firstinspires.ftc.teamcode.BILAutonomousCommon.Color.*;


/**
 * Created by nill on 1/9/2017.
 */


@Autonomous(name="BIL: Autonomous Blue", group="BIL")
public class BILAutonomousBlue extends BILAutonomousCommon {

    @Override public void runOpMode() throws InterruptedException {
        boolean rightMovement = false;
        boolean leftMovement = false;

        robot.init(hardwareMap);

        robot.colorSensor.enableLed(true);

        waitForStart();

        robot.leftGrabber.setPosition(0.8);

        robot.jewelArm.setPosition(0.0);

        delay(2000);

        telemetry.addData("Red", robot.colorSensor.red());
        telemetry.addData("Blue", robot.colorSensor.blue());
        telemetry.update();


//        if(robot.colorSensor.red() > robot.colorSensor.blue()){ //left side red
//
//            setDriveMotors(-0.5, -0.5, 0.5, 0.5);
//            leftMovement = true;
//        } else if(robot.colorSensor.blue() > robot.colorSensor.red()) { //right side is red
//
//            setDriveMotors(0.5, 0.5, -0.5, -0.5);
//            rightMovement = true;
//        }


        Color left = detectLeft();

        time.reset();

        delay(250);

        setAllDriveMotors(0);
        robot.jewelArm.setPosition(robot.jewelArmStartPosition);

        delay(500);

        if(left == RED) {
            setDriveMotors(-0.5,-0.5,0.5,0.5);
        } else if(left == BLUE) {
            setDriveMotors(0.5,0.5,-0.5,-0.5);
        }

        time.reset();

        delay(250);

        setAllDriveMotors(0);
        //setDriveMotors(0.5, -0.5, -0.5, 0.5);

        delay(2000);
    }
}