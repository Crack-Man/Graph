package GraphRedactor.Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GraphRedactor.Main.Model;

public class ClBut extends JButton {
    public ClBut(Color color) {
        super();
        this.setBackground(color);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Model.get().getLast() != null) {
                    Model.get().getLast().setColor(color);
                }
                Model.get().setColor(color);
            }
        });
    }
}
