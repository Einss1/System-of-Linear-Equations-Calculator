/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_matrices;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Luan
 */
public class ReviewOperationsSimul2x2 implements ActionListener {
    
    public boolean verifyFields() {
        String uid = userField.getText(); 
        
        if (uid.trim().equals("")) {
            return false;
        }     
        else {
            return true;
        }
    }
    
    JFrame frame = new JFrame();
    JButton storedOperationButton = new JButton("Fetch");
    JButton backButton = new JButton("Back");
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();
    JTextField userField = new JTextField();
    JLabel userLabel = new JLabel();
    JLabel lbl=new JLabel();

     ReviewOperationsSimul2x2(String userID, String adminCheck) {
                
         adminCheckField.setText(adminCheck);
         userIDField.setText(userID);
         
         userLabel.setText("User id:");
         userLabel.setBounds(250, 15, 50, 50);
         userField.setBounds(300, 25, 50, 25);
         
         lbl.setBounds(100, 50, 420, 420);
         
         backButton.setBounds(25,15,100,25);
         backButton.setFocusable(false);
         backButton.addActionListener(this);
         
         storedOperationButton.setBounds(250,450,100,25);
         storedOperationButton.setFocusable(false);
         storedOperationButton.addActionListener(this);
         
         frame.setTitle("Review Matrix 2x2");
         frame.add(userLabel);
         frame.add(lbl);
         frame.setLayout(new FlowLayout());
         frame.add(userField);
         frame.add(storedOperationButton);
         frame.add(backButton);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(600,600);
         frame.setLayout(null);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String userID = userIDField.getText();
        String adminCheck = adminCheckField.getText();
        String user = userField.getText();
        if(e.getSource()== storedOperationButton){
            if(verifyFields()== true) {
                Connection con = null;
                PreparedStatement ps=null;
                try {
                    con = My_CNX.getConnection();
                    ps= con.prepareStatement("SELECT Simul2x2Saved FROM users_db WHERE id = ?");
                    ps.setString(1, user);
                    ResultSet rset=ps.executeQuery();
               
                    byte b[];
                    
                    while(rset.next()) {
                        File f=new File("simul2x2_" + user + ".png");
                        FileOutputStream fs = new FileOutputStream(f);
                        java.sql.Blob blob = rset.getBlob("Simul2x2Saved");
                        b=blob.getBytes(1, (int)blob.length());
                        fs.write(b);
                    }
                    
                    BufferedImage img=ImageIO.read(new File("simul2x2_" + user + ".png"));
                    ImageIcon icon=new ImageIcon(img);
                    lbl.setIcon(icon);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "No record found");
                } catch (SQLException ex) {
                    Logger.getLogger(ReviewOperationsSimul2x2.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Field is empty!");
            }     
        }
        else if(e.getSource() == backButton){
            frame.dispose();
            ReviewOperations reviewOperations = new ReviewOperations(userID, adminCheck);
        }
    }
}
