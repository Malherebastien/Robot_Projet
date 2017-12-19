package projet;

import simbad.sim.*;

import javax.vecmath.Vector3d;
import java.awt.event.KeyEvent;

public class MyEnv extends EnvironmentDescription
{
    public MyEnv()
    {
        add(new Character(new Vector3d(0,0,0), "mon robot", KeyEvent.VK_Z , KeyEvent.VK_Q   , KeyEvent.VK_S   , KeyEvent.VK_D));
        add(new Character(new Vector3d(3,0,3), "robot 2"  , KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT));

    }
}