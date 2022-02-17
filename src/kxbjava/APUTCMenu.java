/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kxbjava;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class APUTCMenu extends javax.swing.JFrame {
    private String FileDir;
    /**
     * Creates new form APUTCMenu
     */
    public APUTCMenu() {
        initComponents();
        initForm();
    }

    private void setLogo() {
        String sourcefolder = System.getProperty("user.dir") + "\\src\\icons\\";
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(sourcefolder + "AHHASCrsmol.png"));
        this.setTitle("AHHASC Technician Home Page");

    }
    
     private void loadUserProfile() {
        String[] matchedID = null;
        FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
        File usertext = new File(FileDir + "UserCache.txt");
        Scanner intUser;
        try {
            intUser = new Scanner(usertext);
            while (intUser.hasNext()) {
                String bEntry = intUser.nextLine();
                matchedID = bEntry.split(":");
                lblDesc1.setText("Welcome Back "
                        + "\n" 
                        + matchedID[5] 
                        + "!");
            }
            intUser.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        lblTitle = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnHandlingTask = new javax.swing.JButton();
        btnProvideFeedback = new javax.swing.JButton();
        btnCollectPayment = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblDesc1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(68, 68, 68));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setBackground(new java.awt.Color(68, 68, 68));
        lblTitle.setFont(new java.awt.Font("Segoe UI Variable", 1, 38)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(214, 41, 99));
        lblTitle.setText("Technician Home Page");
        jPanel2.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        lblDesc.setBackground(new java.awt.Color(68, 68, 68));
        lblDesc.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc.setText("Please Select Your Choice");
        jPanel2.add(lblDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jPanel3.setBackground(new java.awt.Color(68, 68, 68));
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        btnHandlingTask.setBackground(new java.awt.Color(255, 102, 0));
        btnHandlingTask.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnHandlingTask.setForeground(new java.awt.Color(68, 68, 68));
        btnHandlingTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/task.png"))); // NOI18N
        btnHandlingTask.setBorder(null);
        btnHandlingTask.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHandlingTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHandlingTaskMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHandlingTaskMouseExited(evt);
            }
        });
        btnHandlingTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHandlingTaskActionPerformed(evt);
            }
        });
        jPanel3.add(btnHandlingTask);

        btnProvideFeedback.setBackground(new java.awt.Color(102, 51, 255));
        btnProvideFeedback.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnProvideFeedback.setForeground(new java.awt.Color(68, 68, 68));
        btnProvideFeedback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/feedback.png"))); // NOI18N
        btnProvideFeedback.setBorder(null);
        btnProvideFeedback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProvideFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProvideFeedbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProvideFeedbackMouseExited(evt);
            }
        });
        btnProvideFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProvideFeedbackActionPerformed(evt);
            }
        });
        jPanel3.add(btnProvideFeedback);

        btnCollectPayment.setBackground(new java.awt.Color(0, 153, 0));
        btnCollectPayment.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnCollectPayment.setForeground(new java.awt.Color(68, 68, 68));
        btnCollectPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/dollar.png"))); // NOI18N
        btnCollectPayment.setBorder(null);
        btnCollectPayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCollectPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCollectPaymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCollectPaymentMouseExited(evt);
            }
        });
        btnCollectPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollectPaymentActionPerformed(evt);
            }
        });
        jPanel3.add(btnCollectPayment);

        btnProfile.setBackground(new java.awt.Color(255, 46, 99));
        btnProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/programmer.png"))); // NOI18N
        btnProfile.setBorder(null);
        btnProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProfileMouseExited(evt);
            }
        });
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });
        jPanel3.add(btnProfile);

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 520, 480));

        btnLogout.setBackground(new java.awt.Color(68, 68, 68));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/signouty.png"))); // NOI18N
        btnLogout.setBorder(null);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 50, 100, 100));

        lblDesc1.setBackground(new java.awt.Color(68, 68, 68));
        lblDesc1.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        lblDesc1.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesc1.setText("Welcome Back!");
        jPanel2.add(lblDesc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 600, 80));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    private void initForm(){
        this.setLocationRelativeTo(null);
        setLogo();
        loadUserProfile();
        //userIncrementor();
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
    
    private void btnCollectPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollectPaymentActionPerformed
        new ViewPayment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCollectPaymentActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        // TODO add your handling code here:
        new APUUserProfile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnHandlingTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHandlingTaskActionPerformed
        // TODO add your handling code here:
        new APUHandleTask().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHandlingTaskActionPerformed

    private void btnHandlingTaskMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHandlingTaskMouseEntered
        lblDesc.setText("Handling Tasks");
    }//GEN-LAST:event_btnHandlingTaskMouseEntered

    private void btnHandlingTaskMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHandlingTaskMouseExited
        lblDesc.setText("Please Select Your Choice");
    }//GEN-LAST:event_btnHandlingTaskMouseExited

    private void btnProvideFeedbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProvideFeedbackMouseEntered
        lblDesc.setText("View Customer Feedback");
    }//GEN-LAST:event_btnProvideFeedbackMouseEntered

    private void btnProvideFeedbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProvideFeedbackMouseExited
        lblDesc.setText("Please Select Your Choice");
    }//GEN-LAST:event_btnProvideFeedbackMouseExited

    private void btnCollectPaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCollectPaymentMouseEntered
        lblDesc.setText("View Payments Made");
    }//GEN-LAST:event_btnCollectPaymentMouseEntered

    private void btnCollectPaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCollectPaymentMouseExited
        lblDesc.setText("Please Select Your Choice");
    }//GEN-LAST:event_btnCollectPaymentMouseExited

    private void btnProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfileMouseEntered
        lblDesc.setText("View Your Profile");
    }//GEN-LAST:event_btnProfileMouseEntered

    private void btnProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfileMouseExited
        lblDesc.setText("Please Select Your Choice");
    }//GEN-LAST:event_btnProfileMouseExited

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int selection = JOptionPane.showConfirmDialog(null, "Logging out. Are you sure to continue?", "Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (selection == JOptionPane.YES_OPTION) {
            clearCache();
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnProvideFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProvideFeedbackActionPerformed
        new ViewFeedback().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProvideFeedbackActionPerformed
                                           

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
                new APUTCMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCollectPayment;
    private javax.swing.JButton btnHandlingTask;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnProvideFeedback;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblDesc1;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
