package GraphRedactor.Buttons;

import GraphRedactor.Main.Shape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SavePNG extends MainButton {
    public SavePNG(Shape sp) {
        super("Save");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Shape.get().savePNG();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
