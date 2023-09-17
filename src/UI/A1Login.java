
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

public class A1Login extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    ResultSet getUserName = null;
    PreparedStatement pst = null;
   
    public A1Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        con = db.mycon();
        time();
        scaleImage(jWifi, "/pictures/Wifi_Hooray.png");
//        scaleImage(jCloudLogin,"D:\\University\\SEMESTER 1\\Introduction To Programming\\Mr. Samuel\\NetBeansProject\\FinalProjectSemester2\\src\\pictures\\CloudLogin.png");
//        scaleImage(jSplashBox,"D:\\University\\SEMESTER 1\\Introduction To Programming\\Mr. Samuel\\NetBeansProject\\FinalProjectSemester2\\src\\pictures\\SplashBox_Hooray.png");
//        scaleImage(jSignInButton,"D:\\University\\SEMESTER 1\\Introduction To Programming\\Mr. Samuel\\NetBeansProject\\FinalProjectSemester2\\src\\pictures\\SignInButton.png");
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
        jEmail = new javax.swing.JTextField();
        jPass = new javax.swing.JPasswordField();
        jSignInButton = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSplashBox = new javax.swing.JLabel();
        jCloudLogin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jClock = new javax.swing.JLabel();
        jWifi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(254, 253, 244));
        jPanel1.setPreferredSize(new java.awt.Dimension(375, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmailActionPerformed(evt);
            }
        });
        jPanel1.add(jEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 260, 40));

        jPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassActionPerformed(evt);
            }
        });
        jPanel1.add(jPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 260, 40));

        jSignInButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jSignInButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/SignInButton.png"))); // NOI18N
        jSignInButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSignInButtonMouseClicked(evt);
            }
        });
        jPanel1.add(jSignInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 390, 250, 52));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(183, 218, 222));
        jLabel4.setText("Welcome Back!");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 145, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Email");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Password");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel3.setText("Don’t have an account yet?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 150, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(164, 199, 204));
        jLabel9.setText("Sign up");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 50, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(164, 199, 204));
        jLabel10.setText("Forgot password?");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, -1));

        jSplashBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jSplashBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/SplashBox_Login.png"))); // NOI18N
        jPanel1.add(jSplashBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 375, 350));

        jCloudLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCloudLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Cloud_Login.png"))); // NOI18N
        jPanel1.add(jCloudLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 555, 375, 200));

        jPanel2.setBackground(new java.awt.Color(254, 253, 244));
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

    private void jEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmailActionPerformed

    private void jPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPassActionPerformed

    private void jSignInButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSignInButtonMouseClicked
        String email = jEmail.getText();
        String password = jPass.getText();
        Handler.validateCustomer(email, password, this);
    }//GEN-LAST:event_jSignInButtonMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        this.setVisible(false);
        new A1SignUp().setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

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
            java.util.logging.Logger.getLogger(A1Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A1Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A1Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A1Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new A1Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jClock;
    private javax.swing.JLabel jCloudLogin;
    private javax.swing.JTextField jEmail;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPass;
    private javax.swing.JLabel jSignInButton;
    private javax.swing.JLabel jSplashBox;
    private javax.swing.JLabel jWifi;
    // End of variables declaration//GEN-END:variables
}
