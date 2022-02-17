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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class APUCMMenu extends javax.swing.JFrame {

    private String FileDir;

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
        jPanel3 = new javax.swing.JPanel();
        btnManageProfile = new javax.swing.JButton();
        btnManageFeedback2 = new javax.swing.JButton();
        btnManagePayment = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnBookAppointment = new javax.swing.JButton();
        btnManageAppointment = new javax.swing.JButton();
        btnManageCustomer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblDesc1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(68, 68, 68));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDesc.setBackground(new java.awt.Color(68, 68, 68));
        lblDesc.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc.setText("Please Select Your Choice");
        jPanel1.add(lblDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        lblTitle.setBackground(new java.awt.Color(68, 68, 68));
        lblTitle.setFont(new java.awt.Font("Segoe UI Variable", 1, 38)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(214, 41, 99));
        lblTitle.setText("Centre Manager Home Page");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jPanel3.setBackground(new java.awt.Color(68, 68, 68));
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

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
        jPanel3.add(btnManageProfile);

        btnManageFeedback2.setBackground(new java.awt.Color(102, 0, 255));
        btnManageFeedback2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnManageFeedback2.setForeground(new java.awt.Color(37, 42, 52));
        btnManageFeedback2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/feedbackmanage.png"))); // NOI18N
        btnManageFeedback2.setBorder(null);
        btnManageFeedback2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageFeedback2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManageFeedback2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManageFeedback2MouseExited(evt);
            }
        });
        btnManageFeedback2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageFeedback2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnManageFeedback2);

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
        jPanel3.add(btnManagePayment);

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
        jPanel3.add(btnProfile);

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
        jPanel3.add(btnBookAppointment);

        btnManageAppointment.setBackground(new java.awt.Color(153, 0, 51));
        btnManageAppointment.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnManageAppointment.setForeground(new java.awt.Color(37, 42, 52));
        btnManageAppointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/manager.png"))); // NOI18N
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
        jPanel3.add(btnManageAppointment);

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
        jPanel3.add(btnManageCustomer);

        jPanel2.setBackground(new java.awt.Color(68, 68, 68));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel2);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 830, 400));

        lblDesc1.setBackground(new java.awt.Color(68, 68, 68));
        lblDesc1.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        lblDesc1.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc1.setText("Welcome Back!");
        jPanel1.add(lblDesc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 400, -1, -1));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageProfileActionPerformed
        // TODO add your handling code here:
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManagePaymentActionPerformed

    private void btnManageFeedback2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageFeedback2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManageFeedback2ActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        // TODO add your handling code here:
        new APUUserProfile().setVisible(true);
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

    private void btnManageFeedback2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageFeedback2MouseEntered
        lblDesc.setText("View and Manage Feedback");
    }//GEN-LAST:event_btnManageFeedback2MouseEntered

    private void btnManageFeedback2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageFeedback2MouseExited
        lblDesc.setText("Please Select Your Choice");
    }//GEN-LAST:event_btnManageFeedback2MouseExited

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
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageAppointment;
    private javax.swing.JButton btnManageCustomer;
    private javax.swing.JButton btnManageFeedback2;
    private javax.swing.JButton btnManagePayment;
    private javax.swing.JButton btnManageProfile;
    private javax.swing.JButton btnProfile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblDesc1;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
