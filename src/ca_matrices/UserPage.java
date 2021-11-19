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

/**
 *
 * @author Luan
 */
public class UserPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton modifyProfileButton = new JButton("Modify profile");
    JButton calculatorButton = new JButton("Calculator");
    
    UserPage() {
        
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
            
        }
        else if (e.getSource()== calculatorButton){
            
        }
    }
}
