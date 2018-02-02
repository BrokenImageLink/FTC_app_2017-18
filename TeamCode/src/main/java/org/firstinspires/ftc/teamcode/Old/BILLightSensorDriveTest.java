package org.firstinspires.ftc.teamcode.Old;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.BILAutonomousCommon;

/**
 * Made by Zoha Peterson on 12/31/16.
 */
@Autonomous(name="Light Sensor Drive Test", group="Test")
public class BILLightSensorDriveTest extends BILAutonomousCommon {

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);
        robot.lightSensor.enableLed(true);

        double darkFloorValue = robot.lightSensor.getLightDetected();
        while(!isStarted()) {
            darkFloorValue = (darkFloorValue + robot.lightSensor.getLightDetected())/2;

            //continuously calibrate gyro to keep the heading as accurate as possible
            if(!robot.gyroSensor.isCalibrating()){
                robot.gyroSensor.calibrate();
            }

            idle();
        }

//            waitForStart();
        driveUntilLineOrDistance(0.5, 5);


    }
}

