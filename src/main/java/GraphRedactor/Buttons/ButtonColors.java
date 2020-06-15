package GraphRedactor.Buttons;

import GraphRedactor.Main.Parameters;

import javax.swing.*;
import java.awt.*;

public class ButtonColors extends JPanel {
    public ButtonColors() {
        super();
        Parameters par = Parameters.get();
        this.setBounds(0, par.getButHeight(), par.getWidth(), par.getButHeight());
        this.setBackground(Color.GRAY);
        this.add(new ClBut(Color.black));
        this.add(new ClBut(Color.red));
        this.add(new ClBut(Color.green));
        this.add(new ClBut(Color.blue));
    }
}
