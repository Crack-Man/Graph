package GraphRedactor.Main;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import GraphRedactor.save.BaseShape;

public class Turn implements Serializable {
    private List<BaseShape> list;
    private Color color;

    public Turn() {
        list = new ArrayList<BaseShape>();
        color = Color.black;
    }

    public void add(BaseShape shape) {
        shape.setColor(this.color);
        list.add(shape);
    }

    public void printTo(Graphics buffer) {
        for (BaseShape shape: list) {
            if(shape.get() != null) {
                shape.draw(buffer);
            }
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public BaseShape getLast() {
        if(list.size() == 0) {
            return null;
        } else {
            return list.get(list.size() - 1);
        }
    }

    public void refresh() {
        this.list.clear();
    }

    public List<BaseShape> getTurn() {
        return this.list;
    }
}
