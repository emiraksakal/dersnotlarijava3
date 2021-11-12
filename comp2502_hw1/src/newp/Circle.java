package newp;

import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel {

    int x,y;

    Circle (int x,int y){
        this.x=x;
        this.y=y;
        setSize(x,y);
        setVisible(true);
        setLocation(0,0);
    }

    public void paint(Graphics graphics) {
        graphics.drawOval(0,0,50,50);
        graphics.setColor(Color.BLUE);
        graphics.fillOval(0,0,50,50);
    }

}
