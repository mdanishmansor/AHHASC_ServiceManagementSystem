/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kxbjava;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class APUTCMenu extends javax.swing.JFrame {

    /**
     * Creates new form APUTCMenu
     */
    public APUTCMenu() {
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
        btnCollectPayment = new javax.swing.JButton();
        btnProvideFeedback = new javax.swing.JButton();
        btnHandlingTask = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(68, 68, 68));

        btnCollectPayment.setBackground(new java.awt.Color(8, 217, 214));
        btnCollectPayment.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnCollectPayment.setForeground(new java.awt.Color(68, 68, 68));
        btnCollectPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/dollar.png"))); // NOI18N
        btnCollectPayment.setText("Collect Payment");
        btnCollectPayment.setBorder(null);
        btnCollectPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollectPaymentActionPerformed(evt);
            }
        });

        btnProvideFeedback.setBackground(new java.awt.Color(8, 217, 214));
        btnProvideFeedback.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnProvideFeedback.setForeground(new java.awt.Color(68, 68, 68));
        btnProvideFeedback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/feedback.png"))); // NOI18N
        btnProvideFeedback.setText("Provide Feedback");
        btnProvideFeedback.setBorder(null);

        btnHandlingTask.setBackground(new java.awt.Color(8, 217, 214));
        btnHandlingTask.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnHandlingTask.setForeground(new java.awt.Color(68, 68, 68));
        btnHandlingTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/task.png"))); // NOI18N
        btnHandlingTask.setText("Handling Task");
        btnHandlingTask.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(btnCollectPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(btnProvideFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(453, 453, 453)
                        .addComponent(btnHandlingTask, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(367, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProvideFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCollectPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(btnHandlingTask, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
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

    private void btnCollectPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollectPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCollectPaymentActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Fail Look and Feel");
        }
        //</editor-fold>

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
    private javax.swing.JButton btnProvideFeedback;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
