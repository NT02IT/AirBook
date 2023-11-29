/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.popup;
import BUS.PlaneBUS;
import DAO.PlaneDAO;
import DTO.entities.Plane;import DTO.entities.User;
import GUI.body_panel.AirlineAD;
import GUI.body_panel.AirlinePlaneAD;
import assets.Styles;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import GUI.body_panel.AirlinePlaneAD;
import assets.Styles;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import GUI.body_panel.AirlinePlaneAD;
import assets.Styles;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import GUI.body_panel.AirlinePlaneAD;
import assets.Styles;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class PuPlaneAD extends javax.swing.JFrame {
    private User user;
    AirlineAD airlinePlaneAD;
    private String airlineID;

    /**
     * Creates new form PuPlaneAD
     */
    public PuPlaneAD() {
        initComponents();
    }
    public PuPlaneAD(JFrame context, User user) throws ClassNotFoundException, SQLException, IOException{
        this.user = user;
        initComponents();
;        
    }

    public void setAirPlaneID(String airlineID){
        this.airlineID=airlineID;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        pnPlaneInfo = new javax.swing.JPanel();
        lbPlaneName = new javax.swing.JLabel();
        lbSeats = new javax.swing.JLabel();
        PopupHeader = new javax.swing.JPanel();
        lbHeader = new javax.swing.JLabel();
        btSave = new javax.swing.JButton();
        txtPlaneName = new javax.swing.JTextField();
        txtSeats = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnPlaneInfo.setBackground(new java.awt.Color(255, 255, 255));

        lbPlaneName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPlaneName.setText("Tên Máy Bay");

        lbSeats.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSeats.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSeats.setText("Số Ghế");

        PopupHeader.setBackground(new java.awt.Color(1, 138, 165));

        lbHeader.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbHeader.setForeground(new java.awt.Color(255, 255, 255));
        lbHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-plane-id-white32.png"))); // NOI18N
        lbHeader.setText("Máy bay");

        javax.swing.GroupLayout PopupHeaderLayout = new javax.swing.GroupLayout(PopupHeader);
        PopupHeader.setLayout(PopupHeaderLayout);
        PopupHeaderLayout.setHorizontalGroup(
            PopupHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PopupHeaderLayout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(lbHeader)
                .addGap(138, 138, 138))
        );
        PopupHeaderLayout.setVerticalGroup(
            PopupHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PopupHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHeader)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btSave.setBackground(new java.awt.Color(1, 138, 165));
        btSave.setForeground(new java.awt.Color(255, 255, 255));
        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-save-white18.png"))); // NOI18N
        btSave.setText("Lưu thông tin");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        txtPlaneName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlaneNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPlaneInfoLayout = new javax.swing.GroupLayout(pnPlaneInfo);
        pnPlaneInfo.setLayout(pnPlaneInfoLayout);
        pnPlaneInfoLayout.setHorizontalGroup(
            pnPlaneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlaneInfoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnPlaneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbPlaneName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSeats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(pnPlaneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPlaneName)
                    .addComponent(txtSeats))
                .addGap(28, 28, 28))
            .addComponent(PopupHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnPlaneInfoLayout.setVerticalGroup(
            pnPlaneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlaneInfoLayout.createSequentialGroup()
                .addComponent(PopupHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(pnPlaneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPlaneName)
                    .addComponent(txtPlaneName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnPlaneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSeats)
                    .addComponent(txtSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPlaneInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPlaneInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed

        String seatsText = txtSeats.getText();
        String planeName = txtPlaneName.getText();
        String planeDesc = "";
    
    if (seatsText.isEmpty() || planeName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin máy bay");
        return;
    }

    try {
        int seats = Integer.parseInt(seatsText);
        PlaneDAO planeDAO = new PlaneDAO();
        // Tạo đối tượng Plane
        Plane plane = new Plane();
        plane.setAirlineID(airlineID);
        plane.setSeats(seats);
        plane.setPlaneName(planeName);
        plane.setPlaneDesc(planeDesc);
        plane.setIsDelete(0);
        // Gọi hàm create để thêm máy bay vào cơ sở dữ liệu
        boolean success = planeDAO.create(plane);

        if (success) {
            JOptionPane.showMessageDialog(this, "Thêm máy bay thành công");
            setVisible(false);            
        } else {
            JOptionPane.showMessageDialog(this, "Thêm máy bay thất bại");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng ghế hợp lệ");
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(PuPlaneAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PuPlaneAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PuPlaneAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void txtPlaneNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlaneNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlaneNameActionPerformed

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
            java.util.logging.Logger.getLogger(PuPlaneAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuPlaneAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuPlaneAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuPlaneAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PuPlaneAD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PopupHeader;
    private javax.swing.JButton btSave;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel lbHeader;
    private javax.swing.JLabel lbPlaneName;
    private javax.swing.JLabel lbSeats;
    private javax.swing.JPanel pnPlaneInfo;
    private javax.swing.JTextField txtPlaneName;
    private javax.swing.JTextField txtSeats;
    // End of variables declaration//GEN-END:variables
}
