package projet;

import simbad.sim.*;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;
import java.awt.event.KeyEvent;

public class MyEnv extends EnvironmentDescription
{
    public MyEnv()
    {


        Wall w1 = new Wall(new Vector3d(9, 0, 0), 19, 2, this);
        w1.rotate90(1);
        add(w1);
        Wall w2 = new Wall(new Vector3d(-9, 0, 0), 19, 2, this);
        w2.rotate90(1);
        add(w2);
        Wall w3 = new Wall(new Vector3d(0, 0, 9), 19, 2, this);
        add(w3);
        Wall w4 = new Wall(new Vector3d(0, 0, -9), 19, 2, this);
        add(w4);
        add(new Character(new Vector3d(0,0,0), "mon robot", KeyEvent.VK_Z , KeyEvent.VK_Q   , KeyEvent.VK_S   , KeyEvent.VK_D));
        add(new Character(new Vector3d(3,0,3), "robot 2"  , KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT));

        Box b1 = new Box(new Vector3d(9,0, 0), new Vector3f(1, 3, 5),this);
        add(b1);

        Box b2 = new Box(new Vector3d(-9, 0, 0), new Vector3f(1, 3, 5),this);
        add(b2);

        /*Box b3 = new Box(new Vector3d(0, 0, 9), new Vector3f(19, 2, 1),this);
        add(b3);

        Box b4 = new Box(new Vector3d(0, 0, -9), new Vector3f(19, 2, 1),this);
        add(b4);*/


        add( new BallAgent( new Vector3d (1   ,0   ,1   ), "bouboule",
                new Color3f  (0.7f,0.9f,0.8f), 0.5f, 0.25f ) );

        setUsePhysics(true);
    }
}