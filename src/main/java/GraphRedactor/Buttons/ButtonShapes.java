package GraphRedactor.Buttons;

import javax.swing.*;
import GraphRedactor.Main.Parameters;
import GraphRedactor.Main.Shape;

import java.awt.*;

public class ButtonShapes extends JPanel {
    public ButtonShapes(Shape sp, Parameters par) {
        super();
        this.setBounds(0,0, par.getWidth(), par.getButHeight());
        this.setBackground(Color.GRAY);
        this.add(new ButtonRect(sp));
        this.add(new ButtonEllipse(sp));
        this.add(new ButtonLine(sp));
        this.add(new ButtonPolygon(sp));
        this.add(new SavePNG(sp));
    }
}