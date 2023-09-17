
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
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class A6BCAPayment extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    ResultSet getUserName = null;
    PreparedStatement pst = null;
    
    Customer customer;
    Outlet[] outlets;
    int selectedOutletIndicator;
    
    Payment payment;
   
    public A6BCAPayment() {
        initComponents();
        this.setLocationRelativeTo(null);
        con = db.mycon();
        time();
        scaleImage(jWifi,"/pictures/Wifi_Hooray.png");
        scaleImage(jSplashBox,"/pictures/SplashBox_Hooray.png");
        scaleImage(jSplashBox1,"/pictures/SplashBox_Hooray.png");
        scaleImage(jSplashBox2,"/pictures/SmallSplashBox.png");

        
        scaleImage(jBackButton,"/pictures/BackButton.png");
        
        scaleImage(jPaymentTicket,"/pictures/PaymentTicket.png");
        
        scaleImage(jWaitingPaymentStatus,"/pictures/WaitingPaymentStatus.png");

        scaleImage(jCloudDark,"/pictures/CloudDark.png");
        
        scaleImage(jBarBCASelected,"/pictures/BarBCASelected.png");
        scaleImage(jCheckedCircleBCA,"/pictures/CheckedCircle.png");

        // Countdown Timer
        jTimer.setText("01:00");
        second = 0;
        minute = 1;
        countdownTimer();
        timer.start();
        
        scaleImage(jCompletedPaymentBox,"/pictures/CompletedPaymentBox.png");
        scaleImage(jCompleted,"/pictures/Completed.png");

        jPanel4.setVisible(false);
        
        scaleImage(jCompletedPaymentBox1,"/pictures/CompletedPaymentBox.png");
        scaleImage(jCanceled,"/pictures/Canceled.png");

        jPanel5.setVisible(false);
        
        scaleImage(jCancelNotificationBox,"/pictures/CompletedPaymentBox.png");
        scaleImage(jCancelButton,"/pictures/CancelButton.png");
        scaleImage(jXButton,"/pictures/XButton.png");

        jPanel8.setVisible(false);
    }
    
    public A6BCAPayment(Customer customer, Outlet[] outlets, int selectedOutletIndicator, Payment payment) {
        
        this();
        
        this.customer = customer;
        this.outlets = outlets;
        this.selectedOutletIndicator = selectedOutletIndicator;
        this.payment = payment;
        
        setAllLabels();
    }
    
    public void setAllLabels() {
        jOutletName.setText(this.outlets[this.selectedOutletIndicator].getName());
        
        //Child ticket labels
        jChildTicketName.setText(this.outlets[this.selectedOutletIndicator].getTicketTypes().get(0).getName());
        
        //Guardian ticket labels
        jGuardianTicketName.setText(this.outlets[this.selectedOutletIndicator].getTicketTypes().get(1).getName());
        
        //if customer buy both ticket (child and guardian) - detected buy number of orderDetails
        if(this.payment.getOrder().getOrderDetails().size()==2) {
            
            jChildTicketQty.setText(String.valueOf(this.payment.getOrder().getOrderDetails().get(0).getQuantity()));
            jGuardianTicketQty.setText(String.valueOf(this.payment.getOrder().getOrderDetails().get(1).getQuantity()));
            
        } else { //if customer only buy one type of ticket (child/guardian)
            //if customer buy child ticket only, child ticketTypeID is only "1" or "3"
            if(this.payment.getOrder().getOrderDetails().get(0).getTicketTypeID().equals("1") || 
               this.payment.getOrder().getOrderDetails().get(0).getTicketTypeID().equals("3")   ) {
                jChildTicketQty.setText(String.valueOf(this.payment.getOrder().getOrderDetails().get(0).getQuantity()));
                jGuardianTicketQty.setText("0");
            } else { //if customer buy guardian ticket only
                jChildTicketQty.setText("0");
                jGuardianTicketQty.setText(String.valueOf(this.payment.getOrder().getOrderDetails().get(0).getQuantity()));
            }
            
        }
        
        jVirtualAcc.setText(this.payment.getVirtualAcc());
    }
    
    Timer timer;	
    int second, minute;
    String ddSecond, ddMinute;	
    DecimalFormat dFormat = new DecimalFormat("00");
    int secondCompletedPayment = 3;
    
    public void countdownTimer() {
        
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //if customer have paid, this method will be executed
                if(validatePayment()) {
                    timer.stop();
                    jPanel4.setVisible(true); //set shadow background and notification of payment successful visible
                    
                    timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				secondCompletedPayment--;
				if(secondCompletedPayment==0) {
					timer.stop();
                                        openMyTicketPageIfPaymentCompleted();
				}
			}
                    });
                    
                    timer.start();
                }
                
                second--;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);	
                jTimer.setText(ddMinute + ":" + ddSecond);

                if(second==-1) {
                        second = 59;
                        minute--;
                        ddSecond = dFormat.format(second);
                        ddMinute = dFormat.format(minute);	
                        jTimer.setText(ddMinute + ":" + ddSecond);
                }
                if(minute==0 && second==0) {
                        timer.stop();
                        jPanel5.setVisible(true);
                        
                        timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                            secondCompletedPayment--;
                            if(secondCompletedPayment==0) {
                                paymentCancelation();
                                timer.stop();
                            }
			}
                    });
                    
                    timer.start();
                }
            }
        });		
    }
    
    public boolean validatePayment() {
        return Handler.validatePayment(this.customer, this.payment);
        
//        double bill = DA.DA_VirtualAccount.getVirtualAccountBill(this.payment.getVirtualAcc());
//        
//        if(bill == 0) {
//            DA.DA_Payment.setPaymentStatus(this.payment.getPaymentID(), "paid");
//            
//            DA.DA_Order.setOrderStatus(this.payment.getOrderID(), "paid");
//            
//            //if customer use points, then make points 0 in database
//            if(this.payment.getOrder().getUsePointsStatus().equals("use")) {
//                DA.DA_Customer.setPoints(this.customer.getCustomerID(), "0");
//                this.customer.setPoints(0);
//            }
//            
//            //loop to know how much points the customer should get
//            int totalGiftPoint = 0;
//            for(int orderDetailIndex = 0; orderDetailIndex < this.payment.getOrder().getOrderDetails().size(); orderDetailIndex++) {
//                totalGiftPoint += this.payment.getOrder().getOrderDetails().get(orderDetailIndex).getQuantity()*
//                                  this.payment.getOrder().getOrderDetails().get(orderDetailIndex).getTicketType().getGiftPoint();
//            }
//            
//            //this is updated points of customer which should be updated in database
//            int customerUpdatedPoints = this.customer.getPoints() + totalGiftPoint;
//            DA.DA_Customer.setPoints(this.customer.getCustomerID(), String.valueOf(customerUpdatedPoints));
//            this.customer.setPoints(customerUpdatedPoints);
//            
//            //insert new purchasedTicket to database based on how many orderDetails in order, and how many quantity per orderDetail
//            int orderDetailsAmount = this.payment.getOrder().getOrderDetails().size(); //how many orderDetails in order
//            for(int i = 0; i < orderDetailsAmount; i++) {
//                int ticketQuantity = this.payment.getOrder().getOrderDetails().get(i).getQuantity(); //how many quantity of ticket should be inserted
//                for(int j = 0; j < ticketQuantity; j++) {
//                    DA.DA_PurchasedTicket.insertNewPurchasedTicket(this.payment.getOrder().getOrderDetails().get(i).getOrderDetailID());
//                }
//            }
//            
//            return true;
//            
//        }
//        return false;
//                
    }
    
    public void paymentCancelation() {
        Handler.paymentCanceled(payment.getOrder(), this, this.customer, this.outlets, this.selectedOutletIndicator, this.payment);
    }
    
    public void openMyTicketPageIfPaymentCompleted() {
        Handler.openMyTicketPage(this.customer, this.outlets, this);
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

        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCompleted = new javax.swing.JLabel();
        jCompletedPaymentBox = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jCanceled = new javax.swing.JLabel();
        jCompletedPaymentBox1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jXButton = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
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
        jOutletName = new javax.swing.JLabel();
        jChildTicketName = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPaymentTicket = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jGuardianTicketQty = new javax.swing.JLabel();
        jGuardianTicketName = new javax.swing.JLabel();
        jSplashBox = new javax.swing.JLabel();
        jWaitingPaymentStatus = new javax.swing.JLabel();
        jSplashBox1 = new javax.swing.JLabel();
        JWelcome1 = new javax.swing.JLabel();
        jVirtualAcc = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSplashBox2 = new javax.swing.JLabel();
        jCheckedCircleBCA = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jBarBCASelected = new javax.swing.JLabel();
        jCloudDark = new javax.swing.JLabel();
        jTimer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 0, 135));
        jPanel4.setPreferredSize(new java.awt.Dimension(375, 750));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(166, 166, 166));
        jLabel6.setText("Payment Complete");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 280, 160, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(166, 166, 166));
        jLabel9.setText("Hooray!");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 70, 30));

        jCompleted.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCompleted.setText("Completed");
        jPanel4.add(jCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 320, 150, 150));

        jCompletedPaymentBox.setText("jLabel1");
        jCompletedPaymentBox.setPreferredSize(new java.awt.Dimension(300, 245));
        jPanel4.add(jCompletedPaymentBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 215, -1, 300));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0, 135));
        jPanel5.setPreferredSize(new java.awt.Dimension(375, 750));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(166, 166, 166));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("We can’t verify your payment.");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 250, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(166, 166, 166));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Your order is canceled.");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 210, 30));

        jCanceled.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCanceled.setText("Completed");
        jPanel5.add(jCanceled, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 320, 150, 150));

        jCompletedPaymentBox1.setText("jLabel1");
        jCompletedPaymentBox1.setPreferredSize(new java.awt.Dimension(300, 245));
        jPanel5.add(jCompletedPaymentBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 215, -1, 300));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(166, 166, 166));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("cancel your order?");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 160, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(166, 166, 166));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Are you sure you want to");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 230, 30));

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
        jChildTicketQty.setText("2");
        jPanel1.add(jChildTicketQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 20, -1));

        jOutletName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jOutletName.setText("Hooray Paris Van Java");
        jPanel1.add(jOutletName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 175, -1, -1));

        jChildTicketName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jChildTicketName.setForeground(new java.awt.Color(166, 166, 166));
        jChildTicketName.setText("Ticket Name");
        jPanel1.add(jChildTicketName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 202, 150, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(166, 166, 166));
        jLabel20.setText("Qty :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        jPaymentTicket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPaymentTicket.setText("Ticket");
        jPaymentTicket.setPreferredSize(new java.awt.Dimension(75, 75));
        jPanel1.add(jPaymentTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 75));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(166, 166, 166));
        jLabel21.setText("Status :");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 272, -1, 20));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(166, 166, 166));
        jLabel22.setText("Qty :");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 225, -1, -1));

        jGuardianTicketQty.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jGuardianTicketQty.setForeground(new java.awt.Color(166, 166, 166));
        jGuardianTicketQty.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jGuardianTicketQty.setText("2");
        jPanel1.add(jGuardianTicketQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 225, 20, -1));

        jGuardianTicketName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jGuardianTicketName.setForeground(new java.awt.Color(166, 166, 166));
        jGuardianTicketName.setText("Ticket Name");
        jPanel1.add(jGuardianTicketName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 225, 140, -1));

        jSplashBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jSplashBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(-16, 160, 410, 105));

        jWaitingPaymentStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jWaitingPaymentStatus.setText("Waiting for Payment");
        jPanel1.add(jWaitingPaymentStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 271, 150, 25));

        jSplashBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jSplashBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-16, 200, 410, 105));

        JWelcome1.setBackground(new java.awt.Color(183, 218, 222));
        JWelcome1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JWelcome1.setText("Virtual Account");
        jPanel1.add(JWelcome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jVirtualAcc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jVirtualAcc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jVirtualAcc.setText("123123000000");
        jPanel1.add(jVirtualAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 352, 200, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(166, 166, 166));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Copy Number");
        jLabel5.setPreferredSize(new java.awt.Dimension(94, 25));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 352, -1, -1));

        jSplashBox2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jSplashBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 375, 50));

        jCheckedCircleBCA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckedCircleBCA.setText("O");
        jCheckedCircleBCA.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel1.add(jCheckedCircleBCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 20, -1));

        jLabel15.setBackground(new java.awt.Color(184, 189, 194));
        jLabel15.setForeground(new java.awt.Color(184, 189, 194));
        jLabel15.setText("1. Choose m-Transfer > BCA Virtual Account");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jLabel7.setBackground(new java.awt.Color(184, 189, 194));
        jLabel7.setForeground(new java.awt.Color(184, 189, 194));
        jLabel7.setText("2. Enter Virtual Account number XXXXXXXXXXX and ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        jLabel8.setBackground(new java.awt.Color(184, 189, 194));
        jLabel8.setForeground(new java.awt.Color(184, 189, 194));
        jLabel8.setText("choose Send");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 495, -1, -1));

        jLabel14.setBackground(new java.awt.Color(184, 189, 194));
        jLabel14.setForeground(new java.awt.Color(184, 189, 194));
        jLabel14.setText("3. Enter m-BCA pin and click OK");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 515, -1, -1));

        jBarBCASelected.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jBarBCASelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 375, 165));

        jCloudDark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCloudDark.setText("Cloud");
        jPanel1.add(jCloudDark, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 375, 180));

        jTimer.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jTimer.setForeground(new java.awt.Color(183, 218, 222));
        jTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTimer.setText("MM:SS");
        jPanel1.add(jTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 102, 140, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        jPanel8.setVisible(true);
    }//GEN-LAST:event_jBackButtonMouseClicked

    private void jXButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXButtonMouseClicked
        jPanel8.setVisible(false);
    }//GEN-LAST:event_jXButtonMouseClicked

    private void jCancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelButtonMouseClicked
        paymentCancelation();
    }//GEN-LAST:event_jCancelButtonMouseClicked

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
            java.util.logging.Logger.getLogger(A6BCAPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A6BCAPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A6BCAPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A6BCAPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A6BCAPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JWelcome;
    private javax.swing.JLabel JWelcome1;
    private javax.swing.JLabel jBackButton;
    private javax.swing.JLabel jBarBCASelected;
    private javax.swing.JLabel jCancelButton;
    private javax.swing.JLabel jCancelNotificationBox;
    private javax.swing.JLabel jCanceled;
    private javax.swing.JLabel jCheckedCircleBCA;
    private javax.swing.JLabel jChildTicketName;
    private javax.swing.JLabel jChildTicketQty;
    private javax.swing.JLabel jClock;
    private javax.swing.JLabel jCloudDark;
    private javax.swing.JLabel jCompleted;
    private javax.swing.JLabel jCompletedPaymentBox;
    private javax.swing.JLabel jCompletedPaymentBox1;
    private javax.swing.JLabel jGuardianTicketName;
    private javax.swing.JLabel jGuardianTicketQty;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jOutletName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel jPaymentTicket;
    private javax.swing.JLabel jSplashBox;
    private javax.swing.JLabel jSplashBox1;
    private javax.swing.JLabel jSplashBox2;
    private javax.swing.JLabel jTimer;
    private javax.swing.JLabel jVirtualAcc;
    private javax.swing.JLabel jWaitingPaymentStatus;
    private javax.swing.JLabel jWifi;
    private javax.swing.JLabel jXButton;
    // End of variables declaration//GEN-END:variables
}
