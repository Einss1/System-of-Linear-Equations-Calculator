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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Luan
 */
public class ModifyProfile implements ActionListener {
    
    JFrame frame = new JFrame();
    JButton modifyButton = new JButton("Change");
    JTextField userNameField = new JTextField();
    JTextField fNameField = new JTextField();
    JTextField lNameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JTextField userIDField = new JTextField();
    JLabel userNameLabel = new JLabel("New username:");
    JLabel fNameLabel = new JLabel("New first name:");
    JLabel lNameLabel = new JLabel("New last name:");
    JLabel passwordLabel = new JLabel("New password:");
   
    ModifyProfile(String userID) {
        userIDField.setText(userID);
        userNameLabel.setBounds(50,50,100,25);
        fNameLabel.setBounds(50,100,100,25);
        lNameLabel.setBounds(50,150,100,25);
        passwordLabel.setBounds(50,200,100,25);
        
        userNameField.setBounds(150,50,150,25);
        fNameField.setBounds(150,100,150,25);
        lNameField.setBounds(150,150,150,25);
        passwordField.setBounds(150,200,150,25);
        
        modifyButton.setBounds(170,300,100,25);
        modifyButton.setFocusable(false);
        modifyButton.addActionListener(this);
        
        frame.add(userNameLabel);
        frame.add(fNameLabel);
        frame.add(lNameLabel);
        frame.add(passwordLabel);
        frame.add(userNameField);
        frame.add(fNameField);
        frame.add(lNameField);
        frame.add(passwordField);
        frame.add(modifyButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== modifyButton){
            try {
                String userID = userIDField.getText();
                PreparedStatement st;
                ResultSet rs;
                
                String query = "SELECT * FROM users_db WHERE id = ?";
                
                st = My_CNX.getConnection().prepareStatement(query);
                
                st.setString(1, userID);
                
                rs = st.executeQuery();
                if(rs.next()) {
                    if((userNameField.getText().isEmpty()) && (fNameField.getText().isEmpty()) && (lNameField.getText().isEmpty()) && (passwordField.getPassword().length == 0 )){
                        JOptionPane.showMessageDialog(null, "Empty fields!");
                    }
                    else if ((userNameField.getText().isEmpty()) && (fNameField.getText().isEmpty()) && (lNameField.getText().isEmpty())) {
                        PreparedStatement stUpdate;
                        String password = String.valueOf(passwordField.getPassword());
                        String queryUpdate = "UPDATE users_db SET password = ? WHERE id = ?";
                        stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                        stUpdate.setString(1, password);
                        stUpdate.setString(2, userID);
                        stUpdate.executeUpdate();  
                        JOptionPane.showMessageDialog(null, "Password updated!");
                        frame.dispose();
                        LoginPage loginPage = new LoginPage();
                    }
                    else if ((userNameField.getText().isEmpty()) && (fNameField.getText().isEmpty()) && (passwordField.getPassword().length == 0 )) {
                        PreparedStatement stUpdate;
                        String lname = String.valueOf(lNameField.getText());
                        String queryUpdate = "UPDATE users_db SET lname = ? WHERE id = ?";
                        stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                        stUpdate.setString(1, lname);
                        stUpdate.setString(2, userID);
                        stUpdate.executeUpdate();  
                        JOptionPane.showMessageDialog(null, "Last name updated!");
                        frame.dispose();
                        LoginPage loginPage = new LoginPage();
                    }
                    else if ((userNameField.getText().isEmpty()) && (lNameField.getText().isEmpty()) && (passwordField.getPassword().length == 0 )) {
                        PreparedStatement stUpdate;
                        String fname = String.valueOf(fNameField.getText());
                        String queryUpdate = "UPDATE users_db SET fname = ? WHERE id = ?";
                        stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                        stUpdate.setString(1, fname);
                        stUpdate.setString(2, userID);
                        stUpdate.executeUpdate();  
                        JOptionPane.showMessageDialog(null, "First name updated!");
                        frame.dispose();
                        LoginPage loginPage = new LoginPage();
                    }
                    else if ((fNameField.getText().isEmpty()) && (lNameField.getText().isEmpty()) && (passwordField.getPassword().length == 0 )) {
                        PreparedStatement stUpdate;
                        String username = String.valueOf(userNameField.getText());
                        String queryUpdate = "UPDATE users_db SET username = ? WHERE id = ?";
                        stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                        stUpdate.setString(1, username);
                        stUpdate.setString(2, userID);
                        stUpdate.executeUpdate();  
                        JOptionPane.showMessageDialog(null, "Username updated!");
                        frame.dispose();
                        LoginPage loginPage = new LoginPage();
                    }
                    else if ((lNameField.getText().isEmpty()) && (passwordField.getPassword().length == 0 ) ) {
                        PreparedStatement stUpdate;
                        String username = String.valueOf(userNameField.getText());
                        String fname = String.valueOf(fNameField.getText());
                        String queryUpdate = "UPDATE users_db SET username = ?, fname = ? WHERE id = ?";
                        stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                        stUpdate.setString(1, username);
                        stUpdate.setString(2, fname);
                        stUpdate.setString(3, userID);
                        stUpdate.executeUpdate();  
                        JOptionPane.showMessageDialog(null, "Username and first name updated!");
                        frame.dispose();
                        LoginPage loginPage = new LoginPage();
                    }
                    /**
                    else if ((fNameField.getText().isEmpty()) && (passwordField.getPassword().length == 0 ) ) {
                        PreparedStatement stUpdate;
                        String username = String.valueOf(userNameField.getText());
                        String lname = String.valueOf(lNameField.getText());
                        String queryUpdate = "UPDATE users_db SET username = ?, lname = ? WHERE id = ?";
                        stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                        stUpdate.setString(1, username);
                        stUpdate.setString(2, lname);
                        stUpdate.setString(3, userID);
                        stUpdate.executeUpdate();  
                        JOptionPane.showMessageDialog(null, "Username and last name updated!");
                    }
                    **/
                }          
            } catch (SQLException ex) {
                Logger.getLogger(ModifyProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }        
}
