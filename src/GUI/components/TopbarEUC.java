/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.components;

import GUI.IndexEUC;
import assets.Site.Order;
import assets.Styles;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author agond
 */
public class TopbarEUC extends javax.swing.JPanel implements ITopbar{
    Order siteOrder;
    JFrame context;
    /**
     * Creates new form TopbarEUC
     */
    public TopbarEUC() {
        initComponents();
        style();
        siteOrder = Order.BUY_TICKET;
        siteOrder(siteOrder);
    }
    
    public TopbarEUC(JFrame frParrent) {
        initComponents();
        style();
        siteOrder = Order.BUY_TICKET;
        siteOrder(siteOrder);
        this.context = frParrent;
    }    
        
    @Override
    public void style(){
        Styles.TopbarHeader(lbSitename);
        Styles.ButtonPrimary(btCTA);
    }
    
    @Override
    public void siteOrder(Order siteOrder){
        this.siteOrder = siteOrder;
        if(siteOrder == Order.BUY_TICKET){
            lbSitename.setText("Mua vé");
            btCTA.setVisible(true);
        } else if (siteOrder == Order.MY_TICKET) {
            lbSitename.setText("Vé của tôi");
            btCTA.setVisible(false);
        } else if (siteOrder == Order.PROMOTION) {
            lbSitename.setText("Khuyến mãi");
            btCTA.setVisible(true);
        } else if (siteOrder == Order.ACCOUNT) {
            lbSitename.setText("Tài khoản");
            btCTA.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSitename = new javax.swing.JLabel();
        btCTA = new javax.swing.JButton();

        setBackground(Styles.GRAY_100);
        setPreferredSize(new java.awt.Dimension(740, 62));

        lbSitename.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbSitename.setText("Sitename");

        btCTA.setBackground(new java.awt.Color(1, 138, 165));
        btCTA.setForeground(new java.awt.Color(255, 255, 255));
        btCTA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-my-ticket-white18.png"))); // NOI18N
        btCTA.setText("Vé của tôi");
        btCTA.setBorder(null);
        btCTA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCTA.setFocusPainted(false);
        btCTA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btCTAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btCTAMouseExited(evt);
            }
        });
        btCTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCTAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbSitename)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 476, Short.MAX_VALUE)
                .addComponent(btCTA, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSitename, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCTA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCTAActionPerformed
        this.siteOrder = Order.MY_TICKET;
        try {    
            ((IndexEUC)context).SiteOrder(siteOrder);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TopbarEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TopbarEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TopbarEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.siteOrder(siteOrder);
    }//GEN-LAST:event_btCTAActionPerformed

    private void btCTAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCTAMouseEntered
        btCTA.setBackground(Styles.PRI_DARK);
    }//GEN-LAST:event_btCTAMouseEntered

    private void btCTAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCTAMouseExited
        btCTA.setBackground(Styles.PRI_NORMAL);
    }//GEN-LAST:event_btCTAMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCTA;
    private javax.swing.JLabel lbSitename;
    // End of variables declaration//GEN-END:variables
}
