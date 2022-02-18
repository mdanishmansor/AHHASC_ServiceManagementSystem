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
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class APUCMMenu extends javax.swing.JFrame {

    private String FileDir, uID;

    /**
     * Creates new form APUCMMenu
     */
    public APUCMMenu() {
        initComponents();
        initForm();
    }

    private void setLogo() {
        String sourcefolder = System.getProperty("user.dir") + "\\src\\icons\\";
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(sourcefolder + "AHHASCrsmol.png"));
        this.setTitle("AHHASC Technician Home Page");

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

    private void initForm() {
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

        jPanel1 = new javax.swing.JPanel();
        lblDesc = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        pnlBtn3 = new javax.swing.JPanel();
        btnManageProfile = new javax.swing.JButton();
        btnManageFeedback = new javax.swing.JButton();
        btnManagePayment = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnManageCustomer = new javax.swing.JButton();
        btnLoginRec = new javax.swing.JButton();
        lblDesc1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        pnlBtn1 = new javax.swing.JPanel();
        btnBookAppointment = new javax.swing.JButton();
        pnlBtn2 = new javax.swing.JPanel();
        btnViewAppointment = new javax.swing.JButton();
        btnManageAppointment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(68, 68, 68));
        jPanel1.setMinimumSize(new java.awt.Dimension(1270, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDesc.setBackground(new java.awt.Color(68, 68, 68));
        lblDesc.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc.setText("Please Select Your Choice");
        jPanel1.add(lblDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        lblTitle.setBackground(new java.awt.Color(68, 68, 68));
        lblTitle.setFont(new java.awt.Font("Arial", 1, 38)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(214, 41, 99));
        lblTitle.setText("Centre Manager Home Page");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        pnlBtn3.setBackground(new java.awt.Color(68, 68, 68));
        pnlBtn3.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        btnManageProfile.setBackground(new java.awt.Color(255, 102, 0));
        btnManageProfile.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnManageProfile.setForeground(new java.awt.Color(37, 42, 52));
        btnManageProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/man.png"))); // NOI18N
        btnManageProfile.setBorder(null);
        btnManageProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManageProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManageProfileMouseExited(evt);
            }
        });
        btnManageProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageProfileActionPerformed(evt);
            }
        });
        pnlBtn3.add(btnManageProfile);

        btnManageFeedback.setBackground(new java.awt.Color(102, 0, 255));
        btnManageFeedback.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnManageFeedback.setForeground(new java.awt.Color(37, 42, 52));
        btnManageFeedback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/feedbackmanage.png"))); // NOI18N
        btnManageFeedback.setBorder(null);
        btnManageFeedback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManageFeedbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManageFeedbackMouseExited(evt);
            }
        });
        btnManageFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageFeedbackActionPerformed(evt);
            }
        });
        pnlBtn3.add(btnManageFeedback);

        btnManagePayment.setBackground(new java.awt.Color(0, 102, 0));
        btnManagePayment.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnManagePayment.setForeground(new java.awt.Color(37, 42, 52));
        btnManagePayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/money.png"))); // NOI18N
        btnManagePayment.setBorder(null);
        btnManagePayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManagePayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManagePaymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManagePaymentMouseExited(evt);
            }
        });
        btnManagePayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagePaymentActionPerformed(evt);
            }
        });
        pnlBtn3.add(btnManagePayment);

        btnProfile.setBackground(new java.awt.Color(153, 153, 0));
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
        pnlBtn3.add(btnProfile);

        btnManageCustomer.setBackground(new java.awt.Color(153, 0, 153));
        btnManageCustomer.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnManageCustomer.setForeground(new java.awt.Color(37, 42, 52));
        btnManageCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/rating.png"))); // NOI18N
        btnManageCustomer.setBorder(null);
        btnManageCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManageCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManageCustomerMouseExited(evt);
            }
        });
        btnManageCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCustomerActionPerformed(evt);
            }
        });
        pnlBtn3.add(btnManageCustomer);

        btnLoginRec.setBackground(new java.awt.Color(0, 102, 204));
        btnLoginRec.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLoginRec.setForeground(new java.awt.Color(37, 42, 52));
        btnLoginRec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/lock.png"))); // NOI18N
        btnLoginRec.setBorder(null);
        btnLoginRec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoginRec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginRecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginRecMouseExited(evt);
            }
        });
        btnLoginRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginRecActionPerformed(evt);
            }
        });
        pnlBtn3.add(btnLoginRec);

        jPanel1.add(pnlBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 620, 400));

        lblDesc1.setBackground(new java.awt.Color(68, 68, 68));
        lblDesc1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblDesc1.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesc1.setText("Welcome Back!");
        jPanel1.add(lblDesc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 1260, 80));

        btnLogout.setBackground(new java.awt.Color(68, 68, 68));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/signouty.png"))); // NOI18N
        btnLogout.setBorder(null);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 50, 100, 100));

        pnlBtn1.setBackground(new java.awt.Color(68, 68, 68));
        pnlBtn1.setLayout(new java.awt.GridLayout(1, 1, 5, 5));

        btnBookAppointment.setBackground(new java.awt.Color(0, 153, 153));
        btnBookAppointment.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnBookAppointment.setForeground(new java.awt.Color(37, 42, 52));
        btnBookAppointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/appointments.png"))); // NOI18N
        btnBookAppointment.setBorder(null);
        btnBookAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBookAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBookAppointmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBookAppointmentMouseExited(evt);
            }
        });
        btnBookAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookAppointmentActionPerformed(evt);
            }
        });
        pnlBtn1.add(btnBookAppointment);

        jPanel1.add(pnlBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 210, 410, 198));

        pnlBtn2.setBackground(new java.awt.Color(68, 68, 68));
        pnlBtn2.setLayout(new java.awt.GridLayout(1, 2, 5, 5));

        btnViewAppointment.setBackground(new java.awt.Color(102, 0, 102));
        btnViewAppointment.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnViewAppointment.setForeground(new java.awt.Color(37, 42, 52));
        btnViewAppointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/isee.png"))); // NOI18N
        btnViewAppointment.setBorder(null);
        btnViewAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewAppointmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnViewAppointmentMouseExited(evt);
            }
        });
        btnViewAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAppointmentActionPerformed(evt);
            }
        });
        pnlBtn2.add(btnViewAppointment);

        btnManageAppointment.setBackground(new java.awt.Color(153, 0, 51));
        btnManageAppointment.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnManageAppointment.setForeground(new java.awt.Color(37, 42, 52));
        btnManageAppointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/calen.png"))); // NOI18N
        btnManageAppointment.setBorder(null);
        btnManageAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManageAppointmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManageAppointmentMouseExited(evt);
            }
        });
        btnManageAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageAppointmentActionPerformed(evt);
            }
        });
        pnlBtn2.add(btnManageAppointment);

        jPanel1.add(pnlBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 413, 410, 195));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageProfileActionPerformed
        new APUMUserProfile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnManageProfileActionPerformed

    private void btnBookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookAppointmentActionPerformed
        new APUBookAppointment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBookAppointmentActionPerformed

    private void btnManageAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAppointmentActionPerformed
        new APUManageAppointment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnManageAppointmentActionPerformed

    private void btnManagePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagePaymentActionPerformed
        try {
            new ManagePayment().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(APUCMMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnManagePaymentActionPerformed

    private void btnManageFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageFeedbackActionPerformed
        try {
            new ManageFeedback().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(APUCMMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnManageFeedbackActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        try {
            // TODO add your handling code here:
            new APUUserProfile().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(APUCMMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnManageCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCustomerActionPerformed
        // TODO add your handling code here:
        new APUManageCustomer().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnManageCustomerActionPerformed

    private void btnManageProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageProfileMouseEntered
        lblDesc.setText("Manage User Profile");
    }//GEN-LAST:event_btnManageProfileMouseEntered

    private void btnManageProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageProfileMouseExited
        lblDesc.setText("Please Select Your Choice");
    }//GEN-LAST:event_btnManageProfileMouseExited

    private void btnManageFeedbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageFeedbackMouseEntered
        lblDesc.setText("View and Manage Feedback");
    }//GEN-LAST:event_btnManageFeedbackMouseEntered

    private void btnManageFeedbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageFeedbackMouseExited
        lblDesc.setText("Please Select Your Choice");
    }//GEN-LAST:event_btnManageFeedbackMouseExited

    private void btnManagePaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagePaymentMouseEntered
        lblDesc.setText("View Payment");
    }//GEN-LAST:event_btnManagePaymentMouseEntered

    private void btnManagePaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagePaymentMouseExited
        lblDesc.setText("Please Select Your Choice");
    }//GEN-LAST:event_btnManagePaymentMouseExited

    private void btnBookAppointmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookAppointmentMouseEntered
        lblDesc.setText("Book Appointment");
    }//GEN-LAST:event_btnBookAppointmentMouseEntered

    private void btnBookAppointmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookAppointmentMouseExited
        lblDesc.setText("Please Select Your Choice");
    }//GEN-LAST:event_btnBookAppointmentMouseExited

    private void btnManageAppointmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageAppointmentMouseEntered
        lblDesc.setText("Manage Appointments");
    }//GEN-LAST:event_btnManageAppointmentMouseEntered

    private void btnManageAppointmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageAppointmentMouseExited
        lblDesc.setText("Please Select Your Choice");
    }//GEN-LAST:event_btnManageAppointmentMouseExited

    private void btnManageCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageCustomerMouseEntered
        lblDesc.setText("Manage Customers");
    }//GEN-LAST:event_btnManageCustomerMouseEntered

    private void btnManageCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageCustomerMouseExited
        lblDesc.setText("Please Select Your Choice");
    }//GEN-LAST:event_btnManageCustomerMouseExited

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

    private void btnLoginRecMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginRecMouseEntered
        lblDesc.setText("View Login Records");
    }//GEN-LAST:event_btnLoginRecMouseEntered

    private void btnLoginRecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginRecMouseExited
        lblDesc.setText("Please Select Your Choice");
    }//GEN-LAST:event_btnLoginRecMouseExited

    private void btnLoginRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginRecActionPerformed
        new LoginRecords().setVisible(true);
        this.dispose();    }//GEN-LAST:event_btnLoginRecActionPerformed

    private void btnViewAppointmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAppointmentMouseEntered
        lblDesc.setText("View Appointments");
    }//GEN-LAST:event_btnViewAppointmentMouseEntered

    private void btnViewAppointmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAppointmentMouseExited
        lblDesc.setText("Please Select Your Choice");
    }//GEN-LAST:event_btnViewAppointmentMouseExited

    private void btnViewAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAppointmentActionPerformed
        try {
            new ViewAppointment().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(APUCMMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose(); 
    }//GEN-LAST:event_btnViewAppointmentActionPerformed

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
                new APUCMMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookAppointment;
    private javax.swing.JButton btnLoginRec;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageAppointment;
    private javax.swing.JButton btnManageCustomer;
    private javax.swing.JButton btnManageFeedback;
    private javax.swing.JButton btnManagePayment;
    private javax.swing.JButton btnManageProfile;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnViewAppointment;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblDesc1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBtn1;
    private javax.swing.JPanel pnlBtn2;
    private javax.swing.JPanel pnlBtn3;
    // End of variables declaration//GEN-END:variables
}
