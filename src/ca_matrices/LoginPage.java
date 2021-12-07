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


/*
 * @author Luan
 */

//Public class Login page is implementing from ActionListener
public class LoginPage implements ActionListener {
    
    JFrame frame = new JFrame(); //New frame created
    JButton loginButton = new JButton("Login"); //New button created(login)
    JButton registerButton = new JButton("Register"); //New button created(register)
    JButton clearButton = new JButton("Clear"); //New button created(clearing button)
    JTextField userIDField = new JTextField(); //New field created(username)
    JPasswordField userPasswordField = new JPasswordField(); //New field created(password)
    JLabel userIDLabel = new JLabel("username:"); //Label to follow with the username field
    JLabel userPasswordLabel = new JLabel("password:"); //Label to follow with the password field
    
    LoginPage() {
        
        //Set bounds for labels, fields and buttons inside the frame
        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);
        
        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);
        
        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false); //Prevents an outline to appear when you click a button
        loginButton.addActionListener(this); //It calls for a function
        
        registerButton.setBounds(225,200,100,25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        
        clearButton.setBounds(175,250,100,25);
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);
        
        frame.setTitle("Login Page"); //Sets the title of the frame
        //Adds all the label, fields and buttons to the frame
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(registerButton);
        frame.add(clearButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420); //Sets size of the frame
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); //Sets to be centered
        frame.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== registerButton){            
            frame.dispose(); //Gets rid of the frame
            RegistrationPage registrationPage = new RegistrationPage(); //Creates a new frame (Registration Page)
        }
        
        if(e.getSource()==loginButton) {
            
            // Connects to the database and checks for username and password to see if it is correct
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
                
                //If user is found ...
                if(rs.next()){ 
                    int admin = rs.getInt("admin"); //Gets information of the user to check if it is a user or an admin
                    int id = rs.getInt("id"); //Gets the id of the user/admin
                    String userID = Integer.toString(id);
                    String adminCheck = Integer.toString(admin);
                        //Admins and users are sent to different screens, their userID and adminCheck is brought with them for future use
                        if (admin == 1) {
                            frame.dispose();
                            AdminPage adminPage = new AdminPage(userID, adminCheck);
                        } else {
                            frame.dispose();
                            UserPage userPage = new UserPage(userID, adminCheck);
                        } 
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username / Password", "Login Error",2); //If user is not found, error message is displayed
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            }                           
        }
        else if (e.getSource()== clearButton) {
            //Empties the text fields
            userIDField.setText("");
            userPasswordField.setText("");
        }
    }
}
