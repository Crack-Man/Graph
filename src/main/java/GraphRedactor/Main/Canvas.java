package GraphRedactor.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Canvas extends JPanel {
    private Model model;
    private Parameters par;
    private Canvas me;

    public Canvas() {
        me = this;
        this.model = Model.get();
        this.par = Parameters.get();
        this.setBounds(0, 2 * par.getButHeight(), par.getWidth(), par.getHeight());
        this.addMouseListener(new MouseListener() {
                //MouseListener
                @Override
                public void mouseClicked(MouseEvent event) {}

                @Override
                public void mouseEntered(MouseEvent event) {}

                @Override
                public void mouseExited(MouseEvent event) {}

                @Override
                public void mousePressed(MouseEvent event) {
                    if(model.getLast() != null) {
                        model.addCoordinates(event.getPoint());
                        model.addMotionCoordinates(event.getPoint());
                    }
                }

                @Override
                public void mouseReleased(MouseEvent event) {
                    if(model.getLast() != null) {
                        model.addSecCoordinates(event.getPoint());
                    }
                }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent event) {
                if(model.getLast() != null) {
                    model.addMotionCoordinates(event.getPoint());
                }
            }

            @Override
            public void mouseMoved(MouseEvent event) {
            }
        });
    }

    public void paint(Graphics g) {
        g.drawImage(model.getBuf(), 0, 0, me);
    }

}
