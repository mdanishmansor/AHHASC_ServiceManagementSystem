/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kxbjava;

import com.formdev.flatlaf.FlatDarkLaf;
import com.itextpdf.io.exceptions.IOException;
import static com.itextpdf.kernel.colors.ColorConstants.BLACK;
import static com.itextpdf.kernel.colors.ColorConstants.BLUE;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import org.joda.money.Money;

/**
 *
 * @author User
 */
public class ManagePayment extends javax.swing.JFrame {

    private String FileDir, paymentID, apptID, techID, custName, apptDate, apptTime, appliance, paymentStatus, paymentDate, totalAmount, paymentAmount, balanceAmount;
    private boolean filter = false;
    private Money tAmount, pAmount, bAmount;
    private final Color ogtxt = new Color(237, 237, 237);

    /**
     * Creates new form ViewFeedback
     */
    public ManagePayment() throws java.io.IOException {
        initComponents();
        initForm();
    }

    private void setLogo() {
        String sourcefolder = System.getProperty("user.dir") + "\\src\\icons\\";
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(sourcefolder + "AHHASCrsmol.png"));
        this.setTitle("AHHASC Manage Appointment Payment Page");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFeedback = new javax.swing.JTable();
        txtFilter = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        txtPaymentAmount = new javax.swing.JTextField();
        txtTotalAmount = new javax.swing.JTextField();
        lblTotalAmount = new javax.swing.JLabel();
        lblFilter = new javax.swing.JLabel();
        lblPaymentAmount = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        btnPnl = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPnl.setBackground(new java.awt.Color(68, 68, 68));
        mainPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblFeedback.setBackground(new java.awt.Color(68, 68, 68));
        tblFeedback.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tblFeedback.setForeground(new java.awt.Color(237, 237, 237));
        tblFeedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment ID", "Appointment ID", "Technician ID", "Customer Name", "Appointment Date", "Appointment Time", "Appliance", "Payment Status", "Payment Date", "Total Amount", "Payment Amount", "Balance Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFeedbackMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFeedback);

        mainPnl.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 1268, 302));

        txtFilter.setBackground(new java.awt.Color(68, 68, 68));
        txtFilter.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtFilter.setForeground(new java.awt.Color(237, 237, 237));
        txtFilter.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtFilter.setCaretColor(new java.awt.Color(237, 237, 237));
        txtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilterActionPerformed(evt);
            }
        });
        mainPnl.add(txtFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 422, 50));

        btnFilter.setBackground(new java.awt.Color(68, 68, 68));
        btnFilter.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(237, 237, 237));
        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
        btnFilter.setBorder(null);
        btnFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        mainPnl.add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 50, 100, 100));

        txtPaymentAmount.setBackground(new java.awt.Color(68, 68, 68));
        txtPaymentAmount.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPaymentAmount.setForeground(new java.awt.Color(237, 237, 237));
        txtPaymentAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtPaymentAmount.setCaretColor(new java.awt.Color(237, 237, 237));
        mainPnl.add(txtPaymentAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, 422, 50));

        txtTotalAmount.setBackground(new java.awt.Color(68, 68, 68));
        txtTotalAmount.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtTotalAmount.setForeground(new java.awt.Color(237, 237, 237));
        txtTotalAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtTotalAmount.setCaretColor(new java.awt.Color(237, 237, 237));
        mainPnl.add(txtTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 422, 50));

        lblTotalAmount.setBackground(new java.awt.Color(68, 68, 68));
        lblTotalAmount.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTotalAmount.setForeground(new java.awt.Color(237, 237, 237));
        lblTotalAmount.setText("Total Amount");
        mainPnl.add(lblTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, -1, -1));

        lblFilter.setBackground(new java.awt.Color(68, 68, 68));
        lblFilter.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblFilter.setForeground(new java.awt.Color(237, 237, 237));
        lblFilter.setText("Filter");
        mainPnl.add(lblFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        lblPaymentAmount.setBackground(new java.awt.Color(68, 68, 68));
        lblPaymentAmount.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblPaymentAmount.setForeground(new java.awt.Color(237, 237, 237));
        lblPaymentAmount.setText("Payment Amount");
        mainPnl.add(lblPaymentAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, -1, -1));

        lblDesc.setBackground(new java.awt.Color(68, 68, 68));
        lblDesc.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc.setText("View and Update Payment Made By Customers");
        mainPnl.add(lblDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        lblTitle1.setBackground(new java.awt.Color(68, 68, 68));
        lblTitle1.setFont(new java.awt.Font("Arial", 1, 38)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(214, 41, 99));
        lblTitle1.setText("Manage Appointment Payments");
        mainPnl.add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        btnPnl.setBackground(new java.awt.Color(68, 68, 68));

        btnUpdate.setBackground(new java.awt.Color(68, 68, 68));
        btnUpdate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update Payment");
        btnUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
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

        javax.swing.GroupLayout btnPnlLayout = new javax.swing.GroupLayout(btnPnl);
        btnPnl.setLayout(btnPnlLayout);
        btnPnlLayout.setHorizontalGroup(
            btnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPnlLayout.createSequentialGroup()
                .addContainerGap(793, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        btnPnlLayout.setVerticalGroup(
            btnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPnlLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(btnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        mainPnl.add(btnPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 1280, 100));

        getContentPane().add(mainPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Button Events">   
    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed

        clearTable();
        try {
            if (filterPayment()) {
                JOptionPane.showMessageDialog(null, "Record(s) filtered accordingly", "Records Filtered!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No record(s) found according to the filter", "No Record(s)", JOptionPane.ERROR_MESSAGE);
                insertPaymentRecords();

            }
        } catch (java.io.IOException ex) {
            Logger.getLogger(ManagePayment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnFilterActionPerformed

    private void tblFeedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFeedbackMouseClicked
        // TODO add your handling code here:
        selectRow();
    }//GEN-LAST:event_tblFeedbackMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        deHighlightEmpty();
        try {
            updatePayment();
        } catch (java.io.IOException ex) {
            Logger.getLogger(ManagePayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        int selection = JOptionPane.showConfirmDialog(null, "Are you sure to go back?", "Back to Main Menu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (selection == JOptionPane.YES_OPTION) {
            new APUCMMenu().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFilterActionPerformed

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methods">   
    private void selectRow() {
        int i = tblFeedback.getSelectedRow();

        paymentID = tblFeedback.getValueAt(i, 0).toString();
        apptID = tblFeedback.getValueAt(i, 1).toString();
        techID = tblFeedback.getValueAt(i, 2).toString();
        custName = tblFeedback.getValueAt(i, 3).toString();
        apptDate = tblFeedback.getValueAt(i, 4).toString();
        apptTime = tblFeedback.getValueAt(i, 5).toString();
        appliance = tblFeedback.getValueAt(i, 6).toString();
        paymentStatus = tblFeedback.getValueAt(i, 7).toString();
        paymentDate = tblFeedback.getValueAt(i, 8).toString();
        totalAmount = tblFeedback.getValueAt(i, 9).toString();
        paymentAmount = tblFeedback.getValueAt(i, 10).toString();
        balanceAmount = tblFeedback.getValueAt(i, 11).toString();

        txtTotalAmount.setText(totalAmount.replaceAll("\\s", ""));
        txtPaymentAmount.setText(paymentAmount.replaceAll("\\s", ""));

    }
//    private void printRecords() throws IOException, FileNotFoundException{
//        
//           
//            PdfWriter writer = new PdfWriter(pdfsource);
//            PdfDocument pdfdoc = new PdfDocument(writer);
//            pdfdoc.setDefaultPageSize(PageSize.A4.rotate());
//            Document document = new Document(pdfdoc);
//            
//            Style titlestyle = new Style();
//            titlestyle.setBold()
//                      .setFontSize(18f)
//                      .setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER);
//            
//            String title = "Payment Records of the Customers";
//            Paragraph doctitle = new Paragraph(title).addStyle(titlestyle);
//            
//            float columnWidth[] = {30f,30f,30f,30f,30f,30f,30f,30f,30f,30f,30f,30f};
//            Table tbl = new Table(columnWidth);
//           // doc.addTitle("AHHASC");
//            document.add(doctitle);
//            tbl.addCell("Payment ID").setFontColor(new DeviceRgb(23, 23, 23));
//            tbl.addCell("Appointment ID").setFontColor(new DeviceRgb(23, 23, 23));
//            tbl.addCell("Technician ID").setFontColor(new DeviceRgb(23, 23, 23));
//            tbl.addCell("Customer Name").setFontColor(new DeviceRgb(23, 23, 23));
//            tbl.addCell("Appointment Date").setFontColor(new DeviceRgb(23, 23, 23));
//            tbl.addCell("Appointment Time").setFontColor(new DeviceRgb(23, 23, 23));
//            tbl.addCell("Appliance").setFontColor(new DeviceRgb(23, 23, 23));
//            tbl.addCell("Payment Status").setFontColor(new DeviceRgb(23, 23, 23));
//            tbl.addCell("Payment Date").setFontColor(new DeviceRgb(23, 23, 23));
//            tbl.addCell("Total Amount").setFontColor(new DeviceRgb(23, 23, 23));
//            tbl.addCell("Payment Amount").setFontColor(new DeviceRgb(23, 23, 23));
//            tbl.addCell("Balance Amount").setFontColor(new DeviceRgb(23, 23, 23));
//                    
//            
//            
//            for(int i = 0; i < tblFeedback.getRowCount(); i++){
//                String paymentID = tblFeedback.getValueAt(i, 0).toString();
//                String apptID = tblFeedback.getValueAt(i, 1).toString();
//                String techID = tblFeedback.getValueAt(i, 2).toString();
//                String custName = tblFeedback.getValueAt(i, 3).toString();
//                String apptDate = tblFeedback.getValueAt(i, 4).toString();
//                String apptTime = tblFeedback.getValueAt(i, 5).toString();
//                String appliance = tblFeedback.getValueAt(i, 6).toString();
//                String paymentStatus = tblFeedback.getValueAt(i, 7).toString();
//                String paymentDate = tblFeedback.getValueAt(i, 8).toString();
//                String totalAmount = tblFeedback.getValueAt(i, 9).toString();
//                String paymentAmount = tblFeedback.getValueAt(i, 10).toString();
//                String balanceAmount = tblFeedback.getValueAt(i, 11).toString();
//                
//                tbl.addCell(paymentID);
//                tbl.addCell(apptID);
//                tbl.addCell(techID);
//                tbl.addCell(custName);
//                tbl.addCell(apptDate);
//                tbl.addCell(apptTime);
//                tbl.addCell(appliance);
//                tbl.addCell(paymentStatus);
//                tbl.addCell(paymentDate);
//                tbl.addCell(totalAmount);
//                tbl.addCell(paymentAmount);
//                tbl.addCell(balanceAmount);
//                
//            }
//            
//           //write into the pdf
//           document.add(tbl);
//           document.close();
//        
//       JOptionPane.showMessageDialog(null, "Printed to PDF Successfully!", "Records Printed!", JOptionPane.INFORMATION_MESSAGE);
//    
//    }

    private void updatePayment() throws java.io.IOException {
        // TODO add your handling code here:
        try {
            // Check if textfields are empty
            emptyFields();
            // To get directory  
            FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
            // To get the book ID

            // To rename original book.txt to book.bak
            File paymentOri = new File(FileDir + "Payment.txt");
            File paymentBack = new File(FileDir + "PaymentBack.txt");
            // To check if clientBak.txt is present or not
            if (!paymentBack.exists()) {
                paymentOri.createNewFile();
            }
            // This is for debugging only!
            // JOptionPane.showMessageDialog(null, "renamed");
            // This is to rename the existing book.txt to clientBak.txt
            paymentOri.renameTo(paymentBack);
            // This is to open, find and replace a specific book record
            // Requires temporary file to store current state
            // FileWriter to write into a new file called book.txt
            FileWriter cd = new FileWriter(FileDir + "Payment.txt");
            // PrintWriter to print into book.txt
            PrintWriter cdp = new PrintWriter(cd);
            // This is to open and read clientBak.txt 
            File paymenttxt = new File(FileDir + "PaymentBack.txt");
            // This is to instantiate the file opened earlier
            Scanner inputFile = new Scanner(paymenttxt);
            // This array is to contain all lines
            String[] matchedID;
            // This is only for debugging!
            // boolean itWorked = false;
            // Read lines from the file until no more are left.
            while (inputFile.hasNext()) {
                // This is for debugging only!
                // JOptionPane.showMessageDialog(null, "In loop");
                // Read the next line.
                String bEntry = inputFile.nextLine();
                // Split the line by using the delimiter ":" (semicolon) and store into array.
                matchedID = bEntry.split(":");
                // Check if the read line has current book ID
                if (matchedID[0].equals(paymentID)) {

                    tAmount = Money.parse(txtTotalAmount.getText());
                    pAmount = Money.parse(txtPaymentAmount.getText());

                    if (pAmount.isLessThan(tAmount)) {
                        JOptionPane.showMessageDialog(null, "Total payment is not enough", "Payment failed", JOptionPane.ERROR_MESSAGE);
                    } else {

                        bAmount = pAmount.minus(tAmount);
                        matchedID[1] = apptID;
                        matchedID[2] = techID;
                        matchedID[3] = custName;
                        matchedID[4] = apptDate;
                        matchedID[5] = apptTime;
                        matchedID[6] = appliance;
                        matchedID[7] = paymentStatus;
                        matchedID[8] = paymentDate;
                        matchedID[9] = tAmount.toString();
                        matchedID[10] = pAmount.toString();
                        matchedID[11] = bAmount.toString();
                        matchedID[12] = "true";

                        JOptionPane.showMessageDialog(null, "Customer payment has been updated, balance is: " + bAmount, "Payment made", JOptionPane.INFORMATION_MESSAGE);

                    }
                    //JOptionPane.showMessageDialog(null, "Customer has paid for the service, balance is:RM" + balanceAmount, "Payment made", JOptionPane.INFORMATION_MESSAGE);
                    // Inserting the new information from the text fields into the book line

                }
                // Rewrite the new book.txt with values found in clientBak.txt

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
                        + matchedID[10] + ":"
                        + matchedID[11] + ":"
                        + matchedID[12]);
            }
            // Close the clientBak.txt reader
            inputFile.close();
            // This deletes clientBak.txt
            paymentBack.delete();
            // This closes the book.txt printer 
            cdp.close();
        } catch (Exception ex) {
            highlightEmpty();
            JOptionPane.showMessageDialog(null, "Invalid input! Please check your input to proceed.", "Invalid insertion detected!", JOptionPane.ERROR_MESSAGE);
        }
        clearTable();
        insertPaymentRecords();

    }

    private void highlightEmpty() {
        if ("".equals(txtTotalAmount.getText()) || "MYR".equals(txtTotalAmount.getText())) {
            lblTotalAmount.setForeground(Color.RED);
        }
        if ("".equals(txtTotalAmount.getText()) || "MYR".equals(txtTotalAmount.getText())) {
            lblPaymentAmount.setForeground(Color.RED);
        }
    }

    private void emptyFields() throws Exception {
        PaymentValidation vd = new PaymentValidation();
        if ("".equals(txtTotalAmount.getText()) || "MYR".equals(txtTotalAmount.getText())) {
            throw new Exception("Empty total amount");
        }
        if ("".equals(txtPaymentAmount.getText()) || "MYR".equals(txtPaymentAmount.getText())) {
            throw new Exception("Empty payment amount");
        }
        if (vd.runValidate(txtTotalAmount, false)) {
            throw new Exception("Invalid total amount");
        }
        if (vd.runValidate(txtPaymentAmount, false)) {
            throw new Exception("Invalid payment amount");
        }
    }

    private void deHighlightEmpty() {
        lblTotalAmount.setForeground(ogtxt);
        lblPaymentAmount.setForeground(ogtxt);

        // lblClientHomeAddress.setForeground(ogtxt);
    }

    private void insertPaymentRecords() throws java.io.IOException {
        try {
            FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
            File paymenttxt = new File(FileDir + "Payment.txt");
            BufferedReader br = new BufferedReader(new FileReader(paymenttxt));
            Object[] tableLines = br.lines().toArray();
            DefaultTableModel model = (DefaultTableModel) tblFeedback.getModel();
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
                //if(txticpass.getText().equals(dataRow[1])){
                model.addRow(dataRow);
                //  }

            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginRecords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean filterPayment() throws java.io.IOException {
        boolean Records = false;
        try {

            FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
            File paymenttxt = new File(FileDir + "Payment.txt");
            BufferedReader br = new BufferedReader(new FileReader(paymenttxt));
            Object[] tableLines = br.lines().toArray();
            DefaultTableModel model = (DefaultTableModel) tblFeedback.getModel();
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
                if (dataRow[0].contains(txtFilter.getText()) || dataRow[1].contains(txtFilter.getText()) || dataRow[2].contains(txtFilter.getText()) || dataRow[3].contains(txtFilter.getText()) || dataRow[4].contains(txtFilter.getText())
                        || dataRow[5].contains(txtFilter.getText()) || dataRow[6].contains(txtFilter.getText()) || dataRow[7].contains(txtFilter.getText()) || dataRow[8].contains(txtFilter.getText()) || dataRow[9].contains(txtFilter.getText())
                        || dataRow[10].contains(txtFilter.getText()) || dataRow[11].contains(txtFilter.getText())) {
                    model.addRow(dataRow);
                    Records = true;

                }

            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManagePayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Records;
    }

    private void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tblFeedback.getModel();
        while (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Validation Methods">
    private void inputCharacterValidation() {
        txtFilter.getDocument().addDocumentListener(new APUDocumentListener() {
            filterValidation vd = new filterValidation();

            @Override
            public void changedUpdate(DocumentEvent e) {
                vd.runValidate(txtFilter);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                vd.runValidate(txtFilter);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                vd.runValidate(txtFilter);
            }

        });
    }

    private void showLoginButton() {
        if (filter) {
        btnFilter.setEnabled(true);
        } else {
        btnFilter.setEnabled(false);
        }
    }

    private void showLoginButton(JTextField txt) {
        if ("".equals(txt.getText())) {
            filter = false;
        } else {
            filter = true;
        }
        showLoginButton();
    }

    // </editor-fold>
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

    private void initForm() throws java.io.IOException {
        this.setLocationRelativeTo(null);
        setLogo();
        //btnUpdate.setEnabled(false);
        // btnDelete.setEnabled(false);
        insertPaymentRecords();

        btnFilter.setEnabled(false);
        // Set the initial value for new book
        // This anon class handles window closing event
        txtFilter.getDocument().addDocumentListener(new APUDocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                showLoginButton(txtFilter);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                showLoginButton(txtFilter);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                showLoginButton(txtFilter);

            }
        });
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
        inputCharacterValidation();
    }

    // </editor-fold>
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code">
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Fail Look and Feel");
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManagePayment().setVisible(true);
                } catch (java.io.IOException ex) {
                    Logger.getLogger(ManagePayment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFilter;
    private javax.swing.JPanel btnPnl;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblPaymentAmount;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JPanel mainPnl;
    private javax.swing.JTable tblFeedback;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtPaymentAmount;
    private javax.swing.JTextField txtTotalAmount;
    // End of variables declaration//GEN-END:variables
}
