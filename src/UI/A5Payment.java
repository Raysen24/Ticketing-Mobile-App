
package UI;

import Handler.*;
import Class.*;
import DA.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class A5Payment extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    ResultSet getUserName = null;
    PreparedStatement pst = null;
       
    Customer customer;
    Outlet[] outlets;
    int selectedOutletIndicator;
    
    Order order;
    String methodID;
    PaymentMethod paymentMethod;
    VirtualAccount virtualAccount;
    Payment payment;
        
    public A5Payment() {
        initComponents();
        this.setLocationRelativeTo(null);
        con = db.mycon();
        time();
        scaleImage(jWifi,"/pictures/Wifi_Hooray.png");
        scaleImage(jSplashBox,"/pictures/SplashBox_Hooray.png");
        scaleImage(jBackButton,"/pictures/BackButton.png");
        
        scaleImage(jPaymentTicket,"/pictures/PaymentTicket.png");
        
        scaleImage(jTopBarBox,"/pictures/TopBarBox.png");
        
        scaleImage(jPayNowButton,"/pictures/PayNowButton.png");
        
        //NOT SELECTED TAB
        scaleImage(jBarBCA,"/pictures/BarBCA.png");
        scaleImage(jBarBNI,"/pictures/BarBNI.png");
        scaleImage(jCheckCircleBCA,"/pictures/CheckCircle.png");
        scaleImage(jCheckCircleBNI,"/pictures/CheckCircle.png");
        
        //BCA SELECTED TAB
        scaleImage(jBarBCASelected,"/pictures/BarBCASelected.png");
        scaleImage(jCheckedCircleBCA,"/pictures/CheckedCircle.png");
        scaleImage(jBarBNINotSelected,"/pictures/BarBNI.png");
        scaleImage(jNotCheckedCircleBNI,"/pictures/CheckCircle.png");
        
        //BNI SELECTED TAB
        scaleImage(jBarBNISelected,"/pictures/BarBNISelected.png");
        scaleImage(jCheckedCircleBNI,"/pictures/CheckedCircle.png");
        scaleImage(jBarBCANotSelected,"/pictures/BarBCA.png");
        scaleImage(jNotCheckedCircleBCA,"/pictures/CheckCircle.png");
        
        scaleImage(jCancelNotificationBox,"/pictures/CompletedPaymentBox.png");
        scaleImage(jCancelButton,"/pictures/CancelButton.png");
        scaleImage(jXButton,"/pictures/XButton.png");

        jPanel8.setVisible(false);
    }
    
    public A5Payment(Customer customer, Outlet[] outlets, int selectedOutletIndicator, Order order) {
        this();
        
        this.customer = customer;
        this.outlets = outlets;
        this.selectedOutletIndicator = selectedOutletIndicator;
        this.order = order;
        
        setAllLabels();
    }
    
    public void setAllLabels() {
        jSelectedOutlet.setText(this.outlets[this.selectedOutletIndicator].getNameWithHOORAY());
        
        jChildTicketName.setText(this.outlets[this.selectedOutletIndicator].getTicketTypes().get(0).getName());
        jGuardianTicketName.setText(this.outlets[this.selectedOutletIndicator].getTicketTypes().get(1).getName());
        
        //if customer buy both ticket
        if(this.order.getOrderDetails().size()==2) {
            jChildTicketQty.setText(String.valueOf(this.order.getOrderDetails().get(0).getQuantity()));
            jGuardianTicketQty.setText(String.valueOf(this.order.getOrderDetails().get(1).getQuantity()));
        } else {//if customer buy only one type of ticketType
            if(this.order.getOrderDetails().get(0).getTicketTypeID().equals("1")) { //if only buy child ticket
                jChildTicketQty.setText(String.valueOf(this.order.getOrderDetails().get(0).getQuantity()));
                jGuardianTicketQty.setText("0");
            } else {
                jChildTicketQty.setText("0");
                jGuardianTicketQty.setText(String.valueOf(this.order.getOrderDetails().get(0).getQuantity()));
            }
        }
        
        jTotalPrice.setText(this.order.getTotalPriceInRupiah());
        jTotalPrice2.setText(this.order.getTotalPriceInRupiah());
        
    }
    
    public void time(){
        Timer timer;
        
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Date date = new Date();
                SimpleDateFormat st = new SimpleDateFormat("hh:mm");
                
                String clockString = st.format(date);
                
                jClock.setText(clockString);
            }   
        });
        
        timer.start();
    }
    
    public void scaleImage(JLabel address,String imgURL) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imgURL));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(address.getWidth(), address.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        address.setIcon(scaledIcon );
        address.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jXButton = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCancelButton = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jCancelNotificationBox = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jClock = new javax.swing.JLabel();
        jWifi = new javax.swing.JLabel();
        jBackButton = new javax.swing.JLabel();
        JWelcome = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jChildTicketQty = new javax.swing.JLabel();
        jSelectedOutlet = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTotalPrice = new javax.swing.JLabel();
        jChildTicketName = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPaymentTicket = new javax.swing.JLabel();
        jGuardianTicketName = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jGuardianTicketQty = new javax.swing.JLabel();
        jTotalPrice2 = new javax.swing.JLabel();
        jPayNowButton = new javax.swing.JLabel();
        jSplashBox = new javax.swing.JLabel();
        jTopBarBox = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jCheckCircleBCA = new javax.swing.JLabel();
        jBarBCA = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jCheckCircleBNI = new javax.swing.JLabel();
        jBarBNI = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jCheckedCircleBCA = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jBarBCASelected = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jNotCheckedCircleBNI = new javax.swing.JLabel();
        jBarBNINotSelected = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jNotCheckedCircleBCA = new javax.swing.JLabel();
        jBarBCANotSelected = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jCheckedCircleBNI = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jBarBNISelected = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(0, 0, 0, 135));
        jPanel8.setPreferredSize(new java.awt.Dimension(375, 750));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXButton.setText("X");
        jXButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXButtonMouseClicked(evt);
            }
        });
        jPanel8.add(jXButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 30, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(166, 166, 166));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("cancel your order?");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 160, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(166, 166, 166));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Are you sure you want to");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 230, 30));

        jCancelButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCancelButton.setText("Cancel");
        jCancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCancelButtonMouseClicked(evt);
            }
        });
        jPanel8.add(jCancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 200, 47));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(166, 166, 166));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("You will have to make a new one");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 240, 30));

        jCancelNotificationBox.setText("jLabel1");
        jCancelNotificationBox.setPreferredSize(new java.awt.Dimension(300, 245));
        jPanel8.add(jCancelNotificationBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 215, -1, 300));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(254, 253, 244));
        jPanel1.setPreferredSize(new java.awt.Dimension(375, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(375, 40));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jClock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jClock.setText("hh:mm");
        jPanel2.add(jClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jWifi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jWifi.setText("icon (wifi, etc)");
        jWifi.setPreferredSize(new java.awt.Dimension(67, 12));
        jPanel2.add(jWifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 14, 70, 16));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 375, 40));

        jBackButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBackButton.setText("<");
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });
        jPanel1.add(jBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 50, 31, 30));

        JWelcome.setBackground(new java.awt.Color(183, 218, 222));
        JWelcome.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        JWelcome.setText("Payment");
        jPanel1.add(JWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 50, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 375, 50));

        jChildTicketQty.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jChildTicketQty.setForeground(new java.awt.Color(166, 166, 166));
        jChildTicketQty.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jChildTicketQty.setText("99");
        jPanel1.add(jChildTicketQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 150, 20, -1));

        jSelectedOutlet.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jSelectedOutlet.setText("Hooray Paris Van Java");
        jPanel1.add(jSelectedOutlet, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Total Amount");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel13.setText("Total");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, -1, -1));

        jTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTotalPrice.setText("Rp 300.000");
        jPanel1.add(jTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        jChildTicketName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jChildTicketName.setForeground(new java.awt.Color(166, 166, 166));
        jChildTicketName.setText("Child Ticket");
        jPanel1.add(jChildTicketName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(166, 166, 166));
        jLabel20.setText("Qty :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 150, -1, -1));

        jPaymentTicket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPaymentTicket.setText("Ticket");
        jPaymentTicket.setPreferredSize(new java.awt.Dimension(85, 85));
        jPanel1.add(jPaymentTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 85));

        jGuardianTicketName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jGuardianTicketName.setForeground(new java.awt.Color(166, 166, 166));
        jGuardianTicketName.setText("Child Ticket");
        jPanel1.add(jGuardianTicketName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(166, 166, 166));
        jLabel22.setText("Qty :");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 180, -1, -1));

        jGuardianTicketQty.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jGuardianTicketQty.setForeground(new java.awt.Color(166, 166, 166));
        jGuardianTicketQty.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jGuardianTicketQty.setText("99");
        jPanel1.add(jGuardianTicketQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 180, 20, -1));

        jTotalPrice2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTotalPrice2.setText("Rp 300.000");
        jPanel1.add(jTotalPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 622, -1, 30));

        jPayNowButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPayNowButton.setText("Pay Now");
        jPayNowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPayNowButtonMouseClicked(evt);
            }
        });
        jPanel1.add(jPayNowButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 610, 130, 50));

        jSplashBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jSplashBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(-16, 105, 410, 140));

        jTopBarBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jTopBarBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 375, 170));

        jTabbedPane1.setEnabled(false);

        jPanel7.setBackground(new java.awt.Color(254, 253, 244));
        jPanel7.setMaximumSize(new java.awt.Dimension(375, 345));
        jPanel7.setMinimumSize(new java.awt.Dimension(375, 345));
        jPanel7.setPreferredSize(new java.awt.Dimension(375, 345));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Virtual Account");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 6, 144, 29));

        jPanel10.setBackground(new java.awt.Color(254, 253, 244));
        jPanel10.setPreferredSize(new java.awt.Dimension(375, 80));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckCircleBCA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckCircleBCA.setText("O");
        jCheckCircleBCA.setPreferredSize(new java.awt.Dimension(20, 20));
        jCheckCircleBCA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckCircleBCAMouseClicked(evt);
            }
        });
        jPanel10.add(jCheckCircleBCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 29, 20, -1));

        jBarBCA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBarBCA.setText("BCA");
        jPanel10.add(jBarBCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 375, 80));

        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, -1, -1));

        jPanel11.setBackground(new java.awt.Color(254, 253, 244));
        jPanel11.setPreferredSize(new java.awt.Dimension(375, 80));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckCircleBNI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckCircleBNI.setText("O");
        jCheckCircleBNI.setPreferredSize(new java.awt.Dimension(20, 20));
        jCheckCircleBNI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckCircleBNIMouseClicked(evt);
            }
        });
        jPanel11.add(jCheckCircleBNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 29, 20, -1));

        jBarBNI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBarBNI.setText("Gopay");
        jPanel11.add(jBarBNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 375, 80));

        jPanel7.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 124, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("NotSelected", jPanel4);

        jPanel9.setBackground(new java.awt.Color(254, 253, 244));
        jPanel9.setMaximumSize(new java.awt.Dimension(375, 345));
        jPanel9.setMinimumSize(new java.awt.Dimension(375, 345));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Virtual Account");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 6, 144, 29));

        jPanel14.setBackground(new java.awt.Color(254, 253, 244));
        jPanel14.setPreferredSize(new java.awt.Dimension(375, 200));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckedCircleBCA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckedCircleBCA.setText("O");
        jCheckedCircleBCA.setPreferredSize(new java.awt.Dimension(20, 20));
        jCheckedCircleBCA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckedCircleBCAMouseClicked(evt);
            }
        });
        jPanel14.add(jCheckedCircleBCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 29, 20, -1));

        jLabel7.setBackground(new java.awt.Color(184, 189, 194));
        jLabel7.setForeground(new java.awt.Color(184, 189, 194));
        jLabel7.setText("2. Enter Virtual Account number XXXXXXXXXXX and ");
        jPanel14.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 90, -1, -1));

        jLabel8.setBackground(new java.awt.Color(184, 189, 194));
        jLabel8.setForeground(new java.awt.Color(184, 189, 194));
        jLabel8.setText("choose Send");
        jPanel14.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 106, -1, -1));

        jLabel14.setBackground(new java.awt.Color(184, 189, 194));
        jLabel14.setForeground(new java.awt.Color(184, 189, 194));
        jLabel14.setText("3. Enter m-BCA pin and click OK");
        jPanel14.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 126, -1, -1));

        jLabel15.setBackground(new java.awt.Color(184, 189, 194));
        jLabel15.setForeground(new java.awt.Color(184, 189, 194));
        jLabel15.setText("1. Choose m-Transfer > BCA Virtual Account");
        jPanel14.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 70, -1, -1));

        jBarBCASelected.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel14.add(jBarBCASelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 375, 165));

        jPanel9.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, -1, 170));

        jPanel15.setBackground(new java.awt.Color(254, 253, 244));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jNotCheckedCircleBNI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jNotCheckedCircleBNI.setText("O");
        jNotCheckedCircleBNI.setPreferredSize(new java.awt.Dimension(20, 20));
        jNotCheckedCircleBNI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNotCheckedCircleBNIMouseClicked(evt);
            }
        });
        jPanel15.add(jNotCheckedCircleBNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 29, 20, -1));

        jBarBNINotSelected.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBarBNINotSelected.setText("Gopay");
        jPanel15.add(jBarBNINotSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 375, 80));

        jPanel9.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("BCA", jPanel5);

        jPanel17.setBackground(new java.awt.Color(254, 253, 244));
        jPanel17.setMaximumSize(new java.awt.Dimension(375, 345));
        jPanel17.setMinimumSize(new java.awt.Dimension(375, 345));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Virtual Account");
        jPanel17.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 6, 144, 29));

        jPanel18.setBackground(new java.awt.Color(254, 253, 244));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jNotCheckedCircleBCA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jNotCheckedCircleBCA.setText("O");
        jNotCheckedCircleBCA.setPreferredSize(new java.awt.Dimension(20, 20));
        jNotCheckedCircleBCA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNotCheckedCircleBCAMouseClicked(evt);
            }
        });
        jPanel18.add(jNotCheckedCircleBCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 29, 20, -1));

        jBarBCANotSelected.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBarBCANotSelected.setText("BCA");
        jPanel18.add(jBarBCANotSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 375, 80));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, -1, -1));

        jPanel19.setBackground(new java.awt.Color(254, 253, 244));
        jPanel19.setPreferredSize(new java.awt.Dimension(375, 200));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckedCircleBNI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckedCircleBNI.setText("O");
        jCheckedCircleBNI.setPreferredSize(new java.awt.Dimension(20, 20));
        jCheckedCircleBNI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckedCircleBNIMouseClicked(evt);
            }
        });
        jPanel19.add(jCheckedCircleBNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 29, 20, -1));

        jLabel17.setBackground(new java.awt.Color(184, 189, 194));
        jLabel17.setForeground(new java.awt.Color(184, 189, 194));
        jLabel17.setText("3. Enter m-BNI pin and click OK");
        jPanel19.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 126, -1, -1));

        jLabel18.setBackground(new java.awt.Color(184, 189, 194));
        jLabel18.setForeground(new java.awt.Color(184, 189, 194));
        jLabel18.setText("choose Send");
        jPanel19.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 106, -1, -1));

        jLabel19.setBackground(new java.awt.Color(184, 189, 194));
        jLabel19.setForeground(new java.awt.Color(184, 189, 194));
        jLabel19.setText("2. Enter Virtual Account number XXXXXXXXXXX and ");
        jPanel19.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 90, -1, -1));

        jLabel21.setBackground(new java.awt.Color(184, 189, 194));
        jLabel21.setForeground(new java.awt.Color(184, 189, 194));
        jLabel21.setText("1. Choose m-Transfer > BNI Virtual Account");
        jPanel19.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 70, -1, -1));

        jBarBNISelected.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel19.add(jBarBNISelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 375, 165));

        jPanel17.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 124, -1, 170));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Gopay", jPanel6);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 215, 375, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        //Cancel confirmation
        jPanel8.setVisible(true);
    }//GEN-LAST:event_jBackButtonMouseClicked

    private void jCheckCircleBCAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckCircleBCAMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jCheckCircleBCAMouseClicked

    private void jCheckCircleBNIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckCircleBNIMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jCheckCircleBNIMouseClicked

    private void jCheckedCircleBCAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckedCircleBCAMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jCheckedCircleBCAMouseClicked

    private void jNotCheckedCircleBNIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNotCheckedCircleBNIMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jNotCheckedCircleBNIMouseClicked

    private void jNotCheckedCircleBCAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNotCheckedCircleBCAMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jNotCheckedCircleBCAMouseClicked

    private void jCheckedCircleBNIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckedCircleBNIMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jCheckedCircleBNIMouseClicked

    private void jPayNowButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPayNowButtonMouseClicked
//        //if customer already choose one of payment method
//        if(jTabbedPane1.getSelectedIndex()!=0) {
//            //getAllPaymentMathodData based on the methodID which is indicated by selected TabedPane
//            this.methodID = String.valueOf(jTabbedPane1.getSelectedIndex());
//            
//            //Get all payment method data needed from database and save all data from paymentmethod to obj
//            this.paymentMethod = new PaymentMethod(DA.DA_PaymentMethod.getAllPaymentMethodData(methodID));
//            
//            //if there is already virtualAccount of payment selected
//            //Get all virtual account data from database and save all data from virtualaccount to obj
//            if(DA.DA_VirtualAccount.checkingVirtualAccountAvailability(this.customer.getCustomerID(), this.paymentMethod.getMethodID())) {
//                this.virtualAccount = new VirtualAccount(DA.DA_VirtualAccount.getAllVirtualAccountData(this.customer.getCustomerID(), this.paymentMethod.getMethodID()), this.paymentMethod);
//            } else { //if there is no virtualAccount yet, then insert a new one, get all the data, and save to obj virtualAccount
//                String virtualAcc = this.paymentMethod.getBankCode()+this.customer.getCustomerID();
//                DA.DA_VirtualAccount.insertNewVirtualAccount(this.customer.getCustomerID(), this.paymentMethod.getMethodID(), virtualAcc, "0");
//                this.virtualAccount = new VirtualAccount(DA.DA_VirtualAccount.getAllVirtualAccountData(this.customer.getCustomerID(), this.paymentMethod.getMethodID()), this.paymentMethod);
//            }
//            
//            //Insert new payment to database and save also to obj Payment
//            DA.DA_Payment.insertNewPayment(this.order.getOrderID(), this.methodID, String.valueOf(this.order.getTotalPrice()), this.virtualAccount.getVirtualAcc());
//            this.payment = new Payment(DA.DA_Payment.getAllPaymentData(this.order.getOrderID(), "waiting"), this.order, this.paymentMethod);
//            
//            //Set bill for virtualAccount
//            DA.DA_VirtualAccount.setVirtualAccountBill(this.virtualAccount.getVirtualAcc(), String.valueOf(this.order.getTotalPrice()));
//            
//            if(jTabbedPane1.getSelectedIndex()==1) {
//                this.setVisible(false);
//                new A6BCAPayment(this.customer, this.outlets, this.selectedOutletIndicator, this.payment).setVisible(true);
//            } else {
//                this.setVisible(false);
////                new A6BNIPayment(this.customer, this.outlets, this.selectedOutletIndicator, this.payment).setVisible(true);
//            }
//        }
        
        Handler.proceedPayment(this.customer, this.outlets, this.selectedOutletIndicator, this.order, jTabbedPane1,
                               this.methodID, this.paymentMethod, this.virtualAccount, this.payment, this);
        
    }//GEN-LAST:event_jPayNowButtonMouseClicked

    private void jCancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelButtonMouseClicked
//        //Delete order and orderDetail from database
//        DA.DA_OrderDetail.deleteOrderDetail(this.order.getOrderID()); //remove orderDetail from database
//        DA.DA_Order.deleteOrder(this.order.getOrderID()); //remove orderDetail from database
//        
//        //Back to page ordersummary
//        this.setVisible(false);
//        new A4OrderSummary(this.customer, this.outlets, this.selectedOutletIndicator).setVisible(true);
        Handler.cancelOrder(this.order, this, this.customer, this.outlets, this.selectedOutletIndicator);
    }//GEN-LAST:event_jCancelButtonMouseClicked

    private void jXButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXButtonMouseClicked
        jPanel8.setVisible(false);
    }//GEN-LAST:event_jXButtonMouseClicked

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
            java.util.logging.Logger.getLogger(A5Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A5Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A5Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A5Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new A5Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JWelcome;
    private javax.swing.JLabel jBackButton;
    private javax.swing.JLabel jBarBCA;
    private javax.swing.JLabel jBarBCANotSelected;
    private javax.swing.JLabel jBarBCASelected;
    private javax.swing.JLabel jBarBNI;
    private javax.swing.JLabel jBarBNINotSelected;
    private javax.swing.JLabel jBarBNISelected;
    private javax.swing.JLabel jCancelButton;
    private javax.swing.JLabel jCancelNotificationBox;
    private javax.swing.JLabel jCheckCircleBCA;
    private javax.swing.JLabel jCheckCircleBNI;
    private javax.swing.JLabel jCheckedCircleBCA;
    private javax.swing.JLabel jCheckedCircleBNI;
    private javax.swing.JLabel jChildTicketName;
    private javax.swing.JLabel jChildTicketQty;
    private javax.swing.JLabel jClock;
    private javax.swing.JLabel jGuardianTicketName;
    private javax.swing.JLabel jGuardianTicketQty;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jNotCheckedCircleBCA;
    private javax.swing.JLabel jNotCheckedCircleBNI;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jPayNowButton;
    private javax.swing.JLabel jPaymentTicket;
    private javax.swing.JLabel jSelectedOutlet;
    private javax.swing.JLabel jSplashBox;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jTopBarBox;
    private javax.swing.JLabel jTotalPrice;
    private javax.swing.JLabel jTotalPrice2;
    private javax.swing.JLabel jWifi;
    private javax.swing.JLabel jXButton;
    // End of variables declaration//GEN-END:variables
}
