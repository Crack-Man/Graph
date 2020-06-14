package GraphRedactor.Shape;

import save.BaseShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import java.util.List;

public class RectDraw extends BaseShape {
    private Color color;
    private Rect shape;

    public RectDraw() {
        this.shape = new Rect();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        Rectangle2D rectangle = new Rectangle2D.Double();
        rectangle.setFrameFromDiagonal(shape.getX0(), shape.getY0(), shape.getX1(), shape.getY1());
        g.drawRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    @Override
    public List<Point2D> getPoints() {
        return shape.getPoints();
    }

    @Override
    public void set(Shape shape) {
        this.shape = (Rect) shape;
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
