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
public class PregledDirektora extends javax.swing.JFrame {
    Baza baza = new Baza();
    String naredba = "SELECT IME_DIREKTORA, PREZIME_DIREKTORA FROM O_NAMA";
    String colNames[] = {"Ime Direktora", "Prezime Direktora"};
    
    public PregledDirektora() {
        initComponents();
        
        try {
            baza.poveziSaBazom();
            String query = "SELECT IME_DIREKTORA, PREZIME_DIREKTORA FROM O_NAMA";
            ResultSet rezultat = baza.naredba1.executeQuery(query);
            JViewport view = tableScroller.getViewport();

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
            String naredbaSQL = naredba;

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

        jPanel1 = new javax.swing.JPanel();
        tableScroller = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableScroller.setToolTipText("");

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
        tableScroller.setViewportView(table);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel2.setText("Pregled direktora");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tableScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(tableScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
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
            java.util.logging.Logger.getLogger(PregledDirektora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PregledDirektora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PregledDirektora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PregledDirektora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PregledDirektora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScroller;
    // End of variables declaration//GEN-END:variables
}
