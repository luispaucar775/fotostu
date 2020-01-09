
package ventanas;
import clases.conexion;
import java.sql.Connection;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class Dgraficar {
    Connection cn=conexion.conectar();
    
    public DefaultTableModel mostrarpersona(){
    
        DefaultTableModel miModelo=null;
 
        try {
            String titulos[]= {"id","nombre"};
            String dta[]=new String[2];
            miModelo=new DefaultTableModel(null,titulos);
            String sql="select * from personas";
            PreparedStatement pst=cn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            
            while(rs.next()){
            dta[0]=rs.getString("id_persona");
            dta[1]=rs.getString("nombre");
            miModelo.addRow(dta);
            
            
            
            }
            
        } catch (Exception e) {
        }
        return miModelo;
    }
public DefaultTableModel agruparpersona(){
    
        DefaultTableModel miModelo=null;
 
        try {
            String titulos[]= {"nombre","cuentas_persona"};
            String dta[]=new String[2];
            miModelo=new DefaultTableModel(null,titulos);
            String sql="select nombre, count(nombre) from personas group by nombre";
            PreparedStatement pst=cn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            
            while(rs.next()){
            dta[0]=rs.getString("nombre");
            dta[1]=rs.getString("count(nombre)");
            miModelo.addRow(dta);
            
            
            
            }
            
        } catch (Exception e) {
        }
        return miModelo;
    }
public DefaultTableModel mostrargenero(){
    
        DefaultTableModel miModelo=null;
 
        try {
            String titulos[]= {"cantidad", "genero", "dia"};
            String dta[]=new String[3];
            miModelo=new DefaultTableModel(null,titulos);
            String sql="select cantidad , genero, dia from cuentas";
            PreparedStatement pst=cn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            
            while(rs.next()){
            dta[0]=rs.getString("cantidad");
            dta[1]=rs.getString("genero");
            dta[2]=rs.getString("dia");
            miModelo.addRow(dta);
            
            
            
            }
            
        } catch (Exception e) {
        }
        return miModelo;
    }
}


