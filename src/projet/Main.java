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

    }
}
