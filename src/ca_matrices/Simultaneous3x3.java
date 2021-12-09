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
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
public class Simultaneous3x3 implements ActionListener {

    public boolean verifyFields() {
        String a1 = a1Field.getText();
        String b1 = b1Field.getText();
        String c1 = c1Field.getText();
        String d1 = d1Field.getText();
        String a2 = a2Field.getText();
        String b2 = b2Field.getText();
        String c2 = c2Field.getText();
        String d2 = d2Field.getText();
        String a3 = a3Field.getText();
        String b3 = b3Field.getText();
        String c3 = c3Field.getText();
        String d3 = d3Field.getText();
        
        if (a1.trim().equals("") || b1.trim().equals("") || c1.trim().equals("") || 
            a2.trim().equals("") || b2.trim().equals("") || c2.trim().equals("") || 
            a3.trim().equals("") || b3.trim().equals("") || c3.trim().equals("") ||
            d1.trim().equals("") || d2.trim().equals("") || d3.trim().equals("")    ) 
        {
            return false;
        }     
        else {
            return true;
        }
    }
    
    public boolean verifyNumber() {
        String a1 = a1Field.getText();
        String b1 = b1Field.getText();
        String c1 = c1Field.getText();
        String d1 = c1Field.getText();
        String a2 = a2Field.getText();
        String b2 = b2Field.getText();
        String c2 = c2Field.getText();
        String d2 = c2Field.getText();
        String a3 = a3Field.getText();
        String b3 = b3Field.getText();
        String c3 = c3Field.getText();
        String d3 = c3Field.getText();
        
        if (a1.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && 
            b1.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && 
            c1.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && 
            a2.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && 
            b2.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && 
            c2.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && 
            a3.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && 
            b3.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && 
            c3.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") &&
            d1.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && 
            d2.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && 
            d3.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$")) 
        {
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
    JTextField a1Field = new JTextField();
    JTextField b1Field = new JTextField();
    JTextField c1Field = new JTextField();
    JTextField d1Field = new JTextField();
    JTextField a2Field = new JTextField();
    JTextField b2Field = new JTextField();
    JTextField c2Field = new JTextField();
    JTextField d2Field = new JTextField();
    JTextField a3Field = new JTextField();
    JTextField b3Field = new JTextField();
    JTextField c3Field = new JTextField();
    JTextField d3Field = new JTextField();
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();
    JLabel x1Label = new JLabel("X");
    JLabel x2Label = new JLabel("X");
    JLabel x3Label = new JLabel("X");
    JLabel y1Label = new JLabel("Y");
    JLabel y2Label = new JLabel("Y");
    JLabel y3Label = new JLabel("Y");
    JLabel z1Label = new JLabel("Z");
    JLabel z2Label = new JLabel("Z");
    JLabel z3Label = new JLabel("Z");
    JLabel equalLabel1 = new JLabel("=");
    JLabel equalLabel2 = new JLabel("=");
    JLabel equalLabel3 = new JLabel("=");
    JLabel resultLabel1 = new JLabel("X");
    JLabel resultLabel11 = new JLabel("");
    JLabel resultLabel2 = new JLabel("Y");
    JLabel resultLabel21 = new JLabel("");
    JLabel resultLabel3 = new JLabel("Z");
    JLabel resultLabel31 = new JLabel("");
    
    public String math() {
        //Find determinant D
        int a1 = Integer.parseInt(a1Field.getText());
        int b1 = Integer.parseInt(b1Field.getText()); 
        int c1 = Integer.parseInt(c1Field.getText());
        int d1 = Integer.parseInt(d1Field.getText());
        int a2 = Integer.parseInt(a2Field.getText());
        int b2 = Integer.parseInt(b2Field.getText());
        int c2 = Integer.parseInt(c2Field.getText());
        int d2 = Integer.parseInt(d2Field.getText());
        int a3 = Integer.parseInt(a3Field.getText());
        int b3 = Integer.parseInt(b3Field.getText());
        int c3 = Integer.parseInt(c3Field.getText());
        int d3 = Integer.parseInt(d3Field.getText());
        int ad, bd, cd, det;
        
        ad = (b2 * c3) - (c2 * b3);
        bd = -((a2 * c3) - (c2 * a3));
        cd = (a2 * b3) - (b2 * a3);
        
        det = (a1 * ad) + (b1 * bd) + (c1 * cd);
            
        //Find x
        int x;
            
        x = ((d1 * ((b2 * c3) - (c2* b3))) - (b1 * ((d2 * c3) - (c2 * d3))) + (c1 * ((b3 * d2) - (b2 * d3)))) / det;
        String z1 = Integer.toString(x);
        resultLabel11.setText(z1);
            
        //Find y
        int y;
            
        y = ((a1 * ((d2 * c3) - (c2 * d3))) - (d1 * ((c3 * a2) - (a3 * c2))) + (c1 * ((d3 * a2) - (d2 * a3)))) / det;
        String z2 = Integer.toString(y);
        resultLabel21.setText(z2);
            
        //Find z
        int z;
            
        z = ((a1 * (b2 * d3) - (d2 * b3)) - (b1 * ((d3 * a2) - (d2*a3))) + (d1 * ((b3 * a2) - (b2 * a3)))) / det;
        String z3 = Integer.toString(z);
        resultLabel31.setText(z3);
        return null;
    }
    
    Simultaneous3x3(String userID, String adminCheck) {
        
        adminCheckField.setText(adminCheck);
        userIDField.setText(userID);
        
        x1Label.setBounds(100,50,90,25);
        x2Label.setBounds(100,80,90,25);
        x3Label.setBounds(100,110,90,25);
        y1Label.setBounds(200,50,90,25);
        y2Label.setBounds(200,80,90,25);
        y3Label.setBounds(200,110,90,25);
        z1Label.setBounds(300,50,90,25);
        z2Label.setBounds(300,80,90,25);
        z3Label.setBounds(300,110,90,25);
        equalLabel1.setBounds(330,50,90,25);
        equalLabel2.setBounds(330,80,90,25);
        equalLabel3.setBounds(330,110,90,25);
        
        resultLabel1.setBounds(100,150,90,25);
        resultLabel11.setBounds(100,175,75,25);
        resultLabel2.setBounds(200,150,75,25);
        resultLabel21.setBounds(200,175,35,25);
        resultLabel3.setBounds(300,150,75,25);
        resultLabel31.setBounds(300,175,35,25);
        
        a1Field.setBounds(50,50,50,25);
        b1Field.setBounds(150,50,50,25);
        c1Field.setBounds(250,50,50,25);
        d1Field.setBounds(340,50,50,25);
        a2Field.setBounds(50,80,50,25);
        b2Field.setBounds(150,80,50,25);
        c2Field.setBounds(250,80,50,25);
        d2Field.setBounds(340,80,50,25);
        a3Field.setBounds(50,110,50,25);
        b3Field.setBounds(150,110,50,25);
        c3Field.setBounds(250,110,50,25);
        d3Field.setBounds(340,110,50,25);
        
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
        
        frame.setTitle("Simultaneous 3x3");
        frame.add(x1Label);
        frame.add(x2Label);
        frame.add(x3Label);
        frame.add(y1Label);
        frame.add(y2Label);
        frame.add(y3Label);
        frame.add(z1Label);
        frame.add(z2Label);
        frame.add(z3Label);
        frame.add(equalLabel1);
        frame.add(equalLabel2);
        frame.add(equalLabel3);
        frame.add(resultLabel1);
        frame.add(resultLabel11);
        frame.add(resultLabel2);
        frame.add(resultLabel21);
        frame.add(resultLabel3);
        frame.add(resultLabel31);
        frame.add(a1Field);
        frame.add(b1Field);
        frame.add(c1Field);
        frame.add(d1Field);
        frame.add(a2Field);
        frame.add(b2Field);
        frame.add(c2Field);
        frame.add(d2Field);
        frame.add(a3Field);
        frame.add(b3Field);
        frame.add(c3Field);
        frame.add(d3Field);
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
               String fileName = "simul3x3_" + userID + "." + format;
               BufferedImage captureImage = new BufferedImage (rect.width, rect.height, BufferedImage.TYPE_INT_ARGB);
               frame.paint(captureImage.getGraphics());
               ImageIO.write(captureImage, format, new File (fileName));
            }
             catch (IOException  ex) {
                Logger.getLogger(Matrix2x2.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
            try {
                PreparedStatement stUpdate;
                
                String queryUpdate = "UPDATE users_db SET simul3x3 = ? WHERE id = ?";
                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                File image = new File("simul3x3_"+ userID +".png");
                String image1 = image.toString();
                stUpdate.setString(1, image1);
                stUpdate.setString(2, userID);
                stUpdate.executeUpdate();
                JOptionPane.showMessageDialog(null, "Operation saved!");
                } catch (SQLException ex) {
                    Logger.getLogger(Matrix2x2.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        if (e.getSource()== backButton){
            frame.dispose();
            CalculatorMenu calculatorMenu = new CalculatorMenu(userID, adminCheck);
        }
        if (e.getSource()== clearButton){
            a1Field.setText("");
            b1Field.setText("");
            c1Field.setText("");
            d1Field.setText("");
            a2Field.setText("");
            b2Field.setText("");
            c2Field.setText("");
            d2Field.setText("");
            a3Field.setText("");
            b3Field.setText("");
            c3Field.setText("");
            d3Field.setText("");
            resultLabel11.setText("");
            resultLabel21.setText("");
            resultLabel31.setText("");
        }
    }
    
}
