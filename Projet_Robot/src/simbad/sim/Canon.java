package simbad.sim;

import javax.vecmath.Vector3d;
import java.util.ArrayList;

public class Canon extends Agent
{
    private ArrayList<LaserAgent> al;
    private int randomPosition;
    private Vector3d laserPosition;
    private double angle;

    public Canon(Vector3d position, String name)
    {
        super(position, name);
        al = new ArrayList<>();
    }

    @Override
    protected void initBehavior()
    {

    }

    protected void performBehavior()
    {
        randomPosition =(int) Math.random()*4;

        if (randomPosition == 0) // Nord
        {
            laserPosition = new Vector3d(10, 0, Math.random()*(10-(-10))-10);

            angle = Math.random() * (0.25 + 1.75)- 1.75;
            angle *= Math.PI;
        }

        al.add(new LaserAgent(laserPosition, "pew", angle, 15, (float)0.1));
    }
}
