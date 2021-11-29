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
public class Matrix2x2 implements ActionListener {
    
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
    JLabel resultLabel1 = new JLabel("Determinant A");
    JLabel resultLabel11 = new JLabel("");
    JLabel resultLabel2 = new JLabel("Inverse A");
    JLabel resultLabel21 = new JLabel("");
    JLabel resultLabel22 = new JLabel("");
    JLabel resultLabel23 = new JLabel("");
    JLabel resultLabel24 = new JLabel("");
    JLabel resultLabel3 = new JLabel("Result");
    JLabel resultLabel31 = new JLabel("");
    JLabel resultLabel32 = new JLabel("");
    JLabel equalLabel = new JLabel("=");
    JLabel mResultLabel2 = new JLabel("(");
    JLabel mResultLabel21 = new JLabel(")");
    JLabel mResultLabel3 = new JLabel("(");
    JLabel mResultLabel31 = new JLabel(")");
    JLabel mField1 = new JLabel("(");
    JLabel mField11 = new JLabel(")");
    JLabel mField2 = new JLabel("(");
    JLabel mField21 = new JLabel(")");
    JLabel mField3 = new JLabel("(");
    JLabel mField31 = new JLabel(")");
    JLabel x = new JLabel("x");
    JLabel y = new JLabel("y");
    
    public String DeterminantA() {
        int a = Integer.parseInt(aField.getText());
        int b = Integer.parseInt(bField.getText()); 
        int c = Integer.parseInt(cField.getText());
        int d = Integer.parseInt(dField.getText());
        
        int determinant = (a * d) - (b * c);
        String dA = String.valueOf(determinant);
        return dA;
    }
    
    public String InverseA(){
        int a = Integer.parseInt(aField.getText());
        int b = Integer.parseInt(bField.getText()); 
        int c = Integer.parseInt(cField.getText());
        int d = Integer.parseInt(dField.getText());
        String dA = DeterminantA();
        int determinantA = Integer.parseInt(dA);
        float detA = determinantA;
        float x, x1, x2, x3, x4;
        DecimalFormat df = new DecimalFormat("###.##");
        
        x = (1/detA);
        x1 = (x * d);
        x2 = (x * -b);
        x3 = (x * -c);
        x4 = (x * a);
             
        String z1 = (df.format(x1));
        String z2 = (df.format(x2));
        String z3 = (df.format(x3));
        String z4 = (df.format(x4));
       
        resultLabel21.setText(z1);
        resultLabel23.setText(z2);
        resultLabel22.setText(z3);
        resultLabel24.setText(z4);
        return null;
    }
    
    public String FinalResult() {
        int a = Integer.parseInt(aField.getText());
        int b = Integer.parseInt(bField.getText()); 
        int c = Integer.parseInt(cField.getText());
        int d = Integer.parseInt(dField.getText());
        int e = Integer.parseInt(eField.getText());
        int f = Integer.parseInt(fField.getText());
        String dA = DeterminantA();
        float det = Integer.parseInt(dA);
        float x, x1, x2, x3, x4, x11, x22, x33, x44;
        float xf1, xf2; 
        DecimalFormat df = new DecimalFormat("###.##");
        
        x = (1/det);
        x1 = (x * d);
        x2 = (x * -b);
        x3 = (x * -c);
        x4 = (x * a);
        
        x11 = (x1 * e);
        x22 = (x2 * f); 
        x33 = (x3 * e); 
        x44 = (x4 * f);
        
        xf1 = x11 + x22;
        xf2 = x33 + x44; 
        
        String z1 = (df.format(xf1));
        String z2 = (df.format(xf2));
        
        resultLabel31.setText(z1);
        resultLabel32.setText(z2);
        String result = null;
        return result;
    }
    
    Matrix2x2(String userID, String adminCheck) {
        
        adminCheckField.setText(adminCheck);
        userIDField.setText(userID);
        
        equalLabel.setBounds(220,65,25,25);
        x.setBounds(170,50,25,25);
        y.setBounds(170,80,75,25);
        resultLabel1.setBounds(50,125,90,25);
        resultLabel11.setBounds(75,175,75,25);
        mField2.setFont(new Font("Serif", Font.PLAIN, 60));
        mField21.setFont(new Font("Serif", Font.PLAIN, 60));
        mField2.setBounds(144,20,25,100);
        mField21.setBounds(184,20,25,100);
        
        resultLabel2.setBounds(175,125,75,25);
        resultLabel21.setBounds(174,150,35,25);
        resultLabel22.setBounds(174,175,35,25);
        resultLabel23.setBounds(205,150,35,25);
        resultLabel24.setBounds(205,175,35,25);
        mResultLabel2.setFont(new Font("Serif", Font.PLAIN, 60));
        mResultLabel21.setFont(new Font("Serif", Font.PLAIN, 60));
        mResultLabel2.setBounds(155,117,25,100);
        mResultLabel21.setBounds(220,117,25,100);
        
        resultLabel3.setBounds(300,125,75,25);
        resultLabel31.setBounds(308,150,35,25);
        resultLabel32.setBounds(308,175,35,25);
        mResultLabel3.setFont(new Font("Serif", Font.PLAIN, 60));
        mResultLabel31.setFont(new Font("Serif", Font.PLAIN, 60));
        mResultLabel3.setBounds(280,115,25,100);
        mResultLabel31.setBounds(330,115,25,100);
        
        aField.setBounds(25,50,50,25);
        bField.setBounds(75,50,50,25);
        cField.setBounds(25,80,50,25);
        dField.setBounds(75,80,50,25);
        eField.setBounds(260,50,50,25);
        fField.setBounds(260,80,50,25);
        mField1.setFont(new Font("Serif", Font.PLAIN, 60));
        mField11.setFont(new Font("Serif", Font.PLAIN, 60));
        mField1.setBounds(5,20,25,100);
        mField11.setBounds(125,20,25,100);
        mField3.setFont(new Font("Serif", Font.PLAIN, 60));
        mField31.setFont(new Font("Serif", Font.PLAIN, 60));
        mField3.setBounds(240,20,25,100);
        mField31.setBounds(310,20,25,100);
        
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
        
        frame.setTitle("Matrix 2x2");
        frame.add(x);
        frame.add(y);
        frame.add(equalLabel);
        frame.add(resultLabel1);
        frame.add(resultLabel11);
        frame.add(resultLabel2);
        frame.add(resultLabel21);
        frame.add(resultLabel22);
        frame.add(resultLabel23);
        frame.add(resultLabel24);
        frame.add(mResultLabel2);
        frame.add(mResultLabel21);
        frame.add(resultLabel3);
        frame.add(resultLabel31);
        frame.add(resultLabel32);
        frame.add(mResultLabel3);
        frame.add(mResultLabel31);
        frame.add(aField);
        frame.add(bField);
        frame.add(cField);
        frame.add(dField);
        frame.add(eField);
        frame.add(fField);
        frame.add(mField1);
        frame.add(mField11);
        frame.add(mField2);
        frame.add(mField21);
        frame.add(mField3);
        frame.add(mField31);
        frame.add(resultButton);
        frame.add(storeDataButton);
        frame.add(backButton);
        frame.add(clearButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        aField.setText("var a");
        bField.setText("var b");
        cField.setText("var c");
        dField.setText("var d");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userID = userIDField.getText();
        String adminCheck = adminCheckField.getText();
        if (e.getSource()== resultButton){
            resultLabel11.setText(DeterminantA());
            InverseA();
            FinalResult();
        }
        if (e.getSource() == storeDataButton) {
            Rectangle rect = frame.getBounds();
            try {
               String format = "png";
               String fileName = frame.getName() + userID + "." + format;
               BufferedImage captureImage = new BufferedImage (rect.width, rect.height, BufferedImage.TYPE_INT_ARGB);
               frame.paint(captureImage.getGraphics());
               ImageIO.write(captureImage, format, new File (fileName));
            }
             catch (IOException  ex) {
                Logger.getLogger(Matrix2x2.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
            try {
                PreparedStatement stUpdate;
                
                String queryUpdate = "UPDATE users_db SET storedOperation = ? WHERE id = ?";
                stUpdate = My_CNX.getConnection().prepareStatement(queryUpdate);
                File image = new File("frame"+ userID +".png");
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
            dField.setText("");
            eField.setText("");
            fField.setText("");
            resultLabel11.setText("");
            resultLabel21.setText("");
            resultLabel23.setText("");
            resultLabel22.setText("");
            resultLabel24.setText("");
            resultLabel31.setText("");
            resultLabel32.setText("");
        }
        
    }

    private void assertTrue(boolean exists) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

/**
 *
 * @author Luan
 */

