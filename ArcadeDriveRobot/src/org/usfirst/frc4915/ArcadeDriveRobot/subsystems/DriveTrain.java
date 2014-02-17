// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4915.ArcadeDriveRobot.subsystems;
import org.usfirst.frc4915.ArcadeDriveRobot.RobotMap;
import org.usfirst.frc4915.ArcadeDriveRobot.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4915.ArcadeDriveRobot.Robot;
/**
 *
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftMotor = RobotMap.driveTrainLeftMotor;
    SpeedController rightMotor = RobotMap.driveTrainRightMotor;
    RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public double joystickThrottle;
    private double modifiedThrottle;
    // Whether robot is turning or not
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new ArcadeDrive());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    /**
     * arcadeDrive
     *
     * Public method to enable arcade drive using a joystick. v 1.03.01
     *
     * @param stick A joystick.
     */
    public void arcadeDrive(Joystick stick) {
        robotDrive.arcadeDrive(stick);
    }
    /**
     * driveStraight
     *
     * Public method to drive straight at speed v 1.03.01
     *
     * @param speed Motor speed. Value should be between -1 and 1
     */
    public void driveStraight(double speed) {
        robotDrive.tankDrive(speed, speed);
    }
    public void drive(double speed, double angle) {
        robotDrive.drive(speed, angle);
    }
    /**
     * stop
     *
     * public method to stop the drive train v 1.03.01
     */
    public void stop() {
        robotDrive.tankDrive(0, 0);
    }
    /* turn
     *
     * Turns robot
     */
    public void turn() {
        robotDrive.tankDrive(1.0, -1.0);
    }
    public double modifyThrottle() {
        modifiedThrottle = 0.40 * (-1.0 * Robot.oi.joystickDrive.getAxis(Joystick.AxisType.kThrottle)) + 0.60;
        if (modifiedThrottle != joystickThrottle) {
            SmartDashboard.putNumber("Throttle: ", modifiedThrottle);
        }
        setMaxOutput(modifiedThrottle);
        return modifiedThrottle;
    }
    public void setMaxOutput(double topSpeed) {
        robotDrive.setMaxOutput(topSpeed);
    }
    public void setSafetyEnabled(boolean safety) {
        robotDrive.setSafetyEnabled(safety);
    }
    // Modifiers to scale the PID control.
    // turnPID will not be used
    private static final double PROPORTIONAL_RATIO = .02;
    private static final double INTEGRAL_RATIO = .00002;
    private static final double DERIVATIVE_RATIO = .05;
    private double error; //The difference between the desired angle (the setpoint) and the current angle
    private double lastError; // The previous error. Must be reset to 0 before begining the turning process.
    private double proportional, integral, derivative; // These will sum to how fast the motors should spin
    private static final double MOTOR_MAX_SPEED = 1;
    /**
     * turnPID(double angle)
     *
     * Turns the robot angle degrees using a PID algorithm.
     *
     * @param angle: The angle in degrees that the gyroscope should read at the
     * end of the turn. For fastest results, make it between -180 and 180.
     * @return true when the setpoint has been reached.
     *
     * Prerequisites: Must have the gyroscope reset before usage. TIP: Call
     * DriveTrain.resetPIDValues() in the initiate method of the turning command
     * using this code.
     */
    public boolean turnPID(double angle) {
        if (Robot.gyroscope == null) {
            robotDrive.tankDrive(0, 0);
            System.out.println("Gyroscope not connected");
            return true; // This way the command will exit rather than runs forever
        }
        // Calculate the current error
        error = angle - Robot.gyroscope.getAngle();
        // Calculate proportional, integral and derivative components
        proportional = PROPORTIONAL_RATIO * error;
        integral += INTEGRAL_RATIO * error;
        derivative = DERIVATIVE_RATIO * (lastError - error);
        // Sum the components to determine the driving speed
        double motorSpeed = proportional + integral + derivative;
        // Ensure that the driving speed isn't too fast.
        if (motorSpeed > MOTOR_MAX_SPEED) {
            motorSpeed = MOTOR_MAX_SPEED;
        }
        if (motorSpeed < -MOTOR_MAX_SPEED) {
            motorSpeed = -MOTOR_MAX_SPEED;
        }
        if (Math.abs(error) < 5) { //If we are within 5 degrees of our result, it should stop.
            robotDrive.tankDrive(0, 0);
            return true;
        }
        // Drive at the outputed speed.
        robotDrive.tankDrive(motorSpeed, -motorSpeed);
        lastError = error;
        return false; // The command will be called again by its command.
    }
    public void resetPIDValues() {
        error = 0;
        lastError = 0;
        proportional = 0;
        integral = 0;
        derivative = 0;
        if (Robot.gyroscope != null) {
            Robot.gyroscope.reset();
        }
    }
}
