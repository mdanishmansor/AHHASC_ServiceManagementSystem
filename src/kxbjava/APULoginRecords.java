/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kxbjava;

import com.formdev.flatlaf.FlatDarkLaf;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class APULoginRecords extends javax.swing.JFrame {

    
    private String userSpecies, uID, FileDir, managerID;
    
    private String logTitle = "Login records of the system's users";
    private String SubTitle = new String("Invoice");
    /**
     * Creates new form APULoginRecords
     */
    public APULoginRecords() {
        initComponents();
        insertLoginRecords();
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
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(68, 68, 68));
        jPanel1.setForeground(new java.awt.Color(237, 237, 237));

        tblLoginRecords.setBackground(new java.awt.Color(68, 68, 68));
        tblLoginRecords.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tblLoginRecords.setForeground(new java.awt.Color(237, 237, 237));
        tblLoginRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Manager ID", "User Name", "Username", "Password", "Login Date & Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLoginRecords);

        btnPrint.setText("Print Login Records");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1107, 1107, 1107)
                .addComponent(btnPrint)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(btnPrint)
                .addContainerGap(161, Short.MAX_VALUE))
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

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
//        String savePath="";
//        JFileChooser file = new JFileChooser();
//        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        int selection = file.showSaveDialog(this);
//        
//        if(selection==JFileChooser.APPROVE_OPTION){
//            savePath = file.getSelectedFile().getPath();
//        }
        //get directory to save the file
        FileDir = System.getProperty("user.dir") + "\\src\\PDF\\";
        Document doc=new Document();
//        Document pdf = new Document();
//        

        try {
            
            PdfWriter.getInstance(doc, new FileOutputStream(FileDir + "LoginRecords.pdf"));
           
            doc.open();
            
            PdfPTable tbl = new PdfPTable(6);
            
            tbl.addCell("User ID");
            tbl.addCell("Manager ID");
            tbl.addCell("User Name");
            tbl.addCell("Username");
            tbl.addCell("Password");
            tbl.addCell("Login Date & Time");
            
            
            for(int i = 0; i < tblLoginRecords.getRowCount(); i++){
                String userID = tblLoginRecords.getValueAt(i, 0).toString();
                String ManagerID = tblLoginRecords.getValueAt(i, 1).toString();
                String userFullName = tblLoginRecords.getValueAt(i, 2).toString();
                String username = tblLoginRecords.getValueAt(i, 3).toString();
                String pass = tblLoginRecords.getValueAt(i, 4).toString();
                String logdate = tblLoginRecords.getValueAt(i, 5).toString();
                
                tbl.addCell(userID);
                tbl.addCell(ManagerID);
                tbl.addCell(userFullName);
                tbl.addCell(username);
                tbl.addCell(pass);
                tbl.addCell(logdate);
                
            }
            
            //write into the pdf
            doc.add(tbl);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(APULoginRecords.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(APULoginRecords.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();
       JOptionPane.showMessageDialog(null, "Print Successfully!", "Records Printed!", JOptionPane.INFORMATION_MESSAGE);
    
    }//GEN-LAST:event_btnPrintActionPerformed

    
    private void insertLoginRecords(){
        try {
             FileDir = System.getProperty("user.dir") + "\\src\\TextFiles\\";
             File logintxt = new File(FileDir + "LoginRecords.txt");
             BufferedReader br = new BufferedReader(new FileReader(logintxt));
            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable model
//            String firstLine = br.readLine().trim();
//            String[] columnsName = firstLine.split(":");
//            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
//            model.setColumnIdentifiers(columnsName);
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            DefaultTableModel model = (DefaultTableModel)tblLoginRecords.getModel();
            // extratct data from lines
            // set data to jtable model
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
                //if(txticpass.getText().equals(dataRow[1])){
                     model.addRow(dataRow);
              //  }
             
        }
        }
        catch (Exception ex){
            
        }
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
                new APULoginRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLoginRecords;
    // End of variables declaration//GEN-END:variables
}
