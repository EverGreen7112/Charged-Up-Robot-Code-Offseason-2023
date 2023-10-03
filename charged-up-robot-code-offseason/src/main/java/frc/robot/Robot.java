// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.swing.GroupLayout.SequentialGroup;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Chassis;
import frc.robot.Subsystems.Claw;
import frc.robot.Subsystems.Arm.ArmNumber;
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
    SmartDashboard.putNumber("Roll", Chassis.getInstance().getNavX().getRoll());

    SmartDashboard.putNumber("meters", Chassis.getInstance().getMeters());
    SmartDashboard.putNumber("encoder right ", Chassis.getInstance().m_rightForward.getEncoder().getPosition());
    SmartDashboard.putNumber("encoder left ", Chassis.getInstance().m_leftForward.getEncoder().getPosition());

    SmartDashboard.putBoolean("cube", !Claw.getlimitSwitchCubeBool());
    SmartDashboard.putBoolean("cone", !Claw.getlimitSwitchConeBool());
    SmartDashboard.putBoolean("open", !Claw.getlimitSwitchOpenBool());
  }

  @Override
  public void disabledInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void disabledExit() {
  }

  @Override
  public void autonomousInit() {
    Chassis.getInstance().setIdleMode(IdleMode.kBrake);

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
    Chassis.getInstance().setIdleMode(IdleMode.kCoast);
  }

  @Override
  public void teleopInit() {
    CommandScheduler.getInstance().cancelAll();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    RobotContainer.chassisDrive.schedule();
  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void teleopExit() {
    CommandScheduler.getInstance().cancelAll();
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
