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
    JTextField userNameField = new JTextField();
    JLabel userNameLabel = new JLabel("Username:");

    
    RemoveUser() {
        userNameLabel.setBounds(50,150,100,25);
        
        userNameField.setBounds(150,150,150,25);
        
        removeButton.setBounds(170,300,100,25);
        removeButton.setFocusable(false);
        removeButton.addActionListener(this);
        
        frame.add(userNameLabel);
        frame.add(userNameField);
        frame.add(removeButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== removeButton){
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
       }
    }
    
    
}
