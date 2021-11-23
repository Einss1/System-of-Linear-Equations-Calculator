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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.lang.String;


/**
 *
 * @author Luan
 */
public class LoginPage implements ActionListener {
    
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("password:");
    

    LoginPage() {
        
        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);
        
        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);
        
        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        
        registerButton.setBounds(225,200,100,25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(registerButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== registerButton){
            frame.dispose();
            RegistrationPage registrationPage = new RegistrationPage();
        }
        
        if(e.getSource()==loginButton) {
            try {
                PreparedStatement st;
                ResultSet rs;
                
                String username = userIDField.getText();
                String password = String.valueOf(userPasswordField.getPassword());
                
                String query = "SELECT * FROM users_db WHERE username = ? AND password = ?";
                            
                st = My_CNX.getConnection().prepareStatement(query);
                
                st.setString(1, username);
                st.setString(2, password);
                rs = st.executeQuery();
                
                if(rs.next()){ 
                    int admin = rs.getInt("admin"); 
                    int id = rs.getInt("id");
                    String userID = Integer.toString(id);
                        if (admin == 1) {
                            frame.dispose();
                            AdminPage adminPage = new AdminPage(userID);
                        } else {
                            frame.dispose();
                            UserPage userPage = new UserPage(userID);
                        } 
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username / Password", "Login Error",2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            }                           
        }
    }
}
