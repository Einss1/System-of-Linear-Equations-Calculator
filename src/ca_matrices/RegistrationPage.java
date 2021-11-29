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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luan
 */
public class RegistrationPage implements ActionListener {
    
    JFrame frame = new JFrame();
    JButton clearButton = new JButton("Clear");
    JButton registerButton = new JButton("Register");
    JTextField userfNameField = new JTextField();
    JTextField userlNameField = new JTextField();
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userfNameLabel = new JLabel("First Name:");
    JLabel userlNameLabel = new JLabel("Last Name");
    JLabel userIDLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
   
    
    public boolean verifyFields() {
        String fname = userfNameField.getText();
        String lname = userlNameField.getText();
        String uname = userIDField.getText(); 
        String password = String.valueOf(userPasswordField); 
        
        if (fname.trim().equals("") || lname.trim().equals("") || uname.trim().equals("") || password.trim().equals("") ) {
            return false;
        }     
        else {
            return true;
        }
    }
    
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
    
    RegistrationPage() {
        
        userfNameLabel.setBounds(50,100,75,25);
        userlNameLabel.setBounds(50,150,75,25);
        userIDLabel.setBounds(50,200,75,25);
        userPasswordLabel.setBounds(50,250,75,25);
        
        userfNameField.setBounds(125,100,200,25);
        userlNameField.setBounds(125,150,200,25);
        userIDField.setBounds(125,200,200,25);
        userPasswordField.setBounds(125,250,200,25);
        
        clearButton.setBounds(125,300,100,25);
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);
        registerButton.setBounds(225,300,100,25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        frame.setTitle("Registration Page");
        frame.add(userfNameLabel);
        frame.add(userlNameLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userfNameField);
        frame.add(userlNameField);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(clearButton);
        frame.add(registerButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== registerButton){
            
            String fname = userfNameField.getText();
            String lname = userlNameField.getText();
            String username = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            
            if(verifyFields() == true){
                try {
                    if(!checkUsername(username)){
                        PreparedStatement ps;
                        ResultSet rs;
                        String registerUserQuery = "INSERT INTO users_db (username, fname, lname, password) VALUES (?,?,?,?)";
                        
                        try {
                            
                            ps = My_CNX.getConnection().prepareStatement(registerUserQuery);
                            ps.setString(1, username);
                            ps.setString(2, fname);
                            ps.setString(3, lname);
                            ps.setString(4, password);
                            
                            
                            if(ps.executeUpdate() != 0) {
                                JOptionPane.showMessageDialog(null, "Your account has been created successfully!");
                                frame.dispose();
                                LoginPage loginPage = new LoginPage();  
                            }else{
                                JOptionPane.showMessageDialog(null, "Error!");
                            }
                            
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(RegistrationPage.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                } catch (SQLException ex) {                    
                    Logger.getLogger(RegistrationPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "One or more fields are empty!");
            }           
        }
        else if (e.getSource()== clearButton) {
            userfNameField.setText("");
            userlNameField.setText("");
            userIDField.setText("");
            userPasswordField.setText("");
        }
    } 
}
