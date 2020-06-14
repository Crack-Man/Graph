package GraphRedactor.Buttons;

import GraphRedactor.Main.Parameters;
import GraphRedactor.Shape.PolyLineDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GraphRedactor.Main.Shape;

public class ClBut extends JButton {
    public ClBut(Color color, Parameters par) {
        super();
        this.setBackground(color);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Shape.get().getLast() != null) {
                    Shape.get().getLast().setColor(color);
                }
                Shape.get().setColor(color);
            }
        });
    }
}
