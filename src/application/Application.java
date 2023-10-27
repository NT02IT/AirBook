/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import DTO.entities.User;
import GUI.IndexEUC;
import GUI.IndexAD;
import GUI.SigninGUI;
import GUI.body_panel.BuyTicketEUC;
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
//        SigninGUI signinGUI = new SigninGUI();
//        signinGUI.setVisible(true);

        IndexEUC indexEUC = new IndexEUC(new User());
        indexEUC.setVisible(true);
        // IndexAD indexAD = new IndexAD();
        // indexAD.setVisible(true);
    }
    
}
