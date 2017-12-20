package projet;

import simbad.sim.*;

import javax.vecmath.Vector3d;
import java.awt.event.KeyEvent;

public class MyEnv extends EnvironmentDescription
{
    public MyEnv()
    {
        LaserAgent[] mun1 = {new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1)};

        LaserAgent[] mun2 = {new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1),
                new LaserAgent(new Vector3d(-100,0,-100),"pew", (float)0.1)};

        add(new Character(new Vector3d(0,0,0), "mon robot", mun1,  KeyEvent.VK_Z , KeyEvent.VK_Q   , KeyEvent.VK_S   , KeyEvent.VK_D, KeyEvent.VK_SPACE));
        add(new Character(new Vector3d(3,0,3), "robot 2"  , mun2, KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_BACK_SPACE));

        for (LaserAgent la : mun1)
            add(la);

        for (LaserAgent la : mun2)
            add(la);
    }
}