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
public class ModifyProfile_dummy {
    
    JFrame frame = new JFrame();
    
    ModifyProfile_dummy(String userID){
        frame.dispose();
        ModifyProfile modifyProfile = new ModifyProfile(userID);
    }
}
