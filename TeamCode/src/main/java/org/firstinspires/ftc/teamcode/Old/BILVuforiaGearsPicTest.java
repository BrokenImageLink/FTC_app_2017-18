package org.firstinspires.ftc.teamcode.Old;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.BILAutonomousCommon;
import org.firstinspires.ftc.teamcode.BILRobotHardware;
import org.firstinspires.ftc.teamcode.BILVuforiaCommon;

/**
 * Created on 12/31/2016 by Mika.
 */
@Autonomous(name="Gears Tracking Test", group="Test")
@Disabled
public class BILVuforiaGearsPicTest extends BILAutonomousCommon {

    VuforiaLocalizer vuforia;
    BILVuforiaCommon helper = new BILVuforiaCommon();
    BILRobotHardware robot = new BILRobotHardware();

    @Override public void runOpMode() throws InterruptedException{
        this.vuforia = helper.initVuforia(false, 4);
        VuforiaTrackables targets = helper.loadTargets("FTC_2016-17", "Wheels", "Tools", "Legos", "Gears");

        robot.init(hardwareMap);

        robot.lightSensor.enableLed(true);

        VuforiaTrackable gearsTarget = targets.get(3);

        waitForStart();

        targets.activate();

        //moveToImage(gearsTarget, helper);

        while(opModeIsActive()) {
            VectorF translation = helper.getTargetTranslation(gearsTarget);
            if (translation != null && Math.abs(translation.get(2)) > helper.targetImageDistance) { // 2 = z
                driveToTarget(translation);
                telemetry.addData("Translation X", translation.get(0));
                telemetry.addData("Translation Y", translation.get(1));
                telemetry.addData("Translation Z", translation.get(2));
            } else {
                if (translation != null) {
                    setAllDriveMotors(0);
                } else {
                    telemetry.addData(gearsTarget.getName() + " Target", "not in view");
                }
            }
            telemetry.update();
            //qidle();
        }
    }
}
