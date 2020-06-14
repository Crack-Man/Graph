package GraphRedactor.Main;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import GraphRedactor.Shape.MainShape;

public class Turn implements Serializable {
    private List<MainShape> list;
    private Color color;

    public Turn() {
        list = new ArrayList<MainShape>();
        color = Color.black;
    }

    public void add(MainShape shape) {
        shape.setColor(this.color);
        list.add(shape);
    }

    public void printTo(Graphics buffer) {
        for (MainShape shape: list) {
            if(shape.get() != null) {
                shape.draw(buffer);
            }
        }
    }

    public void setColor(Color color) {
        this.color = color;
        if(this.getLast() != null) {
            this.getLast().setColor(color);
        }
    }

    public Color getColor() {
        return this.color;
    }

    public MainShape getLast() {
        if(list.size() == 0) {
            return null;
        } else {
            return list.get(list.size() - 1);
        }
    }
}
