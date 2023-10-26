/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;

import DTO.entities.User;
import assets.Styles;
import assets.TextBubbleBorder;
import java.awt.Dimension;
import javax.swing.border.AbstractBorder;
import javax.swing.table.JTableHeader;

/**
 *
 * @author agond
 */
public class PromoEUC extends javax.swing.JPanel {
    private User user;
    /**
     * Creates new form PromoEUC
     */
    public PromoEUC() {
        initComponents();
        style();
    }
    
    public PromoEUC(User user) {
        this.user = user;
        initComponents();
        style();
    }
    
    public void style(){
        lbTitle.setForeground(Styles.GRAY_600);
        lbTitle.setFont(Styles.H2);
        
        Styles.ButtonSecondary(btSearch);
        Styles.Table(tbPromoCode, pnPromoCode);         
        
        lbPromoCount.setFont(Styles.Micro);
        lbPromoCount.setForeground(Styles.GRAY_600);
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
        btSearch = new javax.swing.JButton();
        pnPromoCode = new javax.swing.JScrollPane();
        tbPromoCode = new javax.swing.JTable();
        lbPromoCount = new javax.swing.JLabel();

        setBackground(Styles.WHITE);

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitle.setText("Danh sách mã khuyến mãi");

        btSearch.setBackground(new java.awt.Color(230, 243, 246));
        btSearch.setFont(Styles.Body);
        btSearch.setForeground(new java.awt.Color(1, 138, 165));
        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-search-pri18.png"))); // NOI18N
        btSearch.setText("Tìm kiếm");
        btSearch.setBorderPainted(false);
        btSearch.setFocusPainted(false);
        btSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSearchMouseExited(evt);
            }
        });

        pnPromoCode.setBackground(new java.awt.Color(255, 255, 255));
        pnPromoCode.setBorder(null);

        tbPromoCode.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã khuyến mãi", "Hãng bay", "Ngày kết thúc", "Khuyến mãi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPromoCode.setGridColor(Styles.PRI_NORMAL);
        tbPromoCode.setRowHeight(36);
        tbPromoCode.setSelectionBackground(Styles.PRI_LIGHTER);
        tbPromoCode.setSelectionForeground(Styles.PRI_NORMAL);
        tbPromoCode.setShowGrid(true);
        tbPromoCode.getTableHeader().setReorderingAllowed(false);
        pnPromoCode.setViewportView(tbPromoCode);
        if (tbPromoCode.getColumnModel().getColumnCount() > 0) {
            tbPromoCode.getColumnModel().getColumn(0).setMinWidth(46);
            tbPromoCode.getColumnModel().getColumn(0).setMaxWidth(46);
            tbPromoCode.getColumnModel().getColumn(3).setMinWidth(112);
            tbPromoCode.getColumnModel().getColumn(3).setMaxWidth(112);
            tbPromoCode.getColumnModel().getColumn(4).setResizable(false);
        }

        lbPromoCount.setFont(Styles.Micro);
        lbPromoCount.setText("Có tất cả 230 mã khuyến mãi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbPromoCount)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnPromoCode, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btSearch)))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitle)
                    .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(pnPromoCode)
                .addGap(8, 8, 8)
                .addComponent(lbPromoCount)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchMouseEntered
        btSearch.setBackground(Styles.PRI_NORMAL);
        btSearch.setForeground(Styles.WHITE);
        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-search-white18.png")));
    }//GEN-LAST:event_btSearchMouseEntered

    private void btSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchMouseExited
        btSearch.setBackground(Styles.PRI_LIGHTER);
        btSearch.setForeground(Styles.PRI_NORMAL);
        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-search-pri18.png")));
    }//GEN-LAST:event_btSearchMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSearch;
    private javax.swing.JLabel lbPromoCount;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JScrollPane pnPromoCode;
    private javax.swing.JTable tbPromoCode;
    // End of variables declaration//GEN-END:variables
}
