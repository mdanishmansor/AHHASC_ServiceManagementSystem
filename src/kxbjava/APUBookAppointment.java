/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kxbjava;

import com.formdev.flatlaf.FlatDarkLaf;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class APUBookAppointment extends javax.swing.JFrame {

    /**
     * Creates new form APUBookAppointment
     */
    private String source = System.getProperty("user.dir") + "\\src\\TextFiles\\Appointment.txt"; //Retrieving Directory of Appointment.txt File.
    private String generatedStaffID;
    final DecimalFormat idformat = new DecimalFormat("000");

    public APUBookAppointment() {
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
        txtAppDate = new javax.swing.JTextField();
        cmbCustomerID = new javax.swing.JComboBox<>();
        cmbTechID = new javax.swing.JComboBox<>();
        txtCustName = new javax.swing.JTextField();
        txtManagerID = new javax.swing.JTextField();
        cmbAppliance = new javax.swing.JComboBox<>();
        btnBook = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        cmbTime = new javax.swing.JComboBox<>();
        appDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(68, 68, 68));
        jPanel1.setToolTipText("");

        lblTitle.setBackground(new java.awt.Color(68, 68, 68));
        lblTitle.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(218, 0, 55));
        lblTitle.setText("Book Appointment");

        txtAppDate.setBackground(new java.awt.Color(68, 68, 68));
        txtAppDate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtAppDate.setText("08/02/2001");
        txtAppDate.setToolTipText("");
        txtAppDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtAppDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAppDateActionPerformed(evt);
            }
        });

        cmbCustomerID.setBackground(new java.awt.Color(8, 217, 214));
        cmbCustomerID.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmbCustomerID.setForeground(new java.awt.Color(37, 42, 52));
        cmbCustomerID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Customer ID", "TestCustID001", "TestCustID002", "TestCustID003" }));
        cmbCustomerID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        cmbTechID.setBackground(new java.awt.Color(8, 217, 214));
        cmbTechID.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmbTechID.setForeground(new java.awt.Color(37, 42, 52));
        cmbTechID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Technician ID", "TestTechID001", "TestTechID002", "TestTechID003" }));
        cmbTechID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        txtCustName.setBackground(new java.awt.Color(68, 68, 68));
        txtCustName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCustName.setText("Customer Name");
        txtCustName.setToolTipText("");
        txtCustName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtCustName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustNameActionPerformed(evt);
            }
        });

        txtManagerID.setEditable(false);
        txtManagerID.setBackground(new java.awt.Color(68, 68, 68));
        txtManagerID.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtManagerID.setText("Manager001");
        txtManagerID.setToolTipText("");
        txtManagerID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtManagerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManagerIDActionPerformed(evt);
            }
        });

        cmbAppliance.setBackground(new java.awt.Color(8, 217, 214));
        cmbAppliance.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmbAppliance.setForeground(new java.awt.Color(37, 42, 52));
        cmbAppliance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Appliance", "Television", "Refrigerator", "Air-conditioner", "Washing Machine", "PC" }));
        cmbAppliance.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        btnBook.setBackground(new java.awt.Color(255, 46, 99));
        btnBook.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 46, 99));
        btnReset.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnReset.setText("Reset");

        cmbTime.setBackground(new java.awt.Color(8, 217, 214));
        cmbTime.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmbTime.setForeground(new java.awt.Color(37, 42, 52));
        cmbTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Time", "0800", "1000", "1200", "1400", "1600", "1800" }));
        cmbTime.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(477, 477, 477)
                        .addComponent(lblTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(488, 488, 488)
                        .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbAppliance, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtManagerID, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAppDate, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTechID, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(appDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(302, 302, 302))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(lblTitle)
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTechID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtManagerID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAppDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(cmbAppliance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBook)
                    .addComponent(btnReset))
                .addGap(29, 29, 29))
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

    private void txtAppDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAppDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAppDateActionPerformed

    private void txtCustNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustNameActionPerformed

    private void txtManagerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManagerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManagerIDActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        IDincrement();
        insertData();
    }//GEN-LAST:event_btnBookActionPerformed

    private void IDincrement() {
        int countLine = 1;
        try {

            File APtxt = new File(source);
            FileReader fr = new FileReader(APtxt);
            BufferedReader br = new BufferedReader(fr);
            String list;

            while ((list = br.readLine()) != null) { //Counts the total amount of lines in the text file.
                countLine++;
            }

            generatedStaffID = "APID" + idformat.format(countLine);

        } catch (Exception e) {

        }

    }

    private void insertData() {

        try {
            File file = new File(source);
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bf = new BufferedWriter(fw);

            String appointment_id = generatedStaffID;
            String customer_id = cmbCustomerID.getSelectedItem().toString();
            String technician_id = cmbTechID.getSelectedItem().toString(); 
            String customer_name = txtCustName.getText();
            String manager_id = txtManagerID.getText();
            Date selectedDate = appDateChooser.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            String appointment_date = sdf.format(selectedDate);
            String appointment_time = cmbTime.getSelectedItem().toString();
            String appliance_name = cmbAppliance.getSelectedItem().toString();

            String datalist
                    = appointment_id + "::"
                    + customer_id + "::"
                    + technician_id + "::"
                    + customer_name + "::"
                    + manager_id + "::"
                    + appointment_date + "::"
                    + appointment_time + "::"
                    + appliance_name
                    + "\n";

            bf.write(datalist); //Writes the Values From The Variables to the Appointment.txt File.
            bf.close();
        } catch (IOException e) {
        }

    }

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
                new APUBookAppointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser appDateChooser;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cmbAppliance;
    private javax.swing.JComboBox<String> cmbCustomerID;
    private javax.swing.JComboBox<String> cmbTechID;
    private javax.swing.JComboBox<String> cmbTime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAppDate;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtManagerID;
    // End of variables declaration//GEN-END:variables
}
