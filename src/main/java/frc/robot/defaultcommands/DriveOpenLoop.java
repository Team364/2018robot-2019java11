package frc.robot.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Apollo;

public class DriveOpenLoop extends Command {

    static enum DriveStates {
        STATE_NOT_MOVING,
        STATE_DIRECT_DRIVE, 
        STATE_RAMP_DOWN
    }

    public DriveStates driveState;
    private double steer;
    private double throttle;
    private double frontThrottle;
    private double backThrottle;
    private double leftPower;
    private double rightPower;
    private double Deadband1 = 0.25; 
    private double DeadBand2 = 0.2;

    public DriveOpenLoop() {
        requires(Apollo.driveTrain);  
    }

    @Override
    protected void initialize() {
        driveState = DriveStates.STATE_NOT_MOVING;
    }

    @Override
    protected void execute() {
        frontThrottle = Apollo.oi.controller.getRawAxis(2);
        backThrottle = Apollo.oi.controller.getRawAxis(3);
        steer = -0.7*Apollo.oi.controller.getRawAxis(0);
        if (driveState == DriveStates.STATE_NOT_MOVING) {
            throttle = 0;
            if ((Math.abs(frontThrottle) >= Deadband1) || (Math.abs(backThrottle) >= Deadband1) || (Math.abs(steer) >= Deadband1)) {
                driveState = DriveStates.STATE_DIRECT_DRIVE;
            }
        } else if (driveState == DriveStates.STATE_DIRECT_DRIVE) {
            throttle = backThrottle - frontThrottle;
            if ((Math.abs(frontThrottle) < DeadBand2) && (Math.abs(backThrottle) < DeadBand2)) {
                driveState = DriveStates.STATE_RAMP_DOWN;
            }
        } else if (driveState == DriveStates.STATE_RAMP_DOWN) {
            driveState = DriveStates.STATE_NOT_MOVING;
        } else {
            driveState = DriveStates.STATE_NOT_MOVING;
        }
        rightPower = throttle + steer;
        leftPower = throttle - steer;
        Apollo.driveTrain.openLoop(rightPower, leftPower);
    

    }

    @Override
    protected void end() {
        Apollo.driveTrain.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
