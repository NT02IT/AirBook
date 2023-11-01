/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;

import DTO.entities.User;
import assets.Styles;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author agond
 */
public class MyTicketEUC extends javax.swing.JPanel {
    private User user;
    /**
     * Creates new form MyTicketEUC
     */
    public MyTicketEUC() {
        initComponents();
        style();
    }
    
    public MyTicketEUC(User user) {
        this.user = user;
        initComponents();
        style();
    }
    
    public void style(){
        Styles.Table(tbUnpaid, pnUnpaid);
        Styles.Table(tbFlightUpcoming, pnFlightUpcoming);
        Styles.Table(tbHistory, pnHistory);
        Styles.ButtonPrimary(btPayment);
        Styles.FormTextFeild(txtPromoCode);
        pnMainBody.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            protected void configureScrollBarColors() {
                this.thumbColor = Styles.GRAY_200;
                this.scrollBarWidth = 12;
                this.trackColor = Styles.GRAY_100;
            }
        });
        
        lbTitleUnpaid.setFont(Styles.H2);
        lbTitleUnpaid.setForeground(Styles.GRAY_600);
        lbPromoCode.setFont(Styles.Label);
        lbPromoCode.setForeground(Styles.GRAY_600);
        lbFlightUpcoming.setFont(Styles.H2);
        lbFlightUpcoming.setForeground(Styles.GRAY_600);
        lbHistory.setFont(Styles.H2);
        lbHistory.setForeground(Styles.GRAY_600);
        
        lbUnpaidTotalHead.setFont(Styles.Body);
        lbUnpaidTotalHead.setForeground(Styles.GRAY_600);
        lbUnpaidTotal.setFont(Styles.Label);
        lbUnpaidTotal.setForeground(Styles.GRAY_600);
        lbUnpaidTotalTail.setFont(Styles.Body);
        lbUnpaidTotalTail.setForeground(Styles.GRAY_600);
        
        lbFlightUpcomingTotalHead.setFont(Styles.Body);
        lbFlightUpcomingTotalHead.setForeground(Styles.GRAY_600);
        lbFlightUpcomingTotal.setFont(Styles.Label);
        lbFlightUpcomingTotal.setForeground(Styles.GRAY_600);
        lbFlightUpcomingTotalTail.setFont(Styles.Body);
        lbFlightUpcomingTotalTail.setForeground(Styles.GRAY_600);
        
        lbHistoryTotalHead.setFont(Styles.Body);
        lbHistoryTotalHead.setForeground(Styles.GRAY_600);
        lbHistoryTotal.setFont(Styles.Label);
        lbHistoryTotal.setForeground(Styles.GRAY_600);
        lbHistoryTotalTail.setFont(Styles.Body);
        lbHistoryTotalTail.setForeground(Styles.GRAY_600);
        
        lbTempPrice.setFont(Styles.Micro);
        lbTempPrice.setForeground(Styles.GRAY_600);
        lbDiscount.setFont(Styles.Micro);
        lbDiscount.setForeground(Styles.GRAY_600);
        lbTotal.setFont(Styles.Micro);
        lbTotal.setForeground(Styles.GRAY_600);
        
        lbTempPriceNum.setFont(Styles.Label);
        lbTempPriceNum.setForeground(Styles.GRAY_600);
        lbDiscountNum.setFont(Styles.Label);
        lbDiscountNum.setForeground(Styles.FUNC_DANGER);
        lbTotalNum.setFont(Styles.H1);
        lbTotalNum.setForeground(Styles.PRI_NORMAL);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMainBody = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lbTitleUnpaid = new javax.swing.JLabel();
        pnUnpaid = new javax.swing.JScrollPane();
        tbUnpaid = new javax.swing.JTable();
        lbUnpaidTotalTail = new javax.swing.JLabel();
        lbUnpaidTotalHead = new javax.swing.JLabel();
        lbUnpaidTotal = new javax.swing.JLabel();
        lbPromoCode = new javax.swing.JLabel();
        txtPromoCode = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lbTotal = new javax.swing.JLabel();
        lbTotalNum = new javax.swing.JLabel();
        btPayment = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lbTempPrice = new javax.swing.JLabel();
        lbTempPriceNum = new javax.swing.JLabel();
        lbDiscount = new javax.swing.JLabel();
        lbDiscountNum = new javax.swing.JLabel();
        lbFlightUpcoming = new javax.swing.JLabel();
        pnFlightUpcoming = new javax.swing.JScrollPane();
        tbFlightUpcoming = new javax.swing.JTable();
        lbFlightUpcomingTotalTail = new javax.swing.JLabel();
        lbFlightUpcomingTotalHead = new javax.swing.JLabel();
        lbFlightUpcomingTotal = new javax.swing.JLabel();
        lbHistory = new javax.swing.JLabel();
        pnHistory = new javax.swing.JScrollPane();
        tbHistory = new javax.swing.JTable();
        lbHistoryTotalTail = new javax.swing.JLabel();
        lbHistoryTotalHead = new javax.swing.JLabel();
        lbHistoryTotal = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        pnMainBody.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbTitleUnpaid.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitleUnpaid.setText("Vé chưa thanh toán");

        tbUnpaid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Hãng bay", "Ga đi", "Ga đến", "Khởi hành", "Giá vé"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUnpaid.getTableHeader().setReorderingAllowed(false);
        pnUnpaid.setViewportView(tbUnpaid);
        if (tbUnpaid.getColumnModel().getColumnCount() > 0) {
            tbUnpaid.getColumnModel().getColumn(0).setMinWidth(46);
            tbUnpaid.getColumnModel().getColumn(0).setMaxWidth(46);
        }

        lbUnpaidTotalTail.setFont(Styles.Micro);
        lbUnpaidTotalTail.setText("vé chưa thanh toán");

        lbUnpaidTotalHead.setFont(Styles.Micro);
        lbUnpaidTotalHead.setText("Có tất cả");

        lbUnpaidTotal.setText("?");

        lbPromoCode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPromoCode.setLabelFor(txtPromoCode);
        lbPromoCode.setText("Mã khuyến mãi");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lbTotal.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotal.setText("Tổng cộng");

        lbTotalNum.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTotalNum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotalNum.setText("20.000.000đ");

        btPayment.setBackground(new java.awt.Color(1, 138, 165));
        btPayment.setForeground(new java.awt.Color(255, 255, 255));
        btPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-tick-white18.png"))); // NOI18N
        btPayment.setText("Thanh toán");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lbTempPrice.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbTempPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTempPrice.setText("Tạm tính");

        lbTempPriceNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTempPriceNum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTempPriceNum.setText("20.000.000đ");

        lbDiscount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDiscount.setText("Giảm giá");

        lbDiscountNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDiscountNum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDiscountNum.setText("20.000.000đ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTempPrice)
                    .addComponent(lbTempPriceNum)
                    .addComponent(lbDiscount)
                    .addComponent(lbDiscountNum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTotalNum, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btPayment, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbTotal)
                        .addGap(4, 4, 4)
                        .addComponent(lbTotalNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbTempPrice)
                        .addGap(4, 4, 4)
                        .addComponent(lbTempPriceNum)
                        .addGap(8, 8, 8)
                        .addComponent(lbDiscount)
                        .addGap(4, 4, 4)
                        .addComponent(lbDiscountNum)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lbFlightUpcoming.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbFlightUpcoming.setText("Chuyến bay sắp tới");

        tbFlightUpcoming.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Hãng bay", "Ga đi", "Ga đến", "Khởi hành", "Giá vé"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFlightUpcoming.getTableHeader().setReorderingAllowed(false);
        pnFlightUpcoming.setViewportView(tbFlightUpcoming);
        if (tbFlightUpcoming.getColumnModel().getColumnCount() > 0) {
            tbFlightUpcoming.getColumnModel().getColumn(0).setMinWidth(46);
            tbFlightUpcoming.getColumnModel().getColumn(0).setMaxWidth(46);
        }

        lbFlightUpcomingTotalTail.setFont(Styles.Micro);
        lbFlightUpcomingTotalTail.setText("chuyến bay sắp tới");

        lbFlightUpcomingTotalHead.setFont(Styles.Micro);
        lbFlightUpcomingTotalHead.setText("Có tất cả");

        lbFlightUpcomingTotal.setText("?");

        lbHistory.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbHistory.setText("Lịch sử mua vé");

        tbHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Hãng bay", "Ga đi", "Ga đến", "Khởi hành", "Giá vé"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHistory.getTableHeader().setReorderingAllowed(false);
        pnHistory.setViewportView(tbHistory);
        if (tbHistory.getColumnModel().getColumnCount() > 0) {
            tbHistory.getColumnModel().getColumn(0).setMinWidth(46);
            tbHistory.getColumnModel().getColumn(0).setMaxWidth(46);
        }

        lbHistoryTotalTail.setFont(Styles.Micro);
        lbHistoryTotalTail.setText("đã được mua");

        lbHistoryTotalHead.setFont(Styles.Micro);
        lbHistoryTotalHead.setText("Có tất cả");

        lbHistoryTotal.setText("?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbUnpaidTotalHead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUnpaidTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUnpaidTotalTail)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnHistory, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnFlightUpcoming, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnUnpaid, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTitleUnpaid)
                                    .addComponent(lbPromoCode))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPromoCode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbHistoryTotalHead)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbHistoryTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbHistoryTotalTail))
                            .addComponent(lbHistory)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbFlightUpcomingTotalHead)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbFlightUpcomingTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbFlightUpcomingTotalTail))
                            .addComponent(lbFlightUpcoming))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbTitleUnpaid)
                .addGap(16, 16, 16)
                .addComponent(pnUnpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUnpaidTotalHead)
                    .addComponent(lbUnpaidTotalTail)
                    .addComponent(lbUnpaidTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbPromoCode)
                        .addGap(8, 8, 8)
                        .addComponent(txtPromoCode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(lbFlightUpcoming)
                .addGap(16, 16, 16)
                .addComponent(pnFlightUpcoming, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFlightUpcomingTotalHead)
                    .addComponent(lbFlightUpcomingTotalTail)
                    .addComponent(lbFlightUpcomingTotal))
                .addGap(24, 24, 24)
                .addComponent(lbHistory)
                .addGap(24, 24, 24)
                .addComponent(pnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHistoryTotalHead)
                    .addComponent(lbHistoryTotalTail)
                    .addComponent(lbHistoryTotal))
                .addGap(24, 24, 24))
        );

        pnMainBody.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMainBody)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMainBody, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPayment;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbDiscount;
    private javax.swing.JLabel lbDiscountNum;
    private javax.swing.JLabel lbFlightUpcoming;
    private javax.swing.JLabel lbFlightUpcomingTotal;
    private javax.swing.JLabel lbFlightUpcomingTotalHead;
    private javax.swing.JLabel lbFlightUpcomingTotalTail;
    private javax.swing.JLabel lbHistory;
    private javax.swing.JLabel lbHistoryTotal;
    private javax.swing.JLabel lbHistoryTotalHead;
    private javax.swing.JLabel lbHistoryTotalTail;
    private javax.swing.JLabel lbPromoCode;
    private javax.swing.JLabel lbTempPrice;
    private javax.swing.JLabel lbTempPriceNum;
    private javax.swing.JLabel lbTitleUnpaid;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotalNum;
    private javax.swing.JLabel lbUnpaidTotal;
    private javax.swing.JLabel lbUnpaidTotalHead;
    private javax.swing.JLabel lbUnpaidTotalTail;
    private javax.swing.JScrollPane pnFlightUpcoming;
    private javax.swing.JScrollPane pnHistory;
    private javax.swing.JScrollPane pnMainBody;
    private javax.swing.JScrollPane pnUnpaid;
    private javax.swing.JTable tbFlightUpcoming;
    private javax.swing.JTable tbHistory;
    private javax.swing.JTable tbUnpaid;
    private javax.swing.JTextField txtPromoCode;
    // End of variables declaration//GEN-END:variables
}
