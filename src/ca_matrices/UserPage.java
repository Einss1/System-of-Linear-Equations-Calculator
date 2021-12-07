package ca_matrices;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 @author Luan
 */

public class UserPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Back to login");
    JButton modifyProfileButton = new JButton("Modify profile");
    JButton calculatorButton = new JButton("Calculator");
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();
    
    UserPage(String userID, String adminCheck) {
        adminCheckField.setText(adminCheck);
        userIDField.setText(userID);
        loginButton.setBounds(25,25,125,25);
        modifyProfileButton.setBounds(125,75,150,25);
        calculatorButton.setBounds(125,125,150,25);
        
        loginButton.setFocusable(false);
        modifyProfileButton.setFocusable(false);
        calculatorButton.setFocusable(false);
        
        loginButton.addActionListener(this);
        modifyProfileButton.addActionListener(this);
        calculatorButton.addActionListener(this);
        
        frame.setTitle("User Page");
        frame.add(loginButton);
        frame.add(modifyProfileButton);
        frame.add(calculatorButton);
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
            ModifyProfile modifyPage = new ModifyProfile(userID, adminCheck); //Creates a new frame (Modify user's profile)
        }
        else if (e.getSource()== calculatorButton){
            frame.dispose();
            CalculatorMenu calculatorMenu = new CalculatorMenu(userID, adminCheck); //Creates a new frame (Calculator menu)
        }
        else if (e.getSource()== loginButton){
            frame.dispose();
            LoginPage loginPage = new LoginPage(); //Creates a new frame (goes back to the login menu)
        }
    }
}
