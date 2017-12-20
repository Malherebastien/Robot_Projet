package projet;

import simbad.sim.Agent;
import simbad.sim.LaserAgent;

import javax.vecmath.Vector3d;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;

import static java.lang.Thread.sleep;

public class Character extends Agent
{
    final double BASE_SPEED = 0.1;
    Vector3d pos;
    double speed;
    double rotation;
    boolean directionBinary[];
    int up, left, down, right;

    public Character(Vector3d position, String name, int up, int left, int down, int right)
    {
        super(position, name);
        this.pos = position;
        this.speed = BASE_SPEED;
        this.rotation = 0.0;
        this.directionBinary = new boolean[4];
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
    }

    public void initBehavior()
    {

    }

    public void performBehavior()
    {
        if (this.directionBinary[0] && this.directionBinary[1]) //ZD
            rotate(0.75 * Math.PI);
        else if (this.directionBinary[0] && this.directionBinary[3]) // ZQ
            rotate(1.25 * Math.PI);
        else if (this.directionBinary[2] && this.directionBinary[1]) // SD
            rotate(0.25 * Math.PI);
        else if (this.directionBinary[2] && this.directionBinary[3]) // SQ
            rotate(1.75 * Math.PI);
        else if (this.directionBinary[0]) // Z
            rotate(Math.PI);
        else if (this.directionBinary[1]) // D
            rotate(0.5 * Math.PI);
        else if (this.directionBinary[2]) // S
            rotate(2 * Math.PI);
        else if (this.directionBinary[3]) // Q
            rotate(1.5 * Math.PI);
    }

    public void action(Set<Integer> keyPressed)
    {
        if (keyPressed.contains(this.up))
            if (!this.directionBinary[0])
                this.directionBinary[0] = true;
        if (keyPressed.contains(this.right))
            if (!this.directionBinary[1])
                this.directionBinary[1] = true;
        if (keyPressed.contains(this.down))
            if (!this.directionBinary[2])
                this.directionBinary[2] = true;
        if (keyPressed.contains(this.left))
            if (!this.directionBinary[3])
                this.directionBinary[3] = true;
        if (this.directionBinary[0] || this.directionBinary[1] || this.directionBinary[2] || this.directionBinary[3])
            this.setTranslationalVelocity(4);
    }

    private void rotate(double angle)
    {
        while (this.rotation != angle)
        {
            if (this.rotation == Math.PI*2)
                this.rotation = 0;
            this.rotation += Math.PI/4;
            this.rotateY(Math.PI/4);
        }
    }

    public void finAction(Set<Integer> keyPressed)
    {
        if (!keyPressed.contains(this.up))
            if (this.directionBinary[0])
                this.directionBinary[0] = false;
        if (!keyPressed.contains(this.right))
            if (this.directionBinary[1])
                this.directionBinary[1] = false;
        if (!keyPressed.contains(this.down))
            if (this.directionBinary[2])
                this.directionBinary[2] = false;
        if (!keyPressed.contains(this.left))
            if (this.directionBinary[3])
                this.directionBinary[3] = false;
        if (!this.directionBinary[0] && !this.directionBinary[1] && !this.directionBinary[2] && !this.directionBinary[3])
            this.setTranslationalVelocity(0);

    }


}
