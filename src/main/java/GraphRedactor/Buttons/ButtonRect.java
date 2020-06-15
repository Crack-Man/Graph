package GraphRedactor.Buttons;

import GraphRedactor.Main.Model;
import GraphRedactor.Shape.RectDraw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonRect extends MainButton {
    public ButtonRect() {
        super("Rectangle");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.get().add(new RectDraw());
            }
        });
    }
}
