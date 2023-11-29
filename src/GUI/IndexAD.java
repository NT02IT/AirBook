/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.PermissionBUS;
import DTO.entities.User;
import GUI.body_panel.AccountAD;
import GUI.body_panel.AirlineAD;
import GUI.body_panel.AirlinePlaneAD;
import GUI.body_panel.AirportAD;
import GUI.body_panel.FeaturesAD;
import GUI.body_panel.FlightAD;
import GUI.body_panel.PromoAD;
import GUI.body_panel.StatisticAD;
import GUI.body_panel.TicketAD;
import GUI.components.TopbarAD;
import assets.Site.Order;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author agond
 */
public class IndexAD extends javax.swing.JFrame implements iIndex{
    private static JPanel pnBody;
    public static Order siteOrder;
    public static User user;
    private PermissionBUS permissionBUS;
    private static String suffix = "";

    private String airlineID;
    /**
     * Creates new form IndexAD
     */
    public IndexAD() {
        init();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        try {
            suffix = "@" + user.getUsername();
            this.setTitle("Airbook - Thống kê " + suffix);
        } catch (java.lang.NullPointerException e) {
            this.setTitle("Airbook - Thống kê");
        }        
    }

    public IndexAD(User user) throws ClassNotFoundException, SQLException, IOException {
        this.user = user;
        this.permissionBUS = new PermissionBUS();
        init();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/image/app-favicon.png")));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        try {
            suffix = "@" + user.getUsername();
            this.setTitle("Airbook - Thống kê " + suffix);
        } catch (java.lang.NullPointerException e) {
            this.setTitle("Airbook - Thống kê");
        }  
    }
    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }
    public void SiteOrder(Order siteOrder) throws ClassNotFoundException, SQLException, IOException{
        this.siteOrder = siteOrder;
        remove(pnBody);
        remove(topbarAD);
        try {
            suffix = "@" + user.getUsername();
        } catch (java.lang.NullPointerException e) {
        }  
        switch (siteOrder) {
            case STATISTIC:
                pnBody = new StatisticAD(user);
                topbarAD = new TopbarAD(this);
                this.setTitle("Airbook - Thống kê " + suffix);
                break;
            case TICKET:
                if(permissionBUS.hasPerAccess(user.getRoleID(), "TIK")){
                    pnBody = new TicketAD(user);
                    topbarAD = new TopbarAD(this);
                    this.setTitle("Airbook - Vé máy bay " + suffix);
                    break;
                }else {
                    JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập!");
                    break;
                }
                
            case PROMOTION:
                if(permissionBUS.hasPerAccess(user.getRoleID(), "PRM")){
                    pnBody = new PromoAD(user);
                    topbarAD = new TopbarAD(this);
                    this.setTitle("Airbook - Khuyến mãi " + suffix);
                    break;
                }
                else {
                    JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập!");
                    break;
                }
            case FLIGHT:
                if(permissionBUS.hasPerAccess(user.getRoleID(), "FLT")){
                    pnBody = new FlightAD(user);
                    topbarAD = new TopbarAD(this);
                    this.setTitle("Airbook - Tuyến bay " + suffix);
                    break;
                }else {
                    JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập!");
                    break;
                }
            case AIRLINE:
                if(permissionBUS.hasPerAccess(user.getRoleID(), "ALN")){
                    pnBody = new AirlineAD(this, user); 
                    topbarAD = new TopbarAD(this);
                    this.setTitle("Airbook - Hãng bay " + suffix);
                    break;
                }else {
                    JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập!");
                    break;
                }
            case AIRLINEPLANE:
                    pnBody = new AirlinePlaneAD(user);
                    topbarAD = new TopbarAD(this, true, Order.AIRLINE);
                    this.setTitle("Airbook - Chi tiết hãng bay " + suffix);
                    ((AirlinePlaneAD) pnBody).setAirlineID(airlineID); // Truyền giá trị airlineID cho AirlinePlaneAD
                    ((AirlinePlaneAD) pnBody).initPlane();
                    break;
                
            case AIRPORT:
                if(permissionBUS.hasPerAccess(user.getRoleID(), "APT")){
                    pnBody = new AirportAD(user);
                    topbarAD = new TopbarAD(this);
                    this.setTitle("Airbook - Sân bay " + suffix);
                    break;
                }
                else {
                    JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập!");
                    break;
                }
            case ACCOUNT:
                pnBody = new AccountAD(user);
                topbarAD = new TopbarAD(this);
                this.setTitle("Airbook - Tài khoản " + suffix);
                break;
            case FEATURES:
                if(permissionBUS.hasPerAccess(user.getRoleID(), "FET")){
                pnBody = new FeaturesAD(user);
                topbarAD = new TopbarAD(this);
                this.setTitle("Airbook - Chức năng " + suffix);
                break;}
                else {
                    JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập!");
                    break;
                }
            default:
                throw new AssertionError();
        }        
        sidebarAD.siteOrder(siteOrder);
        topbarAD.siteOrder(siteOrder);

//        javax.swing.GroupLayout pnBodyLayout = new javax.swing.GroupLayout(pnBody);
//        pnBody.setLayout(pnBodyLayout);
//        pnBodyLayout.setHorizontalGroup(
//            pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 0, Short.MAX_VALUE)
//        );
//        pnBodyLayout.setVerticalGroup(
//            pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 0, Short.MAX_VALUE)
//        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebarAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topbarAD, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(pnBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(sidebarAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topbarAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    
    private void init(){
        topbarAD = new GUI.components.TopbarAD(this);
        sidebarAD = new GUI.components.SidebarAD(this);        
        pnBody = new StatisticAD(user);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(940, 600));

//        javax.swing.GroupLayout statisticAD1Layout = new javax.swing.GroupLayout(pnBody);
//        pnBody.setLayout(statisticAD1Layout);
//        statisticAD1Layout.setHorizontalGroup(
//            statisticAD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 0, Short.MAX_VALUE)
//        );
//        statisticAD1Layout.setVerticalGroup(
//            statisticAD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 0, Short.MAX_VALUE)
//        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebarAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topbarAD, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(pnBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(sidebarAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topbarAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebarAD = new GUI.components.SidebarAD();
        topbarAD = new GUI.components.TopbarAD();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(928, 600));
        setPreferredSize(new java.awt.Dimension(940, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebarAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(topbarAD, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topbarAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(sidebarAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IndexAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndexAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndexAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndexAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new IndexAD(new User()).setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(IndexAD.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(IndexAD.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(IndexAD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.components.SidebarAD sidebarAD;
    private GUI.components.TopbarAD topbarAD;
    // End of variables declaration//GEN-END:variables
}
