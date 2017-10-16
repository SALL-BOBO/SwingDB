/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.seb.swingDB.frame;

import fr.seb.database.utils.DatabaseConnection;
import fr.seb.database.utils.DatabaseTools;
import fr.seb.swingDB.entity.User;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import swingdb.AppContext;

/**
 *
 * @author formation
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
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

        jLabel1 = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        validButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Identifiant");

        loginField.setText("juser@user.com");
        loginField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginFieldActionPerformed(evt);
            }
        });

        passwordLabel.setText("Mot de passe");

        passwordField.setText("123");

        validButton.setText("connexion");
        validButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("LOGIN");

        errorLabel.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(validButton)
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordField)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(88, 88, 88))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(99, 99, 99)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addGap(14, 14, 14)
                .addComponent(errorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(validButton)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginFieldActionPerformed

    private void validButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validButtonActionPerformed
        //1. Recuperation de la saisie
        String login = loginField.getText();
        String password = String.copyValueOf(passwordField.getPassword());
        
        //2.Validation de la saisie
        
        //Booléen indiquant si la saisie est valide
        boolean validData = true;
        //Validation du login (qui est un email)
        if(login.equals("") || login.length() <3 || login.indexOf("@") < 1){
            loginField.setBackground(Color.RED);
            validData = false;
        } else {
            loginField.setBackground(Color.WHITE);
    }//GEN-LAST:event_validButtonActionPerformed
   //Validation du mot de passe
   if(password.equals("") || password.length() < 3 ){
       passwordField.setBackground(Color.RED);
       validData = false;
   }else {
       passwordField.setBackground(Color.WHITE);
   }
   
   //Si la saisie est valide
   if(validData){
       
            try {
                //Recuperation de la connection
                Connection cn = DatabaseConnection.getInstance();
                String sql = "SELECT * FROM utilisateurs WHERE email=? AND mot_de_passe = ?";
                //Préparation de la requete
                PreparedStatement pstm = cn.prepareStatement(sql);
                
                //Passage des paramètres
                
                pstm.setString(1, login);
                pstm.setString(2, DatabaseTools.sha1Encode(password));
                
                //Exécution de la requete
                ResultSet rs = pstm.executeQuery();
                
                //Si rs.next() retourne false alors le Resultat est vide
                
                if(rs.next()){
                    //Intanciation de l'utilisateur
                    User user = new User();
                    user.setId(rs.getInt("id"))
                         .setName(rs.getString("nom"))
                         .setfirstName(rs.getString("prenom"))
                          .setEmail(rs.getString("email"))
                          .setRole(rs.getString("role"));
                    //Stockage de l'utilisateur dans un objet contexte (global)
                    //pour le rendre disponible partout dans l'application
                    AppContext.setCurrentUser(user);
                    
                    //Ouvrir la fenetre MainFrame
                    MainFrame app = new MainFrame();
                    app.setVisible(true);
                    app.setLocationRelativeTo(null);
                    
                    //Fermeture du LoginFrame
                    this.dispose();
                    
                } else {
                    
                    String message = "login KO";
                    errorLabel.setText(message);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
   

   
    }
    
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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField loginField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton validButton;
    // End of variables declaration//GEN-END:variables
}