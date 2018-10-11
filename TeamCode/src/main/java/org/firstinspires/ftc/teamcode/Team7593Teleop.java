package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import java.util.ArrayList;

@TeleOp (name = "TeleOp")
public class Team7593Teleop extends Team7593Opmode {

    //Declare Variables
    public ElapsedTime time = new ElapsedTime(); //a timer

    Orientation angles;

    @Override
    //code block to that will run at the beginning of Teleop
    public ArrayList<AutonStep> createAutonSteps() {
        return null;
    }

    @Override
    public void init(){
        telemetry.addData("Say", "HELLO FROM THE OTHER SIIIIIDE");

        time.startTime();
    }

    public void loop() {

        //use super's loop so that auton steps can run
        super.loop();

        double leftX, rightX, leftY, rightY; //for the game sticks
        WheelSpeeds speeds = new WheelSpeeds(); //variable to hold speeds

        leftX = gamepad1.left_stick_x;
        rightX = gamepad1.right_stick_x;
        leftY = gamepad1.left_stick_y;
        rightY = gamepad1.right_stick_y;

        //get the speeds
        speeds = WheelSpeeds.mecanumDrive(leftX, leftY, rightX);

        //power the motors
        robot.powerTheWheels(speeds);
        robot.hangMotor.setPower(rightY);
    }
}
