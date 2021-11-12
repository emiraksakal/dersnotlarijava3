package newp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import acm.graphics.*;

/** This class displays a mouse-draggable rectangle and oval */
public class DragUsingStandaloneJFrame extends JFrame
        implements MouseListener, MouseMotionListener {

    /** Initializes and installs the objects in the JFrame */
    public void ObjectDragExample() {
        gc = new GCanvas();
        GRect rect = new GRect(100, 100, 150, 100);
        rect.setFilled(true);
        rect.setColor(Color.RED);
        rect.addMouseListener(this);
        rect.addMouseMotionListener(this);
        gc.add(rect);
        GOval oval = new GOval(300, 115, 100, 70);
        oval.setFilled(true);
        oval.setColor(Color.GREEN);
        oval.addMouseListener(this);
        oval.addMouseMotionListener(this);
        gc.add(oval);
        getContentPane().add(BorderLayout.CENTER, gc);
        setSize(500, 300);
    }

    /** Called on mouse press to record the coordinates of the click */
    public void mousePressed(MouseEvent e) {
        last = new GPoint(e.getPoint());
    }

    /** Called on mouse drag to reposition the object */
    public void mouseDragged(MouseEvent e) {
        GObject gobj = (GObject) e.getSource();
        GPoint pt = new GPoint(e.getPoint());
        gobj.move(pt.getX() - last.getX(), pt.getY() - last.getY());
        last = pt;
    }

    /** Called on mouse click to move this object to the front */
    public void mouseClicked(MouseEvent e) {
        ((GObject) e.getSource()).sendToFront();
    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { }

    /** Standard entry point for the application */


    /* Private state */
    private GCanvas gc;
    private GPoint last;

}