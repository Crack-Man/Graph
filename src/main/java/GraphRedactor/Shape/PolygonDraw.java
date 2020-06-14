package GraphRedactor.Shape;

import GraphRedactor.save.BaseShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

public class PolygonDraw extends BaseShape {
    private Color color;
    private Polygon shape;

    public PolygonDraw() {
        this.shape = new Polygon();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawPolygon(shape.getX(), shape.getY(), shape.size());
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public String getType() {
        return "Polygon";
    }

    @Override
    public List<Point2D> getPoints() {
        return shape.getPoints();
    }

    @Override
    public void set(Shape shape) {
        this.shape = (Polygon) shape;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setCoordinates(List<Point2D> point) {
        for(int i = 0 ; i < point.size(); i++) {
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
