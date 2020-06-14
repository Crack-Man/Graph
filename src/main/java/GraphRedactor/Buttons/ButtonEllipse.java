package GraphRedactor.Buttons;

import GraphRedactor.Main.Shape;
import GraphRedactor.Shape.EllipseDraw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEllipse extends MainButton {
    public ButtonEllipse(Shape sp) {
        super("Ellipse");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sp.add(new EllipseDraw());
            }
        });
    }
}
