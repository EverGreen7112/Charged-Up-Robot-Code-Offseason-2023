// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.Arm.MoveBothArms;
import frc.robot.Commands.Chassis.Balance;
import frc.robot.Commands.Chassis.ChassisDrive;
import frc.robot.Commands.Claw.CloseToCone;
import frc.robot.Commands.Claw.CloseToCube;
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

  public static Balance balance = new Balance();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    // Trigger open = new JoystickButton(m_operator,
    // Consts.ButtonPorts.A).whileTrue(new InstantCommand(() -> {
    // Claw.getIntance().open();
    // }));

    // Trigger close = new JoystickButton(m_operator,
    // Consts.ButtonPorts.B).whileTrue(new InstantCommand(() -> {
    // Claw.getIntance().close();
    // }));

    // Trigger stop = new JoystickButton(m_operator,
    // Consts.ButtonPorts.X).onTrue(new InstantCommand(() -> {
    // Claw.getIntance().stop();
    // }, Claw.getIntance()));

    Trigger open = new JoystickButton(m_operator, Consts.ButtonPorts.B).onTrue(new Open());
    Trigger closeToCube = new JoystickButton(m_operator, Consts.ButtonPorts.X).onTrue(new CloseToCube());
    Trigger closeToCone = new JoystickButton(m_operator, Consts.ButtonPorts.Y).onTrue(new CloseToCone());

    Trigger rollIn = new JoystickButton(m_operator, Consts.ButtonPorts.RB).whileTrue(new RollersInside());
    Trigger rollOut = new JoystickButton(m_operator, Consts.ButtonPorts.LB).whileTrue(new RollersOutside());
    Trigger holdGamePiece = new JoystickButton(m_operator, Consts.ButtonPorts.A).whileTrue(new HoldGamePiece());

    Trigger left = new JoystickButton(m_operator, Consts.ButtonPorts.LT).onTrue(new MoveBothArms(-90, 180));
    Trigger right = new JoystickButton(m_operator, Consts.ButtonPorts.RT).onTrue(new MoveBothArms(90, -90));
    Trigger zero = new JoystickButton(m_operator, Consts.ButtonPorts.START).onTrue(new MoveBothArms(0, 0));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
