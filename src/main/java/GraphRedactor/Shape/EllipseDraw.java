package GraphRedactor.Shape;

import save.BaseShape;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.List;

public class EllipseDraw extends BaseShape {
    private Color color;
    private Ellipse shape;

    public EllipseDraw() {
        this.shape = new Ellipse();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrameFromDiagonal(shape.getX0(), shape.getY0(), shape.getX1(), shape.getY1());
        g.drawOval((int) ellipse.getX(), (int) ellipse.getY(), (int) ellipse.getWidth(), (int) ellipse.getHeight());
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public String getType() {
        return "Ellipse";
    }

    @Override
    public List<Point2D> getPoints() {
        return shape.getPoints();
    }



    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setCoordinates(List<Point2D> point) {
        addCoordinates(point.get(0));
        addSecCoordinates(point.get(1));
    }

    @Override
    public Shape get() {
        return this.shape;
    }

    @Override
    public void addCoordinates(Point2D point) {
        this.shape.addCoordinates(point);
    }

    @Override
    public void addSecCoordinates(Point2D point) {
        this.shape.addSecCoordinates(point);
    }

    @Override
    public void addMotionCoordinates(Point2D point) {
        this.shape.addMotionCoordinates(point);
    }
}
