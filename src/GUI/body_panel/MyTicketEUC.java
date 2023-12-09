/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;

import BUS.AirlineBUS;
import BUS.AirportBUS;
import BUS.FlightBUS;
import BUS.OrderDetailBUS;
import BUS.PlaneBUS;
import BUS.SeatBUS;
import BUS.TicketBUS;
import BUS.TicketClassBUS;
import DTO.entities.Flight;
import DTO.entities.OrderDetail;
import DTO.entities.Plane;
import DTO.entities.Seat;
import DTO.entities.Ticket;
import DTO.entities.TicketClass;
import DTO.entities.User;
import GUI.popup.PuTicketDetailEUC;
import assets.Styles;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agond
 */
public class MyTicketEUC extends javax.swing.JPanel {
    private User user;
    private AirlineBUS airlineBUS;
    private PlaneBUS planeBUS;
    private FlightBUS flightBUS;
    private AirportBUS airportBUS;
    private TicketClassBUS ticketClassBUS;
    private SeatBUS seatBUS;
    private TicketBUS ticketBUS;
    private OrderDetailBUS orderDetailBUS;
    private ArrayList<OrderDetail> listOrderDetail;
    private ArrayList<Ticket> listTicket;
    private ArrayList<OrderDetail> listUserOrderDetailUnpaid;
    private DefaultTableModel ticketsUnpaidModel;
    private DefaultTableModel historyModel;    
    private DefaultTableModel flightUpcomingModel;
    private Map<String,OrderDetail> mapUnpaidRowTicket;
    private Map<String,OrderDetail> mapHistoryRowTicket;
    private Map<String,Ticket> mapUpcomingRowTicket;
    /**
     * Creates new form MyTicketEUC
     */
    public MyTicketEUC() {
        initComponents();
        style();
    }
    
    public MyTicketEUC(User user) {
        try {
            initComponents();
            style();
            this.user = user;
            orderDetailBUS = new OrderDetailBUS();
            listOrderDetail = orderDetailBUS.getList();
            airlineBUS = new AirlineBUS();
            planeBUS = new PlaneBUS();
            ticketClassBUS = new TicketClassBUS();
            seatBUS = new SeatBUS();
            airportBUS = new AirportBUS();
            flightBUS = new FlightBUS();
            ticketBUS = new TicketBUS();
            listTicket = ticketBUS.getList();
            listUserOrderDetailUnpaid = new ArrayList<>();
            ticketsUnpaidModel = (DefaultTableModel) tbUnpaid.getModel();
            historyModel = (DefaultTableModel) tbHistory.getModel();
            flightUpcomingModel = (DefaultTableModel) tbFlightUpcoming.getModel();
            mapUnpaidRowTicket = new HashMap<String, OrderDetail>();
            mapHistoryRowTicket = new HashMap<String, OrderDetail>();
            mapUpcomingRowTicket = new HashMap<String, Ticket>();
            initTickets();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void style(){
        Styles.Table(tbUnpaid, pnUnpaid);
        Styles.Table(tbFlightUpcoming, pnFlightUpcoming);
        Styles.Table(tbHistory, pnHistory);
        Styles.ButtonPrimary(btPayment);
        pnMainBody.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            protected void configureScrollBarColors() {
                this.thumbColor = Styles.GRAY_200;
                this.scrollBarWidth = 12;
                this.trackColor = Styles.GRAY_100;
            }
        });
        
        lbTitleUnpaid.setFont(Styles.H2);
        lbTitleUnpaid.setForeground(Styles.GRAY_600);
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
        
        lbTotal.setFont(Styles.Micro);
        lbTotal.setForeground(Styles.GRAY_600);
        lbTotalNum.setFont(Styles.H1);
        lbTotalNum.setForeground(Styles.PRI_NORMAL);
    }

    public void initTickets() throws ClassNotFoundException, SQLException, IOException{
        initTicketsUnpaid();
        initFlightUpcoming();
        initHistoryTable();
    }
    
    private void initTicketsUnpaid(){      
        int stt = 1;
        int totalPrice = 0;
        int quantityTicket = 0;
        for(OrderDetail od : listOrderDetail){
            if(od.getIsDelete() == 0){
                String airline, flyingFrom, flyingTo;
                String departureFlight;
                Ticket ticket;
                Flight flight;
                if(user.hasReceiver(od.getReceiverID()) != null && od.getNotPaid() == 1){
                    listUserOrderDetailUnpaid.add(od);
                    ticket = ticketBUS.getObjectbyID(od.getTicketID());
                    flight = flightBUS.getObjectbyID(ticket.getFlightID());

                    flyingFrom = airportBUS.getObjectbyID(flight.getFlyingFrom()).getAirportName();
                    flyingTo = airportBUS.getObjectbyID(flight.getFlyingTo()).getAirportName();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    departureFlight = flight.getDepartureFlight().format(formatter);

                    Seat seat = seatBUS.getObjectbyID(ticket.getSeatID());
                    TicketClass ticketClass = ticketClassBUS.getObjectbyID(seat.getTicketClassID());
                    Plane plane = planeBUS.getObjectbyID(ticketClass.getPlaneID());
                    airline = airlineBUS.getObjectbyID(plane.getAirlineID()).getAirlineName();     
                    ticketsUnpaidModel.addRow(new Object[]{stt++, airline, flyingFrom, flyingTo, departureFlight, ticket.getSellingPrice() + "đ"});      
                    quantityTicket++;
                    totalPrice += ticket.getSellingPrice();
                    String key = airline + flyingFrom + flyingTo + departureFlight;            
                    mapUnpaidRowTicket.put(key.trim(), od);
                }
                lbUnpaidTotal.setText(quantityTicket + ""); 
                lbTotalNum.setText(totalPrice + "đ");
            }
        }
    }
    private void initFlightUpcoming(){
        try {
            int stt = 1;
            int quantityTicket = 0;
            for(Ticket tk : ticketBUS.getAllUpcomingTickets(user)){
                String airline, flyingFrom, flyingTo;
                String departureFlight;
                Flight flight;

                flight = flightBUS.getObjectbyID(tk.getFlightID());
                flyingFrom = airportBUS.getObjectbyID(flight.getFlyingFrom()).getAirportName();
                flyingTo = airportBUS.getObjectbyID(flight.getFlyingTo()).getAirportName();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                departureFlight = flight.getDepartureFlight().format(formatter);

                Seat seat = seatBUS.getObjectbyID(tk.getSeatID());
                TicketClass ticketClass = ticketClassBUS.getObjectbyID(seat.getTicketClassID());
                Plane plane = planeBUS.getObjectbyID(ticketClass.getPlaneID());
                airline = airlineBUS.getObjectbyID(plane.getAirlineID()).getAirlineName();
                flightUpcomingModel.addRow(new Object[]{stt++, airline, flyingFrom, flyingTo, departureFlight, tk.getSellingPrice() + "đ"});
                quantityTicket++;
                String key = airline + flyingFrom + flyingTo + departureFlight;            
                mapUpcomingRowTicket.put(key.trim(), tk);
            }
            lbFlightUpcomingTotal.setText(quantityTicket + "");
        } catch (SQLException ex) { 
            Logger.getLogger(MyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initHistoryTable(){      
        int stt = 1;
        int quantityTicket = 0;
        for(OrderDetail od : listOrderDetail){
            String airline, flyingFrom, flyingTo;
            String departureFlight;
            Ticket ticket;
            Flight flight;
            if(user.hasReceiver(od.getReceiverID()) != null && od.getNotPaid() == 0){
                    ticket = ticketBUS.getObjectbyID(od.getTicketID());
                    flight = flightBUS.getObjectbyID(ticket.getFlightID());

                    flyingFrom = airportBUS.getObjectbyID(flight.getFlyingFrom()).getAirportName();
                    flyingTo = airportBUS.getObjectbyID(flight.getFlyingTo()).getAirportName();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    departureFlight = flight.getDepartureFlight().format(formatter);

                    Seat seat = seatBUS.getObjectbyID(ticket.getSeatID());
                    TicketClass ticketClass = ticketClassBUS.getObjectbyID(seat.getTicketClassID());
                    Plane plane = planeBUS.getObjectbyID(ticketClass.getPlaneID());
                    airline = airlineBUS.getObjectbyID(plane.getAirlineID()).getAirlineName();     
                    historyModel.addRow(new Object[]{stt++, airline, flyingFrom, flyingTo, departureFlight, ticket.getSellingPrice() + "đ"});      
                    quantityTicket++;
                    String key = airline + flyingFrom + flyingTo + departureFlight;    
                    mapHistoryRowTicket.put(key.trim(), od);
            }
            lbHistoryTotal.setText(quantityTicket + ""); 
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

        pnMainBody = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lbTitleUnpaid = new javax.swing.JLabel();
        pnUnpaid = new javax.swing.JScrollPane();
        tbUnpaid = new javax.swing.JTable();
        lbUnpaidTotalTail = new javax.swing.JLabel();
        lbUnpaidTotalHead = new javax.swing.JLabel();
        lbUnpaidTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbTotal = new javax.swing.JLabel();
        lbTotalNum = new javax.swing.JLabel();
        btPayment = new javax.swing.JButton();
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
        tbUnpaid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUnpaidMouseClicked(evt);
            }
        });
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
        btPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btPaymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btPaymentMouseExited(evt);
            }
        });
        btPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTotalNum, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbTotal)
                .addGap(0, 0, 0)
                .addComponent(lbTotalNum)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbFlightUpcoming.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbFlightUpcoming.setText("Chuyến bay sắp tới");

        tbFlightUpcoming.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tbFlightUpcoming.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFlightUpcomingMouseClicked(evt);
            }
        });
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
        tbHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHistoryMouseClicked(evt);
            }
        });
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
                            .addComponent(pnHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                            .addComponent(pnFlightUpcoming, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnUnpaid, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbTitleUnpaid)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(212, 212, 212)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
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

    private void btPaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPaymentMouseEntered
        btPayment.setBackground(Styles.PRI_DARK);
    }//GEN-LAST:event_btPaymentMouseEntered

    private void btPaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPaymentMouseExited
        btPayment.setBackground(Styles.PRI_NORMAL);
    }//GEN-LAST:event_btPaymentMouseExited

    private void btPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPaymentActionPerformed
        // Chuyển OrderDetail NotPaid -> 0
        // Ticket Soldout -> 1
        Ticket ticket;
        for(OrderDetail od : listUserOrderDetailUnpaid){
            try {
                od.setNotPaid(0);
                orderDetailBUS.update(od);
            } catch (SQLException ex) {
                Logger.getLogger(MyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(this,"Thanh toán thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        // Refresh page to load result
        try {
            initTickets();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPaymentActionPerformed

    private void tbUnpaidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUnpaidMouseClicked
        int rowPosition = this.tbUnpaid.getSelectedRow();
        String rowKeyTicketTurn = ticketsUnpaidModel.getValueAt(rowPosition, 1).toString()
                + ticketsUnpaidModel.getValueAt(rowPosition, 2).toString()
                + ticketsUnpaidModel.getValueAt(rowPosition, 3).toString()
                + ticketsUnpaidModel.getValueAt(rowPosition, 4).toString();        
        OrderDetail orderDetail = mapUnpaidRowTicket.get(rowKeyTicketTurn.trim());
        System.out.println(orderDetail);
        
        PuTicketDetailEUC puTicketDetailEUC= new PuTicketDetailEUC(orderDetail, user);
        puTicketDetailEUC.setVisible(true);
        puTicketDetailEUC.setLocationRelativeTo(null);
    }//GEN-LAST:event_tbUnpaidMouseClicked

    private void tbFlightUpcomingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFlightUpcomingMouseClicked
        int rowPosition = this.tbFlightUpcoming.getSelectedRow();
        System.out.println(rowPosition + " helllooo");
        String rowKeyTicketTurn = flightUpcomingModel.getValueAt(rowPosition, 1).toString()
                + flightUpcomingModel.getValueAt(rowPosition, 2).toString()
                + flightUpcomingModel.getValueAt(rowPosition, 3).toString()
                + flightUpcomingModel.getValueAt(rowPosition, 4).toString();        
        Ticket ticket = mapUpcomingRowTicket.get(rowKeyTicketTurn.trim());
        System.out.println(ticket);
        
        PuTicketDetailEUC puTicketDetailEUC= new PuTicketDetailEUC(ticket, user, true);
        puTicketDetailEUC.setVisible(true);
        puTicketDetailEUC.setLocationRelativeTo(null);
    }//GEN-LAST:event_tbFlightUpcomingMouseClicked

    private void tbHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHistoryMouseClicked
        int rowPosition = this.tbHistory.getSelectedRow();
        String rowKeyTicketTurn = historyModel.getValueAt(rowPosition, 1).toString()
                + historyModel.getValueAt(rowPosition, 2).toString()
                + historyModel.getValueAt(rowPosition, 3).toString()
                + historyModel.getValueAt(rowPosition, 4).toString();        
        OrderDetail orderDetail = mapHistoryRowTicket.get(rowKeyTicketTurn.trim());
        System.out.println(orderDetail);
        
        PuTicketDetailEUC puTicketDetailEUC= new PuTicketDetailEUC(orderDetail, user, true);
        puTicketDetailEUC.setVisible(true);
        puTicketDetailEUC.setLocationRelativeTo(null);
    }//GEN-LAST:event_tbHistoryMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPayment;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbFlightUpcoming;
    private javax.swing.JLabel lbFlightUpcomingTotal;
    private javax.swing.JLabel lbFlightUpcomingTotalHead;
    private javax.swing.JLabel lbFlightUpcomingTotalTail;
    private javax.swing.JLabel lbHistory;
    private javax.swing.JLabel lbHistoryTotal;
    private javax.swing.JLabel lbHistoryTotalHead;
    private javax.swing.JLabel lbHistoryTotalTail;
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
    // End of variables declaration//GEN-END:variables
}
