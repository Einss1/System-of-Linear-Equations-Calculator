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
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Luan
 */
public class AdminPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Back to Login");
    JButton modifyProfileButton = new JButton("Modify profile");
    JButton userListButton = new JButton("User list");
    JButton removeUsersButton = new JButton("Remove users");
    JButton reviewOperationsButton = new JButton("Review Operations");
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();
    
    
    AdminPage(String userID, String adminCheck) {
    userIDField.setText(userID);
    adminCheckField.setText(adminCheck);
    loginButton.setBounds(25,25,125,25);
    modifyProfileButton.setBounds(125,75,150,25);
    userListButton.setBounds(125,125,150,25);
    removeUsersButton.setBounds(125,175,150,25);
    reviewOperationsButton.setBounds(125,225,150,25);
    
    loginButton.setFocusable(false);
    modifyProfileButton.setFocusable(false);
    userListButton.setFocusable(false);
    removeUsersButton.setFocusable(false);
    reviewOperationsButton.setFocusable(false);
    
    loginButton.addActionListener(this);
    modifyProfileButton.addActionListener(this);
    userListButton.addActionListener(this);
    removeUsersButton.addActionListener(this);
    reviewOperationsButton.addActionListener(this);
    
    frame.setTitle("Admin Page");
    frame.add(loginButton);
    frame.add(modifyProfileButton);
    frame.add(userListButton);
    frame.add(removeUsersButton);
    frame.add(reviewOperationsButton);
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
        if(e.getSource()== modifyProfileButton){
            frame.dispose();
            ModifyProfile modifyPage = new ModifyProfile(userID, adminCheck);
        }
        else if (e.getSource()== userListButton){
            frame.dispose();
            UserList userList = new UserList(userID, adminCheck);
        }
        else if (e.getSource()== removeUsersButton){
            frame.dispose();
            RemoveUser removeUser = new RemoveUser(userID, adminCheck);
        }
        else if (e.getSource()== reviewOperationsButton){
            frame.dispose();
            ReviewOperations reviewOperations = new ReviewOperations(userID, adminCheck);
        }
        else if (e.getSource()== loginButton){
            frame.dispose();
            LoginPage loginPage = new LoginPage();
        }
    }
}
