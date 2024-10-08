/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;

import BUS.OrderDetailBUS;
import BUS.TicketBUS;
import BUS.UserBUS;
import DTO.entities.OrderDetail;
import DTO.entities.User;
import GUI.SigninGUI;
import assets.DateTime;
import assets.Styles;
import assets.TextBubbleBorder;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author agond
 */
public class AccountEUC extends javax.swing.JPanel {
    private User user;
    private UserBUS userBUS;
    private DateTime date = new DateTime();
    private OrderDetailBUS orderDetailBUS;
    private TicketBUS ticketBUS;
    /**
     * Creates new form AccountEUC
     */
    public AccountEUC() {
        initComponents();
        style();
        try {
            initAccountInfo();
        } catch (SQLException ex) {
            Logger.getLogger(AccountEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public AccountEUC(User user) {
        initComponents();
        style(); 
        try {
            userBUS = new UserBUS();
            orderDetailBUS = new OrderDetailBUS();
            ticketBUS = new TicketBUS();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccountEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.user = user;
        try {
            initAccountInfo();
        } catch (SQLException ex) {
            Logger.getLogger(AccountEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void style(){
        Styles.FormLabel(lbName);
        Styles.FormTextFeild(txtName);
        Styles.FormLabel(lbGender);
        Styles.ComboBox(txtGender);
        Styles.FormLabel(lbDoB);
        Styles.FormTextFeild(txtDoB);
        Styles.FormLabel(lbAddress);
        Styles.FormTextFeild(txtAddress);
        Styles.FormLabel(lbNation);
        Styles.FormTextFeild(txtNation);
        Styles.FormLabel(lbPhoneNum);
        Styles.FormTextFeild(txtPhoneNum);
        Styles.FormLabel(lbCCCD);
        Styles.FormTextFeild(txtCCCD);
        Styles.FormLabel(lbUsername);
        Styles.FormTextFeild(txtUsername);
        Styles.FormLabel(lbEmail);
        Styles.FormTextFeild(txtEmail);
        Styles.FormLabel(lbPwd);
        Styles.FormTextFeild(txtPwd);
        Styles.ButtonDanger(btDeleteAccount);
        Styles.ButtonPrimary(btUpdateAccount);
        
        
        lbHello.setFont(Styles.H2);
        lbHello.setForeground(Styles.GRAY_600);
        lbHelloName.setFont(Styles.H2);
        lbHelloName.setForeground(Styles.PRI_NORMAL);
        
        TextBubbleBorder border = new TextBubbleBorder(Styles.WHITE, 0, 16, 0, true);
        
        pnTicketBought.setBackground(Styles.FUNC_SUCCESS_LIGHT);
        pnTicketBought.setForeground(Styles.FUNC_SUCCESS);
        pnTicketBought.setBorder(border);
        
        pnFlightUpcoming.setBackground(Styles.FUNC_WARNING_LIGHT);
        pnFlightUpcoming.setForeground(Styles.FUNC_WARNING);
        pnFlightUpcoming.setBorder(border);
        
        pnTotal.setBackground(Styles.FUNC_DANGER_LIGHT);
        pnTotal.setForeground(Styles.FUNC_DANGER);
        pnTotal.setBorder(border);        
        
        TextBubbleBorder borderPnAcc = new TextBubbleBorder(Styles.GRAY_100, 1, 16, 0, true);
        pnAccountInfo.setBackground(Styles.WHITE);
        pnAccountInfo.setForeground(Styles.GRAY_600);
        pnAccountInfo.setBorder(borderPnAcc);
    }

    private void initAccountInfo() throws SQLException{
        txtName.setText(user.getName());
        txtGender.getModel().setSelectedItem(user.getGender());
        String doB;
        try {
            doB = assets.DateTime.convertFormat(user.getDoB().toString(), "yyyy-MM-dd", "dd/MM/yyyy");
            txtDoB.setText(doB);
        } catch (ParseException ex) {
            Logger.getLogger(AccountEUC.class.getName()).log(Level.SEVERE, null, ex);
        }        
        txtAddress.setText(user.getAddress());
        txtNation.setText(user.getNation());
        txtPhoneNum.setText(user.getPhoneNumber());
        txtCCCD.setText(user.getCCCD());
        txtUsername.setText(user.getUsername());
        txtEmail.setText(user.getEmail());
        txtPwd.setText("SamplePwd");
        lbTicketBoughtNum.setText(orderDetailBUS.getQuantityTicketPaidOf(user) + "");
        lbFlightUpcomingNum.setText(ticketBUS.getAllUpcomingTickets(user).size() + "");
        lbTotalNum.setText(ticketBUS.getTotalSpending(user) + "đ");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbHello = new javax.swing.JLabel();
        lbHelloName = new javax.swing.JLabel();
        pnTicketBought = new javax.swing.JPanel();
        lbTicketBought = new javax.swing.JLabel();
        lbTicketBoughtNum = new javax.swing.JLabel();
        pnTotal = new javax.swing.JPanel();
        lbTotal = new javax.swing.JLabel();
        lbTotalNum = new javax.swing.JLabel();
        pnFlightUpcoming = new javax.swing.JPanel();
        lbFlightUpcoming = new javax.swing.JLabel();
        lbFlightUpcomingNum = new javax.swing.JLabel();
        pnAccountInfo = new javax.swing.JPanel();
        pnAccountInfo5 = new javax.swing.JPanel();
        lbAccInfo = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        lbPwd = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPwd = new javax.swing.JPasswordField();
        btDeleteAccount = new javax.swing.JButton();
        btUpdateAccount = new javax.swing.JButton();
        pnAccountInfo6 = new javax.swing.JPanel();
        lbPersonalInfo = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lbGender = new javax.swing.JLabel();
        txtGender = new javax.swing.JComboBox<>();
        lbDoB = new javax.swing.JLabel();
        txtDoB = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        lbAddress = new javax.swing.JLabel();
        txtNation = new javax.swing.JTextField();
        lbNation = new javax.swing.JLabel();
        txtPhoneNum = new javax.swing.JTextField();
        lbPhoneNum = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        lbCCCD = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbHello.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbHello.setText("Xin chào, ");

        lbHelloName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbHelloName.setForeground(new java.awt.Color(1, 138, 165));
        lbHelloName.setText("Nguyễn Anh Tuấn");

        pnTicketBought.setBackground(new java.awt.Color(228, 252, 214));

        lbTicketBought.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTicketBought.setForeground(new java.awt.Color(55, 196, 51));
        lbTicketBought.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTicketBought.setText("Số vé đã mua");

        lbTicketBoughtNum.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTicketBoughtNum.setForeground(new java.awt.Color(55, 196, 51));
        lbTicketBoughtNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTicketBoughtNum.setText("44");

        javax.swing.GroupLayout pnTicketBoughtLayout = new javax.swing.GroupLayout(pnTicketBought);
        pnTicketBought.setLayout(pnTicketBoughtLayout);
        pnTicketBoughtLayout.setHorizontalGroup(
            pnTicketBoughtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTicketBoughtLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTicketBoughtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTicketBought, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTicketBoughtNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnTicketBoughtLayout.setVerticalGroup(
            pnTicketBoughtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTicketBoughtLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbTicketBought)
                .addGap(8, 8, 8)
                .addComponent(lbTicketBoughtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pnTotal.setBackground(new java.awt.Color(255, 229, 211));

        lbTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(255, 58, 40));
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotal.setText("Tổng chi");

        lbTotalNum.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTotalNum.setForeground(new java.awt.Color(255, 58, 40));
        lbTotalNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotalNum.setText("12.650.000đ");

        javax.swing.GroupLayout pnTotalLayout = new javax.swing.GroupLayout(pnTotal);
        pnTotal.setLayout(pnTotalLayout);
        pnTotalLayout.setHorizontalGroup(
            pnTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotalNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnTotalLayout.setVerticalGroup(
            pnTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTotalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotalNum, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pnFlightUpcoming.setBackground(new java.awt.Color(255, 246, 214));

        lbFlightUpcoming.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFlightUpcoming.setForeground(new java.awt.Color(255, 187, 50));
        lbFlightUpcoming.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFlightUpcoming.setText("Chuyến bay sắp tới");

        lbFlightUpcomingNum.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbFlightUpcomingNum.setForeground(new java.awt.Color(255, 187, 50));
        lbFlightUpcomingNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFlightUpcomingNum.setText("1");

        javax.swing.GroupLayout pnFlightUpcomingLayout = new javax.swing.GroupLayout(pnFlightUpcoming);
        pnFlightUpcoming.setLayout(pnFlightUpcomingLayout);
        pnFlightUpcomingLayout.setHorizontalGroup(
            pnFlightUpcomingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFlightUpcomingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFlightUpcomingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFlightUpcoming, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFlightUpcomingNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnFlightUpcomingLayout.setVerticalGroup(
            pnFlightUpcomingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFlightUpcomingLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbFlightUpcoming)
                .addGap(8, 8, 8)
                .addComponent(lbFlightUpcomingNum, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pnAccountInfo.setBackground(new java.awt.Color(255, 255, 255));

        pnAccountInfo5.setBackground(new java.awt.Color(255, 255, 255));

        lbAccInfo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbAccInfo.setText("Thông tin tài khoản");

        lbUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbUsername.setLabelFor(txtUsername);
        lbUsername.setText("Username");

        lbEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbEmail.setLabelFor(txtEmail);
        lbEmail.setText("Email");

        lbPwd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPwd.setLabelFor(txtPwd);
        lbPwd.setText("Mật khẩu");

        javax.swing.GroupLayout pnAccountInfo5Layout = new javax.swing.GroupLayout(pnAccountInfo5);
        pnAccountInfo5.setLayout(pnAccountInfo5Layout);
        pnAccountInfo5Layout.setHorizontalGroup(
            pnAccountInfo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAccountInfo5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAccountInfo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsername)
                    .addComponent(lbAccInfo)
                    .addComponent(lbEmail)
                    .addComponent(lbPwd))
                .addGap(54, 54, 54)
                .addGroup(pnAccountInfo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail)
                    .addComponent(txtPwd)))
        );
        pnAccountInfo5Layout.setVerticalGroup(
            pnAccountInfo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAccountInfo5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAccInfo)
                .addGap(8, 8, 8)
                .addGroup(pnAccountInfo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnAccountInfo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnAccountInfo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPwd)
                    .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        btDeleteAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png"))); // NOI18N
        btDeleteAccount.setText("Xóa tài khoản");
        btDeleteAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDeleteAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btDeleteAccountMouseExited(evt);
            }
        });
        btDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteAccountActionPerformed(evt);
            }
        });

        btUpdateAccount.setBackground(new java.awt.Color(1, 138, 165));
        btUpdateAccount.setForeground(new java.awt.Color(255, 255, 255));
        btUpdateAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-white18.png"))); // NOI18N
        btUpdateAccount.setText("Sửa thông tin");
        btUpdateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btUpdateAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btUpdateAccountMouseExited(evt);
            }
        });
        btUpdateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateAccountActionPerformed(evt);
            }
        });

        pnAccountInfo6.setBackground(new java.awt.Color(255, 255, 255));

        lbPersonalInfo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbPersonalInfo.setText("Thông tin cá nhân");

        lbName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbName.setLabelFor(txtName);
        lbName.setText("Họ và tên");

        lbGender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGender.setLabelFor(txtGender);
        lbGender.setText("Giới tính");

        txtGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        lbDoB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDoB.setLabelFor(txtDoB);
        lbDoB.setText("Ngày sinh");

        lbAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbAddress.setLabelFor(txtAddress);
        lbAddress.setText("Địa chỉ");

        lbNation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNation.setLabelFor(txtNation);
        lbNation.setText("Quốc tịch ");

        lbPhoneNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPhoneNum.setLabelFor(txtPhoneNum);
        lbPhoneNum.setText("Số điện thoại");

        lbCCCD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbCCCD.setLabelFor(txtCCCD);
        lbCCCD.setText("Số CCCD");

        javax.swing.GroupLayout pnAccountInfo6Layout = new javax.swing.GroupLayout(pnAccountInfo6);
        pnAccountInfo6.setLayout(pnAccountInfo6Layout);
        pnAccountInfo6Layout.setHorizontalGroup(
            pnAccountInfo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAccountInfo6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAccountInfo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName)
                    .addComponent(lbPersonalInfo)
                    .addComponent(lbGender)
                    .addComponent(lbDoB)
                    .addComponent(lbAddress)
                    .addComponent(lbNation)
                    .addComponent(lbPhoneNum)
                    .addComponent(lbCCCD))
                .addGap(54, 54, 54)
                .addGroup(pnAccountInfo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCCCD)
                    .addComponent(txtPhoneNum)
                    .addComponent(txtNation)
                    .addComponent(txtAddress)
                    .addComponent(txtName)
                    .addComponent(txtGender, 0, 141, Short.MAX_VALUE)
                    .addComponent(txtDoB))
                .addGap(0, 0, 0))
        );
        pnAccountInfo6Layout.setVerticalGroup(
            pnAccountInfo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAccountInfo6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPersonalInfo)
                .addGap(8, 8, 8)
                .addGroup(pnAccountInfo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnAccountInfo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGender)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnAccountInfo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDoB)
                    .addComponent(txtDoB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnAccountInfo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnAccountInfo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNation)
                    .addComponent(txtNation, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnAccountInfo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPhoneNum)
                    .addComponent(txtPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnAccountInfo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCCCD)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnAccountInfoLayout = new javax.swing.GroupLayout(pnAccountInfo);
        pnAccountInfo.setLayout(pnAccountInfoLayout);
        pnAccountInfoLayout.setHorizontalGroup(
            pnAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAccountInfoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnAccountInfo6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(pnAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnAccountInfoLayout.createSequentialGroup()
                        .addGap(0, 69, Short.MAX_VALUE)
                        .addComponent(btDeleteAccount)
                        .addGap(12, 12, 12)
                        .addComponent(btUpdateAccount))
                    .addComponent(pnAccountInfo5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        pnAccountInfoLayout.setVerticalGroup(
            pnAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAccountInfoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAccountInfoLayout.createSequentialGroup()
                        .addComponent(pnAccountInfo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDeleteAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btUpdateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnAccountInfo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnAccountInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbHello)
                                .addGap(0, 0, 0)
                                .addComponent(lbHelloName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnTicketBought, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20)
                                .addComponent(pnFlightUpcoming, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(20, 20, 20)
                        .addComponent(pnTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHello)
                    .addComponent(lbHelloName))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTicketBought, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnFlightUpcoming, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(pnAccountInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btUpdateAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateAccountMouseEntered
        btUpdateAccount.setBackground(Styles.PRI_DARK);
    }//GEN-LAST:event_btUpdateAccountMouseEntered

    private void btUpdateAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateAccountMouseExited
        btUpdateAccount.setBackground(Styles.PRI_NORMAL);
    }//GEN-LAST:event_btUpdateAccountMouseExited

    private void btDeleteAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeleteAccountMouseEntered
        btDeleteAccount.setBackground(Styles.FUNC_DANGER);
        btDeleteAccount.setForeground(Styles.WHITE);
        btDeleteAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-white18.png")));
    }//GEN-LAST:event_btDeleteAccountMouseEntered

    private void btDeleteAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeleteAccountMouseExited
        btDeleteAccount.setBackground(Styles.FUNC_DANGER_LIGHT);
        btDeleteAccount.setForeground(Styles.FUNC_DANGER);
        btDeleteAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png")));
    }//GEN-LAST:event_btDeleteAccountMouseExited

    private void btUpdateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateAccountActionPerformed
        try {
            getFormData();
            userBUS.update(user);
            JOptionPane.showMessageDialog(this,"Thông tin của bạn đã được cập nhật!", "Cập nhật thành công", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(AccountEUC.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Thông tin của bạn không được cập nhật đúng cách!", "Cập nhật thất bại", JOptionPane.INFORMATION_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(AccountEUC.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Thông tin của bạn không được cập nhật đúng cách!", "Cập nhật thất bại", JOptionPane.INFORMATION_MESSAGE);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountEUC.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Thông tin của bạn không được cập nhật đúng cách!", "Cập nhật thất bại", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btUpdateAccountActionPerformed

    private void btDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteAccountActionPerformed
        try {
            user.setIsDelete(1);
            userBUS.update(user);
            JOptionPane.showMessageDialog(this,"Tài khoản của bạn đã bị xóa!", "Xóa tài khoản", JOptionPane.INFORMATION_MESSAGE);
            SigninGUI signinGUI = new SigninGUI();
            signinGUI.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AccountEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccountEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btDeleteAccountActionPerformed

    private void getFormData() throws ParseException{
        user.setName(txtName.getText());
        user.setGender(txtGender.getSelectedItem().toString());
        user.setDoB(date.strtoDate(txtDoB.getText()));
        user.setAddress(txtAddress.getText());
        user.setNation(txtNation.getText());
        user.setPhoneNumber(txtPhoneNum.getText());
        user.setCCCD(txtCCCD.getText());
        user.setUsername(txtUsername.getText());
        user.setEmail(txtEmail.getText());
        if(txtPwd.getText().equals("SamplePwd") == false){
            user.setPwd(txtPwd.getText());
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeleteAccount;
    private javax.swing.JButton btUpdateAccount;
    private javax.swing.JLabel lbAccInfo;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbCCCD;
    private javax.swing.JLabel lbDoB;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbFlightUpcoming;
    private javax.swing.JLabel lbFlightUpcomingNum;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbHello;
    private javax.swing.JLabel lbHelloName;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNation;
    private javax.swing.JLabel lbPersonalInfo;
    private javax.swing.JLabel lbPhoneNum;
    private javax.swing.JLabel lbPwd;
    private javax.swing.JLabel lbTicketBought;
    private javax.swing.JLabel lbTicketBoughtNum;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotalNum;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JPanel pnAccountInfo;
    private javax.swing.JPanel pnAccountInfo5;
    private javax.swing.JPanel pnAccountInfo6;
    private javax.swing.JPanel pnFlightUpcoming;
    private javax.swing.JPanel pnTicketBought;
    private javax.swing.JPanel pnTotal;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDoB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JComboBox<String> txtGender;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNation;
    private javax.swing.JTextField txtPhoneNum;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
