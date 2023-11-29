/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.popup;

import BUS.PermissionBUS;
import BUS.RoleBUS;
import BUS.UserBUS;
import DTO.entities.Person;
import DTO.entities.Role;
import DTO.entities.User;
import GUI.body_panel.AccountAD;
import java.awt.Toolkit;
import javax.swing.WindowConstants;
import assets.Styles;
import assets.DateTime;
import assets.EnumCheck;
import assets.EnumCheck.PwdValidStatus;
import assets.EnumCheck.ValidStatus;
import assets.EnumCheck.NumbersValidStatus;
import assets.EnumCheck.DateValidStatus;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WIN 10
 */
public class puAccountAD extends javax.swing.JFrame {
    private User user;
    private User userLogin;
    private PermissionBUS permissionBUS;
    private UserBUS userBUS;
    private RoleBUS roleBUS;
    private String roleID , username, pwd, pwdConfirm, ID, name, doB, address, nation, phoneNumber, CCCD, email;
    private DateTime date= new DateTime();
    private User newAccount;
    private ArrayList<Role> roleList;
    private ArrayList<Person> userList;
    /**
     * Creates new form puAccountAD
     */
    public puAccountAD(User userLogin ,User user) throws ParseException, ClassNotFoundException, SQLException, IOException {
        initComponents();
        this.user= user;
        this.userLogin = userLogin;
        try {
            this.permissionBUS = new PermissionBUS();
            this.roleBUS = new RoleBUS();
            roleList = roleBUS.getList();
        } catch (IOException ex) {
            Logger.getLogger(puAccountAD.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.userBUS = new UserBUS();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/image/app-favicon.png")));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Tài khoản");
        style();
        initFormTextField(user);
    }
    public void disableFormTextField(){
        txtBirthday.setEnabled(false);        
        txtAddress.setEnabled(false);
        txtCCCD.setEnabled(false);
        txtEmail.setEnabled(false);
        txtName.setEnabled(false);
        txtNational.setEnabled(false);
        txtPassword.setEnabled(false);
        txtRePassword.setEnabled(false);
        txtTel.setEnabled(false);
        cbRole.setEnabled(false);
        txtUsername.setEnabled(true);

    }
    public void enableFormTextField(){
        txtBirthday.setEnabled(true);        
        txtAddress.setEnabled(true);
        txtCCCD.setEnabled(true);
        txtEmail.setEnabled(true);
        txtName.setEnabled(true);
        txtNational.setEnabled(true);
        txtPassword.setEnabled(true);
        txtRePassword.setEnabled(true);
        txtTel.setEnabled(true);
        cbRole.setEnabled(true);        
        txtUsername.setEnabled(true);

    }
    public void initFormTextField(User user) throws ParseException, ClassNotFoundException, SQLException, IOException{
        if(user != null) {  
            txtAddress.setText(user.getAddress());
            String doB = DateTime.convertFormat(user.getDoB().toString(), "yyyy-MM-dd", "dd-MM-yyyy");
            txtBirthday.setText(doB);
            txtCCCD.setText(user.getCCCD());
            txtEmail.setText(user.getEmail());
            txtName.setText(user.getName());
            txtNational.setText(user.getNation());
            txtPassword.setText(user.getPwd());
            txtTel.setText(user.getPhoneNumber());
            for (Role role : roleList) {
                String roleID = role.getRoleID();
                String roleName = role.getRoleName();
                cbRole.addItem(roleName);
                if (roleID.equals(user.getRoleID())) {
                    cbRole.setSelectedItem(roleName);
                }
            }
            txtUsername.setText(user.getUsername());
            txtRePassword.setEnabled(false);
            String loggedInUserRole = this.userLogin.getRoleID();
            String currentUserRole = user.getRoleID();
            if (loggedInUserRole.equals("ROLE0")){
                if(loggedInUserRole.equals(currentUserRole)){
                    disableFormTextField();
                }
                if (this.userLogin.getUsername().equals(this.user.getUsername())){
                    enableFormTextField();
                }
                else{
                    enableFormTextField();
                }
            }
            if (loggedInUserRole.equals("ROLE1")) {
                if (loggedInUserRole.equals(currentUserRole) || currentUserRole.equals("ROLE0")) {
                    disableFormTextField();
                }
                if (this.userLogin.getUsername().equals(this.user.getUsername())){
                    enableFormTextField();
                }
            }
            if(permissionBUS.hasPerEdit(userLogin.getRoleID(), "ADM")) btnSaveAccount.setEnabled(true);
            else btnSaveAccount.setEnabled(false);
            if(permissionBUS.hasPerDelete(userLogin.getRoleID(), "ADM")) btnDeleteAccount.setEnabled(true);
            else btnDeleteAccount.setEnabled(false);

        }
        else{
            btnDeleteAccount.setEnabled(false);
        }
    }
    public void style(){
        Styles.ButtonDanger(btnDeleteAccount);
        Styles.ButtonPrimary(btnSaveAccount);
        Styles.FormLabel(lbEmail);        
        Styles.FormLabel(lbPwd);
        Styles.FormLabel(lbRePwd);
        Styles.FormLabel(lbName);
        Styles.FormLabel(lbCCCD);
        Styles.FormLabel(lbDoB);
        Styles.FormLabel(lbNational);        
        Styles.FormLabel(lbTel);
        Styles.FormLabel(lbAddress);
        Styles.FormLabel(lbAccountType);        
        Styles.FormLabel(lbUsername);

        Styles.FormTextFeild(txtTel);        
        Styles.FormTextFeild(txtAddress);
        Styles.FormTextFeild(txtBirthday);
        Styles.FormTextFeild(txtCCCD);
        Styles.FormTextFeild(txtEmail);
        Styles.FormTextFeild(txtName);
        Styles.FormTextFeild(txtNational);
        Styles.FormTextFeild(txtPassword);
        Styles.FormTextFeild(txtRePassword);
        for (Role entry : roleList) {
            String roleID = entry.getRoleID();
            String roleName = entry.getRoleName();
            cbRole.addItem(roleName);
        }
        Styles.FormTextFeild(txtUsername);
        jLabel1.setFont(Styles.Micro);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupHeader1 = new GUI.components.PopupHeader("Tài khoản", "/assets/icon/info-user-white32");
        jLabel1 = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtRePassword = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        lbPwd = new javax.swing.JLabel();
        lbRePwd = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbCCCD = new javax.swing.JLabel();
        lbDoB = new javax.swing.JLabel();
        lbNational = new javax.swing.JLabel();
        txtBirthday = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        txtNational = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        lbTel = new javax.swing.JLabel();
        lbAddress = new javax.swing.JLabel();
        lbAccountType = new javax.swing.JLabel();
        btnSaveAccount = new javax.swing.JButton();
        btnDeleteAccount = new javax.swing.JButton();
        lbUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        cbRole = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Thông tin đăng nhập");

        lbEmail.setText("Email");

        txtEmail.setMinimumSize(new java.awt.Dimension(170, 22));

        lbPwd.setText("Mật khẩu");

        lbRePwd.setText("Xác nhận mật khẩu");

        jLabel5.setText("Thông tin cá nhân");

        lbName.setText("Họ và tên");

        lbCCCD.setText("Số CCCD");

        lbDoB.setText("Ngày sinh");

        lbNational.setText("Quốc gia");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lbTel.setText("Số điện thoại");

        lbAddress.setText("Địa chỉ");

        lbAccountType.setText("Loại tài khoản");

        btnSaveAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-save-white18.png"))); // NOI18N
        btnSaveAccount.setText("Lưu thông tin");
        btnSaveAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAccountActionPerformed(evt);
            }
        });

        btnDeleteAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png"))); // NOI18N
        btnDeleteAccount.setText("Xóa tài khoản");
        btnDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAccountActionPerformed(evt);
            }
        });

        lbUsername.setText("Username");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(popupHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPwd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbRePwd, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(lbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword)
                            .addComponent(txtRePassword)
                            .addComponent(txtUsername)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteAccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbAccountType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbTel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbNational, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbCCCD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbDoB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(4, 4, 4)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNational, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBirthday, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSaveAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(popupHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUsername))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPwd)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRePwd)
                    .addComponent(txtRePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDoB)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCCCD))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNational, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNational))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAddress))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTel))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAccountType)
                    .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveAccount)
                    .addComponent(btnDeleteAccount))
                .addContainerGap(212, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnSaveAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAccountActionPerformed
        EnumCheck.ValidStatus chkNewAccount = EnumCheck.ValidStatus.VALID;
        String strNoti = "";
        
        email = txtEmail.getText();
        email = email.trim();
        EnumCheck.ValidStatus chkEmail;
        
        username = txtUsername.getText();
        username = username.trim();
        EnumCheck.ValidStatus chkUsername;
        
        pwd = txtPassword.getText();
        EnumCheck.PwdValidStatus chkPwd;
        
        pwdConfirm = txtRePassword.getText();
        EnumCheck.PwdValidStatus chkPwdCofirm;
        
        name = txtName.getText();
        name = User.formatName(name);
        EnumCheck.ValidStatus chkName;
        
        doB = txtBirthday.getText();
        doB = doB.trim();
        EnumCheck.DateValidStatus chkDoB;
        
        CCCD = txtCCCD.getText();
        CCCD = CCCD.trim();
        EnumCheck.NumbersValidStatus chkCCCD;
        
        nation = txtNational.getText();
        nation = nation.trim();
        EnumCheck.ValidStatus chkNation;
        
        address = txtAddress.getText();
        address = address.trim();
        EnumCheck.ValidStatus chkAddress;
        
        phoneNumber = txtTel.getText();
        phoneNumber = phoneNumber.trim();
        EnumCheck.NumbersValidStatus chkPhone;
        if(lbEmail.equals("")){
            strNoti = "Email không được để trống";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewAccount = ValidStatus.INVALID;
        } else{
            chkEmail = User.checkEmailValid(email);
            if(chkEmail == ValidStatus.INVALID){
                strNoti = "Không đúng định dạng email";
                JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
                chkNewAccount = ValidStatus.INVALID;
            }
        }        
        
        if(username.equals("")){
            strNoti = "Username không được để trống";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewAccount = ValidStatus.INVALID;
        }
        
        if(pwd.equals("")){
            strNoti = "Mật khẩu không được để trống";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewAccount = ValidStatus.INVALID;
        } else if(!pwd.equals(pwdConfirm)){
            chkPwd = PwdValidStatus.UNMATCH;
            strNoti = "Mật khẩu không trùng khớp.";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewAccount = ValidStatus.INVALID;
        } 
        else {
            chkPwd = User.checkPwdValid(pwd);
            if(chkPwd == PwdValidStatus.MISSINGLETTER){
                strNoti = "Mật khẩu cần chứa ký tự.";
                JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
                chkNewAccount = ValidStatus.INVALID;
            }
            if(chkPwd == PwdValidStatus.MISSINGNUMBER){
                strNoti = "Mật khẩu cần chứa số.";
                JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
                chkNewAccount = ValidStatus.INVALID;
            }
            if(chkPwd == PwdValidStatus.VERYSHORT){
                strNoti = "Mật khẩu cần dài hơn 8 ký tự.";
                JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
                chkNewAccount = ValidStatus.INVALID;
            }
        }  
        
        if(name.equals("")){
            strNoti = "Tên không được để trống.";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewAccount = ValidStatus.INVALID;
        }
        
        chkDoB = date.checkFormat(doB);
        if (chkDoB == DateValidStatus.ISNULL) {
            strNoti = "Ngày sinh không được để trống.";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewAccount = ValidStatus.INVALID;
        } else if (chkDoB == DateValidStatus.UNCORRECTFORMAT) {
            strNoti = "Ngày sinh phải có dạng dd/mm/yyyy.";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewAccount = ValidStatus.INVALID;
        } else if (chkDoB == DateValidStatus.INVALID){
            strNoti = "Ngày sinh không hợp lệ.";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewAccount = ValidStatus.INVALID;
        }
        
        if(CCCD.equals("")){
            strNoti = "CCCD không được để trống.";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewAccount = ValidStatus.INVALID;
        } else{
            chkCCCD = User.checkCCCDValid(CCCD);
            if(chkCCCD == NumbersValidStatus.VERYLONG){
                strNoti = "Số CCCD quá dài.";
               JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
                chkNewAccount = ValidStatus.INVALID;
            }
            if(chkCCCD == NumbersValidStatus.VERYSHORT){
                strNoti = "Số CCCD quá ngắn.";
                JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
                chkNewAccount = ValidStatus.INVALID;
            }
            if(chkCCCD == NumbersValidStatus.HASLETTER){
                strNoti = "Số CCCD sai định dạng";
                JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
                chkNewAccount = ValidStatus.INVALID;
            }
        }
        
        if(nation.equals("")){
            strNoti = "Quốc gia không được để trống";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewAccount = ValidStatus.INVALID;
        }
        
        if(address.equals("")){
            strNoti = "Địa chỉ không được để trống";
            JOptionPane.showMessageDialog(this,strNoti, "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewAccount = ValidStatus.INVALID;
        }
        
        if(phoneNumber.equals("")){
            JOptionPane.showMessageDialog(this,"Số điện thoại không được để trống", "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
            chkNewAccount = ValidStatus.INVALID;
        } else{
            chkPhone = User.checkPhoneValid(phoneNumber);
            if(chkPhone == NumbersValidStatus.VERYLONG){
                JOptionPane.showMessageDialog(this,"Số điện thoại quá dài", "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);

                chkNewAccount = ValidStatus.INVALID;
            }
            if(chkPhone == NumbersValidStatus.VERYSHORT){
                JOptionPane.showMessageDialog(this,"Số điện thoại quá ngắn", "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
                chkNewAccount = ValidStatus.INVALID;
            }
            if(chkPhone == NumbersValidStatus.HASLETTER){
                JOptionPane.showMessageDialog(this,"Số điện thoại sai định dạng", "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
                chkNewAccount = ValidStatus.INVALID;
            } 
        }   

        if(chkNewAccount == ValidStatus.VALID){
            try {
                Object selectedRole = cbRole.getSelectedItem();
                if (selectedRole != null) {
                    for (Role entry : roleList) {
                        if (entry.getRoleName().equals(selectedRole.toString())) {
                            roleID = entry.getRoleID();
                            break;
                        }
                    }
                }
                ID = User.generateID();
                newAccount = new User(roleID, username, pwd, date.now(), ID, name, "male", date.strtoDate(doB), address, nation, phoneNumber, CCCD, email);
                if (userBUS.checkUnique(newAccount)) {
                    try {
                        userBUS.signUp(newAccount);
                        JOptionPane.showMessageDialog(this,"Đăng ký thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                        AccountAD aD = new AccountAD();
                        userList = userBUS.getList();
                        aD.initTableAccount(userList);
                        aD.setVisible(true);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(puAccountAD.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(puAccountAD.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(puAccountAD.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(puAccountAD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else{
                    JOptionPane.showMessageDialog(this,"Tài khoản đã tồn tại", "Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (ParseException ex) {
                Logger.getLogger(puAccountAD.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }   

    }//GEN-LAST:event_btnSaveAccountActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAccountActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa tài khoản?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
        try {
            userBUS.deleteUser(this.user);
            JOptionPane.showMessageDialog(this,"Đã xóa thành công", "Xác thực", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            AccountAD aD = new AccountAD();
            userList = userBUS.getList();
            aD.initTableAccount(userList);
            aD.setVisible(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa tài khoản!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(puAccountAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(puAccountAD.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }//GEN-LAST:event_btnDeleteAccountActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteAccount;
    private javax.swing.JButton btnSaveAccount;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbAccountType;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbCCCD;
    private javax.swing.JLabel lbDoB;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNational;
    private javax.swing.JLabel lbPwd;
    private javax.swing.JLabel lbRePwd;
    private javax.swing.JLabel lbTel;
    private javax.swing.JLabel lbUsername;
    private GUI.components.PopupHeader popupHeader1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirthday;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNational;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtRePassword;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
