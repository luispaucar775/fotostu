
package clases;



import java.sql.*;


public class conexion {
    public static Connection conectar(){
        try {
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/bd_tercerob","root","");
            
            //fg
            return cn;
        } catch (Exception e) {
        }
        return (null);
    }

    public static Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
