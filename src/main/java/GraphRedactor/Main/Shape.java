package GraphRedactor.Main;


import GraphRedactor.Observer.*;
import save.*;
import GraphRedactor.Shape.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.*;
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

    public BaseShape getLast() {
        return turn.getLast();
    }

    public void setColor(Color color) {
        turn.setColor(color);
    }

    public void add(BaseShape shape) {
        turn.add(shape);
    }

    public void refresh() {
        this.turn.refresh();
        notifyObservers();
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

    public void save() throws IOException {
        SaveShapeQueue turnShape = new SaveShapeQueue();
        for(BaseShape shape: turn.getTurn()) {
            turnShape.addShape(new SaveShape(shape));
        }
        FileOutputStream outputStream = new FileOutputStream("save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(turnShape);
        objectOutputStream.close();
    }

    public void load() throws IOException, ClassNotFoundException {
        SaveShapeQueue shapes = new SaveShapeQueue();
        FileInputStream fileInputStream = new FileInputStream("save.ser");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            shapes = (SaveShapeQueue) objectInputStream.readObject();
            refresh();
            for (SaveShape saveShape: shapes.getShapes()) {
                setColor(saveShape.getColor());
                if(saveShape.getType().equals("Ellipse")) {
                    add(new EllipseDraw());
                } else if (saveShape.getType().equals("Rectangle")) {
                    add(new RectDraw());
                } else if (saveShape.getType().equals("Polygon")) {
                    add(new PolygonDraw());
                } else if (saveShape.getType().equals("Polyline")) {
                    add(new PolyLineDraw());
                } else throw new RuntimeException("problem");
                if(saveShape.getPoints().size() != 0) {
                    getLast().setCoordinates(saveShape.getPoints());
                }
            }
            notifyObservers();
        }

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
