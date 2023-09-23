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
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Chassis.getInstance().driveTank(leftMotorSpeed.get(), rightMotorSpeed.get());
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    Chassis.getInstance().stop();
  }

}
