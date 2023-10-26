/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.UserBUS;
import assets.Styles;
import DTO.entities.User;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author agond
 */
public class SigninGUI extends javax.swing.JFrame {
    /**
     * Creates new form AuthGUI
     */
    private UserBUS userBUS;
    private User user;
    private String username = "";
    private String email = "";
    private String pwd = "";
    
    public SigninGUI() throws SQLException, ClassNotFoundException, IOException {
        this.userBUS = new UserBUS();
        this.user = new User();
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/image/app-favicon.png")));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        style();
    }
    
    public void style(){
        this.setTitle("Airbook - Đăng nhập");
        
        lbTitle.setForeground(Styles.PRI_NORMAL);
        lbTitle.setFont(Styles.H1);
        
        Styles.FormLabel(lbUsername);
        Styles.FormLabel(lbPwd);  
        
        Styles.FormTextFeild(txtUsername);        
        Styles.FormTextFeild(txtPwd);        
        
        Styles.ButtonPrimary(btSignin);
        Styles.ButtonSecondary(btSignup);
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
        lbUsername = new javax.swing.JLabel();
        lbPwd = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btSignin = new javax.swing.JButton();
        btSignup = new javax.swing.JButton();
        txtPwd = new javax.swing.JPasswordField();
        pnHeader = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(360, 318));

        pnBody.setBackground(new java.awt.Color(255, 255, 255));
        pnBody.setPreferredSize(new java.awt.Dimension(360, 274));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(1, 138, 165));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Đăng nhập");

        lbUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbUsername.setForeground(new java.awt.Color(84, 104, 129));
        lbUsername.setLabelFor(txtUsername);
        lbUsername.setText("Username");

        lbPwd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPwd.setForeground(new java.awt.Color(84, 104, 129));
        lbPwd.setLabelFor(txtPwd);
        lbPwd.setText("Mật khẩu");

        txtUsername.setBackground(new java.awt.Color(246, 246, 246));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        btSignin.setBackground(new java.awt.Color(1, 138, 165));
        btSignin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSignin.setForeground(new java.awt.Color(255, 255, 255));
        btSignin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-login-white18.png"))); // NOI18N
        btSignin.setText("Đăng nhập");
        btSignin.setBorder(null);
        btSignin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSignin.setFocusPainted(false);
        btSignin.setMargin(new java.awt.Insets(8, 14, 8, 14));
        btSignin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSigninMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSigninMouseExited(evt);
            }
        });
        btSignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSigninActionPerformed(evt);
            }
        });

        btSignup.setBackground(new java.awt.Color(230, 243, 246));
        btSignup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSignup.setForeground(new java.awt.Color(84, 104, 129));
        btSignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png"))); // NOI18N
        btSignup.setText("Đăng ký");
        btSignup.setBorder(null);
        btSignup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSignup.setFocusPainted(false);
        btSignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSignupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSignupMouseExited(evt);
            }
        });
        btSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignupActionPerformed(evt);
            }
        });

        txtPwd.setBackground(new java.awt.Color(246, 246, 246));
        txtPwd.setPreferredSize(new java.awt.Dimension(90, 27));
        txtPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPwdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBodyLayout = new javax.swing.GroupLayout(pnBody);
        pnBody.setLayout(pnBodyLayout);
        pnBodyLayout.setHorizontalGroup(
            pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnBodyLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSignup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSignin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnBodyLayout.createSequentialGroup()
                        .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(lbPwd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtPwd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
        );
        pnBodyLayout.setVerticalGroup(
            pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBodyLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbTitle)
                .addGap(20, 20, 20)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPwd)
                    .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btSignin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnHeader.setBackground(new java.awt.Color(1, 138, 165));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/log-header-logo.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(116, 26));

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        txtUsername.addActionListener((ActionEvent e) -> {
            txtPwd.requestFocus();
        });
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignupActionPerformed
        this.setVisible(false);
        SignupEUC signUpGUI = null;
        try {
            signUpGUI = new SignupEUC();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SigninGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SigninGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        signUpGUI.setVisible(true);
    }//GEN-LAST:event_btSignupActionPerformed

    private void btSigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSigninActionPerformed
        pwd = txtPwd.getText();
        int chkEmail = txtUsername.getText().indexOf('@');
        if(chkEmail == -1)
            username = txtUsername.getText();
        else
            email = txtUsername.getText();
        user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPwd(pwd);        
        try {
            user = userBUS.signIn(user);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SigninGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(user != null){
            File authToken = new File("src\\DTO\\views\\authorization_token.properties");
            if (!authToken.exists()) {
                try {
                    authToken.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(SigninGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(authToken, false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SigninGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                String tokenUsername = "USERNAME=" + user.getUsername() + "\n";
                outputStream.write(tokenUsername.getBytes());
                String tokenRole = "ROLE=" + user.getRoleID() + "\n";
                outputStream.write(tokenRole.getBytes());
                outputStream.close();                
            } catch (IOException ex) {
                Logger.getLogger(SigninGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(user.getRoleID().equals("ROLE3")){
                this.setVisible(false);
                IndexEUC indexEUC = new IndexEUC(user);
                indexEUC.setVisible(true);
            } else {
                this.setVisible(false);
                IndexAD indexAD = new IndexAD(user);
                indexAD.setVisible(true);
            }            
        } else
            JOptionPane.showMessageDialog(null,"Sai thông tin đăng nhập!!!", "Error",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btSigninActionPerformed

    private void txtPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPwdActionPerformed
        txtPwd.addActionListener((ActionEvent e) -> {
            btSignin.requestFocus();
        });
    }//GEN-LAST:event_txtPwdActionPerformed

    private void btSigninMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSigninMouseEntered
        btSignin.setBackground(Styles.PRI_DARK);
    }//GEN-LAST:event_btSigninMouseEntered

    private void btSigninMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSigninMouseExited
        btSignin.setBackground(Styles.PRI_NORMAL);
    }//GEN-LAST:event_btSigninMouseExited

    private void btSignupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSignupMouseEntered
        btSignup.setBackground(Styles.PRI_NORMAL);
        btSignup.setForeground(Styles.WHITE);
        btSignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-white18.png")));
    }//GEN-LAST:event_btSignupMouseEntered

    private void btSignupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSignupMouseExited
        btSignup.setBackground(Styles.PRI_LIGHTER);
        btSignup.setForeground(Styles.PRI_NORMAL);
        btSignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png")));
    }//GEN-LAST:event_btSignupMouseExited

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
            java.util.logging.Logger.getLogger(SigninGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SigninGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SigninGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SigninGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SigninGUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SigninGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SigninGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SigninGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSignin;
    private javax.swing.JButton btSignup;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbPwd;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JPanel pnBody;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
