/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_matrices;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Luan
 */
public class CalculatorMenu implements ActionListener {

    JFrame frame = new JFrame();
    JButton backButton = new JButton("Back");
    JButton x2Button = new JButton("2x2 Matrix");
    JButton x3Button = new JButton("3x3 Matrix");
    JButton x2simButton = new JButton("2x2 Simultaneous");
    JButton x3simButton = new JButton("3x3 Simultaneous");
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();
    
    CalculatorMenu(String userID, String adminCheck) {
        userIDField.setText(userID);
        adminCheckField.setText(adminCheck);
        
        backButton.setBounds(25,15,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        
        x2Button.setBounds(125,75,150,25);
        x3Button.setBounds(125,125,150,25);
        x2simButton.setBounds(125,175,150,25);
        x3simButton.setBounds(125,225,150,25);
        
        x2Button.setFocusable(false);
        x3Button.setFocusable(false);
        x2simButton.setFocusable(false);
        x3simButton.setFocusable(false);
        
        x2Button.addActionListener(this);
        x3Button.addActionListener(this);
        x2simButton.addActionListener(this);
        x3simButton.addActionListener(this);
        
        frame.setTitle("Calculator Menu");
        frame.add(backButton);
        frame.add(x2Button);
        frame.add(x3Button);
        frame.add(x2simButton);
        frame.add(x3simButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String userID = userIDField.getText();
        String adminCheck = adminCheckField.getText();
        if(e.getSource()== x2Button){
            frame.dispose();
            Matrix2x2 x2Menu = new Matrix2x2(userID, adminCheck);
        }
        if (e.getSource()== x3Button){
            frame.dispose();
            Matrix3x3 x3Menu = new Matrix3x3(userID, adminCheck);
        }
        if (e.getSource()== x2simButton) {
            frame.dispose();
            Simultaneous2x2 sim2x2Menu = new Simultaneous2x2(userID, adminCheck);
        }
        if (e.getSource()== x3simButton) {
            frame.dispose();
            Simultaneous3x3 sim3x3Menu = new Simultaneous3x3(userID, adminCheck);
        }
        if (e.getSource()== backButton){
            frame.dispose();
            UserPage userPage = new UserPage(userID, adminCheck);
        }
    }
    
}
