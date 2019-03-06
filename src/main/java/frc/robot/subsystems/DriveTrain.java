package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.defaultcommands.DriveOpenLoop;


public class DriveTrain extends Subsystem {

    private VictorSP leftFront;
    private VictorSP leftRear;
    private VictorSP rightFront;
    private VictorSP rightRear;
    private static DriveTrain Instance = null;

    public DriveTrain() {
        leftFront = new VictorSP(RobotMap.leftFrontDrive);
        leftRear = new VictorSP(RobotMap.leftRearDrive);
        rightFront = new VictorSP(RobotMap.rightFrontDrive);
        rightRear = new VictorSP(RobotMap.rightRearDrive);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveOpenLoop());
    }

    public synchronized static DriveTrain getInstance() {
        if (Instance == null) {
            Instance = new DriveTrain();
        }
        return Instance;
    }
    public void openLoop(double left, double right) {
        leftFront.set(-left*0.85);
        leftRear.set(-left*0.85);
        rightFront.set(-right);
        rightRear.set(-right);
    }
    public void stop() {
        leftFront.set(0);
        leftRear.set(0);
        rightFront.set(0);
        rightRear.set(0);
    }



}
