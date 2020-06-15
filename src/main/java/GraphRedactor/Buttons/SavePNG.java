package GraphRedactor.Buttons;

import GraphRedactor.Main.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SavePNG extends MainButton {
    public SavePNG() {
        super("Save");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Model.get().savePNG();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
