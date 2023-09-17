
package UI;

import Handler.*;
import DA.db;
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

public class A0Splash extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    ResultSet getUserName = null;
    PreparedStatement pst = null;
   
    public A0Splash() {
        initComponents();
        this.setLocationRelativeTo(null);
        con = db.mycon();
        time();
        scaleImage(jLogo,"D:\\University\\SEMESTER 1\\Introduction To Programming\\Mr. Samuel\\NetBeansProject\\FinalProjectSemester2\\src\\pictures\\Logo_Hooray.png");
        scaleImage(jWifi,"D:\\University\\SEMESTER 1\\Introduction To Programming\\Mr. Samuel\\NetBeansProject\\FinalProjectSemester2\\src\\pictures\\Wifi_Hooray.png");
        scaleImage(jCloud,"D:\\University\\SEMESTER 1\\Introduction To Programming\\Mr. Samuel\\NetBeansProject\\FinalProjectSemester2\\src\\pictures\\Cloud_Hooray.png");
        scaleImage(jSplashBox,"D:\\University\\SEMESTER 1\\Introduction To Programming\\Mr. Samuel\\NetBeansProject\\FinalProjectSemester2\\src\\pictures\\SplashBox_Hooray.png");
        scaleImage(jSignUpButton,"D:\\University\\SEMESTER 1\\Introduction To Programming\\Mr. Samuel\\NetBeansProject\\FinalProjectSemester2\\src\\pictures\\GetStartButton.png");
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
        ImageIcon icon = new ImageIcon(imgURL);
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
        jCloud = new javax.swing.JLabel();
        JWelcome = new javax.swing.JLabel();
        JMobileApp = new javax.swing.JLabel();
        jDescription1 = new javax.swing.JLabel();
        jDescription2 = new javax.swing.JLabel();
        jDescription3 = new javax.swing.JLabel();
        jDescription4 = new javax.swing.JLabel();
        jDescription5 = new javax.swing.JLabel();
        jDescription6 = new javax.swing.JLabel();
        jDescription7 = new javax.swing.JLabel();
        jSignUpButton = new javax.swing.JLabel();
        jSplashBox = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 254, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(375, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 254, 245));
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
        jLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Logo_Hooray.png"))); // NOI18N
        jLogo.setPreferredSize(new java.awt.Dimension(250, 250));
        jPanel1.add(jLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 50, 290, 130));

        jCloud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCloud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Cloud_Hooray.png"))); // NOI18N
        jPanel1.add(jCloud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 375, 180));

        JWelcome.setBackground(new java.awt.Color(183, 218, 222));
        JWelcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JWelcome.setForeground(new java.awt.Color(183, 218, 222));
        JWelcome.setText("Welcome to HOORAY");
        jPanel1.add(JWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, 50));

        JMobileApp.setBackground(new java.awt.Color(183, 218, 222));
        JMobileApp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JMobileApp.setForeground(new java.awt.Color(183, 218, 222));
        JMobileApp.setText("Mobile App!");
        jPanel1.add(JMobileApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 240, 150, 50));

        jDescription1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jDescription1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jDescription1.setText("Providing a healthy, fun and");
        jPanel1.add(jDescription1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 230, -1));

        jDescription2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jDescription2.setText("educative playing and learning");
        jPanel1.add(jDescription2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 260, -1));

        jDescription3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jDescription3.setText("environment to explore and");
        jPanel1.add(jDescription3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 230, -1));

        jDescription4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jDescription4.setText("develop the maximum potentials");
        jPanel1.add(jDescription4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 250, -1));

        jDescription5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jDescription5.setText("of future leaders. View our outlets");
        jPanel1.add(jDescription5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 280, -1));

        jDescription6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jDescription6.setText("and service hassle free in our");
        jPanel1.add(jDescription6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 280, -1));

        jDescription7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jDescription7.setText("mobile application.");
        jPanel1.add(jDescription7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 280, -1));

        jSignUpButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jSignUpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/GetStartButton.png"))); // NOI18N
        jSignUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSignUpButtonMouseClicked(evt);
            }
        });
        jPanel1.add(jSignUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 456, 230, 42));

        jSplashBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jSplashBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/SplashBox_Hooray.png"))); // NOI18N
        jPanel1.add(jSplashBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 375, 360));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Already have an account?");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 170, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(164, 199, 204));
        jLabel2.setText("Sign in");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 540, 50, 20));

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

    private void jSignUpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSignUpButtonMouseClicked
        this.setVisible(false);
        new A1SignUp().setVisible(true);
    }//GEN-LAST:event_jSignUpButtonMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setVisible(false);
        new A1Login().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(A0Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A0Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A0Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A0Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A0Splash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JMobileApp;
    private javax.swing.JLabel JWelcome;
    private javax.swing.JLabel jClock;
    private javax.swing.JLabel jCloud;
    private javax.swing.JLabel jDescription1;
    private javax.swing.JLabel jDescription2;
    private javax.swing.JLabel jDescription3;
    private javax.swing.JLabel jDescription4;
    private javax.swing.JLabel jDescription5;
    private javax.swing.JLabel jDescription6;
    private javax.swing.JLabel jDescription7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jSignUpButton;
    private javax.swing.JLabel jSplashBox;
    private javax.swing.JLabel jWifi;
    // End of variables declaration//GEN-END:variables
}
