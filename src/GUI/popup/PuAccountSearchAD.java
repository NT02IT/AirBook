/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.popup;
import BUS.RoleBUS;
import BUS.UserBUS;
import DTO.entities.Person;
import DTO.entities.Role;
import DTO.entities.User;
import GUI.body_panel.AccountAD;
import java.awt.Toolkit;
import javax.swing.WindowConstants;
import assets.Styles;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author WIN 10
 */
public class PuAccountSearchAD extends javax.swing.JFrame { 
    private ArrayList<Role> roles;
    private User user;
    private RoleBUS roleBUS;
    
    /**
     * Creates new form PuAccountSearchAD
     */
    public PuAccountSearchAD(User user) throws ClassNotFoundException, SQLException, IOException {
        initComponents();
        this.roleBUS = new RoleBUS();
        this.user = user;
        this.roles = roleBUS.getList();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/image/app-favicon.png")));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Tài khoản");
        style();
    }
    public void style(){
        Styles.ButtonPrimary(btnSearchAccount);
        Styles.FormLabel(jLabel1);        
        Styles.FormLabel(jLabel2);
        Styles.FormLabel(jLabel3);
        Styles.FormTextFeild(txtName);        
        Styles.FormTextFeild(txtEmail);
        for(Role role : roles){
            cbRole.addItem(role.getRoleName());
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

        popupHeader1 = new GUI.components.PopupHeader("Tìm kiếm tài khoản", "/assets/icon/info-user-white32");
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnSearchAccount = new javax.swing.JButton();
        cbRole = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Email");

        jLabel2.setText("Họ và tên");

        jLabel3.setText("Loại tài khoản");

        btnSearchAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-search-white18.png"))); // NOI18N
        btnSearchAccount.setText("Tìm kiếm");
        btnSearchAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchAccountMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(popupHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearchAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(popupHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbRole))
                .addGap(30, 30, 30)
                .addComponent(btnSearchAccount)
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String getEmail(){
        return txtEmail.getText().trim();
    }
    public String getName(){
        return txtName.getText().trim();
    }
    public String getRoleName(){
        return cbRole.getSelectedItem().toString();
    }
    private void btnSearchAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchAccountMouseClicked
        if(evt.getClickCount() == 1 || evt.getClickCount() == 2){
            if (this.checkTextField().equals("Tìm kiếm thành công !"))
            {
                JOptionPane.showMessageDialog(null, this.checkTextField());
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, this.checkTextField());
            }
        }
    }//GEN-LAST:event_btnSearchAccountMouseClicked
    public String checkTextField()
    {
        if (this.getName().matches(".*[0-9].*")==true)
            return "Tên không chứa chữ số !";
        return "Tìm kiếm thành công !";
    }
    public javax.swing.JButton getBtnSearchAccount() {
        return btnSearchAccount;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchAccount;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private GUI.components.PopupHeader popupHeader1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
