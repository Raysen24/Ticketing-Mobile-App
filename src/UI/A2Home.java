
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

public class A2Home extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    ResultSet getUserName = null;
    PreparedStatement pst = null;
    
    Customer customer;
    Outlet[] outlets;
   
    public A2Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        con = db.mycon();
        time();
        scaleImage(jLogo,"/pictures/Logo_Hooray.png");
        scaleImage(jWifi,"/pictures/Wifi_Hooray.png");
        scaleImage(jBar,"/pictures/BarHome.png");
        scaleImage(jSearchBar,"/pictures/SearchBar.png");
        scaleImage(jOutlet1,"/pictures/Outlet1.png");
        scaleImage(jOutlet2,"/pictures/Outlet1.png");
        scaleImage(jTicketType1,"/pictures/TicketType.png");
        scaleImage(jTicketType2,"/pictures/TicketType.png");
        scaleImage(jCloudDark,"/pictures/CloudDark.png");
        
        
    }
    
    public A2Home(Customer customer, Outlet[] outlets) {
        
        this();
        
        this.customer = customer;
        this.outlets = outlets;
        
        setAllLabels();
    }
    
    public void setAllLabels() {
        //Labels for outlet
        JLabel[][] outletLabels = {{jOutletName1,jOutletAddress1},
                                   {jOutletName2, jOutletAddress2}};
        //Loop to set the outlet label with name and address 
        for(int i = 0; i < outlets.length; i++) {
            outletLabels[i][0].setText(outlets[i].getNameWithHOORAY());
            outletLabels[i][1].setText(outlets[i].getAddress());
        }
        
        //Labels for ticket
        JLabel[][] ticketLabels = {{jTicketOutlet1, jTicketPrice1, jTicketGiftPoints1},
                                   {jTicketOutlet2, jTicketPrice2, jTicketGiftPoints2}};
        //Loop to set the ticket label with price and gift points
        for(int i = 0; i < outlets.length; i++) {
            ticketLabels[i][0].setText(this.outlets[i].getName());
            ticketLabels[i][1].setText(String.valueOf(this.outlets[i].getTicketTypes().get(0).getPricePerTicketInRupiah()));
            ticketLabels[i][2].setText(String.valueOf(this.outlets[i].getTicketTypes().get(0).getGiftPoint()) + " Points");
        }
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
    
    public void scaleImage(JLabel address, String imgURL) {
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
        jLogo = new javax.swing.JLabel();
        jMyTicketButton = new javax.swing.JLabel();
        jBar = new javax.swing.JLabel();
        JWelcome = new javax.swing.JLabel();
        JMobileApp = new javax.swing.JLabel();
        jSearchBar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JMobileApp1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTicketOutlet1 = new javax.swing.JLabel();
        jTicketPrice1 = new javax.swing.JLabel();
        jTicketGiftPoints1 = new javax.swing.JLabel();
        jTicketType1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTicketOutlet2 = new javax.swing.JLabel();
        jTicketPrice2 = new javax.swing.JLabel();
        jTicketGiftPoints2 = new javax.swing.JLabel();
        jTicketType2 = new javax.swing.JLabel();
        jCloudDark = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jOutletAddress1 = new javax.swing.JLabel();
        jOutletName1 = new javax.swing.JLabel();
        jOutlet1 = new javax.swing.JLabel();
        jOutletName2 = new javax.swing.JLabel();
        jOutletAddress2 = new javax.swing.JLabel();
        jOutlet2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(254, 253, 244));
        jPanel1.setPreferredSize(new java.awt.Dimension(375, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(254, 253, 244));
        jPanel2.setPreferredSize(new java.awt.Dimension(375, 40));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jClock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jClock.setText("hh:mm");
        jPanel2.add(jClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jWifi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jWifi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Wifi_Hooray.png"))); // NOI18N
        jWifi.setText("icon (wifi, etc)");
        jWifi.setPreferredSize(new java.awt.Dimension(67, 12));
        jPanel2.add(jWifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 14, 70, 16));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 375, 40));

        jLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLogo.setText("Logo");
        jLogo.setPreferredSize(new java.awt.Dimension(250, 250));
        jPanel1.add(jLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 50, 80, 35));

        jMyTicketButton.setBackground(new java.awt.Color(0, 0, 0, 100));
        jMyTicketButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMyTicketButtonMouseClicked(evt);
            }
        });
        jPanel1.add(jMyTicketButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 690, 50, 50));

        jBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBar.setText("Bar");
        jPanel1.add(jBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 675, 375, 75));

        JWelcome.setBackground(new java.awt.Color(183, 218, 222));
        JWelcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JWelcome.setText("Home");
        jPanel1.add(JWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 50, -1, -1));

        JMobileApp.setBackground(new java.awt.Color(183, 218, 222));
        JMobileApp.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        JMobileApp.setText("Buy Tickets");
        jPanel1.add(JMobileApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 400, 110, 30));

        jSearchBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jSearchBar.setText("Search Bar");
        jPanel1.add(jSearchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 90, 320, 45));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(164, 199, 204));
        jLabel2.setText("See more");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 408, 70, 20));

        JMobileApp1.setBackground(new java.awt.Color(183, 218, 222));
        JMobileApp1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        JMobileApp1.setText("Our Outlets");
        jPanel1.add(JMobileApp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 140, 110, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(164, 199, 204));
        jLabel3.setText("See more");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 70, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(129, 126, 135));
        jLabel1.setText("Ticket");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 450, -1, -1));

        jTicketOutlet1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jTicketOutlet1.setText("Hooray Paris Van Java");
        jPanel1.add(jTicketOutlet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 464, -1, -1));

        jTicketPrice1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTicketPrice1.setForeground(new java.awt.Color(88, 159, 167));
        jTicketPrice1.setText("Rp 150.000");
        jPanel1.add(jTicketPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 480, -1, -1));

        jTicketGiftPoints1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTicketGiftPoints1.setText("100 Points");
        jPanel1.add(jTicketGiftPoints1, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 500, -1, -1));

        jTicketType1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTicketType1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTicketType1MouseClicked(evt);
            }
        });
        jPanel1.add(jTicketType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 315, 85));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(129, 126, 135));
        jLabel7.setText("Ticket");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 540, -1, -1));

        jTicketOutlet2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jTicketOutlet2.setText("Hooray Paris Van Java");
        jPanel1.add(jTicketOutlet2, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 554, -1, -1));

        jTicketPrice2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTicketPrice2.setForeground(new java.awt.Color(88, 159, 167));
        jTicketPrice2.setText("Rp 150.000");
        jPanel1.add(jTicketPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 570, -1, -1));

        jTicketGiftPoints2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTicketGiftPoints2.setText("100 Points");
        jPanel1.add(jTicketGiftPoints2, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 590, -1, -1));

        jTicketType2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTicketType2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTicketType2MouseClicked(evt);
            }
        });
        jPanel1.add(jTicketType2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 315, 85));

        jCloudDark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCloudDark.setText("Cloud");
        jPanel1.add(jCloudDark, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 375, 180));

        jScrollPane1.setBackground(new java.awt.Color(254, 253, 244));
        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(254, 253, 244));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jOutletAddress1.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jOutletAddress1.setForeground(new java.awt.Color(141, 149, 157));
        jOutletAddress1.setText("Paris Van Java, Jl. Sukajadi No.13, ..");
        jPanel3.add(jOutletAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 176, -1, -1));

        jOutletName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jOutletName1.setText("Hooray Paris Van Java");
        jOutletName1.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel3.add(jOutletName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, 200, -1));

        jOutlet1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jOutlet1.setText("Outlet");
        jPanel3.add(jOutlet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 210));

        jOutletName2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jOutletName2.setText("Hooray Paris Van Java");
        jOutletName2.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel3.add(jOutletName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 155, -1, -1));

        jOutletAddress2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jOutletAddress2.setForeground(new java.awt.Color(141, 149, 157));
        jOutletAddress2.setText("Paris Van Java, Jl. Sukajadi No.13, ..");
        jPanel3.add(jOutletAddress2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 176, -1, -1));

        jOutlet2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jOutlet2.setText("Outlet");
        jPanel3.add(jOutlet2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 300, 210));

        jScrollPane1.setViewportView(jPanel3);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 330, 590));

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

    private void jTicketType1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTicketType1MouseClicked
        Handler.openTicketDetailsPage(this.customer, this.outlets,  0, this);
    }//GEN-LAST:event_jTicketType1MouseClicked

    private void jTicketType2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTicketType2MouseClicked
        Handler.openTicketDetailsPage(this.customer, this.outlets,  1, this);
    }//GEN-LAST:event_jTicketType2MouseClicked

    private void jMyTicketButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMyTicketButtonMouseClicked
        Handler.openMyTicketPage(customer, outlets, this);
    }//GEN-LAST:event_jMyTicketButtonMouseClicked

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
            java.util.logging.Logger.getLogger(A2Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A2Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A2Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A2Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A2Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JMobileApp;
    private javax.swing.JLabel JMobileApp1;
    private javax.swing.JLabel JWelcome;
    private javax.swing.JLabel jBar;
    private javax.swing.JLabel jClock;
    private javax.swing.JLabel jCloudDark;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLogo;
    private javax.swing.JLabel jMyTicketButton;
    private javax.swing.JLabel jOutlet1;
    private javax.swing.JLabel jOutlet2;
    private javax.swing.JLabel jOutletAddress1;
    private javax.swing.JLabel jOutletAddress2;
    private javax.swing.JLabel jOutletName1;
    private javax.swing.JLabel jOutletName2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jSearchBar;
    private javax.swing.JLabel jTicketGiftPoints1;
    private javax.swing.JLabel jTicketGiftPoints2;
    private javax.swing.JLabel jTicketOutlet1;
    private javax.swing.JLabel jTicketOutlet2;
    private javax.swing.JLabel jTicketPrice1;
    private javax.swing.JLabel jTicketPrice2;
    private javax.swing.JLabel jTicketType1;
    private javax.swing.JLabel jTicketType2;
    private javax.swing.JLabel jWifi;
    // End of variables declaration//GEN-END:variables
}
