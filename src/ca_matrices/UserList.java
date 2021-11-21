/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_matrices;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.directory.SearchResult;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luan
 */
public class UserList implements ActionListener{

    JFrame frame = new JFrame();
    JButton userListButton = new JButton("Fetch");
    JLabel userIDLabel = new JLabel("");
    JLabel userNameLabel = new JLabel("");

     UserList() {
        
        userIDLabel.setBounds(50,100,200,200); 
        userNameLabel.setBounds(100,100,200,200);

        userListButton.setBounds(170,300,100,25);
        userListButton.setFocusable(false);
        userListButton.addActionListener(this);
        
        frame.add(userNameLabel);
        frame.add(userListButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
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
    }
    
    
    
}
