package GraphRedactor.Main;

import GraphRedactor.Buttons.ButtonColors;
import GraphRedactor.Buttons.ButtonShapes;
import GraphRedactor.Observer.Observer;

import javax.swing.*;

class ShapeFrame extends JFrame implements Observer {
    public ShapeFrame(Shape sp, Parameters par) {
        setTitle("Graph Redactor");
        this.setSize(par.getWidth(), par.getHeight());
        setLocationByPlatform(true);
        this.add(new ButtonShapes(sp, par));
        this.add(new ButtonColors(sp, par));
        this.add(new Canvas(sp, par));
        this.setVisible(true);
    }

    @Override
    public void handleEvent() {
        repaint();
    }
}