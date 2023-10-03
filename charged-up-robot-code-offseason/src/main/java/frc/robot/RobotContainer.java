// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.Arm.MoveBothArms;
import frc.robot.Commands.Chassis.Balance;
import frc.robot.Commands.Chassis.ChassisDrive;
import frc.robot.Commands.Chassis.old.DriveDistanceByEncoders;
import frc.robot.Commands.Chassis.old.OldBalance;
import frc.robot.Commands.Chassis.old.OldDriveUntilIsTilted;
import frc.robot.Commands.Claw.CloseToCone;
import frc.robot.Commands.Claw.OpenToCube;
import frc.robot.Commands.Claw.HoldGamePiece;
import frc.robot.Commands.Claw.Open;
import frc.robot.Commands.Claw.RollersInside;
import frc.robot.Commands.Claw.RollersOutside;
import frc.robot.Subsystems.Claw;
import frc.robot.Utils.Consts;

public class RobotContainer {

  public static Joystick left = new Joystick(Consts.JoysticksConsts.LEFT_JOYSTICK);
  public static Joystick right = new Joystick(Consts.JoysticksConsts.RIGHT_JOYSTICK);

  private Joystick m_operator = new Joystick(Consts.JoysticksConsts.OPERATOR);

  public static ChassisDrive chassisDrive = new ChassisDrive(() -> {
    return left.getY() * -1;
  },
      () -> {
        return right.getY() * -1;
      });

  public static DriveDistanceByEncoders driveMeters = new DriveDistanceByEncoders(1, 0.1);

  // only balance
  public static SequentialCommandGroup balance = new SequentialCommandGroup(new OldDriveUntilIsTilted(-1),
      new OldBalance());
  // throw cube and balance
  public static SequentialCommandGroup throwAndBalance = new SequentialCommandGroup(
      new MoveBothArms(-32, -46).withTimeout(2),
      new ParallelCommandGroup(new RollersOutside(Consts.ClawConsts.ROLLERS_HIGH_AUTO), new MoveBothArms(-32, -46))
          .withTimeout(0.5),
      new ParallelCommandGroup(new CloseToCone(), new MoveBothArms(0, 0).withTimeout(1)), new OldDriveUntilIsTilted(-1),
      new OldBalance());

  public static SequentialCommandGroup throwDriveAndPickUp = new SequentialCommandGroup(
      new MoveBothArms(32, 46).withTimeout(2),
      new ParallelCommandGroup(new RollersOutside(Consts.ClawConsts.ROLLERS_HIGH_AUTO), new MoveBothArms(32, 46))
          .withTimeout(0.5),
      new ParallelCommandGroup(new CloseToCone(), new MoveBothArms(0, 0).withTimeout(1)),
      new MoveBothArms(-7, -125),
      new OpenToCube(),
      new DriveDistanceByEncoders(5, 0.05),
      new RollersInside().withTimeout(1), new HoldGamePiece());

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    Trigger openToCube = new JoystickButton(m_operator, Consts.ButtonPorts.X).onTrue(new OpenToCube());
    Trigger closeToCone = new JoystickButton(m_operator, Consts.ButtonPorts.Y).onTrue(new CloseToCone());

    Trigger rollIn = new JoystickButton(m_operator, Consts.ButtonPorts.RB).whileTrue(new RollersInside());
    Trigger rollOut = new JoystickButton(m_operator, Consts.ButtonPorts.LB)
        .whileTrue(new RollersOutside(Consts.ClawConsts.ROLLERS_HIGH_AUTO));
    Trigger holdGamePiece = new JoystickButton(m_operator, Consts.ButtonPorts.A).whileTrue(new HoldGamePiece());

    Trigger highThrow = new JoystickButton(m_operator, Consts.ButtonPorts.LT).onTrue(new MoveBothArms(-32, -46));
    Trigger midThrow = new JoystickButton(m_operator, Consts.ButtonPorts.BACK).onTrue(new MoveBothArms(0, -30));
    Trigger zero = new JoystickButton(m_operator, Consts.ButtonPorts.START).onTrue(new MoveBothArms(0, 0));
    Trigger pickupShelf = new JoystickButton(m_operator, Consts.ButtonPorts.RT).onTrue(new MoveBothArms(-90, -195));
    Trigger pickupFloor = new JoystickButton(m_operator, Consts.ButtonPorts.B).onTrue(new MoveBothArms(-14, -105));

  }

  public Command getAutonomousCommand() {
    return RobotContainer.throwAndBalance;
  }
}
