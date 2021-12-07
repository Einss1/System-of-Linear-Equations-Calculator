package ca_matrices;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luan
 */

public class UserList implements ActionListener{

    JFrame frame = new JFrame();
    JButton backButton = new JButton("Back");
    JTextField userIDField = new JTextField();
    JTextField adminCheckField = new JTextField();
    
    //Creates a table with data retrieved from the database
    UserList(String userID, String adminCheck) {
        try {
         
            PreparedStatement st;
            ResultSet rs;
        
            String query = "SELECT * FROM users_db";
        
            st = My_CNX.getConnection().prepareStatement(query);
            rs = st.executeQuery();
    
    
            String columns[] = {"ID", "Username", "First Name", "Last Name", "Password"};
            String data[][] = new String[10][5];
    
            int i = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String password = rs.getString("password");
                data[i][0] = id + "";
                data[i][1] = username;
                data[i][2] = fname;
                data[i][3] = lname;
                data[i][4] = password;
                i++;
            }
    
            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            JPanel panel = new JPanel();
            panel.add(pane);
            panel.setBounds(0, 50, 520, 200);
            frame.add(panel);
      
            adminCheckField.setText(adminCheck);
            userIDField.setText(userID); 

            backButton.setBounds(25,15,100,25);
            backButton.setFocusable(false);
            backButton.addActionListener(this);
        
            frame.setSize(520, 420);
            frame.setTitle("User List");
            frame.add(backButton);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong, please try again!");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String userID = userIDField.getText();
        String adminCheck = adminCheckField.getText();
       
        if(e.getSource() == backButton){
            frame.dispose();
            AdminPage adminPage = new AdminPage(userID, adminCheck);
        }
    }    
}
