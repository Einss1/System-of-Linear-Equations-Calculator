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
public class UserPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton modifyProfileButton = new JButton("Modify profile");
    JButton calculatorButton = new JButton("Calculator");
    JTextField userIDField = new JTextField();
    
    UserPage(String userID) {
        userIDField.setText(userID);
        modifyProfileButton.setBounds(125,75,150,25);
        calculatorButton.setBounds(125,125,150,25);
        
        modifyProfileButton.setFocusable(false);
        calculatorButton.setFocusable(false);
        
        modifyProfileButton.addActionListener(this);
        calculatorButton.addActionListener(this);
        
        frame.add(modifyProfileButton);
        frame.add(calculatorButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== modifyProfileButton){
            String userID = userIDField.getText();
            frame.dispose();
            ModifyProfile_dummy modifyPage_dummy = new ModifyProfile_dummy(userID);
        }
        else if (e.getSource()== calculatorButton){
            
        }
    }
}
