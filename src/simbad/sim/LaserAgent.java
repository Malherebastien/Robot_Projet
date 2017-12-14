package simbad.sim;

import javax.media.j3d.Appearance;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;


public class LaserAgent extends SimpleAgent
{

    Color3f color;
    float radius;

    public LaserAgent(Vector3d pos, String name, float radius)
    {
        super(pos, name);
        this.color = new Color3f(1f,0.2f,0.05f);
        this.radius = radius;
    }

    protected void create3D()
    {
        Appearance  appear = new Appearance();

        material.setDiffuseColor(color);
        material.setSpecularColor(black);
        appear.setMaterial(material);
        int flags = Primitive.GEOMETRY_NOT_SHARED | Primitive.ENABLE_GEOMETRY_PICKING | Primitive.GENERATE_NORMALS;


        body = new Sphere(radius,flags,appear);

    }
}
