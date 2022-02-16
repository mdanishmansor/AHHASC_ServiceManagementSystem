/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kxbjava;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author User
 */
public class ForgetPassword extends javax.swing.JFrame {
    private String FileDir, userID, managerID, userRole, fullName, userEmail, username, phoneNumber, Gender, flag;
    private final Color ogtxt = new Color(237,237,237);

    /**
     * Creates new form APUProvideFeedback
     */
    public ForgetPassword() {
        initComponents();
        initForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFeedback = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        txtConfirmPass = new javax.swing.JPasswordField();
        txtNewPass = new javax.swing.JPasswordField();
        lblNewPass = new javax.swing.JLabel();
        lblUserID = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblConfirmPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlFeedback.setBackground(new java.awt.Color(68, 68, 68));

        lblTitle.setBackground(new java.awt.Color(68, 68, 68));
        lblTitle.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(218, 0, 55));
        lblTitle.setText("Reset Password");

        txtUserID.setBackground(new java.awt.Color(68, 68, 68));
        txtUserID.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtUserID.setToolTipText("User ID");
        txtUserID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));

        txtEmail.setBackground(new java.awt.Color(68, 68, 68));
        txtEmail.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtEmail.setToolTipText("User Email");
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        btnSubmit.setBackground(new java.awt.Color(23, 23, 23));
        btnSubmit.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(237, 237, 237));
        btnSubmit.setText("Submit");
        btnSubmit.setToolTipText("Button to reset every fields");
        btnSubmit.setBorder(null);
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        txtConfirmPass.setBackground(new java.awt.Color(68, 68, 68));
        txtConfirmPass.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtConfirmPass.setForeground(new java.awt.Color(237, 237, 237));
        txtConfirmPass.setToolTipText("Confirm Password");
        txtConfirmPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtConfirmPass.setCaretColor(new java.awt.Color(237, 237, 237));

        txtNewPass.setBackground(new java.awt.Color(68, 68, 68));
        txtNewPass.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtNewPass.setForeground(new java.awt.Color(237, 237, 237));
        txtNewPass.setToolTipText("User Password");
        txtNewPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtNewPass.setCaretColor(new java.awt.Color(237, 237, 237));

        lblNewPass.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNewPass.setText("New Password:");

        lblUserID.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblUserID.setText("User ID:");

        lblEmail.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblEmail.setText("Email:");

        lblConfirmPass.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblConfirmPass.setText("Confirm Password:");

        javax.swing.GroupLayout pnlFeedbackLayout = new javax.swing.GroupLayout(pnlFeedback);
        pnlFeedback.setLayout(pnlFeedbackLayout);
        pnlFeedbackLayout.setHorizontalGroup(
            pnlFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFeedbackLayout.createSequentialGroup()
                .addGroup(pnlFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFeedbackLayout.createSequentialGroup()
                        .addGap(528, 528, 528)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFeedbackLayout.createSequentialGroup()
                        .addGap(543, 543, 543)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFeedbackLayout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addGroup(pnlFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNewPass)
                            .addComponent(lblUserID))
                        .addGap(132, 132, 132)
                        .addGroup(pnlFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblConfirmPass)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail))))
                .addContainerGap(437, Short.MAX_VALUE))
        );
        pnlFeedbackLayout.setVerticalGroup(
            pnlFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFeedbackLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(pnlFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lblUserID))
                .addGap(29, 29, 29)
                .addGroup(pnlFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFeedbackLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lblNewPass))
                    .addGroup(pnlFeedbackLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblConfirmPass)))
                .addGap(32, 32, 32)
                .addGroup(pnlFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void loadUserProfile(){
        String[] matchedID = null;
        FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
        File usertext = new File(FileDir + "UserProfile.txt");
        Scanner intUser;
        try {
            intUser = new Scanner(usertext);
            while (intUser.hasNext())
            {
             String bEntry = intUser.nextLine();
             matchedID = bEntry.split(":");
             
             if(matchedID[0].equals(txtUserID.getText()) && matchedID[4].equals(txtEmail.getText())){
                 userID = matchedID[0];
                 managerID = matchedID[1];
                 userRole = matchedID[2];
                 fullName = matchedID[3];
                 userEmail = matchedID[4];
                 username = matchedID[5];
                 matchedID[6] = String.valueOf(txtNewPass.getPassword());
                 phoneNumber = matchedID[7];
                 Gender = matchedID[8];
                 matchedID[9] = "true";
             }
                }
            intUser.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
   
    private boolean similarPassword(){
        boolean isSimilar = false;
        String currentPass = String.valueOf(txtNewPass.getPassword());
        String comparePass = String.valueOf(txtConfirmPass.getPassword());
        if ("".equals(currentPass) || "".equals(comparePass)) {
            isSimilar = false;
        } else if (currentPass.equals(comparePass)) {
            isSimilar = true;
        }
        return isSimilar;
    }
    
     private void updatePassword(){
        // TODO add your handling code here:
        try {
            // Check if textfields are empty
            emptyFields();
            if (!similarPassword()) {
                throw new Exception("Password mismatch");
            }
            // To get directory  
            FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
            // To get the book ID
            // To rename original book.txt to book.bak
            File userOri = new File(FileDir + "UserProfile.txt");
            File userBack = new File(FileDir + "UserProfileBack.txt");
            // To check if clientBak.txt is present or not
            if (!userBack.exists()){
                userOri.createNewFile();
            }
            // This is for debugging only!
            // JOptionPane.showMessageDialog(null, "renamed");
            // This is to rename the existing book.txt to clientBak.txt
            userOri.renameTo(userBack);
            // This is to open, find and replace a specific book record
            // Requires temporary file to store current state
            // FileWriter to write into a new file called book.txt
            FileWriter cd = new FileWriter(FileDir + "UserProfile.txt"); 
            // PrintWriter to print into book.txt
            PrintWriter cdp = new PrintWriter(cd); 
            // This is to open and read clientBak.txt 
            File usertxt = new File(FileDir + "UserProfileBack.txt");
            // This is to instantiate the file opened earlier
            Scanner inputFile = new Scanner(usertxt);
            // This array is to contain all lines
            String[] matchedID;
            // This is only for debugging!
            // boolean itWorked = false;
            // Read lines from the file until no more are left.
            while (inputFile.hasNext())
            {
                // This is for debugging only!
                // JOptionPane.showMessageDialog(null, "In loop");
                // Read the next line.
                String bEntry = inputFile.nextLine();
                // Split the line by using the delimiter ":" (semicolon) and store into array.
                matchedID = bEntry.split(":");
                 if (matchedID[0].equals(txtUserID.getText())) {
                     if(similarPassword()){
                         
                         matchedID[0] = txtUserID.getText();
                         matchedID[1] = managerID;
                         matchedID[2] = userRole;
                         matchedID[3] = fullName;
                         matchedID[4] = userEmail;
                         matchedID[5] = username;
                         matchedID[6] = String.valueOf(txtNewPass.getPassword());
                         matchedID[7] = phoneNumber;
                         matchedID[8] = Gender;
                         matchedID[9] = flag;
                         
                         System.out.println(matchedID[0]);
                         System.out.println(matchedID[1]);
                         System.out.println(matchedID[2]);
                         System.out.println(matchedID[3]);
                         System.out.println(matchedID[4]);
                         System.out.println(matchedID[5]);
                         System.out.println(matchedID[6]);
                         System.out.println(matchedID[7]);
                         System.out.println(matchedID[8]);
                         System.out.println(matchedID[9]);
                         
                         cdp.println(matchedID[0] + ":" +
                            matchedID[1] + ":" +
                            matchedID[2] + ":" +
                            matchedID[3] + ":" +
                            matchedID[4] + ":" +
                            matchedID[5] + ":" +
                            matchedID[6] + ":" +
                            matchedID[7] + ":" +
                            matchedID[8] + ":" +
                            matchedID[9]); 
                         JOptionPane.showMessageDialog(null, "Password is matching!", "Password mismatch!", JOptionPane.WARNING_MESSAGE);
                     }
                     else {
                         JOptionPane.showMessageDialog(null, "Password is not matching!", "Password mismatch!", JOptionPane.WARNING_MESSAGE);
                     }
                  
                 } else {
                     System.out.println("error");
                 }
            }
            // Close the clientBak.txt reader
            inputFile.close();
            // This deletes clientBak.txt
            userBack.delete();
            // This closes the book.txt printer 
            cdp.close();
           
            //loadCustomerInfo();
        } catch (Exception ex) {
            highlightEmpty();
            System.out.println(ex);
             if (!similarPassword()) {
                JOptionPane.showMessageDialog(null, "Password is not matching!", "Password mismatch!", JOptionPane.WARNING_MESSAGE);
            } 
            JOptionPane.showMessageDialog(null, "Invalid input! Please check your input to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
            // Continue with displaying which field was affected. ensure it appears before the mnessagebox
        }
    }
    private void emptyFields() throws Exception {
        EmailValidation vd = new EmailValidation();
        if ("".equals(txtUserID.getText())) {
            throw new Exception("Empty user ID");
        }
        if("".equals(txtNewPass.getPassword())){
            throw new Exception("Empty new password");
        }
        if("".equals(txtConfirmPass.getPassword())){
            throw new Exception("Empty new password");
        }
        if("".equals(txtEmail.getText())){
            throw new Exception("Empty new email");
        }
        if (vd.runValidate(txtEmail, false)) {
            throw new Exception("Invalid email address format");
        }
    }
    private void highlightEmpty(){
        if ("".equals(txtUserID.getText())) {
            lblUserID.setForeground(Color.RED);
        }
        if ("".equals(String.valueOf(txtNewPass.getPassword()))) {
            lblNewPass.setForeground(Color.RED);
        }
        if ("".equals(String.valueOf(txtConfirmPass.getPassword()))) {
            lblConfirmPass.setForeground(Color.RED);
        }
        if ("".equals(txtEmail.getText())) {
            lblEmail.setForeground(Color.RED);
        }
    }
    private void deHighlightEmpty(){
        lblUserID.setForeground(ogtxt);
        lblEmail.setForeground(ogtxt);
        lblNewPass.setForeground(ogtxt);
        lblConfirmPass.setForeground(ogtxt);
        
    }
     private void inputCharacterValidation(){
        txtNewPass.getDocument().addDocumentListener(new APUDocumentListener() {
            APUPasswordValidation vd = new APUPasswordValidation();
            @Override
            public void changedUpdate(DocumentEvent e){
                vd.runValidate(txtNewPass);
                vd.setRegex("test");
                vd.getRegex();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                vd.runValidate(txtNewPass);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                vd.runValidate(txtNewPass);
            }
            
        });
        txtConfirmPass.getDocument().addDocumentListener(new APUDocumentListener() {
            APUPasswordValidation vd = new APUPasswordValidation();
            @Override
            public void changedUpdate(DocumentEvent e){
                vd.runValidate(txtConfirmPass);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                vd.runValidate(txtConfirmPass);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                vd.runValidate(txtConfirmPass);
            }
        });
        txtUserID.getDocument().addDocumentListener(new APUDocumentListener() {
            UserIDValidation vd = new UserIDValidation();
            @Override
            public void changedUpdate(DocumentEvent e){
                vd.runValidate(txtUserID);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                vd.runValidate(txtUserID);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                vd.runValidate(txtUserID);
            }
        });
    }
    
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        
            deHighlightEmpty();
            loadUserProfile();
            updatePassword();

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:
        EmailValidation vd = new EmailValidation();     
        vd.runValidate(txtEmail, true);
    }//GEN-LAST:event_txtEmailFocusLost

    private void clearCache(){
        try {  
            FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
            File cache = new File(FileDir + "UserCache.txt");
            if (cache.exists()) {
                cache.delete();
            }
        } catch (Exception ex) {
            
        }
    }
   private void initForm(){
        this.setSize(1170,750);
        this.setLocation(600,150);
        // Set the initial value for new book
        // This anon class handles window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Closing Window", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (selection == JOptionPane.YES_OPTION) {
                   clearCache();
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        inputCharacterValidation();
     }
    
    
    
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
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Fail Look and Feel");
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNewPass;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JPanel pnlFeedback;
    private javax.swing.JPasswordField txtConfirmPass;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JTextField txtUserID;
    // End of variables declaration//GEN-END:variables
}
