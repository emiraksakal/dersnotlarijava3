

package graph;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//panel ve frame 'leri jpanel ve jframe yaparsan çok şekili tutabiliyorsun

public class SimpleDrawingTool extends Frame{

    //constants for menu shortcuts
    private static final int kControlA = 65;
    private static final int kControlE = 69;
    private static final int kControlD = 68;
    private static final int kControlC = 67;
    private static final int kControlR = 82;
    private static final int kControlP = 80;
    private static final int kControlT = 84;
    private static final int kControlX = 88;

    private RectangleShape rectangle = new RectangleShape();
    private OvalShape oval = new OvalShape();
    private PolygonShape polygon = new PolygonShape();
    private TriangleShape triangle = new TriangleShape();
    private Erase erase = new Erase();

    private DrawingPanel panel;

    public SimpleDrawingTool() {

        super("Simple Drawing Tool");
        addMenu();
        addPanel();
        this.addWindowListener(new WindowHandler());
        this.setSize(400, 400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SimpleDrawingTool simpleDrawingTool = new SimpleDrawingTool();
    }

    private void addMenu()
    {
        //Add menu bar to our frame
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        Menu shape = new Menu("Shapes and Erase");
        Menu about = new Menu("About");
      //  Menu erase = new Menu("Erase");
        file.add(new MenuItem("Exit", new MenuShortcut(kControlX))).addActionListener(new WindowHandler());

        shape.add(new MenuItem("Rectangle", new MenuShortcut(kControlR))).addActionListener(new WindowHandler());
        shape.add(new MenuItem("Circle", new MenuShortcut(kControlC))).addActionListener(new WindowHandler());
        shape.add(new MenuItem("Triangle", new MenuShortcut(kControlT))).addActionListener(new WindowHandler());
        shape.add(new MenuItem("Polygon", new MenuShortcut(kControlP))).addActionListener(new WindowHandler());
        shape.add(new MenuItem("Draw Polygon", new MenuShortcut(kControlD))).addActionListener(new WindowHandler());
        shape.add(new MenuItem("Erase", new MenuShortcut(kControlE))).addActionListener(new WindowHandler());


        about.add(new MenuItem("About", new MenuShortcut(kControlA))).addActionListener(new WindowHandler());
        //add menus to menubar
        menuBar.add(file);
        menuBar.add(shape);
        menuBar.add(about);
        //menuBar.add(erase);
        //menuBar.setVisible(true);
        if(null == this.getMenuBar())
        {
            this.setMenuBar(menuBar);
        }
    }//addMenu()


    private void addPanel()
    {
        panel = new DrawingPanel();
        Dimension d = this.getSize();

        Insets ins = this.insets();

        d.height = d.height - ins.top - ins.bottom;
        d.width = d.width - ins.left - ins.right;
        panel.setSize(d);
        panel.setLocation(ins.left, ins.top);
        panel.setBackground(Color.white);

        panel.addMouseListener(panel);
        this.add(panel);
    }

    private class WindowHandler extends WindowAdapter implements ActionListener
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }

        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("exit"))
            {
                System.exit(0);
            }
            else if(e.getActionCommand().equalsIgnoreCase("Rectangle"))
            {
                Menu menu = getMenuBar().getMenu(1);
                for(int i = 0;i < menu.getItemCount();menu.getItem(i).setEnabled(true),i++);
                getMenuBar().getShortcutMenuItem(new MenuShortcut(kControlR)).setEnabled(false);
                panel.drawShape(rectangle);

            }
            else if(e.getActionCommand().equalsIgnoreCase("Circle"))
            {
                Menu menu = getMenuBar().getMenu(1);
                for(int i = 0;i < menu.getItemCount();menu.getItem(i).setEnabled(true),i++);
                getMenuBar().getShortcutMenuItem(new MenuShortcut(kControlC)).setEnabled(false);
                panel.drawShape(oval);
            }
            else if(e.getActionCommand().equalsIgnoreCase("Triangle"))
            {
                Menu menu = getMenuBar().getMenu(1);
                for(int i = 0;i < menu.getItemCount();menu.getItem(i).setEnabled(true),i++);
                getMenuBar().getShortcutMenuItem(new MenuShortcut(kControlT)).setEnabled(false);
                panel.drawShape(triangle);
            }
            else if(e.getActionCommand().equalsIgnoreCase("Polygon"))
            {
                Menu menu = getMenuBar().getMenu(1);
                for(int i = 0;i < menu.getItemCount();menu.getItem(i).setEnabled(true),i++);
                getMenuBar().getShortcutMenuItem(new MenuShortcut(kControlP)).setEnabled(false);
                panel.drawShape(polygon);
            }
            else if(e.getActionCommand().equalsIgnoreCase("Draw Polygon"))
            {
                Menu menu = getMenuBar().getMenu(1);
                for(int i = 0;i < menu.getItemCount();menu.getItem(i).setEnabled(true),i++);
                getMenuBar().getShortcutMenuItem(new MenuShortcut(kControlP)).setEnabled(false);
                panel.repaint();
            }
            else if(e.getActionCommand().equalsIgnoreCase("About"))
            {
                JOptionPane.showMessageDialog(null, "dörtgen ve oval şekilleri çizmek için mouse'ı sürükleyip bırakmanız gerekiyor.\n" +
                        "üçgen çizmek içinse 3 ayrı noktaya tıklamanız.\n" +
                        "silme işlemi shapes'in içinde bulunuyor.\n", "About", JOptionPane.PLAIN_MESSAGE);
            }
            else if(e.getActionCommand().equalsIgnoreCase("Erase"))
            {
                Menu menu = getMenuBar().getMenu(1);
                for(int i = 0;i < menu.getItemCount();menu.getItem(i).setEnabled(true),i++);
                getMenuBar().getShortcutMenuItem(new MenuShortcut(kControlE)).setEnabled(false);
                panel.repaint();
               panel.drawShape(erase);
            }
        }//actionPerformed()

    }//windowHandler - Inner Class ends here
}//SimpleDrawingTool

class DrawingPanel extends JPanel implements MouseListener
{

    private Point sPoint = null;
    private Point ePoint = null;
    private Shapes shape = null;
    private java.util.ArrayList list = new java.util.ArrayList();
    //override panel paint method to draw shapes
    public void paint(Graphics g)
    {
        g.setColor(Color.green);
        shape.draw(list, g);
    }
    public void drawShape(Shapes shape)
    {
        this.shape = shape;
    }

    public void mouseClicked(MouseEvent e)
    {
        if(shape instanceof TriangleShape)
        {
            list.add(e.getPoint());
            if(list.size() > 2)
            {
                repaint();
            }
        }
        else if(shape instanceof PolygonShape)
        {
            list.add(e.getPoint());
        }
    }//mouseClicked
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e)
    {
        sPoint = e.getPoint();
    }//mousePressed
    public void mouseReleased(MouseEvent e)
    {
        ePoint = e.getPoint();
        if(ePoint.getX() < sPoint.getX())
        {
            Point temp = ePoint;
            ePoint = sPoint;
            sPoint = temp;
        }
        if(ePoint.getY() < sPoint.getY())
        {
            int temp = (int)ePoint.getY();
            ePoint.y = (int)sPoint.getY();
            sPoint.y = temp;
        }
        if(shape instanceof RectangleShape || shape instanceof OvalShape)
        {
            list.clear();
            list.add(sPoint);
            list.add(ePoint);
            repaint();
        }
    }//mouseReleased
}//DrawingPanel

