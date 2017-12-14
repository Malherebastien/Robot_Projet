package projet;

import simbad.sim.Agent;
import simbad.sim.LaserAgent;

import javax.vecmath.Vector3d;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Character extends Agent
{
    final double BASE_SPEED = 0.1;
    double x, y;
    double speed;
    ArrayList<LaserAgent> al;
    Audio audi;

    public Character(Vector3d position, String name)
    {
        super(position, name);
        this.x = 0.0;
        this.y = 0.0;
        this.speed = BASE_SPEED;
    }

    public void initBehavior()
    {
        al = new ArrayList<>();
    }

    public void performBehavior()
    {
        // avance à 0.5 m/s
        // setTranslationalVelocity(0.5);

        // changer l'angle fréquemment
        // setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random()));

    }

    public void action(int keyCode)
    {
        if (keyCode == KeyEvent.VK_Z || keyCode == KeyEvent.VK_UP)
        {
            audi = new Audio("songFile/pasDepHumain.waw");
            audi.jouer();
            this.setTranslationalVelocity(2);

        }

        if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT)
        {
            this.setRotationalVelocity(Math.PI);
        }

        if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN)
        {
            this.setTranslationalVelocity(-2);
            audi = new Audio("songFile/pasDepHumain.waw");
            audi.jouer();
        }

        if (keyCode == KeyEvent.VK_Q || keyCode == KeyEvent.VK_LEFT)
        {
            this.setRotationalVelocity(-Math.PI);
        }


        /*if (keyCode == KeyEvent.VK_Z || keyCode == KeyEvent.VK_UP)
            this.moveToPosition(x -= speed, y);
        if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT)
            this.moveToPosition(x, y -= speed);
        if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN)
            this.moveToPosition(x += speed, y);
        if (keyCode == KeyEvent.VK_Q || keyCode == KeyEvent.VK_LEFT)
            this.moveToPosition(x, y += speed);*/


    }

    public void finAction(int keyCode)
    {
        if (keyCode == KeyEvent.VK_Z || keyCode == KeyEvent.VK_UP)
        {
            this.setTranslationalVelocity(0);
            audi.arreter();
        }

        if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT)
            this.setRotationalVelocity(0);

        if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN)
        {
            this.setTranslationalVelocity(0);
            audi.arreter();
        }

        if (keyCode == KeyEvent.VK_Q || keyCode == KeyEvent.VK_LEFT)
            this.setRotationalVelocity(0);
    }


}
