/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kxbjava;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author User
 */
public class APULogin extends javax.swing.JFrame {

    private boolean Username = false, Password = false;
    private String UserID, username, FileDir, fullname, email, password, phonenumber, gender, ManagerID, currentdate, userRole;

    /**
     * Creates new form APULogin
     */
    public APULogin() {
        initComponents();
        initForm();
    }
    
    private void setLogo() {
        String sourcefolder = System.getProperty("user.dir") + "\\src\\icons\\";
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(sourcefolder + "AHHASCrsmol.png"));
        this.setTitle("AHHASC Login Page");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblTitle1 = new javax.swing.JLabel();
        btnPnl = new javax.swing.JPanel();
        btnForgor = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        lblPass = new javax.swing.JLabel();
        lblsuer = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtUsername = new javax.swing.JTextField();
        lblDesc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(68, 68, 68));
        jPanel2.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle1.setBackground(new java.awt.Color(68, 68, 68));
        lblTitle1.setFont(new java.awt.Font("Segoe UI Variable", 1, 38)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(214, 41, 99));
        lblTitle1.setText("Login");
        jPanel2.add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        btnPnl.setBackground(new java.awt.Color(68, 68, 68));

        btnForgor.setBackground(new java.awt.Color(68, 68, 68));
        btnForgor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnForgor.setForeground(new java.awt.Color(255, 255, 255));
        btnForgor.setText("I Forgot My Password");
        btnForgor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnForgor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnForgor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForgorActionPerformed(evt);
            }
        });

        btnback.setBackground(new java.awt.Color(68, 68, 68));
        btnback.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnback.setForeground(new java.awt.Color(255, 255, 255));
        btnback.setText("Back");
        btnback.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(68, 68, 68));
        btnLogin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPnlLayout = new javax.swing.GroupLayout(btnPnl);
        btnPnl.setLayout(btnPnlLayout);
        btnPnlLayout.setHorizontalGroup(
            btnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPnlLayout.createSequentialGroup()
                .addContainerGap(555, Short.MAX_VALUE)
                .addComponent(btnForgor, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        btnPnlLayout.setVerticalGroup(
            btnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPnlLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(btnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnForgor, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanel2.add(btnPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 1280, 100));

        lblPass.setFont(new java.awt.Font("Segoe UI Variable", 0, 24)); // NOI18N
        lblPass.setForeground(new java.awt.Color(255, 255, 255));
        lblPass.setText("Password");
        jPanel2.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, -1, -1));

        lblsuer.setFont(new java.awt.Font("Segoe UI Variable", 0, 24)); // NOI18N
        lblsuer.setForeground(new java.awt.Color(255, 255, 255));
        lblsuer.setText("Username");
        jPanel2.add(lblsuer, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, -1));

        txtPassword.setBackground(new java.awt.Color(68, 68, 68));
        txtPassword.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(237, 237, 237));
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtPassword.setCaretColor(new java.awt.Color(237, 237, 237));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 700, 80));

        txtUsername.setBackground(new java.awt.Color(68, 68, 68));
        txtUsername.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(237, 237, 237));
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtUsername.setCaretColor(new java.awt.Color(237, 237, 237));
        jPanel2.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 700, 80));

        lblDesc.setBackground(new java.awt.Color(68, 68, 68));
        lblDesc.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc.setText("Please Provide Your Username and Password");
        jPanel2.add(lblDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Validation Methods">
    private void showLoginButton() {
        if (Username && Password) {
            btnLogin.setEnabled(true);
        } else {
            btnLogin.setEnabled(false);
        }
    }

    private void showLoginButton(JTextField txt) {
        if ("".equals(txt.getText())) {
            Username = false;
        } else {
            Username = true;
        }
        showLoginButton();
    }

    private void showLoginButton(JPasswordField txt) {
        if ("".equals(String.valueOf(txtPassword.getPassword()))) {
            Password = false;
        } else {
            Password = true;
        }
        showLoginButton();

    }

    private void createDir() {
        try {
            FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
            Path dir = Paths.get(FileDir);
            Files.createDirectories(dir);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void createDatabase() {
        try {
            FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
            File usertxt = new File(FileDir + "UserProfile.txt");
            File customertxt = new File(FileDir + "Customer.txt");
            File appttxt = new File(FileDir + "Appointment.txt");
            File paymenttxt = new File(FileDir + "Payment.txt");
            if (!usertxt.exists()) {
                usertxt.createNewFile();
            }
            if (!customertxt.exists()) {
                customertxt.createNewFile();
            }
            if (!appttxt.exists()) {
                appttxt.createNewFile();
            }
            if (!paymenttxt.exists()) {
                paymenttxt.createNewFile();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods">
    private boolean validateAccount() {
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
                if (User.equals(matchedID[5]) && Pass.equals(matchedID[6])) {
                    Authenticate = true;
                    UserID = matchedID[0];
                    ManagerID = matchedID[1];
                    userRole = matchedID[2];
                    fullname = matchedID[3];
                    email = matchedID[4];
                    username = matchedID[5];
                    password = matchedID[6];
                    phonenumber = matchedID[7];
                    gender = matchedID[8];
                }
            }
            inputFile.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return Authenticate;
    }

    //Start the session for the user
    private void userSession() {
        try {
            FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
            File cache = new File(FileDir + "UserCache.txt");
            if (!cache.exists()) {
                cache.createNewFile();
            }
            FileWriter ld = new FileWriter(FileDir + "UserCache.txt", true);
            PrintWriter ldp = new PrintWriter(ld);
            ldp.println(UserID + ":" + ManagerID + ":" + userRole + ":" + fullname + ":" + email + ":" + username + ":" + password + ":" + phonenumber + ":" + gender);
            ldp.close();
        } catch (Exception ex) {

        }
    }

    private void clearCache() {
        try {
            FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
            File cache = new File(FileDir + "UserCache.txt");
            if (cache.exists()) {
                cache.delete();
            }
        } catch (Exception ex) {

        }
    }

    //Store the records of the session of the user
    private void storeSession() {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH.mm.ss");
            LocalDateTime now = LocalDateTime.now();
            currentdate = dtf.format(now);
            FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
            File records = new File(FileDir + "LoginRecords.txt");
            if (!records.exists()) {
                records.createNewFile();
            }
            FileWriter ld = new FileWriter(FileDir + "LoginRecords.txt", true);
            PrintWriter ldp = new PrintWriter(ld);
            ldp.println(UserID + ":" + ManagerID + ":" + userRole + ":" + fullname + ":" + currentdate);
            ldp.close();
        } catch (Exception ex) {

        }
    }

    private void checkUserType() {
        if (UserID.contains("CM")) {
            new APUCMMenu().setVisible(true);
            this.dispose();
        }
        if (UserID.contains("TC")) {
            new APUTCMenu().setVisible(true);
            this.dispose();
        }
    }

    private void initForm() {
        // Create the required directory for first time boot
        createDir();
        // Create the required database textfiles for first time boot
        createDatabase();
        setLogo();
        this.setLocationRelativeTo(null);
        btnLogin.setEnabled(false); // This will prevent the login button from being pressed right after startup
        // This anon class handles textfield changes for username entry
        txtUsername.getDocument().addDocumentListener(new APUDocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                showLoginButton(txtUsername);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                showLoginButton(txtUsername);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                showLoginButton(txtUsername);

            }
        });

        // This anon class handles textfield changes for password entry
        txtPassword.getDocument().addDocumentListener(new APUDocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                showLoginButton(txtPassword);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                showLoginButton(txtPassword);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                showLoginButton(txtPassword);

            }
        });

        // This anon class handles window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Closing Window", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (selection == JOptionPane.YES_OPTION) {
                    clearCache();
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }
    //</editor-fold>

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        // TODO add your handling code here:
        if ("".equals(String.valueOf(txtPassword.getPassword())) && "".equals(txtUsername.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter the password!", "Failure of Authentication", JOptionPane.ERROR_MESSAGE);
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (validateAccount()) {
                    JOptionPane.showMessageDialog(null, "Login Successfully! Going to Main Menu", "Authentication Successfully!", JOptionPane.INFORMATION_MESSAGE);
                    userSession();
                    checkUserType();
                } else {
                    JOptionPane.showMessageDialog(null, "Authentication failed! Wrong password or username", "Failure of Authentication", JOptionPane.ERROR_MESSAGE);

                }
            }
        }

    }//GEN-LAST:event_txtPasswordKeyReleased

    private void btnForgorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForgorActionPerformed
        new ForgetPassword().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnForgorActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        new APUHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        if (validateAccount()) {
            JOptionPane.showMessageDialog(null, "Login Successfully! Going to Main Menu", "Authentication Successfully!", JOptionPane.INFORMATION_MESSAGE);
            userSession();
            storeSession();
            checkUserType();
        } else {
            JOptionPane.showMessageDialog(null, "Authentication failed! Wrong password or username", "Failure of Authentication", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnLoginActionPerformed
    // </editor-fold>

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
    private javax.swing.JButton btnForgor;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel btnPnl;
    private javax.swing.JButton btnback;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblsuer;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
