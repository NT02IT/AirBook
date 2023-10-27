/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;
import assets.Styles;
import DTO.entities.User;

/**
 *
 * @author agond
 */
public class TicketAD extends javax.swing.JPanel {
    private User user;
    /**
     * Creates new form TicketAD
     */
    public TicketAD() {
        initComponents();
        styles();
    }
    
    public TicketAD(User user) {
        this.user = user;
        initComponents();
        styles();
    }
    public void styles(){
        Styles.ButtonNeutral(btAddTicket);        
        Styles.ButtonNeutral(btExportTicket);
        Styles.ButtonNeutral(btImportTicket);
        Styles.ButtonSecondary(btSearchTicket);
        Styles.Table(tbAllTicket, pnAllTicket);
        
        lbTitle.setFont(Styles.H2);
        lbTitle.setForeground(Styles.GRAY_600);
        lbTotalTicketHead.setFont(Styles.Body);
        lbTotalTicketHead.setForeground(Styles.GRAY_600);
        lbTotalTicket.setFont(Styles.Label);
        lbTotalTicket.setForeground(Styles.GRAY_600);
        lbTotalTicketTail.setFont(Styles.Body);
        lbTotalTicketTail.setForeground(Styles.GRAY_600);
    }    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSearchTicket = new javax.swing.JButton();
        btImportTicket = new javax.swing.JButton();
        lbTitle = new javax.swing.JLabel();
        btAddTicket = new javax.swing.JButton();
        btExportTicket = new javax.swing.JButton();
        pnAllTicket = new javax.swing.JScrollPane();
        tbAllTicket = new javax.swing.JTable();
        lbTotalTicketHead = new javax.swing.JLabel();
        lbTotalTicket = new javax.swing.JLabel();
        lbTotalTicketTail = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(740, 490));
        setPreferredSize(new java.awt.Dimension(740, 540));

        btSearchTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-search-pri18.png"))); // NOI18N
        btSearchTicket.setText("Tìm kiếm");

        btImportTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-import-black18.png"))); // NOI18N

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitle.setText("Quản lý chuyến bay");

        btAddTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-black18.png"))); // NOI18N

        btExportTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-export-black18.png"))); // NOI18N

        tbAllTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Hãy bay", "Ga đi", "Ga đến", "Khởi hành", "Thời gian bay", "Còn lại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnAllTicket.setViewportView(tbAllTicket);
        if (tbAllTicket.getColumnModel().getColumnCount() > 0) {
            tbAllTicket.getColumnModel().getColumn(0).setMinWidth(40);
            tbAllTicket.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        lbTotalTicketHead.setFont(Styles.Micro);
        lbTotalTicketHead.setText("Có tất cả");

        lbTotalTicket.setFont(Styles.Label);
        lbTotalTicket.setText("?");

        lbTotalTicketTail.setFont(Styles.Micro);
        lbTotalTicketTail.setText("mã khuyến mãi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTotalTicketHead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalTicketTail)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnAllTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btExportTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btImportTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btAddTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btSearchTicket)))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle)
                            .addComponent(btExportTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(pnAllTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTotalTicketHead)
                            .addComponent(lbTotalTicket)
                            .addComponent(lbTotalTicketTail))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btImportTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAddTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSearchTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(482, 482, 482))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddTicket;
    private javax.swing.JButton btExportTicket;
    private javax.swing.JButton btImportTicket;
    private javax.swing.JButton btSearchTicket;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTotalTicket;
    private javax.swing.JLabel lbTotalTicketHead;
    private javax.swing.JLabel lbTotalTicketTail;
    private javax.swing.JScrollPane pnAllTicket;
    private javax.swing.JTable tbAllTicket;
    // End of variables declaration//GEN-END:variables
}
