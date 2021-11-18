/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_matrices;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author Luan
 */
public class RegistrationPage implements ActionListener {
    
    JFrame frame = new JFrame();
    JButton registerButton = new JButton("Register");
    JTextField userfNameField = new JTextField();
    JTextField userlNameField = new JTextField();
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userfNameLabel = new JLabel("First Name:");
    JLabel userlNameLabel = new JLabel("Last Name");
    JLabel userIDLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    HashMap<String,String> logininfo = new HashMap<String,String>();
    
    RegistrationPage() {
        
        userfNameLabel.setBounds(50,100,75,25);
        userlNameLabel.setBounds(50,150,75,25);
        userIDLabel.setBounds(50,200,75,25);
        userPasswordLabel.setBounds(50,250,75,25);
        
        userfNameField.setBounds(125,100,200,25);
        userlNameField.setBounds(125,150,200,25);
        userIDField.setBounds(125,200,200,25);
        userPasswordField.setBounds(125,250,200,25);
        
        registerButton.setBounds(170,300,100,25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        
        frame.add(userfNameLabel);
        frame.add(userlNameLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userfNameField);
        frame.add(userlNameField);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(registerButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== registerButton){
            //Find code to send data to database
            
            frame.dispose();
            LoginPage loginPage = new LoginPage();
        }
    } 
}
