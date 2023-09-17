
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

public class A3TicketDetails extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    ResultSet getUserName = null;
    PreparedStatement pst = null;
    
    Customer customer;
    Outlet[] outlets;
    int selectedOutletIndicator;
   
    public A3TicketDetails() {
        initComponents();
        this.setLocationRelativeTo(null);
        con = db.mycon();
        time();
        scaleImage(jWifi,"/pictures/Wifi_Hooray.png");
        scaleImage(jBar, "/pictures/BarHomeTicketDetails.png");
        scaleImage(jOutletReviews,"/pictures/OutletReviews.png");
        scaleImage(jTicketDetailsTicket1,"/pictures/TicketDetailsTicket.png");
        scaleImage(jTicketDetailsTicket2,"/pictures/TicketDetailsTicket.png");
        scaleImage(jComments,"/pictures/Comments.png");
        scaleImage(jComments1,"/pictures/Comments.png");
        scaleImage(jBackButton,"/pictures/BackButton.png");
        scaleImage(jBuyButton,"/pictures/BuyNowButton.png");
        scaleImage(jLocationLogo,"/pictures/LocationLogo.png");

    }
    
    public A3TicketDetails(Customer customer, Outlet[] outlets, int selectedOutletIndicator) {
        
        this();
        
        this.customer = customer;
        this.outlets = outlets;
        this.selectedOutletIndicator = selectedOutletIndicator;
        
        setAllLabels();
    }
    
    public void setAllLabels() {
        jOutletName.setText(this.outlets[this.selectedOutletIndicator].getName()); //outlet[0], name of outlet
        jOutletAddress.setText(this.outlets[this.selectedOutletIndicator].getAddress());
        
        jPriceTicketWithoutRp.setText(this.outlets[this.selectedOutletIndicator].getTicketTypes().get(0).getPricePerTicketWithoutRupiah());
        
        jOverallRatings.setText(String.valueOf(this.outlets[this.selectedOutletIndicator].getOverallRatings()));
        
        //Child ticket labels
        jChildTicketName.setText(this.outlets[this.selectedOutletIndicator].getTicketTypes().get(0).getName());
        jChildTicketPrice.setText(this.outlets[this.selectedOutletIndicator].getTicketTypes().get(0).getPricePerTicketInRupiah());
        jChildTicketGiftPoints.setText(String.valueOf(this.outlets[this.selectedOutletIndicator].getTicketTypes().get(0).getGiftPoint()) + " Points");
        
        //Guardian ticket labels
        jGuardianTicketName.setText(this.outlets[this.selectedOutletIndicator].getTicketTypes().get(1).getName());
        jGuardianTicketPrice.setText(this.outlets[this.selectedOutletIndicator].getTicketTypes().get(1).getPricePerTicketInRupiah());
        jGuardianTicketGiftPoints.setText(String.valueOf(this.outlets[this.selectedOutletIndicator].getTicketTypes().get(1).getGiftPoint()) + " Points");
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

        jMainPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jClock = new javax.swing.JLabel();
        jWifi = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBar = new javax.swing.JLabel();
        jBuyButton = new javax.swing.JLabel();
        JWelcome1 = new javax.swing.JLabel();
        jBackButton = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        JWelcome = new javax.swing.JLabel();
        jOutletName = new javax.swing.JLabel();
        jPriceTicketWithoutRp = new javax.swing.JLabel();
        JMobileApp1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jOutletAddress = new javax.swing.JLabel();
        jChildTicketGiftPoints = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jChildTicketPrice = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jChildTicketName = new javax.swing.JLabel();
        jTicketDetailsTicket1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jOverallRatings = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jOutletReviews = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jGuardianTicketName = new javax.swing.JLabel();
        jGuardianTicketPrice = new javax.swing.JLabel();
        jGuardianTicketGiftPoints = new javax.swing.JLabel();
        jTicketDetailsTicket2 = new javax.swing.JLabel();
        JMobileApp4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jComments = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jComments1 = new javax.swing.JLabel();
        jLocationLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setMinimumSize(new java.awt.Dimension(375, 750));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMainPanel.setBackground(new java.awt.Color(254, 253, 244));
        jMainPanel.setPreferredSize(new java.awt.Dimension(375, 750));
        jMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(254, 253, 244));
        jPanel4.setPreferredSize(new java.awt.Dimension(375, 40));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jClock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jClock.setText("hh:mm");
        jPanel4.add(jClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jWifi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jWifi.setText("icon (wifi, etc)");
        jWifi.setPreferredSize(new java.awt.Dimension(67, 12));
        jPanel4.add(jWifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 14, 70, 16));

        jMainPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 375, 40));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0, 100));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jMainPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 690, 50, 50));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0, 100));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jMainPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 690, 50, 50));

        jBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBar.setText("Bar");
        jMainPanel.add(jBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 675, 375, 75));

        jBuyButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBuyButton.setText("Buy now");
        jBuyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBuyButtonMouseClicked(evt);
            }
        });
        jMainPanel.add(jBuyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 375, 100));

        JWelcome1.setBackground(new java.awt.Color(183, 218, 222));
        JWelcome1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        JWelcome1.setText("Ticket Details");
        jMainPanel.add(JWelcome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, 30));

        jBackButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBackButton.setText("<");
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });
        jMainPanel.add(jBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 50, 31, 30));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(375, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JWelcome.setBackground(new java.awt.Color(183, 218, 222));
        JWelcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JWelcome.setText("HOORAY");
        jPanel1.add(JWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jOutletName.setBackground(new java.awt.Color(183, 218, 222));
        jOutletName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jOutletName.setText("Outlet Name");
        jPanel1.add(jOutletName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 300, 30));

        jPriceTicketWithoutRp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPriceTicketWithoutRp.setForeground(new java.awt.Color(220, 172, 0));
        jPriceTicketWithoutRp.setText("000.000");
        jPanel1.add(jPriceTicketWithoutRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 110, 20));

        JMobileApp1.setBackground(new java.awt.Color(183, 218, 222));
        JMobileApp1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        JMobileApp1.setText("Comments");
        jPanel1.add(JMobileApp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 100, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 172, 0));
        jLabel3.setText("Rp");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 20, 20));

        jOutletAddress.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jOutletAddress.setForeground(new java.awt.Color(166, 166, 166));
        jOutletAddress.setText("Ticket address Ticket address Ticket address Ticket address ");
        jPanel1.add(jOutletAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 85, 280, -1));

        jChildTicketGiftPoints.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jChildTicketGiftPoints.setText("000 Points");
        jPanel1.add(jChildTicketGiftPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 310, 50, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(129, 126, 135));
        jLabel7.setText("Gunakan dalam 7 hari sejak tanggal pilihan");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 343, -1, -1));

        jChildTicketPrice.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jChildTicketPrice.setForeground(new java.awt.Color(165, 200, 205));
        jChildTicketPrice.setText("Rp 000.000");
        jPanel1.add(jChildTicketPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(129, 126, 135));
        jLabel21.setText("Ticket perlu reservasi");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 330, -1, 10));

        jChildTicketName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jChildTicketName.setText("Ticket Name");
        jPanel1.add(jChildTicketName, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 290, -1, -1));

        jTicketDetailsTicket1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jTicketDetailsTicket1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 322, 120));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel22.setText("Reviews");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 145, -1, -1));

        jOverallRatings.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jOverallRatings.setText("0.0");
        jPanel1.add(jOverallRatings, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 177, -1, 20));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("/10");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 177, -1, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setText("Reviews");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 183, 40, 10));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel25.setText("|");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 182, -1, 10));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel26.setText("100");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 183, 20, 10));

        jOutletReviews.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jOutletReviews, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 130, 325, 90));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(129, 126, 135));
        jLabel27.setText("Gunakan dalam 7 hari sejak tanggal pilihan");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 453, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(129, 126, 135));
        jLabel28.setText("Ticket perlu reservasi");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 440, -1, 10));

        jGuardianTicketName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jGuardianTicketName.setText("Ticket Name");
        jPanel1.add(jGuardianTicketName, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 400, -1, -1));

        jGuardianTicketPrice.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jGuardianTicketPrice.setForeground(new java.awt.Color(165, 200, 205));
        jGuardianTicketPrice.setText("Rp 000.000");
        jPanel1.add(jGuardianTicketPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        jGuardianTicketGiftPoints.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jGuardianTicketGiftPoints.setText("000 Points");
        jPanel1.add(jGuardianTicketGiftPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 420, 50, 20));

        jTicketDetailsTicket2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jTicketDetailsTicket2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 322, 120));

        JMobileApp4.setBackground(new java.awt.Color(183, 218, 222));
        JMobileApp4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        JMobileApp4.setText("Ticket");
        jPanel1.add(JMobileApp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 235, 60, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(165, 200, 205));
        jLabel8.setText("See more");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Kaori Harris");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, -1, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(185, 185, 185));
        jLabel32.setText("- Tue, 17 Nov 2022");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 582, -1, -1));

        jLabel33.setText("Mainannya bagus,anak saya senang");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 595, -1, -1));
        jPanel1.add(jComments, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 548, 317, 98));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(185, 185, 185));
        jLabel34.setText("- Tue, 17 Nov 2022");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 682, -1, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setText("Kaori Harris");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 680, -1, -1));

        jLabel36.setText("Mainannya bagus,anak saya senang");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 695, -1, -1));
        jPanel1.add(jComments1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 647, 317, 98));

        jLocationLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLocationLogo.setText("...");
        jPanel1.add(jLocationLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 86, 10, 13));

        jScrollPane1.setViewportView(jPanel1);

        jMainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 90, 400, 520));

        getContentPane().add(jMainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        Handler.backToHomePage(this.customer, this.outlets, this);
    }//GEN-LAST:event_jBackButtonMouseClicked

    private void jBuyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBuyButtonMouseClicked
        Handler.openOrderSummary(this.customer, this.outlets, this.selectedOutletIndicator, this);
    }//GEN-LAST:event_jBuyButtonMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Handler.backToHomePage(this.customer, this.outlets, this);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Handler.openMyTicketPage(this.customer, this.outlets, this);
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(A3TicketDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A3TicketDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A3TicketDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A3TicketDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A3TicketDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JMobileApp1;
    private javax.swing.JLabel JMobileApp4;
    private javax.swing.JLabel JWelcome;
    private javax.swing.JLabel JWelcome1;
    private javax.swing.JLabel jBackButton;
    private javax.swing.JLabel jBar;
    private javax.swing.JLabel jBuyButton;
    private javax.swing.JLabel jChildTicketGiftPoints;
    private javax.swing.JLabel jChildTicketName;
    private javax.swing.JLabel jChildTicketPrice;
    private javax.swing.JLabel jClock;
    private javax.swing.JLabel jComments;
    private javax.swing.JLabel jComments1;
    private javax.swing.JLabel jGuardianTicketGiftPoints;
    private javax.swing.JLabel jGuardianTicketName;
    private javax.swing.JLabel jGuardianTicketPrice;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLocationLogo;
    private javax.swing.JPanel jMainPanel;
    private javax.swing.JLabel jOutletAddress;
    private javax.swing.JLabel jOutletName;
    private javax.swing.JLabel jOutletReviews;
    private javax.swing.JLabel jOverallRatings;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jPriceTicketWithoutRp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTicketDetailsTicket1;
    private javax.swing.JLabel jTicketDetailsTicket2;
    private javax.swing.JLabel jWifi;
    // End of variables declaration//GEN-END:variables
}
