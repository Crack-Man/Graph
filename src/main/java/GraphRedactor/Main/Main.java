package GraphRedactor.Main;


import GraphRedactor.Observer.Observer;

import javax.swing.*;
import java.awt.*;

class Main {
    public static void main(String args[]) {
        Parameters par = Parameters.get();
        par.setParameters(600, 600, 40);
        Shape sp = Shape.get();
        EventQueue.invokeLater(() -> {
                JFrame frame = new ShapeFrame(sp, par);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Shape.get().addObserver((Observer) frame);
                frame.setVisible(true);
        });
    }
}