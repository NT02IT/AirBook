/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.components;

import DTO.entities.User;
import GUI.IndexEUC;
import assets.Site.Order;
import javax.swing.BorderFactory;
import assets.Styles;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Insets;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author agond
 */
public class SidebarEUC extends javax.swing.JPanel implements iSidebar{
    Order siteOrder;
    JFrame frParrent;
    /**
     * Creates new form SidebarEUC
     */
    public SidebarEUC() {
        initComponents();
        style();
        siteOrder = Order.BUY_TICKET;
        siteOrder(siteOrder);
    }
    
    public SidebarEUC(JFrame frParrent) {
        initComponents();
        style();
        siteOrder = Order.BUY_TICKET;
        siteOrder(siteOrder);
        this.frParrent = frParrent;
    }
    
    @Override
    public void style(){
        this.setBackground(Styles.PRI_NORMAL);

        btBuyTicket.setBorder(BorderFactory.createEmptyBorder());
        btBuyTicket.setFont(Styles.Label);
        btBuyTicket.setForeground(Styles.WHITE);
        btBuyTicket.setMargin(new Insets(12, 16, 12, 16));

        btMyTicket.setBorder(BorderFactory.createEmptyBorder());
        btMyTicket.setFont(Styles.Label);
        btMyTicket.setForeground(Styles.WHITE);

        btPromo.setBorder(BorderFactory.createEmptyBorder());
        btPromo.setFont(Styles.Label);
        btPromo.setForeground(Styles.WHITE);

        btAccount.setBorder(BorderFactory.createEmptyBorder());
        btAccount.setFont(Styles.Label);
        btAccount.setForeground(Styles.WHITE);

        btLogout.setBorder(BorderFactory.createEmptyBorder());
        btLogout.setFont(Styles.Label);
        btLogout.setForeground(Styles.WHITE);
    }
    
    @Override
    public void resetNavItemBG(){
        btBuyTicket.setBackground(this.getBackground());
        btMyTicket.setBackground(this.getBackground());
        btPromo.setBackground(this.getBackground());
        btAccount.setBackground(this.getBackground());
    }
    
    @Override
    public void siteOrder(Order siteOrder){
        this.siteOrder = siteOrder;
        style();        
        if(siteOrder == Order.BUY_TICKET){
            resetNavItemBG();
            btBuyTicket.setBackground(Styles.PRI_DARK);
        } else if (siteOrder == Order.MY_TICKET) {
            resetNavItemBG();
            btMyTicket.setBackground(Styles.PRI_DARK);
        } else if (siteOrder == Order.PROMOTION) {
            resetNavItemBG();
            btPromo.setBackground(Styles.PRI_DARK);
        } else if (siteOrder == Order.ACCOUNT) {
            resetNavItemBG();
            btAccount.setBackground(Styles.PRI_DARK);
        }
    }
    
    @Override
    public void navigateTo(Order siteOrder){
        ((IndexEUC)frParrent).SiteOrder(siteOrder);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpNav = new javax.swing.ButtonGroup();
        pnHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btBuyTicket = new javax.swing.JButton();
        btMyTicket = new javax.swing.JButton();
        btPromo = new javax.swing.JButton();
        btAccount = new javax.swing.JButton();
        btLogout = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(1, 138, 165));
        setPreferredSize(new java.awt.Dimension(200, 600));

        pnHeader.setBackground(getBackground());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/log-header-logo.png"))); // NOI18N

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btBuyTicket.setBackground(getBackground());
        btBuyTicket.setForeground(new java.awt.Color(255, 255, 255));
        btBuyTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/nav-ticket-white20.png"))); // NOI18N
        btBuyTicket.setText("Mua vé");
        btBuyTicket.setBorder(null);
        grpNav.add(btBuyTicket);
        btBuyTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btBuyTicket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btBuyTicket.setIconTextGap(12);
        btBuyTicket.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btBuyTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuyTicketActionPerformed(evt);
            }
        });

        btMyTicket.setBackground(getBackground());
        btMyTicket.setForeground(new java.awt.Color(255, 255, 255));
        btMyTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/nav-my-ticket-white20.png"))); // NOI18N
        btMyTicket.setText("Vé của tôi");
        btMyTicket.setBorder(null);
        grpNav.add(btMyTicket);
        btMyTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btMyTicket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btMyTicket.setIconTextGap(12);
        btMyTicket.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btMyTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMyTicketActionPerformed(evt);
            }
        });

        btPromo.setBackground(getBackground());
        btPromo.setForeground(new java.awt.Color(255, 255, 255));
        btPromo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/nav-promotion-white20.png"))); // NOI18N
        btPromo.setText("Khuyến mãi");
        btPromo.setBorder(null);
        grpNav.add(btPromo);
        btPromo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPromo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btPromo.setIconTextGap(12);
        btPromo.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPromoActionPerformed(evt);
            }
        });

        btAccount.setBackground(getBackground());
        btAccount.setForeground(new java.awt.Color(255, 255, 255));
        btAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/nav-account-white20.png"))); // NOI18N
        btAccount.setText("Tài khoản");
        btAccount.setBorder(null);
        grpNav.add(btAccount);
        btAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAccount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btAccount.setIconTextGap(12);
        btAccount.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAccountActionPerformed(evt);
            }
        });

        btLogout.setBackground(getBackground());
        btLogout.setForeground(new java.awt.Color(255, 255, 255));
        btLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-logout-white20.png"))); // NOI18N
        btLogout.setText("Đăng xuất");
        btLogout.setBorder(null);
        grpNav.add(btLogout);
        btLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btLogout.setIconTextGap(12);
        btLogout.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(btBuyTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btMyTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btPromo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btBuyTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btMyTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btBuyTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuyTicketActionPerformed
        this.siteOrder = Order.BUY_TICKET;
        navigateTo(siteOrder);
    }//GEN-LAST:event_btBuyTicketActionPerformed

    private void btMyTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMyTicketActionPerformed
        this.siteOrder = Order.MY_TICKET;
        navigateTo(siteOrder);
    }//GEN-LAST:event_btMyTicketActionPerformed

    private void btPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPromoActionPerformed
        this.siteOrder = Order.PROMOTION;
        navigateTo(siteOrder);
    }//GEN-LAST:event_btPromoActionPerformed

    private void btAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAccountActionPerformed
        this.siteOrder = Order.ACCOUNT;
        navigateTo(siteOrder);
    }//GEN-LAST:event_btAccountActionPerformed

    private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoutActionPerformed
        JDialog dialog = new JDialog();
        dialog.setLocationRelativeTo(this);
        int result = JOptionPane.showConfirmDialog(dialog, "Bạn có muốn đăng xuất", "Đăng xuất", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }        
    }//GEN-LAST:event_btLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAccount;
    private javax.swing.JButton btBuyTicket;
    private javax.swing.JButton btLogout;
    private javax.swing.JButton btMyTicket;
    private javax.swing.JButton btPromo;
    private javax.swing.ButtonGroup grpNav;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pnHeader;
    // End of variables declaration//GEN-END:variables
}
