/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import GUI.SigninGUI;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author agond
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        SigninGUI signinGUI = new SigninGUI();
        signinGUI.setVisible(true);
    }
    
}
