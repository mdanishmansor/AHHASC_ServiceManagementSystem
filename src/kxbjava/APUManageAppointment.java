/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kxbjava;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class APUManageAppointment extends javax.swing.JFrame {

    private String apptxtdir = System.getProperty("user.dir") + "\\src\\TextFiles\\Appointment.txt"; //Retrieving Directory of Appointment.txt File.
    String appID;
    String custID;
    String techID;
    String custName;
    String manID;
    String appDate;
    String appTime;
    String appType;

    /**
     * Creates new form APUManageAppointment
     */
    public APUManageAppointment() {
        initComponents();
        readData();
    }

    public final void readData() {
        File file = new File(apptxtdir);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String firstLine = br.readLine().trim();
            Object[] tableLines = br.lines().toArray();
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("::");
                cmbAppID.addItem(dataRow[0]);
            }
            br.close();
        } catch (Exception e) {

        }
    }

    public void InsertData(String appID) {
        File file = new File(apptxtdir);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            Object[] record = br.lines().toArray();
            for (int i = 0; i < record.length; i++) {
                String line = record[i].toString().trim();
                String[] dataRow = line.split("::");

                if (dataRow[0].equals(appID)) {
                    appID = dataRow[0];
                    txtCustomerID.setText(dataRow[1]);
                    cmbTechID.setSelectedItem(dataRow[2]);
                    txtCustName.setText(dataRow[3]);
                    txtManagerID.setText(dataRow[4]);
                    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dataRow[5]);
                    appDateChooser.setDate(date1);
                    cmbTime.setSelectedItem(dataRow[6]);
                    cmbAppliance.setSelectedItem(dataRow[7]);

                }

            }
            br.close();

        } catch (Exception e) {

        }
    }

    private void updateData() {

        try {

            File file = new File(apptxtdir);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String record;
            while ((record = br.readLine()) != null) { //Retrieving All Data Appointment.txt File.
                String[] dataRow = record.split("::");
                appID = dataRow[0];

                if (cmbAppID.getSelectedItem().equals(appID)) {
                    br.close();
                    String datalist
                            = appID + "::"
                            + txtCustomerID.getText() + "::"
                            + cmbTechID.getSelectedItem() + "::"
                            + txtCustName.getText() + "::"
                            + txtManagerID.getText() + "::"
                            + txtAppDate.getText() + "::"
                            + cmbTime.getSelectedItem() + "::"
                            + cmbAppliance.getSelectedItem() + "\n";
                    deleteData(appID, 1, datalist); //Removes Line of Empty Data.
                    sortData(); //Rearrange the Lines in Appointment.txt Alphabetically.

                }

            }

        } catch (IOException e) {
        }
    }

    private void deleteData(String removeterm, int positionOfTerm, String datalist) throws IOException {

        int position = positionOfTerm - 1; // Integer Value Assigned To Choose Which Column in a Line To Be Selected for Deletion.
        String tempFile = System.getProperty("user.dir") + "\\src\\TextFiles\\temp.txt"; //Creates A Temporary File Which Will Store the Updated Appointment.txt File.
        File oldFile = new File(apptxtdir);
        File newFile = new File(tempFile);
        String readData;
        String data[];

        try {

            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            FileReader fr = new FileReader(apptxtdir);
            BufferedReader br = new BufferedReader(fr);

            while ((readData = br.readLine()) != null) { //Data in Appointment.txt Will Be Inserted into data Array.
                data = readData.split("::");
                if (!(data[position].equalsIgnoreCase(removeterm))) { //Identify Which Line Contains the removeterm Value.
                    pw.println(readData); //Writes to the temp.txt File Without the Data of the Identified Line with the removeterm Value.
                }
            }

            bw.write(datalist); //Writes the Values From The Variables to the Appointment.txt File.
            bw.close();
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            fw.close();

            oldFile.delete();
            File dump = new File(apptxtdir);
            newFile.renameTo(dump); //Renames The temp.txt File to Appointment.txt.

        } catch (Exception e) {

            JFrame parent = new JFrame(); //Display Error Message.
            JOptionPane.showMessageDialog(parent, "Error Occured While Trying To Delete Data");
        }

    }

    public void deleteall() {
        File oldFile = new File(apptxtdir);
        oldFile.delete();

    }

    private void sortData() {

        try {

            Path path = Paths.get(apptxtdir);
            Charset charset = Charset.forName("UTF-8");

            List<String> lines = Files.readAllLines(path, charset);
            Collections.sort(lines, new IgnoreCase());

            Path toPath = Paths.get(apptxtdir);
            Files.write(toPath, lines, charset);

        } catch (IOException ex) {

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

        pnlApp = new javax.swing.JPanel();
        cmbTechID = new javax.swing.JComboBox<>();
        cmbAppID = new javax.swing.JComboBox<>();
        txtManagerID = new javax.swing.JTextField();
        txtCustomerID = new javax.swing.JTextField();
        txtCustName = new javax.swing.JTextField();
        txtBookDate = new javax.swing.JTextField();
        txtAppDate = new javax.swing.JTextField();
        cmbTime = new javax.swing.JComboBox<>();
        cmbAppliance = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        appDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlApp.setBackground(new java.awt.Color(68, 68, 68));

        cmbTechID.setBackground(new java.awt.Color(255, 46, 99));
        cmbTechID.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmbTechID.setForeground(new java.awt.Color(237, 237, 237));
        cmbTechID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Technician ID", "TestTechID001", "TestTechID002", "TestTechID003" }));

        cmbAppID.setBackground(new java.awt.Color(255, 46, 99));
        cmbAppID.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmbAppID.setForeground(new java.awt.Color(237, 237, 237));
        cmbAppID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Appointment ID" }));
        cmbAppID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAppIDActionPerformed(evt);
            }
        });

        txtManagerID.setEditable(false);
        txtManagerID.setBackground(new java.awt.Color(68, 68, 68));
        txtManagerID.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtManagerID.setForeground(new java.awt.Color(237, 237, 237));
        txtManagerID.setText("Manager ID");
        txtManagerID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));

        txtCustomerID.setEditable(false);
        txtCustomerID.setBackground(new java.awt.Color(68, 68, 68));
        txtCustomerID.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCustomerID.setForeground(new java.awt.Color(237, 237, 237));
        txtCustomerID.setText("Customer ID");
        txtCustomerID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));

        txtCustName.setBackground(new java.awt.Color(68, 68, 68));
        txtCustName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCustName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtCustName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustNameActionPerformed(evt);
            }
        });

        txtBookDate.setEditable(false);
        txtBookDate.setBackground(new java.awt.Color(68, 68, 68));
        txtBookDate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtBookDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtBookDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookDateActionPerformed(evt);
            }
        });

        txtAppDate.setEditable(false);
        txtAppDate.setBackground(new java.awt.Color(68, 68, 68));
        txtAppDate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtAppDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtAppDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAppDateActionPerformed(evt);
            }
        });

        cmbTime.setBackground(new java.awt.Color(255, 46, 99));
        cmbTime.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmbTime.setForeground(new java.awt.Color(237, 237, 237));
        cmbTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Time", "0800", "1000", "1200", "1400", "1600", "1800" }));
        cmbTime.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        cmbAppliance.setBackground(new java.awt.Color(255, 46, 99));
        cmbAppliance.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmbAppliance.setForeground(new java.awt.Color(237, 237, 237));
        cmbAppliance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Appliance", "Television", "Refrigerator", "Air-conditioner", "Washing Machine", "PC" }));
        cmbAppliance.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAppLayout = new javax.swing.GroupLayout(pnlApp);
        pnlApp.setLayout(pnlAppLayout);
        pnlAppLayout.setHorizontalGroup(
            pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAppLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAppLayout.createSequentialGroup()
                        .addComponent(cmbAppliance, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlAppLayout.createSequentialGroup()
                            .addComponent(txtAppDate, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                            .addComponent(cmbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlAppLayout.createSequentialGroup()
                            .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBookDate, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlAppLayout.createSequentialGroup()
                            .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(txtManagerID))
                        .addGroup(pnlAppLayout.createSequentialGroup()
                            .addComponent(cmbAppID, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbTechID, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAppLayout.createSequentialGroup()
                .addContainerGap(599, Short.MAX_VALUE)
                .addComponent(appDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(254, 254, 254))
        );
        pnlAppLayout.setVerticalGroup(
            pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAppLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAppID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTechID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtManagerID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBookDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(appDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAppDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAppLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(cmbAppliance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAppLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlApp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlApp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCustNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustNameActionPerformed

    private void txtAppDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAppDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAppDateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        updateData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbAppIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAppIDActionPerformed
        InsertData(cmbAppID.getSelectedItem().toString());
    }//GEN-LAST:event_cmbAppIDActionPerformed

    private void txtBookDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookDateActionPerformed

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
            java.util.logging.Logger.getLogger(APUManageAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(APUManageAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(APUManageAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(APUManageAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new APUManageAppointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser appDateChooser;
    private javax.swing.JComboBox<String> cmbAppID;
    private javax.swing.JComboBox<String> cmbAppliance;
    private javax.swing.JComboBox<String> cmbTechID;
    private javax.swing.JComboBox<String> cmbTime;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel pnlApp;
    private javax.swing.JTextField txtAppDate;
    private javax.swing.JTextField txtBookDate;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtManagerID;
    // End of variables declaration//GEN-END:variables
}
