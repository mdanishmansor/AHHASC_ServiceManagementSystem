/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kxbjava;

import com.formdev.flatlaf.FlatDarkLaf;
import com.sun.glass.events.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class APULogin extends javax.swing.JFrame {
    private boolean Username = false, Password = false;
    private String UserID, username, FileDir, fullname, email, password, phonenumber, gender;
    /**
     * Creates new form APULogin
     */
    public APULogin() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(68, 68, 68));

        lblTitle.setBackground(new java.awt.Color(68, 68, 68));
        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(218, 0, 55));
        lblTitle.setText("Login");

        txtUsername.setBackground(new java.awt.Color(68, 68, 68));
        txtUsername.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(237, 237, 237));
        txtUsername.setText("Username");
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtUsername.setCaretColor(new java.awt.Color(237, 237, 237));
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(68, 68, 68));
        txtPassword.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(237, 237, 237));
        txtPassword.setText("PasswordforUser");
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtPassword.setCaretColor(new java.awt.Color(237, 237, 237));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(23, 23, 23));
        btnLogin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(218, 0, 55));
        btnLogin.setText("Login");
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(463, 463, 463)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(txtUsername))
                .addContainerGap(497, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Methods">
    
    private boolean ValidateAccount() {
        boolean Authenticate = false;
        try {
            FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
            String User = txtUsername.getText();
            String Pass = String.valueOf(txtPassword.getPassword());
            File usertext = new File(FileDir + "UserProfile.txt");
            if (!usertext.exists()) {
                usertext.createNewFile();
            }
            Scanner inputFile = new Scanner(usertext);
            String[] matchedID;
            while (inputFile.hasNext()) {
                String lEntry = inputFile.nextLine();
                matchedID = lEntry.split(":");
                if (User.equals(matchedID[4]) && Pass.equals(matchedID[5])) {
                    Authenticate = true;
                    UserID = matchedID[0];
                    fullname = matchedID[1];
                    email = matchedID[2];
                    username = matchedID[3];
                    password = matchedID[4];
                    phonenumber = matchedID[5];
                    gender = matchedID[6];
                   }
            }
            inputFile.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return Authenticate;
    }
    //Start the session for the user
    private void UserSession(){
         try {
        FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
        File cache = new File(FileDir + "UserCache.txt");
        if (!cache.exists()) {
            cache.createNewFile();
        }
        FileWriter ld = new FileWriter(FileDir + "UserCache.txt", true); 
        PrintWriter ldp = new PrintWriter(ld);
        ldp.println(UserID + ":" + fullname + ":" + email + ":" + username + ":" + password + ":" + phonenumber + ":" + gender);
        ldp.close();
        } catch (Exception ex) {
            
        }
    }
    
    //Store the records of the session of the user
    private void StoreSession(){
        
    }
    
    private void checkUserType(){
         if (UserID.contains("CM")) {
                    new APUCMMenu().setVisible(true);
                    this.dispose();
                }
         if(UserID.contains("TC")){
             new APUTCMenu().setVisible(true);
             this.dispose();
         }
    }
    //</editor-fold>
    
    
    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
       if (txtUsername.getText().equals("Username")) {
            txtUsername.setText("");
        } 
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
         if (txtUsername.getText().equals("")) {
            txtUsername.setText("Username");
        } 
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
         if (txtPassword.getText().equals("PasswordforUser")) {
            txtPassword.setText("");
        } 
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
         if (txtPassword.getText().equals("")) {
            txtPassword.setText("PasswordforUser");
        } 
    }//GEN-LAST:event_txtPasswordFocusLost

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        if(ValidateAccount()){
            JOptionPane.showMessageDialog(null, "Login Successfully! Going to Main Menu", "Authentication Successfully!", JOptionPane.INFORMATION_MESSAGE);
           UserSession();
           checkUserType();
        } else {
            JOptionPane.showMessageDialog(null, "Authentication failed! Wrong password or username", "Failure of Authentication", JOptionPane.ERROR_MESSAGE);
        
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(ValidateAccount()){
            JOptionPane.showMessageDialog(null, "Login Successfully! Going to Main Menu", "Authentication Successfully!", JOptionPane.INFORMATION_MESSAGE);
           UserSession();
           checkUserType();
        } else {
            JOptionPane.showMessageDialog(null, "Authentication failed! Wrong password or username", "Failure of Authentication", JOptionPane.ERROR_MESSAGE);
        
        }
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(ValidateAccount()){
            JOptionPane.showMessageDialog(null, "Login Successfully! Going to Main Menu", "Authentication Successfully!", JOptionPane.INFORMATION_MESSAGE);
           UserSession();
           checkUserType();
        } else {
            JOptionPane.showMessageDialog(null, "Authentication failed! Wrong password or username", "Failure of Authentication", JOptionPane.ERROR_MESSAGE);
        
        }
        }
    }//GEN-LAST:event_txtUsernameKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Fail Look and Feel");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new APULogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
