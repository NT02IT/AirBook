/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;

import assets.Styles;
import DTO.entities.User;
import GUI.IndexAD;
import assets.Site;
import java.awt.Container;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author agond
 */
public class AirlineAD extends javax.swing.JPanel {
    private User user;
    private int rowPosition;
    private JFrame context;
    /**
     * Creates new form AirlineAD
     */
    public AirlineAD() {
        initComponents();
        styles();
    }
    
    public AirlineAD(JFrame context, User user) {
        this.user = user;
        this.context = context;
        initComponents();
        styles();
    }
    
    public void styles(){
        Styles.Table(tbAllAirline, pnAllAirline);
        Styles.ButtonSecondary(btAddAirline);
        
        lbTitle.setFont(Styles.H2);
        lbTitle.setForeground(Styles.GRAY_600);
        lbTotalAirlineHead.setFont(Styles.Body);
        lbTotalAirlineHead.setForeground(Styles.GRAY_600);
        lbTotalAirline.setFont(Styles.Body);
        lbTotalAirline.setForeground(Styles.GRAY_600);
        lbTotalAirlineTail.setFont(Styles.Body);
        lbTotalAirlineTail.setForeground(Styles.GRAY_600);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        btAddAirline = new javax.swing.JButton();
        pnAllAirline = new javax.swing.JScrollPane();
        tbAllAirline = new javax.swing.JTable();
        lbTotalAirlineHead = new javax.swing.JLabel();
        lbTotalAirline = new javax.swing.JLabel();
        lbTotalAirlineTail = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(740, 490));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitle.setText("Danh sách các hãng bay");

        btAddAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png"))); // NOI18N
        btAddAirline.setText("Thêm hãng bay");
        btAddAirline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddAirlineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddAirlineMouseExited(evt);
            }
        });

        tbAllAirline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hãng bay", "Tên máy bay", "Số máy bay", "Doanh thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAllAirline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAllAirlineMouseClicked(evt);
            }
        });
        pnAllAirline.setViewportView(tbAllAirline);
        if (tbAllAirline.getColumnModel().getColumnCount() > 0) {
            tbAllAirline.getColumnModel().getColumn(0).setMinWidth(40);
            tbAllAirline.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        lbTotalAirlineHead.setFont(Styles.Micro);
        lbTotalAirlineHead.setText("Có tất cả");

        lbTotalAirline.setText("230");

        lbTotalAirlineTail.setFont(Styles.Micro);
        lbTotalAirlineTail.setText("chuyến bay");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTotalAirlineHead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalAirline)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalAirlineTail)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnAllAirline, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btAddAirline)))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle)
                    .addComponent(btAddAirline, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(pnAllAirline, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotalAirlineHead)
                    .addComponent(lbTotalAirline)
                    .addComponent(lbTotalAirlineTail))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btAddAirlineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddAirlineMouseEntered
        btAddAirline.setBackground(Styles.PRI_NORMAL);
        btAddAirline.setForeground(Styles.WHITE);
        btAddAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-white18.png")));
    }//GEN-LAST:event_btAddAirlineMouseEntered

    private void btAddAirlineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddAirlineMouseExited
        btAddAirline.setBackground(Styles.PRI_LIGHTER);
        btAddAirline.setForeground(Styles.PRI_NORMAL);
        btAddAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png")));
    }//GEN-LAST:event_btAddAirlineMouseExited

    private void tbAllAirlineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAllAirlineMouseClicked
        rowPosition = this.tbAllAirline.getSelectedRow();
        IndexAD indexAD = (IndexAD)context;
        try {
            indexAD.SiteOrder(Site.Order.AIRLINEPLANE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirlineAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AirlineAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AirlineAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbAllAirlineMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddAirline;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTotalAirline;
    private javax.swing.JLabel lbTotalAirlineHead;
    private javax.swing.JLabel lbTotalAirlineTail;
    private javax.swing.JScrollPane pnAllAirline;
    private javax.swing.JTable tbAllAirline;
    // End of variables declaration//GEN-END:variables
}
