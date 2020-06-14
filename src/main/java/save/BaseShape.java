package save;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.List;

public abstract class BaseShape implements Serializable {
    abstract public void draw(Graphics g);

    abstract public Shape get();
    abstract public Color getColor();
    abstract public String getType();
    abstract public List<Point2D> getPoints();

    abstract public void set(Shape shape);
    abstract public void setColor(Color color);
    abstract public void setCoordinates(List<Point2D> point);

    abstract public void addCoordinates(Point2D point);
    abstract public void addSecCoordinates(Point2D point);
    abstract public void addMotionCoordinates(Point2D point);
}
