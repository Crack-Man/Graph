package GraphRedactor.save;

import GraphRedactor.save.SaveShape;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SaveShapeQueue implements Serializable {
    private List<SaveShape> turn;

    public SaveShapeQueue() {
        this.turn = new ArrayList<SaveShape>();
    }

    public void addShape(SaveShape shape) {
        this.turn.add(shape);
    }

    public List<SaveShape> getShapes() {
        return this.turn;
    }
}
