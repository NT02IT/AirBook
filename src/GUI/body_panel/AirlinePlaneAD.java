/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;
import BUS.PlaneBUS;
import DAO.PlaneDAO;
import DTO.entities.Plane;
import  assets.Styles;
import DTO.entities.User;
import DTO.views.MoreLuggageViews;
import DTO.views.MoreLuggageViews.MoreLuggageView;
import DTO.entities.MoreLuggage;
import BUS.MoreLuggageBUS;
import DAO.MoreLuggageDAO;
import DTO.views.PlaneViews;
import DTO.views.PlaneViews.PlaneView;
import GUI.popup.PuMoreLuggage;
import GUI.popup.PuPlaneAD;
import static assets.Styles.GRAY_100;
import static assets.Styles.GRAY_200;
import assets.TextBubbleBorder;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agond
 */
public class AirlinePlaneAD extends javax.swing.JPanel {

    private User user;
    private ArrayList<Plane> listPlane;
    private ArrayList<MoreLuggage> listMoreLuggage;
    private ArrayList<PlaneView> listPlaneView;
    private ArrayList<MoreLuggageView> listMoreLuggageView;    
    private PlaneBUS planeBUS;
    private MoreLuggageBUS moreLuggageBUS;
    private DefaultTableModel planesModel;
    private DefaultTableModel moreLuggageModel;    
    private static String planeID;
    private String airlineID;
    public AirlinePlaneAD() throws ClassNotFoundException, SQLException, IOException {
        initComponents();
        styles();
    }
    
    public AirlinePlaneAD(User user) throws ClassNotFoundException, SQLException, IOException {
        this.user = user;
        initComponents();
        styles();
        //initPlane();
    }
    
     public void setAirlineID(String airlineID){
         this.airlineID=airlineID;
     }
 
    public void initPlane() throws ClassNotFoundException, SQLException, IOException {
        planeBUS = new PlaneBUS();
        listPlane = planeBUS.getList();
        PlaneViews planeViews = new PlaneViews(listPlane);
        listPlaneView = planeViews.getList();
        planesModel = (DefaultTableModel) tbAllPlane.getModel();
        planesModel.setRowCount(0);
        int stt = 1;
        System.out.println(airlineID);
        for (PlaneView planeView : listPlaneView) {
            if(planeView.getAirlineID().equals(airlineID)){
                //System.out.println(AirlineID);
                planesModel.addRow(new Object[]{stt++, planeView.getPlaneID(), planeView.getPlaneName(), planeView.getSeats()});
                //System.out.println(planeView.TenMayBay);
            }
        }
    
        lbTotalPlane.setText(--stt + "");
    }
    
        public void initMoreLuggage() throws ClassNotFoundException, SQLException, IOException {
        moreLuggageBUS = new MoreLuggageBUS();
        listMoreLuggage = moreLuggageBUS.getList();
        MoreLuggageViews moreLuggageViews = new MoreLuggageViews(listMoreLuggage);
        listMoreLuggageView = moreLuggageViews.getList();
        moreLuggageModel = (DefaultTableModel) tbAllLugage.getModel();
        moreLuggageModel.setRowCount(0);
        int stt = 1;
        System.out.println(airlineID);
        for (MoreLuggageView moreLuggageView : listMoreLuggageView) {
            if(moreLuggageView.getAirlineID().equals(airlineID)){
                //System.out.println(AirlineID);
                moreLuggageModel.addRow(new Object[]{stt++, moreLuggageView.getLuggageWeight(), moreLuggageView.getPrice()});
                //System.out.println(planeView.TenMayBay);
            }
        }    
        //lbTotalPlane.setText(--stt + "");
    }



    public  void styles(){
        Styles.FormTextFeild(txtAirlineID);
        Styles.FormTextFeild(txtAirlineName);
        Styles.ButtonNeutral(btUpdateAirline);        
        Styles.ButtonNeutral(btRefresh );
        Styles.ButtonSecondary(btAddPlane);
        Styles.Table(tbAllPlane, pnAllPlane);
        Styles.ButtonSecondary(btAddLuggage);
        Styles.ButtonPrimary(btCancelEditPlane);
        Styles.ButtonDanger(btDeletePlane);
        Styles.ButtonSecondary(btAddLuggage);
        Styles.Table(tbAllLugage, pnAllLugage);
        
        pnMainBody.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            protected void configureScrollBarColors() {
                this.thumbColor = Styles.WHITE;
                this.scrollBarWidth = 0;
                this.trackColor = Styles.WHITE;
            }
        });
        TextBubbleBorder border = new TextBubbleBorder(GRAY_100, 0, 12, 0, true);
        pnPlaneDetail.setBorder(border);
        
        Styles.ComboBox(cbTicketClass);
        txtAllSeat.setBorder(border);
        txtAllSeat.setFont(Styles.Label);
        txtAllSeat.setForeground(Styles.PRI_NORMAL);
        txtAllSeat.setBackground(Styles.WHITE);
        
        lbAirlineName.setFont(Styles.Label);
        lbAirlineName.setForeground(Styles.WHITE);
        lbAirlineID.setFont(Styles.Label);
        lbAirlineID.setForeground(Styles.WHITE);
        
        lbTitlePlane.setFont(Styles.H2);
        lbTitlePlane.setForeground(Styles.GRAY_600);
        lbTitleMoreLuggage.setFont(Styles.H2);
        lbTitleMoreLuggage.setForeground(Styles.GRAY_600);
        
        lbTotalPlaneHead.setFont(Styles.Body);
        lbTotalPlaneHead.setForeground(Styles.GRAY_600);
        lbTotalPlane.setFont(Styles.Label);
        lbTotalPlane.setForeground(Styles.GRAY_600);
        lbTotalPlaneTail.setFont(Styles.Body);
        lbTotalPlaneTail.setForeground(Styles.GRAY_600);
        
        lbTotalOptionLugageHead.setFont(Styles.Body);
        lbTotalOptionLugageHead.setForeground(Styles.GRAY_600);
        lbTotalOptionLugage.setFont(Styles.Label);
        lbTotalOptionLugage.setForeground(Styles.GRAY_600);
        lbTotalOptionLugageTail.setFont(Styles.Body);
        lbTotalOptionLugageTail.setForeground(Styles.GRAY_600);
        

    }

public void displayPlaneTableByAirlineID(String airlineID) throws ClassNotFoundException, SQLException, IOException {
    // Xóa dữ liệu cũ trong bảng Plane
    planesModel.setRowCount(0);

    // Lấy danh sách máy bay theo AirlineID từ cơ sở dữ liệu hoặc nguồn dữ liệu tương ứng
    PlaneDAO planeDAO = new PlaneDAO();
    ArrayList<Plane> planeList = planeDAO.getPlaneListByAirlineID(airlineID);

    // Hiển thị dữ liệu máy bay trên bảng Plane
    int stt = 1;
    for (Plane plane : planeList) {
        planesModel.addRow(new Object[]{
            stt++,
            plane.getPlaneID(),
            plane.getPlaneName(),
            plane.getSeats()
            // Thêm các cột dữ liệu khác tương ứng với đối tượng Plane
        });
    }

    lbTotalPlane.setText(String.valueOf(stt - 1));
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnAirlineInfo = new javax.swing.JPanel();
        lbAirlineName = new javax.swing.JLabel();
        txtAirlineName = new javax.swing.JTextField();
        lbAirlineID = new javax.swing.JLabel();
        txtAirlineID = new javax.swing.JTextField();
        btUpdateAirline = new javax.swing.JButton();
        btRefresh = new javax.swing.JButton();
        pnPlaneDetail = new javax.swing.JPanel();
        lbPlaneName = new javax.swing.JLabel();
        lbPlaneID = new javax.swing.JLabel();
        lbTicketClass = new javax.swing.JLabel();
        pnAllSeat = new javax.swing.JScrollPane();
        txtAllSeat = new javax.swing.JTextArea();
        btCancelEditPlane = new javax.swing.JButton();
        cbTicketClass = new javax.swing.JComboBox<>();
        btDeletePlane = new javax.swing.JButton();
        pnMainBody = new javax.swing.JScrollPane();
        pnMain = new javax.swing.JPanel();
        pnPlanes = new javax.swing.JPanel();
        lbTitlePlane = new javax.swing.JLabel();
        btAddPlane = new javax.swing.JButton();
        pnAllPlane = new javax.swing.JScrollPane();
        tbAllPlane = new javax.swing.JTable();
        lbTotalPlaneHead = new javax.swing.JLabel();
        lbTotalPlane = new javax.swing.JLabel();
        lbTotalPlaneTail = new javax.swing.JLabel();
        pnMoreLugage = new javax.swing.JPanel();
        lbTitleMoreLuggage = new javax.swing.JLabel();
        btAddLuggage = new javax.swing.JButton();
        pnAllLugage = new javax.swing.JScrollPane();
        tbAllLugage = new javax.swing.JTable();
        lbTotalOptionLugageHead = new javax.swing.JLabel();
        lbTotalOptionLugage = new javax.swing.JLabel();
        lbTotalOptionLugageTail = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(740, 490));

        pnAirlineInfo.setBackground(new java.awt.Color(1, 104, 124));
        pnAirlineInfo.setForeground(Styles.WHITE);
        pnAirlineInfo.setMinimumSize(new java.awt.Dimension(100, 79));

        lbAirlineName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbAirlineName.setForeground(new java.awt.Color(255, 255, 255));
        lbAirlineName.setLabelFor(txtAirlineName);
        lbAirlineName.setText("Tên hãng bay");

        lbAirlineID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbAirlineID.setForeground(new java.awt.Color(255, 255, 255));
        lbAirlineID.setLabelFor(txtAirlineID);
        lbAirlineID.setText("Mã hãng bay");

        btUpdateAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-import-black18.png"))); // NOI18N
        btUpdateAirline.setText("Lưu sửa đổi");
        btUpdateAirline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btUpdateAirlineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btUpdateAirlineMouseExited(evt);
            }
        });
        btUpdateAirline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateAirlineActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout pnAirlineInfoLayout = new javax.swing.GroupLayout(pnAirlineInfo);
        pnAirlineInfo.setLayout(pnAirlineInfoLayout);
        pnAirlineInfoLayout.setHorizontalGroup(
            pnAirlineInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAirlineInfoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnAirlineInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAirlineName, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAirlineName))
                .addGap(12, 12, 12)
                .addGroup(pnAirlineInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAirlineID)
                    .addComponent(txtAirlineID, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(btUpdateAirline)
                .addGap(18, 18, 18)
                .addComponent(btRefresh)
                .addContainerGap())
        );
        pnAirlineInfoLayout.setVerticalGroup(
            pnAirlineInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAirlineInfoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnAirlineInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAirlineName)
                    .addComponent(lbAirlineID))
                .addGap(4, 4, 4)
                .addGroup(pnAirlineInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAirlineName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAirlineID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAirlineInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAirlineInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUpdateAirline, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pnPlaneDetail.setBackground(new java.awt.Color(230, 243, 246));

        lbPlaneName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbPlaneName.setForeground(Styles.GRAY_600);
        lbPlaneName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlaneName.setText("Boeing 787");

        lbPlaneID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlaneID.setText("ID: VN123");

        lbTicketClass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTicketClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-seat-black20.png"))); // NOI18N
        lbTicketClass.setText("Hạng ghế");

        pnAllSeat.setBorder(null);

        txtAllSeat.setColumns(20);
        txtAllSeat.setFont(Styles.Label);
        txtAllSeat.setLineWrap(true);
        txtAllSeat.setRows(5);
        txtAllSeat.setMinimumSize(new java.awt.Dimension(20, 20));
        pnAllSeat.setViewportView(txtAllSeat);

        btCancelEditPlane.setBackground(new java.awt.Color(1, 138, 165));
        btCancelEditPlane.setForeground(new java.awt.Color(255, 255, 255));
        btCancelEditPlane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-cancel-white18.png"))); // NOI18N
        btCancelEditPlane.setText("Hủy sửa đổi");
        btCancelEditPlane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btCancelEditPlaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btCancelEditPlaneMouseExited(evt);
            }
        });
        btCancelEditPlane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelEditPlaneActionPerformed(evt);
            }
        });

        btDeletePlane.setBackground(new java.awt.Color(255, 229, 211));
        btDeletePlane.setForeground(new java.awt.Color(255, 58, 40));
        btDeletePlane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png"))); // NOI18N
        btDeletePlane.setText("Xóa máy bay");
        btDeletePlane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDeletePlaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btDeletePlaneMouseExited(evt);
            }
        });
        btDeletePlane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletePlaneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPlaneDetailLayout = new javax.swing.GroupLayout(pnPlaneDetail);
        pnPlaneDetail.setLayout(pnPlaneDetailLayout);
        pnPlaneDetailLayout.setHorizontalGroup(
            pnPlaneDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbPlaneName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbPlaneID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbTicketClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnAllSeat, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(btCancelEditPlane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cbTicketClass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btDeletePlane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnPlaneDetailLayout.setVerticalGroup(
            pnPlaneDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlaneDetailLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbPlaneName)
                .addGap(4, 4, 4)
                .addComponent(lbPlaneID)
                .addGap(20, 20, 20)
                .addComponent(lbTicketClass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTicketClass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(pnAllSeat)
                .addGap(12, 12, 12)
                .addComponent(btDeletePlane, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btCancelEditPlane, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pnMainBody.setBackground(new java.awt.Color(255, 255, 255));
        pnMainBody.setBorder(null);
        pnMainBody.setHorizontalScrollBar(null);
        pnMainBody.setMinimumSize(new java.awt.Dimension(16, 490));
        pnMainBody.setPreferredSize(new java.awt.Dimension(100, 490));

        pnMain.setBackground(new java.awt.Color(255, 255, 255));

        pnPlanes.setBackground(new java.awt.Color(255, 255, 255));

        lbTitlePlane.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitlePlane.setForeground(Styles.GRAY_600);
        lbTitlePlane.setText("Danh sách máy bay");

        btAddPlane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png"))); // NOI18N
        btAddPlane.setText("Thêm máy bay");
        btAddPlane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddPlaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddPlaneMouseExited(evt);
            }
        });
        btAddPlane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddPlaneActionPerformed(evt);
            }
        });

        tbAllPlane.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã máy bay", "Tên máy bay", "Số ghế"
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
        tbAllPlane.setMinimumSize(new java.awt.Dimension(100, 80));
        pnAllPlane.setViewportView(tbAllPlane);
        if (tbAllPlane.getColumnModel().getColumnCount() > 0) {
            tbAllPlane.getColumnModel().getColumn(0).setMinWidth(40);
            tbAllPlane.getColumnModel().getColumn(0).setMaxWidth(50);
            tbAllPlane.getColumnModel().getColumn(3).setMinWidth(60);
            tbAllPlane.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        lbTotalPlaneHead.setFont(Styles.Micro);
        lbTotalPlaneHead.setText("Có tất cả");

        lbTotalPlane.setFont(Styles.Label);
        lbTotalPlane.setText("?");

        lbTotalPlaneTail.setFont(Styles.Micro);
        lbTotalPlaneTail.setText("máy bay");

        javax.swing.GroupLayout pnPlanesLayout = new javax.swing.GroupLayout(pnPlanes);
        pnPlanes.setLayout(pnPlanesLayout);
        pnPlanesLayout.setHorizontalGroup(
            pnPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlanesLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pnPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPlanesLayout.createSequentialGroup()
                        .addComponent(lbTitlePlane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAddPlane))
                    .addGroup(pnPlanesLayout.createSequentialGroup()
                        .addComponent(lbTotalPlaneHead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalPlane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalPlaneTail)
                        .addContainerGap())
                    .addComponent(pnAllPlane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)))
        );
        pnPlanesLayout.setVerticalGroup(
            pnPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlanesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitlePlane)
                    .addComponent(btAddPlane, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(pnAllPlane, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(pnPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotalPlaneHead)
                    .addComponent(lbTotalPlane)
                    .addComponent(lbTotalPlaneTail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnMoreLugage.setBackground(new java.awt.Color(255, 255, 255));

        lbTitleMoreLuggage.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitleMoreLuggage.setForeground(Styles.GRAY_600);
        lbTitleMoreLuggage.setText("Hành lý bổ sung");

        btAddLuggage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png"))); // NOI18N
        btAddLuggage.setText("Thêm HLBS");
        btAddLuggage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddLuggageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddLuggageMouseExited(evt);
            }
        });
        btAddLuggage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddLuggageActionPerformed(evt);
            }
        });

        tbAllLugage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Khối lượng (kg)", "Giá thành (đ)"
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
        pnAllLugage.setViewportView(tbAllLugage);
        if (tbAllLugage.getColumnModel().getColumnCount() > 0) {
            tbAllLugage.getColumnModel().getColumn(0).setMinWidth(40);
            tbAllLugage.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        lbTotalOptionLugageHead.setFont(Styles.Micro);
        lbTotalOptionLugageHead.setText("Có tất cả");

        lbTotalOptionLugage.setFont(Styles.Label);
        lbTotalOptionLugage.setText("?");

        lbTotalOptionLugageTail.setFont(Styles.Micro);
        lbTotalOptionLugageTail.setText("sự lựa chọn bổ sung");

        javax.swing.GroupLayout pnMoreLugageLayout = new javax.swing.GroupLayout(pnMoreLugage);
        pnMoreLugage.setLayout(pnMoreLugageLayout);
        pnMoreLugageLayout.setHorizontalGroup(
            pnMoreLugageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMoreLugageLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pnMoreLugageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMoreLugageLayout.createSequentialGroup()
                        .addComponent(lbTitleMoreLuggage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAddLuggage))
                    .addGroup(pnMoreLugageLayout.createSequentialGroup()
                        .addComponent(lbTotalOptionLugageHead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalOptionLugage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalOptionLugageTail)
                        .addContainerGap())
                    .addComponent(pnAllLugage, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        pnMoreLugageLayout.setVerticalGroup(
            pnMoreLugageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMoreLugageLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnMoreLugageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAddLuggage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTitleMoreLuggage))
                .addGap(12, 12, 12)
                .addComponent(pnAllLugage, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(pnMoreLugageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotalOptionLugage)
                    .addComponent(lbTotalOptionLugageTail)
                    .addComponent(lbTotalOptionLugageHead))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnMoreLugage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnPlanes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnPlanes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(pnMoreLugage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pnMainBody.setViewportView(pnMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnAirlineInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(pnMainBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnPlaneDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnAirlineInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnMainBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(pnPlaneDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void refreshPlaneList() throws IOException, ClassNotFoundException, SQLException {
        planesModel.setRowCount(0); // Xóa các hàng hiện tại trong bảng   
        initPlane();
    }
    
    public void refreshMoreLuggageList() throws IOException, ClassNotFoundException, SQLException {
        moreLuggageModel.setRowCount(0); // Xóa các hàng hiện tại trong bảng   
        initMoreLuggage();
    }
    
    private void btCancelEditPlaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelEditPlaneActionPerformed
        try {
            refreshPlaneList();
        } catch (IOException ex) {
            Logger.getLogger(AirlinePlaneAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirlinePlaneAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AirlinePlaneAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btCancelEditPlaneActionPerformed

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

    private void btUpdateAirlineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateAirlineMouseEntered
        btUpdateAirline.setBackground(Styles.FUNC_DANGER_LIGHT);
        btUpdateAirline.setForeground(Styles.FUNC_DANGER);
    }//GEN-LAST:event_btUpdateAirlineMouseEntered

    private void btUpdateAirlineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateAirlineMouseExited
        btUpdateAirline.setBackground(Styles.GRAY_100);
        btUpdateAirline.setForeground(Styles.GRAY_600);
    }//GEN-LAST:event_btUpdateAirlineMouseExited

    private void btCancelEditPlaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelEditPlaneMouseEntered
        btCancelEditPlane.setBackground(Styles.PRI_DARK);
    }//GEN-LAST:event_btCancelEditPlaneMouseEntered

    private void btCancelEditPlaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelEditPlaneMouseExited
        btCancelEditPlane.setBackground(Styles.PRI_NORMAL);
    }//GEN-LAST:event_btCancelEditPlaneMouseExited

    private void btAddPlaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddPlaneMouseEntered
        btAddPlane.setBackground(Styles.PRI_NORMAL);
        btAddPlane.setForeground(Styles.WHITE);
        btAddPlane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-white18.png")));
    }//GEN-LAST:event_btAddPlaneMouseEntered

    private void btAddPlaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddPlaneMouseExited
        btAddPlane.setBackground(Styles.PRI_LIGHTER);
        btAddPlane.setForeground(Styles.PRI_NORMAL);
        btAddPlane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png")));
    }//GEN-LAST:event_btAddPlaneMouseExited

    private void btAddLuggageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddLuggageMouseEntered
        btAddLuggage.setBackground(Styles.PRI_NORMAL);
        btAddLuggage.setForeground(Styles.WHITE);
        btAddLuggage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-white18.png")));
    }//GEN-LAST:event_btAddLuggageMouseEntered

    private void btAddLuggageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddLuggageMouseExited
        btAddLuggage.setBackground(Styles.PRI_LIGHTER);
        btAddLuggage.setForeground(Styles.PRI_NORMAL);
        btAddLuggage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-pri18.png")));
    }//GEN-LAST:event_btAddLuggageMouseExited

    private void btDeletePlaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeletePlaneMouseEntered
        btDeletePlane.setBackground(Styles.FUNC_DANGER);
        btDeletePlane.setForeground(Styles.WHITE);
        btDeletePlane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-white18.png")));
    }//GEN-LAST:event_btDeletePlaneMouseEntered

    private void btDeletePlaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeletePlaneMouseExited
        btDeletePlane.setBackground(Styles.FUNC_DANGER_LIGHT);
        btDeletePlane.setForeground(Styles.FUNC_DANGER);
        btDeletePlane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png")));
    }//GEN-LAST:event_btDeletePlaneMouseExited

    private void btDeletePlaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletePlaneActionPerformed
    int selectedRow = tbAllPlane.getSelectedRow();
    if (selectedRow >= 0) {
        int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa máy bay này?", "Xóa máy bay", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) tbAllPlane.getModel();
            String planeID = (String) model.getValueAt(selectedRow, 1); // Lấy ID của máy bay từ cột thích hợp trong bảng
            Plane plane = new Plane();
            plane.setPlaneID(planeID);
            try {
                planeBUS = new PlaneBUS();
                boolean deleteSuccess = planeBUS.delete(plane);
                if (deleteSuccess) {
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Đã xóa máy bay thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    refreshPlaneList();
                } else {
                    // Hiển thị thông báo xóa không thành công
                    JOptionPane.showMessageDialog(this, "Xóa máy bay không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                // Xử lý lỗi nếu có
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa máy bay", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(AirlinePlaneAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Hãy chọn một hàng để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btDeletePlaneActionPerformed

    private void btUpdateAirlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateAirlineActionPerformed
        int selectedRow = tbAllPlane.getSelectedRow();
        if (selectedRow == -1) {
            // Không có hàng nào được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đúng dòng bạn muốn cập nhật.");
            return;
        }

        String planeID = tbAllPlane.getValueAt(selectedRow, 1).toString();
        String planeName = tbAllPlane.getValueAt(selectedRow, 2).toString();
        int seats = Integer.parseInt(tbAllPlane.getValueAt(selectedRow, 3).toString());
        if (planeName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng không bỏ trống dữ liệu.");
            return;
        }
        Plane plane = new Plane();
        plane.setPlaneID(planeID);
        plane.setPlaneName(planeName);
        plane.setSeats(seats);
        
        try {
            planeBUS = new PlaneBUS();
            boolean success = planeBUS.update(plane);
            if (success) {
                JOptionPane.showMessageDialog(this, "Sửa đổi thông tin sân bay thành công.");
                // Cập nhật lại dữ liệu trên bảng
                DefaultTableModel model = (DefaultTableModel) tbAllPlane.getModel();
                model.setValueAt(plane.getPlaneName(), selectedRow, 2);
                model.setValueAt(plane.getSeats(), selectedRow, 3);
            } else {
                JOptionPane.showMessageDialog(this, "Sửa đổi thông tin sân bay không thành công.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PlaneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (IOException ex) {
            Logger.getLogger(AirlinePlaneAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btUpdateAirlineActionPerformed

    private void btAddPlaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddPlaneActionPerformed
        PuPlaneAD puPlaneAD= new PuPlaneAD();
        puPlaneAD.setAirPlaneID(airlineID);
        puPlaneAD.setVisible(true);
        puPlaneAD.setLocationRelativeTo(null);
    }//GEN-LAST:event_btAddPlaneActionPerformed

    private void btRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshActionPerformed
        try {
            refreshPlaneList();
            refreshMoreLuggageList();
        } catch (IOException ex) {
            Logger.getLogger(AirlinePlaneAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirlinePlaneAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AirlinePlaneAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btRefreshActionPerformed

    private void btAddLuggageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddLuggageActionPerformed
        PuMoreLuggage puMoreLuggage = new PuMoreLuggage();
        puMoreLuggage.setAirPlaneID(airlineID);
        puMoreLuggage.setVisible(true);
        puMoreLuggage.setLocationRelativeTo(null);
    }//GEN-LAST:event_btAddLuggageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddLuggage;
    private javax.swing.JButton btAddPlane;
    private javax.swing.JButton btCancelEditPlane;
    private javax.swing.JButton btDeletePlane;
    private javax.swing.JButton btRefresh;
    private javax.swing.JButton btUpdateAirline;
    private javax.swing.JComboBox<String> cbTicketClass;
    private javax.swing.JLabel lbAirlineID;
    private javax.swing.JLabel lbAirlineName;
    private javax.swing.JLabel lbPlaneID;
    private javax.swing.JLabel lbPlaneName;
    private javax.swing.JLabel lbTicketClass;
    private javax.swing.JLabel lbTitleMoreLuggage;
    private javax.swing.JLabel lbTitlePlane;
    private javax.swing.JLabel lbTotalOptionLugage;
    private javax.swing.JLabel lbTotalOptionLugageHead;
    private javax.swing.JLabel lbTotalOptionLugageTail;
    private javax.swing.JLabel lbTotalPlane;
    private javax.swing.JLabel lbTotalPlaneHead;
    private javax.swing.JLabel lbTotalPlaneTail;
    private javax.swing.JPanel pnAirlineInfo;
    private javax.swing.JScrollPane pnAllLugage;
    private javax.swing.JScrollPane pnAllPlane;
    private javax.swing.JScrollPane pnAllSeat;
    private javax.swing.JPanel pnMain;
    private javax.swing.JScrollPane pnMainBody;
    private javax.swing.JPanel pnMoreLugage;
    private javax.swing.JPanel pnPlaneDetail;
    private javax.swing.JPanel pnPlanes;
    private javax.swing.JTable tbAllLugage;
    private javax.swing.JTable tbAllPlane;
    private javax.swing.JTextField txtAirlineID;
    private javax.swing.JTextField txtAirlineName;
    private javax.swing.JTextArea txtAllSeat;
    // End of variables declaration//GEN-END:variables
}
