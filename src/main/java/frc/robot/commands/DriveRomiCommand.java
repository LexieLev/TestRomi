// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveRomiCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain driverSubsystem;
  private XboxController xController;
  private final DoubleSupplier translationXSupplier;
  private final DoubleSupplier translationYSupplier;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveRomiCommand(RomiDrivetrain subsystem, XboxController xController, DoubleSupplier translationXSupplier, DoubleSupplier translationYSupplier) {
    this.driverSubsystem = subsystem;
    this.xController = xController;
    this.translationXSupplier = translationXSupplier;
    this.translationYSupplier = translationYSupplier;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem); 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double x = translationXSupplier.getAsDouble();
    double y = translationYSupplier.getAsDouble();
    
    driverSubsystem.Drive((xController.getLeftY()));
    driverSubsystem.Left((xController.getLeftX()));
    driverSubsystem.Right((xController.getLeftX()));
  
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
