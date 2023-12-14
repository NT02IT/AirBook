/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.body_panel;

import BUS.AirlineBUS;
import BUS.AirportBUS;
import BUS.FlightBUS;
import BUS.PlaneBUS;
import BUS.SeatBUS;
import BUS.TicketBUS;
import BUS.TicketClassBUS;
import DTO.entities.Airport;
import DTO.entities.Flight;
import DTO.entities.Plane;
import DTO.entities.Seat;
import DTO.entities.Ticket;
import DTO.entities.TicketClass;
import DTO.entities.User;
import DTO.views.TicketView;
import GUI.popup.PuBuyTicketEUC;
import assets.DateTime;
import assets.Styles;
import assets.TextBubbleBorder;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agond
 */
public class BuyTicketEUC extends javax.swing.JPanel {
    private User user;
    private int rowPosition;
    String rowPatternUnique;
    private TicketView ticketView;
    private AirlineBUS airlineBUS;
//    private TicketView tkViewSendToDlg;
    private PlaneBUS planeBUS;
    private TicketBUS ticketBUS;
    private FlightBUS flightBUS;
    private AirportBUS airportBUS;
    private TicketClassBUS ticketClassBUS;
    private SeatBUS seatBUS;
    private ArrayList<Ticket> listTicket;
    private Map<String,ArrayList<Ticket>> listTicketView;
    private Map<String,ArrayList<Ticket>> mapRowTicket;
    private Map<String,ArrayList<Ticket>> mapRowReturnTicket;
    private DefaultTableModel ticketsModel;
    /**
     * Creates new form PuBuyTicketEUC
     */
    public BuyTicketEUC() throws ClassNotFoundException, SQLException, IOException {
        initComponents();
        style();
        mapRowTicket = new HashMap<String, ArrayList<Ticket>>();
        mapRowReturnTicket = new HashMap<String, ArrayList<Ticket>>();
        airlineBUS = new AirlineBUS();
        planeBUS = new PlaneBUS();
        ticketClassBUS = new TicketClassBUS();
        seatBUS = new SeatBUS();
        airportBUS = new AirportBUS();
        flightBUS = new FlightBUS();
        ticketBUS = new TicketBUS();
        listTicket = ticketBUS.getList();
        ticketView = new TicketView(listTicket);        
        listTicketView = ticketView.getList();
        ticketsModel = (DefaultTableModel) tbTikets.getModel();
        initTickets();
        initProvine();
    }
    
    public BuyTicketEUC(User user) throws ClassNotFoundException, SQLException, IOException {
        this.user = user;
        initComponents();
        style();
        mapRowTicket = new HashMap<String, ArrayList<Ticket>>();
        mapRowReturnTicket = new HashMap<String, ArrayList<Ticket>>();
        airlineBUS = new AirlineBUS();
        planeBUS = new PlaneBUS();
        ticketClassBUS = new TicketClassBUS();
        seatBUS = new SeatBUS();
        airportBUS = new AirportBUS();
        flightBUS = new FlightBUS();
        ticketBUS = new TicketBUS();
        listTicket = ticketBUS.getList();
        ticketView = new TicketView(listTicket);        
        listTicketView = ticketView.getList();
        ticketsModel = (DefaultTableModel) tbTikets.getModel();
        initTickets();
        initProvine();        
    }
    
    public void style(){
        TextBubbleBorder border = new TextBubbleBorder(Color.yellow, 0, 12, 0, true);
        pnSearch.setBorder(border);
        Styles.FormLabel(lbFlyingFrom);
        Styles.ComboBox(cbFlyingFrom);
        Styles.FormLabel(lbFlyingTo);
        Styles.ComboBox(cbFlyingTo);
        Styles.FormLabel(lbDepartureFlight);
        Styles.FormTextFeild(txtDepartureFlight);
        Styles.ButtonSecondary(btSearch);
        Styles.FormRadio(rdoAllTicket, null);        
        Styles.Table(tbTikets, pnTickets);        
        
        lbTitle.setFont(Styles.H2);
        lbTitle.setForeground(Styles.GRAY_600);
        lbToltalTicketHead.setFont(Styles.Body);
        lbToltalTicketHead.setForeground(Styles.GRAY_600);
        lbToltalTicket.setFont(Styles.Label);
        lbToltalTicket.setForeground(Styles.GRAY_600);
        lbToltalTicketTail.setFont(Styles.Body);
        lbToltalTicketTail.setForeground(Styles.GRAY_600);
        lbFlyingFrom.setForeground(Styles.WHITE);
        lbFlyingTo.setForeground(Styles.WHITE);
        lbDepartureFlight.setForeground(Styles.WHITE);
        
        jScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            protected void configureScrollBarColors() {
                this.thumbColor = Styles.GRAY_200;
                this.scrollBarWidth = 12;
                this.trackColor = Styles.GRAY_100;
            }
        });
    }
    
    public void initTickets() throws ClassNotFoundException, SQLException, IOException{  
        ticketsModel.setRowCount(0);
        rdoAllTicket.setSelected(true);
        mapRowTicket = new HashMap<String, ArrayList<Ticket>>();
        mapRowReturnTicket = new HashMap<String, ArrayList<Ticket>>();
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
            
            ticketsModel.addRow(new Object[]{stt++, airline, flyingFrom, flyingTo, departureFlight, hoursFly, remain});
            String key = airline + flyingFrom + flyingTo + departureFlight;            
            mapRowTicket.put(key.trim(), entry.getValue());
            
            String keyReturnTicket = airline + flyingFrom + flyingTo;
            if(mapRowReturnTicket.get(keyReturnTicket) == null){
                mapRowReturnTicket.put(keyReturnTicket.trim(), entry.getValue());
            } else{
                for(Ticket tk : entry.getValue()){
                    mapRowReturnTicket.get(keyReturnTicket).add(tk);
                }                
            }
            
        }
        
        lbToltalTicket.setText(totalTicketRemain + "");
    }
    public void initTickets(String flyFromID, String flyToID, String dateFly) throws ClassNotFoundException, SQLException, IOException{
        ticketsModel.setRowCount(0);
        rdoAllTicket.setSelected(false);
        mapRowTicket = new HashMap<String, ArrayList<Ticket>>();
        mapRowReturnTicket = new HashMap<String, ArrayList<Ticket>>();
        String airportFromName = airportBUS.getObjectbyID(flyFromID).getAirportName();
        String airportToName = airportBUS.getObjectbyID(flyToID).getAirportName();
        
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
            
            if(flyingFrom.equals(airportFromName) && flyingTo.equals(airportToName)){
                ticketsModel.addRow(new Object[]{stt++, airline, flyingFrom, flyingTo, departureFlight, hoursFly, remain});
                String key = airline + flyingFrom + flyingTo + departureFlight;            
                mapRowTicket.put(key.trim(), entry.getValue());
            }
            
            String keyReturnTicket = airline + flyingFrom + flyingTo;
            if(mapRowReturnTicket.get(keyReturnTicket) == null){
                mapRowReturnTicket.put(keyReturnTicket.trim(), entry.getValue());
            } else{
                for(Ticket tk : entry.getValue()){
                    mapRowReturnTicket.get(keyReturnTicket).add(tk);
                }                
            }            
        }        
        lbToltalTicket.setText(totalTicketRemain + "");
    }
    
    public void initProvine() throws ClassNotFoundException, SQLException, IOException{
        AirportBUS airportBUS = new AirportBUS();
        String str = "";
        for(Airport airport : airportBUS.getList()){
            str = airport.getProvince() + " (" + airport.getAirportID() + ")";
            cbFlyingFrom.addItem(str);
            cbFlyingTo.addItem(str);
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

        jScrollPane = new javax.swing.JScrollPane();
        pnMainBody2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pnSearch = new javax.swing.JPanel();
        lbFlyingFrom = new javax.swing.JLabel();
        cbFlyingFrom = new javax.swing.JComboBox<>();
        cbFlyingTo = new javax.swing.JComboBox<>();
        lbFlyingTo = new javax.swing.JLabel();
        lbDepartureFlight = new javax.swing.JLabel();
        txtDepartureFlight = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        rdoAllTicket = new javax.swing.JRadioButton();
        lbTitle = new javax.swing.JLabel();
        pnTickets = new javax.swing.JScrollPane();
        tbTikets = new javax.swing.JTable();
        lbToltalTicketHead = new javax.swing.JLabel();
        lbToltalTicketTail = new javax.swing.JLabel();
        lbToltalTicket = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));

        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.setBorder(null);
        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnMainBody2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(255, 102, 51));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/ticketbaner.png"))); // NOI18N

        pnSearch.setBackground(new java.awt.Color(27, 124, 148));

        lbFlyingFrom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFlyingFrom.setForeground(new java.awt.Color(255, 255, 255));
        lbFlyingFrom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-flight-from-white20.png"))); // NOI18N
        lbFlyingFrom.setText("Bay từ");

        cbFlyingFrom.setBorder(null);

        cbFlyingTo.setBorder(null);

        lbFlyingTo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFlyingTo.setForeground(new java.awt.Color(255, 255, 255));
        lbFlyingTo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-flight-to-white20.png"))); // NOI18N
        lbFlyingTo.setText("Bay đến");

        lbDepartureFlight.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDepartureFlight.setForeground(new java.awt.Color(255, 255, 255));
        lbDepartureFlight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-time-white20.png"))); // NOI18N
        lbDepartureFlight.setLabelFor(txtDepartureFlight);
        lbDepartureFlight.setText("Ngày khởi hành");

        txtDepartureFlight.setToolTipText("dd/mm/yyyy");
        txtDepartureFlight.setBorder(null);

        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-search-pri18.png"))); // NOI18N
        btSearch.setText("Tìm kiếm");
        btSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSearchMouseExited(evt);
            }
        });
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnSearchLayout = new javax.swing.GroupLayout(pnSearch);
        pnSearch.setLayout(pnSearchLayout);
        pnSearchLayout.setHorizontalGroup(
            pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSearchLayout.createSequentialGroup()
                .addGroup(pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnSearchLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnSearchLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbFlyingFrom, 0, 117, Short.MAX_VALUE)
                            .addComponent(lbFlyingFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbFlyingTo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbFlyingTo, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDepartureFlight, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(txtDepartureFlight))))
                .addGap(24, 24, 24))
        );
        pnSearchLayout.setVerticalGroup(
            pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSearchLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFlyingTo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbDepartureFlight, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbFlyingFrom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbFlyingFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFlyingTo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepartureFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        rdoAllTicket.setText("Hiển thị tất cả vé");
        rdoAllTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAllTicketActionPerformed(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitle.setText("Danh sách vé");

        tbTikets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Hãng bay", "Ga đi", "Ga đến", "Khởi hành", "Thời gian bay", "Còn lại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTikets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTiketsMouseClicked(evt);
            }
        });
        pnTickets.setViewportView(tbTikets);
        if (tbTikets.getColumnModel().getColumnCount() > 0) {
            tbTikets.getColumnModel().getColumn(0).setMinWidth(46);
            tbTikets.getColumnModel().getColumn(0).setMaxWidth(46);
            tbTikets.getColumnModel().getColumn(4).setMinWidth(132);
            tbTikets.getColumnModel().getColumn(4).setMaxWidth(132);
            tbTikets.getColumnModel().getColumn(5).setMinWidth(106);
            tbTikets.getColumnModel().getColumn(5).setMaxWidth(106);
            tbTikets.getColumnModel().getColumn(6).setMinWidth(72);
            tbTikets.getColumnModel().getColumn(6).setMaxWidth(72);
        }

        lbToltalTicketHead.setFont(Styles.Micro);
        lbToltalTicketHead.setText("Có tất cả");

        lbToltalTicketTail.setFont(Styles.Micro);
        lbToltalTicketTail.setText("vé bay");

        lbToltalTicket.setFont(Styles.Label);
        lbToltalTicket.setText("?");

        javax.swing.GroupLayout pnMainBody2Layout = new javax.swing.GroupLayout(pnMainBody2);
        pnMainBody2.setLayout(pnMainBody2Layout);
        pnMainBody2Layout.setHorizontalGroup(
            pnMainBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainBody2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnMainBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMainBody2Layout.createSequentialGroup()
                        .addComponent(lbToltalTicketHead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbToltalTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbToltalTicketTail)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainBody2Layout.createSequentialGroup()
                        .addGroup(pnMainBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnTickets, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnMainBody2Layout.createSequentialGroup()
                                .addComponent(lbTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoAllTicket))
                            .addGroup(pnMainBody2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(pnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))))
        );
        pnMainBody2Layout.setVerticalGroup(
            pnMainBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainBody2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnMainBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(pnMainBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoAllTicket)
                    .addComponent(lbTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnTickets, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(pnMainBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbToltalTicketHead)
                    .addComponent(lbToltalTicket)
                    .addComponent(lbToltalTicketTail))
                .addGap(26, 26, 26))
        );

        jScrollPane.setViewportView(pnMainBody2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        // TODO add your handling code here:
        //Lấy giá trị 3 ô input
        boolean validate = true;
        String flyFrom = cbFlyingFrom.getSelectedItem().toString();
        String flyTo = cbFlyingTo.getSelectedItem().toString();
        String flyFromID = null, flyToID = null;
        
        String dayFly = txtDepartureFlight.getText();
        Date departureFlight = null;
        try {
            departureFlight = DateTime.strtoDate(dayFly);
        } catch (ParseException ex) {
            Logger.getLogger(BuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
            validate = false;
            JOptionPane.showMessageDialog(this,"Ngày bay sai định dạng", "Thất bại", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        //Lấy mã sân bay
        String regex = "\\(([^)]+)\\)";        
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcherFlyFrom = pattern.matcher(flyFrom);
        if (matcherFlyFrom.find()) {
            flyFromID = matcherFlyFrom.group(1);
        } else {
            System.out.println("Khong the lay ma san bay di");
            validate = false;
        }
        Matcher matcherFlyTo = pattern.matcher(flyTo);
        if (matcherFlyTo.find()) {
            flyToID = matcherFlyTo.group(1);
        } else {
            System.out.println("Khong the lay ma san bay den");
            validate = false;
        }     
        
        if(validate){
            try {
                initTickets(flyFromID, flyToID, dayFly);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(BuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btSearchActionPerformed

    private void btSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchMouseEntered
        btSearch.setBackground(Styles.PRI_DARKER);
        btSearch.setForeground(Styles.WHITE);
        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-search-white18.png")));
    }//GEN-LAST:event_btSearchMouseEntered

    private void btSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchMouseExited
        btSearch.setBackground(Styles.PRI_LIGHTER);
        btSearch.setForeground(Styles.PRI_NORMAL);
        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-search-pri18.png")));
    }//GEN-LAST:event_btSearchMouseExited

    private void tbTiketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTiketsMouseClicked
        rowPosition = this.tbTikets.getSelectedRow();
        String rowKeyTicketTurn = ticketsModel.getValueAt(rowPosition, 1).toString()
                + ticketsModel.getValueAt(rowPosition, 2).toString()
                + ticketsModel.getValueAt(rowPosition, 3).toString()
                + ticketsModel.getValueAt(rowPosition, 4).toString();        
        ArrayList<Ticket> tickets = mapRowTicket.get(rowKeyTicketTurn.trim());
        System.out.println(rowKeyTicketTurn);
        System.out.println(tickets);
        
        String rowKeyTicketReturn = ticketsModel.getValueAt(rowPosition, 1).toString()
                + ticketsModel.getValueAt(rowPosition, 3).toString()
                + ticketsModel.getValueAt(rowPosition, 2).toString();      
        ArrayList<Ticket> returnTickets = mapRowReturnTicket.get(rowKeyTicketReturn.trim());
        System.out.println(rowKeyTicketReturn);
        System.out.println(returnTickets);
        
        PuBuyTicketEUC puBuyTicketEUC= new PuBuyTicketEUC(tickets, returnTickets, user);
        puBuyTicketEUC.setVisible(true);
        puBuyTicketEUC.setLocationRelativeTo(null);
    }//GEN-LAST:event_tbTiketsMouseClicked

    private void rdoAllTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAllTicketActionPerformed
        try {
            initTickets();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdoAllTicketActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSearch;
    private javax.swing.JComboBox<String> cbFlyingFrom;
    private javax.swing.JComboBox<String> cbFlyingTo;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lbDepartureFlight;
    private javax.swing.JLabel lbFlyingFrom;
    private javax.swing.JLabel lbFlyingTo;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbToltalTicket;
    private javax.swing.JLabel lbToltalTicketHead;
    private javax.swing.JLabel lbToltalTicketTail;
    private javax.swing.JPanel pnMainBody2;
    private javax.swing.JPanel pnSearch;
    private javax.swing.JScrollPane pnTickets;
    private javax.swing.JRadioButton rdoAllTicket;
    private javax.swing.JTable tbTikets;
    private javax.swing.JTextField txtDepartureFlight;
    // End of variables declaration//GEN-END:variables
}
