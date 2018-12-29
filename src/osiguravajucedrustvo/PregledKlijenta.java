/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osiguravajucedrustvo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JViewport;

/**
 *
 * @author emma
 */
public class PregledKlijenta extends javax.swing.JFrame {
    Baza baza = new Baza();
    String naredba = "SELECT klijenti.ime, klijenti.prezime, klijenti.jmbg,"
            + "klijenti.adresa,klijenti.telefon,tipovi_klijenta.naziv FROM klijenti JOIN tipovi_klijenta ON "
            + "klijenti.tip_klijenta = tipovi_klijenta.id ";
    String uslov = " WHERE klijenti.tip_klijenta = TIPOVI_KLIJENTA.id";
    String uslov2 = "";
    String colNames[] = {"Ime", "Prezime", "JMBG", "Adresa", "Telefon", "Tip klijenta"};

    public PregledKlijenta() {
        initComponents();

        try {
            baza.poveziSaBazom();
            String query = "SELECT naziv FROM TIPOVI_KLIJENTA";
            ResultSet rezultat = baza.naredba1.executeQuery(query);
            JViewport view = tableScroller.getViewport();

            while (rezultat.next()) {
                cb_tip.addItem(rezultat.getString("naziv"));
            }

            Vector dataSet = new Vector();

            ResultSet rezultat1 = baza.naredba1.executeQuery(naredba);
            ResultSetMetaData md = rezultat1.getMetaData();
            int nColumns = md.getColumnCount() + 1;
            
            while (rezultat1.next()) {
                Vector rowData = new Vector();
            
                for (int i = 1; i < nColumns; i++) {
                    rowData.addElement(rezultat1.getObject(i));
                }
                
                dataSet.addElement(rowData);
            }
            
            int nRows = dataSet.size();
            String[][] rowDataS = new String[nRows][colNames.length];
            
            for (int i = 0; i < nRows; i++) {
                Vector row = (Vector) dataSet.elementAt(i);
                
                for (int j = 0; j < row.size(); j++) {
                    rowDataS[i][j] = ((Object) row.elementAt(j)).toString();
                }
            }
            
            JTable table = new JTable(rowDataS, colNames);
            view.add(table);
        } catch (Exception e) {
            System.out.println("Problem ComboBox : " + e);
        } finally {
            try {
                if (baza.naredba1 != null) {
                    baza.naredba1.close();
                }
                
                if (baza.dbConn != null) {
                    baza.dbConn.close();
                }
            } catch (SQLException sqlEx) {
                System.out.println("Greska sa bazom u konstrukturu! " + sqlEx);
            }
        }
    }
    
    public JTable createTable() {
        Vector dataSet = new Vector();
        JTable tableResult = null;
        
        try {
            baza.poveziSaBazom();
            String naredbaSQL = naredba + uslov + uslov2;

            System.out.println(naredbaSQL);

            ResultSet rezultat1 = baza.naredba1.executeQuery(naredbaSQL);
            ResultSetMetaData md = rezultat1.getMetaData();
            int nColumns = md.getColumnCount() + 1;
            
            while (rezultat1.next()) {
                Vector rowData = new Vector();
                
                for (int i = 1; i < nColumns; i++) {
                    rowData.addElement(rezultat1.getObject(i));
                }
               
                dataSet.addElement(rowData);
            }
            
            int nRows = dataSet.size();
            String[][] rowDataS = new String[nRows][colNames.length];
            
            for (int i = 0; i < nRows; i++) {
                Vector row = (Vector) dataSet.elementAt(i);
                
                for (int j = 0; j < row.size(); j++) {
                    rowDataS[i][j] = ((Object) row.elementAt(j)).toString();
                }
            }
            
            tableResult = new JTable(rowDataS, colNames);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (baza.naredba1 != null) {
                    baza.naredba1.close();
                }
                
                if (baza.dbConn != null) {
                    baza.dbConn.close();
                }
            } catch (SQLException sqle) {
                System.out.println("SQLIzuzetak za vreme close(): "
                        + sqle.getMessage());
            }
        }
            
        return tableResult;
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
        jPanel1 = new javax.swing.JPanel();
        tableScroller = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lbl1 = new javax.swing.JLabel();
        cb_tip = new javax.swing.JComboBox<>();
        izvrsi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("Pregled klijenta");

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableScroller.setViewportView(table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(39, Short.MAX_VALUE)
                    .addComponent(tableScroller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tableScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE)))
        );

        lbl1.setText("Tip:");

        izvrsi.setText("Izvrši");
        izvrsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izvrsiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1)
                        .addGap(0, 115, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lbl1)
                        .addGap(18, 18, 18)
                        .addComponent(cb_tip, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(izvrsi)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(izvrsi)
                    .addComponent(cb_tip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl1))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izvrsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izvrsiActionPerformed
        uslov2 = " AND tipovi_klijenta.naziv = " + "'" + cb_tip.getSelectedItem().toString()
                    + "'";
        
        JViewport viewport = tableScroller.getViewport();
        viewport.remove(tableScroller);
        JTable table2 = createTable();
        viewport.add(table2);


    }//GEN-LAST:event_izvrsiActionPerformed

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
            java.util.logging.Logger.getLogger(PregledKlijenta.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        



} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PregledKlijenta.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        



} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PregledKlijenta.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        



} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PregledKlijenta.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PregledKlijenta().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_tip;
    private javax.swing.JButton izvrsi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScroller;
    // End of variables declaration//GEN-END:variables
}