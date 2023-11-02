/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;

import DTO.entities.User;
import assets.Styles;

/**
 *
 * @author agond
 */
public class FlightAD extends javax.swing.JPanel {
    private User user;
    /**
     * Creates new form FlightAD
     */
    public FlightAD() {
        initComponents();
        styles();
    }
    
    public FlightAD(User user) {
        this.user = user;
        initComponents();
        styles();
    }
    public void styles(){
        Styles.ButtonSecondary(btAddFlight);
        Styles.Table(tbAllFlight, pnAllFlight);
        
        lbTitle.setFont(Styles.H2);
        lbTitle.setForeground(Styles.GRAY_600);
        lbTotalFlightHead.setFont(Styles.Body);
        lbTotalFlightHead.setForeground(Styles.GRAY_600);
        lbTotalFlight.setFont(Styles.Body);
        lbTotalFlight.setForeground(Styles.GRAY_600);
        lbTotalFlightTail.setFont(Styles.Body);
        lbTotalFlightTail.setForeground(Styles.GRAY_600);
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
        btAddFlight = new javax.swing.JButton();
        pnAllFlight = new javax.swing.JScrollPane();
        tbAllFlight = new javax.swing.JTable();
        lbTotalFlightHead = new javax.swing.JLabel();
        lbTotalFlight = new javax.swing.JLabel();
        lbTotalFlightTail = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(740, 490));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitle.setText("Danh sách tuyến bay");

        btAddFlight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png"))); // NOI18N
        btAddFlight.setText("Thêm tuyến");
        btAddFlight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddFlightMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddFlightMouseExited(evt);
            }
        });

        tbAllFlight.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ga đi", "Ga đến", "Số giờ bay", "Khởi hành"
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
        pnAllFlight.setViewportView(tbAllFlight);
        if (tbAllFlight.getColumnModel().getColumnCount() > 0) {
            tbAllFlight.getColumnModel().getColumn(0).setMinWidth(40);
            tbAllFlight.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        lbTotalFlightHead.setFont(Styles.Micro);
        lbTotalFlightHead.setText("Có tất cả");

        lbTotalFlight.setText("?");

        lbTotalFlightTail.setFont(Styles.Micro);
        lbTotalFlightTail.setText("chuyến bay");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTotalFlightHead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalFlight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalFlightTail)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btAddFlight))
                            .addComponent(pnAllFlight, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle)
                    .addComponent(btAddFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(pnAllFlight, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotalFlightHead)
                    .addComponent(lbTotalFlight)
                    .addComponent(lbTotalFlightTail))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btAddFlightMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddFlightMouseEntered
        btAddFlight.setBackground(Styles.PRI_NORMAL);
        btAddFlight.setForeground(Styles.WHITE);
        btAddFlight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-white18.png")));
    }//GEN-LAST:event_btAddFlightMouseEntered

    private void btAddFlightMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddFlightMouseExited
        btAddFlight.setBackground(Styles.PRI_LIGHTER);
        btAddFlight.setForeground(Styles.PRI_NORMAL);
        btAddFlight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png")));
    }//GEN-LAST:event_btAddFlightMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddFlight;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTotalFlight;
    private javax.swing.JLabel lbTotalFlightHead;
    private javax.swing.JLabel lbTotalFlightTail;
    private javax.swing.JScrollPane pnAllFlight;
    private javax.swing.JTable tbAllFlight;
    // End of variables declaration//GEN-END:variables
}
