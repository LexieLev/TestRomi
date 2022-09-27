// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.simulation.JoystickSim;
import frc.robot.commands.DriveBackwardCommand;
import frc.robot.commands.DriveForwardCommand;
import frc.robot.commands.DriveLeftCommand;
import frc.robot.commands.DriveRightCommand;
import frc.robot.commands.DriveRomiCommand;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
//test
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final RomiDrivetrain m_romiDrivetrain = new RomiDrivetrain();


  private final XboxController xController = new XboxController(Constants.RobotContainer.controller0);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings

    // m_romiDrivetrain.setDefaultCommand(
    // new DriveRomiCommand(
    //   m_romiDrivetrain, xController, 
    //   () -> ((xController.getLeftY())),
    //   () -> ((xController.getLeftX()))));
      


    configureButtonBindings();
    
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    // new Button(xController::getYButton).whenHeld(new DriveRomiCommand(m_romiDrivetrain));
    // new Button(xController::getXButton).whenHeld(new DriveRomiCommand(m_romiDrivetrain));
    new Button(xController::getLeftStickButton)
    .whenPressed(new DriveRomiCommand(m_romiDrivetrain, xController));


    new Button(xController::getYButton).whenHeld((new DriveForwardCommand(m_romiDrivetrain)));
    new Button(xController::getXButton).whenHeld((new DriveLeftCommand(m_romiDrivetrain)));
    new Button(xController::getBButton).whenHeld((new DriveRightCommand(m_romiDrivetrain)));
    new Button(xController::getAButton).whenHeld((new DriveBackwardCommand(m_romiDrivetrain)));
    

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
   return null;
  }
  
}
