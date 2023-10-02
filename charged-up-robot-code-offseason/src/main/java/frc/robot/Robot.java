// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Chassis;
import frc.robot.Subsystems.Claw;
import frc.robot.Subsystems.Arm.ArmNumber;
import frc.robot.Utils.KeyboardReader;
import frc.robot.Commands.Arm.MoveArmByAngle;
import frc.robot.Commands.Arm.MoveBothArms;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    Claw.getIntance();
    Chassis.getInstance();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("first angle", Arm.getInstance().getFirstAngle());
    SmartDashboard.putNumber("second angle", Arm.getInstance().getSecondAngle());

    SmartDashboard.putBoolean("open", !Claw.getlimitSwitchOpenBool());
    SmartDashboard.putBoolean("close to cone", !Claw.getlimitSwitchConeBool());
    SmartDashboard.putBoolean("close to cube", !Claw.getlimitSwitchCubeBool());
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void disabledExit() {
  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void autonomousExit() {
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    // drive with joysticks
    RobotContainer.chassisDrive.schedule();

    ;
  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void teleopExit() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void testExit() {
  }
}
