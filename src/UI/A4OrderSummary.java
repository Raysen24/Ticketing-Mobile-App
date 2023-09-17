
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.Timer;

public class A4OrderSummary extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    ResultSet getUserName = null;
    PreparedStatement pst = null;
    
    Customer customer;
    Outlet[] outlets;
    int selectedOutletIndicator;
    
    int childAmount;
    int guardianAmount;
    
    String usePointsStatus;
    double totalPrice;
    
    Order order;
    
    // Get the current date
    LocalDate currentDate = LocalDate.now();
    Date today = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd");
    String dateToday = st.format(today);
   
    public A4OrderSummary() {
        initComponents();
        this.setLocationRelativeTo(null);
        con = db.mycon();
        time();
        scaleImage(jWifi,"/pictures/Wifi_Hooray.png");
        scaleImage(jSplashBox,"/pictures/SplashBox_Hooray.png");
        scaleImage(jBackButton,"/pictures/BackButton.png");
        scaleImage(jTicketDetailsTicket1,"/pictures/TicketDetailsTicket.png");
        scaleImage(jTicketDetailsTicket2,"/pictures/TicketDetailsTicket.png");

        scaleImage(jMinus,"/pictures/MinusTicket.png");
        scaleImage(jAmountBg,"/pictures/AmountTicket.png");
        scaleImage(jPlus,"/pictures/PlusTicket.png");
        
        scaleImage(jMinus1,"/pictures/MinusTicket.png");
        scaleImage(jAmountBg1,"/pictures/AmountTicket.png");
        scaleImage(jPlus1,"/pictures/PlusTicket.png");

        scaleImage(jContinueToPayment,"/pictures/ContinueToPayment.png");
    
        scaleImage(jPointsButtonInactive,"/pictures/DiactivateButton.png");
        scaleImage(jPointsButtonActive,"/pictures/ActivateButton.png");
        
        
    }
    
    public A4OrderSummary(Customer customer, Outlet[] outlets, int selectedOutletIndicator) {
        
        this();
        
        this.customer = customer;
        this.outlets = outlets;
        this.selectedOutletIndicator = selectedOutletIndicator;
        
        setAllLabels();
    }
    
    public void setAllLabels() {
        jOutletName.setText(this.outlets[this.selectedOutletIndicator].getNameWithHOORAY());
        
        //Child ticket labels
        jChildTicketName.setText(this.outlets[selectedOutletIndicator].getTicketTypes().get(0).getName());
        jChildTicketPrice.setText(this.outlets[selectedOutletIndicator].getTicketTypes().get(0).getPricePerTicketInRupiah());
        jChildTicketGiftPoints.setText(String.valueOf(this.outlets[selectedOutletIndicator].getTicketTypes().get(0).getGiftPoint()) + " Points");
        
        //Guardian ticket labels
        jGuardianTicketName.setText(this.outlets[selectedOutletIndicator].getTicketTypes().get(1).getName());
        jGuardianTicketPrice.setText(this.outlets[selectedOutletIndicator].getTicketTypes().get(1).getPricePerTicketInRupiah());
        jGuardianTicketGiftPoints.setText(String.valueOf(this.outlets[selectedOutletIndicator].getTicketTypes().get(1).getGiftPoint()) + " Points");
        
        //Customer points
        jPoints.setText(String.valueOf(this.customer.getPoints()));
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jClock = new javax.swing.JLabel();
        jWifi = new javax.swing.JLabel();
        jBackButton = new javax.swing.JLabel();
        JWelcome = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jOutletName = new javax.swing.JLabel();
        jChildTicketName = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jChildTicketPrice = new javax.swing.JLabel();
        jChildTicketGiftPoints = new javax.swing.JLabel();
        jMinus = new javax.swing.JLabel();
        jPlus = new javax.swing.JLabel();
        jChildTicketAmount = new javax.swing.JLabel();
        jAmountBg = new javax.swing.JLabel();
        jTicketDetailsTicket1 = new javax.swing.JLabel();
        jGuardianTicketName = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jGuardianTicketPrice = new javax.swing.JLabel();
        jGuardianTicketGiftPoints = new javax.swing.JLabel();
        jMinus1 = new javax.swing.JLabel();
        jGuardianTicketAmount = new javax.swing.JLabel();
        jAmountBg1 = new javax.swing.JLabel();
        jPlus1 = new javax.swing.JLabel();
        jTicketDetailsTicket2 = new javax.swing.JLabel();
        jSplashBox = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPoints = new javax.swing.JLabel();
        jTotalPrice = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSubTotal = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jContinueToPayment = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jUsePointsStatus = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPointsButtonInactive = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPointsButtonActive = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

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
        JWelcome.setText("Order Summary");
        jPanel1.add(JWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 50, -1, -1));

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(129, 126, 135));
        jLabel1.setText("Ticket");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jOutletName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jOutletName.setText("Outlet Name");
        jPanel1.add(jOutletName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jChildTicketName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jChildTicketName.setText("Ticket Name");
        jPanel1.add(jChildTicketName, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 190, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(129, 126, 135));
        jLabel21.setText("Ticket perlu reservasi");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, 10));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(129, 126, 135));
        jLabel7.setText("Gunakan dalam 7 hari sejak tanggal pilihan");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 242, -1, -1));

        jChildTicketPrice.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jChildTicketPrice.setForeground(new java.awt.Color(165, 200, 205));
        jChildTicketPrice.setText("Rp 000.000");
        jPanel1.add(jChildTicketPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 190, -1, -1));

        jChildTicketGiftPoints.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jChildTicketGiftPoints.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jChildTicketGiftPoints.setText("000 Points");
        jPanel1.add(jChildTicketGiftPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 210, 90, 20));

        jMinus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMinus.setText("-");
        jMinus.setPreferredSize(new java.awt.Dimension(25, 25));
        jMinus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMinusMouseClicked(evt);
            }
        });
        jPanel1.add(jMinus, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 240, 25, 25));

        jPlus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPlus.setText("+");
        jPlus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPlusMouseClicked(evt);
            }
        });
        jPanel1.add(jPlus, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 240, 25, 25));

        jChildTicketAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jChildTicketAmount.setText("0");
        jPanel1.add(jChildTicketAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 240, 25, 25));

        jAmountBg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jAmountBg.setText("0");
        jPanel1.add(jAmountBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 240, 25, 25));

        jTicketDetailsTicket1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jTicketDetailsTicket1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 170, 335, 120));

        jGuardianTicketName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jGuardianTicketName.setText("Entrance Ticket");
        jPanel1.add(jGuardianTicketName, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 300, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(129, 126, 135));
        jLabel22.setText("Ticket perlu reservasi");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, 10));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(129, 126, 135));
        jLabel10.setText("Gunakan dalam 7 hari sejak tanggal pilihan");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        jGuardianTicketPrice.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jGuardianTicketPrice.setForeground(new java.awt.Color(165, 200, 205));
        jGuardianTicketPrice.setText("Rp 000.000");
        jPanel1.add(jGuardianTicketPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 300, -1, -1));

        jGuardianTicketGiftPoints.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jGuardianTicketGiftPoints.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jGuardianTicketGiftPoints.setText("000 Points");
        jPanel1.add(jGuardianTicketGiftPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 320, 90, 20));

        jMinus1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMinus1.setText("-");
        jMinus1.setPreferredSize(new java.awt.Dimension(25, 25));
        jMinus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMinus1MouseClicked(evt);
            }
        });
        jPanel1.add(jMinus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 350, 25, 25));

        jGuardianTicketAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jGuardianTicketAmount.setText("0");
        jPanel1.add(jGuardianTicketAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 350, 25, 25));

        jAmountBg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jAmountBg1.setText("0");
        jPanel1.add(jAmountBg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 350, 25, 25));

        jPlus1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPlus1.setText("+");
        jPlus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPlus1MouseClicked(evt);
            }
        });
        jPanel1.add(jPlus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 350, 25, 25));

        jTicketDetailsTicket2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jTicketDetailsTicket2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 280, 335, 120));

        jSplashBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jSplashBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(-16, 105, 410, 310));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 375, -1));

        jLabel13.setText("UsePoints");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel14.setText("Available Points :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        jPoints.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jPoints.setText("100");
        jPanel1.add(jPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 130, -1));

        jTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jTotalPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTotalPrice.setText("Rp 000.000");
        jPanel1.add(jTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 580, 180, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setText("Sub Total");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        jSubTotal.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jSubTotal.setText("Rp 000.000");
        jPanel1.add(jSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 490, 130, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setText("Total Amount");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        jContinueToPayment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jContinueToPayment.setText("Continue To Payment");
        jContinueToPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jContinueToPaymentMouseClicked(evt);
            }
        });
        jPanel1.add(jContinueToPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 645, 375, 50));

        jPanel5.setBackground(new java.awt.Color(254, 253, 244));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 124, 40));

        jUsePointsStatus.setBackground(new java.awt.Color(254, 253, 244));
        jUsePointsStatus.setForeground(new java.awt.Color(254, 253, 244));

        jPanel4.setBackground(new java.awt.Color(254, 253, 244));
        jPanel4.setForeground(new java.awt.Color(254, 253, 244));

        jPanel8.setBackground(new java.awt.Color(254, 253, 244));
        jPanel8.setForeground(new java.awt.Color(254, 253, 244));
        jPanel8.setPreferredSize(new java.awt.Dimension(55, 25));

        jPointsButtonInactive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPointsButtonInactive.setText("Inactive");
        jPointsButtonInactive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPointsButtonInactiveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jPointsButtonInactive, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jPointsButtonInactive, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        jUsePointsStatus.addTab("tab1", jPanel4);

        jPanel9.setBackground(new java.awt.Color(254, 253, 244));
        jPanel9.setForeground(new java.awt.Color(254, 253, 244));

        jPanel10.setBackground(new java.awt.Color(254, 253, 244));
        jPanel10.setForeground(new java.awt.Color(254, 253, 244));
        jPanel10.setPreferredSize(new java.awt.Dimension(55, 25));

        jPointsButtonActive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPointsButtonActive.setText("Active");
        jPointsButtonActive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPointsButtonActiveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jPointsButtonActive, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jPointsButtonActive, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        jUsePointsStatus.addTab("tab2", jPanel9);

        jPanel1.add(jUsePointsStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 500, 102, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        Handler.openTicketDetailsPage(this.customer, this.outlets, this.selectedOutletIndicator, this);
    }//GEN-LAST:event_jBackButtonMouseClicked

    private void jPointsButtonActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPointsButtonActiveMouseClicked
        //if customer disactivate point, the total price will be added back
        Handler.addBackTotalPrice(this.customer, this.totalPrice, jTotalPrice, jUsePointsStatus);
    }//GEN-LAST:event_jPointsButtonActiveMouseClicked

    private void jPointsButtonInactiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPointsButtonInactiveMouseClicked
//        //if customer doesn't have points or no ticket is selected, they cannot activate "use points" button and notification will pop up
//        if(this.customer.getPoints()==0){
//            JOptionPane.showMessageDialog(rootPane, "You dont have enough points");
//        } else if(jSubTotal.getText().equals("Rp 000.000")) {
//            JOptionPane.showMessageDialog(rootPane, "Please select a ticket");
//        } else {
//            //if they activate point, the total price will be subtracted
//            this.totalPrice -= this.customer.getPoints();
//            jTotalPrice.setText(rupiahFormat(totalPrice));
//            
//            jUsePointsStatus.setSelectedIndex(1);
//        }
        
        Handler.usingPoints(this.customer, jSubTotal, this.totalPrice, jTotalPrice, jUsePointsStatus);
    }//GEN-LAST:event_jPointsButtonInactiveMouseClicked

    private void jMinusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMinusMouseClicked
        childAmount = Integer.valueOf(jChildTicketAmount.getText());
        if(childAmount>0) {
            childAmount -= 1;
        }
        jChildTicketAmount.setText(String.valueOf(childAmount));
        setJSubTotalAndJTotalPrice();
        
//        Handler.minusChildTicketAmount(this.childAmount, jChildTicketAmount);
////        Handler.setJSubTotalAndJTotalPrice(customer, outlets, selectedOutletIndicator, childAmount, guardianAmount, totalPrice,
////                                   jSubTotal, jTotalPrice,  jUsePointsStatus);
//        setJSubTotalAndJTotalPrice();
    }//GEN-LAST:event_jMinusMouseClicked

    private void jPlusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPlusMouseClicked
        childAmount = Integer.valueOf(jChildTicketAmount.getText());
        if(childAmount<99) {
            childAmount += 1;
        }
        jChildTicketAmount.setText(String.valueOf(childAmount));
        setJSubTotalAndJTotalPrice();
//        
//        Handler.plusChildTicketAmount(this.childAmount, jChildTicketAmount);
//        Handler.setJSubTotalAndJTotalPrice(customer, outlets, selectedOutletIndicator, childAmount, guardianAmount, totalPrice,
//                                   jSubTotal, jTotalPrice,  jUsePointsStatus);
////        
//        setJSubTotalAndJTotalPrice();
    }//GEN-LAST:event_jPlusMouseClicked

    private void jMinus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMinus1MouseClicked
        guardianAmount = Integer.valueOf(jGuardianTicketAmount.getText());
        if(guardianAmount>0) {
            guardianAmount -= 1;
        }
        jGuardianTicketAmount.setText(String.valueOf(guardianAmount));
        setJSubTotalAndJTotalPrice();
//
//        Handler.minusGuardianTicketAmount(this.guardianAmount, jGuardianTicketAmount);
//        Handler.setJSubTotalAndJTotalPrice(customer, outlets, selectedOutletIndicator, childAmount, guardianAmount, totalPrice,
//                                           jSubTotal, jTotalPrice,  jUsePointsStatus);
//        setJSubTotalAndJTotalPrice();
    }//GEN-LAST:event_jMinus1MouseClicked

    private void jPlus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPlus1MouseClicked
        guardianAmount = Integer.valueOf(jGuardianTicketAmount.getText());
        if(guardianAmount < 2) {
            guardianAmount += 1;
        }
        jGuardianTicketAmount.setText(String.valueOf(guardianAmount));
        setJSubTotalAndJTotalPrice();
//
//        Handler.plusGuardianTicketAmount(this.guardianAmount, jGuardianTicketAmount);
//        Handler.setJSubTotalAndJTotalPrice(customer, outlets, selectedOutletIndicator, childAmount, guardianAmount, totalPrice,
//                                   jSubTotal, jTotalPrice,  jUsePointsStatus);
//        setJSubTotalAndJTotalPrice();
    }//GEN-LAST:event_jPlus1MouseClicked

    private void jContinueToPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContinueToPaymentMouseClicked
        if(jUsePointsStatus.getSelectedIndex()==0) {
            this.usePointsStatus = "not use";
        } else {
            this.usePointsStatus = "use";
            this.totalPrice -= customer.getPoints();
        }
//        //Insert Order
        Handler.openPaymentPage(this.customer, this.outlets, this.selectedOutletIndicator, this.usePointsStatus, this.totalPrice, this.order, this.dateToday, 
                                jChildTicketAmount.getText(), this.childAmount, jGuardianTicketAmount.getText(), this.guardianAmount, this, jSubTotal);
        
//        //Inserting new order to database
//        
//        DA.DA_Order.insertNewOrder(customer.getCustomerID(), usePointsStatus, totalPrice);
//        
//        //Create Order that havent been paid object from Order class
//        order = new Order(DA.DA_Order.getAllOrderData(customer.getCustomerID(), dateToday, "pending"));
//        System.out.println("this line 623");
//        //if there is Child Ticket that customer wants to buy
//        if(Integer.valueOf(jChildTicketAmount.getText())!=0) {
//            //Inserting new orderDetail of Child Ticket to database
//            String[] ticketTypeDataForOrderDetail = {outlets[selectedOutletIndicator].getTicketTypes().get(0).getTicketTypeID(),
//                                                   String.valueOf(outlets[selectedOutletIndicator].getTicketTypes().get(0).getPricePerTicket()),
//                                                   String.valueOf(childAmount)};
//            DA.DA_OrderDetail.insertNewOrderDetail(order.getOrderID(), ticketTypeDataForOrderDetail);
//        }
//        
//        //if there is Guardian Ticket that customer wants to buy
//        if(Integer.valueOf(jGuardianTicketAmount.getText())!=0) {
//            //Inserting new orderDetail of Guardian Ticket to database
//            String[] ticketTypeDataForOrderDetail = {outlets[selectedOutletIndicator].getTicketTypes().get(1).getTicketTypeID(),
//                                                   String.valueOf(outlets[selectedOutletIndicator].getTicketTypes().get(1).getPricePerTicket()),
//                                                   String.valueOf(guardianAmount)};
//            DA.DA_OrderDetail.insertNewOrderDetail(order.getOrderID(), ticketTypeDataForOrderDetail);
//        }
//        
//        ArrayList<ArrayList<String>> allOrderDetails = DA.DA_OrderDetail.getAllOrderDetailsData(order.getOrderID());
//        for(int i = 0; i < allOrderDetails.size(); i++) {
//            OrderDetail orderDetail1 = new OrderDetail(allOrderDetails.get(i), 
//                                                       order, 
//                                                       outlets[selectedOutletIndicator].getTicketTypes().get(i));
//        }
//        System.out.println(" this line 648 ");
//        this.setVisible(false);
//        new A5Payment(customer, outlets, selectedOutletIndicator, order).setVisible(true);
    }//GEN-LAST:event_jContinueToPaymentMouseClicked

    
    //Method to return double with rupiah format
    public static String rupiahFormat(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        decimalFormat.setMaximumFractionDigits(0);
        decimalFormat.setMinimumFractionDigits(0);
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        decimalFormat.setDecimalSeparatorAlwaysShown(false);

        String rupiahSymbol = "Rp ";
        String formattedAmount = decimalFormat.format(amount);

        return rupiahSymbol + formattedAmount.replace(",", ".");
    }
    
    //Method to calculate everytime customer click plus or minus
    public void setJSubTotalAndJTotalPrice() {
        double childSubTotal = this.outlets[this.selectedOutletIndicator].getTicketTypes().get(0).getPricePerTicket()*this.childAmount;
        double guardianSubTotal = this.outlets[this.selectedOutletIndicator].getTicketTypes().get(1).getPricePerTicket()*this.guardianAmount;
        
        totalPrice = childSubTotal+guardianSubTotal;
        
        if(totalPrice == 0){
            jSubTotal.setText("Rp 000.000");
            jTotalPrice.setText("Rp 000.000");
        } else {
            jSubTotal.setText(rupiahFormat(totalPrice));
            if(jUsePointsStatus.getSelectedIndex()==1) { //if customer use points
                totalPrice -= customer.getPoints();
                jTotalPrice.setText(rupiahFormat(totalPrice));
            } else { //if customer not using points
                jTotalPrice.setText(rupiahFormat(totalPrice));
            }
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
            java.util.logging.Logger.getLogger(A4OrderSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A4OrderSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A4OrderSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A4OrderSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A4OrderSummary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JWelcome;
    private javax.swing.JLabel jAmountBg;
    private javax.swing.JLabel jAmountBg1;
    private javax.swing.JLabel jBackButton;
    private javax.swing.JLabel jChildTicketAmount;
    private javax.swing.JLabel jChildTicketGiftPoints;
    private javax.swing.JLabel jChildTicketName;
    private javax.swing.JLabel jChildTicketPrice;
    private javax.swing.JLabel jClock;
    private javax.swing.JLabel jContinueToPayment;
    private javax.swing.JLabel jGuardianTicketAmount;
    private javax.swing.JLabel jGuardianTicketGiftPoints;
    private javax.swing.JLabel jGuardianTicketName;
    private javax.swing.JLabel jGuardianTicketPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jMinus;
    private javax.swing.JLabel jMinus1;
    private javax.swing.JLabel jOutletName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jPlus;
    private javax.swing.JLabel jPlus1;
    private javax.swing.JLabel jPoints;
    private javax.swing.JLabel jPointsButtonActive;
    private javax.swing.JLabel jPointsButtonInactive;
    private javax.swing.JLabel jSplashBox;
    private javax.swing.JLabel jSubTotal;
    private javax.swing.JLabel jTicketDetailsTicket1;
    private javax.swing.JLabel jTicketDetailsTicket2;
    private javax.swing.JLabel jTotalPrice;
    private javax.swing.JTabbedPane jUsePointsStatus;
    private javax.swing.JLabel jWifi;
    // End of variables declaration//GEN-END:variables
}
