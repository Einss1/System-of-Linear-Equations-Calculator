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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Luan
 */
public class ReviewOperations3x3 implements ActionListener {
    JFrame frame = new JFrame();
    JButton storedOperationButton = new JButton("Fetch");
    JButton backButton = new JButton("Back");
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();
    JTextField userField = new JTextField();
    JLabel userLabel = new JLabel();
    JLabel lbl=new JLabel();

     ReviewOperations3x3(String userID, String adminCheck) {
                
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
         
         frame.setTitle("Review Operations 3x3");
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
        if(e.getSource()== storedOperationButton){
            try {
                String user = userField.getText();
                BufferedImage img=ImageIO.read(new File("frame02x2_" + user + ".png"));
                ImageIcon icon=new ImageIcon(img);
                lbl.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(ReviewOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == backButton){
            frame.dispose();
            ReviewOperations reviewOperations = new ReviewOperations(userID, adminCheck);
        }
    }
}