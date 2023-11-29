/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.popup;

import BUS.AirlineBUS;
import BUS.PermissionBUS;
import BUS.PromoBUS;
import DTO.entities.Airline;
import DTO.entities.FlatDiscount;
import DTO.entities.PercentDiscount;
import DTO.entities.Promotion;
import DTO.entities.User;
import GUI.body_panel.PromoAD;
import assets.DateTime;
import java.awt.Toolkit;
import javax.swing.WindowConstants;
import assets.Styles;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import assets.DateTime;
import assets.EnumCheck;
/**
 *
 * @author WIN 10
 */
public class PuPromoAD extends javax.swing.JFrame {
    private User user;
    private Promotion promo;
    private PermissionBUS permissionBUS;
    private AirlineBUS airlineBUS;
    private PromoBUS promoBUS;
    
    private DateTime date= new DateTime();
    
    private ArrayList<Airline> airlines;
    /**
     * Creates new form PuPromoAD
     */
    public PuPromoAD(User user, Promotion promo) throws ParseException {
        try {
            this.user= user;
            this.promo = promo;
            this.permissionBUS = new PermissionBUS();
            this.airlineBUS = new AirlineBUS();
            this.airlines = airlineBUS.getList();
            this.promoBUS = new PromoBUS();
            initComponents();
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/image/app-favicon.png")));
            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("Khuyến mãi");
            initAccessPerRole();
            initFormTextField();
            style();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initAccessPerRole() {
        User userLogin = (User) this.user;
        if(permissionBUS.hasPerEdit(userLogin.getRoleID(), "PRM")) {
            btnSavePromo.setEnabled(true);
        }
        else {
            btnSavePromo.setEnabled(false);
        }
        if(permissionBUS.hasPerDelete(userLogin.getRoleID(), "PRM")) {
            btnDeletePromo.setEnabled(true);
        }
        else {
            btnDeletePromo.setEnabled(false);
        }
        
        
    }
    public void initFormTextField() throws ParseException, ClassNotFoundException, SQLException, IOException{
        if(promo != null) {
            String dayEnd = DateTime.convertFormat(promo.getDateEnd().toString(), "yyyy-MM-dd", "dd/MM/yyyy");
            txtDayEnd.setText(dayEnd);
            String dayStart = DateTime.convertFormat(promo.getDateStart().toString(), "yyyy-MM-dd", "dd/MM/yyyy");
            txtDayStart.setText(dayStart);
            txtPromotionID.setText(promo.getPromoID());
            txtPromotionName.setText(promo.getPromoName());
            txtValueDecrease.setText(String.valueOf(promo.getDecreased()));
            txtPromotionID.setEnabled(false);            
            cbAirline.setEnabled(false);

            for (Airline a : airlines) {
                String aID = a.getAirlineID();
                String aName = a.getAirlineName();
                cbAirline.addItem(aName);
                if (aID.equals(promo.getAirlineID())) {
                    cbAirline.setSelectedItem(aName);
                }
            }
            if(promo instanceof FlatDiscount){
                cbValueDecreaseOpiton.setSelectedItem("đ");
            }else cbValueDecreaseOpiton.setSelectedItem("%");
        }
        else{
            btnDeletePromo.setEnabled(false);
        }
    }
    public void style(){
        Styles.ButtonPrimary(btnSavePromo);
        Styles.ButtonDanger(btnDeletePromo);
        Styles.FormLabel(jLabel1);        
        Styles.FormLabel(lbDateEnd);
        Styles.FormLabel(lbDateStart);
        Styles.FormLabel(lbPromotionID);        
        Styles.FormLabel(lbPromoName);
        
        Styles.FormLabel(lbValueDecrease);
        Styles.FormTextFeild(txtDayEnd);           
        Styles.FormTextFeild(txtPromotionName);
        Styles.FormTextFeild(txtDayStart);
        Styles.FormTextFeild(txtPromotionID);
        Styles.FormTextFeild(txtValueDecrease);
        for (Airline entry : airlines) {
            String roleID = entry.getAirlineID();
            String roleName = entry.getAirlineName();
            cbAirline.addItem(roleName);
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
        lbPromoName = new javax.swing.JLabel();
        txtPromotionName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-airline-black20.png"))); // NOI18N
        jLabel1.setText("Hãng bay");

        cbAirline.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        lbPromotionID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-ticket-black20.png"))); // NOI18N
        lbPromotionID.setText("Mã khuyến mãi");

        txtValueDecrease.setMinimumSize(new java.awt.Dimension(35, 22));
        txtValueDecrease.setOpaque(true);
        txtValueDecrease.setPreferredSize(new java.awt.Dimension(35, 22));

        cbValueDecreaseOpiton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "đ" }));
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
        btnDeletePromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePromoActionPerformed(evt);
            }
        });

        btnSavePromo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-save-white18.png"))); // NOI18N
        btnSavePromo.setText("Lưu thông tin");
        btnSavePromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePromoActionPerformed(evt);
            }
        });

        lbPromoName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-ticket-black20.png"))); // NOI18N
        lbPromoName.setText("Tên mã ");

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
                    .addComponent(btnDeletePromo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPromoName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSavePromo, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(txtPromotionID)
                    .addComponent(cbAirline, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtValueDecrease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbValueDecreaseOpiton, 0, 1, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(txtPromotionName)
                    .addComponent(txtDayStart)
                    .addComponent(txtDayEnd))
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
                    .addComponent(lbPromoName)
                    .addComponent(txtPromotionName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValueDecrease)
                    .addComponent(txtValueDecrease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbValueDecreaseOpiton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDateStart)
                    .addComponent(txtDayStart, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDateEnd)
                    .addComponent(txtDayEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletePromo)
                    .addComponent(btnSavePromo))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDayStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDayStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDayStartActionPerformed

    private void btnSavePromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePromoActionPerformed
        String promoID = txtPromotionID.getText().trim();
        EnumCheck.ValidStatus chkID;
        String promoName = txtPromotionName.getText().trim();
        EnumCheck.ValidStatus chkName;
        String promoDataEnd = txtDayEnd.getText().trim();
        EnumCheck.DateValidStatus chkEnd;
        String promoDataStart = txtDayStart.getText().trim();
        EnumCheck.DateValidStatus chkStart;
        String promoAirline = (String) cbAirline.getSelectedItem();
        for (Airline a : airlines) {
            String aID = a.getAirlineID();
            String aName = a.getAirlineName();
            if (aName.equals(promoAirline)) {
                promoAirline = aID;
        }}
        String promoValueDecrease = txtValueDecrease.getText().trim();
        EnumCheck.ValidStatus chkValue;
        String promoType = (String) cbValueDecreaseOpiton.getSelectedItem();
        int type;
        if(promoType == "%")  type = 1;
        else type = 2;
        String strNoti = "";
        EnumCheck.ValidStatus chkNewPromo = EnumCheck.ValidStatus.VALID;
        if(promoID.equals("")){
            strNoti = "ID không được để trống";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewPromo = EnumCheck.ValidStatus.INVALID;
        }
        if(promoName.equals("")){
            strNoti = "Tên không được để trống";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewPromo = EnumCheck.ValidStatus.INVALID;
        }
        if(promoValueDecrease.equals("")){
            strNoti = "Giá trị không được để trống";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewPromo = EnumCheck.ValidStatus.INVALID;
        }
        chkEnd = date.checkFormat(promoDataEnd);
        if (chkEnd == EnumCheck.DateValidStatus.ISNULL) {
            strNoti = "Ngày kết thúc không được để trống.";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewPromo = EnumCheck.ValidStatus.INVALID;
        } else if (chkEnd == EnumCheck.DateValidStatus.UNCORRECTFORMAT) {
            strNoti = "Ngày kết thúc phải có dạng dd/mm/yyyy.";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewPromo = EnumCheck.ValidStatus.INVALID;
        } else if (chkEnd == EnumCheck.DateValidStatus.INVALID){
            strNoti = "Ngày kết thúc không hợp lệ.";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewPromo = EnumCheck.ValidStatus.INVALID;
        }
        
        chkStart = date.checkFormat(promoDataStart);
        if (chkStart == EnumCheck.DateValidStatus.ISNULL) {
            strNoti = "Ngày bắt đầu không được để trống.";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewPromo = EnumCheck.ValidStatus.INVALID;
        } else if (chkStart == EnumCheck.DateValidStatus.UNCORRECTFORMAT) {
            strNoti = "Ngày bắt đầu có dạng dd/mm/yyyy.";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewPromo = EnumCheck.ValidStatus.INVALID;
        } else if (chkStart == EnumCheck.DateValidStatus.INVALID){
            strNoti = "Ngày bắt đầu không hợp lệ.";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewPromo = EnumCheck.ValidStatus.INVALID;
        }
        if (chkNewPromo == EnumCheck.ValidStatus.VALID){
            if (this.promo == null){
                try {
                    if (type == 1){
                        PercentDiscount p = new PercentDiscount();
                        p.setPromoID(promoID);
                        p.setAirlineID(promoAirline);               
                        p.setDateEnd(date.strtoDate(promoDataEnd));
                        p.setDateStart(date.strtoDate(promoDataStart));
                        p.setPromoName(promoName);
                        p.setDecreased(Integer.valueOf(promoValueDecrease));
                        boolean check = promoBUS.createNewPromoPer(p);
                        if (check) {
                            JOptionPane.showMessageDialog(this, "Promotion created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            PromoAD promoAD = new PromoAD(this.user);
                            this.setVisible(false);
                            promoAD.setVisible(true);
                            
                            try {
                                PromoBUS promoBUS = new PromoBUS();
                                promoAD.initTablePromo(promoBUS.getList());
                            } catch (IOException ex) {
                                Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to create promotion.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else if (type == 2){
                        FlatDiscount p = new FlatDiscount();
                        p.setPromoID(promoID);
                        p.setAirlineID(promoAirline);               
                        p.setDateEnd(date.strtoDate(promoDataEnd));
                        p.setDateStart(date.strtoDate(promoDataStart));
                        p.setPromoName(promoName);
                        p.setDecreased(Integer.valueOf(promoValueDecrease));
                        
                        boolean check = promoBUS.createNewPromoFlat(p);
                        if (check) {
                            JOptionPane.showMessageDialog(this, "Promotion created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            PromoAD promoAD = new PromoAD(this.user);
                            this.setVisible(false);
                            promoAD.setVisible(true);
                            try {
                                PromoBUS promoBUS = new PromoBUS();
                                promoAD.initTablePromo(promoBUS.getList());
                            } catch (IOException ex) {
                                Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to create promotion.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                try {
                    PercentDiscount p = new PercentDiscount();
                    p.setAirlineID(promoID);               
                    p.setDateEnd(date.strtoDate(promoDataEnd));
                    p.setDateStart(date.strtoDate(promoDataStart));
                    p.setAirlineID(promoID);
                    p.setAirlineID(promoID);
                    p.setAirlineID(promoID);
                    boolean check = promoBUS.updatePromo(p, type);
                    if (check) {
                        JOptionPane.showMessageDialog(this, "Promotion update successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        PromoAD promoAD = new PromoAD(this.user);
                        this.setVisible(false);
                        promoAD.setVisible(true);
                        try {
                            PromoBUS promoBUS = new PromoBUS();
                            promoAD.initTablePromo(promoBUS.getList());
                        } catch (IOException ex) {
                            Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to update promotion.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnSavePromoActionPerformed

    private void btnDeletePromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePromoActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa promo này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                promoBUS.deletePromo(this.promo.getPromoID());
                PromoAD promoAD = new PromoAD(this.user);
                this.setVisible(false);
                promoAD.setVisible(true);
                try {
                    PromoBUS promoBUS = new PromoBUS();
                    promoAD.initTablePromo(promoBUS.getList());
                } catch (IOException ex) {
                    Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PuPromoAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeletePromoActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletePromo;
    private javax.swing.JButton btnSavePromo;
    private javax.swing.JComboBox<String> cbAirline;
    private javax.swing.JComboBox<String> cbValueDecreaseOpiton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbDateEnd;
    private javax.swing.JLabel lbDateStart;
    private javax.swing.JLabel lbPromoName;
    private javax.swing.JLabel lbPromotionID;
    private javax.swing.JLabel lbValueDecrease;
    private GUI.components.PopupHeader popupHeader1;
    private javax.swing.JTextField txtDayEnd;
    private javax.swing.JTextField txtDayStart;
    private javax.swing.JTextField txtPromotionID;
    private javax.swing.JTextField txtPromotionName;
    private javax.swing.JTextField txtValueDecrease;
    // End of variables declaration//GEN-END:variables
}
