package GraphRedactor.Shape;

import save.BaseShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

public class PolyLineDraw extends BaseShape {
    private Color color;
    private PolyLine shape;

    public PolyLineDraw() {
        this.shape = new PolyLine();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawPolyline(shape.getX(), shape.getY(), shape.size());
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public String getType() {
        return "Polyline";
    }

    @Override
    public List<Point2D> getPoints() {
        return shape.getPoints();
    }

    @Override
    public void set(Shape shape) {
        this.shape = (PolyLine) shape;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setCoordinates(List<Point2D> point) {
        for(int i = 0; i < point.size() - 1; i++) {
            addCoordinates(point.get(i));
        }
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
        this.shape.addCoordinate(point);
    }

    @Override
    public void addMotionCoordinates(Point2D point) {
        this.shape.addMotionCoordinates(point);
    }
}
