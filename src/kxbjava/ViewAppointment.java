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
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ViewAppointment extends javax.swing.JFrame {

    private String FileDir;
    private boolean filter = false;
    private final String pdfsource = System.getProperty("user.dir") + "\\src\\PDF\\Appointment.pdf";
    /**
     * Creates new form ViewFeedback
     */
    public ViewAppointment() throws java.io.IOException {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFeedback = new javax.swing.JTable();
        txtFilter = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        lblTitle1 = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        btnPnl = new javax.swing.JPanel();
        btnPrint = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(68, 68, 68));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblFeedback.setBackground(new java.awt.Color(68, 68, 68));
        tblFeedback.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tblFeedback.setForeground(new java.awt.Color(237, 237, 237));
        tblFeedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appointment ID", "Customer ID", "Technician ID", "Manager ID", "Customer Name", "Appointment Date", "Appointment Time", "Appliance", "Booking Date", "Appointment Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFeedback);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 181, 1230, 430));

        txtFilter.setBackground(new java.awt.Color(68, 68, 68));
        txtFilter.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtFilter.setForeground(new java.awt.Color(237, 237, 237));
        txtFilter.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtFilter.setCaretColor(new java.awt.Color(237, 237, 237));
        jPanel1.add(txtFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 430, 50));

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
        jPanel1.add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, 100, 100));

        lblTitle1.setBackground(new java.awt.Color(68, 68, 68));
        lblTitle1.setFont(new java.awt.Font("Segoe UI Variable", 1, 38)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(214, 41, 99));
        lblTitle1.setText("View Appointments");
        jPanel1.add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        lblDesc.setBackground(new java.awt.Color(68, 68, 68));
        lblDesc.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc.setText("View and Print List of Appointments");
        jPanel1.add(lblDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        lblSearch.setFont(new java.awt.Font("Segoe UI Variable", 0, 24)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(255, 255, 255));
        lblSearch.setText("Provide Search Term");
        jPanel1.add(lblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, -1, 30));

        btnPnl.setBackground(new java.awt.Color(68, 68, 68));

        btnPrint.setBackground(new java.awt.Color(68, 68, 68));
        btnPrint.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("Save as PDF");
        btnPrint.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
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
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        btnPnlLayout.setVerticalGroup(
            btnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPnlLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(btnPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanel1.add(btnPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 1280, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Button Events">   
    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed

        clearTable();
        try {
            if(filterAppointment()){
                JOptionPane.showMessageDialog(null, "Record(s) filtered accordingly", "Records Filtered!", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "No record(s) found according to the filter", "No Record(s)", JOptionPane.ERROR_MESSAGE);
            }
        } catch (java.io.IOException ex) {
            Logger.getLogger(ViewAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            printRecords();
        } catch (IOException | FileNotFoundException ex) {
            Logger.getLogger(LoginRecords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        int selection = JOptionPane.showConfirmDialog(null, "Are you sure to go back?", "Back to Main Menu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (selection == JOptionPane.YES_OPTION) {
            new APUCMMenu().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods">   
    
    private void setLogo() {
        String sourcefolder = System.getProperty("user.dir") + "\\src\\icons\\";
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(sourcefolder + "AHHASCrsmol.png"));
        this.setTitle("AHHASC View Appointments Page");

    }
    
    private void printRecords() throws IOException, FileNotFoundException{
        
           
            PdfWriter writer = new PdfWriter(pdfsource);
            PdfDocument pdfdoc = new PdfDocument(writer);
            pdfdoc.setDefaultPageSize(PageSize.A4.rotate());
            Document document = new Document(pdfdoc);
            
            Style titlestyle = new Style();
            titlestyle.setBold()
                      .setFontSize(18f)
                      .setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER);
            
            String title = "Appointment Records of the Customers";
            Paragraph doctitle = new Paragraph(title).addStyle(titlestyle);
            
            float columnWidth[] = {30f,30f,30f,30f,30f,30f,30f,30f,30f,30f};
            Table tbl = new Table(columnWidth);
           // doc.addTitle("AHHASC");
            document.add(doctitle);
            tbl.addCell("Appointment ID").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Customer ID").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Technician ID").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Manager ID").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Customer Name").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Appointment Date").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Appointment Time").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Appliance").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Booking Date").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Appointment Status").setFontColor(new DeviceRgb(23, 23, 23));
            
            
            for(int i = 0; i < tblFeedback.getRowCount(); i++){
                String apptID = tblFeedback.getValueAt(i, 0).toString();
                String custID = tblFeedback.getValueAt(i, 1).toString();
                String techID = tblFeedback.getValueAt(i, 2).toString();
                String managerID = tblFeedback.getValueAt(i, 3).toString();
                String custName = tblFeedback.getValueAt(i, 4).toString();
                String apptDate = tblFeedback.getValueAt(i, 5).toString();
                String apptTime = tblFeedback.getValueAt(i, 6).toString();
                String appliance = tblFeedback.getValueAt(i, 7).toString();
                String bookingDate = tblFeedback.getValueAt(i, 8).toString();
                String apptStatus = tblFeedback.getValueAt(i, 9).toString();
                
                
                tbl.addCell(apptID);
                tbl.addCell(custID);
                tbl.addCell(techID);
                tbl.addCell(managerID);
                tbl.addCell(custName);
                tbl.addCell(apptDate);
                tbl.addCell(apptTime);
                tbl.addCell(appliance);
                tbl.addCell(bookingDate);
                tbl.addCell(apptStatus);
                
            }
            
           //write into the pdf
           document.add(tbl);
           document.close();
        
       JOptionPane.showMessageDialog(null, "Printed to PDF Successfully!", "Records Printed!", JOptionPane.INFORMATION_MESSAGE);
    
    }
    private void insertAppointmentRecords() throws java.io.IOException{
        try {
             FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
             File appttxt = new File(FileDir + "Appointment.txt");
             BufferedReader br = new BufferedReader(new FileReader(appttxt));
            Object[] tableLines = br.lines().toArray();
            DefaultTableModel model = (DefaultTableModel)tblFeedback.getModel();
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
                //if(txticpass.getText().equals(dataRow[1])){
                     model.addRow(dataRow);
              //  }
             
        }
            br.close();
        }
        catch (FileNotFoundException ex){
            Logger.getLogger(LoginRecords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private boolean filterAppointment() throws java.io.IOException{
        boolean Records = false;
        try {
             
             FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
             File appttxt = new File(FileDir + "Appointment.txt");
             BufferedReader br = new BufferedReader(new FileReader(appttxt));
            Object[] tableLines = br.lines().toArray();
            DefaultTableModel model = (DefaultTableModel)tblFeedback.getModel();
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
                if(dataRow[0].contains(txtFilter.getText()) || dataRow[1].contains(txtFilter.getText()) || dataRow[2].contains(txtFilter.getText()) || dataRow[3].contains(txtFilter.getText()) || dataRow[4].contains(txtFilter.getText())
                    || dataRow[5].contains(txtFilter.getText()) || dataRow[6].contains(txtFilter.getText()) || dataRow[7].contains(txtFilter.getText()) || dataRow[8].contains(txtFilter.getText()) || dataRow[9].contains(txtFilter.getText())){
                     model.addRow(dataRow);
                     Records = true;
                     
               }
            }
             br.close();
        }
        catch (FileNotFoundException ex){
           Logger.getLogger(ViewAppointment.class.getName()).log(Level.SEVERE, null, ex);
       }
         return Records;
    }
    
    
    private void clearTable(){
        DefaultTableModel model = (DefaultTableModel)tblFeedback.getModel();
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
    }
     //<editor-fold defaultstate="collapsed" desc="Validation Methods">
         private void inputCharacterValidation(){
        txtFilter.getDocument().addDocumentListener(new APUDocumentListener() {
            filterValidation vd = new filterValidation();
            @Override
            public void changedUpdate(DocumentEvent e){
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
    private void showLoginButton(){
        if (filter){
            btnFilter.setVisible(true);
        }
        else
        {
            btnFilter.setVisible(false);
        }
     } 
    private void showLoginButton(JTextField txt){
        if ("".equals(txt.getText())){
            filter = false;
        } 
        else {
            filter = true;
        }
        showLoginButton();
     }
    
    // </editor-fold>
    
    
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
     private void initForm() throws java.io.IOException{
        this.setLocationRelativeTo(null);
        setLogo();
        //btnUpdate.setEnabled(false);
       // btnDelete.setEnabled(false);
        insertAppointmentRecords();
        btnFilter.setVisible(false);
        // Set the initial value for new book
        // This anon class handles window closing event
         txtFilter.getDocument().addDocumentListener(new APUDocumentListener(){

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
                    new ViewAppointment().setVisible(true);
                } catch (java.io.IOException ex) {
                    Logger.getLogger(ViewAppointment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFilter;
    private javax.swing.JPanel btnPnl;
    private javax.swing.JButton btnPrint;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JTable tblFeedback;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables
}
