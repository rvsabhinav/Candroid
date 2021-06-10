/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Candroid;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author pranj
 */
public class Signup extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Signup() {
        initComponents();
    }
public boolean isValidEmail(String id){
    boolean validity = true;    
    if(id.contains("@")&&id.contains(".")){
        int indexOfAt = id.indexOf("@"),indexOfDot=id.indexOf(".",indexOfAt);
        String chars = "~`!@#$%^&*()-=+[]{}\\|''\"\";:/?>,< ";
        String [] subs = new String[3];
        subs[0] = id.substring(0,indexOfAt);
        if(indexOfDot!=-1) subs[1] = id.substring(indexOfAt+1,indexOfDot);
        else return false;
        subs[2] = id.substring(indexOfDot+1);
        for(int j = 0;j<3;j++){
         for(int i=0;i<chars.length();i++)
              if(subs[j].contains(""+chars.charAt(i))) return false;
          if(j==2)
            if(!(subs[2].length()==3||subs[2].length()==2)) return false;
        }
    }
    else validity=false;   
    return validity;
    }

     
 //    -----------------------Variable Declaration-------------------------
    String FirstName,LastName,Username,Password,ConfirmPassword,Email;
    short NullState,RedundancyState,VerificationState;
    MysqlConnector  DataMine= new MysqlConnector();
   
    public void NullCheck(){
 //    -----------------------Variable Assignmrnt-------------------------
    FirstName=FirstNameTF.getText();
    LastName=LastNameTF.getText();
    Username=UsernameTF.getText();
    Password=PasswordTF.getText();
    ConfirmPassword=ConfirmPasswordTF.getText();
    Email=EmailTF.getText();
    //         Logic Starts Here
    //the if block checks each text field for null and then sets red color
    NullState=0;
            if(FirstName.equals("")){
            FirstNameTF.setText("");
            FirstNameTF.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
            NullState=1;
                }
            if(LastName.equals("")){
            LastNameTF.setText("");
            LastNameTF.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
            NullState=1;
                }
            if(Username.equals("")){
            UsernameTF.setText("");
            UsernameTF.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
            NullState=1;
                }
            if(Password.equals("")){
            PasswordTF.setText("");
            PasswordTF.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
            NullState=1;
                }
            if(ConfirmPassword.equals("")){
            ConfirmPasswordTF.setText("");
            ConfirmPasswordTF.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
            NullState=1;
                }
            if(Email.equals("")){
            EmailTF.setText("");
            EmailTF.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
            NullState=1;
                }
    //based on value of NullState we show a Dialog Box
    if(NullState==1){
    JOptionPane.showMessageDialog(null,"Please fill the required fields");
    }else NullState=0;
    }
    public void RedundancyCheck(){
   // -----------------------Declaration---------------------
   String TableUsername,TableEmail; 
// --------------------------Data Extraxtion----------------
   ResultSet Data=DataMine.getResultSetFor("Select email,username from user");
    try {
        while (Data.next()) {            
            TableUsername=Data.getString("username");
            TableEmail=Data.getString("email");
            if(TableEmail.equals(Email)){
                    RedundancyState=1;
                    break;
            }
            else if(TableUsername.equals(Username)){
                    RedundancyState=2;
                    break;       
            }
            
        }
        switch (RedundancyState) {
            case 1: {
                EmailTF.setText("");
                JOptionPane.showMessageDialog(null,"E-mail already exits please contact admin to reset your account");
                }break;
            case 2: {
                UsernameTF.setText("");
                JOptionPane.showMessageDialog(null,"Username already exits please contact admin to reset your account");
                }break;
            default: RedundancyState=3;
                
        }
    } catch (SQLException e) {
    }
}
public void SecurityCheck(){
        if(ConfirmPassword.equals(Password)==false){
        ConfirmPasswordTF.setText("");
        PasswordTF.setText("");
        JOptionPane.showMessageDialog(null,"Passwords do not match");
        VerificationState=0;
        }
        else if(Password.length()<8){
        ConfirmPasswordTF.setText("");
        PasswordTF.setText("");
        JOptionPane.showMessageDialog(null,"Password must be greater than 8 characters");
        VerificationState=0;
        }
        else if(Username.length()>20){
        UsernameTF.setText("");
        JOptionPane.showMessageDialog(null,"Username must be less than 20 characters");
        VerificationState=0;
        }
        else if(!isValidEmail(Email)){
        EmailTF.setText("");
        JOptionPane.showMessageDialog(null,"Invalid Email");
        VerificationState=0;
        }else VerificationState=1;
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
        SubmitBT = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jb4 = new javax.swing.JButton();
        TermsCHK = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        EmailTF = new javax.swing.JTextField();
        ConfirmPasswordTF = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PasswordTF = new javax.swing.JPasswordField();
        UsernameTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LastNameTF = new javax.swing.JTextField();
        FirstNameTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(375, 150, 0, 0));
        setMinimumSize(new java.awt.Dimension(454, 390));

        jPanel1.setBackground(new java.awt.Color(121, 172, 69));

        SubmitBT.setBackground(new java.awt.Color(121, 172, 69));
        SubmitBT.setForeground(new java.awt.Color(255, 255, 255));
        SubmitBT.setText("Submit");
        SubmitBT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        SubmitBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitBTActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(121, 172, 69));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Clear");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(121, 172, 69));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Exit");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jb4.setBackground(new java.awt.Color(121, 172, 69));
        jb4.setForeground(new java.awt.Color(255, 255, 255));
        jb4.setText("Back");
        jb4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb4ActionPerformed(evt);
            }
        });

        TermsCHK.setBackground(new java.awt.Color(121, 172, 69));
        TermsCHK.setForeground(new java.awt.Color(255, 255, 255));
        TermsCHK.setText("I Accept the Terms And Conditions and Privacy Policy of Candroid");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");

        EmailTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        EmailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailTFActionPerformed(evt);
            }
        });

        ConfirmPasswordTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ConfirmPasswordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmPasswordTFActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirm Password");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");

        PasswordTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        PasswordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordTFActionPerformed(evt);
            }
        });

        UsernameTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Name");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name ");

        LastNameTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        FirstNameTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("First Name ");

        jLabel8.setFont(new java.awt.Font("Ethnocentric Rg", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Sign Up");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(FirstNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(LastNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(PasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(ConfirmPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(EmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TermsCHK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SubmitBT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jb4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(FirstNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addComponent(LastNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3))
                    .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(PasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConfirmPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel5)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel6))
                    .addComponent(EmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(TermsCHK)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SubmitBT, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
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

    private void SubmitBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitBTActionPerformed
        NullCheck();
        System.out.println(NullState);
        if(NullState==0){
            RedundancyCheck();
            System.out.println(RedundancyState);
            if(RedundancyState==3){
                SecurityCheck();
                System.out.println(VerificationState);
                if(VerificationState==1){
                    if(TermsCHK.isSelected()){
                        DataMine.setSQLInsert("insert into user(firstname,lastname,username,password,email) values ('"+FirstName+"', '"+LastName+"','"+Username+"','"+Password+"','"+Email+"');");
                        //add the remaining code
                    }else JOptionPane.showMessageDialog(null,"Please agree to our terms and conditions");
                }
            }
        }
    }//GEN-LAST:event_SubmitBTActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FirstNameTF.setText("");
        LastNameTF.setText("");
        UsernameTF.setText("");
        PasswordTF.setText("");
        ConfirmPasswordTF.setText("");
        EmailTF.setText("");
        TermsCHK.setSelected(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb4ActionPerformed
        Login g;
        g = new Login();
        g.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jb4ActionPerformed

    private void EmailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailTFActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailTFActionPerformed

    private void ConfirmPasswordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmPasswordTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmPasswordTFActionPerformed

    private void PasswordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordTFActionPerformed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfirmPasswordTF;
    private javax.swing.JTextField EmailTF;
    private javax.swing.JTextField FirstNameTF;
    private javax.swing.JTextField LastNameTF;
    private javax.swing.JPasswordField PasswordTF;
    private javax.swing.JButton SubmitBT;
    private javax.swing.JCheckBox TermsCHK;
    private javax.swing.JTextField UsernameTF;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb4;
    // End of variables declaration//GEN-END:variables
}
