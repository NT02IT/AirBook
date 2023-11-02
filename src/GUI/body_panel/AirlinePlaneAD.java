/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;
import  assets.Styles;
import DTO.entities.User;
import static assets.Styles.GRAY_100;
import static assets.Styles.GRAY_200;
import assets.TextBubbleBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author agond
 */
public class AirlinePlaneAD extends javax.swing.JPanel {
    private User user;
    /**
     * Creates new form AirlinePlaneAD
     */
    public AirlinePlaneAD() {
        initComponents();
        styles();
    }
    
    public AirlinePlaneAD(User user) {
        this.user = user;
        initComponents();
        styles();
    }
    public  void styles(){
        Styles.FormTextFeild(txtAirlineID);
        Styles.FormTextFeild(txtAirlineName);
        Styles.ButtonNeutral(btDeleteAirline);        
        Styles.ButtonNeutral(btUpdateAirline );
        Styles.ButtonSecondary(btAddPlane);
        Styles.Table(tbAllPlane, pnAllPlane);
        Styles.ButtonSecondary(btAddLuggage);
        Styles.ButtonPrimary(btCancelEditPlane);
        Styles.ButtonDanger(btDeletePlane);
        Styles.ButtonPrimary(btUpdatePlane);
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnAirlineInfo = new javax.swing.JPanel();
        lbAirlineName = new javax.swing.JLabel();
        txtAirlineName = new javax.swing.JTextField();
        lbAirlineID = new javax.swing.JLabel();
        txtAirlineID = new javax.swing.JTextField();
        btDeleteAirline = new javax.swing.JButton();
        btUpdateAirline = new javax.swing.JButton();
        pnPlaneDetail = new javax.swing.JPanel();
        lbPlaneName = new javax.swing.JLabel();
        lbPlaneID = new javax.swing.JLabel();
        lbTicketClass = new javax.swing.JLabel();
        pnAllSeat = new javax.swing.JScrollPane();
        txtAllSeat = new javax.swing.JTextArea();
        btCancelEditPlane = new javax.swing.JButton();
        btUpdatePlane = new javax.swing.JButton();
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

        btDeleteAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-black18.png"))); // NOI18N
        btDeleteAirline.setText("Xóa");
        btDeleteAirline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDeleteAirlineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btDeleteAirlineMouseExited(evt);
            }
        });

        btUpdateAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-black18.png"))); // NOI18N
        btUpdateAirline.setText("Lưu sửa đổi");
        btUpdateAirline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btUpdateAirlineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btUpdateAirlineMouseExited(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(btUpdateAirline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDeleteAirline)
                .addGap(24, 24, 24))
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
                    .addComponent(btUpdateAirline, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDeleteAirline, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        btUpdatePlane.setBackground(new java.awt.Color(1, 138, 165));
        btUpdatePlane.setForeground(new java.awt.Color(255, 255, 255));
        btUpdatePlane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-white18.png"))); // NOI18N
        btUpdatePlane.setText("Sửa thông tin");
        btUpdatePlane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btUpdatePlaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btUpdatePlaneMouseExited(evt);
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
            .addComponent(pnAllSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(btCancelEditPlane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btUpdatePlane, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
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
                .addGap(10, 10, 10)
                .addComponent(btUpdatePlane, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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

    private void btCancelEditPlaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelEditPlaneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelEditPlaneActionPerformed

    private void btUpdateAirlineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateAirlineMouseEntered
        btUpdateAirline.setBackground(Styles.PRI_LIGHTER);
        btUpdateAirline.setForeground(Styles.PRI_NORMAL);
        btUpdateAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-pri18.png")));
    }//GEN-LAST:event_btUpdateAirlineMouseEntered

    private void btUpdateAirlineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateAirlineMouseExited
        btUpdateAirline.setBackground(Styles.GRAY_100);
        btUpdateAirline.setForeground(Styles.GRAY_600);
        btUpdateAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-black18.png")));
    }//GEN-LAST:event_btUpdateAirlineMouseExited

    private void btDeleteAirlineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeleteAirlineMouseEntered
        btDeleteAirline.setBackground(Styles.FUNC_DANGER_LIGHT);
        btDeleteAirline.setForeground(Styles.FUNC_DANGER);
        btDeleteAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png")));
    }//GEN-LAST:event_btDeleteAirlineMouseEntered

    private void btDeleteAirlineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeleteAirlineMouseExited
        btDeleteAirline.setBackground(Styles.GRAY_100);
        btDeleteAirline.setForeground(Styles.GRAY_600);
        btDeleteAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-black18.png")));
    }//GEN-LAST:event_btDeleteAirlineMouseExited

    private void btCancelEditPlaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelEditPlaneMouseEntered
        btCancelEditPlane.setBackground(Styles.PRI_DARK);
    }//GEN-LAST:event_btCancelEditPlaneMouseEntered

    private void btCancelEditPlaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelEditPlaneMouseExited
        btCancelEditPlane.setBackground(Styles.PRI_NORMAL);
    }//GEN-LAST:event_btCancelEditPlaneMouseExited

    private void btUpdatePlaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdatePlaneMouseEntered
        btUpdatePlane.setBackground(Styles.PRI_DARK);
    }//GEN-LAST:event_btUpdatePlaneMouseEntered

    private void btUpdatePlaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdatePlaneMouseExited
        btUpdatePlane.setBackground(Styles.PRI_NORMAL);
    }//GEN-LAST:event_btUpdatePlaneMouseExited

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
        // TODO add your handling code here:
    }//GEN-LAST:event_btDeletePlaneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddLuggage;
    private javax.swing.JButton btAddPlane;
    private javax.swing.JButton btCancelEditPlane;
    private javax.swing.JButton btDeleteAirline;
    private javax.swing.JButton btDeletePlane;
    private javax.swing.JButton btUpdateAirline;
    private javax.swing.JButton btUpdatePlane;
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
