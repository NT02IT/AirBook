/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.popup;

import BUS.AirlineBUS;
import BUS.AirportBUS;
import BUS.AirportGateBUS;
import BUS.FlightBUS;
import BUS.PermissionBUS;
import BUS.PlaneBUS;
import BUS.SeatBUS;
import BUS.TicketBUS;
import BUS.TicketClassBUS;
import DTO.entities.Airline;
import DTO.entities.Airport;
import DTO.entities.AirportGate;
import DTO.entities.Flight;
import DTO.entities.Plane;
import DTO.entities.Seat;
import DTO.entities.Ticket;
import DTO.entities.TicketClass;
import DTO.entities.User;
import assets.DateTime;
import assets.Styles;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
/**
 *
 * @author WIN 10
 */
public class puTicketAD extends javax.swing.JFrame {
    private User user;
    private Airline a = new Airline();
    private AirportGate gate = new AirportGate();
    private Plane planeSeleted = new Plane();
    private TicketClass ticketClassSelected = new TicketClass();
    private Flight flight = new Flight();
    private ArrayList<Ticket> tickets;    
    
    private ArrayList<AirportGate> airportGates;
    private ArrayList<Airline> airlines;
    private ArrayList<Airport> airports;    
    private ArrayList<Plane> planes;
    private ArrayList<TicketClass> ticketClasses;
    private ArrayList<Flight> flights;
    
    private AirlineBUS airlineBUS;
    private PermissionBUS permissionBUS;
    private AirportBUS airportBUS;
    private SeatBUS seatBUS;
    private TicketClassBUS ticketClassBUS;
    private PlaneBUS planeBUS;
    private FlightBUS flightBUS;
    private AirportGateBUS airportGateBUS;
    private boolean isImportPriceFieldEmpty = true;    
    private boolean isSellPriceFieldEmpty = true;


    
    /**
     * Creates new form puTicketAD
     */
    public puTicketAD(User user,ArrayList<Ticket> tickets) throws ParseException {
        try {
            initComponents();
            this.user = user;
            this.tickets = tickets;
            this.airlineBUS = new AirlineBUS();
            this.airlines = airlineBUS.getList();
            this.permissionBUS = new PermissionBUS();
            this.seatBUS = new SeatBUS();
            this.airportBUS = new AirportBUS();
            this.ticketClassBUS = new TicketClassBUS();
            this.planeBUS = new PlaneBUS();
            this.flightBUS = new FlightBUS();
            this.airports = airportBUS.getList();
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/image/app-favicon.png")));
            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("Chuyến bay");
            style();
            initAccessPerRole();
            initFormTextField();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(puTicketAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(puTicketAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(puTicketAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void initAccessPerRole() {
        User userLogin = (User) this.user;
        if(permissionBUS.hasPerEdit(userLogin.getRoleID(), "TIK")) {
            btUpdate.setEnabled(true);
        }
        else {
            btUpdate.setEnabled(false);
        }
        if(permissionBUS.hasPerDelete(userLogin.getRoleID(), "TIK")) {
            btDelete.setEnabled(true);
        }
        else {
            btDelete.setEnabled(false);
        } 
    }
    public void initFormTextField() throws ParseException, ClassNotFoundException, SQLException, IOException{
        if(this.tickets != null) {
            Ticket ticket = tickets.get(0);
            btUpdate.setText("Thêm mới vé bay");
            cbAirline.setEnabled(false);
            cbFlightFrom.setEnabled(false);
            cbFlightTo.setEnabled(false);
            cbPlane.setEnabled(false);
            
            txtDepartureFlight.setEnabled(false);
            Seat seat = seatBUS.getObjectbyID(ticket.getSeatID());
            TicketClass ticketClass = ticketClassBUS.getObjectbyID(seat.getTicketClassID());
            Plane plane = planeBUS.getObjectbyID(ticketClass.getPlaneID());
            Airline airline = airlineBUS.getObjectbyID(plane.getAirlineID());            
            for (Airline a : airlines) {
                String aID = a.getAirlineID();
                String aName = a.getAirlineName();
                cbAirline.addItem(aName);
                if (aID.equals(airline.getAirlineID())) {
                    cbAirline.setSelectedItem(aName);
                }
            }
            Flight flight = flightBUS.getObjectbyID(ticket.getFlightID());            
            String flyingFrom = airportBUS.getObjectbyID(flight.getFlyingFrom()).getAirportName();
            String flyingTo = airportBUS.getObjectbyID(flight.getFlyingTo()).getAirportName();
            for(Airport airport : airports){
                if(airport.getAirportName().equals(flyingFrom))
                    cbFlightFrom.setSelectedItem(airport.getProvince());
                if(airport.getAirportName().equals(flyingTo))
                    cbFlightTo.setSelectedItem(airport.getProvince());
            } 
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            txtDepartureFlight.setText(flight.getDepartureFlight().format(formatter));
        }
        else{
            btDelete.setEnabled(false);
        }
    }
    public void style(){
        this.getContentPane().setBackground(Styles.WHITE);
        Styles.FormLabel(lbAirline);
        Styles.FormLabel(lbFlyingFrom);
        Styles.FormLabel(lbFlyingTo);
        Styles.FormLabel(lbDepartureFlight);
        Styles.FormTextFeild(txtDepartureFlight);
        
        Styles.FormLabel(lbPlane);
        Styles.FormLabel(lbTicketClass);
        
        Styles.FormLabel(lbAirportGate);
        
        Styles.FormLabel(lbImportPrice);
        Styles.FormTextFeild(txtImportPrice);
        
        Styles.FormLabel(lbResellPrice);
        Styles.FormTextFeild(txtResellPrice);
        
        Styles.ButtonDanger(btDelete);
        Styles.ButtonSecondary(btUpdate); 
        txtImportPrice.setText("0");
        txtResellPrice.setText("0");
        for (Airline entry : airlines) {
            String roleID = entry.getAirlineID();
            String roleName = entry.getAirlineName();
            cbAirline.addItem(roleName);
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

        popupHeader1 = new GUI.components.PopupHeader("Chuyến bay", "/assets/icon/nav-flight-white20");
        pnDetail = new javax.swing.JPanel();
        lbAirline = new javax.swing.JLabel();
        lbFlyingFrom = new javax.swing.JLabel();
        lbFlyingTo = new javax.swing.JLabel();
        lbDepartureFlight = new javax.swing.JLabel();
        txtDepartureFlight = new javax.swing.JTextField();
        lbPlane = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbTicketClass = new javax.swing.JLabel();
        lbAirportGate = new javax.swing.JLabel();
        txtImportPrice = new javax.swing.JTextField();
        lbImportPrice = new javax.swing.JLabel();
        txtResellPrice = new javax.swing.JTextField();
        lbResellPrice = new javax.swing.JLabel();
        btDelete = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        cbFlightFrom = new javax.swing.JComboBox<>();
        cbFlightTo = new javax.swing.JComboBox<>();
        cbAirline = new javax.swing.JComboBox<>();
        cbTicketClass = new javax.swing.JComboBox<>();
        cbPlane = new javax.swing.JComboBox<>();
        cbGate = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnDetail.setBackground(new java.awt.Color(255, 255, 255));

        lbAirline.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-airline-black20.png"))); // NOI18N
        lbAirline.setText("Hãng bay");

        lbFlyingFrom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFlyingFrom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbFlyingFrom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-flight-from-black20.png"))); // NOI18N
        lbFlyingFrom.setText("Bay từ");

        lbFlyingTo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFlyingTo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbFlyingTo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-flight-to-black20.png"))); // NOI18N
        lbFlyingTo.setText("Bay đến");

        lbDepartureFlight.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDepartureFlight.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDepartureFlight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-time-black20.png"))); // NOI18N
        lbDepartureFlight.setText("Khởi hành");

        lbPlane.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPlane.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPlane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-plane-id-black20.png"))); // NOI18N
        lbPlane.setText("Số hiệu máy bay");

        lbTicketClass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTicketClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-ticket-black20.png"))); // NOI18N
        lbTicketClass.setText("Hạng vé");

        lbAirportGate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbAirportGate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-login-black20.png"))); // NOI18N
        lbAirportGate.setText("Cổng đi");

        txtImportPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtImportPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtImportPriceFocusLost(evt);
            }
        });
        txtImportPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtImportPriceKeyPressed(evt);
            }
        });

        lbImportPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbImportPrice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-price-black20.png"))); // NOI18N
        lbImportPrice.setText("Giá nhập");

        txtResellPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtResellPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtResellPriceFocusLost(evt);
            }
        });

        lbResellPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbResellPrice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-price-black20.png"))); // NOI18N
        lbResellPrice.setText("Giá bán");

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png"))); // NOI18N
        btDelete.setText("Xóa");

        btUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-pri18.png"))); // NOI18N
        btUpdate.setText("Cập nhật");
        btUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpdateMouseClicked(evt);
            }
        });

        cbFlightFrom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFlightFromItemStateChanged(evt);
            }
        });

        cbAirline.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbAirline.setMinimumSize(new java.awt.Dimension(150, 22));
        cbAirline.setPreferredSize(new java.awt.Dimension(150, 22));
        cbAirline.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAirlineItemStateChanged(evt);
            }
        });

        cbTicketClass.setMinimumSize(new java.awt.Dimension(190, 22));
        cbTicketClass.setPreferredSize(new java.awt.Dimension(190, 22));

        cbPlane.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPlaneItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnDetailLayout = new javax.swing.GroupLayout(pnDetail);
        pnDetail.setLayout(pnDetailLayout);
        pnDetailLayout.setHorizontalGroup(
            pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(pnDetailLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetailLayout.createSequentialGroup()
                        .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetailLayout.createSequentialGroup()
                                .addComponent(lbFlyingFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnDetailLayout.createSequentialGroup()
                                .addComponent(cbFlightFrom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(99, 99, 99)))
                        .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbFlightTo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbFlyingTo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnDetailLayout.createSequentialGroup()
                        .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbDepartureFlight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbAirline, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPlane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDepartureFlight)
                            .addComponent(cbAirline, javax.swing.GroupLayout.Alignment.TRAILING, 0, 175, Short.MAX_VALUE)
                            .addComponent(cbPlane, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnDetailLayout.createSequentialGroup()
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetailLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtResellPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtImportPrice, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(pnDetailLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbImportPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(lbAirportGate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTicketClass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbResellPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTicketClass, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbGate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
        );
        pnDetailLayout.setVerticalGroup(
            pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAirline)
                    .addComponent(cbAirline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFlyingFrom)
                    .addComponent(lbFlyingTo))
                .addGap(10, 10, 10)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFlightFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFlightTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDepartureFlight)
                    .addComponent(txtDepartureFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPlane)
                    .addComponent(cbPlane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTicketClass)
                    .addComponent(cbTicketClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAirportGate)
                    .addComponent(cbGate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbImportPrice)
                    .addComponent(txtImportPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbResellPrice)
                    .addComponent(txtResellPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(popupHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(popupHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(pnDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbAirlineItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAirlineItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            // Lấy giá trị đã chọn trong cbAirline
            String selectedAirline = (String) cbAirline.getSelectedItem();
            for(Airline airline : airlines){
                if(selectedAirline.equals(airline.getAirlineName())){
                    this.a = airline;
                    break;
                }
            }
            try {
                flights = flightBUS.getAllFlightOfAirline(a);
                for(Flight f : flights){
                    for(Airport airport : airports){
                        if(f.getFlyingFrom().equals(airport.getAirportID()))
                            cbFlightFrom.addItem(airport.getProvince());
                    }
                }
                planes = planeBUS.getAllPlaneByAirline(a.getAirlineID());
                cbPlane.removeAllItems();
                for(Plane plane : planes){
                    cbPlane.addItem(plane.getPlaneName());
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(puTicketAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(puTicketAD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_cbAirlineItemStateChanged

    private void cbFlightFromItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFlightFromItemStateChanged
       if (evt.getStateChange() == ItemEvent.SELECTED) {
            // Lấy giá trị đã chọn trong cbAirline
            String selected = (String) cbFlightFrom.getSelectedItem();
            for(Airport airport : airports){
                if(selected.equals(airport.getProvince())){
                    selected = airport.getAirportID();
                    break;
                }
            }
            try {
                flights = flightBUS.getAllFlightOfAirline(this.a);
                cbFlightTo.removeAllItems();
                for(Flight f : flights){
                    if(f.getFlyingFrom().equals(selected)){
                        for(Airport airport : airports){
                            if( f.getFlyingTo().equals(airport.getAirportID())){
                                cbFlightTo.addItem(airport.getProvince());
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                                txtDepartureFlight.setText(f.getDepartureFlight().format(formatter));
                                flight = f;
                                break;
                            }
                        }
                    }
                }
                
                airportGateBUS = new AirportGateBUS();
                airportGates = airportGateBUS.getAllGateByAirlineID(selected);
                cbGate.removeAllItems();
                for(AirportGate airportGate : airportGates){
                    cbGate.addItem(airportGate.getGateName());
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(puTicketAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(puTicketAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
               Logger.getLogger(puTicketAD.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }//GEN-LAST:event_cbFlightFromItemStateChanged

    private void cbPlaneItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPlaneItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            // Lấy giá trị đã chọn trong cbAirline
            String selected = (String) cbPlane.getSelectedItem();
            for(Plane plane : planes){
                if(selected.equals(plane.getPlaneName())){
                    selected = plane.getPlaneID();
                    break;
                }
            }
            System.out.println(selected);
            try {
                ticketClasses = ticketClassBUS.getAllByPlaneID(selected);
                cbTicketClass.removeAllItems();
                for(TicketClass ticketClass : ticketClasses){
                    cbTicketClass.addItem(ticketClass.getClassName());
                }
            } catch (SQLException ex) {
                Logger.getLogger(puTicketAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cbPlaneItemStateChanged

    private void btUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateMouseClicked
        if(evt.getClickCount() == 1 || evt.getClickCount() == 2){
            String flightTo = cbFlightTo.getSelectedItem().toString();
            String flightFrom = cbFlightFrom.getSelectedItem().toString();
            String airline = cbAirline.getSelectedItem().toString();
            String dep = txtDepartureFlight.getText();
            String plane = cbPlane.getSelectedItem().toString();
            String ticketClass = cbTicketClass.getSelectedItem().toString();
            String gate = cbGate.getSelectedItem().toString();
            int importPrice = Integer.parseInt(txtImportPrice.getText());
            int sellPrice = Integer.parseInt(txtResellPrice.getText());
            // Kiểm tra giá trị flightFrom
            if (flightFrom.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn nơi khởi hành.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra giá trị flightTo
            if (flightTo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn nơi đến.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra giá trị airline
            if (airline.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hãng hàng không.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra giá trị dep
            if (dep.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày khởi hành.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                Date date = DateTime.strtoDateTime(dep);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Định dạnh ngày giờ không hợp lệ. Hãy nhập thêm format dd/MM/yyyy HH:mm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            // Kiểm tra giá trị plane
            if (plane.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn máy bay.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra giá trị ticketClass
            if (ticketClass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hạng vé.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra giá trị gate
            if (gate.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn cổng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(importPrice == 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá nhập.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                try {
                    if (importPrice <= 100000) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị lớn hơn 100000.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Giá nhập không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Kiểm tra giá trị sellPrice
            if (sellPrice == 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá bán.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                try {
                    if (sellPrice <= 100000) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị lớn hơn 100000.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Giá bán không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            for(AirportGate airportGate : airportGates){
                if(airportGate.getGateName().equals(gate)){
                    this.gate = airportGate;
                }
            }
            for(Plane p : planes){
                if(p.getPlaneName().equals(plane)){
                    this.planeSeleted = p;
                }
            }
            for(TicketClass tc : ticketClasses){
                if(tc.getClassName().equals(tc)){
                    this.ticketClassSelected = tc;
                }
            }
            Ticket newTicket = new Ticket();
            newTicket.setGateID(this.gate.getGateID());
            newTicket.setImportPrice(importPrice);
            newTicket.setSellingPrice(sellPrice);
            newTicket.setFlightID(this.flight.getFlightID());
            TicketBUS ticketBUS;
            try {
                ticketBUS = new TicketBUS();
                boolean checkCreateSuccessFully = ticketBUS.create(newTicket,this.planeSeleted,this.ticketClassSelected);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(puTicketAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(puTicketAD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(puTicketAD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btUpdateMouseClicked

    private void txtImportPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImportPriceKeyPressed
        
    }//GEN-LAST:event_txtImportPriceKeyPressed

    private void txtImportPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImportPriceFocusGained
         if (isImportPriceFieldEmpty) {
                txtImportPrice.setText("");
            }
    }//GEN-LAST:event_txtImportPriceFocusGained

    private void txtImportPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImportPriceFocusLost
       if (txtImportPrice.getText().isEmpty()) {
            txtImportPrice.setText("0");
            isImportPriceFieldEmpty = true;
        } else {
            isImportPriceFieldEmpty = false;
        }
    }//GEN-LAST:event_txtImportPriceFocusLost

    private void txtResellPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtResellPriceFocusGained
        if (isSellPriceFieldEmpty) {
            txtResellPrice.setText("");
        }

    }//GEN-LAST:event_txtResellPriceFocusGained

    private void txtResellPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtResellPriceFocusLost
        if (txtResellPrice.getText().isEmpty()) {
            txtResellPrice.setText("0");
            isSellPriceFieldEmpty = true;
        } else {
            isSellPriceFieldEmpty = false;
        }
    }//GEN-LAST:event_txtResellPriceFocusLost



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox<String> cbAirline;
    private javax.swing.JComboBox<String> cbFlightFrom;
    private javax.swing.JComboBox<String> cbFlightTo;
    private javax.swing.JComboBox<String> cbGate;
    private javax.swing.JComboBox<String> cbPlane;
    private javax.swing.JComboBox<String> cbTicketClass;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbAirline;
    private javax.swing.JLabel lbAirportGate;
    private javax.swing.JLabel lbDepartureFlight;
    private javax.swing.JLabel lbFlyingFrom;
    private javax.swing.JLabel lbFlyingTo;
    private javax.swing.JLabel lbImportPrice;
    private javax.swing.JLabel lbPlane;
    private javax.swing.JLabel lbResellPrice;
    private javax.swing.JLabel lbTicketClass;
    private javax.swing.JPanel pnDetail;
    private GUI.components.PopupHeader popupHeader1;
    private javax.swing.JTextField txtDepartureFlight;
    private javax.swing.JTextField txtImportPrice;
    private javax.swing.JTextField txtResellPrice;
    // End of variables declaration//GEN-END:variables
}
