package GraphRedactor.Buttons;

import GraphRedactor.Buttons.ClBut;
import GraphRedactor.Main.Parameters;
import GraphRedactor.Main.Shape;

import javax.swing.*;
import java.awt.*;

public class ButtonColors extends JPanel {
    public ButtonColors(Shape sp, Parameters par) {
        super();
        this.setBounds(0, par.getButHeight(), par.getWidth(), par.getButHeight());
        this.setBackground(Color.GRAY);
        this.add(new ClBut(Color.black, par));
        this.add(new ClBut(Color.red, par));
        this.add(new ClBut(Color.green, par));
        this.add(new ClBut(Color.blue, par));
    }
}
