// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4915.ArcadeDriveRobot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static SpeedController driveTrainLeftMotor;
    public static SpeedController driveTrainRightMotor;
    public static RobotDrive driveTrainRobotDrive;
    public static DoubleSolenoid harvesterPneumaticAnglers;
    public static SpeedController harvesterCollectionWheels;
    public static DigitalInput harvesterMagneticSwitchBottom;
    public static DigitalInput harvesterMagneticSwitchTop;
    public static Compressor airCompressorCompressor;
    public static SpeedController launcherWindingMotor;
    public static DoubleSolenoid launcherPneumaticPistonDoubleSolenoid;
    public static DigitalInput launcherLimitSwitchForLauncherDown;
    public static Gyro gyroscopeSensor;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftMotor = new Victor(1, 1);
        LiveWindow.addActuator("Drive Train", "Left Motor", (Victor) driveTrainLeftMotor);

        driveTrainRightMotor = new Victor(1, 2);
        LiveWindow.addActuator("Drive Train", "Right Motor", (Victor) driveTrainRightMotor);

        driveTrainRobotDrive = new RobotDrive(driveTrainLeftMotor, driveTrainRightMotor);

        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        harvesterPneumaticAnglers = new DoubleSolenoid(1, 1, 2);


        harvesterCollectionWheels = new Talon(1, 4);
        LiveWindow.addActuator("Harvester", "Collection Wheels", (Talon) harvesterCollectionWheels);
        
        harvesterMagneticSwitchBottom = new DigitalInput(1, 3);
        LiveWindow.addSensor("Harvester", "Magnetic Switch Bottom", harvesterMagneticSwitchBottom);

        harvesterMagneticSwitchTop = new DigitalInput(1, 4);
        LiveWindow.addSensor("Harvester", "Magnetic Switch Top", harvesterMagneticSwitchTop);

        
        airCompressorCompressor = new Compressor(1, 1, 1, 1);

        
        launcherWindingMotor = new Talon(1, 6);
        LiveWindow.addActuator("Launcher", "Winding Motor", (Talon) launcherWindingMotor);

        launcherPneumaticPistonDoubleSolenoid = new DoubleSolenoid(1, 3, 4);

        launcherLimitSwitchForLauncherDown = new DigitalInput(1, 5);
        LiveWindow.addSensor("Launcher", "Limit Switch For Launcher Down", launcherLimitSwitchForLauncherDown);

        
        gyroscopeSensor = new Gyro(1, 1);
        LiveWindow.addSensor("Gyroscope", "Sensor", gyroscopeSensor);
        gyroscopeSensor.setSensitivity(0.007);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        ((Talon) harvesterCollectionWheels).setSafetyEnabled(true);
        ((Talon) launcherWindingMotor).setSafetyEnabled(true);
        
        ((Talon) harvesterCollectionWheels).setExpiration(0.1);
        ((Talon) launcherWindingMotor).setExpiration(0.1);
    }
}
