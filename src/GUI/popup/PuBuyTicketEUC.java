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
import BUS.PromoCollectionBUS;
import BUS.ReceiverBUS;
import BUS.SeatBUS;
import BUS.TicketBUS;
import BUS.TicketClassBUS;
import DTO.entities.Airline;
import DTO.entities.FlatDiscount;
import DTO.entities.Flight;
import DTO.entities.MoreLuggage;
import DTO.entities.Order;
import DTO.entities.OrderDetail;
import DTO.entities.PercentDiscount;
import DTO.entities.Plane;
import DTO.entities.PromoCollection;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author agond
 */
public class PuBuyTicketEUC extends javax.swing.JFrame {
    private ArrayList<Ticket> tickets;
    private ArrayList<Ticket> returnTickets;
    private ArrayList<Receiver> receivers;
    private ArrayList<String> seatTurnIDs;
    private ArrayList<String> seatReturnIDs;
    private ArrayList<PromoCollection> listPromoCode;
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
    private PromoCollectionBUS promoCollectionBUS;
    private String flyingFrom;
    private String flyingTo;
    private String hoursFly;
    private String departureFlight;
    private Flight flight;    
    private ArrayList<Flight> flightReturn;
    private Map<String,ArrayList<String>> mapClassSeat;
    private Airline airline;
    private User user;
    private int totalValue = 0;
    private Receiver receiver;
    private DateTime date = new DateTime();
    DateTimeFormatter datetimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    /**
     * Creates new form BuyTicketEUC
     */
    public PuBuyTicketEUC() {
        initComponents();
        style();
    }
    
    public PuBuyTicketEUC(ArrayList<Ticket> tickets, ArrayList<Ticket> returnTickets, User user) {
        try {
            this.tickets = tickets;
            this.user = user;
            this.returnTickets = returnTickets;
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
            promoCollectionBUS = new PromoCollectionBUS();
            initComponents();
            style();
            initDataTicketView();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
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
        Styles.ButtonPrimary(btAddTicket);
        Styles.FormLabel(lbReceiver);
        Styles.ComboBox(cbReceiver);
        lbGrpReceiverInfo.setFont(Styles.Micro);
        lbGrpReceiverInfo.setForeground(Styles.GRAY_300);
        Styles.FormLabel(lbName);
        Styles.FormTextFeild(txtName);
        Styles.FormLabel(lbGender);
        Styles.ComboBox(cbGender);
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
        lbGrpPromo.setFont(Styles.Micro);
        lbGrpPromo.setForeground(Styles.GRAY_300);
        Styles.ComboBox(cbPromoCode);
        lbPromoDiscount.setFont(Styles.Label);
        lbPromoDiscount.setForeground(Styles.FUNC_DANGER);
        lbTotal.setFont(Styles.Label);
        lbTotal.setForeground(Styles.GRAY_600);
        lbTotalValue.setFont(Styles.H2);
        lbTotalValue.setForeground(Styles.PRI_NORMAL);
        
        lbGrpFlightInfo.setFont(Styles.Micro);
        lbGrpFlightInfo.setForeground(Styles.GRAY_300);
        lbGrpTurnTicket.setFont(Styles.Micro);
        lbGrpTurnTicket.setForeground(Styles.GRAY_300);
        lbGrpTurnBonus.setFont(Styles.Micro);
        lbGrpTurnBonus.setForeground(Styles.GRAY_300);
        lbGrpReturnTicket.setFont(Styles.Micro);
        lbGrpReturnTicket.setForeground(Styles.GRAY_300);
        lbGrpReturnBonus.setFont(Styles.Micro);
        lbGrpReturnBonus.setForeground(Styles.GRAY_300);
        
        Styles.FormLabel(lbAirline);
        Styles.FormTextFeild(txtAirline);
        Styles.FormLabel(lbFlyingFrom);
        Styles.FormTextFeild(txtFlyingFrom);
        Styles.FormLabel(lbFlyingTo);
        Styles.FormTextFeild(txtFlyingTo);
        Styles.FormTextFeild(txtHourFly);
        chkRoundTrip.setFont(Styles.Body);
        chkRoundTrip.setBackground(this.getBackground());
        
        Styles.FormLabel(lbTurnDeparture);
        Styles.FormTextFeild(txtTurnDeparture);
        Styles.FormLabel(lbTurnTicketClass);
        Styles.ComboBox(cbTurnTicketClass);
        Styles.FormLabel(lbTurnSeat);
        Styles.ComboBox(cbTurnSeat);
        lbTurnPrice.setFont(Styles.Label);
        lbTurnPrice.setForeground(Styles.GRAY_600);
        lbTurnPriceNum.setFont(Styles.H2);
        lbTurnPriceNum.setForeground(Styles.GRAY_600);
        Styles.FormLabel(lbTurnMoreLuggage);
        Styles.ComboBox(cbTurnMoreLuggage);
        Styles.FormTextFeild(txtTurnMoreLuggagePrice);
        
        Styles.FormLabel(lbReturnDeparture);
        Styles.ComboBox(cbReturnDeparture);
        Styles.FormLabel(lbReturnTicketClass);
        Styles.ComboBox(cbReturnTicketClass);
        Styles.FormLabel(lbReturnSeat);
        Styles.ComboBox(cbReturnSeat);
        lbReturnPrice.setFont(Styles.Label);
        lbReturnPrice.setForeground(Styles.GRAY_600);
        lbReturnPriceNum.setFont(Styles.H2);
        lbReturnPriceNum.setForeground(Styles.GRAY_600);
        Styles.FormLabel(lbReturnMoreLuggage);
        Styles.ComboBox(cbReturnMoreLuggage);
        Styles.FormTextFeild(txtReturnMoreLuggagePrice);
    }
    
    public void initDataTicketView() throws IOException, ClassNotFoundException, SQLException, ParseException{
        mapClassSeat = new HashMap<>();
        
        Ticket ticket = tickets.get(0);
        flight = flightBUS.getObjectbyID(ticket.getFlightID());
        flyingFrom = airportBUS.getObjectbyID(flight.getFlyingFrom()).getAirportName();
        flyingTo = airportBUS.getObjectbyID(flight.getFlyingTo()).getAirportName();
        hoursFly = flight.getHoursFly() + " giờ";
        departureFlight = flight.getDepartureFlight().format(datetimeFormat);
        
        txtFlyingFrom.setText(flyingFrom);
        txtFlyingTo.setText(flyingTo);
        txtTurnDeparture.setText(departureFlight);
        txtHourFly.setText(hoursFly);
        
        Seat seat = seatBUS.getObjectbyID(ticket.getSeatID());
        TicketClass ticketClass = ticketClassBUS.getObjectbyID(seat.getTicketClassID());
        Plane plane = planeBUS.getObjectbyID(ticketClass.getPlaneID());
        airline = airlineBUS.getObjectbyID(plane.getAirlineID());
        txtAirline.setText(airline.getAirlineName());
        listPromoCode =  promoCollectionBUS.getList(user, airline);
        
        flightReturn = flightBUS.getReturnFlight(flight, airline);
        if(flightReturn.size()!=0){
            chkRoundTrip.setEnabled(true);
        } else chkRoundTrip.setEnabled(false);
        
        initReceiver(cbReceiver);
        initCbTicketClass(cbTurnTicketClass, flight, airline);
        initCbSeat(cbTurnSeat, cbTurnTicketClass.getItemAt(0), tickets);
        loadPrice(lbTurnPriceNum, cbTurnTicketClass, tickets);
        initCbMoreLuggage(cbTurnMoreLuggage, airline);
        initPromoCode();
        
        seatTurnIDs = mapClassSeat.get(cbTurnSeat.getName()+cbTurnTicketClass.getSelectedItem().toString());
    }
    
    private void initPromoCode(){
        String[] listPromoCodeStr = new String[listPromoCode.size()+1];
        listPromoCodeStr[0] = "-";
        int i = 1;
        for(PromoCollection pc : listPromoCode){
            listPromoCodeStr[i] = pc.getPromo_ID();
            i++;
        }
        cbPromoCode.setModel(new javax.swing.DefaultComboBoxModel<>(listPromoCodeStr));
    }
    
    private void initCbMoreLuggage(javax.swing.JComboBox<String> combobox, Airline airline){
        ArrayList<MoreLuggage> moreLuggages = moreLuggageBUS.getObjectbyAirlineID(airline.getAirlineID());
        String[] moreLuggageStrings = new String[moreLuggages.size()+1];
        moreLuggageStrings[0] = "-";
        int i = 1;
        for(MoreLuggage ml : moreLuggages){
            moreLuggageStrings[i] = ml.getLuggageWeight() + " kg";
            i++;
        }
        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(moreLuggageStrings));
    }
    
    private void initCbTicketClass(javax.swing.JComboBox<String> combobox, Flight flight, Airline airline) throws SQLException{
        ArrayList<TicketClass> ticketClasses = ticketClassBUS.getAllClassNameByAirlineIDFlightID(airline.getAirlineID(), flight.getFlightID());
        int i = 0;
        String[] ticketClassName = new String[ticketClasses.size()];
        for(TicketClass tkCls : ticketClasses){
            ticketClassName[i] = tkCls.getClassName();
            i++;
        }        
        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(ticketClassName));
    }
    
    private void initCbSeat(javax.swing.JComboBox<String> combobox, String selectedClassName, ArrayList<Ticket> tickets){
        ArrayList<String> seatIDList = new ArrayList<>();
        TicketClass ticketClass;
        Seat seat;
        for(Ticket tk : tickets){
            seat = seatBUS.getObjectbyID(tk.getSeatID());
            ticketClass = ticketClassBUS.getObjectbyID(seat.getTicketClassID());
            if(!seatIDList.contains(tk.getSeatID()) && selectedClassName.equals(ticketClass.getClassName()) && tk.getSoldout() == 0){
                seatIDList.add(tk.getSeatID());
            }
        }

        int i = 0;
        String[] seatNameList = new String[seatIDList.size()];
        for(String seatID : seatIDList){
            seatNameList[i] = seatBUS.getObjectbyID(seatID).getSeatName();
            i++;
        }
        System.out.println("initCbSeat");
        mapClassSeat.put(combobox.getName()+selectedClassName, seatIDList);
        System.out.println("mapClassSeat" + mapClassSeat);
        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(seatNameList));
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

        popupHeader1 = new GUI.components.PopupHeader("Mua vé", "/assets/icon/info-ticket-white32");
        pnTicketInfoCont = new javax.swing.JScrollPane();
        pnTicketInfo = new javax.swing.JPanel();
        lbGrpFlightInfo = new javax.swing.JLabel();
        lbAirline = new javax.swing.JLabel();
        txtAirline = new javax.swing.JTextField();
        lbFlyingFrom = new javax.swing.JLabel();
        txtFlyingFrom = new javax.swing.JTextField();
        chkRoundTrip = new javax.swing.JCheckBox();
        jSeparator5 = new javax.swing.JSeparator();
        lbGrpTurnTicket = new javax.swing.JLabel();
        lbTurnDeparture = new javax.swing.JLabel();
        lbTurnTicketClass = new javax.swing.JLabel();
        lbTurnSeat = new javax.swing.JLabel();
        lbTurnPrice = new javax.swing.JLabel();
        lbTurnPriceNum = new javax.swing.JLabel();
        lbGrpTurnBonus = new javax.swing.JLabel();
        lbTurnMoreLuggage = new javax.swing.JLabel();
        txtTurnMoreLuggagePrice = new javax.swing.JTextField();
        cbTurnMoreLuggage = new javax.swing.JComboBox<>();
        jSeparator6 = new javax.swing.JSeparator();
        cbReturnMoreLuggage = new javax.swing.JComboBox<>();
        lbGrpReturnTicket = new javax.swing.JLabel();
        lbReturnDeparture = new javax.swing.JLabel();
        lbReturnTicketClass = new javax.swing.JLabel();
        lbReturnSeat = new javax.swing.JLabel();
        lbReturnPrice = new javax.swing.JLabel();
        lbReturnPriceNum = new javax.swing.JLabel();
        lbGrpReturnBonus = new javax.swing.JLabel();
        lbReturnMoreLuggage = new javax.swing.JLabel();
        txtReturnMoreLuggagePrice = new javax.swing.JTextField();
        cbTurnTicketClass = new javax.swing.JComboBox<>();
        cbTurnSeat = new javax.swing.JComboBox<>();
        cbReturnTicketClass = new javax.swing.JComboBox<>();
        cbReturnSeat = new javax.swing.JComboBox<>();
        txtHourFly = new javax.swing.JTextField();
        lbHourFly = new javax.swing.JLabel();
        lbFlyingTo = new javax.swing.JLabel();
        txtFlyingTo = new javax.swing.JTextField();
        txtTurnDeparture = new javax.swing.JTextField();
        cbReturnDeparture = new javax.swing.JComboBox<>();
        pnReceiverInfo = new javax.swing.JPanel();
        lbReceiver = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        lbGrpReceiverInfo = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lbName = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        cbReceiver = new javax.swing.JComboBox<>();
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
        lbGrpPromo = new javax.swing.JLabel();
        cbPromoCode = new javax.swing.JComboBox<>();
        lbPromoDiscount = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        lbTotal = new javax.swing.JLabel();
        lbTotalValue = new javax.swing.JLabel();
        btAddTicket = new javax.swing.JButton();

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

        chkRoundTrip.setText("Chuyến bay khứ hồi");
        chkRoundTrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkRoundTripActionPerformed(evt);
            }
        });

        lbGrpTurnTicket.setText("Vé lượt đi");

        lbTurnDeparture.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTurnDeparture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-time-black20.png"))); // NOI18N
        lbTurnDeparture.setText("Khởi hành");

        lbTurnTicketClass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTurnTicketClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-ticket-black20.png"))); // NOI18N
        lbTurnTicketClass.setText("Hạng vé");

        lbTurnSeat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTurnSeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-seat-black20.png"))); // NOI18N
        lbTurnSeat.setText("Ghế ngồi");

        lbTurnPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTurnPrice.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbTurnPrice.setText("Giá vé");

        lbTurnPriceNum.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTurnPriceNum.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbTurnPriceNum.setText("-");

        lbGrpTurnBonus.setText("Dịch vụ bổ sung");

        lbTurnMoreLuggage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTurnMoreLuggage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-luggage-black20.png"))); // NOI18N
        lbTurnMoreLuggage.setText("Thêm hành lý");

        txtTurnMoreLuggagePrice.setEditable(false);
        txtTurnMoreLuggagePrice.setText("-");
        txtTurnMoreLuggagePrice.setToolTipText("");

        cbTurnMoreLuggage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cbTurnMoreLuggage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTurnMoreLuggageActionPerformed(evt);
            }
        });

        cbReturnMoreLuggage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cbReturnMoreLuggage.setEnabled(false);
        cbReturnMoreLuggage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReturnMoreLuggageActionPerformed(evt);
            }
        });

        lbGrpReturnTicket.setText("Vé lượt về");

        lbReturnDeparture.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbReturnDeparture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-time-black20.png"))); // NOI18N
        lbReturnDeparture.setText("Khởi hành");

        lbReturnTicketClass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbReturnTicketClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-ticket-black20.png"))); // NOI18N
        lbReturnTicketClass.setText("Hạng vé");

        lbReturnSeat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbReturnSeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-seat-black20.png"))); // NOI18N
        lbReturnSeat.setText("Ghế ngồi");

        lbReturnPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbReturnPrice.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbReturnPrice.setText("Giá vé");

        lbReturnPriceNum.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbReturnPriceNum.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbReturnPriceNum.setText("-");

        lbGrpReturnBonus.setText("Dịch vụ bổ sung");

        lbReturnMoreLuggage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbReturnMoreLuggage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-luggage-black20.png"))); // NOI18N
        lbReturnMoreLuggage.setText("Thêm hành lý");

        txtReturnMoreLuggagePrice.setEditable(false);
        txtReturnMoreLuggagePrice.setText("-");
        txtReturnMoreLuggagePrice.setEnabled(false);

        cbTurnTicketClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cbTurnTicketClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTurnTicketClassActionPerformed(evt);
            }
        });

        cbTurnSeat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cbTurnSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTurnSeatActionPerformed(evt);
            }
        });

        cbReturnTicketClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cbReturnTicketClass.setEnabled(false);
        cbReturnTicketClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReturnTicketClassActionPerformed(evt);
            }
        });

        cbReturnSeat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cbReturnSeat.setEnabled(false);
        cbReturnSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReturnSeatActionPerformed(evt);
            }
        });

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

        txtTurnDeparture.setEditable(false);
        txtTurnDeparture.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTurnDeparture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTurnDepartureActionPerformed(evt);
            }
        });

        cbReturnDeparture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cbReturnDeparture.setEnabled(false);

        javax.swing.GroupLayout pnTicketInfoLayout = new javax.swing.GroupLayout(pnTicketInfo);
        pnTicketInfo.setLayout(pnTicketInfoLayout);
        pnTicketInfoLayout.setHorizontalGroup(
            pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTicketInfoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(txtAirline, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnTicketInfoLayout.createSequentialGroup()
                        .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbGrpTurnTicket, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnTicketInfoLayout.createSequentialGroup()
                                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTurnDeparture)
                                    .addComponent(lbTurnTicketClass)
                                    .addComponent(lbTurnSeat))
                                .addGap(56, 56, 56)
                                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbTurnTicketClass, javax.swing.GroupLayout.Alignment.LEADING, 0, 184, Short.MAX_VALUE)
                                    .addComponent(txtTurnDeparture)
                                    .addComponent(cbTurnSeat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbTurnPriceNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbTurnPrice)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnTicketInfoLayout.createSequentialGroup()
                                        .addComponent(cbTurnMoreLuggage, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTurnMoreLuggagePrice))))
                            .addComponent(lbGrpFlightInfo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkRoundTrip, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGrpTurnBonus, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTurnMoreLuggage, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGrpReturnTicket, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGrpReturnBonus, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbReturnMoreLuggage, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnTicketInfoLayout.createSequentialGroup()
                                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbReturnTicketClass)
                                    .addComponent(lbReturnSeat)
                                    .addComponent(lbReturnDeparture))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnTicketInfoLayout.createSequentialGroup()
                                        .addComponent(cbReturnMoreLuggage, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtReturnMoreLuggagePrice))
                                    .addComponent(lbReturnPriceNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbReturnPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbReturnTicketClass, 0, 186, Short.MAX_VALUE)
                                    .addComponent(cbReturnSeat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbReturnDeparture, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(24, 24, 24))))
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
                .addGap(12, 12, 12)
                .addComponent(chkRoundTrip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGrpTurnTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTurnDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTurnDeparture))
                .addGap(16, 16, 16)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbTurnTicketClass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTurnTicketClass))
                .addGap(16, 16, 16)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbTurnSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTurnSeat))
                .addGap(12, 12, 12)
                .addComponent(lbTurnPrice)
                .addGap(4, 4, 4)
                .addComponent(lbTurnPriceNum)
                .addGap(8, 8, 8)
                .addComponent(lbGrpTurnBonus)
                .addGap(8, 8, 8)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTurnMoreLuggagePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTurnMoreLuggage)
                    .addComponent(cbTurnMoreLuggage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGrpReturnTicket)
                .addGap(10, 10, 10)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbReturnDeparture)
                    .addComponent(cbReturnDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbReturnTicketClass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbReturnTicketClass))
                .addGap(7, 7, 7)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbReturnSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbReturnSeat))
                .addGap(12, 12, 12)
                .addComponent(lbReturnPrice)
                .addGap(4, 4, 4)
                .addComponent(lbReturnPriceNum)
                .addGap(10, 10, 10)
                .addComponent(lbGrpReturnBonus)
                .addGap(8, 8, 8)
                .addGroup(pnTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtReturnMoreLuggagePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbReturnMoreLuggage)
                    .addComponent(cbReturnMoreLuggage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        pnTicketInfoCont.setViewportView(pnTicketInfo);

        lbReceiver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbReceiver.setText("Hành khách");

        lbGrpReceiverInfo.setText("Thông tin hành khách");

        lbName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbName.setText("Họ và tên");

        lbGender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGender.setText("Giới tính");

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        cbReceiver.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cbReceiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReceiverActionPerformed(evt);
            }
        });

        lbDoB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDoB.setText("Ngày sinh");

        lbAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbAddress.setText("Địa chỉ");

        lbNation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNation.setText("Quốc tịch");

        lbEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbEmail.setText("Email");

        lbPhoneNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPhoneNum.setText("Số điện thoại");

        lbCCCD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbCCCD.setText("Số CCCD");

        lbGrpPromo.setText("Mã khuyến mãi");

        cbPromoCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cbPromoCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPromoCodeActionPerformed(evt);
            }
        });

        lbPromoDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPromoDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPromoDiscount.setText("-");

        lbTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotal.setText("Tổng cộng");

        lbTotalValue.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTotalValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTotalValue.setText("1.200.000đ");

        btAddTicket.setBackground(new java.awt.Color(1, 138, 165));
        btAddTicket.setForeground(new java.awt.Color(255, 255, 255));
        btAddTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-add-white18.png"))); // NOI18N
        btAddTicket.setText("Thêm vé");
        btAddTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnReceiverInfoLayout = new javax.swing.GroupLayout(pnReceiverInfo);
        pnReceiverInfo.setLayout(pnReceiverInfoLayout);
        pnReceiverInfoLayout.setHorizontalGroup(
            pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnReceiverInfoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotal)
                    .addComponent(lbGrpPromo)
                    .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnReceiverInfoLayout.createSequentialGroup()
                            .addComponent(lbTotalValue)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAddTicket))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnReceiverInfoLayout.createSequentialGroup()
                            .addComponent(cbPromoCode, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbPromoDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(cbGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDoB, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(txtNation, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(txtPhoneNum, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(txtCCCD, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))))
                        .addComponent(lbGrpReceiverInfo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnReceiverInfoLayout.createSequentialGroup()
                            .addComponent(lbReceiver)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbReceiver, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbDoB, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator9)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        pnReceiverInfoLayout.setVerticalGroup(
            pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnReceiverInfoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
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
                .addGap(8, 8, 8)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGender))
                .addGap(8, 8, 8)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGrpPromo)
                .addGap(8, 8, 8)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPromoCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPromoDiscount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnReceiverInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnReceiverInfoLayout.createSequentialGroup()
                        .addComponent(lbTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalValue))
                    .addComponent(btAddTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(popupHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTicketInfoCont)
                .addGap(0, 0, 0)
                .addComponent(pnReceiverInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(popupHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTicketInfoCont, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnReceiverInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHourFlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHourFlyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHourFlyActionPerformed

    private void txtFlyingFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFlyingFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFlyingFromActionPerformed

    private void txtFlyingToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFlyingToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFlyingToActionPerformed

    private void txtTurnDepartureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTurnDepartureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTurnDepartureActionPerformed

    private void cbTurnTicketClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTurnTicketClassActionPerformed
        String selectedClassName = cbTurnTicketClass.getSelectedItem().toString().trim();
        initCbSeat(cbTurnSeat, selectedClassName, tickets);
        loadPrice(lbTurnPriceNum, cbTurnTicketClass, tickets);
    }//GEN-LAST:event_cbTurnTicketClassActionPerformed
    
    private void cbTurnSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTurnSeatActionPerformed
        //String selectedSeatName = cbTurnSeat.getSelectedItem().toString();
        seatTurnIDs = mapClassSeat.get(cbTurnSeat.getName()+cbTurnTicketClass.getSelectedItem().toString());
        System.out.println(seatTurnIDs);
    }//GEN-LAST:event_cbTurnSeatActionPerformed

    private void chkRoundTripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRoundTripActionPerformed
        if(chkRoundTrip.isSelected()){
            try {
                cbReturnDeparture.setEnabled(true);
                cbReturnTicketClass.setEnabled(true);
                cbReturnSeat.setEnabled(true);
                txtReturnMoreLuggagePrice.setEnabled(true);
                cbReturnMoreLuggage.setEnabled(true);                
                
                String[] returnDeparture = new String[flightReturn.size()];
                int i = 0;
                for(Flight fl : flightReturn){
                    returnDeparture[i] = fl.getDepartureFlight().format(datetimeFormat);
                    i++;
                }        
                cbReturnDeparture.setModel(new javax.swing.DefaultComboBoxModel<>(returnDeparture));
                
                initCbTicketClass(cbReturnTicketClass, flightReturn.get(0), airline);
                initCbSeat(cbReturnSeat, cbReturnTicketClass.getItemAt(0), tickets);
                loadPrice(lbReturnPriceNum, cbReturnTicketClass, returnTickets);
                initCbMoreLuggage(cbReturnMoreLuggage, airline);
                seatReturnIDs = mapClassSeat.get(cbReturnSeat.getName()+cbReturnTicketClass.getSelectedItem().toString());
            } catch (SQLException ex) {
                Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            cbReturnDeparture.setEnabled(false);
            cbReturnTicketClass.setEnabled(false);
            cbReturnSeat.setEnabled(false);
            txtReturnMoreLuggagePrice.setEnabled(false);
            cbReturnMoreLuggage.setEnabled(false);
            
            cbReturnDeparture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
            cbReturnTicketClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
            cbReturnSeat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
            lbReturnPriceNum.setText("-");
            cbReturnMoreLuggage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
            txtReturnMoreLuggagePrice.setText("");
        }
    }//GEN-LAST:event_chkRoundTripActionPerformed

    private void cbReturnTicketClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReturnTicketClassActionPerformed
        String selectedClassName = cbReturnTicketClass.getSelectedItem().toString().trim();
        initCbSeat(cbReturnSeat, selectedClassName, returnTickets);
        loadPrice(lbReturnPriceNum, cbReturnTicketClass, returnTickets);
    }//GEN-LAST:event_cbReturnTicketClassActionPerformed

    private void cbTurnMoreLuggageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTurnMoreLuggageActionPerformed
        loadLuggagePrice(txtTurnMoreLuggagePrice, cbTurnMoreLuggage);
    }//GEN-LAST:event_cbTurnMoreLuggageActionPerformed

    private void cbReturnMoreLuggageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReturnMoreLuggageActionPerformed
        loadLuggagePrice(txtReturnMoreLuggagePrice, cbReturnMoreLuggage);
    }//GEN-LAST:event_cbReturnMoreLuggageActionPerformed

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

    private void btAddTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddTicketActionPerformed
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
                    receiver = new Receiver(userCreateID, name, gender, date.strtoDate(doB), address, nation, phoneNumber, CCCD, email, userCreateID);
                    receiverBUS.create(receiver);
                } catch (ParseException ex) {
                    Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this,strNoti, "Mua vé không thành công", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            String orderID = Order.generateID();
            Order order = new Order(orderID, user.getID(), LocalDateTime.now());            
            orderBUS.create(order);
            
            String promoID = cbPromoCode.getSelectedItem().toString().trim();
            
            
            MoreLuggage moreLuggage;
            String weightLuggage;       
            //Vé đi
            String turnMoreLuggageID = null;                 
            try {
                weightLuggage = cbTurnMoreLuggage.getSelectedItem().toString();     
                weightLuggage = weightLuggage.replaceAll("[^0-9]", "");
                moreLuggage = moreLuggageBUS.getObjectbyWeight(Integer.parseInt(weightLuggage));
                turnMoreLuggageID = moreLuggage.getMoreLuggageID();
            } catch (Exception e) {
            }    
            String orderDetailID = OrderDetail.generateID();
            int seatTurnIndex = cbTurnSeat.getSelectedIndex();
            String ticketTurnID = null;
            for(Ticket tk : tickets){
                if(tk.getSeatID().equals(seatTurnIDs.get(seatTurnIndex))){
                    ticketTurnID = tk.getTicketID();
                    try {
                        ticketBUS.setSoldout(ticketTurnID);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            OrderDetail orderDetailTurn = new OrderDetail(orderDetailID, orderID, turnMoreLuggageID, receiver.getID(), ticketTurnID, promoID, 1, 0);
            orderDetailBUS.create(orderDetailTurn);
            //Vé về
            if(chkRoundTrip.isSelected()){
                String returnMoreLuggageID = null;               
                try {
                    weightLuggage = cbReturnMoreLuggage.getSelectedItem().toString();     
                    weightLuggage = weightLuggage.replaceAll("[^0-9]", "");
                    moreLuggage = moreLuggageBUS.getObjectbyWeight(Integer.parseInt(weightLuggage));
                    returnMoreLuggageID = moreLuggage.getMoreLuggageID();
                } catch (Exception e) {
                } 
                int seatReturnIndex = cbReturnSeat.getSelectedIndex();
                String ticketReturnID = null;
                for(Ticket tk : returnTickets){
                    if(tk.getSeatID().equals(seatReturnIDs.get(seatReturnIndex))){
                        ticketReturnID = tk.getTicketID();
                        try {
                            ticketBUS.setSoldout(ticketReturnID);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                OrderDetail orderDetailReturn = new OrderDetail(orderDetailID, orderID, returnMoreLuggageID, receiver.getID(), ticketReturnID, promoID, 1, 0);            
                orderDetailBUS.create(orderDetailReturn);
            }            
        }
        this.dispose();
    }//GEN-LAST:event_btAddTicketActionPerformed

    private void cbPromoCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPromoCodeActionPerformed
        loadDescreased();
        loadTotalValue();
    }//GEN-LAST:event_cbPromoCodeActionPerformed

    private void cbReturnSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReturnSeatActionPerformed
        seatReturnIDs = mapClassSeat.get(cbReturnSeat.getName()+cbReturnTicketClass.getSelectedItem().toString());
        System.out.println(seatReturnIDs);
    }//GEN-LAST:event_cbReturnSeatActionPerformed

    private void loadDescreased(){
        try {
            String promoID = cbPromoCode.getSelectedItem().toString().trim();
            PromoBUS promoBUS = new PromoBUS();
            Promotion promotion = promoBUS.getObjectbyID(promoID);
            if(promotion instanceof PercentDiscount){
                PercentDiscount pd = (PercentDiscount) promotion;
                lbPromoDiscount.setText(pd.getDecreased() + "%");
            }
            else if(promotion instanceof FlatDiscount){
                FlatDiscount fd = (FlatDiscount) promotion;
                lbPromoDiscount.setText(fd.getDecreased() + "đ");
            }
            else lbPromoDiscount.setText("-");            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PuBuyTicketEUC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void loadReceiver(Receiver receiver) throws ParseException{
        if(receiver!=null){
            txtName.setText(receiver.getName());
            cbGender.setSelectedItem(receiver.getGender());
            String doB = assets.DateTime.convertFormat(receiver.getDoB().toString(), "yyyy-MM-dd", "dd/MM/yyyy");
            txtDoB.setText(doB);
            txtAddress.setText(receiver.getAddress());
            txtNation.setText(receiver.getNation());
            txtEmail.setText(receiver.getEmail());
            txtPhoneNum.setText(receiver.getPhoneNumber());
            txtCCCD.setText(receiver.getCCCD());
        } else{
            txtName.setText("");
            cbGender.setSelectedIndex(0);
            txtDoB.setText("");
            txtAddress.setText("");
            txtNation.setText("");
            txtEmail.setText("");
            txtPhoneNum.setText("");
            txtCCCD.setText("");
        }
        
    }
    
    private void loadLuggagePrice(javax.swing.JTextField txtPrice, javax.swing.JComboBox<String> cbMoreLuggage){
        String weight = cbMoreLuggage.getSelectedItem().toString();
        weight = weight.replaceAll("[^0-9]", "");
        try {
            MoreLuggage moreLuggage = moreLuggageBUS.getObjectbyWeight(Integer.parseInt(weight));
            txtPrice.setText(moreLuggage.getPrice()+"đ");
        } catch (Exception e) {
            txtPrice.setText("-");
        }    
        loadTotalValue();
    }
    
    private void loadPrice(javax.swing.JLabel labelPrice, javax.swing.JComboBox<String> cbTicketClass, ArrayList<Ticket> tickets){
        flight.getFlightID();
        String ticketClassID;
        for(Ticket tk : tickets){
            ticketClassID = seatBUS.getObjectbyID(tk.getSeatID()).getTicketClassID();
            if(ticketClassBUS.getObjectbyID(ticketClassID).getClassName().equals(cbTicketClass.getSelectedItem())){
                labelPrice.setText(tk.getSellingPrice() + "đ");
                loadTotalValue();
                break;
            }
        }
    }
    
    private void loadTotalValue(){   
        System.out.println("-------Tính tiền--------");     
        totalValue = 0;
         
        int turnPrice = 0;        
        try {
            String turnPriceStr = lbTurnPriceNum.getText().toString();
            turnPriceStr = turnPriceStr.replaceAll("[^0-9]", "");
            turnPrice = Integer.parseInt(turnPriceStr);
        } catch (Exception e) {
        }
        totalValue += turnPrice;
        System.out.println("turnPrice " + turnPrice);        
        System.out.println("totalValue " + totalValue);
        
        int turnMoreLuggagePrice = 0;
        try {
            String turnMoreLuggagePriceStr = txtTurnMoreLuggagePrice.getText().toString();
            turnMoreLuggagePriceStr = turnMoreLuggagePriceStr.replaceAll("[^0-9]", "");
            turnMoreLuggagePrice = Integer.parseInt(turnMoreLuggagePriceStr);
        } catch (Exception e) {
        }
        totalValue += turnMoreLuggagePrice;
        System.out.println("turnMoreLuggagePrice " + turnMoreLuggagePrice);        
        System.out.println("totalValue " + totalValue);
        
        int returnPriceNum = 0;
        try {
            String returnPriceNumStr = lbReturnPriceNum.getText().toString();
            returnPriceNumStr = returnPriceNumStr.replaceAll("[^0-9]", "");
            returnPriceNum = Integer.parseInt(returnPriceNumStr);
        } catch (Exception e) {
        }
        totalValue += returnPriceNum;
        System.out.println("returnPriceNum " + returnPriceNum);        
        System.out.println("totalValue " + totalValue);
        
        int returnMoreLuggagePrice = 0;
        try {
            String returnMoreLuggagePriceStr = txtReturnMoreLuggagePrice.getText().toString();
            returnMoreLuggagePriceStr = returnMoreLuggagePriceStr.replaceAll("[^0-9]", "");
            returnMoreLuggagePrice = Integer.parseInt(returnMoreLuggagePriceStr);
        } catch (Exception e) {
        }
        totalValue += returnMoreLuggagePrice;    
        System.out.println("returnMoreLuggagePrice " + returnMoreLuggagePrice);        
        System.out.println("totalValue " + totalValue);        
        
        int promoDiscount = 0;
        try {
            
        } catch (Exception e) {
        }
        String promoDiscountStr = lbPromoDiscount.getText().toString();
        if(promoDiscountStr.charAt(promoDiscountStr.length()-1) == 'đ'){
            promoDiscountStr = promoDiscountStr.replaceAll("[^0-9]", "");
            promoDiscount = Integer.parseInt(promoDiscountStr);
        } else if(promoDiscountStr.charAt(promoDiscountStr.length()-1) == '%'){
            promoDiscountStr = promoDiscountStr.replaceAll("[^0-9]", "");
            promoDiscount = Integer.parseInt(promoDiscountStr);
            promoDiscount = promoDiscount*totalValue/100;
        } else System.out.println("error...");
        totalValue -= promoDiscount;    
        System.out.println("promoDiscount " + promoDiscount);        
        System.out.println("totalValue " + totalValue);
        
        lbTotalValue.setText(totalValue + "đ");
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
            java.util.logging.Logger.getLogger(PuBuyTicketEUC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuBuyTicketEUC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuBuyTicketEUC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuBuyTicketEUC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PuBuyTicketEUC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddTicket;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JComboBox<String> cbPromoCode;
    private javax.swing.JComboBox<String> cbReceiver;
    private javax.swing.JComboBox<String> cbReturnDeparture;
    private javax.swing.JComboBox<String> cbReturnMoreLuggage;
    private javax.swing.JComboBox<String> cbReturnSeat;
    private javax.swing.JComboBox<String> cbReturnTicketClass;
    private javax.swing.JComboBox<String> cbTurnMoreLuggage;
    private javax.swing.JComboBox<String> cbTurnSeat;
    private javax.swing.JComboBox<String> cbTurnTicketClass;
    private javax.swing.JCheckBox chkRoundTrip;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbAirline;
    private javax.swing.JLabel lbCCCD;
    private javax.swing.JLabel lbDoB;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbFlyingFrom;
    private javax.swing.JLabel lbFlyingTo;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbGrpFlightInfo;
    private javax.swing.JLabel lbGrpPromo;
    private javax.swing.JLabel lbGrpReceiverInfo;
    private javax.swing.JLabel lbGrpReturnBonus;
    private javax.swing.JLabel lbGrpReturnTicket;
    private javax.swing.JLabel lbGrpTurnBonus;
    private javax.swing.JLabel lbGrpTurnTicket;
    private javax.swing.JLabel lbHourFly;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNation;
    private javax.swing.JLabel lbPhoneNum;
    private javax.swing.JLabel lbPromoDiscount;
    private javax.swing.JLabel lbReceiver;
    private javax.swing.JLabel lbReturnDeparture;
    private javax.swing.JLabel lbReturnMoreLuggage;
    private javax.swing.JLabel lbReturnPrice;
    private javax.swing.JLabel lbReturnPriceNum;
    private javax.swing.JLabel lbReturnSeat;
    private javax.swing.JLabel lbReturnTicketClass;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotalValue;
    private javax.swing.JLabel lbTurnDeparture;
    private javax.swing.JLabel lbTurnMoreLuggage;
    private javax.swing.JLabel lbTurnPrice;
    private javax.swing.JLabel lbTurnPriceNum;
    private javax.swing.JLabel lbTurnSeat;
    private javax.swing.JLabel lbTurnTicketClass;
    private javax.swing.JPanel pnReceiverInfo;
    private javax.swing.JPanel pnTicketInfo;
    private javax.swing.JScrollPane pnTicketInfoCont;
    private GUI.components.PopupHeader popupHeader1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAirline;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDoB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFlyingFrom;
    private javax.swing.JTextField txtFlyingTo;
    private javax.swing.JTextField txtHourFly;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNation;
    private javax.swing.JTextField txtPhoneNum;
    private javax.swing.JTextField txtReturnMoreLuggagePrice;
    private javax.swing.JTextField txtTurnDeparture;
    private javax.swing.JTextField txtTurnMoreLuggagePrice;
    // End of variables declaration//GEN-END:variables
}
