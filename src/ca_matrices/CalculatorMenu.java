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
    JButton x2Button = new JButton("2x2 equation");
    JButton x3Button = new JButton("3x3 equation");
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
        
        x3Button.setFocusable(false);
        x3Button.setFocusable(false);
        
        x2Button.addActionListener(this);
        x3Button.addActionListener(this);
        
        frame.add(backButton);
        frame.add(x2Button);
        frame.add(x3Button);
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
        else if (e.getSource()== x3Button){
            frame.dispose();
            Matrix3x3 x3Menu = new Matrix3x3(userID);
        }
        else if (e.getSource()== backButton){
            frame.dispose();
            UserPage userPage = new UserPage(userID, adminCheck);
        }
    }
    
}
