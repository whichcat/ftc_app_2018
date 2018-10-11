package org.firstinspires.ftc.teamcode;

/**
 * Created by vineelavandanapu on 11/26/17.
 *
 * i love this class so much ahhhhhhhhhhhh
 *
 * instead having to copy and paste the mecanum wheel formula constantly we can use thissssssss
 */

public class WheelSpeeds {

    double v_lf; //variable that sets the left front wheel power
    double v_lr; //variable that sets the left rear wheel power
    double v_rf; //variable that sets the right front wheel power
    double v_rr; //variable that sets the right rear wheel power

    public static WheelSpeeds mecanumDrive(double leftX, double leftY, double rightX){

        WheelSpeeds wheelSpeeds = new WheelSpeeds();

        //declare some necessary variables
        double desiredSpeed = Math.sqrt(leftX * leftX + leftY * leftY); //using pythagoras theorem to find the speed vector
        double direction; //direction (in radians)
        double rotationSpeed = rightX; //make rotation use rightX

        //a whole bunch of if conditions to satisfy the different cases for the direction
        if (leftX != 0) {
            if (leftY == 0) {
                if (leftX > 0) direction = Math.PI / 2;
                else direction = -Math.PI / 2;
            } else {
                direction = Math.atan(leftY / leftX) + Math.PI / 2;
                // atan has a cycle of 180.  We are using the value of X to make sure we are strafe-ing correctly.
                if (leftX < 0){
                    direction = direction + Math.PI;
                }
            }
        } else {
            if (leftY > 0) {
                direction = 0;
            } else if (leftY < 0) {
                direction = Math.PI;
            } else {
                direction = 0;
            }
            // Our motors are mounted the other way.  Apply the correction to reverse the direction.
            direction = direction + Math.PI;
        }

        //mecanum wheel formulas
        wheelSpeeds.v_lf = -(desiredSpeed * Math.sin(direction + Math.PI / 4) + rotationSpeed);
        wheelSpeeds.v_rf = (desiredSpeed * Math.cos(direction + Math.PI / 4) - rotationSpeed);
        wheelSpeeds.v_lr = -(desiredSpeed * Math.cos(direction + Math.PI / 4) + rotationSpeed);
        wheelSpeeds.v_rr = (desiredSpeed * Math.sin(direction + Math.PI / 4) - rotationSpeed);

        return wheelSpeeds;
    }
}
