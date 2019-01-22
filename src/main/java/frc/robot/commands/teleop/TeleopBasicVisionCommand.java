package frc.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.VisionSystem;

public class TeleopBasicVisionCommand extends Command {

    /**
     * This command ensures that values in the visionSystem are constantly updated. No vision Processing occurs here.
     */
    public TeleopBasicVisionCommand() {
        requires(Robot.visionSystem);
        //setInterruptible(true);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
       //Robot.visionSystem.processOneFrame();
        double[] myArray = Robot.visionSystem.getTargetXValues();
        System.out.print(myArray[0] + "\n");
        // double xValue = Robot.visionSystem.getTargetXValue();
        // System.out.print(xValue);
    }

    @Override
    protected boolean isFinished() {
       return false;
    }

    @Override
    protected void end() {
    }

}
