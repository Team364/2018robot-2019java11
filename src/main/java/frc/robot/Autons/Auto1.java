package frc.robot.Autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.commands.auto.drive.*;

/**
 * Auto file - Objective - DriveStraight
 */
public class Auto1 extends CommandGroup {
    /**
     * Objective - Cross the line
     *<p>1 Drive Foward
     */
    public Auto1() {
       
        addSequential(new DriveForPower(0.6, 2)); //1
        addSequential(new StopDriveMotors());
        addSequential(new TurnToHeadingL(-90));
        addSequential(new StopDriveMotors());
        addSequential(new WaitCommand(0.2));

        addSequential(new DriveForPower(0.6, 2)); //1
        addSequential(new StopDriveMotors());
        addSequential(new TurnToHeadingL(90));
        addSequential(new StopDriveMotors());
        addSequential(new WaitCommand(0.2));

        addSequential(new WaitCommand(30));

    
    }
}