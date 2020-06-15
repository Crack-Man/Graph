package GraphRedactor.Buttons;

import javax.swing.*;
import GraphRedactor.Main.Parameters;
import GraphRedactor.Main.Model;

import java.awt.*;

public class ButtonShapes extends JPanel {
    public ButtonShapes() {
        super();
        Parameters par = Parameters.get();
        this.setBounds(0,0, par.getWidth(), par.getButHeight());
        this.setBackground(Color.GRAY);
        this.add(new ButtonRect());
        this.add(new ButtonEllipse());
        this.add(new ButtonLine());
        this.add(new ButtonPolygon());
        this.add(new SavePNG());
        this.add(new Save());
        this.add(new Load());
    }
}
