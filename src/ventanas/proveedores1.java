
package ventanas;

// Autor Freddy Sanango Morales
import clases.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// creacion de la clase proveedores
public class proveedores1 extends javax.swing.JFrame {
  conexion cn=new conexion();
Connection coneccion=cn.conectar();

    
    public proveedores1() {
        initComponents();
           this.setLocationRelativeTo(null);
    }
    // metodo para llamar a las tablas de proveedores
    public void verdatos(String valor){
    
    DefaultTableModel modelo=new  DefaultTableModel();
    modelo.addColumn("ID");
     modelo.addColumn("NOMBRE");
    modelo.addColumn("TELEFONO");
    modelo.addColumn("DIRECCION");
   modelo.addColumn("MAIL");
    tbTienda.setModel(modelo);
    
    String sql="";
    
    if(valor.equals("")){
        sql="SELECT * from proveedores";
    }else{
        sql="SELECT * from proveedores WHERE DENOMINACION='"+valor+"'";
        
        
    }
    String datos[]=new String[5];
    
    try {
       Statement st=coneccion.createStatement();
       ResultSet rs=st.executeQuery(sql);
       
       while (rs.next()){
       datos[0]=rs.getString(5);
        datos[1]=rs.getString(1);
        datos[2]=rs.getString(4);
        datos[3]=rs.getString(2);
        datos[4]=rs.getString(3);
        modelo.addRow(datos);
    }
       tbTienda.setModel(modelo);
    } catch (Exception e) {
    }
}
      public void verCliente(String nombre){
        String sql="";
        if (nombre.equals("")){
            sql="Select * from proveedores";
        }else{
            sql="Select * from  proveedores where nombre='"+ nombre+"'";
        }
            String id="";
            String Nombre="";
             String telefono="";
            String mail="";
            String direccion="";
            
            try {
                Statement st=coneccion.createStatement();
                ResultSet rs=st.executeQuery(sql);
                while(rs.next()){
                id=rs.getString(5);
                Nombre=rs.getString(1);
                telefono=rs.getString(4);
                direccion=rs.getString(2);
                mail=rs.getString(3);
                 JOptionPane.showMessageDialog(null, "LOS DATOS FUERON ENCONTRADOS");
                verdatos("");
            }
                txtnombre.setText(String.valueOf(Nombre));
                  txtid.setText(String.valueOf(id));
                   txttelefono.setText(String.valueOf(telefono));
                  txtgmail.setText(String.valueOf(mail));
                   txtdireccion.setText(String.valueOf(direccion));
            } catch (Exception e) {
              
            }
       
        
    }
     
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbTienda = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnmostrar = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        Nombre13 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        btneliminar1 = new javax.swing.JButton();
        btninventario = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtgmail = new javax.swing.JTextField();
        btnclientes = new javax.swing.JButton();
        btnin = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Yu Gothic Light", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 0));
        jLabel8.setText("Foto Store");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, 50));

        tbTienda.setForeground(new java.awt.Color(51, 51, 51));
        tbTienda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbTienda);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 950, 222));

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 230, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 0));
        jLabel9.setFont(new java.awt.Font("Footlight MT Light", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 153));
        jLabel9.setText("Id_proveedor");
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 160, 32));

        jLabel37.setBackground(new java.awt.Color(255, 255, 0));
        jLabel37.setFont(new java.awt.Font("Yu Gothic Light", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(153, 0, 153));
        jLabel37.setText("Telefono");
        jLabel37.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 160, 32));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 230, 30));

        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });
        getContentPane().add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 230, 40));

        btnGuardar.setBackground(new java.awt.Color(153, 153, 153));
        btnGuardar.setFont(new java.awt.Font("Footlight MT Light", 0, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 390, 134, 40));

        btnmostrar.setBackground(new java.awt.Color(153, 153, 153));
        btnmostrar.setFont(new java.awt.Font("Footlight MT Light", 0, 12)); // NOI18N
        btnmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hh.png"))); // NOI18N
        btnmostrar.setText("MOSTRA DATOS");
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 341, -1, 40));

        jLabel38.setBackground(new java.awt.Color(255, 255, 0));
        jLabel38.setFont(new java.awt.Font("Yu Gothic Light", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(153, 0, 153));
        jLabel38.setText("Direccion");
        jLabel38.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 150, 40));

        Nombre13.setBackground(new java.awt.Color(255, 255, 0));
        Nombre13.setFont(new java.awt.Font("Yu Gothic Light", 1, 24)); // NOI18N
        Nombre13.setForeground(new java.awt.Color(153, 0, 153));
        Nombre13.setText("Nombre");
        Nombre13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Nombre13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 160, 32));
        getContentPane().add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 240, 230, 30));

        btneliminar1.setBackground(new java.awt.Color(153, 153, 153));
        btneliminar1.setFont(new java.awt.Font("Footlight MT Light", 0, 12)); // NOI18N
        btneliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btneliminar1.setText("ELIMINAR ");
        btneliminar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btneliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 390, 130, 44));

        btninventario.setBackground(new java.awt.Color(153, 153, 153));
        btninventario.setFont(new java.awt.Font("Footlight MT Light", 0, 12)); // NOI18N
        btninventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        btninventario.setText("IR A MENU PRINCIPAL");
        btninventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btninventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btninventarioMouseClicked(evt);
            }
        });
        btninventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninventarioActionPerformed(evt);
            }
        });
        getContentPane().add(btninventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 7, 190, 50));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Footlight MT Light", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        jButton1.setText("SALIR DEL PROGRAMA");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 460, 190, 40));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Yu Gothic Light", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 204));
        jLabel3.setText("PROVEEDORES");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 200, -1));

        jLabel39.setBackground(new java.awt.Color(255, 255, 0));
        jLabel39.setFont(new java.awt.Font("Yu Gothic Light", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(153, 0, 153));
        jLabel39.setText("E-mail");
        jLabel39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 290, 150, 32));

        txtgmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtgmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 290, 230, 30));

        btnclientes.setBackground(new java.awt.Color(153, 153, 153));
        btnclientes.setFont(new java.awt.Font("Footlight MT Light", 0, 12)); // NOI18N
        btnclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconfinder_customers_49500.png"))); // NOI18N
        btnclientes.setText("CLIENTES");
        btnclientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnclientesMouseClicked(evt);
            }
        });
        getContentPane().add(btnclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 150, 50));

        btnin.setBackground(new java.awt.Color(153, 153, 153));
        btnin.setFont(new java.awt.Font("Footlight MT Light", 0, 12)); // NOI18N
        btnin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconfinder_to-do-list_checked3_15154.png"))); // NOI18N
        btnin.setText("INVENTARIO");
        btnin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btninMouseClicked(evt);
            }
        });
        btnin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninActionPerformed(evt);
            }
        });
        getContentPane().add(btnin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 160, 50));

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Footlight MT Light", 0, 12)); // NOI18N
        jButton2.setText("LIMPIAR");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 390, 140, 40));

        btnbuscar.setBackground(new java.awt.Color(153, 153, 153));
        btnbuscar.setFont(new java.awt.Font("Footlight MT Light", 0, 12)); // NOI18N
        btnbuscar.setText("BUSCAR");
        btnbuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 140, 30));

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 230, 30));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Footlight MT Light", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_1.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String id=txtid.getText();
        String denominacion=txtnombre.getText();
        String cantidad=txttelefono.getText();
        String precioP=txtdireccion.getText();
        String precioC=txtgmail.getText();
        
        
        if(id.equals("")){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR ID");
        }
           
        if(denominacion.equals("")){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR NOMBRE");
        }
         if(cantidad.equals("")){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR TELEFONO");
        }
          if(precioP.equals("")){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR DIRECCION");
        }
           if(precioC.equals("")){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR GMAIL");
        }
           
        try {

            String Query="INSERT INTO proveedores (Id,nombre,telefono,direccion,correo)values(?,?,?,?,?)";
            PreparedStatement statement=coneccion.prepareStatement(Query);
            
            statement.setString(1,txtid.getText());
            statement.setString(2,txtnombre.getText());
            statement.setString(3,txttelefono.getText());
            statement.setString(4,txtgmail.getText());
            statement.setString(5,txtdireccion.getText());
           JOptionPane.showMessageDialog(null,"DATOS GUARDADOS");
            statement.executeUpdate();
                    verdatos("");
      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"DATOS NO GUARDADOS");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed
        // TODO add your handling code here:
        verdatos("");
    }//GEN-LAST:event_btnmostrarActionPerformed

    private void btneliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar1ActionPerformed
        // TODO add your handling code here:
  
        int fila=tbTienda.getSelectedRow();

        String cod="";
        cod=tbTienda.getValueAt(fila,0).toString();
        try {
            PreparedStatement pst=coneccion.prepareStatement("DELETE from proveedores WHERE Id='"+cod+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"DATOS ELIMINADOS");
            verdatos("");
           
        } catch (Exception e) {
        }
      
    }//GEN-LAST:event_btneliminar1ActionPerformed

    private void btninventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btninventarioMouseClicked
        // TODO add your handling code here:
     
    }//GEN-LAST:event_btninventarioMouseClicked

    private void btninventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btninventarioActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtgmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgmailActionPerformed

    private void btnclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclientesMouseClicked
         clientes c = new clientes();
        c.setVisible(true);
        this.dispose();
                      
    }//GEN-LAST:event_btnclientesMouseClicked

    private void btninMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btninMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btninMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         txtbuscar.setText("");
        txtnombre.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtgmail.setText("");
         txtbuscar.setText("");
         txtid.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        verCliente(txtbuscar.getText());
        verdatos("");
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void btninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btninActionPerformed

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
            java.util.logging.Logger.getLogger(proveedores1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(proveedores1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(proveedores1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(proveedores1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new proveedores1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre13;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnclientes;
    private javax.swing.JButton btneliminar1;
    private javax.swing.JButton btnin;
    private javax.swing.JButton btninventario;
    private javax.swing.JButton btnmostrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable tbTienda;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtgmail;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
