package GraphRedactor.Buttons;

import GraphRedactor.Main.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GraphRedactor.Shape.PolyLineDraw;

public class ButtonLine extends MainButton {
    public ButtonLine() {
        super("PolyLine");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.get().add(new PolyLineDraw());
            }
        });
    }
}
