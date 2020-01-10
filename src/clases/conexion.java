
package clases;



import java.sql.*;


public class conexion {
    public static Connection conectar(){
        try {
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/foto_studio","root","");
            
            
            return cn;
        } catch (Exception e) {
        }
        return (null);
    }
    
}
