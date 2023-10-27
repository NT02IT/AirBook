/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.popup;

import assets.Styles;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author agond
 */
public class TicketImportAD extends javax.swing.JFrame {

    /**
     * Creates new form TicketImportAD
     */
    public TicketImportAD() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/image/app-favicon.png")));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Import chuyến bay");
        style();
    }
    
    public void style(){
        
        this.getContentPane().setBackground(Styles.WHITE);
        pnDetail.setBackground(this.getContentPane().getBackground());
//        pnTicketList.setBackground(this.getContentPane().getBackground());
        
        lbTitle.setFont(Styles.H2);
        lbTitle.setForeground(Styles.GRAY_600);
        
        Styles.ButtonPrimary(btImportConfirm);
        Styles.Table(tbTicketList, pnTicketList);          
        
        Styles.FormLabel(lbAirline);
        Styles.FormTextFeild(txtAirline);
        
        Styles.FormLabel(lbFlyingFrom);
        Styles.FormTextFeild(txtFlyingFrom);
        
        Styles.FormLabel(lbFlyingTo);
        Styles.FormTextFeild(txtFlyingTo);
        
        Styles.FormLabel(lbDepartureFlight);
        Styles.FormTextFeild(txtDepartureFlight);
        
        Styles.FormLabel(lbPlane);
        Styles.FormTextFeild(txtPlane);
        
        Styles.FormLabel(lbTicketClass);
        Styles.FormTextFeild(txtTicketClass);
        
        Styles.FormLabel(lbAirportGate);
        Styles.FormTextFeild(txtAirportGate);
        
        Styles.FormLabel(lbImportPrice);
        Styles.FormTextFeild(txtImportPrice);
        
        Styles.FormLabel(lbResellPrice);
        Styles.FormTextFeild(txtResellPrice);
        
        Styles.ButtonDanger(btDelete);
        Styles.ButtonSecondary(btUpdate);    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupHeader = new GUI.components.PopupHeader("Import chuyến bay", "/assets/icon/info-flight-white32.png");
        lbTitle = new javax.swing.JLabel();
        pnTicketList = new javax.swing.JScrollPane();
        tbTicketList = new javax.swing.JTable();
        btImportConfirm = new javax.swing.JButton();
        pnDetail = new javax.swing.JPanel();
        lbAirline = new javax.swing.JLabel();
        txtAirline = new javax.swing.JTextField();
        lbFlyingFrom = new javax.swing.JLabel();
        lbFlyingTo = new javax.swing.JLabel();
        txtFlyingFrom = new javax.swing.JTextField();
        txtFlyingTo = new javax.swing.JTextField();
        lbDepartureFlight = new javax.swing.JLabel();
        txtDepartureFlight = new javax.swing.JTextField();
        lbPlane = new javax.swing.JLabel();
        txtPlane = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lbTicketClass = new javax.swing.JLabel();
        txtTicketClass = new javax.swing.JTextField();
        txtAirportGate = new javax.swing.JTextField();
        lbAirportGate = new javax.swing.JLabel();
        txtImportPrice = new javax.swing.JTextField();
        lbImportPrice = new javax.swing.JLabel();
        txtResellPrice = new javax.swing.JTextField();
        lbResellPrice = new javax.swing.JLabel();
        btDelete = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitle.setText("Danh sách chuyến bay");

        pnTicketList.setBackground(this.getContentPane().getBackground());

        tbTicketList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Ga đi", "Ga đến", "Khởi hành", "Thời gian bay"
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
        pnTicketList.setViewportView(tbTicketList);
        if (tbTicketList.getColumnModel().getColumnCount() > 0) {
            tbTicketList.getColumnModel().getColumn(0).setMinWidth(46);
            tbTicketList.getColumnModel().getColumn(0).setMaxWidth(46);
        }

        btImportConfirm.setBackground(new java.awt.Color(1, 138, 165));
        btImportConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btImportConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-import-white18.png"))); // NOI18N
        btImportConfirm.setText("Import to database");
        btImportConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImportConfirmActionPerformed(evt);
            }
        });

        pnDetail.setBackground(new java.awt.Color(255, 255, 255));

        lbAirline.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-airline-black20.png"))); // NOI18N
        lbAirline.setText("Hãng bay");

        lbFlyingFrom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFlyingFrom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbFlyingFrom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-flight-from-black20.png"))); // NOI18N
        lbFlyingFrom.setText("Bay từ");

        lbFlyingTo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFlyingTo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbFlyingTo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-flight-to-black20.png"))); // NOI18N
        lbFlyingTo.setText("Bay đến");

        lbDepartureFlight.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDepartureFlight.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDepartureFlight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-time-black20.png"))); // NOI18N
        lbDepartureFlight.setText("Khởi hành");

        lbPlane.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPlane.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPlane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-plane-id-black20.png"))); // NOI18N
        lbPlane.setText("Số hiệu máy bay");

        lbTicketClass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTicketClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-ticket-black20.png"))); // NOI18N
        lbTicketClass.setText("Hạng vé");

        lbAirportGate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbAirportGate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-login-black20.png"))); // NOI18N
        lbAirportGate.setText("Cổng đi");

        lbImportPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbImportPrice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-price-black20.png"))); // NOI18N
        lbImportPrice.setText("Giá nhập");

        lbResellPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbResellPrice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-price-black20.png"))); // NOI18N
        lbResellPrice.setText("Giá bán");

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png"))); // NOI18N
        btDelete.setText("Xóa");

        btUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-pri18.png"))); // NOI18N
        btUpdate.setText("Cập nhật");

        javax.swing.GroupLayout pnDetailLayout = new javax.swing.GroupLayout(pnDetail);
        pnDetail.setLayout(pnDetailLayout);
        pnDetailLayout.setHorizontalGroup(
            pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailLayout.createSequentialGroup()
                .addComponent(lbAirline, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAirline))
            .addGroup(pnDetailLayout.createSequentialGroup()
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtFlyingFrom, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFlyingFrom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(lbDepartureFlight, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDepartureFlight, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetailLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbFlyingTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFlyingTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))))
            .addComponent(lbPlane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtPlane)
            .addComponent(jSeparator1)
            .addGroup(pnDetailLayout.createSequentialGroup()
                .addComponent(lbTicketClass, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTicketClass))
            .addGroup(pnDetailLayout.createSequentialGroup()
                .addComponent(lbAirportGate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAirportGate))
            .addGroup(pnDetailLayout.createSequentialGroup()
                .addComponent(lbImportPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImportPrice))
            .addGroup(pnDetailLayout.createSequentialGroup()
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetailLayout.createSequentialGroup()
                        .addComponent(lbResellPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnDetailLayout.createSequentialGroup()
                        .addComponent(btDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetailLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtResellPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)))
        );
        pnDetailLayout.setVerticalGroup(
            pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailLayout.createSequentialGroup()
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAirline)
                    .addComponent(txtAirline, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFlyingFrom)
                    .addComponent(lbFlyingTo))
                .addGap(4, 4, 4)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFlyingFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFlyingTo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDepartureFlight)
                    .addComponent(txtDepartureFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(lbPlane)
                .addGap(4, 4, 4)
                .addComponent(txtPlane, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTicketClass)
                    .addComponent(txtTicketClass, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAirportGate)
                    .addComponent(txtAirportGate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbImportPrice)
                    .addComponent(txtImportPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbResellPrice)
                    .addComponent(txtResellPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(popupHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btImportConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(pnTicketList, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(pnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(popupHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lbTitle)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTicketList, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(btImportConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btImportConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImportConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btImportConfirmActionPerformed

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
            java.util.logging.Logger.getLogger(TicketImportAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketImportAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketImportAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketImportAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketImportAD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btImportConfirm;
    private javax.swing.JButton btUpdate;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbAirline;
    private javax.swing.JLabel lbAirportGate;
    private javax.swing.JLabel lbDepartureFlight;
    private javax.swing.JLabel lbFlyingFrom;
    private javax.swing.JLabel lbFlyingTo;
    private javax.swing.JLabel lbImportPrice;
    private javax.swing.JLabel lbPlane;
    private javax.swing.JLabel lbResellPrice;
    private javax.swing.JLabel lbTicketClass;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnDetail;
    private javax.swing.JScrollPane pnTicketList;
    private GUI.components.PopupHeader popupHeader;
    private javax.swing.JTable tbTicketList;
    private javax.swing.JTextField txtAirline;
    private javax.swing.JTextField txtAirportGate;
    private javax.swing.JTextField txtDepartureFlight;
    private javax.swing.JTextField txtFlyingFrom;
    private javax.swing.JTextField txtFlyingTo;
    private javax.swing.JTextField txtImportPrice;
    private javax.swing.JTextField txtPlane;
    private javax.swing.JTextField txtResellPrice;
    private javax.swing.JTextField txtTicketClass;
    // End of variables declaration//GEN-END:variables
}
