// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.time.Instant;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.CloseToCube;
import frc.robot.Commands.Open;
import frc.robot.Commands.RollersInside;
import frc.robot.Commands.RollersOutside;
import frc.robot.Subsystems.Claw;
import frc.robot.Utils.Consts;

public class RobotContainer {

  public static Joystick left = new Joystick(Consts.JoysticksConsts.LEFT_JOYSTICK);
  public static Joystick right = new Joystick(Consts.JoysticksConsts.RIGHT_JOYSTICK);
  

  private Joystick m_operator = new Joystick(Consts.JoysticksConsts.OPERATOR);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    Trigger open = new JoystickButton(m_operator, Consts.ButtonPorts.A).onTrue(new Open());
    Trigger close = new JoystickButton(m_operator, Consts.ButtonPorts.B).onTrue(new CloseToCube());
    Trigger stop = new JoystickButton(m_operator, Consts.ButtonPorts.X).onTrue(new InstantCommand(() -> {
      Claw.getIntance().stop();
    }, Claw.getIntance()));
  }

  Trigger roll = new JoystickButton(m_operator, Consts.ButtonPorts.RB).whileTrue(new RollersInside());
  Trigger rollin = new JoystickButton(m_operator, Consts.ButtonPorts.LB).whileTrue(new RollersOutside());

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
