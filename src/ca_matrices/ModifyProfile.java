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
    public boolean checkUsername(String username) throws SQLException{
        
    PreparedStatement st;
    ResultSet rs;
    boolean username_exist = false;
        
    String query = "SELECT * FROM users_db WHERE username = ?";
        
    st = My_CNX.getConnection().prepareStatement(query);
    st.setString(1, username);
    rs = st.executeQuery();
        
    if(rs.next()){
        username_exist = true;
        JOptionPane.showMessageDialog(null,"Username already taken!","Username failed",2);
    }
        
    return username_exist;      
    }
    
    JFrame frame = new JFrame();
    JButton backButton = new JButton("Back");
    JButton modifyButton = new JButton("Change");
    JTextField userNameField = new JTextField();
    JTextField fNameField = new JTextField();
    JTextField lNameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();
    JLabel userNameLabel = new JLabel("New username:");
    JLabel fNameLabel = new JLabel("New first name:");
    JLabel lNameLabel = new JLabel("New last name:");
    JLabel passwordLabel = new JLabel("New password:");
   
    ModifyProfile(String userID, String adminCheck) {
        adminCheckField.setText(adminCheck);
        userIDField.setText(userID);
        userNameLabel.setBounds(50,50,100,25);
        fNameLabel.setBounds(50,100,100,25);
        lNameLabel.setBounds(50,150,100,25);
        passwordLabel.setBounds(50,200,100,25);
        
        userNameField.setBounds(150,50,150,25);
        fNameField.setBounds(150,100,150,25);
        lNameField.setBounds(150,150,150,25);
        passwordField.setBounds(150,200,150,25);
        
        backButton.setBounds(25,15,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        
        modifyButton.setBounds(170,300,100,25);
        modifyButton.setFocusable(false);
        modifyButton.addActionListener(this);
        
        frame.setTitle("Modify Profile");
        frame.add(userNameLabel);
        frame.add(fNameLabel);
        frame.add(lNameLabel);
        frame.add(passwordLabel);
        frame.add(userNameField);
        frame.add(fNameField);
        frame.add(lNameField);
        frame.add(passwordField);
        frame.add(modifyButton);
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
        String user = userNameField.getText();
        if(e.getSource()== modifyButton){
            try {
                if(!checkUsername(user)) {
                    try {
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
                            else if ((userNameField.getText().isEmpty()) && (fNameField.getText().isEmpty()) ) {
                                PreparedStatement stUpdate;
                                String lname = String.valueOf(lNameField.getText());
                                String password = String.valueOf(passwordField.getPassword());
                                String queryUpdate = "UPDATE users_db SET lname = ?, password = ? WHERE id = ?";
                                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                                stUpdate.setString(1, lname);
                                stUpdate.setString(2, password);
                                stUpdate.setString(3, userID);
                                stUpdate.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Last name and password updated!");
                                frame.dispose();
                                LoginPage loginPage = new LoginPage();
                            }
                            else if ((userNameField.getText().isEmpty()) && (lNameField.getText().isEmpty()) ) {
                                PreparedStatement stUpdate;
                                String password = String.valueOf(passwordField.getPassword());
                                String fname = String.valueOf(fNameField.getText());
                                String queryUpdate = "UPDATE users_db SET password = ?, fname = ? WHERE id = ?";
                                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                                stUpdate.setString(1, password);
                                stUpdate.setString(2, fname);
                                stUpdate.setString(3, userID);
                                stUpdate.executeUpdate();
                                JOptionPane.showMessageDialog(null, "First name and password updated!");
                                frame.dispose();
                                LoginPage loginPage = new LoginPage();
                            }
                            else if ((userNameField.getText().isEmpty()) && (passwordField.getPassword().length == 0)) {
                                PreparedStatement stUpdate;
                                String fname = String.valueOf(fNameField.getText());
                                String lname = String.valueOf(lNameField.getText());
                                String queryUpdate = "UPDATE users_db SET lname = ?, fname = ? WHERE id = ?";
                                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                                stUpdate.setString(1, lname);
                                stUpdate.setString(2, fname);
                                stUpdate.setString(3, userID);
                                stUpdate.executeUpdate();
                                JOptionPane.showMessageDialog(null, "First name and last name updated!");
                                frame.dispose();
                                LoginPage loginPage = new LoginPage();
                            }
                            else if ((fNameField.getText().isEmpty()) && (lNameField.getText().isEmpty())) {
                                PreparedStatement stUpdate;
                                String username = String.valueOf(userNameField.getText());
                                String password = String.valueOf(passwordField.getPassword());
                                String queryUpdate = "UPDATE users_db SET username = ?, password = ? WHERE id = ?";
                                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                                stUpdate.setString(1, username);
                                stUpdate.setString(2, password);
                                stUpdate.setString(3, userID);
                                stUpdate.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Username and password updated!");
                                frame.dispose();
                                LoginPage loginPage = new LoginPage();
                            }
                            else if ((fNameField.getText().isEmpty()) && (passwordField.getPassword().length == 0)) {
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
                                frame.dispose();
                                LoginPage loginPage = new LoginPage();
                            }
                            else if ((lNameField.getText().isEmpty()) && (passwordField.getPassword().length == 0)) {
                                PreparedStatement stUpdate;
                                String fname = String.valueOf(fNameField.getText());
                                String username = String.valueOf(userNameField.getText());
                                String queryUpdate = "UPDATE users_db SET username = ?, fname = ? WHERE id = ?";
                                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                                stUpdate.setString(1, username);
                                stUpdate.setString(2, fname);
                                stUpdate.setString(3, userID);
                                stUpdate.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Username and First name updated!");
                                frame.dispose();
                                LoginPage loginPage = new LoginPage();
                            }
                            else if (userNameField.getText().isEmpty()) {
                                PreparedStatement stUpdate;
                                String fname = String.valueOf(fNameField.getText());
                                String lname = String.valueOf(lNameField.getText());
                                String password = String.valueOf(passwordField.getPassword());
                                String queryUpdate = "UPDATE users_db SET fname = ?, lname = ?, password = ? WHERE id = ?";
                                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                                stUpdate.setString(1, fname);
                                stUpdate.setString(2, lname);
                                stUpdate.setString(3, password);
                                stUpdate.setString(4, userID);
                                stUpdate.executeUpdate();
                                JOptionPane.showMessageDialog(null, "First name, last name and password updated!");
                                frame.dispose();
                                LoginPage loginPage = new LoginPage();
                            }
                            else if (fNameField.getText().isEmpty()) {
                                PreparedStatement stUpdate;
                                String username = String.valueOf(userNameField.getText());
                                String lname = String.valueOf(lNameField.getText());
                                String password = String.valueOf(passwordField.getPassword());
                                String queryUpdate = "UPDATE users_db SET username = ?, lname = ?, password = ? WHERE id = ?";
                                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                                stUpdate.setString(1, username);
                                stUpdate.setString(2, lname);
                                stUpdate.setString(3, password);
                                stUpdate.setString(4, userID);
                                stUpdate.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Username, last name and password updated!");
                                frame.dispose();
                                LoginPage loginPage = new LoginPage();
                            }
                            else if (lNameField.getText().isEmpty()) {
                                PreparedStatement stUpdate;
                                String username = String.valueOf(userNameField.getText());
                                String fname = String.valueOf(fNameField.getText());
                                String password = String.valueOf(passwordField.getPassword());
                                String queryUpdate = "UPDATE users_db SET username = ?, fname = ?, password = ? WHERE id = ?";
                                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                                stUpdate.setString(1, username);
                                stUpdate.setString(2, fname);
                                stUpdate.setString(3, password);
                                stUpdate.setString(4, userID);
                                stUpdate.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Username, first name and password updated!");
                                frame.dispose();
                                LoginPage loginPage = new LoginPage();
                            }
                            else if (passwordField.getPassword().length == 0) {
                                PreparedStatement stUpdate;
                                String username = String.valueOf(userNameField.getText());
                                String fname = String.valueOf(fNameField.getText());
                                String lname = String.valueOf(lNameField.getText());
                                String queryUpdate = "UPDATE users_db SET username = ?, fname = ?, lname = ? WHERE id = ?";
                                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                                stUpdate.setString(1, username);
                                stUpdate.setString(2, fname);
                                stUpdate.setString(3, lname);
                                stUpdate.setString(4, userID);
                                stUpdate.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Password updated!");
                                frame.dispose();
                                LoginPage loginPage = new LoginPage();
                            }
                            else {
                                PreparedStatement stUpdate;
                                String username = String.valueOf(userNameField.getText());
                                String fname = String.valueOf(fNameField.getText());
                                String lname = String.valueOf(lNameField.getText());
                                String password = String.valueOf(passwordField.getPassword());
                                String queryUpdate = "UPDATE users_db SET username = ?, fname = ?,lname = ?, password = ? WHERE id = ?";
                                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                                stUpdate.setString(1, username);
                                stUpdate.setString(2, fname);
                                stUpdate.setString(3, lname);
                                stUpdate.setString(4, password);
                                stUpdate.setString(5, userID);
                                stUpdate.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Username, first name, last name and password updated!");
                                frame.dispose();
                                LoginPage loginPage = new LoginPage();
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ModifyProfile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
            } catch (SQLException ex) {
                Logger.getLogger(ModifyProfile.class.getName()).log(Level.SEVERE, null, ex);
            }  
        } 
        if (e.getSource()== backButton) {
            if ("1".equals(adminCheck)){
                frame.dispose();
                AdminPage adminPage = new AdminPage(userID, adminCheck);
            } else {
                frame.dispose();
                UserPage userPage = new UserPage(userID, adminCheck);
            }
        }   
    }        
}
