package GraphRedactor.Main;

import GraphRedactor.Buttons.ButtonColors;
import GraphRedactor.Buttons.ButtonShapes;
import GraphRedactor.Observer.Observer;

import javax.swing.*;

class ShapeFrame extends JFrame implements Observer {
    public ShapeFrame() {
        setTitle("Graph Redactor");
        Parameters par = Parameters.get();
        this.setSize(par.getWidth(), par.getHeight());
        setLocationByPlatform(true);
        this.add(new ButtonShapes());
        this.add(new ButtonColors());
        this.add(new Canvas());
        this.setVisible(true);
    }

    @Override
    public void handleEvent() {
        repaint();
    }
}