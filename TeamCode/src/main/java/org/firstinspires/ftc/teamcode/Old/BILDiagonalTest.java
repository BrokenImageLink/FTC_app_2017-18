package org.firstinspires.ftc.teamcode.Old;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.BILAutonomousCommon;

/**
 * Created on 1/10/2017 by Mika.
 */
@Autonomous(name="Diagonal Test", group="Test")
public class BILDiagonalTest extends BILAutonomousCommon {

    @Override
    public void runOpMode() throws InterruptedException{
        robot.init(hardwareMap);

        waitForStart();

        setDriveMotors(0.5, 0, 0, 0.5);

        delay(2000);

        setAllDriveMotors(0);
    }
}
