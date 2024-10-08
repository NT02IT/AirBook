/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.popup;

import BUS.AirportBUS;
import BUS.FlightBUS;
import DAO.AirportDAO;
import DAO.FlightDAO;
import DTO.entities.Airport;
import DTO.entities.DateTimeItem;
import DTO.entities.Flight;
import assets.Styles;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.List;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Admin
 */
public class PuFlight extends javax.swing.JFrame  {
    private AirportBUS airportBUS;
    private FlightBUS flightBUS;
    /**
     * Creates new form PuFlight
     */
    public PuFlight() throws ClassNotFoundException, SQLException, IOException {
        initComponents();
        initPuFLight();
        style();
    }
    
    public void style(){
        pnFlightiInfo.setBackground(Styles.GRAY_100);
        Styles.ButtonPrimary(btSave);
        Styles.FormLabel(lbFlyingFrom);
        Styles.ComboBox(cbFlyingFrom);
        Styles.ComboBox(cbFlyingTo);
        lbFlightID.setFont(Styles.Micro);
        lbFlightID.setForeground(Styles.GRAY_300);
        Styles.FormTextFeild(txtFlightID);
 

        Styles.FormTextFeild(txtFlightID);
        Styles.FormLabel(lbFlyingFrom);;
        Styles.FormLabel(lbFlyingTo);
        Styles.FormTextFeild(txtHourFly);

        
        Styles.FormLabel(lbTurnDeparture);
        Styles.FormTextFeild(txtDeparture);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFlightiInfo = new javax.swing.JPanel();
        PopupHeader = new javax.swing.JPanel();
        lbHeader = new javax.swing.JLabel();
        btSave = new javax.swing.JButton();
        lbFlyingFrom = new javax.swing.JLabel();
        lbFlyingTo = new javax.swing.JLabel();
        cbFlyingTo = new javax.swing.JComboBox<>();
        cbFlyingFrom = new javax.swing.JComboBox<>();
        lbTurnDeparture = new javax.swing.JLabel();
        txtHourFly = new javax.swing.JTextField();
        txtDeparture = new javax.swing.JTextField();
        lbFlightID = new java.awt.Label();
        txtFlightID = new javax.swing.JTextField();
        lbHours = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnFlightiInfo.setBackground(new java.awt.Color(255, 255, 255));

        PopupHeader.setBackground(new java.awt.Color(1, 138, 165));

        lbHeader.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbHeader.setForeground(new java.awt.Color(255, 255, 255));
        lbHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-flight-white18.png"))); // NOI18N
        lbHeader.setText("Chuyến bay");

        javax.swing.GroupLayout PopupHeaderLayout = new javax.swing.GroupLayout(PopupHeader);
        PopupHeader.setLayout(PopupHeaderLayout);
        PopupHeaderLayout.setHorizontalGroup(
            PopupHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PopupHeaderLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(lbHeader)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        PopupHeaderLayout.setVerticalGroup(
            PopupHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PopupHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHeader)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btSave.setBackground(new java.awt.Color(1, 138, 165));
        btSave.setForeground(new java.awt.Color(255, 255, 255));
        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/action-save-white18.png"))); // NOI18N
        btSave.setText("Lưu chuyến bay");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        lbFlyingFrom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFlyingFrom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-flight-from-black20.png"))); // NOI18N
        lbFlyingFrom.setText("Bay từ");

        lbFlyingTo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFlyingTo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-flight-to-black20.png"))); // NOI18N
        lbFlyingTo.setText("Bay đến");

        cbFlyingTo.setBackground(new java.awt.Color(246, 246, 246));
        cbFlyingTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sân bay" }));
        cbFlyingTo.setToolTipText("");
        cbFlyingTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFlyingToActionPerformed(evt);
            }
        });

        cbFlyingFrom.setBackground(new java.awt.Color(204, 204, 204));
        cbFlyingFrom.setEditable(true);
        cbFlyingFrom.setForeground(new java.awt.Color(153, 153, 153));
        cbFlyingFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sân bay" }));
        cbFlyingFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFlyingFromActionPerformed(evt);
            }
        });

        lbTurnDeparture.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTurnDeparture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-time-black20.png"))); // NOI18N
        lbTurnDeparture.setText("Khởi hành");

        txtHourFly.setBackground(new java.awt.Color(246, 246, 246));
        txtHourFly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHourFlyActionPerformed(evt);
            }
        });

        lbFlightID.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbFlightID.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbFlightID.setText("Mã Tuyến Bay");

        lbHours.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbHours.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/info-time-black20.png"))); // NOI18N
        lbHours.setText("Số Giờ bay");

        javax.swing.GroupLayout pnFlightiInfoLayout = new javax.swing.GroupLayout(pnFlightiInfo);
        pnFlightiInfo.setLayout(pnFlightiInfoLayout);
        pnFlightiInfoLayout.setHorizontalGroup(
            pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PopupHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnFlightiInfoLayout.createSequentialGroup()
                .addGroup(pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnFlightiInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnFlightiInfoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTurnDeparture)
                                    .addComponent(lbHours)
                                    .addComponent(cbFlyingFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFlightiInfoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbFlyingTo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnFlightiInfoLayout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addGroup(pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHourFly, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtDeparture)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnFlightiInfoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbFlightID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbFlyingFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                        .addGroup(pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnFlightiInfoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbFlyingTo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnFlightiInfoLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(txtFlightID)))))
                .addContainerGap())
        );
        pnFlightiInfoLayout.setVerticalGroup(
            pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFlightiInfoLayout.createSequentialGroup()
                .addComponent(PopupHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbFlightID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFlightID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFlyingTo)
                    .addComponent(lbFlyingFrom))
                .addGap(18, 18, 18)
                .addGroup(pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFlyingFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFlyingTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTurnDeparture)
                    .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFlightiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHourFly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHours))
                .addGap(34, 34, 34)
                .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        PopupHeader.getAccessibleContext().setAccessibleParent(PopupHeader);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFlightiInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnFlightiInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean isValidFlightID(String flightID) {
        // Kiểm tra độ dài của FlightID
        if (flightID.length() != 6) {
            return false;
        }    
     // Kiểm tra hai ký tự đầu tiên là chữ cái viết hoa
        if (!Character.isUpperCase(flightID.charAt(0)) || !Character.isUpperCase(flightID.charAt(1))) {
            return false;
        }   
    // Kiểm tra bốn ký tự cuối là chữ số
        for (int i = 2; i < 6; i++) {
            if (!Character.isDigit(flightID.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        String fligthId = txtFlightID.getText().trim();            
        String hoursText = txtHourFly.getText().trim();
        int hours;
        try {
            hours = Integer.parseInt(hoursText);
        } catch (NumberFormatException e) {
        return; 
        }
        String flyingFrom = cbFlyingFrom.getSelectedItem().toString().trim();
        String flyingTo = cbFlyingTo.getSelectedItem().toString().trim();
        String departureText = txtDeparture.getText().trim();
        LocalDateTime departure;

        try {
            departure = LocalDateTime.parse(departureText, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        } catch (DateTimeParseException e) {
            String errorMessage = "Định dạng ngày giờ không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy HH:mm.";
            String errorTitle = "Lỗi";
            JOptionPane.showMessageDialog(null, errorMessage, errorTitle, JOptionPane.ERROR_MESSAGE);
        return; 
    }
        if (!isValidFlightID(fligthId)) {
        JOptionPane.showMessageDialog(null, "Vui lòng viết theo định dạng 2 chữ đầu viết hoa và 4 số theo sau ", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
        try {
           flightBUS = new FlightBUS();
            if (flightBUS.existsFlightID(fligthId)) {
                JOptionPane.showMessageDialog(null, "ID sân bay đã tồn tại. Vui lòng chọn ID khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Flight flight = new Flight();
            flight.setFlightID(fligthId);
            flight.setHoursFly(hours);
            flight.setFlyingFrom(flyingFrom);
            flight.setFlyingTo(flyingTo);
            flight.setDepartureFlight(departure);
            flight.setIsDelete(0);

            boolean success = flightBUS.create(flight);

            if (success) {
                JOptionPane.showMessageDialog(null, "Thêm tuyến bay thành công: ");
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Thêm tuyến bay thất bại: " , "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thực hiện thêm tuyến bay.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void cbFlyingToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFlyingToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFlyingToActionPerformed

    private void txtHourFlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHourFlyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHourFlyActionPerformed
    private void initPuFLight() throws ClassNotFoundException, SQLException, IOException {
        String selectedOptionFrom = (String) cbFlyingFrom.getSelectedItem();
        String selectedOptionTo = (String) cbFlyingTo.getSelectedItem();
        cbFlyingFrom.removeAllItems();
        airportBUS = new AirportBUS();
        ArrayList<Airport> airportList = airportBUS.getList();
        for (Airport airport : airportList) {
            if (airport.getIsDelete() == 0) {
                cbFlyingFrom.addItem(airport.getAirportID());
            }
        }
        if (cbFlyingFrom.getItemCount() > 0) {
            cbFlyingFrom.setSelectedItem(selectedOptionFrom);
        }
        cbFlyingTo.removeAllItems();
        for (Airport airport : airportList) {
            if (airport.getIsDelete() == 0 && !airport.getAirportID().equals(selectedOptionFrom)) {
                cbFlyingTo.addItem(airport.getAirportID());
            }
        }
        if (cbFlyingTo.getItemCount() > 0) {
            cbFlyingTo.setSelectedItem(selectedOptionTo);
        }
    }

    private void updateComboBox2Options() throws ClassNotFoundException, SQLException, IOException {
        String selectedOptionFrom = (String) cbFlyingFrom.getSelectedItem();
        String selectedOptionTo = (String) cbFlyingTo.getSelectedItem();
        cbFlyingTo.removeAllItems();
        airportBUS = new AirportBUS();
        ArrayList<Airport> airportList = airportBUS.getList();
        for (Airport airport : airportList) {
            if (airport.getIsDelete() == 0 && !airport.getAirportID().equals(selectedOptionFrom)) {
                cbFlyingTo.addItem(airport.getAirportID());
            }
        }
        if (cbFlyingTo.getItemCount() > 0) {
            cbFlyingTo.setSelectedItem(selectedOptionTo);
        }
    }
    

    
    private void cbFlyingFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFlyingFromActionPerformed
        try {
            updateComboBox2Options();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PuFlight.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PuFlight.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PuFlight.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbFlyingFromActionPerformed

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
            java.util.logging.Logger.getLogger(PuFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PuFlight().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PuFlight.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PuFlight.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PuFlight.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PopupHeader;
    private javax.swing.JButton btSave;
    private javax.swing.JComboBox<String> cbFlyingFrom;
    private javax.swing.JComboBox<String> cbFlyingTo;
    private java.awt.Label lbFlightID;
    private javax.swing.JLabel lbFlyingFrom;
    private javax.swing.JLabel lbFlyingTo;
    private javax.swing.JLabel lbHeader;
    private javax.swing.JLabel lbHours;
    private javax.swing.JLabel lbTurnDeparture;
    private javax.swing.JPanel pnFlightiInfo;
    private javax.swing.JTextField txtDeparture;
    private javax.swing.JTextField txtFlightID;
    private javax.swing.JTextField txtHourFly;
    // End of variables declaration//GEN-END:variables


 
}