/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kxbjava;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author User
 */
public class APUManageAppointment extends javax.swing.JFrame {

    private final String custSource = System.getProperty("user.dir") + "\\src\\TextFiles\\Customer.txt"; //Retrieving Directory of Appointment.txt File.
    private final String techSource = System.getProperty("user.dir") + "\\src\\TextFiles\\UserProfile.txt"; //Retrieving Directory of Appointment.txt File.
    private String FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
    private String uID, ApptID, app_status, booking_date;
    private DefaultComboBoxModel ApptList;

    /**
     * Creates new form APUManageAppointment
     */
    public APUManageAppointment() {
        initComponents();
        initForm();
    }

    //<editor-fold defaultstate="collapsed" desc="Methods">
    private void setLogo() {
        String sourcefolder = System.getProperty("user.dir") + "\\src\\icons\\";
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(sourcefolder + "AHHASCrsmol.png"));
        this.setTitle("AHHASC Manage Appointment Page");

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
                uID = matchedID[0];
                txtManagerID.setText(uID);
            }
            intUser.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setAppointmentID() {
        // This is to ensure the entire method have access to borrow matchedID array
        String[] matchedID = null;
        ApptList = new DefaultComboBoxModel();
        // Adding default text
        ApptList.addElement("Select Appointment ID");
        cmbAppID.setModel(ApptList);
        File appttxt = new File(FileDir + "Appointment.txt");

        Scanner intAppt;
        try {
            // This part loads all book information
            intAppt = new Scanner(appttxt);
            // This is to increment the discovered client assignment index
            int i = 0;
            // Read lines from the file until no more are left.
            while (intAppt.hasNext()) {
                // Read the next line.
                String bEntry = intAppt.nextLine();
                // Split the line by using the delimiterÂ ":" (semicolon) and store into array.
                matchedID = bEntry.split(":");
                if ("true".equals(matchedID[10]) && matchedID[0].contains("APPT")) {
                    ApptList.addElement(matchedID[0]);
                    i++;
                }

            }
            // OptionPane.showMessageDialog(null, i);
            intAppt.close();
            // Check if there are no appointments at all for each type
            if (ApptList.getSize() == 1) {
                ApptList.removeAllElements();
                ApptList.addElement("No appointments available.");
            }
            // Attempt to list all fetched client ID into the list box
            cmbAppID.setModel(ApptList);
            // Select index 0 as default
            cmbAppID.setSelectedIndex(0);

        } catch (FileNotFoundException ex) {
            //Logger.getLogger(unnamedBorrowMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void readCustData() {
        File file = new File(custSource);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] tableLines = br.lines().toArray();
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
                if (dataRow[0].contains("CUST") && "true".equals(dataRow[8])) {
                    cmbCustomerID.addItem(dataRow[0]);
                }
            }
            br.close();
        } catch (Exception e) {

        }

    }

    public final void readCustData(String SelectedCustID) {
        File file = new File(custSource);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] tableLines = br.lines().toArray();
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
                if (SelectedCustID.equals(dataRow[0])) {
                    cmbCustomerID.setSelectedItem(SelectedCustID);
                }
            }
            br.close();
        } catch (Exception e) {

        }

    }

    public final void readTechData(String SelectedTechID) {
        File file = new File(techSource);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] tableLines = br.lines().toArray();
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
                if (SelectedTechID.equals(dataRow[0])) {
                    cmbTechID.setSelectedItem(SelectedTechID);
                }

            }
            br.close();
        } catch (Exception e) {

        }

    }

    public final void readTechData() {
        File file = new File(techSource);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] tableLines = br.lines().toArray();
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
                if (dataRow[0].contains("TC") && "true".equals(dataRow[9])) {
                    cmbTechID.addItem(dataRow[0]);
                }

            }
            br.close();
        } catch (Exception e) {

        }

    }
//

    private void updateData() throws Exception {

        try {
            //emptyFields();
            File appOri = new File(FileDir + "Appointment.txt");
            File appBack = new File(FileDir + "AppointmentBack.txt");

            if (!appBack.exists()) {
                appOri.createNewFile();
            }

            appOri.renameTo(appBack);

            FileWriter cd = new FileWriter(FileDir + "Appointment.txt");
            PrintWriter cdp = new PrintWriter(cd);
            File appTxt = new File(FileDir + "AppointmentBack.txt");
            Scanner inputFile = new Scanner(appTxt);
            String[] matchedID;
            while (inputFile.hasNext()) {

                String bEntry = inputFile.nextLine();
                matchedID = bEntry.split(":");
                if (matchedID[0].equals(ApptID)) {

                    matchedID[0] = cmbAppID.getSelectedItem().toString();
                    matchedID[1] = cmbCustomerID.getSelectedItem().toString();
                    matchedID[2] = cmbTechID.getSelectedItem().toString();
                    matchedID[3] = txtManagerID.getText();
                    matchedID[4] = txtCustName.getText();
                    Date selectedDate = appDateChooser.getDate();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    matchedID[5] = sdf.format(selectedDate);
                    matchedID[6] = cmbTime.getSelectedItem().toString();
                    matchedID[7] = cmbAppliance.getSelectedItem().toString();
                    matchedID[8] = booking_date;
                    matchedID[9] = app_status;
                    matchedID[10] = "true";

                }
                cdp.println(matchedID[0] + ":"
                        + matchedID[1] + ":"
                        + matchedID[2] + ":"
                        + matchedID[3] + ":"
                        + matchedID[4] + ":"
                        + matchedID[5] + ":"
                        + matchedID[6] + ":"
                        + matchedID[7] + ":"
                        + matchedID[8] + ":"
                        + matchedID[9] + ":"
                        + matchedID[10]);

            }
            inputFile.close();
            appBack.delete();
            cdp.close();
            JOptionPane.showMessageDialog(null, "Customer has paid for the service, balance is: ", "Payment made", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            //highlightEmpty();
            JOptionPane.showMessageDialog(null, "Invalid input! Please check your input to proceed.", "Invalid insertion detected!", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void deleteData() throws Exception {

        try {
            //emptyFields();
            File appOri = new File(FileDir + "Appointment.txt");
            File appBack = new File(FileDir + "AppointmentBack.txt");

            if (!appBack.exists()) {
                appOri.createNewFile();
            }

            appOri.renameTo(appBack);

            FileWriter cd = new FileWriter(FileDir + "Appointment.txt");
            PrintWriter cdp = new PrintWriter(cd);
            File appTxt = new File(FileDir + "AppointmentBack.txt");
            Scanner inputFile = new Scanner(appTxt);
            String[] matchedID;
            while (inputFile.hasNext()) {

                String bEntry = inputFile.nextLine();
                matchedID = bEntry.split(":");
                if (matchedID[0].equals(ApptID)) {
                    matchedID[10] = "false";

                }
                cdp.println(matchedID[0] + ":"
                        + matchedID[1] + ":"
                        + matchedID[2] + ":"
                        + matchedID[3] + ":"
                        + matchedID[4] + ":"
                        + matchedID[5] + ":"
                        + matchedID[6] + ":"
                        + matchedID[7] + ":"
                        + matchedID[8] + ":"
                        + matchedID[9] + ":"
                        + matchedID[10]);

            }
            inputFile.close();
            appBack.delete();
            cdp.close();
            JOptionPane.showMessageDialog(null, "Appointment Has Been Successfully Deleted", "Payment made", JOptionPane.INFORMATION_MESSAGE);
            setAppointmentID();
            cmbAppID.setSelectedIndex(0);
            cmbCustomerID.setSelectedIndex(0);
            cmbTechID.setSelectedIndex(0);
            txtManagerID.setText("");
            txtCustName.setText("");
            appDateChooser.setDate(null);
            cmbTime.setSelectedIndex(0);
            cmbAppliance.setSelectedIndex(0);

        } catch (IOException e) {
            //highlightEmpty();
            JOptionPane.showMessageDialog(null, "Unable Delete Appointment", "Error Occured!", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void loadApptInfo() throws ParseException {
        // Assigning the cID to the selected index value
        ApptID = (String) cmbAppID.getSelectedItem();
        // This is to ensure the entire method have access to borrow matchedID array
        String[] matchedID = null;
        FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
        // For debugging purpose only
        // JOptionPane.showMessageDialog(null, bID);
        File appttxt = new File(FileDir + "Appointment.txt");
        Scanner intAppt;
        try {
            // This part loads all book information
            intAppt = new Scanner(appttxt);
            // Read lines from the file until no more are left.
            while (intAppt.hasNext()) {
                // Read the next line.
                String bEntry = intAppt.nextLine();
                // Split the line by using the delimiter ":" (semicolon) and store into array.
                matchedID = bEntry.split(":");
                // JOptionPane.showMessageDialog(null, i);
                if (cmbAppID.getSelectedItem().equals(matchedID[0])) {
                    ApptID = matchedID[0];
                    readCustData(matchedID[1]);
                    readTechData(matchedID[2]);
                    txtManagerID.setText(matchedID[3]);
                    txtCustName.setText(matchedID[4]);
                    java.util.Date sdf = new SimpleDateFormat("dd-MM-yyyy").parse(matchedID[5]);
                    appDateChooser.setDate(sdf);
                    cmbTime.setSelectedItem(matchedID[6]);
                    cmbAppliance.setSelectedItem(matchedID[7]);
                    booking_date = matchedID[8];
                    app_status = matchedID[9];

                }
            }
            intAppt.close();
        } catch (FileNotFoundException ex) {
            // Logger.getLogger(unnamedBorrowMenu.class.getName()).log(Level.SEVERE, null, ex);
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

    private void initForm() {
        this.setLocationRelativeTo(null);
        setLogo();
        loadUserProfile();
        setAppointmentID();
        readCustData();
        readTechData();
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        appDateChooser.setEnabled(false);
        appDateChooser.getCalendarButton().setEnabled(true);
        appDateChooser.setMinSelectableDate(new Date());
        // Set the initial value for new book
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
        // txaHomeAddress.getDocument().putProperty("filterNewlines", Boolean.TRUE);
        //  inputCharacterValidation();
    }

    // </editor-fold>
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlApp = new javax.swing.JPanel();
        btnPnl = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblDesc = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblApptID = new javax.swing.JLabel();
        cmbAppID = new javax.swing.JComboBox<>();
        lblApptID1 = new javax.swing.JLabel();
        cmbCustomerID = new javax.swing.JComboBox<>();
        cmbAppliance = new javax.swing.JComboBox<>();
        cmbTime = new javax.swing.JComboBox<>();
        lblApptID2 = new javax.swing.JLabel();
        lblApptID3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblApptID4 = new javax.swing.JLabel();
        lblApptID5 = new javax.swing.JLabel();
        txtCustName = new javax.swing.JTextField();
        txtManagerID = new javax.swing.JTextField();
        cmbTechID = new javax.swing.JComboBox<>();
        appDateChooser = new com.toedter.calendar.JDateChooser();
        lblApptID6 = new javax.swing.JLabel();
        lblApptID7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlApp.setBackground(new java.awt.Color(68, 68, 68));
        pnlApp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPnl.setBackground(new java.awt.Color(68, 68, 68));

        btnReset.setBackground(new java.awt.Color(68, 68, 68));
        btnReset.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(237, 237, 237));
        btnReset.setText("Reset");
        btnReset.setToolTipText("Button to reset every fields");
        btnReset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(68, 68, 68));
        btnBack.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(237, 237, 237));
        btnBack.setText("Back");
        btnBack.setToolTipText("Button to reset every fields");
        btnBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(68, 68, 68));
        btnUpdate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(237, 237, 237));
        btnUpdate.setText("Update");
        btnUpdate.setToolTipText("Button to reset every fields");
        btnUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(68, 68, 68));
        btnDelete.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(237, 237, 237));
        btnDelete.setText("Delete");
        btnDelete.setToolTipText("Button to reset every fields");
        btnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPnlLayout = new javax.swing.GroupLayout(btnPnl);
        btnPnl.setLayout(btnPnlLayout);
        btnPnlLayout.setHorizontalGroup(
            btnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPnlLayout.createSequentialGroup()
                .addContainerGap(317, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        btnPnlLayout.setVerticalGroup(
            btnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPnlLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(btnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pnlApp.add(btnPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 1280, 100));

        lblDesc.setBackground(new java.awt.Color(68, 68, 68));
        lblDesc.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc.setText("Select Your Appointment To Update");
        pnlApp.add(lblDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        lblTitle1.setBackground(new java.awt.Color(68, 68, 68));
        lblTitle1.setFont(new java.awt.Font("Segoe UI Variable", 1, 38)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(214, 41, 99));
        lblTitle1.setText("Manage Appointments");
        pnlApp.add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jPanel1.setBackground(new java.awt.Color(68, 68, 68));

        lblApptID.setFont(new java.awt.Font("Segoe UI Variable", 0, 24)); // NOI18N
        lblApptID.setForeground(new java.awt.Color(255, 255, 255));
        lblApptID.setText("Appointment ID");

        cmbAppID.setBackground(new java.awt.Color(68, 68, 68));
        cmbAppID.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        cmbAppID.setForeground(new java.awt.Color(255, 255, 255));
        cmbAppID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Appointment ID" }));
        cmbAppID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        cmbAppID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbAppID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAppIDActionPerformed(evt);
            }
        });

        lblApptID1.setFont(new java.awt.Font("Segoe UI Variable", 0, 24)); // NOI18N
        lblApptID1.setForeground(new java.awt.Color(255, 255, 255));
        lblApptID1.setText("Customer ID");

        cmbCustomerID.setBackground(new java.awt.Color(68, 68, 68));
        cmbCustomerID.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        cmbCustomerID.setForeground(new java.awt.Color(255, 255, 255));
        cmbCustomerID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Customer ID" }));
        cmbCustomerID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        cmbCustomerID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerIDActionPerformed(evt);
            }
        });

        cmbAppliance.setBackground(new java.awt.Color(68, 68, 68));
        cmbAppliance.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        cmbAppliance.setForeground(new java.awt.Color(255, 255, 255));
        cmbAppliance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Appliance", "Television", "Refrigerator", "Air-conditioner", "Washing Machine", "PC" }));
        cmbAppliance.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        cmbAppliance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbAppliance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbApplianceActionPerformed(evt);
            }
        });

        cmbTime.setBackground(new java.awt.Color(68, 68, 68));
        cmbTime.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        cmbTime.setForeground(new java.awt.Color(255, 255, 255));
        cmbTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Time", "0800", "1000", "1200", "1400", "1600", "1800" }));
        cmbTime.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        cmbTime.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTimeActionPerformed(evt);
            }
        });

        lblApptID2.setFont(new java.awt.Font("Segoe UI Variable", 0, 24)); // NOI18N
        lblApptID2.setForeground(new java.awt.Color(255, 255, 255));
        lblApptID2.setText("Appliance Type");

        lblApptID3.setFont(new java.awt.Font("Segoe UI Variable", 0, 24)); // NOI18N
        lblApptID3.setForeground(new java.awt.Color(255, 255, 255));
        lblApptID3.setText("Appointment Time");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApptID2)
                    .addComponent(cmbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApptID3)
                    .addComponent(lblApptID1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cmbAppliance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblApptID)
                    .addComponent(cmbAppID, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(lblApptID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAppID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblApptID1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblApptID2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAppliance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblApptID3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        cmbCustomerID.getAccessibleContext().setAccessibleName("260");
        cmbCustomerID.getAccessibleContext().setAccessibleDescription("35");
        cmbAppliance.getAccessibleContext().setAccessibleName("");
        cmbAppliance.getAccessibleContext().setAccessibleDescription("");
        cmbTime.getAccessibleContext().setAccessibleName("");
        cmbTime.getAccessibleContext().setAccessibleDescription("");

        pnlApp.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 630, 430));

        jPanel2.setBackground(new java.awt.Color(68, 68, 68));

        lblApptID4.setFont(new java.awt.Font("Segoe UI Variable", 0, 24)); // NOI18N
        lblApptID4.setForeground(new java.awt.Color(255, 255, 255));
        lblApptID4.setText("Technician ID");

        lblApptID5.setFont(new java.awt.Font("Segoe UI Variable", 0, 24)); // NOI18N
        lblApptID5.setForeground(new java.awt.Color(255, 255, 255));
        lblApptID5.setText("Customer Name");

        txtCustName.setEditable(false);
        txtCustName.setBackground(new java.awt.Color(68, 68, 68));
        txtCustName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCustName.setToolTipText("Customer Name");
        txtCustName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtCustName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustNameActionPerformed(evt);
            }
        });

        txtManagerID.setEditable(false);
        txtManagerID.setBackground(new java.awt.Color(68, 68, 68));
        txtManagerID.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtManagerID.setToolTipText("Manager ID");
        txtManagerID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));

        cmbTechID.setBackground(new java.awt.Color(68, 68, 68));
        cmbTechID.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        cmbTechID.setForeground(new java.awt.Color(255, 255, 255));
        cmbTechID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Technician ID" }));
        cmbTechID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        cmbTechID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbTechID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTechIDActionPerformed(evt);
            }
        });

        appDateChooser.setBackground(new java.awt.Color(68, 68, 68));
        appDateChooser.setForeground(new java.awt.Color(255, 255, 255));
        appDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                appDateChooserPropertyChange(evt);
            }
        });

        lblApptID6.setFont(new java.awt.Font("Segoe UI Variable", 0, 24)); // NOI18N
        lblApptID6.setForeground(new java.awt.Color(255, 255, 255));
        lblApptID6.setText("Manager ID");

        lblApptID7.setFont(new java.awt.Font("Segoe UI Variable", 0, 24)); // NOI18N
        lblApptID7.setForeground(new java.awt.Color(255, 255, 255));
        lblApptID7.setText("Appointment Date");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTechID, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApptID7)
                    .addComponent(txtManagerID, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApptID5)
                    .addComponent(lblApptID4)
                    .addComponent(lblApptID6))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblApptID4)
                .addGap(5, 5, 5)
                .addComponent(cmbTechID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblApptID5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblApptID6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtManagerID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblApptID7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        cmbTechID.getAccessibleContext().setAccessibleName("260");
        cmbTechID.getAccessibleContext().setAccessibleDescription("35");

        pnlApp.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 640, 430));

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

    private void cmbTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTimeActionPerformed
        // TODO add your handling code here:
        Date selectedDate = appDateChooser.getDate();
        if (cmbAppID.getSelectedIndex() > 0 && cmbCustomerID.getSelectedIndex() > 0 && cmbTechID.getSelectedIndex() > 0 && cmbAppliance.getSelectedIndex() > 0 && cmbTime.getSelectedIndex() > 0 && selectedDate != null) {
            btnUpdate.setEnabled(true);
            btnReset.setEnabled(true);
        } else {
            btnUpdate.setEnabled(false);
            btnReset.setEnabled(false);
        }
    }//GEN-LAST:event_cmbTimeActionPerformed

    private void cmbApplianceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbApplianceActionPerformed
        // TODO add your handling code here:
        Date selectedDate = appDateChooser.getDate();
        if (cmbAppID.getSelectedIndex() > 0 && cmbCustomerID.getSelectedIndex() > 0 && cmbTechID.getSelectedIndex() > 0 && cmbAppliance.getSelectedIndex() > 0 && cmbTime.getSelectedIndex() > 0 && selectedDate != null) {
            btnUpdate.setEnabled(true);
            btnReset.setEnabled(true);
        } else {
            btnUpdate.setEnabled(false);
            btnReset.setEnabled(false);
        }
    }//GEN-LAST:event_cmbApplianceActionPerformed

    private void appDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_appDateChooserPropertyChange
        // TODO add your handling code here:
        Date selectedDate = appDateChooser.getDate();
        if (cmbAppID.getSelectedIndex() > 0 && cmbCustomerID.getSelectedIndex() > 0 && cmbTechID.getSelectedIndex() > 0 && cmbAppliance.getSelectedIndex() > 0 && cmbTime.getSelectedIndex() > 0 && selectedDate != null) {
            btnUpdate.setEnabled(true);
            btnReset.setEnabled(true);
        } else {
            btnUpdate.setEnabled(false);
            btnReset.setEnabled(false);
        }
    }//GEN-LAST:event_appDateChooserPropertyChange

    private void txtCustNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustNameActionPerformed

    private void cmbCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerIDActionPerformed
//        readCustData(cmbCustomerID.getSelectedItem().toString());
        Date selectedDate = appDateChooser.getDate();
        if (cmbAppID.getSelectedIndex() > 0 && cmbCustomerID.getSelectedIndex() > 0 && cmbTechID.getSelectedIndex() > 0 && cmbAppliance.getSelectedIndex() > 0 && cmbTime.getSelectedIndex() > 0 && selectedDate != null) {
            btnUpdate.setEnabled(true);
            btnReset.setEnabled(true);
        } else {
            btnUpdate.setEnabled(false);
            btnReset.setEnabled(false);
        }
    }//GEN-LAST:event_cmbCustomerIDActionPerformed

    private void cmbTechIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTechIDActionPerformed
        // TODO add your handling code here:
        Date selectedDate = appDateChooser.getDate();
        if (cmbAppID.getSelectedIndex() > 0 && cmbCustomerID.getSelectedIndex() > 0 && cmbTechID.getSelectedIndex() > 0 && cmbAppliance.getSelectedIndex() > 0 && cmbTime.getSelectedIndex() > 0 && selectedDate != null) {
            btnUpdate.setEnabled(true);
            btnReset.setEnabled(true);
        } else {
            btnUpdate.setEnabled(false);
            btnReset.setEnabled(false);
        }

    }//GEN-LAST:event_cmbTechIDActionPerformed

    private void cmbAppIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAppIDActionPerformed
        if (cmbAppID.getSelectedIndex() > 0 && cmbAppID.getSelectedIndex() > 0) {
            try {
                loadApptInfo();
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
            } catch (ParseException ex) {
                Logger.getLogger(APUManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            btnUpdate.setEnabled(false);
            btnReset.setEnabled(false);
            btnDelete.setEnabled(false);

        }
    }//GEN-LAST:event_cmbAppIDActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        try {
            loadApptInfo();
        } catch (ParseException ex) {
            Logger.getLogger(APUManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new APUCMMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            updateData();
        } catch (Exception ex) {
            Logger.getLogger(APUBookAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            deleteData();
        } catch (Exception ex) {
            Logger.getLogger(APUManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JPanel btnPnl;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbAppID;
    private javax.swing.JComboBox<String> cmbAppliance;
    private javax.swing.JComboBox<String> cmbCustomerID;
    private javax.swing.JComboBox<String> cmbTechID;
    private javax.swing.JComboBox<String> cmbTime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblApptID;
    private javax.swing.JLabel lblApptID1;
    private javax.swing.JLabel lblApptID2;
    private javax.swing.JLabel lblApptID3;
    private javax.swing.JLabel lblApptID4;
    private javax.swing.JLabel lblApptID5;
    private javax.swing.JLabel lblApptID6;
    private javax.swing.JLabel lblApptID7;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel pnlApp;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtManagerID;
    // End of variables declaration//GEN-END:variables
}
