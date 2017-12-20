package projet;

import simbad.sim.Agent;
import simbad.sim.LaserAgent;

import javax.media.j3d.Transform3D;
import javax.vecmath.Point3d;
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
    int up, left, down, right, tir;
    boolean recharge;
    LaserAgent[] munitions;
    Point3d tmp;
    Transform3D t3d;

    int numLaser;

    public Character(Vector3d position, String name, LaserAgent[] munitions, int up, int left, int down, int right, int tir)
    {
        super(position, name);
        this.pos = position;
        this.munitions = munitions;
        this.speed = BASE_SPEED;
        this.rotation = 0.0;
        this.directionBinary = new boolean[4];
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
        this.tir = tir;
        this.recharge = true;
        this.numLaser = 0;
        this.t3d = new Transform3D();
        this.tmp = new Point3d();
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
            this.setTranslationalVelocity(2);
        if (keyPressed.contains(this.tir))
            tir();
    }

    private void tir()
    {
        if (this.recharge)
        {
            this.recharge = false;
            this.getCoords(tmp);
            this.getRotationTransform(t3d);
            System.out.println("t3d = " + t3d);
            System.out.println(tmp);
            if (this.numLaser == this.munitions.length-1)
                this.numLaser = 0;
            else
                this.numLaser++;
            System.out.println(this.munitions[numLaser].getName());
            this.munitions[numLaser].tir(new Vector3d(tmp), this.rotation);

        }

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

        if (!keyPressed.contains(this.tir))
            this.recharge = true;

    }


}
