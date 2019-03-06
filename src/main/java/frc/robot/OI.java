package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    public Joystick controller;
    private static OI Instance = null;

    public OI() {
        controller = new Joystick(0);
    }
    
    public synchronized static OI getInstance() {
        if (Instance == null) {
            Instance = new OI();
        }
        return Instance;
    }

}
