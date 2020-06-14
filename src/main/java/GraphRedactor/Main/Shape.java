package GraphRedactor.Main;


import GraphRedactor.Shape.MainShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class Shape {
    private int width, height;
    private BufferedImage buf = null;
    private Graphics buffer = null;
    private Turn turn;
    private Parameters par;
    private static Shape me;

    private Shape() {
        turn = new Turn();
        this.par = Parameters.get();
        this.width = par.getWidth();
        this.height = par.getHeight();
        buf = new BufferedImage(this.par.getWidth(), this.par.getHeight(), BufferedImage.TYPE_INT_ARGB);
        buffer = buf.getGraphics();
        buffer.setColor(Color.white);
        buffer.fillRect(0, 0, this.width, this.height);
    }

    public static Shape get() {
        if(me == null) {
            me = new Shape();
        }
        return me;
    }

    public MainShape getLast() {
        return turn.getLast();
    }

    public void setColor(Color color) {
        turn.setColor(color);
    }

    public void add(MainShape shape) {
        turn.add(shape);
    }

    public void addCoordinates(Point2D point) {
        if(point.getY() >= 2 * par.getButHeight()) {
            turn.getLast().addCoordinates(point);
        }
    }

    public void addSecCoordinates(Point2D point) {
        if(point.getY() >= 2 * par.getButHeight()) {
            turn.getLast().addSecCoordinates(point);
        }
    }

    public void addMotionCoordinates(Point2D point) {
        if(point.getY() >= 2 * par.getButHeight()) {
            turn.getLast().addMotionCoordinates(point);
        }
    }

    public BufferedImage getBuf() {
        buffer.setColor(Color.white);
        buffer.fillRect(0, 2 * par.getButHeight(), par.getWidth(), par.getHeight());
        turn.printTo(buffer);
        return buf;
    }
}
