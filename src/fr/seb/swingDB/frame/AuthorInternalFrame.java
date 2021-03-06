/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.seb.swingDB.frame;

import fr.seb.database.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author formation
 */
public class AuthorInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form AuthorInternalFrame
     */
    public AuthorInternalFrame() {
        initComponents();
        initTable();
    }
    
    private void initTable(){
        //Récuperaration du modele de la jTable
       DefaultTableModel model =  (DefaultTableModel)jTable1.getModel();
       
       //Récuperation des données depuis la base de données
       String sql = "SELECT * FROM auteurs";
       
        try {
            //La connexion a la base de données
            Connection cn = DatabaseConnection.getInstance();
            //Le statement
            Statement stm = cn.createStatement();
            //Exécution de la requete
            ResultSet rs = stm.executeQuery(sql);
            
            //Tableau d'objet qui represente une ligne de la table
            Object[] tableRow;
            
            //Boucle sur le ResultSet
            while(rs.next()){
                //Consstitution du tableau des données
                tableRow = new Object[3];
                tableRow[0] = rs.getObject("id");
                tableRow[1] = rs.getObject("prenom");
                tableRow[2] = rs.getObject("nom");
                
                //Ajout du tableau dans une nouvelle variable
                model.addRow(tableRow);
                
               
            }
             //Fermeture des objets de connexion
                rs.close();
                stm.close();
                cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AuthorInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        idField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ajouterButton = new javax.swing.JButton();
        supprimerButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion des auteurs");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Prenom", "Nom"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("id");

        jLabel2.setText("prenom");

        jLabel3.setText("nom");

        ajouterButton.setText("Ajouter");
        ajouterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterButtonActionPerformed(evt);
            }
        });

        supprimerButton.setText("Supprimer");
        supprimerButton.setActionCommand("");
        supprimerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idField)
                                    .addComponent(firstName)
                                    .addComponent(nameField)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(ajouterButton)
                        .addGap(90, 90, 90)
                        .addComponent(supprimerButton)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterButton)
                    .addComponent(supprimerButton))
                .addContainerGap(201, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int SelectedIndex = jTable1.getSelectedRow();
       
       //Récuperation du modèle
       TableModel model = jTable1.getModel();
       
       //RECUP2RATION DES DONN2ES DE LA LIGNE SELECTIONNE
       String id = (String) model.getValueAt(SelectedIndex, 0);
       String name = (String) model.getValueAt(SelectedIndex, 1);
       String firstName = (String) model.getValueAt(SelectedIndex, 2);
       
       //Insertion des données dans les TextFile
       idField.setText(id);
       nameField.setText(name);
       this.firstName.setText(firstName);
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void ajouterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterButtonActionPerformed
        DefaultTableModel mod = (DefaultTableModel)jTable1.getModel();
        mod.addRow(new Object[]{idField.getText(),
                                firstName.getText(),
                                nameField.getText()});
                                jTable1.getSelectedRow();
        
    }//GEN-LAST:event_ajouterButtonActionPerformed

    private void supprimerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerButtonActionPerformed
      DefaultTableModel mod = (DefaultTableModel)jTable1.getModel();
      mod.removeRow(jTable1.getSelectedRow());
    }//GEN-LAST:event_supprimerButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterButton;
    private javax.swing.JTextField firstName;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton supprimerButton;
    // End of variables declaration//GEN-END:variables
}
