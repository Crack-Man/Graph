package GraphRedactor.Main;

import GraphRedactor.Buttons.ClBut;

import javax.swing.*;
import java.awt.*;

public class ButtonColors extends JPanel {
    public ButtonColors(Shape sp, Parameters par) {
        super();
        this.setBounds(0, par.getButHeight(), par.getWidth(), par.getButHeight());
        this.add(new ClBut(Color.black, par));
        this.add(new ClBut(Color.red, par));
        this.add(new ClBut(Color.green, par));
        this.add(new ClBut(Color.blue, par));
    }
}
