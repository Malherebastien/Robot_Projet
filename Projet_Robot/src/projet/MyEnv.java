package projet;

import simbad.sim.EnvironmentDescription;

import javax.vecmath.Vector3d;

public class MyEnv extends EnvironmentDescription
{
    public MyEnv()
    {
        add(new Character(new Vector3d(0,0,0), "mon robot"));
        Audio audi = new Audio("songFile/SuperHexagonFocusOST.waw");
        audi.jouerEnBoucle();
    }
}
