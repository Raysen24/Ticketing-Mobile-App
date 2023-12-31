/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Handler.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author raysen
 */
public class A1SignUp extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public A1SignUp() {
        initComponents();
        this.setLocationRelativeTo(null);
        time();
//        scaleImage(jWifi,"D:\\University\\SEMESTER 1\\Introduction To Programming\\Mr. Samuel\\NetBeansProject\\FinalProjectSemester2\\src\\pictures\\Wifi_Hooray.png");
//        scaleImage(jCloud,"D:\\University\\SEMESTER 1\\Introduction To Programming\\Mr. Samuel\\NetBeansProject\\FinalProjectSemester2\\src\\pictures\\Cloud_Hooray.png");
//        scaleImage(jSplashBox,"D:\\University\\SEMESTER 1\\Introduction To Programming\\Mr. Samuel\\NetBeansProject\\FinalProjectSemester2\\src\\pictures\\SplashBox_Hooray.png");
//        scaleImage(jSignUpButton,"D:\\University\\SEMESTER 1\\Introduction To Programming\\Mr. Samuel\\NetBeansProject\\FinalProjectSemester2\\src\\pictures\\SignUpButton.png");
//        scaleImage(jBackButton,"D:\\University\\SEMESTER 1\\Introduction To Programming\\Mr. Samuel\\NetBeansProject\\FinalProjectSemester2\\src\\pictures\\BackButton.png");
    }
    
    public void time(){
        Timer timer;
        
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                
                java.util.Date date = new java.util.Date();
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jFirstName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateOfBirth = new javax.swing.JTextField();
        jPass2 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jPass = new javax.swing.JPasswordField();
        jSignUpButton = new javax.swing.JLabel();
        jSplashBox = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDescription6 = new javax.swing.JLabel();
        jCloud = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jClock = new javax.swing.JLabel();
        jWifi = new javax.swing.JLabel();
        jBackButton = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(254, 253, 244));
        jPanel1.setPreferredSize(new java.awt.Dimension(375, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(183, 218, 222));
        jLabel1.setText("Sign Up");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("First name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 110, -1, -1));

        jFirstName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFirstNameActionPerformed(evt);
            }
        });
        jPanel1.add(jFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 130, 250, 31));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Last name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 170, -1, -1));

        jLastName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLastNameActionPerformed(evt);
            }
        });
        jPanel1.add(jLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 190, 250, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Email");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 230, -1, -1));

        jEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmailActionPerformed(evt);
            }
        });
        jPanel1.add(jEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 250, 250, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Confirm Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 410, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Date of Birth (dd-MM-yyyy)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 290, 190, 20));

        jDateOfBirth.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jDateOfBirth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateOfBirthMouseClicked(evt);
            }
        });
        jDateOfBirth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDateOfBirthActionPerformed(evt);
            }
        });
        jPanel1.add(jDateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 310, 250, -1));

        jPass2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPass2ActionPerformed(evt);
            }
        });
        jPanel1.add(jPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 430, 250, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Password");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 350, -1, -1));

        jPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassActionPerformed(evt);
            }
        });
        jPanel1.add(jPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 370, 250, -1));

        jSignUpButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jSignUpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/SignUpButton.png"))); // NOI18N
        jSignUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSignUpButtonMouseClicked(evt);
            }
        });
        jPanel1.add(jSignUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 478, 230, 50));

        jSplashBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jSplashBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/SplashBox_SignUp.png"))); // NOI18N
        jPanel1.add(jSplashBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 375, 465));

        jLabel3.setText("By signing up you're agree to our");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 552, 180, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(164, 199, 204));
        jLabel9.setText("Terms & Conditions");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 552, 120, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(164, 199, 204));
        jLabel10.setText("Privacy Policy");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 80, -1));

        jDescription6.setText("and");
        jPanel1.add(jDescription6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 30, -1));

        jCloud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCloud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Cloud_Hooray.png"))); // NOI18N
        jPanel1.add(jCloud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 375, 180));

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

        jBackButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/BackButton.png"))); // NOI18N
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });
        jPanel1.add(jBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 50, 31, 30));

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

    private void jFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFirstNameActionPerformed

    private void jLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLastNameActionPerformed

    private void jEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmailActionPerformed

    private void jSignUpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSignUpButtonMouseClicked
            // Register code here
        

        String firstName = jFirstName.getText();
        String lastName = jLastName.getText();
        String email = jEmail.getText();
        String dob = jDateOfBirth.getText();
        String pass = jPass.getText();
        String pass2 = jPass2.getText();
        
        Handler.signUp(firstName, lastName, email, dob, pass, pass2, this);
    }//GEN-LAST:event_jSignUpButtonMouseClicked

    private void jPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPassActionPerformed

    private void jPass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPass2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPass2ActionPerformed

    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        this.setVisible(false);
        new A0Splash().setVisible(true);
    }//GEN-LAST:event_jBackButtonMouseClicked

    private void jDateOfBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDateOfBirthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateOfBirthActionPerformed

    private void jDateOfBirthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateOfBirthMouseClicked
        jDateOfBirth.setText("");
    }//GEN-LAST:event_jDateOfBirthMouseClicked

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
            java.util.logging.Logger.getLogger(A1SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A1SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A1SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A1SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new A1SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBackButton;
    private javax.swing.JLabel jClock;
    private javax.swing.JLabel jCloud;
    private javax.swing.JTextField jDateOfBirth;
    private javax.swing.JLabel jDescription6;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jFirstName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLastName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPass;
    private javax.swing.JPasswordField jPass2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JLabel jSignUpButton;
    private javax.swing.JLabel jSplashBox;
    private javax.swing.JLabel jWifi;
    // End of variables declaration//GEN-END:variables
}
