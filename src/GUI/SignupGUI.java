/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DTO.entities.User;
import assets.EnumCheck.NumbersValidStatus;
import assets.EnumCheck.PwdValidStatus;
import assets.EnumCheck.ValidStatus;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;

/**
 *
 * @author agond
 */
public class SignupGUI extends javax.swing.JFrame {

    /**
     * Creates new form AuthGUI
     */
    private String email, pwd, pwdConfirm, name, doB, CCCD, nation, address, phoneNum;
    
    public SignupGUI() {
        initComponents();
        this.setTitle("Airbook - Đăng ký");
    }
    
    public void showWindow() {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBody = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbPwd = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btSignup = new javax.swing.JButton();
        lbSubtitle1 = new javax.swing.JLabel();
        lbPwdConfirm = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbSubtitle2 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtDoB = new javax.swing.JTextField();
        lbDoB = new javax.swing.JLabel();
        lbCCCD = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        lbPhoneNum = new javax.swing.JLabel();
        txtPhoneNum = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        lbAddress = new javax.swing.JLabel();
        lbNation = new javax.swing.JLabel();
        txtNation = new javax.swing.JTextField();
        txtPwd = new javax.swing.JPasswordField();
        txtPwdConfirm = new javax.swing.JPasswordField();
        txtNoti = new javax.swing.JTextField();
        pnHeader = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(360, 592));

        pnBody.setBackground(new java.awt.Color(255, 255, 255));
        pnBody.setPreferredSize(new java.awt.Dimension(360, 266));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(1, 138, 165));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Đăng ký");

        lbEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(84, 104, 129));
        lbEmail.setText("Email");

        lbPwd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPwd.setForeground(new java.awt.Color(84, 104, 129));
        lbPwd.setText("Mật khẩu");

        txtEmail.setBackground(new java.awt.Color(246, 246, 246));
        txtEmail.setNextFocusableComponent(txtPwd);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btSignup.setBackground(new java.awt.Color(1, 138, 165));
        btSignup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSignup.setForeground(new java.awt.Color(255, 255, 255));
        btSignup.setText("Đăng ký");
        btSignup.setBorder(null);
        btSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignupActionPerformed(evt);
            }
        });

        lbSubtitle1.setForeground(new java.awt.Color(84, 104, 129));
        lbSubtitle1.setText("Thông tin đăng nhập");

        lbPwdConfirm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPwdConfirm.setForeground(new java.awt.Color(84, 104, 129));
        lbPwdConfirm.setText("Xác nhận mật khẩu");

        lbSubtitle2.setForeground(new java.awt.Color(84, 104, 129));
        lbSubtitle2.setText("Thông tin tài khoản");

        lbName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(84, 104, 129));
        lbName.setText("Họ và tên");

        txtName.setBackground(new java.awt.Color(246, 246, 246));
        txtName.setNextFocusableComponent(txtDoB);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtDoB.setBackground(new java.awt.Color(246, 246, 246));
        txtDoB.setText("dd/mm/yyyy");
        txtDoB.setNextFocusableComponent(txtCCCD);
        txtDoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoBActionPerformed(evt);
            }
        });

        lbDoB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDoB.setForeground(new java.awt.Color(84, 104, 129));
        lbDoB.setText("Ngày sinh");

        lbCCCD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbCCCD.setForeground(new java.awt.Color(84, 104, 129));
        lbCCCD.setText("Số CCCD");

        txtCCCD.setBackground(new java.awt.Color(246, 246, 246));
        txtCCCD.setNextFocusableComponent(txtNation);
        txtCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCCDActionPerformed(evt);
            }
        });

        lbPhoneNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPhoneNum.setForeground(new java.awt.Color(84, 104, 129));
        lbPhoneNum.setText("Số điện thoại");

        txtPhoneNum.setBackground(new java.awt.Color(246, 246, 246));
        txtPhoneNum.setNextFocusableComponent(btSignup);
        txtPhoneNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumActionPerformed(evt);
            }
        });

        txtAddress.setBackground(new java.awt.Color(246, 246, 246));
        txtAddress.setNextFocusableComponent(txtPhoneNum);
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        lbAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbAddress.setForeground(new java.awt.Color(84, 104, 129));
        lbAddress.setText("Địa chỉ");

        lbNation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNation.setForeground(new java.awt.Color(84, 104, 129));
        lbNation.setText("Quốc gia");

        txtNation.setBackground(new java.awt.Color(246, 246, 246));
        txtNation.setNextFocusableComponent(txtAddress);
        txtNation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNationActionPerformed(evt);
            }
        });

        txtPwd.setBackground(new java.awt.Color(246, 246, 246));
        txtPwd.setNextFocusableComponent(txtPwdConfirm);
        txtPwd.setPreferredSize(new java.awt.Dimension(90, 27));
        txtPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPwdActionPerformed(evt);
            }
        });

        txtPwdConfirm.setBackground(new java.awt.Color(246, 246, 246));
        txtPwdConfirm.setNextFocusableComponent(txtName);
        txtPwdConfirm.setPreferredSize(new java.awt.Dimension(90, 27));
        txtPwdConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPwdConfirmActionPerformed(evt);
            }
        });

        txtNoti.setBorder(null);

        javax.swing.GroupLayout pnBodyLayout = new javax.swing.GroupLayout(pnBody);
        pnBody.setLayout(pnBodyLayout);
        pnBodyLayout.setHorizontalGroup(
            pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnBodyLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBodyLayout.createSequentialGroup()
                        .addComponent(lbSubtitle1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBodyLayout.createSequentialGroup()
                        .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNoti, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnBodyLayout.createSequentialGroup()
                                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCCCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnBodyLayout.createSequentialGroup()
                                        .addComponent(lbSubtitle2)
                                        .addGap(0, 44, Short.MAX_VALUE))
                                    .addComponent(lbDoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDoB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCCCD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnBodyLayout.createSequentialGroup()
                                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPhoneNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbNation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNation, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhoneNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btSignup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnBodyLayout.createSequentialGroup()
                                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnBodyLayout.createSequentialGroup()
                                        .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(lbPwdConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPwdConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(txtPwd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(24, 24, 24))))
        );
        pnBodyLayout.setVerticalGroup(
            pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBodyLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbTitle)
                .addGap(8, 8, 8)
                .addComponent(lbSubtitle1)
                .addGap(8, 8, 8)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPwd)
                    .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPwdConfirm)
                    .addComponent(txtPwdConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSubtitle2)
                .addGap(8, 8, 8)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDoB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDoB))
                .addGap(8, 8, 8)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCCCD))
                .addGap(8, 8, 8)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNation, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNation, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAddress))
                .addGap(8, 8, 8)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPhoneNum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoti, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pnHeader.setBackground(new java.awt.Color(1, 138, 165));
        pnHeader.setPreferredSize(new java.awt.Dimension(100, 62));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/log-header-logo.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(116, 26));

        jButton1.setBackground(new java.awt.Color(1, 138, 165));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/png/action-arrow-back -signupfrm.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBody, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnBody, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        txtEmail.addActionListener((ActionEvent e) -> {
            txtPwd.requestFocus();
        });
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        txtName.addActionListener((ActionEvent e) -> {
            txtDoB.requestFocus();
        });
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtDoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoBActionPerformed
        txtDoB.addActionListener((ActionEvent e) -> {
            txtCCCD.requestFocus();
        });
    }//GEN-LAST:event_txtDoBActionPerformed

    private void txtPhoneNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumActionPerformed
        txtPhoneNum.addActionListener((ActionEvent e) -> {
            btSignup.requestFocus();
        });
    }//GEN-LAST:event_txtPhoneNumActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        txtAddress.addActionListener((ActionEvent e) -> {
            txtPhoneNum.requestFocus();
        });
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtNationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNationActionPerformed
        txtNation.addActionListener((ActionEvent e) -> {
            txtAddress.requestFocus();
        });
    }//GEN-LAST:event_txtNationActionPerformed

    private void txtCCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCCDActionPerformed
        txtCCCD.addActionListener((ActionEvent e) -> {
            txtNation.requestFocus();
        });
    }//GEN-LAST:event_txtCCCDActionPerformed

    private void btSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignupActionPerformed
        //Kiểm tra xem mật khẩu xác nhận có trùng với mật khẩu đã tạo không
        //Kiểm tra định dạng mật khẩu có phù hợp không
        //Kiểm tra định dạng CCCD, SĐT, Tên, Ngày Sinh
        //Kiểm tra có bị trùng tài khoản hay chưa (Email, SĐT)
        ValidStatus chkNewAccount = ValidStatus.VALID;
        String strNoti = "";
        
        email = txtEmail.getText();
        pwd = txtPwd.getText();
        pwdConfirm = txtPwdConfirm.getText();
        name = txtName.getText();
        doB = txtDoB.getText();
        CCCD = txtCCCD.getText();
        nation = txtNation.getText();
        address = txtAddress.getText();
        phoneNum = txtPhoneNum.getText();
        
        ValidStatus chkEmail = User.checkEmailValid(email);
        if(chkEmail == ValidStatus.INVALID){
            strNoti += "Không đúng định dạng email.";
            txtNoti.setText(strNoti);
        }
        
        
        NumbersValidStatus chkPhone = User.checkPhoneValid(phoneNum);
        NumbersValidStatus chkCCCD = User.checkCCCDValid(CCCD);
        
        PwdValidStatus chkPwd = User.checkPwdValid(pwd);;
        
        
        
        
        
        
        
        
//        this.setVisible(false);
        try {
            SigninGUI signinGUI = new SigninGUI();
            signinGUI.showWindow();
        } catch (SQLException ex) {
            Logger.getLogger(SignupGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignupGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SignupGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSignupActionPerformed

    private void txtPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPwdActionPerformed
        txtPwd.addActionListener((ActionEvent e) -> {
            txtPwdConfirm.requestFocus();
        });
    }//GEN-LAST:event_txtPwdActionPerformed

    private void txtPwdConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPwdConfirmActionPerformed
        txtPwdConfirm.addActionListener((ActionEvent e) -> {
            txtName.requestFocus();
        });
    }//GEN-LAST:event_txtPwdConfirmActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        try {
            SigninGUI signinGUI = new SigninGUI();
            signinGUI.showWindow();
        } catch (SQLException ex) {
            Logger.getLogger(SignupGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignupGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SignupGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SignupGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSignup;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbCCCD;
    private javax.swing.JLabel lbDoB;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNation;
    private javax.swing.JLabel lbPhoneNum;
    private javax.swing.JLabel lbPwd;
    private javax.swing.JLabel lbPwdConfirm;
    private javax.swing.JLabel lbSubtitle1;
    private javax.swing.JLabel lbSubtitle2;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnBody;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDoB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNation;
    private javax.swing.JTextField txtNoti;
    private javax.swing.JTextField txtPhoneNum;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JPasswordField txtPwdConfirm;
    // End of variables declaration//GEN-END:variables
}
