package ventanas;

import clases.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class inventario extends javax.swing.JFrame {
// miguel eduardo chimbo guamantario
    Connection cn=conexion.conectar();

    public inventario() {
        initComponents();
        this.setLocationRelativeTo(null);
        calcularTotal();
    }

    public void verdatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO Al PUBLICO");
        modelo.addColumn("PRECIO DE COMPRA");
        modelo.addColumn("TOTAL");
        
        
        tbTienda.setModel(modelo);

        String sql = "";

        if (valor.equals("")) {
            sql = "SELECT * from Tienda";
        } else {
            sql = "SELECT * from Tienda WHERE DENOMINACION='" + valor + "'";

        }
        String datos[] = new String[6];

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(6);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(4);
               
                
               
                modelo.addRow(datos);
            }
            tbTienda.setModel(modelo);
        } catch (Exception e) {
        }
       
    }
          public void calcularTotal(){
        double subtotal,iva,total;
        subtotal=0;
      for(int i=0;i<tbTienda.getRowCount();i++){
          subtotal=subtotal+Double.parseDouble(tbTienda.getValueAt(i,5).toString());
      }
      lblsubtotal.setText(String.valueOf(Math.round(subtotal)));
      iva=subtotal*0.12;
      lbliva.setText(String.valueOf(Math.round(iva)));
      total=subtotal+iva;
      lbltotal.setText(String.valueOf(Math.round(total)));
          }
      public static String pregunta(String strMensaje ) {
         int seleccion=JOptionPane.showOptionDialog(null, strMensaje,"SELECCIONO",
                 JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,new Object[]{"SI","NO"},"SI");
                  
          if(seleccion !=-1){
              if((seleccion+ 1)==1)
                  return "SI";
          }else{
              return "NO";}
      return null;
      
      }
       public void verCliente(String denominacion){
        String sql="";
        if (denominacion.equals("")){
            sql="Select * from clientes";
        }else{
            sql="Select * from Tienda where denominacion='"+ denominacion+"'";
        }
            String cantidad="";
            String nombre="";
             String precioP="";
            String prcioC="";
            String ID="";
            
            try {
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(sql);
               

                while(rs.next()){
                    ID=rs.getString(1);
                cantidad=rs.getString(3);
                nombre=rs.getString(2);
                precioP=rs.getString(6);
                prcioC=rs.getString(5);
               JOptionPane.showMessageDialog(null, "SE ENCONTRO CORRECTAMENTE");
                verdatos("");
                           }
              
                txtdenominacion.setText(String.valueOf(nombre));
                  txtPrecio.setText(String.valueOf(precioP));
                   txtcompra.setText(String.valueOf(prcioC));
                  txtCantidad.setText(String.valueOf(cantidad));
                 txtid.setText(String.valueOf(ID));
                   
            } catch (Exception e) {
                
            }
       
        
    }
      
      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbTienda = new javax.swing.JTable();
        txtid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtdenominacion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnmostrar = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        Nombre13 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btneliminar1 = new javax.swing.JButton();
        btninventario = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnprovedores = new javax.swing.JButton();
        btnclientes = new javax.swing.JButton();
        txtcompra = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        lbliva = new javax.swing.JLabel();
        lblsubtotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        btnstock = new javax.swing.JButton();
        btnprovedores1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(204, 0, 51));
        jLabel8.setFont(new java.awt.Font("Footlight MT Light", 3, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 255, 102));
        jLabel8.setText("\"FOTO STUDIO\"");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 500, 68));

        tbTienda.setForeground(new java.awt.Color(51, 51, 51));
        tbTienda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbTienda);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 800, 190));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 140, -1));

        jLabel9.setBackground(new java.awt.Color(204, 0, 51));
        jLabel9.setFont(new java.awt.Font("Footlight MT Light", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 255, 102));
        jLabel9.setText("id_Producto");
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 150, 32));

        jLabel37.setBackground(new java.awt.Color(204, 0, 51));
        jLabel37.setFont(new java.awt.Font("Footlight MT Light", 3, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 255, 102));
        jLabel37.setText("Cantidad");
        jLabel37.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 120, 32));
        getContentPane().add(txtdenominacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 140, -1));

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 140, -1));

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Stylus BT", 3, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 130, 40));

        btnmostrar.setBackground(new java.awt.Color(204, 204, 204));
        btnmostrar.setFont(new java.awt.Font("Stylus BT", 3, 12)); // NOI18N
        btnmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hh.png"))); // NOI18N
        btnmostrar.setText("MOSTRA DATOS");
        btnmostrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 180, 50));

        jLabel38.setBackground(new java.awt.Color(204, 0, 51));
        jLabel38.setFont(new java.awt.Font("Footlight MT Light", 3, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 255, 102));
        jLabel38.setText("Precio de compra");
        jLabel38.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 210, 32));

        Nombre13.setBackground(new java.awt.Color(204, 0, 51));
        Nombre13.setFont(new java.awt.Font("Footlight MT Light", 3, 24)); // NOI18N
        Nombre13.setForeground(new java.awt.Color(102, 255, 102));
        Nombre13.setText("Nombre");
        Nombre13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Nombre13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 110, 32));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 140, -1));

        btneliminar1.setBackground(new java.awt.Color(204, 204, 204));
        btneliminar1.setFont(new java.awt.Font("Stylus BT", 3, 12)); // NOI18N
        btneliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btneliminar1.setText("ELIMINAR ");
        btneliminar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btneliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 140, 50));

        btninventario.setBackground(new java.awt.Color(204, 204, 204));
        btninventario.setFont(new java.awt.Font("Stylus BT", 3, 12)); // NOI18N
        btninventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        btninventario.setText("IR A LA FACTORICACION");
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
        getContentPane().add(btninventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 210, 50));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Stylus BT", 3, 12)); // NOI18N
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1062, 504, 190, 40));

        btnprovedores.setBackground(new java.awt.Color(204, 204, 204));
        btnprovedores.setFont(new java.awt.Font("Stylus BT", 3, 12)); // NOI18N
        btnprovedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/prove.png"))); // NOI18N
        btnprovedores.setText("PROVEEDORES");
        btnprovedores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnprovedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnprovedoresMouseClicked(evt);
            }
        });
        btnprovedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprovedoresActionPerformed(evt);
            }
        });
        getContentPane().add(btnprovedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, -1, 40));

        btnclientes.setBackground(new java.awt.Color(204, 204, 204));
        btnclientes.setFont(new java.awt.Font("Stylus BT", 3, 12)); // NOI18N
        btnclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconfinder_customers_49500.png"))); // NOI18N
        btnclientes.setText("CLIENTES");
        btnclientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnclientesMouseClicked(evt);
            }
        });
        btnclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 120, 40));

        txtcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcompraActionPerformed(evt);
            }
        });
        getContentPane().add(txtcompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 140, -1));

        jLabel39.setBackground(new java.awt.Color(204, 0, 51));
        jLabel39.setFont(new java.awt.Font("Footlight MT Light", 3, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 255, 102));
        jLabel39.setText("Precio al publico");
        jLabel39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 210, 30));

        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("IVA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, -1, -1));

        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("TOTAL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 380, 41, -1));

        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("SUB TOTAL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 320, 70, -1));

        lbltotal.setForeground(new java.awt.Color(51, 255, 51));
        lbltotal.setText("---------");
        getContentPane().add(lbltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 380, 50, -1));

        lbliva.setForeground(new java.awt.Color(51, 255, 51));
        lbliva.setText("---------");
        getContentPane().add(lbliva, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 360, 50, -1));

        lblsubtotal.setForeground(new java.awt.Color(51, 255, 51));
        lblsubtotal.setText("---------");
        getContentPane().add(lblsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 330, 50, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel4.setText("INVENTARIO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 110, -1));

        btnlimpiar.setBackground(new java.awt.Color(204, 204, 204));
        btnlimpiar.setFont(new java.awt.Font("Stylus BT", 3, 12)); // NOI18N
        btnlimpiar.setText("LIMPIAR");
        btnlimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnlimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlimpiarMouseClicked(evt);
            }
        });
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 450, 135, 40));

        btnbuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnbuscar.setFont(new java.awt.Font("Stylus BT", 3, 12)); // NOI18N
        btnbuscar.setText("BUSCAR");
        btnbuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 110, -1));

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 140, -1));

        btnstock.setBackground(new java.awt.Color(204, 204, 204));
        btnstock.setFont(new java.awt.Font("Stylus BT", 3, 12)); // NOI18N
        btnstock.setText("STOCK");
        btnstock.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnstock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnstockMouseClicked(evt);
            }
        });
        btnstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstockActionPerformed(evt);
            }
        });
        getContentPane().add(btnstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, 135, 40));

        btnprovedores1.setBackground(new java.awt.Color(204, 204, 204));
        btnprovedores1.setFont(new java.awt.Font("Stylus BT", 3, 12)); // NOI18N
        btnprovedores1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/prove.png"))); // NOI18N
        btnprovedores1.setText("PROVEEDORES");
        btnprovedores1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnprovedores1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnprovedores1MouseClicked(evt);
            }
        });
        btnprovedores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprovedores1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnprovedores1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, -1, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_1.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -20, 1320, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
         String id=txtid.getText();
        String denominacion=txtdenominacion.getText();
          String cantidad=txtCantidad.getText();
            String precioP=txtPrecio.getText();
              String precioC=txtcompra.getText();
        
        
        if(id.equals("")){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR ID");
        }
           
        if(denominacion.equals("")){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR NOMBRE");
        }
         if(cantidad.equals("")){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR CANTIDAD");
        }
          if(precioP.equals("")){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR PRECIO AL PUBLICO");
        }
           if(precioC.equals("")){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR PRECIO DE COMPRA");
        }
     
     
        try {
            

            String Query = "INSERT INTO Tienda(Id,denominacion,cantidad,precio_publico,precio_compra)values(?,?,?,?,?)";
            PreparedStatement statement = coneccion.prepareStatement(Query);
            statement.setString(1, txtid.getText());
            statement.setString(2, txtdenominacion.getText());
            statement.setString(3, txtCantidad.getText());
            statement.setString(4, txtPrecio.getText());
            statement.setString(5, txtcompra.getText());
            JOptionPane.showMessageDialog(null, "GUARDADO");
            statement.executeUpdate();
            verdatos("");

        } catch (Exception e) {

        }
         
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btneliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar1ActionPerformed
        // TODO add your handling code here:
      
     JOptionPane.showMessageDialog(null, "TIENE QUE SECCIONAR UN DATOS DE LA TABLA");
        int fila = tbTienda.getSelectedRow();

        String cod = "";
        
        cod = tbTienda.getValueAt(fila, 0).toString();
     
        
       
        try {
          
            PreparedStatement pst = coneccion.prepareStatement("DELETE from Tienda WHERE Id ='" + cod + "'");
            pst.executeUpdate();
             verdatos("");
             JOptionPane.showMessageDialog(null, "SE ELIMINO CORECCTAMENTE");
           
        } catch (Exception e) {
           
        }
        
      
    }//GEN-LAST:event_btneliminar1ActionPerformed

    private void btninventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btninventarioMouseClicked
        // TODO add your handling code here:
        facturacionn f = new facturacionn();
        f.setVisible(true);
        this.dispose();
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

    private void btnclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclientesMouseClicked
        // TODO add your handling code here:
        clientes c = new clientes();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnclientesMouseClicked

    private void txtcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcompraActionPerformed

    private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed

        verdatos("");
        calcularTotal();
    }//GEN-LAST:event_btnmostrarActionPerformed

    private void btnclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnclientesActionPerformed

    private void btnprovedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprovedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnprovedoresActionPerformed

    private void btnprovedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprovedoresMouseClicked
        // TODO add your handling code here:
        proveedores f = new proveedores();
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnprovedoresMouseClicked

    private void btnlimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlimpiarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlimpiarMouseClicked

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        // TODO add your handling code here:
      txtid.setText("");
        txtdenominacion.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtcompra.setText("");
         txtbuscar.setText("");
        
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
          verCliente(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnstockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnstockMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnstockMouseClicked

    private void btnstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstockActionPerformed
        categoria c=new categoria();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnstockActionPerformed

    private void btnprovedores1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprovedores1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnprovedores1MouseClicked

    private void btnprovedores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprovedores1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnprovedores1ActionPerformed

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
            java.util.logging.Logger.getLogger(inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre13;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnclientes;
    private javax.swing.JButton btneliminar1;
    private javax.swing.JButton btninventario;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnmostrar;
    private javax.swing.JButton btnprovedores;
    private javax.swing.JButton btnprovedores1;
    private javax.swing.JButton btnstock;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbliva;
    private javax.swing.JLabel lblsubtotal;
    private javax.swing.JLabel lbltotal;
    public javax.swing.JTable tbTienda;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcompra;
    private javax.swing.JTextField txtdenominacion;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
