package org.firstinspires.ftc.teamcode.Old;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.BILAutonomousCommon;

/**
 * Created by mikab_000 on 1/10/2017.
 */
@Autonomous(name="Strafe Test", group="Test")
public class BILStrafeTest extends BILAutonomousCommon {

    @Override
    public void runOpMode() throws InterruptedException{
        robot.init(hardwareMap);

        waitForStart();

        setDriveMotors(0.5, -0.5, -0.5, 0.5);

        delay(2000);

        setAllDriveMotors(0);

    }
}

