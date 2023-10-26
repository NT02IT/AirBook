/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DTO.entities.User;
import GUI.body_panel.AccountAD;
import GUI.body_panel.AirlineAD;
import GUI.body_panel.AirlinePlaneAD;
import GUI.body_panel.AirportAD;
import GUI.body_panel.FlightAD;
import GUI.body_panel.PromoAD;
import GUI.body_panel.StatisticAD;
import GUI.body_panel.TicketAD;
import assets.Site.Order;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author agond
 */
public class IndexAD extends javax.swing.JFrame implements IIndex{
    private static JPanel pnBody;
    public static Order siteOrder;
    public static User user;
    /**
     * Creates new form IndexAD
     */
    public IndexAD() {
        init();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Airbook - Thống kê");
    }
    public IndexAD(User user) {
        this.user = user;
        init();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/image/app-favicon.png")));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Airbook - Thống kê");
    }
    
    public void SiteOrder(Order siteOrder){
        this.siteOrder = siteOrder;
        if(siteOrder == Order.STATISTIC){
            remove(pnBody);
            pnBody = new StatisticAD(user);
        } else if (siteOrder == Order.TICKET) {
            remove(pnBody);
            pnBody = new TicketAD(user);
        } else if (siteOrder == Order.PROMOTION) {
            remove(pnBody);
            pnBody = new PromoAD(user);
        } else if (siteOrder == Order.FLIGHT) {
            remove(pnBody);
            pnBody = new FlightAD(user);
        } else if (siteOrder == Order.AIRLINE) {
            remove(pnBody);
            pnBody = new AirlinePlaneAD(user);
        } else if (siteOrder == Order.AIRPORT) {
            remove(pnBody);
            pnBody = new AirportAD(user);
        } else if (siteOrder == Order.ACCOUNT) {
            remove(pnBody);
            pnBody = new AccountAD(user);
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
        sidebarAD = new GUI.components.SidebarAD(this);
        topbarAD = new GUI.components.TopbarAD(this);
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
                new IndexAD(new User()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.components.SidebarAD sidebarAD;
    private GUI.components.TopbarAD topbarAD;
    // End of variables declaration//GEN-END:variables
}
