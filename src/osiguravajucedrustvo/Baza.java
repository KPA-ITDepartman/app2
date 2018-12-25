/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package osiguravajucedrustvo;

import java.sql.*;

/**
 *
 * @author Ema
 */
public class Baza {
    
    Connection dbConn = null;
    Statement naredba1 = null;
    
    public void poveziSaBazom(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            //uspostavljanje veze
            dbConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","emma","Emaprogramer123");

            //ako je veza ok
            System.out.println("Veza sa bazom je: "+dbConn);
            System.out.println("Veza uspostavljena\\n");
            // pa sta je problem? ispisuje ti da je konekcija uspela pa radim aplikaciju nece da mi prikace rezultat
            
            naredba1 = dbConn.createStatement();
        }
        catch (Exception e){
            System.out.println("Greska je izbacena: "+e.getMessage());
        }
    }
    public void zatvoriBazu(){
        try{
            if (naredba1 != null)
                naredba1.close();
            if (dbConn != null)
                dbConn.close();
        }
        catch (Exception e){
            System.out.println("SQL izuzetak za vreme  close(): "+e.getMessage());
        }
}
}
