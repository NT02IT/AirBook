/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.popup;

import java.awt.Toolkit;
import javax.swing.WindowConstants;
import assets.Styles;
/**
 *
 * @author WIN 10
 */
public class PuPromoAD extends javax.swing.JFrame {

    /**
     * Creates new form PuPromoAD
     */
    public PuPromoAD() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/image/app-favicon.png")));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Khuyến mãi");
        style();
    }
    
    public void style(){
        Styles.ButtonPrimary(btnSavePromo);
        Styles.ButtonDanger(btnDeletePromo);
        Styles.FormLabel(jLabel1);        
        Styles.FormLabel(lbDateEnd);
        Styles.FormLabel(lbDateStart);
        Styles.FormLabel(lbPromotionID);
        Styles.FormLabel(lbValueDecrease);
        Styles.FormTextFeild(txtDayEnd);        
        Styles.FormTextFeild(txtDayStart);
        Styles.FormTextFeild(txtPromotionID);
        Styles.FormTextFeild(txtValueDecrease);


    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupHeader1 = new GUI.components.PopupHeader("Mã khuyến mãi", "/assets/icon/info-promotion-white32");
        jLabel1 = new javax.swing.JLabel();
        cbAirline = new javax.swing.JComboBox<>();
        lbPromotionID = new javax.swing.JLabel();
        txtPromotionID = new javax.swing.JTextField();
        txtValueDecrease = new javax.swing.JTextField();
        cbValueDecreaseOpiton = new javax.swing.JComboBox<>();
        lbValueDecrease = new javax.swing.JLabel();
        txtDayStart = new javax.swing.JTextField();
        lbDateStart = new javax.swing.JLabel();
        txtDayEnd = new javax.swing.JTextField();
        lbDateEnd = new javax.swing.JLabel();
        btnDeletePromo = new javax.swing.JButton();
        btnSavePromo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-airline-black20.png"))); // NOI18N
        jLabel1.setText("Hãng bay");

        cbAirline.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbPromotionID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-ticket-black20.png"))); // NOI18N
        lbPromotionID.setText("Mã khuyến mãi");

        txtValueDecrease.setMinimumSize(new java.awt.Dimension(35, 22));
        txtValueDecrease.setOpaque(true);
        txtValueDecrease.setPreferredSize(new java.awt.Dimension(35, 22));

        cbValueDecreaseOpiton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "VNĐ" }));
        cbValueDecreaseOpiton.setMinimumSize(new java.awt.Dimension(100, 22));
        cbValueDecreaseOpiton.setPreferredSize(new java.awt.Dimension(100, 22));

        lbValueDecrease.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-price-black20.png"))); // NOI18N
        lbValueDecrease.setText("Giá trị mã giảm");

        txtDayStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDayStartActionPerformed(evt);
            }
        });

        lbDateStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-time-black20.png"))); // NOI18N
        lbDateStart.setText("Ngày bắt đầu");

        lbDateEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-time-black20.png"))); // NOI18N
        lbDateEnd.setText("Ngày kết thúc");

        btnDeletePromo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png"))); // NOI18N
        btnDeletePromo.setText("Xóa mã");

        btnSavePromo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-save-white18.png"))); // NOI18N
        btnSavePromo.setText("Lưu thông tin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(popupHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPromotionID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValueDecrease, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(lbDateStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletePromo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSavePromo, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(txtDayEnd)
                    .addComponent(txtDayStart)
                    .addComponent(txtPromotionID)
                    .addComponent(cbAirline, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtValueDecrease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbValueDecreaseOpiton, 0, 1, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(popupHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbAirline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPromotionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPromotionID))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValueDecrease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbValueDecreaseOpiton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbValueDecrease))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lbDateStart))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDayStart, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDayEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDateEnd))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletePromo)
                    .addComponent(btnSavePromo))
                .addGap(0, 63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDayStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDayStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDayStartActionPerformed

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
            java.util.logging.Logger.getLogger(PuPromoAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuPromoAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuPromoAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuPromoAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PuPromoAD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletePromo;
    private javax.swing.JButton btnSavePromo;
    private javax.swing.JComboBox<String> cbAirline;
    private javax.swing.JComboBox<String> cbValueDecreaseOpiton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbDateEnd;
    private javax.swing.JLabel lbDateStart;
    private javax.swing.JLabel lbPromotionID;
    private javax.swing.JLabel lbValueDecrease;
    private GUI.components.PopupHeader popupHeader1;
    private javax.swing.JTextField txtDayEnd;
    private javax.swing.JTextField txtDayStart;
    private javax.swing.JTextField txtPromotionID;
    private javax.swing.JTextField txtValueDecrease;
    // End of variables declaration//GEN-END:variables
}
