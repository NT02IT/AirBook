/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.components;

import GUI.IndexAD;
import GUI.popup.PuTicketImportAD;
import static assets.Site.Order;
import assets.Styles;
import java.awt.Container;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author agond
 */
public class TopbarAD extends javax.swing.JPanel {
    private Order siteOrder;
    private JFrame context;
    private Boolean haveBackBTN;
    /**
     * Creates new form TopbarEUC
     */
    public TopbarAD() {
        initComponents();
        style();
        siteOrder(Order.STATISTIC);
    }
    
    public TopbarAD(JFrame frParents) {
        initComponents();
        style();
        siteOrder(Order.STATISTIC);
        this.context = frParents;
    }
    
    public TopbarAD(JFrame frParents, boolean haveBackBTN, Order backTo) {
        initComponents();
        this.context = (IndexAD)frParents;
        siteOrder(backTo);
        if(haveBackBTN){
            javax.swing.JButton btBack = new javax.swing.JButton();
            
            btBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-arrow-back-white18.png"))); // NOI18N
            Styles.ButtonPrimary(btBack);
            btBack.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btBack.setBackground(Styles.PRI_DARK);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btBack.setBackground(Styles.PRI_NORMAL);
                }
            });
            btBack.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Container topbarContainer = btBack.getParent();
                    JFrame indexADFrame = ((TopbarAD)topbarContainer).context;
                    IndexAD indexAD = (IndexAD)indexADFrame;
                    try {    
                        indexAD.SiteOrder(backTo);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(TopbarAD.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(TopbarAD.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(TopbarAD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16)
                    .addComponent(lbSitename)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                    .addComponent(btCTA, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSitename, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btCTA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11))
            );
        }        
        style();
    }
    
    public void siteOrder(Order siteOrder){
        this.siteOrder = siteOrder;
        switch (siteOrder) {
            case STATISTIC:
                lbSitename.setText("Thống kê");
                break;
            case TICKET:
                lbSitename.setText("Vé máy bay");
                break;
            case PROMOTION:
                lbSitename.setText("Khuyến mãi");
                break;
            case FLIGHT:
                lbSitename.setText("Tuyến bay");
                break;
            case AIRLINE:
                lbSitename.setText("Hãng bay");
                break;
            case AIRLINEPLANE:
                lbSitename.setText("Chi tiết hãng bay");
                break;
            case AIRPORT:
                lbSitename.setText("Sân bay");
                break;
            case ACCOUNT:
                lbSitename.setText("Tài khoản");
                break;
            case FEATURES:
                lbSitename.setText("Chức năng");
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public void style(){
        Styles.TopbarHeader(lbSitename);
        Styles.ButtonPrimary(btCTA);
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
        btCTA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-import-white18.png"))); // NOI18N
        btCTA.setText("Import ticket");
        btCTA.setBorder(null);
        btCTA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCTA.setFocusPainted(false);
        btCTA.setIconTextGap(6);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 454, Short.MAX_VALUE)
                .addComponent(btCTA, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSitename, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCTA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCTAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCTAMouseEntered
        btCTA.setBackground(Styles.PRI_DARK);
    }//GEN-LAST:event_btCTAMouseEntered

    private void btCTAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCTAMouseExited
        btCTA.setBackground(Styles.PRI_NORMAL);
    }//GEN-LAST:event_btCTAMouseExited

    private void btCTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCTAActionPerformed
        PuTicketImportAD ticketImportAD = new PuTicketImportAD();
        ticketImportAD.setVisible(true);
    }//GEN-LAST:event_btCTAActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCTA;
    private javax.swing.JLabel lbSitename;
    // End of variables declaration//GEN-END:variables
}
