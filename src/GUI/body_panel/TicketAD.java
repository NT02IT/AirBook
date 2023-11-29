/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;
import BUS.AirlineBUS;
import BUS.AirportBUS;
import BUS.FlightBUS;
import BUS.PermissionBUS;
import BUS.PlaneBUS;
import BUS.SeatBUS;
import BUS.TicketBUS;
import BUS.TicketClassBUS;
import DTO.entities.Airline;
import DTO.entities.Flight;
import DTO.entities.Plane;
import DTO.entities.Seat;
import DTO.entities.Ticket;
import DTO.entities.TicketClass;
import assets.Styles;
import DTO.entities.User;
import DTO.views.TicketView;
import GUI.popup.PuTicketSearchAD;
import GUI.popup.puTicketAD;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agond
 */
public class TicketAD extends javax.swing.JPanel {
    private User user;
    private TicketBUS ticketBUS;
    private FlightBUS flightBUS;
    private AirlineBUS airlineBUS;
    private PermissionBUS permissionBUS;
    private DefaultTableModel ticketModel; 
    
    private AirportBUS airportBUS;
    private SeatBUS seatBUS;
    private TicketClassBUS ticketClassBUS;
    private PlaneBUS planeBUS;
    
    private TicketView ticketView;
    
    private ArrayList<Ticket> ticketList;    
    private ArrayList<Flight> flightList;
    private ArrayList<Airline> airlineList;
    private ArrayList<Ticket> listTicket;
    private Map<String,ArrayList<Ticket>> listTicketView;
    private Map<String, ArrayList<Ticket>> mapRowTicket;

    /**
     * Creates new form TicketAD
     */
    public TicketAD() {
        initComponents();
        styles();
    }
    
    public TicketAD(User user) {
        try {
            this.user = user;
            this.ticketBUS = new TicketBUS();
            this.flightBUS = new FlightBUS();
            this.airlineBUS = new AirlineBUS();
            this.permissionBUS = new PermissionBUS();
            this.listTicket = ticketBUS.getList();
            airportBUS = new AirportBUS();
            this.seatBUS = new SeatBUS();
            this.ticketClassBUS = new TicketClassBUS();
            this.planeBUS = new PlaneBUS();
            initComponents();
            styles();
            flightList = flightBUS.getList();
            this.airlineList = airlineBUS.getList();
            ticketView = new TicketView(listTicket); 
            listTicketView = ticketView.getList();
            ticketModel = (DefaultTableModel) tbAllTicket.getModel();
            mapRowTicket = new HashMap<String, ArrayList<Ticket>>();
            initTickets();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TicketAD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void initAccessPerRole() {
        User userLogin = (User) this.user;
        if(permissionBUS.hasPerCreate(userLogin.getRoleID(), "TIK")) {
            btAddTicket.setEnabled(true);
            btImportTicket.setEnabled(true);
        }
        else {
            btAddTicket.setEnabled(false);
            btImportTicket.setEnabled(false );
        }
        
    }
    public void initTickets() throws ClassNotFoundException, SQLException, IOException{       
        int stt = 1;
        String airline, flyingFrom, flyingTo, remain;
        String departureFlight;
        String hoursFly;
        Flight flight;
        Ticket ticket;
        
        int totalTicketRemain = 0;
        for(Map.Entry<String, ArrayList<Ticket>> entry : listTicketView.entrySet()){
            ticket = entry.getValue().get(0);
            flight = flightBUS.getObjectbyID(ticket.getFlightID());
            
            flyingFrom = airportBUS.getObjectbyID(flight.getFlyingFrom()).getAirportName();
            flyingTo = airportBUS.getObjectbyID(flight.getFlyingTo()).getAirportName();
            hoursFly = flight.getHoursFly() + " giờ";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            departureFlight = flight.getDepartureFlight().format(formatter);
            
            int remainTicket = 0;
            int totalTicket = 0;
            for(Ticket tk : entry.getValue()){
                totalTicket++;
                if(tk.getSoldout() == 0) remainTicket++;
            }
            totalTicketRemain += remainTicket;
            remain = remainTicket + "/" + totalTicket;
            
            Seat seat = seatBUS.getObjectbyID(ticket.getSeatID());
            TicketClass ticketClass = ticketClassBUS.getObjectbyID(seat.getTicketClassID());
            Plane plane = planeBUS.getObjectbyID(ticketClass.getPlaneID());
            airline = airlineBUS.getObjectbyID(plane.getAirlineID()).getAirlineName();            
            
            ticketModel.addRow(new Object[]{stt++, airline, flyingFrom, flyingTo, departureFlight, hoursFly, remain});
            String key = airline + flyingFrom + flyingTo + departureFlight;            
            mapRowTicket.put(key, entry.getValue());
        }
        
//        for (TicketView ticketView : listTicketView){
//            airline = ticketView.airline;
//            flyingFrom = ticketView.flyingFrom;
//            flyingTo = ticketView.flyingTo;
//            remain = ticketView.remain + "/" + ticketView.quantity;
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//            departureFlight = ticketView.departureFlight.format(formatter);
//            hoursFly = ticketView.hoursFly + " giờ";
//            ticketsModel.addRow(new Object[]{stt++, airline, flyingFrom, flyingTo, departureFlight, hoursFly, remain});
//        }
        
//        int ticketCount = 0;
//        for(TicketView item : listTicketView){
//            ticketCount += item.remain;
//        }
//        lbToltalTicket.setText(totalTicketRemain + "");
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
        btSearchTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSearchTicketMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSearchTicketMouseExited(evt);
            }
        });
        btSearchTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchTicketActionPerformed(evt);
            }
        });

        btImportTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-import-black18.png"))); // NOI18N
        btImportTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btImportTicketMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btImportTicketMouseExited(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitle.setText("Quản lý chuyến bay");

        btAddTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-black18.png"))); // NOI18N
        btAddTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddTicketMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddTicketMouseExited(evt);
            }
        });
        btAddTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddTicketActionPerformed(evt);
            }
        });

        btExportTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-export-black18.png"))); // NOI18N
        btExportTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btExportTicketMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btExportTicketMouseExited(evt);
            }
        });

        tbAllTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tbAllTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAllTicketMouseClicked(evt);
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

    private void btSearchTicketMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchTicketMouseEntered
        btSearchTicket.setBackground(Styles.PRI_NORMAL);
        btSearchTicket.setForeground(Styles.WHITE);
        btSearchTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-search-white18.png")));
    }//GEN-LAST:event_btSearchTicketMouseEntered

    private void btSearchTicketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchTicketMouseExited
        btSearchTicket.setBackground(Styles.PRI_LIGHTER);
        btSearchTicket.setForeground(Styles.PRI_NORMAL);
        btSearchTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-search-pri18.png")));
    }//GEN-LAST:event_btSearchTicketMouseExited

    private void btAddTicketMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddTicketMouseEntered
        btAddTicket.setBackground(Styles.PRI_NORMAL);
        btAddTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-white18.png")));
    }//GEN-LAST:event_btAddTicketMouseEntered

    private void btAddTicketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddTicketMouseExited
        btAddTicket.setBackground(Styles.GRAY_100);
        btAddTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-black18.png")));
    }//GEN-LAST:event_btAddTicketMouseExited

    private void btImportTicketMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImportTicketMouseEntered
        btImportTicket.setBackground(Styles.PRI_NORMAL);
        btImportTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-import-white18.png")));
    }//GEN-LAST:event_btImportTicketMouseEntered

    private void btImportTicketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImportTicketMouseExited
        btImportTicket.setBackground(Styles.GRAY_100);
        btImportTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-import-black18.png")));
    }//GEN-LAST:event_btImportTicketMouseExited

    private void btExportTicketMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExportTicketMouseEntered
        btExportTicket.setBackground(Styles.PRI_NORMAL);
        btExportTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-export-white18.png")));
    }//GEN-LAST:event_btExportTicketMouseEntered

    private void btExportTicketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExportTicketMouseExited
        btExportTicket.setBackground(Styles.GRAY_100);
        btExportTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-export-black18.png")));
    }//GEN-LAST:event_btExportTicketMouseExited

    private void btSearchTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchTicketActionPerformed
        PuTicketSearchAD puTicketSearchAD = new PuTicketSearchAD();
        puTicketSearchAD.setVisible(true);
    }//GEN-LAST:event_btSearchTicketActionPerformed

    private void btAddTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddTicketActionPerformed
        try {
            puTicketAD pTicketAD = new puTicketAD(this.user, null);
            pTicketAD.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(TicketAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAddTicketActionPerformed

    private void tbAllTicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAllTicketMouseClicked
        if(evt.getClickCount() == 2){
            int rowPosition = this.tbAllTicket.getSelectedRow();
            String rowKey = ticketModel.getValueAt(rowPosition, 1).toString()
                    + ticketModel.getValueAt(rowPosition, 2).toString()
                    + ticketModel.getValueAt(rowPosition, 3).toString()
                    + ticketModel.getValueAt(rowPosition, 4).toString();
            System.out.println(rowKey);
            ArrayList<Ticket> tickets = mapRowTicket.get(rowKey);

            puTicketAD pAD;
            try {
                pAD = new puTicketAD((User) this.user, tickets);
                pAD.setVisible(true);
                pAD.setLocationRelativeTo(null);
            } catch (ParseException ex) {
                Logger.getLogger(TicketAD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_tbAllTicketMouseClicked


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
