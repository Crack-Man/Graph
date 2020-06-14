package GraphRedactor.Buttons;

import GraphRedactor.Main.Shape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Save extends MainButton {
    public Save(Shape sp) {
        super("Save Project");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Shape.get().save();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
