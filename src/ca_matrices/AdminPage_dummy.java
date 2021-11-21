/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_matrices;

import javax.swing.JFrame;

/**
 *
 * @author Luan
 */
public class AdminPage_dummy {
    
    JFrame frame = new JFrame();
    
    AdminPage_dummy(String userID){
        frame.dispose();
        AdminPage adminPage = new AdminPage(userID);
    }
    
}
