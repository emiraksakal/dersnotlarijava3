package newp;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {


        JFrame frame = new JFrame("Işık Paint");



        JPanel panel = new JPanel();
        frame.add(panel);


        JButton btn1 = new JButton("Create");
        btn1.setBounds(0,0,500,500);
        panel.add(btn1);

        JButton btn2 = new JButton("Move");
        btn2.setBounds(0,0,500,500);
        panel.add(btn2);



      //  frame.setLayout(null);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        // create.setLayout(null);
    }
}