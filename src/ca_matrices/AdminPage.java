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
    JButton modifyProfileButton = new JButton("Modify profile");
    JButton userListButton = new JButton("User list");
    JButton removeUsersButton = new JButton("Remove users");
    JButton reviewOperationsButton = new JButton("Review Operations");
    JTextField userIDField = new JTextField();
    
    
    AdminPage(String userID) {
    userIDField.setText(userID);
    modifyProfileButton.setBounds(125,75,150,25);
    userListButton.setBounds(125,125,150,25);
    removeUsersButton.setBounds(125,175,150,25);
    reviewOperationsButton.setBounds(125,225,150,25);
    
    modifyProfileButton.setFocusable(false);
    userListButton.setFocusable(false);
    removeUsersButton.setFocusable(false);
    reviewOperationsButton.setFocusable(false);
    
    modifyProfileButton.addActionListener(this);
    userListButton.addActionListener(this);
    removeUsersButton.addActionListener(this);
    reviewOperationsButton.addActionListener(this);
    
    frame.add(modifyProfileButton);
    frame.add(userListButton);
    frame.add(removeUsersButton);
    frame.add(reviewOperationsButton);
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
            ModifyProfile modifyPage = new ModifyProfile(userID);
        }
        else if (e.getSource()== userListButton){
            frame.dispose();
            UserList userList = new UserList();
        }
        else if (e.getSource()== removeUsersButton){
            frame.dispose();
            RemoveUser removeUser = new RemoveUser();
        }
        else if (e.getSource()== reviewOperationsButton){
            
        }
    }
}
