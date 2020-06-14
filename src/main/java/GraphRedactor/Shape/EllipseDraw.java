package GraphRedactor.Shape;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class EllipseDraw extends MainShape {
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
        return null;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Shape get() {
        return this.shape;
    }

    @Override
    public void addCoordinates(Point2D point) {
        this.shape.addCoordinate(point);
    }

    @Override
    public void addSecCoordinates(Point2D point) {
        this.shape.addSecCoordinate(point);
    }

    @Override
    public void addMotionCoordinates(Point2D point) {
        this.shape.addMotionCoordinates(point);
    }
}
