
package UI;

import DA.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OA2BCATransfer extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String email;
    
    String virtualAcc;
    double bill;
    
    public OA2BCATransfer() {
        initComponents();
        this.setLocation(965, 18);
        time();
        con = db.mycon();
        scaleImage(jIcon,"/picturesBCA/Screenshot_20230103_031419.png");
        scaleImage(jLogo, "/picturesBCA/Screenshot_20230103_080537.png");
        scaleImage(jBackButton, "/picturesBCA/Screenshot_20230104_053736.png");
        
        jPanel9.setVisible(false);
        jPanel8.setVisible(false);
    }

    OA2BCATransfer(int userID) {
        
        this();
        
        //email = em;
//        showingTransaction(userID);
    }
    
//    public void showingTransaction(int userID){
//        String sql = "SELECT * FROM transactionhistory WHERE userID = " + userID +";";
//        try{
//            PreparedStatement pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
//            model.setRowCount(0);
//            while(rs.next()){
//                model.addRow(new String[]{rs.getString("transactionDate"), rs.getString("e-moneyType"), rs.getString("amount"), rs.getString("transactionInfo")});
//            }
//      
//        } catch(Exception e) {
//            
//        }
//    }
    
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
        ImageIcon icon = new ImageIcon(imgURL);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(address.getWidth(), address.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        address.setIcon(scaledIcon );
        address.setText("");
    }
    
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPin = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jVirtualAccount = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jBillInRupiah = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jClock = new javax.swing.JLabel();
        jIcon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbcaAccountNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jVirtualAccountNumber = new javax.swing.JTextField();
        jLogo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jBackButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(375, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(0, 0, 0, 135));
        jPanel9.setPreferredSize(new java.awt.Dimension(375, 750));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPinActionPerformed(evt);
            }
        });
        jPanel5.add(jPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 240, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 153));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Access Code");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 240, 30));

        jButton4.setBackground(new java.awt.Color(0, 102, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("OK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 110, 40));

        jButton5.setBackground(new java.awt.Color(0, 102, 204));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 110, 40));

        jPanel9.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 300, 210));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0, 135));
        jPanel8.setPreferredSize(new java.awt.Dimension(375, 750));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 153));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("m-Transfer");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 230, 30));

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 110, 40));

        jVirtualAccount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jVirtualAccount.setForeground(new java.awt.Color(0, 51, 153));
        jVirtualAccount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jVirtualAccount.setText("12312300");
        jPanel4.add(jVirtualAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 150, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 153));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Virtual Account :");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 140, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 153));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Bill :");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        jBillInRupiah.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBillInRupiah.setForeground(new java.awt.Color(0, 51, 153));
        jBillInRupiah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBillInRupiah.setText("Rp 100.000");
        jPanel4.add(jBillInRupiah, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 150, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 153));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("9321178999");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 150, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 153));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("From :");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 30));

        jButton3.setBackground(new java.awt.Color(0, 102, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, 40));

        jPanel8.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 300, 350));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(6, 56, 156));
        jPanel2.setPreferredSize(new java.awt.Dimension(375, 40));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jClock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jClock.setText("hh:mm");
        jPanel2.add(jClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jIcon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jIcon.setText("icon (wifi, etc)");
        jIcon.setPreferredSize(new java.awt.Dimension(67, 12));
        jPanel2.add(jIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 10, 80, 20));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TRANSFER");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Send From :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jbcaAccountNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbcaAccountNumber.setText("0902373726667");
        jbcaAccountNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcaAccountNumberActionPerformed(evt);
            }
        });
        jPanel2.add(jbcaAccountNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 300, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Virtual Account :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jVirtualAccountNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jVirtualAccountNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVirtualAccountNumberActionPerformed(evt);
            }
        });
        jPanel2.add(jVirtualAccountNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 300, -1));

        jLogo.setText("                        Logo");
        jLogo.setPreferredSize(new java.awt.Dimension(250, 250));
        jPanel2.add(jLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 180, 80));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(6, 56, 156));
        jButton1.setText("PAY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 440, 360, 42));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(375, 40));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jBackButton.setForeground(new java.awt.Color(255, 255, 255));
        jBackButton.setText("Back");
        jBackButton.setToolTipText("");
        jPanel2.add(jBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 40, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 375, 750));

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

    private void jbcaAccountNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcaAccountNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbcaAccountNumberActionPerformed

    private void jVirtualAccountNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVirtualAccountNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jVirtualAccountNumberActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.virtualAcc = jVirtualAccountNumber.getText();      
        
        this.bill = DA.DA_VirtualAccount.getVirtualAccountBill(virtualAcc);
        
        if(bill == 0) {
            JOptionPane.showMessageDialog(rootPane, "You have no bill to pay"); 
        } else {
            jVirtualAccount.setText(this.virtualAcc);
            jBillInRupiah.setText(rupiahFormat(bill));
            jPanel8.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPanel9.setVisible(rootPaneCheckingEnabled);
        jPanel8.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(jPin.getText().equals("1234")) {
            DA.DA_VirtualAccount.setVirtualAccountBill(this.virtualAcc, "0");
            this.setVisible(false);
            new OA2BCAHomePage("close").setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPinActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jPanel8.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jPanel9.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed
    
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
            java.util.logging.Logger.getLogger(OA2BCALogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OA2BCALogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OA2BCALogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OA2BCALogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OA2BCATransfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBackButton;
    private javax.swing.JLabel jBillInRupiah;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jClock;
    private javax.swing.JLabel jIcon;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPin;
    private javax.swing.JLabel jVirtualAccount;
    private javax.swing.JTextField jVirtualAccountNumber;
    private javax.swing.JTextField jbcaAccountNumber;
    // End of variables declaration//GEN-END:variables
}
