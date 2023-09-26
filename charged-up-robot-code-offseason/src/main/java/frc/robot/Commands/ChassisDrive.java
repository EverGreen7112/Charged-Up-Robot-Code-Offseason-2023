package frc.robot.Commands;

import frc.robot.Subsystems.Chassis;
import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ChassisDrive extends CommandBase {
  private Supplier<Double> rightMotorSpeed;
  private Supplier<Double> leftMotorSpeed;

  public ChassisDrive(Supplier<Double> leftMotorSpeed, Supplier<Double> rightMotorSpeed) {
    this.rightMotorSpeed = rightMotorSpeed;
    this.leftMotorSpeed = leftMotorSpeed;
    addRequirements(Chassis.getInstance());
    // getting supplier
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Chassis.getInstance().driveTank(leftMotorSpeed.get(), rightMotorSpeed.get());
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    Chassis.getInstance().stop();
  }

}
