/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.popup;

import BUS.AirlineBUS;
import BUS.AirportBUS;
import BUS.FlightBUS;
import BUS.MoreLuggageBUS;
import BUS.OrderBUS;
import BUS.OrderDetailBUS;
import BUS.PlaneBUS;
import BUS.PromoBUS;
import BUS.ReceiverBUS;
import BUS.SeatBUS;
import BUS.TicketBUS;
import BUS.TicketClassBUS;
import DTO.entities.Airline;
import DTO.entities.FlatDiscount;
import DTO.entities.Flight;
import DTO.entities.MoreLuggage;
import DTO.entities.OrderDetail;
import DTO.entities.PercentDiscount;
import DTO.entities.Plane;
import DTO.entities.Promotion;
import DTO.entities.Receiver;
import DTO.entities.Seat;
import DTO.entities.Ticket;
import DTO.entities.TicketClass;
import DTO.entities.User;
import assets.DateTime;
import assets.EnumCheck;
import assets.Styles;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author agond
 */
public class PuTicketDetailEUC extends javax.swing.JFrame {
    private OrderDetail orderDetail;
    private Receiver receiver;
    private String seatID;
    private String promoID;
    private ReceiverBUS receiverBUS;
    private SeatBUS seatBUS;
    private FlightBUS flightBUS;
    private AirlineBUS airlineBUS;
    private PlaneBUS planeBUS;
    private OrderBUS orderBUS;
    private OrderDetailBUS orderDetailBUS;
    private AirportBUS airportBUS;
    private TicketClassBUS ticketClassBUS;
    private TicketBUS ticketBUS;
    private MoreLuggageBUS moreLuggageBUS;
    private String flyingFrom;
    private String flyingTo;
    private String hoursFly;
    private String departureFlight;
    private Flight flight;    
    private Airline airline;
    private User user;
    private int totalValue = 0;
    private Ticket ticket;
    private DateTime date = new DateTime();
    private ArrayList<Receiver> receivers;
    DateTimeFormatter datetimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    /**
     * Creates new form BuyTicketEUC
     */
    public PuTicketDetailEUC() {
        initComponents();
        style();
    }
    
    public PuTicketDetailEUC(OrderDetail orderDetail, User user) {
        this.orderDetail = orderDetail;
        this.user = user;
        initComponents();
        style();
        try {
            receiverBUS = new ReceiverBUS();
            orderDetailBUS = new OrderDetailBUS();
            flightBUS = new FlightBUS();
            seatBUS = new SeatBUS();
            airlineBUS = new AirlineBUS();
            planeBUS = new PlaneBUS();
            orderBUS = new OrderBUS();
            ticketBUS = new TicketBUS();
            airportBUS = new AirportBUS();
            moreLuggageBUS = new MoreLuggageBUS();
            ticketClassBUS = new TicketClassBUS();
            initDataTicketView();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public PuTicketDetailEUC(OrderDetail orderDetail, User user, boolean onlyView) {
        this.orderDetail = orderDetail;
        this.user = user;
        initComponents();
        style();
        try {
            receiverBUS = new ReceiverBUS();
            orderDetailBUS = new OrderDetailBUS();
            flightBUS = new FlightBUS();
            seatBUS = new SeatBUS();
            airlineBUS = new AirlineBUS();
            planeBUS = new PlaneBUS();
            orderBUS = new OrderBUS();
            ticketBUS = new TicketBUS();
            airportBUS = new AirportBUS();
            moreLuggageBUS = new MoreLuggageBUS();
            ticketClassBUS = new TicketClassBUS();
            initDataTicketView();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(onlyView){
            cbReceiver.setEditable(false);
            cbReceiver.setEnabled(false);
            cbGender.setEditable(false);
            cbGender.setEnabled(false);
            txtName.setEditable(false);
            txtDoB.setEditable(false);
            txtAddress.setEditable(false);
            txtNation.setEditable(false);
            txtEmail.setEditable(false);
            txtPhoneNum.setEditable(false);
            txtCCCD.setEditable(false);
            jSeparator8.setVisible(false);
            btCancelTicket.setVisible(false);
            btUpdateTicket.setVisible(false);
        }
    }
    
    public PuTicketDetailEUC(Ticket ticket, User user, boolean onlyView) {
        this.ticket = ticket;
        this.user = user;
        initComponents();
        style();
        try {
            receiverBUS = new ReceiverBUS();
            orderDetailBUS = new OrderDetailBUS();
            flightBUS = new FlightBUS();
            seatBUS = new SeatBUS();
            airlineBUS = new AirlineBUS();
            planeBUS = new PlaneBUS();
            orderBUS = new OrderBUS();
            ticketBUS = new TicketBUS();
            airportBUS = new AirportBUS();
            moreLuggageBUS = new MoreLuggageBUS();
            ticketClassBUS = new TicketClassBUS();
            initDataTicketView();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(onlyView){
            cbReceiver.setEditable(false);
            cbReceiver.setEnabled(false);
            cbGender.setEditable(false);
            cbGender.setEnabled(false);
            txtName.setEditable(false);
            txtDoB.setEditable(false);
            txtAddress.setEditable(false);
            txtNation.setEditable(false);
            txtEmail.setEditable(false);
            txtPhoneNum.setEditable(false);
            txtCCCD.setEditable(false);
            jSeparator8.setVisible(false);
            btCancelTicket.setVisible(false);
            btUpdateTicket.setVisible(false);
        }
    }
    
    public void style(){
        pnReceiverInfo.setBackground(Styles.GRAY_100);
        pnTicketInfo.setBackground(Styles.WHITE);
        pnTicketInfoCont.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            protected void configureScrollBarColors() {
                this.thumbColor = Styles.GRAY_200;
                this.scrollBarWidth = 6;
                this.trackColor = Styles.GRAY_100;
            }
        });
        Styles.ButtonPrimary(btUpdateTicket);
        Styles.ButtonDanger(btCancelTicket);
        Styles.ComboBox(cbReceiver);
        Styles.ComboBox(cbGender);
        lbGrpReceiverInfo.setFont(Styles.Micro);
        lbGrpReceiverInfo.setForeground(Styles.GRAY_300);
        Styles.FormLabel(lbName);
        Styles.FormTextFeild(txtName);
        Styles.FormLabel(lbGender);
        Styles.FormLabel(lbDoB);
        Styles.FormDateFeild(txtDoB);
        Styles.FormLabel(lbAddress);
        Styles.FormTextFeild(txtAddress);
        Styles.FormLabel(lbNation);
        Styles.FormTextFeild(txtNation);
        Styles.FormLabel(lbEmail);
        Styles.FormTextFeild(txtEmail);
        Styles.FormLabel(lbPhoneNum);
        Styles.FormTextFeild(txtPhoneNum);
        Styles.FormLabel(lbCCCD);
        Styles.FormTextFeild(txtCCCD);
        Styles.FormTextFeild(txtPromoCode);
        lbGrpPromo.setFont(Styles.Micro);
        lbGrpPromo.setForeground(Styles.GRAY_300);

        lbPromoDiscount.setFont(Styles.Label);
        lbPromoDiscount.setForeground(Styles.FUNC_DANGER);
        lbTotal.setFont(Styles.Label);
        lbTotal.setForeground(Styles.GRAY_600);
        lbTotalValue.setFont(Styles.H2);
        lbTotalValue.setForeground(Styles.PRI_NORMAL);
        
        lbGrpFlightInfo.setFont(Styles.Micro);
        lbGrpFlightInfo.setForeground(Styles.GRAY_300);
        lbGrpTicket.setFont(Styles.Micro);
        lbGrpTicket.setForeground(Styles.GRAY_300);
        lbGrpBonus.setFont(Styles.Micro);
        lbGrpBonus.setForeground(Styles.GRAY_300);
        
        Styles.FormLabel(lbAirline);
        Styles.FormTextFeild(txtAirline);
        Styles.FormLabel(lbFlyingFrom);
        Styles.FormTextFeild(txtFlyingFrom);
        Styles.FormLabel(lbFlyingTo);
        Styles.FormTextFeild(txtFlyingTo);
        Styles.FormTextFeild(txtHourFly);
        
        Styles.FormLabel(lbDeparture);
        Styles.FormTextFeild(txtDeparture);
        Styles.FormLabel(lbTicketClass);
        Styles.FormTextFeild(txtTicketClass);
        Styles.FormLabel(lbSeat);
        Styles.FormTextFeild(txtSeat);
        lbPrice.setFont(Styles.Label);
        lbPrice.setForeground(Styles.GRAY_600);
        lbPriceNum.setFont(Styles.H2);
        lbPriceNum.setForeground(Styles.GRAY_600);
        Styles.FormLabel(lbMoreLuggage);
        Styles.FormTextFeild(txtMoreLuggageWeight);
        Styles.FormTextFeild(txtMoreLuggagePrice);
    }
    
    public void initDataTicketView() throws IOException, ClassNotFoundException, SQLException, ParseException{
        if(ticket == null) {
            ticket = ticketBUS.getObjectbyID(orderDetail.getTicketID());
        } else {
            for(OrderDetail od : orderDetailBUS.getList()){
                if(od.getTicketID().equals(ticket.getTicketID())) orderDetail = od;
            }
        }
        lbPriceNum.setText(ticket.getSellingPrice() + "đ");
        flight = flightBUS.getObjectbyID(ticket.getFlightID());
        flyingFrom = airportBUS.getObjectbyID(flight.getFlyingFrom()).getAirportName();
        flyingTo = airportBUS.getObjectbyID(flight.getFlyingTo()).getAirportName();
        hoursFly = flight.getHoursFly() + " giờ";
        departureFlight = flight.getDepartureFlight().format(datetimeFormat);
        
        txtFlyingFrom.setText(flyingFrom);
        txtFlyingTo.setText(flyingTo);
        txtDeparture.setText(departureFlight);
        txtHourFly.setText(hoursFly);
        
        Seat seat = seatBUS.getObjectbyID(ticket.getSeatID());
        txtSeat.setText(seat.getSeatName());
        TicketClass ticketClass = ticketClassBUS.getObjectbyID(seat.getTicketClassID());
        txtTicketClass.setText(ticketClass.getClassName());
        Plane plane = planeBUS.getObjectbyID(ticketClass.getPlaneID());
        airline = airlineBUS.getObjectbyID(plane.getAirlineID());
        txtAirline.setText(airline.getAirlineName());
        promoID =  orderDetail.getPromoID();
        if(promoID != null) txtPromoCode.setText(promoID);
        else txtPromoCode.setText("-");
        int total = ticket.getSellingPrice();
        try {
            PromoBUS promoBUS = new PromoBUS();
            if(promoID != null){ 
                Promotion promotion = promoBUS.getObjectbyID(promoID);
                if(promotion instanceof PercentDiscount){
                    PercentDiscount pd = (PercentDiscount) promotion;
                    lbPromoDiscount.setText(pd.getDecreased() + "%");
                    total -= (ticket.getSellingPrice() * pd.getDecreased())/100;
                }
                else if(promotion instanceof FlatDiscount){
                    FlatDiscount fd = (FlatDiscount) promotion;
                    lbPromoDiscount.setText(fd.getDecreased() + "đ");
                    total -= fd.getDecreased();
                }
                else lbPromoDiscount.setText("-");  
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            MoreLuggage moreLuggage = moreLuggageBUS.getObjectbyID(orderDetail.getMoreLuggageID());
            txtMoreLuggageWeight.setText(moreLuggage.getLuggageWeight() + "kg");
            txtMoreLuggagePrice.setText(moreLuggage.getPrice()+ "đ");
            total += moreLuggage.getPrice();
        } catch (Exception e) {
            txtMoreLuggageWeight.setText("-");
            txtMoreLuggagePrice.setText("-");
        }        
        lbTotalValue.setText(total + "đ");   
        
        initReceiver(cbReceiver);
        receiver = (Receiver)receiverBUS.getObjectByID(orderDetail.getReceiverID());
        cbReceiver.setSelectedItem(receiver.getName());        
        loadReceiver(receiver);
    }
    
    private void initReceiver(javax.swing.JComboBox<String> combobox){
        receivers = receiverBUS.getListFromUser(user);
        String[] receiversString = new String[receivers.size()+1];
        receiversString[0] = "-";
        int i = 1;
        for(Receiver r : receivers){
            receiversString[i] = r.getName();
            i++;
        }
        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(receiversString));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupHeader1 = new GUI.components.PopupHeader("Chi tiết vé", "/assets/icon/info-ticket-white32");
        pnTicketInfoCont = new javax.swing.JScrollPane();
        pnTicketInfo = new javax.swing.JPanel();
        lbGrpFlightInfo = new javax.swing.JLabel();
        lbAirline = new javax.swing.JLabel();
        txtAirline = new javax.swing.JTextField();
        lbFlyingFrom = new javax.swing.JLabel();
        txtFlyingFrom = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        lbGrpTicket = new javax.swing.JLabel();
        lbDeparture = new javax.swing.JLabel();
        lbTicketClass = new javax.swing.JLabel();
        lbSeat = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        lbPriceNum = new javax.swing.JLabel();
        lbGrpBonus = new javax.swing.JLabel();
        lbMoreLuggage = new javax.swing.JLabel();
        txtMoreLuggagePrice = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtHourFly = new javax.swing.JTextField();
        lbHourFly = new javax.swing.JLabel();
        lbFlyingTo = new javax.swing.JLabel();
        txtFlyingTo = new javax.swing.JTextField();
        txtDeparture = new javax.swing.JTextField();
        lbGrpPromo = new javax.swing.JLabel();
        lbPromoDiscount = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        lbTotal = new javax.swing.JLabel();
        lbTotalValue = new javax.swing.JLabel();
        txtTicketClass = new javax.swing.JTextField();
        txtSeat = new javax.swing.JTextField();
        txtPromoCode = new javax.swing.JTextField();
        txtMoreLuggageWeight = new javax.swing.JTextField();
        pnReceiverInfo = new javax.swing.JPanel();
        lbGrpReceiverInfo = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lbName = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        lbDoB = new javax.swing.JLabel();
        txtDoB = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        lbAddress = new javax.swing.JLabel();
        txtNation = new javax.swing.JTextField();
        lbNation = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        txtPhoneNum = new javax.swing.JTextField();
        lbPhoneNum = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        lbCCCD = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        btUpdateTicket = new javax.swing.JButton();
        btCancelTicket = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        cbReceiver = new javax.swing.JComboBox<>();
        lbReceiver = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi tiết vé");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        pnTicketInfoCont.setBorder(null);
        pnTicketInfoCont.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnTicketInfo.setBackground(new java.awt.Color(255, 255, 255));

        lbGrpFlightInfo.setText("Thông tin chuyến bay");

        lbAirline.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbAirline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-airline-black20.png"))); // NOI18N
        lbAirline.setText("Hãng bay");

        txtAirline.setEditable(false);

        lbFlyingFrom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFlyingFrom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-flight-from-black20.png"))); // NOI18N
        lbFlyingFrom.setText("Bay từ");

        txtFlyingFrom.setEditable(false);
        txtFlyingFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFlyingFromActionPerformed(evt);
            }
        });

        lbGrpTicket.setText("Vé lượt đi");

        lbDeparture.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDeparture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-time-black20.png"))); // NOI18N
        lbDeparture.setText("Khởi hành");

        lbTicketClass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTicketClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-ticket-black20.png"))); // NOI18N
        lbTicketClass.setText("Hạng vé");

        lbSeat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-seat-black20.png"))); // NOI18N
        lbSeat.setText("Ghế ngồi");

        lbPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPrice.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbPrice.setText("Giá vé");

        lbPriceNum.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbPriceNum.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbPriceNum.setText("-");

        lbGrpBonus.setText("Dịch vụ bổ sung");

        lbMoreLuggage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMoreLuggage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-luggage-black20.png"))); // NOI18N
        lbMoreLuggage.setText("Hành lý");

        txtMoreLuggagePrice.setEditable(false);
        txtMoreLuggagePrice.setText("-");
        txtMoreLuggagePrice.setToolTipText("");

        txtHourFly.setEditable(false);
        txtHourFly.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtHourFly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHourFlyActionPerformed(evt);
            }
        });

        lbHourFly.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbHourFly.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbHourFly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-time-black20.png"))); // NOI18N
        lbHourFly.setText("Thời gian bay");

        lbFlyingTo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFlyingTo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-flight-to-black20.png"))); // NOI18N
        lbFlyingTo.setText("Bay đến");

        txtFlyingTo.setEditable(false);
        txtFlyingTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFlyingToActionPerformed(evt);
            }
        });

        txtDeparture.setEditable(false);
        txtDeparture.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDeparture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartureActionPerformed(evt);
            }
        });

        lbGrpPromo.setText("Mã khuyến mãi");

        lbPromoDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPromoDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPromoDiscount.setText("-");

        lbTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotal.setText("Tổng cộng");

        lbTotalValue.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTotalValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotalValue.setText("1.200.000đ");

        txtTicketClass.setEditable(false);
        txtTicketClass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTicketClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTicketClassActionPerformed(evt);
            }
        });

        txtSeat.setEditable(false);
        txtSeat.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSeatActionPerformed(evt);
            }
        });

        txtPromoCode.setEditable(false);
        txtPromoCode.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPromoCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPromoCodeActionPerformed(evt);
            }
        });

        txtMoreLuggageWeight.setEditable(false);
        txtMoreLuggageWeight.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtMoreLuggageWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoreLuggageWeightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTicketInfoLayout = new javax.swing.GroupLayout(pnTicketInfo);
        pnTicketInfo.setLayout(pnTicketInfoLayout);
        pnTicketInfoLayout.setHorizontalGroup(
            pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTicketInfoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGrpPromo)
                    .addGroup(pnTicketInfoLayout.createSequentialGroup()
                        .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbFlyingFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbAirline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbFlyingTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbHourFly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFlyingTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFlyingFrom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHourFly, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAirline, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbTotalValue)
                        .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnTicketInfoLayout.createSequentialGroup()
                                .addComponent(txtPromoCode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbPromoDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGrpTicket, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnTicketInfoLayout.createSequentialGroup()
                                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDeparture)
                                    .addComponent(lbTicketClass)
                                    .addComponent(lbSeat))
                                .addGap(56, 56, 56)
                                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDeparture)
                                    .addComponent(lbPriceNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbPrice)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnTicketInfoLayout.createSequentialGroup()
                                        .addComponent(txtMoreLuggageWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMoreLuggagePrice, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                    .addComponent(txtTicketClass, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSeat)))
                            .addComponent(lbGrpFlightInfo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGrpBonus, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMoreLuggage, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbTotal)))
                .addGap(24, 24, 24))
        );
        pnTicketInfoLayout.setVerticalGroup(
            pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTicketInfoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbGrpFlightInfo)
                .addGap(12, 12, 12)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtAirline, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAirline))
                .addGap(15, 15, 15)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtFlyingFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFlyingFrom))
                .addGap(16, 16, 16)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtFlyingTo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFlyingTo))
                .addGap(17, 17, 17)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtHourFly, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHourFly))
                .addGap(16, 16, 16)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGrpTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDeparture))
                .addGap(16, 16, 16)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTicketClass)
                    .addComponent(txtTicketClass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSeat)
                    .addComponent(txtSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(lbPrice)
                .addGap(4, 4, 4)
                .addComponent(lbPriceNum)
                .addGap(8, 8, 8)
                .addComponent(lbGrpBonus)
                .addGap(8, 8, 8)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtMoreLuggagePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMoreLuggage)
                    .addComponent(txtMoreLuggageWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGrpPromo)
                .addGap(8, 8, 8)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPromoDiscount)
                    .addComponent(txtPromoCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotalValue)
                .addGap(48, 48, 48))
        );

        pnTicketInfoCont.setViewportView(pnTicketInfo);

        lbGrpReceiverInfo.setText("Thông tin hành khách");

        txtName.setEditable(false);

        lbName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbName.setText("Họ và tên");

        lbGender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGender.setText("Giới tính");

        lbDoB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDoB.setText("Ngày sinh");

        txtDoB.setEditable(false);

        txtAddress.setEditable(false);

        lbAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbAddress.setText("Địa chỉ");

        txtNation.setEditable(false);

        lbNation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNation.setText("Quốc tịch");

        txtEmail.setEditable(false);

        lbEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbEmail.setText("Email");

        txtPhoneNum.setEditable(false);

        lbPhoneNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPhoneNum.setText("Số điện thoại");

        txtCCCD.setEditable(false);

        lbCCCD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbCCCD.setText("Số CCCD");

        btUpdateTicket.setBackground(new java.awt.Color(1, 138, 165));
        btUpdateTicket.setForeground(new java.awt.Color(255, 255, 255));
        btUpdateTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-refresh-white18.png"))); // NOI18N
        btUpdateTicket.setText("Cập nhật thông tin");
        btUpdateTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateTicketActionPerformed(evt);
            }
        });

        btCancelTicket.setForeground(new java.awt.Color(255, 51, 51));
        btCancelTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-delete-red18.png"))); // NOI18N
        btCancelTicket.setText("Hủy vé");
        btCancelTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelTicketActionPerformed(evt);
            }
        });

        cbReceiver.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cbReceiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReceiverActionPerformed(evt);
            }
        });

        lbReceiver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbReceiver.setText("Hành khách");

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        javax.swing.GroupLayout pnReceiverInfoLayout = new javax.swing.GroupLayout(pnReceiverInfo);
        pnReceiverInfo.setLayout(pnReceiverInfoLayout);
        pnReceiverInfoLayout.setHorizontalGroup(
            pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnReceiverInfoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnReceiverInfoLayout.createSequentialGroup()
                        .addComponent(lbReceiver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbReceiver, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnReceiverInfoLayout.createSequentialGroup()
                        .addComponent(btCancelTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btUpdateTicket))
                    .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnReceiverInfoLayout.createSequentialGroup()
                            .addComponent(lbName)
                            .addGap(222, 222, 222))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnReceiverInfoLayout.createSequentialGroup()
                            .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbNation, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbPhoneNum)
                                .addComponent(lbCCCD))
                            .addGap(46, 46, 46)
                            .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addComponent(txtDoB, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addComponent(txtNation, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addComponent(txtPhoneNum, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addComponent(txtCCCD, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addComponent(cbGender, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(lbGrpReceiverInfo)
                    .addComponent(lbDoB)
                    .addComponent(jSeparator8)
                    .addComponent(jSeparator7))
                .addGap(48, 48, 48))
        );
        pnReceiverInfoLayout.setVerticalGroup(
            pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnReceiverInfoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbReceiver)
                    .addComponent(cbReceiver, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbGrpReceiverInfo)
                .addGap(8, 8, 8)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbName))
                .addGap(9, 9, 9)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGender)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDoB)
                    .addComponent(txtDoB, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbNation)
                    .addComponent(txtNation, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbPhoneNum)
                    .addComponent(txtPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCCCD)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btUpdateTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(popupHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTicketInfoCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnReceiverInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(popupHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTicketInfoCont, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addComponent(pnReceiverInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void txtDepartureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartureActionPerformed

    private void txtFlyingToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFlyingToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFlyingToActionPerformed

    private void txtHourFlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHourFlyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHourFlyActionPerformed

    private void txtFlyingFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFlyingFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFlyingFromActionPerformed

    private void btCancelTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelTicketActionPerformed
        try {
            //Chuyển isDelete OrderDetail -> 1        
            orderDetail.setIsDelete(1);
            orderDetailBUS.update(orderDetail);
            //Chuyển ticket soldout -> 0
            ticket.setSoldout(0);
            ticketBUS.update(ticket);
        } catch (SQLException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
        }  
        JOptionPane.showMessageDialog(this,"Đã hủy vé của bạn", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_btCancelTicketActionPerformed

    private void txtTicketClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTicketClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTicketClassActionPerformed

    private void txtSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeatActionPerformed

    private void txtPromoCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPromoCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPromoCodeActionPerformed

    private void txtMoreLuggageWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMoreLuggageWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMoreLuggageWeightActionPerformed

    private void btUpdateTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateTicketActionPerformed
        if(receiver == null){            
            EnumCheck.ValidStatus chkNewReceiver = EnumCheck.ValidStatus.VALID;
            String strNoti = "";
            String ID = Receiver.generateID();
            
            String name = txtName.getText();
            name = User.formatName(name);
            EnumCheck.ValidStatus chkName;
            
            String gender = cbGender.getSelectedItem().toString();
            
            String doB = txtDoB.getText();
            doB = doB.trim();
            EnumCheck.DateValidStatus chkDoB;
            
            String address = txtAddress.getText();
            address = address.trim();
            EnumCheck.ValidStatus chkAddress;
            
            String nation = txtNation.getText();
            nation = nation.trim();
            EnumCheck.ValidStatus chkNation;
            
            String phoneNumber = txtPhoneNum.getText();
            phoneNumber = phoneNumber.trim();
            EnumCheck.NumbersValidStatus chkPhone;
            
            String CCCD = txtCCCD.getText();
            CCCD = CCCD.trim();
            EnumCheck.NumbersValidStatus chkCCCD;
            
            String email = txtEmail.getText();
            email = email.trim();
            EnumCheck.ValidStatus chkEmail;
            
            String userCreateID = user.getID();
            if(email.equals("")){
                strNoti += "Email không được để trống.\n";
                chkNewReceiver = EnumCheck.ValidStatus.INVALID;
            } else{
                chkEmail = User.checkEmailValid(email);
                if(chkEmail == EnumCheck.ValidStatus.INVALID){
                    strNoti += "Không đúng định dạng email.\n";
                    chkNewReceiver = EnumCheck.ValidStatus.INVALID;
                }
            }         

            if(name.equals("")){
                strNoti += "Tên không được để trống.\n";
                chkNewReceiver = EnumCheck.ValidStatus.INVALID;
            }

            chkDoB = date.checkFormat(doB);
            if (chkDoB == EnumCheck.DateValidStatus.ISNULL) {
                strNoti += "Ngày sinh không được để trống.\n";
                chkNewReceiver = EnumCheck.ValidStatus.INVALID;
            } else if (chkDoB == EnumCheck.DateValidStatus.UNCORRECTFORMAT) {
                strNoti += "Ngày sinh phải có dạng dd/mm/yyyy.\n";
                chkNewReceiver = EnumCheck.ValidStatus.INVALID;
            } else if (chkDoB == EnumCheck.DateValidStatus.INVALID){
                strNoti += "Ngày sinh không hợp lệ.\n";
                chkNewReceiver = EnumCheck.ValidStatus.INVALID;
            }

            if(CCCD.equals("")){
                strNoti += "CCCD không được để trống.\n";
                chkNewReceiver = EnumCheck.ValidStatus.INVALID;
            } else{
                chkCCCD = User.checkCCCDValid(CCCD);
                if(chkCCCD == EnumCheck.NumbersValidStatus.VERYLONG){
                    strNoti += "Số CCCD quá dài.\n";
                    chkNewReceiver = EnumCheck.ValidStatus.INVALID;
                }
                if(chkCCCD == EnumCheck.NumbersValidStatus.VERYSHORT){
                    strNoti += "Số CCCD quá ngắn.\n";
                    chkNewReceiver = EnumCheck.ValidStatus.INVALID;
                }
                if(chkCCCD == EnumCheck.NumbersValidStatus.HASLETTER){
                    strNoti += "Số CCCD sai định dạng.\n";
                    chkNewReceiver = EnumCheck.ValidStatus.INVALID;
                }
            }

            if(nation.equals("")){
                strNoti += "Quốc gia không được để trống.\n";
                chkNewReceiver = EnumCheck.ValidStatus.INVALID;
            }

            if(address.equals("")){
                strNoti += "Địa chỉ không được để trống.\n";
                chkNewReceiver = EnumCheck.ValidStatus.INVALID;
            }

            if(phoneNumber.equals("")){
                strNoti += "Số điện thoại không được để trống.\n";
                chkNewReceiver = EnumCheck.ValidStatus.INVALID;
            } else{
                chkPhone = User.checkPhoneValid(phoneNumber);
                if(chkPhone == EnumCheck.NumbersValidStatus.VERYLONG){
                    strNoti += "Số điện thoại quá dài.\n";
                    chkNewReceiver = EnumCheck.ValidStatus.INVALID;
                }
                if(chkPhone == EnumCheck.NumbersValidStatus.VERYSHORT){
                    strNoti += "Số điện thoại quá ngắn.\n";
                    chkNewReceiver = EnumCheck.ValidStatus.INVALID;
                }
                if(chkPhone == EnumCheck.NumbersValidStatus.HASLETTER){
                    strNoti += "Số điện thoại sai định dạng.\n";
                    chkNewReceiver = EnumCheck.ValidStatus.INVALID;
                } 
            }   
            
            if(chkNewReceiver == EnumCheck.ValidStatus.VALID){
                try {
                    receiver = new Receiver(Receiver.generateID(), name, gender, date.strtoDate(doB), address, nation, phoneNumber, CCCD, email, userCreateID);
                    receiverBUS.create(receiver);
                } catch (ParseException ex) {
                    Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this,"Không thể cập nhật thông tin hành khách", "Cập nhật thất bại", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,strNoti, "Mua vé không thành công", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        try {
            orderDetail.setReceiverID(receiver.getID());
            orderDetailBUS.update(orderDetail);
        } catch (SQLException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Không thể cập nhật thông tin hành khách", "Cập nhật thất bại", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Không thể cập nhật thông tin hành khách", "Cập nhật thất bại", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PuTicketDetailEUC.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Không thể cập nhật thông tin hành khách", "Cập nhật thất bại", JOptionPane.INFORMATION_MESSAGE);
        }
        JOptionPane.showMessageDialog(this,"Cập nhật thông tin hành khách thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_btUpdateTicketActionPerformed

    private void cbReceiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReceiverActionPerformed
        try {
            int indexSelected = cbReceiver.getSelectedIndex();
            indexSelected--;
            if(indexSelected>=0){
                receiver = receivers.get(indexSelected);
                loadReceiver(receiver);
            } else{
                receiver = null;
                loadReceiver(receiver);
            }
        } catch (ParseException ex) {
            Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbReceiverActionPerformed
    
    private void loadReceiver(Receiver receiver) throws ParseException{
        if (receiver != null) {
            txtName.setText(receiver.getName()); txtName.setEditable(false);
            cbGender.setSelectedItem(receiver.getGender());
            String doB = assets.DateTime.convertFormat(receiver.getDoB().toString(), "yyyy-MM-dd", "dd/MM/yyyy");
            txtDoB.setText(doB); txtDoB.setEditable(false);
            txtAddress.setText(receiver.getAddress()); txtAddress.setEditable(false);
            txtNation.setText(receiver.getNation()); txtNation.setEditable(false);
            txtEmail.setText(receiver.getEmail()); txtEmail.setEditable(false);
            txtPhoneNum.setText(receiver.getPhoneNumber()); txtPhoneNum.setEditable(false);
            txtCCCD.setText(receiver.getCCCD()); txtCCCD.setEditable(false);
        } else{
            txtName.setText(""); txtName.setEditable(true);
            cbGender.setSelectedItem("Nam");
            txtDoB.setText(""); txtDoB.setEditable(true);
            txtAddress.setText(""); txtAddress.setEditable(true);
            txtNation.setText(""); txtNation.setEditable(true);
            txtEmail.setText(""); txtEmail.setEditable(true);
            txtPhoneNum.setText(""); txtPhoneNum.setEditable(true);
            txtCCCD.setText(""); txtCCCD.setEditable(true);
        }        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PuTicketDetailEUC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuTicketDetailEUC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuTicketDetailEUC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuTicketDetailEUC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PuTicketDetailEUC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelTicket;
    private javax.swing.JButton btUpdateTicket;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JComboBox<String> cbReceiver;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbAirline;
    private javax.swing.JLabel lbCCCD;
    private javax.swing.JLabel lbDeparture;
    private javax.swing.JLabel lbDoB;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbFlyingFrom;
    private javax.swing.JLabel lbFlyingTo;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbGrpBonus;
    private javax.swing.JLabel lbGrpFlightInfo;
    private javax.swing.JLabel lbGrpPromo;
    private javax.swing.JLabel lbGrpReceiverInfo;
    private javax.swing.JLabel lbGrpTicket;
    private javax.swing.JLabel lbHourFly;
    private javax.swing.JLabel lbMoreLuggage;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNation;
    private javax.swing.JLabel lbPhoneNum;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbPriceNum;
    private javax.swing.JLabel lbPromoDiscount;
    private javax.swing.JLabel lbReceiver;
    private javax.swing.JLabel lbSeat;
    private javax.swing.JLabel lbTicketClass;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotalValue;
    private javax.swing.JPanel pnReceiverInfo;
    private javax.swing.JPanel pnTicketInfo;
    private javax.swing.JScrollPane pnTicketInfoCont;
    private GUI.components.PopupHeader popupHeader1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAirline;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDeparture;
    private javax.swing.JTextField txtDoB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFlyingFrom;
    private javax.swing.JTextField txtFlyingTo;
    private javax.swing.JTextField txtHourFly;
    private javax.swing.JTextField txtMoreLuggagePrice;
    private javax.swing.JTextField txtMoreLuggageWeight;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNation;
    private javax.swing.JTextField txtPhoneNum;
    private javax.swing.JTextField txtPromoCode;
    private javax.swing.JTextField txtSeat;
    private javax.swing.JTextField txtTicketClass;
    // End of variables declaration//GEN-END:variables
}
