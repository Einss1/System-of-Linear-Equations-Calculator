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
public class Matrix3x3 implements ActionListener {

    JFrame frame = new JFrame();
    JButton backButton = new JButton("Back");
    JButton resultButton = new JButton("Result");
    JButton storeDataButton = new JButton("Save");
    JButton clearButton = new JButton("Clear");
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();
    
    
    Matrix3x3(String userID, String adminCheck){
        userIDField.setText(userID);
        adminCheckField.setText(adminCheck);
        
        storeDataButton.setBounds(200,300,100,25);
        storeDataButton.setFocusable(false);
        storeDataButton.addActionListener(this);
        
        backButton.setBounds(25,15,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        
        clearButton.setBounds(125,15,100,25);
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);
        
        frame.setTitle("Matrix 3x3");
        frame.add(resultButton);
        frame.add(storeDataButton);
        frame.add(backButton);
        frame.add(clearButton);
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
        if (e.getSource()== resultButton){

        }
        if (e.getSource()== storeDataButton){

        }
        if (e.getSource()== backButton){
            frame.dispose();
            CalculatorMenu calculatorMenu = new CalculatorMenu(userID, adminCheck);
        }
        if (e.getSource()== clearButton){

        }
    }
    
}
