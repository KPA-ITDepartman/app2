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
public class PregledPolisa extends javax.swing.JFrame {
    Baza baza = new Baza();
    String getAgenti = "SELECT * FROM agenti";
    String naredba = "SELECT polise.novcano_pokrice, polise.datum_vazenja_polise, polise.datum_kreiranja, klijenti.ime, klijenti.prezime, agenti.ime, agenti.prezime FROM polise JOIN klijenti ON "
            + "polise.klijent_id = klijenti.id JOIN agenti ON "
            + "polise.agent_id = agenti.id ";
    String uslov = " WHERE agenti.id = polise.agent_id";
    String uslov2 = "";
    String colNames[] = {"Novcano pokrice polise", "Datum vazenja polise", "Datum kreiranja polise", "Ime klijenta",
        "Prezime klijenta", "Ime agenta", "Prezime agenta"};
    
    public PregledPolisa() {
        initComponents();
        
        try {
            baza.poveziSaBazom();
            ResultSet rezultat = baza.naredba1.executeQuery(getAgenti);
            JViewport view = tableScroller.getViewport();
            
            while (rezultat.next()) {
                cb_agent.addItem(rezultat.getString("ime") + " " + rezultat.getString("prezime"));
            }
            
            Vector dataSet = new Vector();

            ResultSet rezultat2 = baza.naredba1.executeQuery(naredba);
            ResultSetMetaData md = rezultat2.getMetaData();
            int nColumns = md.getColumnCount() + 1;
            
            while (rezultat2.next()) {
                Vector rowData = new Vector();
                
                for (int i = 1; i < nColumns; i++) {
                    rowData.addElement(rezultat2.getObject(i));
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

        tableScroller = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lbl1 = new javax.swing.JLabel();
        cb_agent = new javax.swing.JComboBox<>();
        izvrsi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        lbl1.setText("Agent:");

        izvrsi.setText("Izvrši");
        izvrsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izvrsiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Pregled polisa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbl1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(154, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cb_agent, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(izvrsi)
                        .addGap(44, 44, 44))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tableScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 381, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_agent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl1)
                    .addComponent(izvrsi))
                .addGap(54, 54, 54))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(tableScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(119, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izvrsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izvrsiActionPerformed
        String imePrezimeAgenta = cb_agent.getSelectedItem().toString();
        String[] delovi = imePrezimeAgenta.split(" ");

        try {
            String getAgentQuery = "SELECT id FROM agenti WHERE ime = '" + delovi[0] + "' AND prezime = '" + delovi[1] + "'";
            baza.poveziSaBazom();
            ResultSet rezultat = baza.naredba1.executeQuery(getAgentQuery);
            JViewport view = tableScroller.getViewport();

            while (rezultat.next()) {
                uslov2 = " AND polise.agent_id=" + "'" + rezultat.getInt("id") + "'";
            }
            
            System.out.println(uslov2);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            uslov2 = "";
        }
        
        JViewport viewport = tableScroller.getViewport();
        viewport.remove(table);
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
            java.util.logging.Logger.getLogger(PregledPolisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PregledPolisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PregledPolisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PregledPolisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PregledPolisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_agent;
    private javax.swing.JButton izvrsi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScroller;
    // End of variables declaration//GEN-END:variables
}
