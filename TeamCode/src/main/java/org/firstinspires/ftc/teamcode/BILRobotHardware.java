package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created on 10/20/2016 by Mika.
 */
public class BILRobotHardware {
    /* Public OpMode members. */
    public DcMotor motorFrontRight;
    public DcMotor motorBackRight;
    public DcMotor motorFrontLeft;
    public DcMotor motorBackLeft;
    //public DcMotor motorLift;
    public DcMotor motorLift;
    //public DcMotor relicExtender;
    public LightSensor lightSensor;
    public GyroSensor gyroSensor;
    public ColorSensor colorSensor;
    //public Servo relicRecoverer;
    public Servo jewelArm;
    public Servo rightGrabber;
    public Servo leftGrabber;
    public double pusherLeft = 0.80;
    public double pusherMiddle = 0.45;
    public double pusherRight = 0.10;
    public DcMotor glyphGatherer;
    public Servo liftPitch;
    public Servo relicGrab;
    public Servo relicExtend;
    public Servo relicDeploy;

    public double liftHolderStart = 0.2;
    public int liftHolderRelease = 1;
    public double rightGripperMaxRight = 0.0;
    public double leftGripperMaxLeft = 0.0;
    public double jewelArmStartPosition = 0.5;

    public Servo pusher; //for compatibility

    /* local OpMode members. */
    HardwareMap hwMap = null;

    /* Constructor */
    public BILRobotHardware(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        //Define and Initialize Motors
        //Left_Front, Left_Back, Right_Front, Right_Back
        motorFrontRight = hwMap.dcMotor.get("Right_Front");
        motorBackRight = hwMap.dcMotor.get("Right_Back");
        motorFrontLeft = hwMap.dcMotor.get("Left_Front");
        motorBackLeft = hwMap.dcMotor.get("Left_Back");
        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotor.Direction.REVERSE
                                   
        motorLift = hwMap.dcMotor.get("Lift");
        relicGrab = hwMap.servo.get("Relic_Claw");
        relicExtend = hwMap.servo.get("Relic_Extend");
        liftPitch = hwMap.servo.get("Lift_Pitch");
        glyphGatherer = hwMap.dcMotor.get("Glyph_gatherer");
        relicDeploy = hwMap.servo.get("Relic_deploy");

        //Lift & Extender Motors
        //motorLift = hwMap.dcMotor.get("lift");
        //relicExtender = hw.dcMotor.get("RelicExtender");

        //Initialize Servos
        //pusher = hwMap.servo.get("pusher");
        //pusher.setPosition(pusherMiddle);
        //relicRecoverer = hwMap.servo.get("RelicRecoverer");
        jewelArm = hwMap.servo.get("JewelArm");
        rightGrabber = hwMap.servo.get("Grabber_R");
        leftGrabber = hwMap.servo.get("Grabber_L");
        rightGrabber.setPosition(rightGripperMaxRight);
        leftGrabber.setPosition(leftGripperMaxLeft);
        jewelArm.setPosition(this.jewelArmStartPosition);

        //Initialize sensors
        lightSensor = hwMap.lightSensor.get("lightSensor");
        colorSensor = hwMap.colorSensor.get("colorSensor");

        //Initialize gyro and calibrate
        gyroSensor = hwMap.gyroSensor.get("gyro");

        // Set all motors to zero power
        motorFrontLeft.setPower(0);
        motorBackLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackRight.setPower(0);
        motorLift.setPower(0);

        // Set all motors to run with encoders.
        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Set all motors to brake when set to zero power.
        motorFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        jewelArm.setPosition(1.0);
    }
}
