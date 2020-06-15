package GraphRedactor.Buttons;

import GraphRedactor.Main.Model;
import GraphRedactor.Shape.PolygonDraw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPolygon extends MainButton {
    public ButtonPolygon() {
        super("Polygon");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.get().add(new PolygonDraw());
            }
        });
    }
}
