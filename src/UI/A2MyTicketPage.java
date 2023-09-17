
package UI;

import Handler.*;
import Class.*;
import DA.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class A2MyTicketPage extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    ResultSet getUserName = null;
    PreparedStatement pst = null;
    
    Customer customer;
    Outlet[] outlets;
    
    ArrayList<Order> orders = new ArrayList<Order>();
    ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
    ArrayList<PurchasedTicket> purchasedTickets = new ArrayList<PurchasedTicket>();
    
    int ticketAmount;
    int jPanel1SizeToContainTicket;
   
    public A2MyTicketPage() {
        initComponents();
        this.setLocationRelativeTo(null);
        con = db.mycon();
        time();
        scaleImage(jWifi,"/pictures/Wifi_Hooray.png");
        scaleImage(jBar,"/pictures/BarMyTickets.png");
    }
    
    public A2MyTicketPage(Customer customer, Outlet[] outlets) {
        
        this();
        
        this.customer = customer;
        this.outlets = outlets;
        
        Handler.displayAllActiveTicket(this.customer, this.outlets, this.orders, this.orderDetails, this.purchasedTickets);
        
        this.ticketAmount = this.purchasedTickets.size();
        this.jPanel1SizeToContainTicket = this.ticketAmount*600;
        
        if(this.jPanel1SizeToContainTicket == 0) {
            displayNoTicket();
        } else {
            displayEachTicket();
        }
    }
    
    public void displayNoTicket() {
        Dimension size = new Dimension(375, 400);
        jPanel1.setPreferredSize(size);
        
        JLabel jLabel1 = new javax.swing.JLabel();
        jLabel1.setBackground(new java.awt.Color(166, 166, 166));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(166, 166, 166));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Purchase one now.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 100, 270, -1));
        
        JLabel jLabel2 = new javax.swing.JLabel();
        jLabel2.setBackground(new java.awt.Color(166, 166, 166));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(166, 166, 166));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("No tickets available at the moment.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 80, 270, -1));
        
        JLabel jBuyTicketsButton = new javax.swing.JLabel();
        jBuyTicketsButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBuyTicketsButton.setText("Buy Tickets");
        jPanel1.add(jBuyTicketsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 120, 37));
        
        ImageIcon icon = new ImageIcon("/pictures/BuyTicketsButton.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(120, 37, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jBuyTicketsButton.setIcon(scaledIcon);
        jBuyTicketsButton.setText("");
    }
    
    //method to display QR per ticket
    public void displayEachTicket() {
        Dimension size = new Dimension(375, this.jPanel1SizeToContainTicket);
        jPanel1.setPreferredSize(size);
        
        for(int i = 0; i < this.ticketAmount; i++) {
            JPanel jPanel2 = new javax.swing.JPanel();
            jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            
            JLabel jOutletName = new javax.swing.JLabel();
            jOutletName.setBackground(new java.awt.Color(183, 218, 222));
            jOutletName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            jOutletName.setText(this.purchasedTickets.get(i).getOrderDetail().getTicketType().getOutlet().getName());
            jPanel2.add(jOutletName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 270, 30));
            
            JLabel jScanInstruction = new javax.swing.JLabel();
            jScanInstruction.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
            jScanInstruction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jScanInstruction.setText("Scan this QR Code or show this ticket at the gate");
            jPanel2.add(jScanInstruction, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 240, -1));
            
            JLabel jDateLabel = new javax.swing.JLabel();
            jDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
            jDateLabel.setForeground(new java.awt.Color(166, 166, 166));
            jDateLabel.setText("Date");
            jPanel2.add(jDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, 20));
            
            JLabel jDownloadTicketLabel = new javax.swing.JLabel();
            jDownloadTicketLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
            jDownloadTicketLabel.setForeground(new java.awt.Color(255, 255, 255));
            jDownloadTicketLabel.setText("Download Ticket");
            jPanel2.add(jDownloadTicketLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 532, -1, -1));
            
            JLabel jTicketID = new javax.swing.JLabel();
            jTicketID.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
            jTicketID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jTicketID.setText(this.purchasedTickets.get(i).getPurchasedTicketID());
            jPanel2.add(jTicketID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 50, 20));
            
            JLabel jExpireDate = new javax.swing.JLabel();
            jExpireDate.setBackground(new java.awt.Color(183, 218, 222));
            jExpireDate.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
            String formattedDate = formatter.format(this.purchasedTickets.get(i).getExpireDate());
            jExpireDate.setText(formattedDate);
            jPanel2.add(jExpireDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 80, 20));
            
            JLabel jTicketIDLabel = new javax.swing.JLabel();
            jTicketIDLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
            jTicketIDLabel.setForeground(new java.awt.Color(166, 166, 166));
            jTicketIDLabel.setText("Ticket ID");
            jPanel2.add(jTicketIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, 20));
            
            JLabel jTicketName = new javax.swing.JLabel();
            jTicketName.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
            jTicketName.setForeground(new java.awt.Color(166, 166, 166));
            jTicketName.setText(this.purchasedTickets.get(i).getOrderDetail().getTicketType().getName());
            jPanel2.add(jTicketName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, -1, 20));
            
            JLabel jUnused = new javax.swing.JLabel();
            jUnused.setBackground(new java.awt.Color(183, 218, 222));
            jUnused.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
            jUnused.setText("Unused");
            jPanel2.add(jUnused, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 60, 20));
            
            JLabel jStatusLabel = new javax.swing.JLabel();
            jStatusLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
            jStatusLabel.setForeground(new java.awt.Color(166, 166, 166));
            jStatusLabel.setText("Status");
            jPanel2.add(jStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, 20));
            
            JLabel jBackgroundEachActiveTicket = new javax.swing.JLabel();
            jBackgroundEachActiveTicket.setText("jLabel1");
            jBackgroundEachActiveTicket.setMaximumSize(new java.awt.Dimension(375, 2147483647));
            jBackgroundEachActiveTicket.setMinimumSize(new java.awt.Dimension(375, 600));
            jBackgroundEachActiveTicket.setPreferredSize(new java.awt.Dimension(375, 600));
            
            jPanel2.add(jBackgroundEachActiveTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
            
            ImageIcon icon = new ImageIcon("/pictures/BackgroundEachActiveTicket.png");
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(375, 600, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScale);
            jBackgroundEachActiveTicket.setIcon(scaledIcon );
            jBackgroundEachActiveTicket.setText("");
            
            jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, i*600, -1, -1));
            
        }
    }
    
    public void setAllLabels() {
//        jOutletName.setText(this.outlets[this.selectedOutletIndicator].getName()); //outlet[0], name of outlet
//        jScanInstruction.setText(this.outlets[this.selectedOutletIndicator].getAddress());
        
        
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
        jLabel4 = new javax.swing.JLabel();
        jBar = new javax.swing.JLabel();
        JWelcome1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

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

        jLabel4.setBackground(new java.awt.Color(0, 0, 0, 100));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jMainPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 690, 50, 50));

        jBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBar.setText("Bar");
        jMainPanel.add(jBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 675, 375, 75));

        JWelcome1.setBackground(new java.awt.Color(183, 218, 222));
        JWelcome1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        JWelcome1.setText("Ticket Details");
        jMainPanel.add(JWelcome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, 30));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(254, 253, 244));
        jPanel1.setMaximumSize(new java.awt.Dimension(375, 2147483647));
        jPanel1.setMinimumSize(new java.awt.Dimension(375, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(375, 600));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(jPanel1);

        jMainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 90, 400, 590));

        getContentPane().add(jMainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Handler.backToHomePage(this.customer, this.outlets, this);
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(A2MyTicketPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A2MyTicketPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A2MyTicketPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A2MyTicketPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new A2MyTicketPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JWelcome1;
    private javax.swing.JLabel jBar;
    private javax.swing.JLabel jClock;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jMainPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jWifi;
    // End of variables declaration//GEN-END:variables
}
