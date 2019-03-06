package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;
public class Apollo extends TimedRobot {

  public static DriveTrain driveTrain = DriveTrain.getInstance();
  public static OI oi = OI.getInstance();

  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    Scheduler.getInstance().removeAll();
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }
  @Override
  public void teleopInit() {
      Scheduler.getInstance().removeAll();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }

}
