/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_matrices;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Luan
 */
public class UserList implements ActionListener{

    JFrame frame = new JFrame();
    JButton userListButton = new JButton("Fetch");
    JButton backButton = new JButton("Back");
    JLabel userIDLabel = new JLabel("");
    JLabel userNameLabel = new JLabel("");
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();

     UserList(String userID, String adminCheck) {
        
        adminCheckField.setText(adminCheck);
        userIDField.setText(userID); 
         
        userIDLabel.setBounds(50,100,200,200); 
        userNameLabel.setBounds(100,100,200,200);

        backButton.setBounds(25,15,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        
        userListButton.setBounds(170,300,100,25);
        userListButton.setFocusable(false);
        userListButton.addActionListener(this);
        
        frame.add(userNameLabel);
        frame.add(userListButton);
        frame.add(backButton);
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
        if(e.getSource()== userListButton){
            try {
                PreparedStatement st;
                ResultSet rs;
                
                String Query = "SELECT * FROM users_db";
                st = My_CNX.getConnection().prepareStatement(Query);
                
                
                rs = st.executeQuery();
                
                while (rs.next()) {
        
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == backButton){
            frame.dispose();
            AdminPage adminPage = new AdminPage(userID, adminCheck);
        }
    }
    
    
    
}
