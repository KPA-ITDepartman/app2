/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osiguravajucedrustvo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author emma
 */
public class UnosAgenta extends javax.swing.JFrame {
    Baza baza = new Baza();

    private int id;
    private String ime, prezime, telefon, email, datum;
    
    public UnosAgenta() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_ime = new javax.swing.JTextField();
        tfr_br = new javax.swing.JTextField();
        tf_prezime = new javax.swing.JTextField();
        tf_email = new javax.swing.JTextField();
        tf_telefon = new javax.swing.JTextField();
        tf_datum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPronadji1 = new javax.swing.JButton();
        jIzmeni = new javax.swing.JButton();
        jDodaj = new javax.swing.JButton();
        jObrisi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPolise = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Redni broj:");

        jLabel4.setText("Ime:");

        jLabel5.setText("Prezime:");

        jLabel8.setText("Telefon:");

        jLabel9.setText("Email:");

        jLabel2.setText("Datum zaposlenja:");

        jPronadji1.setText("Pronadji");
        jPronadji1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPronadji1ActionPerformed(evt);
            }
        });

        jIzmeni.setText("Izmeni");
        jIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIzmeniActionPerformed(evt);
            }
        });

        jDodaj.setText("Dodaj");
        jDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDodajActionPerformed(evt);
            }
        });

        jObrisi.setText("Obrisi");
        jObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jObrisiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("Unos agenta");

        jPolise.setText("Polise");
        jPolise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPoliseActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/osiguravajucedrustvo/Slike/klijent-pocetna.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2))
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfr_br, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(tf_ime)
                            .addComponent(tf_prezime)
                            .addComponent(tf_telefon)
                            .addComponent(tf_email)
                            .addComponent(tf_datum)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPolise))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPronadji1)
                                .addGap(18, 18, 18)
                                .addComponent(jIzmeni)
                                .addGap(32, 32, 32)
                                .addComponent(jDodaj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(jObrisi)))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfr_br, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_ime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_prezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_datum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPronadji1)
                            .addComponent(jIzmeni)
                            .addComponent(jDodaj)
                            .addComponent(jObrisi))
                        .addGap(56, 56, 56)
                        .addComponent(jPolise)
                        .addGap(23, 23, 23))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPronadji1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPronadji1ActionPerformed
        System.out.println("Dugme pronadji pritisnuto");

        if (tfr_br.getText().isEmpty()) {
            System.out.println("Molimo Vas unesite broj");
        } else {
            System.out.println("Redni broj: = " + tfr_br.getText());
            this.id = Integer.parseInt(tfr_br.getText());
            pronadjiUBazi();
            
            tf_ime.setText(ime);
            tf_prezime.setText(prezime);
            tf_telefon.setText(telefon);
            tf_email.setText(email);
            tf_datum.setText(datum);
        }
    }//GEN-LAST:event_jPronadji1ActionPerformed

    private void pronadjiUBazi() {
        try {
            baza.poveziSaBazom();
            id = Integer.parseInt(tfr_br.getText());

            String naredbaSQL = "SELECT * FROM AGENTI WHERE ID = " + id;

            ResultSet rezultat = baza.naredba1.executeQuery(naredbaSQL);
            
            while (rezultat.next()) {
                ime = rezultat.getString("ime");
                prezime = rezultat.getString("prezime");
                telefon = rezultat.getString("telefon");
                email = rezultat.getString("email");
                datum = rezultat.getString("datum_zaposlenja");
            }
        } catch (Exception e) {
            System.out.println("Izuzetak izbacen: " + e.getMessage());
        } finally {
            try {
                if (baza.naredba1 != null) {
                    baza.naredba1.close();
                }
                
                if (baza.dbConn != null) {
                    baza.dbConn.close();
                }
            } catch (SQLException sqle) {
                System.out.println("SQLIzuzetak za vreme close()! " + sqle.getMessage());
            }
        }
    }
    
    private void jIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIzmeniActionPerformed
        System.out.println("Dugme izmeni pritisnuto.");

        if (tfr_br.getText().isEmpty()) {
            System.out.println("Molim Vas unesite mesto.");
        } else {
            azuriratiBazu();
        }  
    }//GEN-LAST:event_jIzmeniActionPerformed

    private void azuriratiBazu() {
        try {
            baza.poveziSaBazom();
            id = Integer.parseInt(tfr_br.getText());
            ime = tf_ime.getText().replace("'", "");
            prezime = tf_prezime.getText().replace("'", "");
            telefon = tf_telefon.getText().replace("'", "");
            email = tf_email.getText().replace("'", "");
            datum = tf_datum.getText().replace("'", "");
            
            String azurirajQuery = "UPDATE AGENTI SET ime = '" + ime + "', prezime = '" + prezime + "', telefon = '" + telefon + "', email = '" + email + "', datum_zaposlenja = '" + datum + "' WHERE ID = " + id + "";
            baza.naredba1.executeUpdate(azurirajQuery);
        } catch (Exception e) {
            System.out.println("Javila se greska prilikom izmene: " + e.getMessage());
        } finally {
            try {
                if (baza.naredba1 != null) {
                    baza.naredba1.close();
                }
                
                if (baza.dbConn != null) {
                    baza.dbConn.close();
                }
            } catch (SQLException sqlEx) {
                System.out.println("SQL izuzetak za vreme close(): " + sqlEx.getMessage());
            }
        }
    }
    
    private void jDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDodajActionPerformed
        System.out.println("Dugme dodaj pritisnuto.");

        if (tfr_br.getText().equals("")) {
            System.out.println("Molim Vas, unesite nesto.");
        } else {
            dodajUBazu();
        }
    }//GEN-LAST:event_jDodajActionPerformed

    private void jObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jObrisiActionPerformed
        System.out.println("Dugme obrisi pritisnuto!");

        if (tfr_br.getText().isEmpty()) {
            System.out.println("Molim Vas, unesite id.");
        } else {
            izbrisiIzBaze();
        }
    }                                       

    private void izbrisiIzBaze() {
        try {
            baza.poveziSaBazom();
            id = Integer.parseInt(tfr_br.getText());

            String izbrisiQuery = "DELETE FROM AGENTI WHERE ID = " + id;
            System.out.println(izbrisiQuery);
            baza.naredba1.executeUpdate(izbrisiQuery);
        } catch (Exception e) {
            System.out.println("Greska prilikom brisanja!" + e.getMessage());
        } finally {
            try {
                if (baza.naredba1 != null) {
                    baza.naredba1.close();
                }
                
                if (baza.dbConn != null) {
                    baza.dbConn.close();
                }
            } catch (SQLException sqlEx) {
                System.out.println("Greska prilikom zatvaranja baze! " + sqlEx.getMessage());
            }
        }
    }//GEN-LAST:event_jObrisiActionPerformed

    private void jPoliseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPoliseActionPerformed
        PregledPolisa pan = new PregledPolisa();
        pan.setVisible(true);
    }//GEN-LAST:event_jPoliseActionPerformed

    private void dodajUBazu() {
        try {
            baza.poveziSaBazom();
            id = Integer.parseInt(tfr_br.getText());
            ime = tf_ime.getText().replace("'", "");
            prezime = tf_prezime.getText().replace("'", "");
            telefon = tf_telefon.getText().replace("'", "");
            email = tf_email.getText().replace("'", "");
            datum = tf_datum.getText().replace("'", "");

            String proveriQuery = "SELECT * FROM AGENTI WHERE ID = " + id;
            ResultSet r = baza.naredba1.executeQuery(proveriQuery);

            if (!r.next()) {
                String dodajQuery = "INSERT INTO AGENTI (id, ime, prezime, telefon, email, datum_zaposlenja)VALUES('" + id + "','" + ime + "','" + prezime + "', '" + telefon + "', '" + email + "', '" + datum + "')";
                System.out.println(dodajQuery);
                baza.naredba1.executeUpdate(dodajQuery);
            } else {
                System.out.println("Vec postoji taj redni broj.");
            }
        } catch (Exception e) {
            System.out.println("Neuspesno dodavanje u bazu!" + e.getMessage());
        } finally {
            try {
                if (baza.naredba1 != null) {
                    baza.naredba1.close();
                }
                
                if (baza.dbConn != null) {
                    baza.dbConn.close();
                }
            } catch (SQLException sqlEx) {
                System.out.println("Greska prilikom zatvaranja baze! " + sqlEx.getMessage());
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
            java.util.logging.Logger.getLogger(UnosAgenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnosAgenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnosAgenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnosAgenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UnosAgenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jDodaj;
    private javax.swing.JButton jIzmeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jObrisi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jPolise;
    private javax.swing.JButton jPronadji1;
    private javax.swing.JTextField tf_datum;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_ime;
    private javax.swing.JTextField tf_prezime;
    private javax.swing.JTextField tf_telefon;
    private javax.swing.JTextField tfr_br;
    // End of variables declaration//GEN-END:variables
}
