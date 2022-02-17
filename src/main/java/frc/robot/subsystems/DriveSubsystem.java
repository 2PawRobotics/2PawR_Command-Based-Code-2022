// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.RobotContainer;


public class DriveSubsystem extends SubsystemBase {
 
  private final CANSparkMax leftCim1 = new CANSparkMax(Constants.leftCimPort1, MotorType.kBrushed);
  private final CANSparkMax leftCim2 = new CANSparkMax(Constants.leftCimPort2, MotorType.kBrushed);
  private final CANSparkMax rightCim1 = new CANSparkMax(Constants.rightCimPort1, MotorType.kBrushed);
  private final CANSparkMax rightCim2 = new CANSparkMax(Constants.rightCimPort2, MotorType.kBrushed);

  private final SpeedControllerGroup leftCims = new SpeedControllerGroup(leftCim1, leftCim2);
  private final SpeedControllerGroup rightCims = new SpeedControllerGroup(rightCim1, rightCim2);

  private final DifferentialDrive arcadeDrive = new DifferentialDrive(leftCims, rightCims);

//  public final static XboxController xCont = new XboxController(Constants.XContPort);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void ArcadeDrive(XboxController controller, double speedx, double speedy){
    arcadeDrive.arcadeDrive(RobotContainer.XCont.getY(Hand.kLeft)*speedy, RobotContainer.XCont.getX(Hand.kRight)*speedx);

  }
}
