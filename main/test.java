package main;

import com.github.javafaker.Faker;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class test {

    public static void main(String[] args){

        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel text = new JLabel("Hello!");
        text.setText("This is a label");
        JButton button = new JButton("This is a button!");
        JButton button2 = new JButton("This is a button also!");

        panel1.add(text);
        panel1.add(button2);
        panel2.add(button);

        frame.add(panel1);
        panel1.setVisible(false);
        frame.add(panel2);
        panel2.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.setVisible(false);
                panel1.setVisible(true);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                panel2.setVisible(true);
            }
        });

        frame.pack();
        frame.setVisible(true);



    }

}
