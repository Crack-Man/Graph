package GraphRedactor.Buttons;

import GraphRedactor.Main.Model;
import GraphRedactor.Shape.EllipseDraw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEllipse extends MainButton {
    public ButtonEllipse() {
        super("Ellipse");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.get().add(new EllipseDraw());
            }
        });
    }
}
