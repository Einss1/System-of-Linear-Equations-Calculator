/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_matrices;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Luan
 */
public class RemoveUser implements ActionListener {
    
    JFrame frame = new JFrame();
    JButton removeButton = new JButton("Remove");
    JButton backButton = new JButton("Back");
    JTextField userNameField = new JTextField();
    JLabel userNameLabel = new JLabel("Username:");
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();

    public boolean verifyFields() {
        String uname = userNameField.getText(); 
        
        if (uname.trim().equals("")) {
            return false;
        }     
        else {
            return true;
        }
    }
    
    RemoveUser(String userID, String adminCheck) {
        adminCheckField.setText(adminCheck);
        userIDField.setText(userID);
        
        userNameLabel.setBounds(50,150,100,25);
        
        userNameField.setBounds(150,150,150,25);
        
        backButton.setBounds(25,15,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        
        removeButton.setBounds(170,300,100,25);
        removeButton.setFocusable(false);
        removeButton.addActionListener(this);
        
        frame.add(userNameLabel);
        frame.add(userNameField);
        frame.add(removeButton);
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
        if(e.getSource()== removeButton){
            if(verifyFields() == true){
                try {
                    String username = userNameField.getText();
                    PreparedStatement st;
            
                    String query = "DELETE FROM users_db WHERE username = ?";
               
                    st = My_CNX.getConnection().prepareStatement(query);
                    st.setString(1, username);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Account deleted successfully!");              
                } catch (SQLException ex) {
                    Logger.getLogger(RemoveUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   else {
                JOptionPane.showMessageDialog(null, "Field is empty!");
            }     
        }   
        else if (e.getSource()== backButton) {
            frame.dispose();
            AdminPage adminPage = new AdminPage(userID, adminCheck);
        }
    }
    
    
}
