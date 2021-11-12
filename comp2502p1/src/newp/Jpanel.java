package newp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jpanel extends JPanel {

   Jpanel(){
        JPanel panel = new JPanel();


        JButton square = new JButton("SQUARE");
        JButton circle = new JButton("CIRCLE");
        JButton rect = new JButton("RECTANGLE");
        JButton line = new JButton("LINE");

        square.setBounds(20, 10, 120, 50);
        circle.setBounds(20, 62, 120, 50);
        rect.setBounds(20, 114, 120, 50);
        line.setBounds(20, 166, 120, 50);


       square.addActionListener((ActionListener) this);
       circle.addActionListener((ActionListener) this);
       rect.addActionListener((ActionListener) this);
       line.addActionListener((ActionListener) this);




    }
}
