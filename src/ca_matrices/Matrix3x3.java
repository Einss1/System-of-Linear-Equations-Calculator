/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_matrices;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
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
public class Matrix3x3 implements ActionListener {

    public boolean verifyFields() {
        String a = aField.getText();
        String b = bField.getText();
        String c = cField.getText();
        String e = eField.getText();
        String f = fField.getText();
        String g = gField.getText();
        String i = iField.getText();
        String j = jField.getText();
        String k = kField.getText();
        
        if (a.trim().equals("") || b.trim().equals("") || c.trim().equals("") || e.trim().equals("") || f.trim().equals("") || g.trim().equals("") || i.trim().equals("") || j.trim().equals("") || k.trim().equals("")) {
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
        String e = eField.getText();
        String f = fField.getText();
        String g = gField.getText();
        String i = iField.getText();
        String j = jField.getText();
        String k = kField.getText();
        
        if (a.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && b.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && c.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && e.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && f.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && g.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && i.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && j.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$") && k.trim().matches("^-?([0]{1}\\.{1}[0-9]+|[1-9]{1}[0-9]*\\.{1}[0-9]+|[0-9]+|0)$")) {
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
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();
    JTextField aField = new JTextField();
    JTextField bField = new JTextField();
    JTextField cField = new JTextField();
    JTextField eField = new JTextField();
    JTextField fField = new JTextField();
    JTextField gField = new JTextField();
    JTextField iField = new JTextField();
    JTextField jField = new JTextField();
    JTextField kField = new JTextField();
    JLabel mField1 = new JLabel("(");
    JLabel mField11 = new JLabel(")");
    JLabel mField2 = new JLabel("(");
    JLabel mField21 = new JLabel(")");
    JLabel resultLabel1 = new JLabel("Determinant");
    JLabel resultLabel11 = new JLabel("");
    JLabel resultLabel2 = new JLabel("Inverse ");
    JLabel resultLabel21 = new JLabel("a11");
    JLabel resultLabel22 = new JLabel("a12");
    JLabel resultLabel23 = new JLabel("a13");
    JLabel resultLabel24 = new JLabel("a21");
    JLabel resultLabel25 = new JLabel("a22");
    JLabel resultLabel26 = new JLabel("a23");
    JLabel resultLabel27 = new JLabel("a31");
    JLabel resultLabel28 = new JLabel("a32");
    JLabel resultLabel29 = new JLabel("a33");
    
    public String Determinant() {
        int a = Integer.parseInt(aField.getText());
        int b = Integer.parseInt(bField.getText()); 
        int c = Integer.parseInt(cField.getText());
        int e = Integer.parseInt(eField.getText());
        int f = Integer.parseInt(fField.getText());
        int g = Integer.parseInt(gField.getText());
        int i = Integer.parseInt(iField.getText());
        int j = Integer.parseInt(jField.getText());
        int k = Integer.parseInt(kField.getText());
        float a2, b2, c2, det;
        DecimalFormat df = new DecimalFormat("###.##");
        
        a2 = (f * k) - (g * j);
        b2 = -((e * k) - (g * i));
        c2 = (e * j) - (f * i);
        
        det = (a * a2) + (b * b2) + (c * c2);
        String dA = String.valueOf(det);
        return dA;
    }
    
    public String Inverse(){
        int a = Integer.parseInt(aField.getText());
        int b = Integer.parseInt(bField.getText()); 
        int c = Integer.parseInt(cField.getText());
        int e = Integer.parseInt(eField.getText());
        int f = Integer.parseInt(fField.getText());
        int g = Integer.parseInt(gField.getText());
        int i = Integer.parseInt(iField.getText());
        int j = Integer.parseInt(jField.getText());
        int k = Integer.parseInt(kField.getText());
        float a2, b2, c2, e2, f2, g2, i2, j2, k2, det;
        float x, a22, b22, c22, e22, f22, g22, i22, j22, k22;
        DecimalFormat df = new DecimalFormat("###.##");
        String x1;
        
        a2 = (f * k) - (g * j);
        b2 = -((e * k) - (g * i));
        c2 = (e * j) - (f * i);
        e2 = -((b * k) - (c * j));
        f2 = (a * k) - (c * i);
        g2 = -((a * j) - (b * i));
        i2 = (b * g) - (c * f);
        j2 = -((a * g) - (c * e));
        k2 = (a * f) - (b * e);
        
        det = (a * a2) + (b * b2) + (c * c2);
        
        x = (1/det);
        a22 = x * a;
        b22 = x * e;
        c22 = x * i;
        e22 = x * b;
        f22 = x * f;
        g22 = x * j;
        i22 = x * c;
        j22 = x * g;
        k22 = x * k;
        
        String z1 = (df.format(a22));
        String z2 = (df.format(b22));
        String z3 = (df.format(c22));
        String z4 = (df.format(e22));
        String z5 = (df.format(f22));
        String z6 = (df.format(g22));
        String z7 = (df.format(i22));
        String z8 = (df.format(j22));
        String z9 = (df.format(k22));
        
        resultLabel21.setText(z1);
        resultLabel22.setText(z2);
        resultLabel23.setText(z3);
        resultLabel24.setText(z4);
        resultLabel25.setText(z5);
        resultLabel26.setText(z6);
        resultLabel27.setText(z7);
        resultLabel28.setText(z8);
        resultLabel29.setText(z9);
       
        return null;
    }
    
    
    Matrix3x3(String userID, String adminCheck){
        userIDField.setText(userID);
        adminCheckField.setText(adminCheck);
        
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
        
        aField.setBounds(130,50,50,25);
        bField.setBounds(180,50,50,25);
        cField.setBounds(230,50,50,25);
        eField.setBounds(130,80,50,25);
        fField.setBounds(180,80,50,25);
        gField.setBounds(230,80,50,25);
        iField.setBounds(130,110,50,25);
        jField.setBounds(180,110,50,25);
        kField.setBounds(230,110,50,25);
        aField.setText("a11");
        bField.setText("a12");
        cField.setText("a13");
        eField.setText("a21");
        fField.setText("a22");
        gField.setText("a23");
        iField.setText("a31");
        jField.setText("a32");
        kField.setText("a33");
        
        mField1.setFont(new Font("Serif", Font.PLAIN, 95));
        mField11.setFont(new Font("Serif", Font.PLAIN, 95));
        mField1.setBounds(105,30,100,100);
        mField11.setBounds(275,30,100,100);
        mField2.setFont(new Font("Serif", Font.PLAIN, 95));
        mField21.setFont(new Font("Serif", Font.PLAIN, 95));
        mField2.setBounds(210,150,100,100);
        mField21.setBounds(310,150,100,100);
        
        resultLabel1.setBounds(100,150,90,25);
        resultLabel11.setBounds(120,200,75,25);
        
        resultLabel2.setBounds(250,150,75,25);
        resultLabel21.setBounds(235,175,35,25);
        resultLabel22.setBounds(265,175,35,25);
        resultLabel23.setBounds(295,175,35,25);
        resultLabel24.setBounds(235,200,35,25);
        resultLabel25.setBounds(265,200,35,25);
        resultLabel26.setBounds(295,200,35,25);
        resultLabel27.setBounds(235,225,35,25);
        resultLabel28.setBounds(265,225,35,25);
        resultLabel29.setBounds(295,225,35,25);
        
        
        frame.setTitle("Matrix 3x3");
        frame.add(resultButton);
        frame.add(storeDataButton);
        frame.add(backButton);
        frame.add(clearButton);
        frame.add(aField);
        frame.add(bField);
        frame.add(cField);
        frame.add(eField);
        frame.add(fField);
        frame.add(gField);
        frame.add(iField);
        frame.add(jField);
        frame.add(kField);
        frame.add(mField1);
        frame.add(mField11);
        frame.add(mField2);
        frame.add(mField21);
        frame.add(resultLabel1);
        frame.add(resultLabel11);
        frame.add(resultLabel2);
        frame.add(resultLabel21);
        frame.add(resultLabel22);
        frame.add(resultLabel23);
        frame.add(resultLabel24);
        frame.add(resultLabel25);
        frame.add(resultLabel26);
        frame.add(resultLabel27);
        frame.add(resultLabel28);
        frame.add(resultLabel29);
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
                    resultLabel11.setText(Determinant());
                    Inverse();
                } else {
                    JOptionPane.showMessageDialog(null, "Numbers only please!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "One or more fields are empty!");
            }   
        }
        if (e.getSource()== storeDataButton){
             Rectangle rect = frame.getBounds();
            try {
               String format = "png";
               String fileName = "3x3_" + userID + "." + format;
               BufferedImage captureImage = new BufferedImage (rect.width, rect.height, BufferedImage.TYPE_INT_ARGB);
               frame.paint(captureImage.getGraphics());
               ImageIO.write(captureImage, format, new File (fileName));
            }
             catch (IOException  ex) {
                Logger.getLogger(Matrix2x2.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
            try {
                PreparedStatement stUpdate;
                
                String queryUpdate = "UPDATE users_db SET storedMatrix3x3 = ? WHERE id = ?";
                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                File image = new File("3x3_" + userID +".png");
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
            aField.setText("");
            bField.setText("");
            cField.setText("");
            eField.setText("");
            fField.setText("");
            gField.setText("");
            iField.setText("");
            jField.setText("");
            kField.setText("");
            resultLabel11.setText("");
            resultLabel21.setText("");
            resultLabel22.setText("");
            resultLabel23.setText("");
            resultLabel24.setText("");
            resultLabel25.setText("");
            resultLabel26.setText("");
            resultLabel27.setText("");
            resultLabel28.setText("");
            resultLabel29.setText("");
        }
    }
    
}
