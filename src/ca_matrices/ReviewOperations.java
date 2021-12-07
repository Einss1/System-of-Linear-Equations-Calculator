package ca_matrices;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Luan
 */
public class ReviewOperations implements ActionListener {
    JFrame frame = new JFrame();
    JButton review2x2Button = new JButton("Matrix 2x2");
    JButton review3x3Button = new JButton("Matrix 3x3");
    JButton reviewsimul2x2Button = new JButton("Simultaneous 2x2");
    JButton backButton = new JButton("Back");
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();

     ReviewOperations(String userID, String adminCheck) {
                
         adminCheckField.setText(adminCheck);
         userIDField.setText(userID);
         
         review2x2Button.setBounds(155,100,100,25);
         review2x2Button.setFocusable(false);
         review2x2Button.addActionListener(this);
         
         review3x3Button.setBounds(155,150,100,25);
         review3x3Button.setFocusable(false);
         review3x3Button.addActionListener(this);
         
         reviewsimul2x2Button.setBounds(155,200,150,25);
         reviewsimul2x2Button.setFocusable(false);
         reviewsimul2x2Button.addActionListener(this);
         
         backButton.setBounds(25,15,100,25);
         backButton.setFocusable(false);
         backButton.addActionListener(this);
         
         frame.setTitle("Review Operations");
         frame.add(review2x2Button);
         frame.add(review3x3Button);
         frame.add(reviewsimul2x2Button);
         frame.add(backButton);
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
        if(e.getSource()== review2x2Button){
            frame.dispose();
            ReviewOperations2x2 reviewOperations2x2 = new ReviewOperations2x2(userID, adminCheck);
        }
        if(e.getSource()== review3x3Button){
            frame.dispose();
            ReviewOperations3x3 reviewOperations3x3 = new ReviewOperations3x3(userID, adminCheck);
        }
        if(e.getSource()== reviewsimul2x2Button){
            frame.dispose();
            ReviewOperationsSimul2x2 reviewOperationsSimul2x2 = new ReviewOperationsSimul2x2(userID, adminCheck);
        }
        if(e.getSource() == backButton){
            frame.dispose();
            AdminPage adminPage = new AdminPage(userID, adminCheck);
        }
    }
}
