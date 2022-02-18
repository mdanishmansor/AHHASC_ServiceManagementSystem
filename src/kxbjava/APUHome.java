/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kxbjava;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Toolkit;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class APUHome extends javax.swing.JFrame {

    /**
     * Creates new form APUHome
     */
    public APUHome() {
        initComponents();
        initForm();
    }
    
    private void setLogo() {
        String sourcefolder = System.getProperty("user.dir") + "\\src\\icons\\";
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(sourcefolder + "AHHASCrsmol.png"));
        this.setTitle("AHHASC Homepage");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHome = new javax.swing.JPanel();
        lblDesc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnPnl = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlHome.setBackground(new java.awt.Color(68, 68, 68));
        pnlHome.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDesc.setBackground(new java.awt.Color(68, 68, 68));
        lblDesc.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc.setText("APU Hostel Home Appliances Service Centre");
        pnlHome.add(lblDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.gif"))); // NOI18N
        pnlHome.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 500, 531));

        lblTitle.setBackground(new java.awt.Color(68, 68, 68));
        lblTitle.setFont(new java.awt.Font("Arial", 1, 38)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(214, 41, 99));
        lblTitle.setText("Welcome To AHHASC");
        pnlHome.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        btnPnl.setBackground(new java.awt.Color(68, 68, 68));

        btnLogin.setBackground(new java.awt.Color(68, 68, 68));
        btnLogin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Start");
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPnlLayout = new javax.swing.GroupLayout(btnPnl);
        btnPnl.setLayout(btnPnlLayout);
        btnPnlLayout.setHorizontalGroup(
            btnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPnlLayout.createSequentialGroup()
                .addContainerGap(1031, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        btnPnlLayout.setVerticalGroup(
            btnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPnlLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pnlHome.add(btnPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 1280, 100));

        getContentPane().add(pnlHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        new APULogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void initForm(){
        this.setLocationRelativeTo(null);
        setLogo();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
             try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new APUHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel btnPnl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlHome;
    // End of variables declaration//GEN-END:variables
}
