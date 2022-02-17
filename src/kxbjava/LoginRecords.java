/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kxbjava;

import com.formdev.flatlaf.FlatDarkLaf;
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
public class LoginRecords extends javax.swing.JFrame {

    
    private String FileDir;
    private final String pdfsource = System.getProperty("user.dir") + "\\src\\PDF\\LoginRecords.pdf";    
    private boolean filter = false;
    
    
    //private final String pdfTitle = new String ("AHHASC");
    //private String subTitle = "Login Records";
    /**
     * Creates new form APULoginRecords
     */
    public LoginRecords() {
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
        tblLoginRecords = new javax.swing.JTable();
        btnFilter = new javax.swing.JButton();
        txtFilter = new javax.swing.JTextField();
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
        jPanel1.setForeground(new java.awt.Color(237, 237, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblLoginRecords.setBackground(new java.awt.Color(68, 68, 68));
        tblLoginRecords.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tblLoginRecords.setForeground(new java.awt.Color(237, 237, 237));
        tblLoginRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Manager ID", "User Role", "Full Name", "Login Date & Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLoginRecords);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 1204, 420));

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

        txtFilter.setBackground(new java.awt.Color(68, 68, 68));
        txtFilter.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtFilter.setForeground(new java.awt.Color(237, 237, 237));
        txtFilter.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(237, 237, 237)));
        txtFilter.setCaretColor(new java.awt.Color(237, 237, 237));
        jPanel1.add(txtFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 422, 50));

        lblTitle1.setBackground(new java.awt.Color(68, 68, 68));
        lblTitle1.setFont(new java.awt.Font("Segoe UI Variable", 1, 38)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(214, 41, 99));
        lblTitle1.setText("View Login Records");
        jPanel1.add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        lblDesc.setBackground(new java.awt.Color(68, 68, 68));
        lblDesc.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc.setText("Track and Monitor Login Activity");
        jPanel1.add(lblDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        lblSearch.setFont(new java.awt.Font("Segoe UI Variable", 0, 24)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(255, 255, 255));
        lblSearch.setText("Provide Search Term");
        jPanel1.add(lblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, -1, 30));

        btnPnl.setBackground(new java.awt.Color(68, 68, 68));

        btnPrint.setBackground(new java.awt.Color(68, 68, 68));
        btnPrint.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("Print Login Records");
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
        jPanel1.getAccessibleContext().setAccessibleName("");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed

        clearTable();
        if(filterLoginRecords()){
            JOptionPane.showMessageDialog(null, "Record(s) filtered accordingly", "Records Filtered!", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "No record(s) found according to the filter", "No Record(s)", JOptionPane.ERROR_MESSAGE);
        }
       
    
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            printRecords();
        } catch (FileNotFoundException ex) {
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

    private void setLogo() {
        String sourcefolder = System.getProperty("user.dir") + "\\src\\icons\\";
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(sourcefolder + "AHHASCrsmol.png"));
        this.setTitle("AHHASC View Login Records Page");

    }
    
    private void printRecords() throws FileNotFoundException{
        
           
            PdfWriter writer = new PdfWriter(pdfsource);
            PdfDocument pdfdoc = new PdfDocument(writer);
            Document document = new Document(pdfdoc);
            
            Style titlestyle = new Style();
            titlestyle.setBold()
                      .setFontSize(18)
                      .setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER);
            
            String title = "Login Records of the Users Using the System";
            Paragraph doctitle = new Paragraph(title).addStyle(titlestyle);
            
            float columnWidth[] = {50,60,150,200,200};
            Table tbl = new Table(columnWidth);
           // doc.addTitle("AHHASC");
            document.add(doctitle);
            tbl.addCell("User ID");
            tbl.addCell("Manager ID");
            tbl.addCell("User Role");
            tbl.addCell("Full Name");
            tbl.addCell("Login Date & Time");
            
            
            for(int i = 0; i < tblLoginRecords.getRowCount(); i++){
                String userID = tblLoginRecords.getValueAt(i, 0).toString();
                String ManagerID = tblLoginRecords.getValueAt(i, 1).toString();
                String userRole = tblLoginRecords.getValueAt(i, 2).toString();
                String fullName = tblLoginRecords.getValueAt(i, 3).toString();
                String logdate = tblLoginRecords.getValueAt(i, 4).toString();
                
                tbl.addCell(userID);
                tbl.addCell(ManagerID);
                tbl.addCell(userRole);
                tbl.addCell(fullName);
                tbl.addCell(logdate);
                
            }
            
           //write into the pdf
           document.add(tbl);
           document.close();
        
       JOptionPane.showMessageDialog(null, "Printed to PDF Successfully!", "Records Printed!", JOptionPane.INFORMATION_MESSAGE);
    
    }
    private void insertLoginRecords(){
        try {
             FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
             File logintxt = new File(FileDir + "LoginRecords.txt");
             BufferedReader br = new BufferedReader(new FileReader(logintxt));
            Object[] tableLines = br.lines().toArray();
            DefaultTableModel model = (DefaultTableModel)tblLoginRecords.getModel();
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
                //if(txticpass.getText().equals(dataRow[1])){
                     model.addRow(dataRow);
              //  }
             
        }
        }
        catch (FileNotFoundException ex){
            Logger.getLogger(LoginRecords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void clearTable(){
        DefaultTableModel model = (DefaultTableModel)tblLoginRecords.getModel();
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
    }
    private boolean filterLoginRecords(){
        boolean Records = false;
        try {
             
             FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
             File logintxt = new File(FileDir + "LoginRecords.txt");
             BufferedReader br = new BufferedReader(new FileReader(logintxt));
            Object[] tableLines = br.lines().toArray();
            DefaultTableModel model = (DefaultTableModel)tblLoginRecords.getModel();
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
                if(dataRow[0].contains(txtFilter.getText()) || dataRow[1].contains(txtFilter.getText()) || dataRow[2].contains(txtFilter.getText()) || dataRow[3].contains(txtFilter.getText())){
                     model.addRow(dataRow);
                     Records = true;
                     
               }
            }
             
        }
        catch (FileNotFoundException ex){
          Logger.getLogger(LoginRecords.class.getName()).log(Level.SEVERE, null, ex);
       }
         return Records;
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
    
    
    
    // </editor-fold>
    
   private void initForm(){
        this.setLocationRelativeTo(null);
        setLogo();
        //btnUpdate.setEnabled(false);
       // btnDelete.setEnabled(false);
        insertLoginRecords();
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
                new LoginRecords().setVisible(true);
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
    private javax.swing.JTable tblLoginRecords;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables
}
