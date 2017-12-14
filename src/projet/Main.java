package projet;

import simbad.gui.Simbad;
import simbad.sim.LaserAgent;

import javax.vecmath.Vector3d;

public class Main
{
    public static void main(String[] args)
    {
        MyEnv myEnv = new MyEnv();
        Simbad frame = new Simbad(myEnv, false);
        myEnv.add(new LaserAgent(new Vector3d(-10,0,-10),"pew", 1.75 * Math.PI, 15 , (float)0.1));
    }
}
