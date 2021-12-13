/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_matrices;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Luan
 */
public class Simultaneous2x2 implements ActionListener {

    public boolean verifyFields() {
        String a = aField.getText();
        String b = bField.getText();
        String c = cField.getText();
        String d = dField.getText();
        String e = eField.getText();
        String f = fField.getText();
        
        if (a.trim().equals("") || b.trim().equals("") || c.trim().equals("") || d.trim().equals("") || e.trim().equals("") || f.trim().equals("")) {
            return false;
        }     
        else {
            return true;
        }
    }
    
    public boolean verifyNumber() {
        String a = aField.getText();
        String b = bField.getText();
        String c = cField.getText();
        String d = dField.getText();
        String e = eField.getText();
        String f = fField.getText();
        
        if (a.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && b.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && c.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && d.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && e.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && f.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$")) {
            return true;
        }     
        else {
            return false;
        }
    }
    
    JFrame frame = new JFrame();
    JButton backButton = new JButton("Back");
    JButton resultButton = new JButton("Result");
    JButton storeDataButton = new JButton("Save");
    JButton clearButton = new JButton("Clear");
    JTextField aField = new JTextField();
    JTextField bField = new JTextField();
    JTextField cField = new JTextField();
    JTextField dField = new JTextField();
    JTextField eField = new JTextField();
    JTextField fField = new JTextField();
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();
    JLabel x1Label = new JLabel("X");
    JLabel x2Label = new JLabel("X");
    JLabel y1Label = new JLabel("Y");
    JLabel y2Label = new JLabel("Y");
    JLabel equalLabel1 = new JLabel("=");
    JLabel equalLabel2 = new JLabel("=");
    JLabel resultLabel1 = new JLabel("X");
    JLabel resultLabel11 = new JLabel("");
    JLabel resultLabel2 = new JLabel("Y");
    JLabel resultLabel21 = new JLabel("");
    
    public String math() {
        float x1 = Float.parseFloat(aField.getText());
        float x2 = Float.parseFloat(cField.getText());
        float y1 = Float.parseFloat(bField.getText());
        float y2 = Float.parseFloat(dField.getText());
        float r1 = Float.parseFloat(eField.getText());
        float r2 = Float.parseFloat(fField.getText());
        DecimalFormat df = new DecimalFormat("###.##");
      
        if (x1 != x2){
            float x3 = (x2/x1);
            float y3 = (y1 * x3);
            float r11 = (r1 * x3);
            float x4 = x1 * x3;
            
            if (x4 == x2) {
                if (y3 > y2) {
                    float y33 = (y3 - y2);
                    float r4 = (r11 - r2);
                    float y = (r4 / y33);
                
                    float x = (r1 - (y1 * y)) / x1;
                
                    String z1 = (df.format(y));
                    String z2 = (df.format(x));
                    resultLabel11.setText(z2);
                    resultLabel21.setText(z1);
                }
                if (y2 > y3) {
                    float y33 = (y2 - y3);
                    
                    float r4 = (r2 - r11);
                    float y = (r4 / y33);
                
                    float x = (r1 - (y1 * y)) / x1;
                    
                    String z1 = (df.format(y));
                    String z2 = (df.format(x));
                    resultLabel11.setText(z2);
                    resultLabel21.setText(z1);
                }
     
            }
        }
        if (x1 == x2) {
            float y3 = (y1 * -1);
            float r3 = (r1 * -1);
            
            float y33 = (y3 + y2);
            float r4 = (r3 + r2);
            float y = (r4 / y33);
            
            float x = (r1 - (y1 * y)) / x1;
            
            String z1 = (df.format(y));
            String z2 = (df.format(x));
            resultLabel11.setText(z2);
            resultLabel21.setText(z1); 
        }
        return null;
    }
    
    Simultaneous2x2(String userID, String adminCheck) {
        
        adminCheckField.setText(adminCheck);
        userIDField.setText(userID);
        
        x1Label.setBounds(100,50,90,25);
        x2Label.setBounds(100,80,90,25);
        y1Label.setBounds(200,50,90,25);
        y2Label.setBounds(200,80,90,25);
        equalLabel1.setBounds(230,50,90,25);
        equalLabel2.setBounds(230,80,90,25);
        
        resultLabel1.setBounds(125,150,90,25);
        resultLabel11.setBounds(125,175,75,25);
        resultLabel2.setBounds(225,150,75,25);
        resultLabel21.setBounds(225,175,35,25);
        
        aField.setBounds(50,50,50,25);
        bField.setBounds(150,50,50,25);
        cField.setBounds(50,80,50,25);
        dField.setBounds(150,80,50,25);
        eField.setBounds(260,50,50,25);
        fField.setBounds(260,80,50,25);
        
        resultButton.setBounds(100,300,100,25);
        resultButton.setFocusable(false);
        resultButton.addActionListener(this);
        
        storeDataButton.setBounds(200,300,100,25);
        storeDataButton.setFocusable(false);
        storeDataButton.addActionListener(this);
        
        backButton.setBounds(25,15,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        
        clearButton.setBounds(125,15,100,25);
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);
        
        frame.setTitle("Simultaneous 2x2");
        frame.add(x1Label);
        frame.add(x2Label);
        frame.add(y1Label);
        frame.add(y2Label);
        frame.add(equalLabel1);
        frame.add(equalLabel2);         
        frame.add(resultLabel1);
        frame.add(resultLabel11);
        frame.add(resultLabel2);
        frame.add(resultLabel21);
        frame.add(aField);
        frame.add(bField);
        frame.add(cField);
        frame.add(dField);
        frame.add(eField);
        frame.add(fField);
        frame.add(resultButton);
        frame.add(storeDataButton);
        frame.add(backButton);
        frame.add(clearButton);
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
        
        if (e.getSource()== resultButton){
            if (verifyFields() == true) {
                if (verifyNumber() == true) {
                    math();
                } else {
                    JOptionPane.showMessageDialog(null, "Numbers only please!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "One or more fields are empty!");
            }
        }
        if (e.getSource() == storeDataButton) {
            Rectangle rect = frame.getBounds();
            try {
               String format = "png";
               String fileName = "simul2x2_" + userID + "." + format;
               BufferedImage captureImage = new BufferedImage (rect.width, rect.height, BufferedImage.TYPE_INT_ARGB);
               frame.paint(captureImage.getGraphics());
               ImageIO.write(captureImage, format, new File (fileName));
            }
             catch (IOException  ex) {
                Logger.getLogger(Matrix2x2.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
            try {
                PreparedStatement stUpdate = null;
                
                String queryUpdate = "UPDATE users_db SET Simul2x2Saved = ? WHERE id = ?";
                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                File image = new File("simul2x2_"+ userID +".png");
                try {
                    FileInputStream fs = new FileInputStream(image);
                    stUpdate.setBinaryStream(1, fs, (int)image.length());
                    stUpdate.setString(2, userID);
                    stUpdate.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operation saved!");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Simultaneous2x2.class.getName()).log(Level.SEVERE, null, ex);
                } 
                
            } catch (SQLException ex) {
                Logger.getLogger(Simultaneous2x2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource()== backButton){
            frame.dispose();
            CalculatorMenu calculatorMenu = new CalculatorMenu(userID, adminCheck);
        }
        if (e.getSource()== clearButton){
            aField.setText("");
            bField.setText("");
            cField.setText("");
            dField.setText("");
            eField.setText("");
            fField.setText("");
            resultLabel11.setText("");
            resultLabel21.setText("");
        }
    }
    
}
