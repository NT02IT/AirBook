/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;

import BUS.AirlineBUS;
import DAO.PlaneDAO;
import DTO.entities.Airline;
import assets.Styles;
import DTO.entities.User;
import DTO.views.AirlineViews;
import DTO.views.AirlineViews.AirlineView;
import GUI.IndexAD;
import GUI.popup.PuAirline;
import assets.Site;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author agond
 */
public class AirlineAD extends javax.swing.JPanel {
    private User user;
    private int rowPosition;
    private JFrame context;
    private ArrayList<Airline> listAirline;
    private ArrayList<AirlineView> listAirlineView;
    private AirlineBUS airlineBUS;
    private DefaultTableModel airlinesModel;
    private String selectedAirlineID; 
    //private PlaneDAO planeDAO;
    /**
     * Creates new form AirlineAD
     */
    public AirlineAD() throws ClassNotFoundException, SQLException, IOException{
        initComponents();
        styles();
        initAirline();
    }
    
    public AirlineAD(JFrame context, User user) throws ClassNotFoundException, SQLException, IOException{
        this.user = user;
        this.context = context;
        initComponents();
        styles();
        initAirline();        
    }
    
    public String getSelectedAirlineID() {
        return selectedAirlineID;
    }
    
    public void styles(){
        Styles.Table(tbAllAirline, pnAllAirline);
        Styles.ButtonSecondary(btAddAirline);
        
        lbTitle.setFont(Styles.H2);
        lbTitle.setForeground(Styles.GRAY_600);
        lbTotalAirlineHead.setFont(Styles.Body);
        lbTotalAirlineHead.setForeground(Styles.GRAY_600);
        lbTotalAirline.setFont(Styles.Body);
        lbTotalAirline.setForeground(Styles.GRAY_600);
        lbTotalAirlineTail.setFont(Styles.Body);
        lbTotalAirlineTail.setForeground(Styles.GRAY_600);
    }
    
    private void initAirline() throws ClassNotFoundException, SQLException, IOException {
        airlineBUS = new AirlineBUS();
        listAirline = airlineBUS.getList();
        AirlineViews airlineViews = new AirlineViews(listAirline);
        listAirlineView = airlineViews.getList();        
        airlinesModel = (DefaultTableModel) tbAllAirline.getModel();
        int stt = 1;
        for (AirlineView airlineView : listAirlineView){
            String airlineID = airlineView.MaHangMayBay;
            int numberOfPlanes = getNumberOfPlanesByAirlineID(airlineID);   
            airlinesModel.addRow(new Object[]{stt++, airlineView.MaHangMayBay, airlineView.TenHangBay, numberOfPlanes, stt });
        }
        lbTotalAirline.setText(--stt + "");
    }

    private int getNumberOfPlanesByAirlineID(String airlineID) throws ClassNotFoundException, SQLException, IOException {
        PlaneDAO planeDAO = new PlaneDAO();
        int numberOfPlanes = planeDAO.getNumberOfPlanesByAirlineID(airlineID);
        return numberOfPlanes;
    }     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        btAddAirline = new javax.swing.JButton();
        pnAllAirline = new javax.swing.JScrollPane();
        tbAllAirline = new javax.swing.JTable();
        lbTotalAirlineHead = new javax.swing.JLabel();
        lbTotalAirline = new javax.swing.JLabel();
        lbTotalAirlineTail = new javax.swing.JLabel();
        btRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(740, 490));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitle.setText("Danh sách các hãng bay");

        btAddAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png"))); // NOI18N
        btAddAirline.setText("Thêm hãng bay");
        btAddAirline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddAirlineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddAirlineMouseExited(evt);
            }
        });
        btAddAirline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddAirlineActionPerformed(evt);
            }
        });

        tbAllAirline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hãng bay", "Tên hãng bay", "Số máy bay", "Doanh thu"
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
        tbAllAirline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAllAirlineMouseClicked(evt);
            }
        });
        pnAllAirline.setViewportView(tbAllAirline);
        if (tbAllAirline.getColumnModel().getColumnCount() > 0) {
            tbAllAirline.getColumnModel().getColumn(0).setMinWidth(40);
            tbAllAirline.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        lbTotalAirlineHead.setFont(Styles.Micro);
        lbTotalAirlineHead.setText("Có tất cả");

        lbTotalAirline.setText("230");

        lbTotalAirlineTail.setFont(Styles.Micro);
        lbTotalAirlineTail.setText("chuyến bay");

        btRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-black18.png"))); // NOI18N
        btRefresh.setText("Làm mới");
        btRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btRefreshMouseExited(evt);
            }
        });
        btRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTotalAirlineHead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalAirline)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalAirlineTail)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnAllAirline, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btRefresh)
                                .addGap(18, 18, 18)
                                .addComponent(btAddAirline)))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btAddAirline, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(pnAllAirline, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotalAirlineHead)
                    .addComponent(lbTotalAirline)
                    .addComponent(lbTotalAirlineTail))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btAddAirlineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddAirlineMouseEntered
        btAddAirline.setBackground(Styles.PRI_NORMAL);
        btAddAirline.setForeground(Styles.WHITE);
        btAddAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-white18.png")));
    }//GEN-LAST:event_btAddAirlineMouseEntered

    private void btAddAirlineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddAirlineMouseExited
        btAddAirline.setBackground(Styles.PRI_LIGHTER);
        btAddAirline.setForeground(Styles.PRI_NORMAL);
        btAddAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png")));
    }//GEN-LAST:event_btAddAirlineMouseExited

    private void tbAllAirlineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAllAirlineMouseClicked
    int rowPosition = this.tbAllAirline.getSelectedRow();
    IndexAD indexAD = (IndexAD) context;

    try {
        // Lấy giá trị AirlineID từ cột đã chọn trong bảng tbAllAirline
        String airlineID = (String) tbAllAirline.getValueAt(rowPosition, 1);
        selectedAirlineID = airlineID;
        indexAD.setAirlineID(selectedAirlineID);
        indexAD.SiteOrder(Site.Order.AIRLINEPLANE);
        // Tạo đối tượng AirlinePlaneAD với đối số User
        //AirlinePlaneAD airlinePlaneAD = new AirlinePlaneAD(user);
        //airlinePlaneAD.setAirlineID(airlineID);
        //System.out.println(airlineID);
        //airlinePlaneAD.initPlane();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(AirlineAD.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(AirlineAD.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(AirlineAD.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_tbAllAirlineMouseClicked

    private void btAddAirlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddAirlineActionPerformed
        PuAirline puAirline= new PuAirline();
        puAirline.setVisible(true);
        puAirline.setLocationRelativeTo(null);
    }//GEN-LAST:event_btAddAirlineActionPerformed

    private void btRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRefreshMouseEntered
        btRefresh.setBackground(Styles.PRI_LIGHTER);
        btRefresh.setForeground(Styles.PRI_NORMAL);
        btRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-pri18.png")));
    }//GEN-LAST:event_btRefreshMouseEntered

    private void btRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRefreshMouseExited
        btRefresh.setBackground(Styles.GRAY_100);
        btRefresh.setForeground(Styles.GRAY_600);
        btRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-black18.png")));
    }//GEN-LAST:event_btRefreshMouseExited

    private void btRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshActionPerformed
        try {
            refreshAirlineList();
        } catch (IOException ex) {
            Logger.getLogger(AirlinePlaneAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirlinePlaneAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AirlinePlaneAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btRefreshActionPerformed
    public void refreshAirlineList() throws IOException, ClassNotFoundException, SQLException {
        airlinesModel.setRowCount(0); // Xóa các hàng hiện tại trong bảng   
        initAirline();
    }
//   
//       public void displayPlaneTableByAirlineID(String airlineID) throws ClassNotFoundException, SQLException, IOException {
//        // Gọi phương thức trong AirlinePlaneAD để hiển thị bảng Plane theo AirlineID
//        AirlinePlaneAD airlinePlaneAD = new AirlinePlaneAD();
//        airlinePlaneAD.
//    }
//    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddAirline;
    private javax.swing.JButton btRefresh;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTotalAirline;
    private javax.swing.JLabel lbTotalAirlineHead;
    private javax.swing.JLabel lbTotalAirlineTail;
    private javax.swing.JScrollPane pnAllAirline;
    private javax.swing.JTable tbAllAirline;
    // End of variables declaration//GEN-END:variables
}
