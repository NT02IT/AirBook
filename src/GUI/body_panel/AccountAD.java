/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;

import BUS.ActionBUS;
import BUS.PermissionBUS;
import BUS.RoleBUS;
import BUS.UserBUS;
import DTO.entities.Action;
import DTO.entities.Permission;
import DTO.entities.Person;
import DTO.entities.Role;
import DTO.entities.User;
import GUI.popup.PuAccountAuthAD;
import GUI.popup.PuAccountSearchAD;
import GUI.popup.puAccountAD;
import assets.Styles;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author agond
 */
public class AccountAD extends javax.swing.JPanel {
    private Person user;
    private UserBUS userBUS;    
    private RoleBUS roleBUS;
    private PermissionBUS permissionBUS;
    private ActionBUS actionBUS;
    
    private ArrayList<Person> userList;
    private ArrayList<Person> searchUserList;    
    private ArrayList<Permission> permissionList;  
    private ArrayList<Action> actionList;    
    private ArrayList<Permission> permissionOfRoleID;

    private ArrayList<Role> roleList;

    private DefaultTableModel usersModel;        
    private DefaultTableModel rolesModel;     
    private DefaultTableModel permissionModel;  
    private String roleIDSelected = null;
   

    /**
     * Creates new form AccountAD
     */
    public AccountAD() throws ClassNotFoundException, SQLException, IOException {
        this.user = new User();
        this.userBUS = new UserBUS();
        this.roleBUS = new RoleBUS();
        this.permissionBUS = new PermissionBUS();
        initComponents();
        styles();
    }
    
    public AccountAD(User user) throws ClassNotFoundException, SQLException, IOException {
        this.user = user;
        this.userBUS = new UserBUS();
        this.roleBUS = new RoleBUS();
        this.permissionBUS = new PermissionBUS();
        initComponents();
        styles();
    }
    public void initAccessPerAccount() {
        User userLogin = (User) this.user;
        if(permissionBUS.hasPerCreate(userLogin.getRoleID(), "ADM")) btAddAccount.setEnabled(true);
        else btAddAccount.setEnabled(false);
    }
    public void initAccessPerRole() {
        User userLogin = (User) this.user;
        if(permissionBUS.hasPerCreate(userLogin.getRoleID(), "ADM")) btAddRole.setEnabled(true);
        else btAddRole.setEnabled(false);
        
        if(permissionBUS.hasPerEdit(userLogin.getRoleID(), "ADM")) btUpdatePermission.setEnabled(true);
        else btUpdatePermission.setEnabled(false);
        
        if(permissionBUS.hasPerDelete(userLogin.getRoleID(), "ADM")) btDeletePermission.setEnabled(true);
        else btDeletePermission.setEnabled(false);
        
    }
    public void initTableAccount(ArrayList<Person> userList) throws ClassNotFoundException, SQLException, IOException{
        usersModel = (DefaultTableModel) tableAllAccounts.getModel();
        usersModel.setRowCount(0);
        int stt = 1;
        String username, staffName, typeAccount;
        Date dayCreated;
        for (Person account : userList){
            User user = (User) account;
            if(user.getIsDelete() == 0){
                username = user.getUsername();
                staffName = user.getName();
                dayCreated = user.getDateCreate();
                typeAccount = user.getRoleID();
                usersModel.addRow(new Object[]{stt++,username,staffName,dayCreated,typeAccount});
            }
        }
    }
    public void initTableRoles(ArrayList<Role> roleList) throws ClassNotFoundException, SQLException, IOException, NoSuchAlgorithmException{
        rolesModel = (DefaultTableModel) tbAllRole.getModel();
        rolesModel.setRowCount(0);
        int stt = 1;
        String roleName;
        int totalTypeAccount;
        Role firstRoleEntry = null;
        for (Role roleEntry : roleList) {
            if(roleEntry.getIsDelete() == 0){
                roleName = roleEntry.getRoleName();
                totalTypeAccount = userBUS.getTotalTypeAccountByRoleID(roleEntry.getRoleID());
                rolesModel.addRow(new Object[]{stt++, roleName, totalTypeAccount});
                if (firstRoleEntry == null) {
                    firstRoleEntry = roleEntry;
                }
            }
        }
        if (firstRoleEntry != null) {
            initTablePermission(firstRoleEntry.getRoleID(), firstRoleEntry.getRoleName());
        }
    }
    public void initTablePermission(String roleID, String roleName) throws ClassNotFoundException, SQLException, IOException, NoSuchAlgorithmException{
        this.roleIDSelected = roleID;
        permissionBUS = new PermissionBUS();
        
        ArrayList<Integer> listPer = new ArrayList<>();
        
        permissionModel = (DefaultTableModel) tbRolePermission.getModel();
        permissionModel.setRowCount(0);
        txtRoleName.setText(roleName);
        txtRoleName.setEnabled(false);
        
        actionBUS = new ActionBUS();
        actionList = actionBUS.getList();
        
        permissionOfRoleID = permissionBUS.canAccessForm(roleID);
        
        int stt = 1;
        String funcPermission, actionName = null;
        for (Permission permission : permissionOfRoleID){
            for(Action action : actionList){
                if(permission.getActionID().equals(action.getActionID()))
                    actionName = action.getActionName();
            }
            funcPermission = permission.getActionID();
            listPer = permissionBUS.hasPermission(roleID, funcPermission, permissionOfRoleID);
            boolean A = (listPer.get(0) == 1);            
            boolean C = (listPer.get(1) == 1);
            boolean R = (listPer.get(2) == 1);
            boolean U = (listPer.get(3) == 1);
            boolean D = (listPer.get(4) == 1);
            
            permissionModel.addRow(new Object[]{stt++,actionName,A,C,R,U,D});
        }
    }
    public void styles(){
        Styles.ButtonNeutral(btAddAccount);
        Styles.ButtonSecondary(btSearchAccount);
        Styles.Table(tableAllAccounts, pnAllAccounts);
        Styles.Table(tbRolePermission, pnAllRole);        
        Styles.Table(tbAllRole, pnRolePermission);

        Styles.FormTextFeild(txtRoleName);
        Styles.ButtonDanger(btDeletePermission);
        Styles.ButtonSecondary(btUpdatePermission);
        Styles.ButtonPrimary(btAddRole);
        
        lbTitleAccounts.setFont(Styles.H2);
        lbTitleAccounts.setForeground(Styles.GRAY_600);
        lbTitleAllAccount.setFont(Styles.H2);
        lbTitleAllAccount.setForeground(Styles.GRAY_600);
        lbTitleAuth.setFont(Styles.H2);
        lbTitleAuth.setForeground(Styles.GRAY_600);
        
        lbTotalAccHead.setFont(Styles.Body);
        lbTotalAccHead.setForeground(Styles.GRAY_600);
        lbTotalAccount.setFont(Styles.Label);
        lbTotalAccount.setForeground(Styles.GRAY_600);
        lbTotalAccTail.setFont(Styles.Body);
        lbTotalAccTail.setForeground(Styles.GRAY_600);        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabAccount = new javax.swing.JPanel();
        btAddAccount = new javax.swing.JButton();
        btSearchAccount = new javax.swing.JButton();
        lbTitleAccounts = new javax.swing.JLabel();
        pnAllAccounts = new javax.swing.JScrollPane();
        tableAllAccounts = new javax.swing.JTable();
        lbTotalAccHead = new javax.swing.JLabel();
        lbTotalAccount = new javax.swing.JLabel();
        lbTotalAccTail = new javax.swing.JLabel();
        tabAuth = new javax.swing.JPanel();
        pnAllAccount = new javax.swing.JPanel();
        lbTitleAllAccount = new javax.swing.JLabel();
        pnAllRole = new javax.swing.JScrollPane();
        tbAllRole = new javax.swing.JTable();
        btAddRole = new javax.swing.JButton();
        pnAuth = new javax.swing.JPanel();
        lbTitleAuth = new javax.swing.JLabel();
        txtRoleName = new javax.swing.JTextField();
        pnRolePermission = new javax.swing.JScrollPane();
        tbRolePermission = new javax.swing.JTable();
        btDeletePermission = new javax.swing.JButton();
        btUpdatePermission = new javax.swing.JButton();

        setBackground(new java.awt.Color(246, 246, 246));
        setMinimumSize(new java.awt.Dimension(740, 490));

        jTabbedPane1.setBackground(new java.awt.Color(246, 246, 246));
        jTabbedPane1.setForeground(Styles.PRI_NORMAL);
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        tabAccount.setBackground(new java.awt.Color(255, 255, 255));

        btAddAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-black18.png"))); // NOI18N
        btAddAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddAccountMouseExited(evt);
            }
        });
        btAddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddAccountActionPerformed(evt);
            }
        });

        btSearchAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-search-pri18.png"))); // NOI18N
        btSearchAccount.setText("Tìm kiếm");
        btSearchAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSearchAccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSearchAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSearchAccountMouseExited(evt);
            }
        });
        btSearchAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchAccountActionPerformed(evt);
            }
        });

        lbTitleAccounts.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitleAccounts.setText("Danh sách tài khoản");

        tableAllAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Username", "Tên nhân viên", "Ngày tạo TK", "Loại TK"
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
        tableAllAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAllAccountsMouseClicked(evt);
            }
        });
        pnAllAccounts.setViewportView(tableAllAccounts);
        if (tableAllAccounts.getColumnModel().getColumnCount() > 0) {
            tableAllAccounts.getColumnModel().getColumn(0).setMinWidth(40);
            tableAllAccounts.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        lbTotalAccHead.setFont(Styles.Micro);
        lbTotalAccHead.setText("Có tất cả");

        lbTotalAccount.setText("?");

        lbTotalAccTail.setFont(Styles.Micro);
        lbTotalAccTail.setText("tài khoản");

        javax.swing.GroupLayout tabAccountLayout = new javax.swing.GroupLayout(tabAccount);
        tabAccount.setLayout(tabAccountLayout);
        tabAccountLayout.setHorizontalGroup(
            tabAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabAccountLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(tabAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabAccountLayout.createSequentialGroup()
                        .addComponent(lbTotalAccHead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalAccount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalAccTail)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tabAccountLayout.createSequentialGroup()
                        .addGroup(tabAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnAllAccounts, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                            .addGroup(tabAccountLayout.createSequentialGroup()
                                .addComponent(lbTitleAccounts)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btAddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btSearchAccount)))
                        .addGap(24, 24, 24))))
        );
        tabAccountLayout.setVerticalGroup(
            tabAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabAccountLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(tabAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSearchAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTitleAccounts))
                .addGap(12, 12, 12)
                .addComponent(pnAllAccounts, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(tabAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotalAccHead)
                    .addComponent(lbTotalAccTail)
                    .addComponent(lbTotalAccount))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Tài khoản", new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-account-pri20.png")), tabAccount); // NOI18N
        tabAccount.getAccessibleContext().setAccessibleName("");

        tabAuth.setBackground(new java.awt.Color(255, 255, 255));

        pnAllAccount.setBackground(new java.awt.Color(255, 255, 255));
        pnAllAccount.setPreferredSize(new java.awt.Dimension(217, 368));

        lbTitleAllAccount.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitleAllAccount.setText("Tất cả các loại tài khoản");

        tbAllRole.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Loại Tài khoản", "SL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAllRole.setMinimumSize(new java.awt.Dimension(60, 100));
        tbAllRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAllRoleMouseClicked(evt);
            }
        });
        pnAllRole.setViewportView(tbAllRole);
        if (tbAllRole.getColumnModel().getColumnCount() > 0) {
            tbAllRole.getColumnModel().getColumn(0).setMinWidth(40);
            tbAllRole.getColumnModel().getColumn(0).setMaxWidth(50);
            tbAllRole.getColumnModel().getColumn(2).setMinWidth(40);
            tbAllRole.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        btAddRole.setBackground(new java.awt.Color(27, 124, 148));
        btAddRole.setForeground(new java.awt.Color(255, 255, 255));
        btAddRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-white18.png"))); // NOI18N
        btAddRole.setText("Thêm mới");
        btAddRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddRoleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddRoleMouseExited(evt);
            }
        });
        btAddRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnAllAccountLayout = new javax.swing.GroupLayout(pnAllAccount);
        pnAllAccount.setLayout(pnAllAccountLayout);
        pnAllAccountLayout.setHorizontalGroup(
            pnAllAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAllAccountLayout.createSequentialGroup()
                .addComponent(lbTitleAllAccount)
                .addGap(0, 84, Short.MAX_VALUE))
            .addComponent(btAddRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnAllRole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );
        pnAllAccountLayout.setVerticalGroup(
            pnAllAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAllAccountLayout.createSequentialGroup()
                .addComponent(lbTitleAllAccount)
                .addGap(24, 24, 24)
                .addComponent(pnAllRole, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(btAddRole, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnAuth.setBackground(new java.awt.Color(255, 255, 255));
        pnAuth.setPreferredSize(new java.awt.Dimension(455, 452));

        lbTitleAuth.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitleAuth.setLabelFor(txtRoleName);
        lbTitleAuth.setText("Quyền tài khoản");

        txtRoleName.setText("Người dùng");

        tbRolePermission.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Chức năng", "A", "C", "R", "U", "D"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRolePermission.setMinimumSize(new java.awt.Dimension(60, 100));
        tbRolePermission.getTableHeader().setReorderingAllowed(false);
        tbRolePermission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRolePermissionMouseClicked(evt);
            }
        });
        pnRolePermission.setViewportView(tbRolePermission);
        if (tbRolePermission.getColumnModel().getColumnCount() > 0) {
            tbRolePermission.getColumnModel().getColumn(0).setMinWidth(40);
            tbRolePermission.getColumnModel().getColumn(0).setMaxWidth(50);
            tbRolePermission.getColumnModel().getColumn(2).setMinWidth(40);
            tbRolePermission.getColumnModel().getColumn(2).setMaxWidth(50);
            tbRolePermission.getColumnModel().getColumn(3).setMinWidth(40);
            tbRolePermission.getColumnModel().getColumn(3).setMaxWidth(50);
            tbRolePermission.getColumnModel().getColumn(4).setMinWidth(40);
            tbRolePermission.getColumnModel().getColumn(4).setMaxWidth(50);
            tbRolePermission.getColumnModel().getColumn(5).setMinWidth(40);
            tbRolePermission.getColumnModel().getColumn(5).setMaxWidth(50);
            tbRolePermission.getColumnModel().getColumn(6).setMinWidth(40);
            tbRolePermission.getColumnModel().getColumn(6).setMaxWidth(50);
        }

        btDeletePermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png"))); // NOI18N
        btDeletePermission.setText("Xóa");
        btDeletePermission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDeletePermissionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btDeletePermissionMouseExited(evt);
            }
        });
        btDeletePermission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletePermissionActionPerformed(evt);
            }
        });

        btUpdatePermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-pri18.png"))); // NOI18N
        btUpdatePermission.setText("Cập nhật");
        btUpdatePermission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btUpdatePermissionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btUpdatePermissionMouseExited(evt);
            }
        });
        btUpdatePermission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdatePermissionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnAuthLayout = new javax.swing.GroupLayout(pnAuth);
        pnAuth.setLayout(pnAuthLayout);
        pnAuthLayout.setHorizontalGroup(
            pnAuthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAuthLayout.createSequentialGroup()
                .addComponent(lbTitleAuth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(txtRoleName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAuthLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDeletePermission)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btUpdatePermission))
            .addComponent(pnRolePermission, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnAuthLayout.setVerticalGroup(
            pnAuthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAuthLayout.createSequentialGroup()
                .addGroup(pnAuthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitleAuth)
                    .addComponent(txtRoleName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(pnRolePermission, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnAuthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btUpdatePermission, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDeletePermission, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout tabAuthLayout = new javax.swing.GroupLayout(tabAuth);
        tabAuth.setLayout(tabAuthLayout);
        tabAuthLayout.setHorizontalGroup(
            tabAuthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabAuthLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(pnAllAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnAuth, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        tabAuthLayout.setVerticalGroup(
            tabAuthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabAuthLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(tabAuthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnAuth, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addComponent(pnAllAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Phân quyền", new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png")), tabAuth); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void btSearchAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchAccountActionPerformed

    }//GEN-LAST:event_btSearchAccountActionPerformed

    private void btDeletePermissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletePermissionActionPerformed
        
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Role role = new Role();
                role.setRoleID(roleIDSelected);
                boolean deleted = roleBUS.deleteRole(role);
                if (deleted) {
                    RoleBUS roleBUS = new RoleBUS();
                    roleList = roleBUS.getList();
                    JOptionPane.showMessageDialog(this, "Đã xóa thành công!", "Xác nhận xóa", JOptionPane.INFORMATION_MESSAGE);
                    initTableRoles(roleList);
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btDeletePermissionActionPerformed

    private void btSearchAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchAccountMouseEntered
        btSearchAccount.setBackground(Styles.PRI_NORMAL);
        btSearchAccount.setForeground(Styles.WHITE);
        btSearchAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-search-white18.png")));
    }//GEN-LAST:event_btSearchAccountMouseEntered

    private void btSearchAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchAccountMouseExited
        btSearchAccount.setBackground(Styles.PRI_LIGHTER);
        btSearchAccount.setForeground(Styles.PRI_NORMAL);
        btSearchAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-search-pri18.png")));
    }//GEN-LAST:event_btSearchAccountMouseExited

    private void btAddAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddAccountMouseEntered
        btAddAccount.setBackground(Styles.PRI_NORMAL);
        btAddAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-white18.png")));
    }//GEN-LAST:event_btAddAccountMouseEntered

    private void btAddRoleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddRoleMouseEntered
        btAddRole.setBackground(Styles.PRI_DARK);
    }//GEN-LAST:event_btAddRoleMouseEntered

    private void btAddRoleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddRoleMouseExited
        btAddRole.setBackground(Styles.PRI_NORMAL);
    }//GEN-LAST:event_btAddRoleMouseExited

    private void btUpdatePermissionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdatePermissionMouseEntered
        btUpdatePermission.setBackground(Styles.PRI_NORMAL);
        btUpdatePermission.setForeground(Styles.WHITE);
        btUpdatePermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-white18.png")));
    }//GEN-LAST:event_btUpdatePermissionMouseEntered

    private void btAddAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddAccountMouseExited
        btAddAccount.setBackground(Styles.GRAY_100);
        btAddAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-black18.png")));
    }//GEN-LAST:event_btAddAccountMouseExited

    private void btUpdatePermissionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdatePermissionMouseExited
        btUpdatePermission.setBackground(Styles.GRAY_100);
        btUpdatePermission.setForeground(Styles.PRI_NORMAL);
        btUpdatePermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-pri18.png")));
    }//GEN-LAST:event_btUpdatePermissionMouseExited

    private void btDeletePermissionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeletePermissionMouseEntered
        btDeletePermission.setBackground(Styles.FUNC_DANGER);
        btDeletePermission.setForeground(Styles.WHITE);
        btDeletePermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-white18.png")));
    }//GEN-LAST:event_btDeletePermissionMouseEntered

    private void btDeletePermissionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeletePermissionMouseExited
        btDeletePermission.setBackground(Styles.FUNC_DANGER_LIGHT);
        btDeletePermission.setForeground(Styles.FUNC_DANGER);
        btDeletePermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png")));
    }//GEN-LAST:event_btDeletePermissionMouseExited

    private void btAddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddAccountActionPerformed
        puAccountAD addNewAccount;
        User userLogin = (User) this.user;
        if(permissionBUS.hasPerCreate(userLogin.getRoleID(), "ADM")){
            try {
                addNewAccount = new puAccountAD((User) this.user, null);
                addNewAccount.setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btAddAccountActionPerformed

    private void btAddRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddRoleActionPerformed
        User userLogin = (User) this.user;
        if(permissionBUS.hasPerCreate(userLogin.getRoleID(),"ADM")){
            PuAccountAuthAD puAccountAuthAD = new PuAccountAuthAD();
            puAccountAuthAD.setVisible(true);
        }
    }//GEN-LAST:event_btAddRoleActionPerformed

    private void tableAllAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllAccountsMouseClicked
        User userLogin = (User) this.user;
        if(evt.getClickCount() == 2 && permissionBUS.hasPerView(userLogin.getRoleID(), "ADM")){
            int selectedRow = tableAllAccounts.getSelectedRow();
            if(selectedRow != -1 ){
                try {
                    Person person = userList.get(selectedRow);
                    String userID = person.getID();
                    User user = userBUS.getByID(userID);
                    if (user != null) {
                        puAccountAD pAccountAD = new puAccountAD((User) this.user, user);
                        pAccountAD.setVisible(true);
                    }
                }   catch (SQLException ex) {
                    Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_tableAllAccountsMouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        JTabbedPane sourceTabbedPane = (JTabbedPane) evt.getSource();
        int selectedIndex = sourceTabbedPane.getSelectedIndex();
        if (selectedIndex == 0) {
            try {
                userList = userBUS.getList();
                initTableAccount(userList);
                initAccessPerAccount();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (selectedIndex == 1) {
            try {
                roleList = roleBUS.getList();
                initTableRoles(roleList);
                initAccessPerRole();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void tbRolePermissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRolePermissionMouseClicked
        
    }//GEN-LAST:event_tbRolePermissionMouseClicked

    private void tbAllRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAllRoleMouseClicked
        if (evt.getClickCount() == 1){
            int selectedRow = tbAllRole.getSelectedRow();
            if (selectedRow != -1) {
                
                String roleName = (String) tbAllRole.getValueAt(selectedRow, 1); // Replace 0 with the desired column index
                for (Role roleEntry : roleList){
                    if(roleEntry.getRoleName().equals(roleName)){
                        try {
                            System.out.println(roleName +" "+ roleEntry.getRoleID());
                            initTablePermission(roleEntry.getRoleID(), roleName);

                        } catch (SQLException ex) {
                            Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (NoSuchAlgorithmException ex) {
                            Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                }
            }
        }
        
    }//GEN-LAST:event_tbAllRoleMouseClicked

    private void btUpdatePermissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdatePermissionActionPerformed
        try {
            int rowCount = tbRolePermission.getRowCount();
            int[] columnIndices = {2, 3, 4, 5, 6}; // Chỉ mục của các cột cần lấy giá trị
            List<List<Object>> dataList = new ArrayList<>();
            for (int row = 0; row < rowCount; row++) {
                List<Object> rowData = new ArrayList<>();
                for (int columnIndex : columnIndices) {
                    Object cellValue = tbRolePermission.getValueAt(row, columnIndex);
                    rowData.add(cellValue);
                }
                dataList.add(rowData);
            }
            permissionBUS.updatePermissions(dataList, this.roleIDSelected);
            JOptionPane.showMessageDialog(this,"Thay đổi thành công", "Thông báo thay đổi", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btUpdatePermissionActionPerformed

    private void btSearchAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchAccountMouseClicked
        PuAccountSearchAD puSearch;
        try {
            puSearch = new PuAccountSearchAD((User) this.user);
            puSearch.setVisible(true);
            puSearch.getBtnSearchAccount().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        searchUserList = userBUS.search(puSearch.getEmail(), puSearch.getName(), puSearch.getRoleName());
                        initTableAccount(searchUserList);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccountAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSearchAccountMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddAccount;
    private javax.swing.JButton btAddRole;
    private javax.swing.JButton btDeletePermission;
    private javax.swing.JButton btSearchAccount;
    private javax.swing.JButton btUpdatePermission;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbTitleAccounts;
    private javax.swing.JLabel lbTitleAllAccount;
    private javax.swing.JLabel lbTitleAuth;
    private javax.swing.JLabel lbTotalAccHead;
    private javax.swing.JLabel lbTotalAccTail;
    private javax.swing.JLabel lbTotalAccount;
    private javax.swing.JPanel pnAllAccount;
    private javax.swing.JScrollPane pnAllAccounts;
    private javax.swing.JScrollPane pnAllRole;
    private javax.swing.JPanel pnAuth;
    private javax.swing.JScrollPane pnRolePermission;
    private javax.swing.JPanel tabAccount;
    private javax.swing.JPanel tabAuth;
    private javax.swing.JTable tableAllAccounts;
    private javax.swing.JTable tbAllRole;
    private javax.swing.JTable tbRolePermission;
    private javax.swing.JTextField txtRoleName;
    // End of variables declaration//GEN-END:variables
}
