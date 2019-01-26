/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    // "defines" motors
    private Talon leftFront;
    private Talon leftBack;
    private Talon rightFront;
    private Talon rightBack;
    private DifferentialDrive DR;

    private SpeedControllerGroup right;
    private SpeedControllerGroup left;



    public DriveTrain() {
        // initializes motors
        leftFront = new Talon(RobotMap.leftFront);
        leftBack = new Talon(RobotMap.leftBack);
        rightFront = new Talon(RobotMap.rightFront);
        rightBack = new Talon(RobotMap.rightBack);

        left = new SpeedControllerGroup(leftFront, leftBack);
        right = new SpeedControllerGroup(rightFront, rightBack);

        DR = new DifferentialDrive(left, right );
    }

    /**
     * Drive in teleop.
     */
    public void drive(double x, double twist) {

        System.out.println("Twist:     " + twist + "Forward:     " + x);
        DR.curvatureDrive(x, twist, true);
    }

    public void stop() {
        DR.curvatureDrive(0, 0, false);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Drive());
    }
}
