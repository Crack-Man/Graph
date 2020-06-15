package GraphRedactor.Main;


import GraphRedactor.Observer.Observer;

import javax.swing.*;
import java.awt.*;

class Main {
    public static void main(String args[]) {
        Parameters par = Parameters.get();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        par.setParameters(screenSize.width, screenSize.height, 40);
        EventQueue.invokeLater(() -> {
                JFrame frame = new ShapeFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Model.get().addObserver((Observer) frame);
                frame.setVisible(true);
        });
    }
}