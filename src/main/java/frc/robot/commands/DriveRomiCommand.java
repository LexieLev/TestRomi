// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;


import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Button;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveRomiCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain driverSubsystem;
  private XboxController xController;
  

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveRomiCommand(RomiDrivetrain subsystem, XboxController xController) {
    this.driverSubsystem = subsystem;
    this.xController = xController;
    

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem); 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if (xController.getLeftX()>-0.5 && xController.getLeftX()<0.5 && xController.getLeftY()>-0.5 && xController.getLeftY()<0.5){
      driverSubsystem.Drive(0);
      driverSubsystem.Left(0, 0);
      driverSubsystem.Right(0, 0);
   
    } else if (xController.getLeftX()>-0.5 && xController.getLeftX()<0.5 ){

    driverSubsystem.Drive((xController.getLeftY()));
    
    } else if (xController.getLeftX()<-0.5){

    driverSubsystem.Left((xController.getLeftX()), xController.getLeftY());
    } else if (xController.getLeftX()>0.5) {

    driverSubsystem.Right((xController.getLeftX()), xController.getLeftY());
    }
  
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
