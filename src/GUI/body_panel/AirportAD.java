/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;
import BUS.AirportBUS;
import DAO.AirportDAO;
import DTO.entities.Airport;
import DTO.entities.User;
import DTO.views.AirportViews;
import DTO.views.AirportViews.AirportView;
import GUI.popup.PuAirportAD;
import assets.Styles;
import DTO.entities.User;
import assets.TextBubbleBorder;
import java.awt.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agond
 */
public class AirportAD extends javax.swing.JPanel {
    private User user;
    private ArrayList<Airport> listAirport;
    private ArrayList<AirportView> listAirportView;
    private AirportBUS airportBUS;
    private DefaultTableModel airportsModel;
    private static String airportID;
    /**
     * Creates new form AirportAD
     */
    public AirportAD() throws ClassNotFoundException, SQLException, IOException {
        initComponents();
        styles();
        initAirport();
    }
    
    public AirportAD(User user) throws ClassNotFoundException, SQLException, IOException {
        this.user = user;
        //this.airportID = airportID;
        initComponents();
        styles();
        initAirport();        
    }
    
    

    
    public  void  styles(){
        Styles.Table(tbAllAirport, pnAllAirport);
        Styles.ButtonPrimary(btCancelEditAirport);
        Styles.ButtonDanger(btDeleteAirport);
        Styles.ButtonPrimary(btUpdateAirport);
        Styles.ButtonSecondary(btAddAirport);
        
        lbTitle.setFont(Styles.H2);
        lbTitle.setForeground(Styles.GRAY_600);
        lbTotalAirportHead.setFont(Styles.Body);
        lbTotalAirportHead.setForeground(Styles.GRAY_600);
        lbTotalAirport.setFont(Styles.Label);
        lbTotalAirport.setForeground(Styles.GRAY_600);
        lbTotalAirportTail.setFont(Styles.Body);
        lbTotalAirportTail.setForeground(Styles.GRAY_600);
        
        TextBubbleBorder border = new TextBubbleBorder(Styles.PRI_LIGHTER, 0, 12, 0, true);
        pnAirportDetail.setBorder(border);
        
        txtAllGate.setBorder(border);
        txtAllGate.setFont(Styles.Label);
        txtAllGate.setForeground(Styles.PRI_NORMAL);
        txtAllGate.setBackground(Styles.WHITE);
        
    }
    
    private Airport getSelectedAirport() {
        int selectedRow = tbAllAirport.getSelectedRow();
        if (selectedRow != -1) {
        // Lấy thông tin của sân bay từ bảng danh sách sân bay
             int stt = (int) tbAllAirport.getValueAt(selectedRow, 0);
            String airportID = (String) tbAllAirport.getValueAt(selectedRow, 1);
            String airportName = (String) tbAllAirport.getValueAt(selectedRow, 2);
            String province = (String) tbAllAirport.getValueAt(selectedRow, 3);


        // Tạo đối tượng sân bay
            Airport selectedAirport = new Airport();
            selectedAirport.setAirportID(airportID);
            selectedAirport.setAirportName(airportName);
            selectedAirport.setProvince(province);
            selectedAirport.setIsDelete(stt);

            return selectedAirport;
        }
        return null;
    }
    
    public void refreshAirportList() throws IOException {
        try {
            // Tạo đối tượng AirportDAO
            AirportDAO airportDAO = new AirportDAO();

            // Gọi phương thức đọc lại danh sách sân bay từ đối tượng AirportDAO
            ArrayList<Airport> airportList = airportDAO.getList();

            // Cập nhật danh sách sân bay trong giao diện người dùng
            DefaultTableModel model = (DefaultTableModel) tbAllAirport.getModel();
            model.setRowCount(0); // Xóa các hàng hiện tại trong bảng           
            for (int i = 0; i < airportList.size(); i++) {
                Airport airport = airportList.get(i);
                Object[] rowData = { i+1, airport.getAirportID(), airport.getAirportName(), airport.getProvince() };
                model.addRow(rowData); // Thêm hàng mới vào bảng
            }
        } catch (ClassNotFoundException | SQLException ex) {
            // Xử lý lỗi nếu có
            ex.printStackTrace();
        }
    }
    
    private void initAirport() throws ClassNotFoundException, SQLException, IOException{
        airportBUS = new AirportBUS();
        listAirport = airportBUS.getList();
        AirportViews airportViews = new AirportViews(listAirport);
        listAirportView = airportViews.getList();
        
        airportsModel = (DefaultTableModel) tbAllAirport.getModel();
        int stt = 1;
        for (AirportView airportView : listAirportView){
            airportsModel.addRow(new Object[]{stt++, airportView.MaCang, airportView.TenCang, airportView.ThanhPho});
        }
        
        lbTotalAirport.setText(--stt + "");
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        btAddAirport = new javax.swing.JButton();
        pnAllAirport = new javax.swing.JScrollPane();
        tbAllAirport = new javax.swing.JTable();
        lbTotalAirportHead = new javax.swing.JLabel();
        lbTotalAirport = new javax.swing.JLabel();
        lbTotalAirportTail = new javax.swing.JLabel();
        pnAirportDetail = new javax.swing.JPanel();
        lbGate = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAllGate = new javax.swing.JTextArea();
        btCancelEditAirport = new javax.swing.JButton();
        btUpdateAirport = new javax.swing.JButton();
        btDeleteAirport = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 450));
        jPanel1.setPreferredSize(new java.awt.Dimension(560, 450));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitle.setText("Danh sách các sân bay");

        btAddAirport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png"))); // NOI18N
        btAddAirport.setText("Thêm sân bay");
        btAddAirport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddAirportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddAirportMouseExited(evt);
            }
        });
        btAddAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddAirportActionPerformed(evt);
            }
        });

        tbAllAirport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã cảng", "Tên cảng", "Tỉnh thành"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnAllAirport.setViewportView(tbAllAirport);
        if (tbAllAirport.getColumnModel().getColumnCount() > 0) {
            tbAllAirport.getColumnModel().getColumn(0).setMinWidth(40);
            tbAllAirport.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        lbTotalAirportHead.setFont(Styles.Micro);
        lbTotalAirportHead.setText("Có tất cả");

        lbTotalAirport.setText("64");

        lbTotalAirportTail.setFont(Styles.Micro);
        lbTotalAirportTail.setText("sân bay");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbTotalAirportHead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalAirport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalAirportTail)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnAllAirport, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAddAirport))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle)
                    .addComponent(btAddAirport, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(pnAllAirport, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotalAirportHead)
                    .addComponent(lbTotalAirport)
                    .addComponent(lbTotalAirportTail))
                .addGap(24, 24, 24))
        );

        pnAirportDetail.setBackground(Styles.PRI_LIGHTER);

        lbGate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-login-black20.png"))); // NOI18N
        lbGate.setText("Cổng");

        txtAllGate.setColumns(20);
        txtAllGate.setFont(Styles.Label);
        txtAllGate.setForeground(Styles.PRI_NORMAL);
        txtAllGate.setLineWrap(true);
        txtAllGate.setRows(5);
        txtAllGate.setText("A1, A2, A3");
        jScrollPane2.setViewportView(txtAllGate);

        btCancelEditAirport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-cancel-white18.png"))); // NOI18N
        btCancelEditAirport.setText("Hủy sửa đổi");
        btCancelEditAirport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btCancelEditAirportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btCancelEditAirportMouseExited(evt);
            }
        });
        btCancelEditAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelEditAirportActionPerformed(evt);
            }
        });

        btUpdateAirport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-white18.png"))); // NOI18N
        btUpdateAirport.setText("Cập nhật sân bay");
        btUpdateAirport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btUpdateAirportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btUpdateAirportMouseExited(evt);
            }
        });
        btUpdateAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateAirportActionPerformed(evt);
            }
        });

        btDeleteAirport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png"))); // NOI18N
        btDeleteAirport.setText("Xóa sân bay");
        btDeleteAirport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDeleteAirportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btDeleteAirportMouseExited(evt);
            }
        });
        btDeleteAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteAirportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnAirportDetailLayout = new javax.swing.GroupLayout(pnAirportDetail);
        pnAirportDetail.setLayout(pnAirportDetailLayout);
        pnAirportDetailLayout.setHorizontalGroup(
            pnAirportDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbGate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(btCancelEditAirport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btUpdateAirport, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
            .addComponent(btDeleteAirport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnAirportDetailLayout.setVerticalGroup(
            pnAirportDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAirportDetailLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(lbGate)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(btDeleteAirport, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btCancelEditAirport, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btUpdateAirport, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(pnAirportDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(pnAirportDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btAddAirportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddAirportMouseEntered
        btAddAirport.setBackground(Styles.PRI_NORMAL);
        btAddAirport.setForeground(Styles.WHITE);
        btAddAirport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-white18.png")));
    }//GEN-LAST:event_btAddAirportMouseEntered

    private void btAddAirportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddAirportMouseExited
        btAddAirport.setBackground(Styles.PRI_LIGHTER);
        btAddAirport.setForeground(Styles.PRI_NORMAL);
        btAddAirport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png")));
    }//GEN-LAST:event_btAddAirportMouseExited

    private void btUpdateAirportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateAirportMouseEntered
        btUpdateAirport.setBackground(Styles.PRI_DARK);
    }//GEN-LAST:event_btUpdateAirportMouseEntered

    private void btUpdateAirportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateAirportMouseExited
        btUpdateAirport.setBackground(Styles.PRI_NORMAL);
    }//GEN-LAST:event_btUpdateAirportMouseExited

    private void btCancelEditAirportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelEditAirportMouseEntered
        btCancelEditAirport.setBackground(Styles.PRI_DARK);
    }//GEN-LAST:event_btCancelEditAirportMouseEntered

    private void btCancelEditAirportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelEditAirportMouseExited
        btCancelEditAirport.setBackground(Styles.PRI_NORMAL);
    }//GEN-LAST:event_btCancelEditAirportMouseExited

    private void btDeleteAirportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeleteAirportMouseEntered
        btDeleteAirport.setBackground(Styles.FUNC_DANGER);
        btDeleteAirport.setForeground(Styles.WHITE);
        btDeleteAirport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-white18.png")));
    
    }//GEN-LAST:event_btDeleteAirportMouseEntered

    private void btDeleteAirportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeleteAirportMouseExited
    btDeleteAirport.setBackground(Styles.FUNC_DANGER_LIGHT);
    btDeleteAirport.setForeground(Styles.FUNC_DANGER);
    btDeleteAirport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png")));    
    }//GEN-LAST:event_btDeleteAirportMouseExited

    private void btDeleteAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteAirportActionPerformed
    // Xử lý sự kiện khi người dùng nhấn nút xóa sân bay
    int selectedRow = tbAllAirport.getSelectedRow();
    if (selectedRow >= 0) {
        int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sân bay này?", "Xóa sân bay", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) tbAllAirport.getModel();
            String airportID = (String) model.getValueAt(selectedRow, 1); // Lấy giá trị ID của sân bay từ mô hình bảng
            // Tạo đối tượng Airport từ airportID
            Airport airport = new Airport();
            airport.setAirportID(airportID);

            // Xóa dữ liệu trong cơ sở dữ liệu
            try {
                // Tạo đối tượng AirportDAO
                AirportDAO airportDAO = new AirportDAO();

                // Gọi phương thức xóa sân bay từ đối tượng AirportDAO
                boolean deleteSuccess = airportDAO.deleteAirport(airport);

                if (deleteSuccess) {
                    // Xóa hàng trong bảng
                    model.removeRow(selectedRow);

                    // Hiển thị thông báo xóa thành công
                    JOptionPane.showMessageDialog(this, "Đã xóa sân bay thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    refreshAirportList();
                } else {
                    // Hiển thị thông báo xóa không thành công
                    JOptionPane.showMessageDialog(this, "Xóa sân bay không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                // Xử lý lỗi nếu có
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa sân bay", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(AirportAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Hãy chọn một hàng để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btDeleteAirportActionPerformed

    private void btAddAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddAirportActionPerformed
        PuAirportAD puAirportAD= new PuAirportAD();
        puAirportAD.setVisible(true);
        puAirportAD.setLocationRelativeTo(null);
    }//GEN-LAST:event_btAddAirportActionPerformed

    private void btCancelEditAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelEditAirportActionPerformed
        try {
            refreshAirportList();
        } catch (IOException ex) {
            Logger.getLogger(AirportAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btCancelEditAirportActionPerformed

    private void btUpdateAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateAirportActionPerformed
    // Lấy dữ liệu từ các cột trên bảng
        int selectedRow = tbAllAirport.getSelectedRow();
        if (selectedRow == -1) {
            // Không có hàng nào được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đúng dòng bạn muốn cập nhật.");
            return;
        }

        String airportID = tbAllAirport.getValueAt(selectedRow, 1).toString();
        String airportName = tbAllAirport.getValueAt(selectedRow, 2).toString();
        String province = tbAllAirport.getValueAt(selectedRow, 3).toString();
        if (province.isEmpty()||airportName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng không bỏ trống dữ liệu.");
            return;
        }
        Airport airport = new Airport();
        airport.setAirportID(airportID);
        airport.setAirportName(airportName);
        airport.setProvince(province);
        
        try {
            AirportDAO airportDAO = new AirportDAO();
            boolean success = airportDAO.updateAirport(airport);
            if (success) {
                JOptionPane.showMessageDialog(this, "Sửa đổi thông tin sân bay thành công.");

                // Cập nhật lại dữ liệu trên bảng
                DefaultTableModel model = (DefaultTableModel) tbAllAirport.getModel();
                model.setValueAt(airport.getAirportName(), selectedRow, 2);
                model.setValueAt(airport.getProvince(), selectedRow, 3);
            } else {
                JOptionPane.showMessageDialog(this, "Sửa đổi thông tin sân bay không thành công.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AirportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (IOException ex) {
            Logger.getLogger(AirportAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btUpdateAirportActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddAirport;
    private javax.swing.JButton btCancelEditAirport;
    private javax.swing.JButton btDeleteAirport;
    private javax.swing.JButton btUpdateAirport;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbGate;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTotalAirport;
    private javax.swing.JLabel lbTotalAirportHead;
    private javax.swing.JLabel lbTotalAirportTail;
    private javax.swing.JPanel pnAirportDetail;
    private javax.swing.JScrollPane pnAllAirport;
    private javax.swing.JTable tbAllAirport;
    private javax.swing.JTextArea txtAllGate;
    // End of variables declaration//GEN-END:variables
}
