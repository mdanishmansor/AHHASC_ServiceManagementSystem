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
abstract class APUStringValidation {
    
    private String title, msg, regex, nregex;
    
    public APUStringValidation() {
        title = "Invalid input type!";
        msg = "Field can only consist of letters, numbers and spacing.";
        regex = "^[a-zA-Z0-9 ]+";
        nregex = "[^a-zA-Z0-9 ]";
    }
    
    public APUStringValidation(String title, String msg, String regex, String nregex) {
        this.title = title;
        this.msg = msg;
        this.regex = regex;
        this.nregex = nregex;
    }
    
    public APUStringValidation(String msg, String regex, String nregex) {
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
class APUUsernameValidation extends APUStringValidation {
    
    public APUUsernameValidation() {
        super();
        setPopup("Invalid username!", "Username can only consist of letters, numbers and escaped symbols, without spaces.");
        setRegex("^[-a-zA-Z0-9!@#$%^&*()\\{\\}\\[\\]\"\';\\\\/?|.,><~`_+=]+");
        setNegateRegex("[^-a-zA-Z0-9!@#$%^&*()\\{\\}\\[\\]\"\';\\\\/?|.,><~`_+=]");
    }
}

// This subclass handles password validation
class APUPasswordValidation extends APUStringValidation {
    
    public APUPasswordValidation() {
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
class APUEmailValidation extends APUStringValidation {
    
    public APUEmailValidation() {
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

// This subclass handles name validation
class APUNameValidation extends APUStringValidation {
    
    public APUNameValidation() {
        super();
        setPopup("Invalid name!", "Name can only consist of letters and spacing.");
        setRegex("^[a-zA-Z ]+");
        setNegateRegex("[^a-zA-Z ]");
    }
}

// This is a subclass of name validation but focuses full name
class APUFullNameValidation extends APUNameValidation {
    public APUFullNameValidation(){
        super();
        setPopup("Invalid first name!", "First name can only consist of letters and spacing.");
    }
}

// This subclass handles home address validation
class APUAddressValidation extends APUStringValidation {
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

// This subclass handles book title naming validation
class APUTitleValidation extends APUStringValidation {
        APUTitleValidation(){
        super();
        setPopup("Invalid book title!", "Book title can only consist of letters, numbers, spacing and escaped symbols.");
        setRegex("^[-a-zA-Z0-9!@#$%^&*()\\{\\}\\[\\]\"\';\\\\/?|.,><~`_+= ]+");
        setNegateRegex("[^-a-zA-Z0-9!@#$%^&*()\\{\\}\\[\\]\"\';\\\\/?|.,><~`_+= ]");
    }
}

// This subclass handles book genre validation
class APUGenreValidation extends  APUStringValidation {
        APUGenreValidation(){
        super();
        setPopup("Invalid book genre!", "Book genre can only consist of letters, numbers, spacing and acceptable symbols.");
        setRegex("^[-a-zA-Z0-9()&., ]+");
        setNegateRegex("[^-a-zA-Z0-9()&., ]");
    }
}

// This subclass handles book summary validation
class APUSummaryValidation extends APUStringValidation {
        APUSummaryValidation(){
        super();
        setPopup("Invalid book summary!", "Book summary can only consist of letters, numbers, spacing and acceptable symbols.");
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
                    // String output = input.replaceAll(getRegex(), "");
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

// This subclass handles book publisher validation
class APUPublisherValidation extends APUStringValidation {
        APUPublisherValidation(){
        super();
        setPopup("Invalid book publisher!", "Book publisher can only consist of letters, numbers, spacing and acceptable symbols.");
        setRegex("^[-a-zA-Z0-9()&., ]+");
        setNegateRegex("[^-a-zA-Z0-9()&., ]");
    }
}

// This subclass handles book author validation
class APUAuthorValidation extends APUStringValidation {
        APUAuthorValidation(){
        super();
        setPopup("Invalid book author!", "Book author can only consist of letters, numbers, spacing and acceptable symbols.");
        setRegex("^[-a-zA-Z0-9()&., ]+");
        setNegateRegex("[^-a-zA-Z0-9()&., ]");
    }
}
// </editor-fold>
