/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_matrices;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luan
 */
public class Matrix2x2 implements ActionListener {

    JFrame frame = new JFrame();
    JButton backButton = new JButton("Back");
    JButton determinantButton = new JButton("Determinant A");
    JButton inverseButton = new JButton("Inverse A");
    JButton finalButton = new JButton("Final result");
    JTextField aField = new JTextField();
    JTextField bField = new JTextField();
    JTextField cField = new JTextField();
    JTextField dField = new JTextField();
    JTextField eField = new JTextField();
    JTextField fField = new JTextField();
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();
    JLabel resultLabel1 = new JLabel("Determinant");
    JLabel resultLabel11 = new JLabel("");
    JLabel resultLabel2 = new JLabel("Inverse");
    JLabel resultLabel21 = new JLabel("");
    JLabel resultLabel22 = new JLabel("");
    JLabel resultLabel23 = new JLabel("");
    JLabel resultLabel24 = new JLabel("");
    JLabel resultLabel3 = new JLabel("Result");
    JLabel equalLabel1 = new JLabel("=");
    JLabel equalLabel2 = new JLabel("=");

   
    
    public String DeterminantA() {
        int a = Integer.parseInt(aField.getText());
        int b = Integer.parseInt(bField.getText()); 
        int c = Integer.parseInt(cField.getText());
        int d = Integer.parseInt(dField.getText());
        boolean boolValue;
        
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
        int det = Integer.parseInt(dA);
        int x, x1, x2, x3, x4;
        
        x = (1/det);
        x1 = (x * d);
        x2 = (x * -b);
        x3 = (x * -c);
        x4 = (x * a);
        
        String z1 = String.valueOf(x1);
        String z2 = String.valueOf(x2);
        String z3 = String.valueOf(x3);
        String z4 = String.valueOf(x4);
        
        
        resultLabel21.setText(z1);
        resultLabel23.setText(z2);
        resultLabel22.setText(z3);
        resultLabel24.setText(z4);
        String result = null;
        return result;
        
    }
    
    Matrix2x2(String userID, String adminCheck) {
        
        adminCheckField.setText(adminCheck);
        userIDField.setText(userID);
        
        equalLabel1.setBounds(210,50,25,25);
        equalLabel2.setBounds(210,80,75,25);
        resultLabel1.setBounds(50,125,75,25);
        resultLabel11.setBounds(75,175,75,25);
        
        resultLabel2.setBounds(175,125,75,25);
        resultLabel21.setBounds(180,150,25,25);
        resultLabel22.setBounds(180,175,25,25);
        resultLabel23.setBounds(205,150,25,25);
        resultLabel24.setBounds(205,175,25,25);
        
        resultLabel3.setBounds(300,125,75,25);
        
        aField.setBounds(100,50,50,25);
        bField.setBounds(150,50,50,25);
        cField.setBounds(100,80,50,25);
        dField.setBounds(150,80,50,25);
        eField.setBounds(225,50,50,25);
        fField.setBounds(225,80,50,25);
        
        determinantButton.setBounds(25,300,125,25);
        determinantButton.setFocusable(false);
        determinantButton.addActionListener(this);
        
        inverseButton.setBounds(150,300,100,25);
        inverseButton.setFocusable(false);
        inverseButton.addActionListener(this);
        
        finalButton.setBounds(250,300,100,25);
        finalButton.setFocusable(false);
        finalButton.addActionListener(this);
        
        backButton.setBounds(25,15,100,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        
        frame.add(equalLabel1);
        frame.add(equalLabel2);
        frame.add(resultLabel1);
        frame.add(resultLabel11);
        frame.add(resultLabel2);
        frame.add(resultLabel21);
        frame.add(resultLabel22);
        frame.add(resultLabel23);
        frame.add(resultLabel24);
        frame.add(resultLabel3);
        frame.add(aField);
        frame.add(bField);
        frame.add(cField);
        frame.add(dField);
        frame.add(eField);
        frame.add(fField);
        frame.add(determinantButton);
        frame.add(inverseButton);
        frame.add(finalButton);
        frame.add(backButton);
        
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
        if(e.getSource()== determinantButton){
            resultLabel11.setText(DeterminantA());
            }
        else if (e.getSource()== inverseButton){
            InverseA();
        }
        else if (e.getSource()== backButton){
            frame.dispose();
            CalculatorMenu calculatorMenu = new CalculatorMenu(userID, adminCheck);
        }
        
    }

}

/**
 *
 * @author Luan
 */

