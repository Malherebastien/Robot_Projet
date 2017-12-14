package simbad.sim;

import javax.media.j3d.Appearance;

import javax.media.j3d.BoundingSphere;
import javax.media.j3d.Bounds;
import javax.media.j3d.Node;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;

public class LaserAgent extends Agent
{
    Vector3d step;
    Vector3d basePosition;
    Color3f color;
    float radius;
    double angle;
    long speed;
    double rotation;

    public LaserAgent(Vector3d pos, String name, double angle, long speed, float radius)
    {
        super(pos, name);
        this.basePosition = pos;
        this.color = new Color3f(1f,0.2f,0.05f);
        this.angle = angle;
        this.speed = speed;
        this.radius = radius;
        this.rotation = 0;
    }

    protected void create3D()
    {
        Appearance  appear = new Appearance();

        material.setDiffuseColor(color);
        material.setSpecularColor(black);
        appear.setMaterial(material);
        int flags = Primitive.GEOMETRY_NOT_SHARED | Primitive.ENABLE_GEOMETRY_PICKING | Primitive.GENERATE_NORMALS;


        body = new Sphere(radius,flags,appear);

        // we must be able to change the pick flag of the agent
        body.setCapability(Node.ALLOW_PICKABLE_READ);
        body.setCapability(Node.ALLOW_PICKABLE_WRITE);
        body.setPickable(true);
        body.setCollidable(true);
        addChild(body);

        // Add bounds for interactions
        Bounds bounds = new BoundingSphere(new Point3d(0,0,0),radius);
        setBounds(bounds);
    }

    public void initBehavior()
    {
        rotate(angle);
    }

    public void performBehavior()
    {
        this.setTranslationalVelocity(speed);
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
}
