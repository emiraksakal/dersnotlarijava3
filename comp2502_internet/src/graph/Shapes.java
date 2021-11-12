
package graph;

import java.util.*;
import java.awt.*;

public abstract class Shapes
{


    public abstract void draw(java.util.List list, Graphics g);

}
class RectangleShape extends Shapes
{
    Point sPoint = null;
    Point ePoint = null;
    public void draw(java.util.List list, Graphics g)
    {
        Iterator it = list.iterator();

        if(list.size()<2)
        {
            return;
        }
        sPoint = (Point)it.next();
        ePoint = (Point)it.next();
        if(sPoint == null || ePoint == null)
        {
            return;
        }
        else
        {
            g.setColor(Color.red);
            g.fillRect((int)sPoint.getX(), (int)sPoint.getY(), (int)(ePoint.getX()-sPoint.getX()),
                    (int)(ePoint.getY()-sPoint.getY()));
        }
        list.clear();
    }
}
class OvalShape extends Shapes
{
    Point sPoint = null;
    Point ePoint = null;
    public void draw(java.util.List list, Graphics g)
    {
        Iterator it = list.iterator();

        if(list.size()<2)
        {
            return;
        }
        sPoint = (Point)it.next();
        ePoint = (Point)it.next();
        if(sPoint == null || ePoint == null)
        {
            return;
        }
        else
        {
            g.setColor(Color.ORANGE);
            g.fillOval((int)sPoint.getX(), (int)sPoint.getY(), (int)(ePoint.getX()-sPoint.getX()),
                    (int)(ePoint.getY()-sPoint.getY()));
        }
        list.clear();
    }
}
class TriangleShape extends Shapes
{
    public void draw(java.util.List list, Graphics g)
    {
        Point point = null;
        Iterator it = list.iterator();

        if(list.size()<3)
        {
            return;
        }
        Polygon p = new Polygon();
        for(int i = 0; i < 3; i++)
        {
            point = (Point)it.next();
            p.addPoint((int)point.getX(), (int)point.getY());
        }

        g.fillPolygon(p);
        list.clear();
    }}
class PolygonShape extends Shapes
{
    public void draw(java.util.List list, Graphics g)
    {
        Point point = null;
        Iterator it = list.iterator();

        if(list.size()<3)
        {
            return;
        }
        Polygon p = new Polygon();
        for(;it.hasNext();)
        {
            point = (Point)it.next();
            p.addPoint((int)point.getX(), (int)point.getY());
        }
        g.fillPolygon(p);
        list.clear();
    }
}

class Erase extends Shapes {
    public void draw(java.util.List list, Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,2000,2000);
    }
}

// draw line