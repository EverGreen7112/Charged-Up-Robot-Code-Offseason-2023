package frc.robot.Commands;
import frc.robot.Subsystems.Chassis;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Utils.Consts;
import frc.robot.Subsystems.Chassis;
public class ChassisDrive extends CommandBase {
    // Supplier<double> rightMotorSpeed = () -> rightJoystick();
    // Supplier<double> leftMotorSpeed= () -> leftJoystick();

    @Override
    public boolean isFinished() {
        return false;
    }
    private final Chassis m_chassis;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ChassisDrive(Chassis chassi) {
    m_chassis = chassi;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(chassi);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

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

