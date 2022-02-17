/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kxbjava;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author User
 */
// <editor-fold defaultstate="collapsed" desc="Document Listener Class"> 
// This document listener is made concrete due to limitation
// with JFrame form
class APUDocumentListener implements DocumentListener {
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        // TO BE OVERRIDDEN
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        // TO BE OVERRIDDEN
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // TO BE OVERRIDDEN
       
    }
}
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Validation Class"> 
// This abstract class contains the fundamental methods required of a validation
abstract class StringValidation {
    
    private String title, msg, regex, nregex;
    
    public StringValidation() {
        title = "Invalid input type!";
        msg = "Field can only consist of letters, numbers and spacing.";
        regex = "^[a-zA-Z0-9 ]+";
        nregex = "[^a-zA-Z0-9 ]";
    }
    
    public StringValidation(String title, String msg, String regex, String nregex) {
        this.title = title;
        this.msg = msg;
        this.regex = regex;
        this.nregex = nregex;
    }
    
    public StringValidation(String msg, String regex, String nregex) {
        title = "Invalid input type!";
        this.msg = msg;
        this.regex = regex;
        this.nregex = nregex;
    }
    
    public void setRegex(String regex){
        this.regex = regex;
    }
    
    public void setNegateRegex(String nregex){
        this.nregex = nregex;
    }
    
    public void setPopup(String title, String msg){
        this.title = title;
        this.msg = msg;
    }
    
    public String getRegex(){
        return regex;
    }
    
    public String getNegateRegex(){
        return nregex;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getMessage(){
        return msg;
    }
    
    public void runPopup(){
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.WARNING_MESSAGE);
    }
    
    public void runValidate(JTextField txt){
        Runnable doDelete = new Runnable(){
            public void set(){
                String input = txt.getText();
                boolean matching = input.matches(getRegex());
                if (!matching && !"".equals(input)) {
                    runPopup();
                    String output = input.replaceAll(getNegateRegex(), "");
                    txt.setText(output);
                }
            }
            @Override
            public void run(){
                set();
            }
        };
        SwingUtilities.invokeLater(doDelete);
    }
    
}

// This subclass handles username validation
class APUUsernameValidation extends StringValidation {
    
    public APUUsernameValidation() {
        super();
        setPopup("Invalid username!", "Username can only consist of letters, numbers and escaped symbols, without spaces.");
        setRegex("^[-a-zA-Z0-9!@#$%^&*()\\{\\}\\[\\]\"\';\\\\/?|.,><~`_+=]+");
        setNegateRegex("[^-a-zA-Z0-9!@#$%^&*()\\{\\}\\[\\]\"\';\\\\/?|.,><~`_+=]");
    }
}

// This subclass handles password validation
class PasswordValidation extends StringValidation {
    
    public PasswordValidation() {
        super();
        setPopup("Invalid password!", "Password can only consist of letters, numbers and escaped symbols.");
        setRegex("^[-a-zA-Z0-9!@#$%^&*()\\{\\}\\[\\]\"\';\\\\/?|.,><~`_+=]+");
        setNegateRegex("[^-a-zA-Z0-9!@#$%^&*()\\{\\}\\[\\]\"\';\\\\/?|.,><~`_+=]");
    }
    
    public void runValidate(JPasswordField txt){
        Runnable doDelete = new Runnable(){
            public void set(){
                String input = String.valueOf(txt.getPassword());
                boolean matching = input.matches(getRegex());
                if (!matching && !"".equals(input)) {
                    runPopup();
                    String output = input.replaceAll(getNegateRegex(), "");
                    txt.setText(output);
                }
            }
            @Override
            public void run(){
                set();
            }
        };
        SwingUtilities.invokeLater(doDelete);
    }
}

// This subclass handles email validation
class EmailValidation extends StringValidation {
    
    public EmailValidation() {
        super();
        setPopup("Invalid email address!", "Email must follow the format 'abc123@mail.com'.");
        setRegex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }
    
    public boolean runValidate(JTextField txt, boolean dispenseMessage){
        boolean invalidEmail = false;
        String input = txt.getText();
        boolean matching = input.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        if (matching == false && !"".equals(input)) {
            if (dispenseMessage) {
                runPopup();
            }
            String output = "";
            txt.setText(output);
            invalidEmail = true;
        };
        return invalidEmail;
    }
    
}
class PaymentValidation extends StringValidation {
    
    public PaymentValidation() {
        super();
        setPopup("Invalid payment format", "Payment must contains 'MYR and Numbers only, MYR11.11 for example'.");
        setRegex("MYR+[0-9]+\\.[0-9]{2}$");
    }
    
    public boolean runValidate(JTextField txt, boolean dispenseMessage){
        boolean invalidMoney = false;
        String input = txt.getText();
        boolean matching = input.matches("MYR+[0-9]+\\.[0-9]{2}$");
        if (matching == false && !"".equals(input)) {
            if (dispenseMessage) {
                runPopup();
            }
            String output = "";
            txt.setText(output);
            invalidMoney = true;
        };
        return invalidMoney;
    }
    
}

// This subclass handles name validation
class APUNameValidation extends StringValidation {
    
    public APUNameValidation() {
        super();
        setPopup("Invalid name!", "Name can only consist of letters and spacing.");
        setRegex("^[a-zA-Z ]+");
        setNegateRegex("[^a-zA-Z ]");
    }
}
class filterValidation extends StringValidation {
    
    public filterValidation() {
        super();
        setPopup("Invalid filter format", "Filter can only contains numbers, letters and spacing.");
        setRegex("^[a-zA-Z0-9 ]+");
        setNegateRegex("[^a-zA-Z0-9 ]");
    }
}

// This is a subclass of name validation but focuses full name
class APUFullNameValidation extends APUNameValidation {
    public APUFullNameValidation(){
        super();
        setPopup("Invalid full name!", "Full name can only consist of letters and spacing.");
    }
}

// This subclass handles home address validation
class APUAddressValidation extends StringValidation {
    public APUAddressValidation() {
        super();
        setPopup("Invalid home address!", "Home address can only consist of letters, numbers, spacing and acceptable symbols.");
        setRegex("^[-a-zA-Z0-9()&., ]+");
        setNegateRegex("[^-a-zA-Z0-9()&., ]");
    }
    
    public void runValidate(JTextArea txt){
        Runnable doDelete = new Runnable(){
            public void set(){
                String input = txt.getText();
                boolean matching = input.matches(getRegex());
                if (!matching && !"".equals(input)) {
                    runPopup();
                    // String output = input.substring(0, input.length() - 1);
                    // String illegalSymbols = input.replaceAll(getRegex(), "");
                    // String output = input.replaceAll(illegalSymbols, "");
                    String output = input.replaceAll(getNegateRegex(), "");
                    txt.setText(output);
                }
            }
            @Override
            public void run(){
                set();
            }
        };
        SwingUtilities.invokeLater(doDelete);
    }
    
}
class DOBValidation extends StringValidation {
    
    public DOBValidation() {
        super();
        setPopup("Invalid DOB Format", "Date of birth must contains numbers and allowed symbols only, follow dd-MM-yyyy format.");
        setRegex("(0?[1-9]|[12][0-9]|[01])-(0?[1-9]|1[012])-(\\d{4})");
    }
    
    public boolean runValidate(JTextField txt, boolean dispenseMessage){
        boolean invalidMoney = false;
        String input = txt.getText();
        boolean matching = input.matches("(0?[1-9]|[12][0-9]|[01])-(0?[1-9]|1[012])-(\\d{4})");
        if (matching == false && !"".equals(input)) {
            if (dispenseMessage) {
                runPopup();
            }
            String output = "";
            txt.setText(output);
            invalidMoney = true;
        };
        return invalidMoney;
    }
    
}
class UserIDValidation extends StringValidation {
    public UserIDValidation(){
        super(); 
        setPopup("Invalid user ID format", "User ID must only containts letters and number without spacing and symbols.");
        setRegex("^[a-zA-Z0-9]+");
        setNegateRegex("[^a-zA-Z0-9]");
    }
}
// </editor-fold>
