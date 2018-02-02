package org.firstinspires.ftc.teamcode.Old;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.BILAutonomousCommon;

/**
 * Created by mikab_000 on 10/20/2016.
 */
@Autonomous(name="Cap Ball", group="Old")
@Disabled
public class BILCapBall extends BILAutonomousCommon {

    @Override
    public void runOpMode() throws InterruptedException {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        time.reset();
        while(time.milliseconds() < 20000){
            idle();
        }

        driveDistance(0.5, 5);
    }
}
