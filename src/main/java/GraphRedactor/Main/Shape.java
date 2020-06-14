package GraphRedactor.Main;


import GraphRedactor.Observer.*;
import GraphRedactor.Shape.MainShape;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Shape implements Observed {
    private java.util.List<Observer> listOfObservers;
    private int width, height;
    private BufferedImage buf = null;
    private Graphics buffer = null;
    private Turn turn;
    private Parameters par;
    private static Shape me;

    private Shape() {
        turn = new Turn();
        listOfObservers = new ArrayList<Observer>();
        this.par = Parameters.get();
        this.width = par.getWidth();
        this.height = par.getHeight();
        buf = new BufferedImage(this.par.getWidth(), this.par.getHeight(), BufferedImage.TYPE_INT_ARGB);
        buffer = buf.getGraphics();
        buffer.setColor(Color.white);
        buffer.fillRect(0, 2 * par.getButHeight(), this.width, this.height);
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
            notifyObservers();
        }
    }

    public void addSecCoordinates(Point2D point) {
        if(point.getY() >= 2 * par.getButHeight()) {
            turn.getLast().addSecCoordinates(point);
            notifyObservers();
        }
    }

    public void addMotionCoordinates(Point2D point) {
        if(point.getY() >= 2 * par.getButHeight()) {
            turn.getLast().addMotionCoordinates(point);
            notifyObservers();
        }
    }

    public BufferedImage getBuf() {
        buffer.setColor(Color.white);
        buffer.fillRect(0, 2 * par.getButHeight(), par.getWidth(), par.getHeight());
        turn.printTo(buffer);
        return buf;
    }

    public void savePNG() throws IOException {
        ImageIO.write(buf, "png", new File("image.png"));
    }

    @Override
    public void addObserver(Observer observer) {
        listOfObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        listOfObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: listOfObservers) {
            observer.handleEvent();
        }
    }
}
