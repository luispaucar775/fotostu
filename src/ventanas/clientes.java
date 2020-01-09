
package ventanas;
import java.sql.*;
import clases.conexion;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class clientes extends javax.swing.JFrame {
    int a=0;
    int b=0;

    
    public clientes() {
        initComponents();
        setLocationRelativeTo(null);
        
        //descargar nombres desde la tabla.
        try {
            Connection cn=conexion.conectar();
            PreparedStatement pst=cn.prepareStatement("select * from clientes");
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                comboProductos.addItem(rs.getString("producto"));
                
            }
            
        } catch (Exception e) {
        }
        try {
            Connection cn=conexion.conectar();
            PreparedStatement pst=cn.prepareStatement("select * from clientes");
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                comboClientes.addItem(rs.getString("nombreCliente"));
                
            }
        } catch (Exception e) {
        }
        
    }
    
    

   public void mostrarDatos(String valor){
       DefaultTableModel modelo=new DefaultTableModel();
       modelo.addColumn("ID");
       modelo.addColumn("NOMBRE_CLIENTE");
       modelo.addColumn("MAIL");
       modelo.addColumn("PRODUCTO");
       modelo.addColumn("CANTIDAD");
       modelo.addColumn("PRECIO_UNITARIO");
       modelo.addColumn("PRECIO_TOTAL");
       
       String sql="";
       
       if(valor.equals("")){
         sql="select * from clientes";  
       }else{
           sql="select id_cliente ID, nombreCliente NOMBRE_CLIENTE, mailCliente MAIL, producto PRODUCTO, cantidad CANTIDAD, precioUnitario PRECIO_UNITARIO, cantidad*precioUnitario PRECIO_TOTAL from clientes where id_cliente='"+txtBuscar.getText()+"'";
       }
       
       String []dato=new String[7];
       
       try {
           Connection cn=conexion.conectar();
           PreparedStatement pst=cn.prepareStatement(sql);
           ResultSet rs=pst.executeQuery();
           
           
           while(rs.next()){
               dato[0]=rs.getString(1);
               dato[1]=rs.getString(2);
               dato[2]=rs.getString(3);
               dato[3]=rs.getString(4);
               dato[4]=rs.getString(5);
               dato[5]=rs.getString(6);
               dato[6]=rs.getString(7);
               
               
               modelo.addRow(dato);
               
               
           }
           tbClientes.setModel(modelo);
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"ERROR"+e);
       }
       
   }
   
   public void calcularTotal(){
       double s=0,iva,total;
       
       for (int i=0;i<tbClientes.getRowCount();i++){
           s=s+Double.parseDouble(tbClientes.getValueAt(i,6).toString());
           
       }
       s=redondear(s);
       iva=0.12*s;
       iva=redondear(iva);
       total=iva+s;
       
       total=redondear(total);
       
       lblSubtotal.setText(String.valueOf(s));
       lbliva.setText(String.valueOf(iva));
       lblTotal.setText(String.valueOf(total));
   }
   
   
   public double redondear(double num){
       return Math.rint(num*100)/100;
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecioUnitario = new javax.swing.JTextField();
        txtPrecioTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lbliva = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnInsertarRegistro = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        comboClientes = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtCodigoClientes = new javax.swing.JTextField();
        btnProductos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaProductos = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        comboProductos = new javax.swing.JComboBox<>();
        txt_id_cliente = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtAgregarQuitar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Nombre Cliente:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Mail Cliente:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("Producto:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("Cantidad:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("Precio Unitario:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel6.setText("Precio Total:");

        txtCliente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        txtMail.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtProducto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtCantidad.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        txtPrecioUnitario.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtPrecioUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioUnitarioActionPerformed(evt);
            }
        });

        txtPrecioTotal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbClientes);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setText("Buscar Registro:");

        btnBuscar.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnBuscar.setText("Buscar Registro");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setText("Subtotal:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setText("IVA:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel10.setText("TOTAL:");

        lblSubtotal.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblSubtotal.setText("jLabel11");

        lbliva.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbliva.setText("jLabel12");

        lblTotal.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblTotal.setText("jLabel13");

        btnInsertarRegistro.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnInsertarRegistro.setText("Insertar Registro");
        btnInsertarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarRegistroActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnActualizar.setText("Actulizar registro");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnEliminar.setText("eliminar registro");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        comboClientes.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClientesActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("descargar productos");

        txtCodigoClientes.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnProductos.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnProductos.setText("descargar productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        txtAreaProductos.setColumns(20);
        txtAreaProductos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtAreaProductos.setRows(5);
        jScrollPane2.setViewportView(txtAreaProductos);

        jLabel12.setText("productos:");

        comboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductosActionPerformed(evt);
            }
        });

        jLabel13.setText("codigo_cliente");

        jLabel14.setText("stock");

        btnAgregar.setText("Agregar cantidad");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setText("Quitar cantidad");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jLabel15.setText("ingrese cantidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(493, 493, 493)
                        .addComponent(jLabel7)
                        .addGap(39, 39, 39)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(210, 210, 210))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsertarRegistro)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(253, 253, 253)
                                .addComponent(txt_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnEliminar)
                                        .addGap(36, 36, 36)
                                        .addComponent(btnProductos))
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubtotal)
                            .addComponent(lbliva)
                            .addComponent(lblTotal))
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPrecioTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(txtMail)
                                    .addComponent(txtProducto)
                                    .addComponent(txtPrecioUnitario)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(txtCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregar)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAgregarQuitar))
                                .addGap(92, 92, 92)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtCodigoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(437, 437, 437)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbliva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(3, 3, 3)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(30, 30, 30)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnAgregar)
                                            .addComponent(btnQuitar))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel15)
                                            .addComponent(txtAgregarQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnInsertarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminar)
                                    .addComponent(btnProductos))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioUnitarioActionPerformed

    private void btnInsertarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarRegistroActionPerformed
Timer tarea=new Timer();
TimerTask t=new TimerTask(){
        
        
        
        @Override
        
        public void run(){
         try {
            Connection cn=conexion.conectar();
            PreparedStatement pst=cn.prepareStatement("insert into clientes value(?,?,?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, txtCliente.getText().trim());
            pst.setString(3, txtMail.getText().trim());
            pst.setString(4, txtProducto.getText().trim());
            pst.setString(5, txtCantidad.getText().trim());
            pst.setString(6, txtPrecioUnitario.getText().trim());
            
            int cantidad=0;
            int precio=0;
            cantidad=Integer.parseInt(txtCantidad.getText());
            precio=Integer.parseInt(txtPrecioUnitario.getText());
            txtPrecioTotal.setText(String.valueOf(cantidad*precio));
            pst.setString(7, txtPrecioTotal.getText());
            pst.executeUpdate();
            txtCliente.setText("");
            txtMail.setText("");
            txtProducto.setText("");
            txtCantidad.setText("");
            txtPrecioUnitario.setText("");
            txtPrecioTotal.setText("");
            JOptionPane.showMessageDialog(null,"Datos guardados con exito en la base de datos");
         
        } catch (Exception e) {
        }
        
        
        
  
    }//GEN-LAST:event_btnInsertarRegistroActionPerformed
      };
            tarea.schedule (t , 3000);
    }  
        
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            Connection cn=conexion.conectar();
            PreparedStatement psp=cn.prepareStatement("select * from clientes where id_cliente=?");
            psp.setString(1,txtBuscar.getText().trim());
            ResultSet rs=psp.executeQuery();
            if(rs.next()){
                int cant=0;
                int precioU=0;
                 txtCliente.setText(rs.getString("nombreCliente"));
                 txtMail.setText(rs.getString("mailCliente"));
                 txtProducto.setText(rs.getString("producto"));
                 txtCantidad.setText(rs.getString("cantidad"));
                 txtPrecioUnitario.setText(rs.getString("precioUnitario"));
                 txtPrecioTotal.setText(rs.getString("precioTotal"));
                 
            }else{
                JOptionPane.showMessageDialog(null,"NO EXISTE");
            }
            mostrarDatos(txtBuscar.getText());
            calcularTotal();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        try {
            DefaultTableModel modelo=new DefaultTableModel();
            
       modelo.addColumn("ID");
       modelo.addColumn("NOMBRE_CLIENTE");
       modelo.addColumn("MAIL");
       modelo.addColumn("PRODUCTO");
       modelo.addColumn("CANTIDAD");
       modelo.addColumn("PRECIO_UNITARIO");
       modelo.addColumn("PRECIO_TOTAL");
       
       String dato[]=new String[7];
       
       
       Connection cn=conexion.conectar();
       PreparedStatement pst=cn.prepareStatement("select id_cliente ID, nombreCliente NOMBRE_CLIENTE, mailCliente MAIL, producto PRODUCTO, cantidad CANTIDAD, precioUnitario PRECIO_UNITARIO, cantidad*precioUnitario PRECIO_TOTAL from clientes where nombreCliente LIKE '%"+txtBuscar.getText()+"%'");
       ResultSet rs=pst.executeQuery();
       
       while(rs.next()){
               dato[0]=rs.getString(1);
               dato[1]=rs.getString(2);
               dato[2]=rs.getString(3);
               dato[3]=rs.getString(4);
               dato[4]=rs.getString(5);
               dato[5]=rs.getString(6);
               dato[6]=rs.getString(7);
               
               
               modelo.addRow(dato);
            
       }
       tbClientes.setModel (modelo);
       calcularTotal();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            String ID=txtBuscar.getText();
            Connection cn=conexion.conectar();
            PreparedStatement pst=cn.prepareStatement("update clientes set nombreCliente=?, mailCliente=?, producto=?, cantidad=?, precioUnitario=?, precioTotal=? where id_cliente='"+ID+"'");
            pst.setString(1, txtCliente.getText().trim());
            pst.setString(2, txtMail.getText().trim());
            pst.setString(3, txtProducto.getText().trim());
            pst.setString(4, txtCantidad.getText().trim());
            pst.setString(5, txtPrecioUnitario.getText().trim());
            int cantidad=0;
            int precio=0;
            
            cantidad=Integer.parseInt(txtCantidad.getText());
            precio=Integer.parseInt(txtPrecioUnitario.getText());
            txtPrecioTotal.setText(String.valueOf(cantidad*precio));
            pst.setString(6, txtPrecioTotal.getText().trim());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"DATOS ACTUALIZADOS");
            
            
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            Connection cn=conexion.conectar();
            PreparedStatement pst=cn.prepareStatement("delete from clientes where id_cliente=?");
            pst.setString(1, txtBuscar.getText());
            pst.executeUpdate();
            mostrarDatos("");
            txtCliente.setText("");
            txtMail.setText("");
            txtProducto.setText("");
            txtCantidad.setText("");
            txtPrecioUnitario.setText("");
            txtPrecioTotal.setText("");
            JOptionPane.showMessageDialog(null," Registro borrado");
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void comboClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientesActionPerformed
        try {
            Connection cn=conexion.conectar();
            PreparedStatement pst=cn.prepareStatement("select * from clientes where nombreCliente= '"+comboClientes.getSelectedItem()+"' ");
            ResultSet rs=pst.executeQuery();
            rs.next();
            
            txtCodigoClientes.setText(String.valueOf(rs.getString("id_cliente")));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_comboClientesActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        try {
            Connection cn=conexion.conectar();
            PreparedStatement pst=cn.prepareStatement("select * from clientes");
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                txtAreaProductos.append(""+rs.getString("producto")+"\n");
            }
            
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnProductosActionPerformed

    private void comboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductosActionPerformed
        try {
            Connection cn=conexion.conectar();
            PreparedStatement pst=cn.prepareStatement("select * from clientes where producto='"+comboProductos.getSelectedItem()+"'");
            ResultSet rs=pst.executeQuery();
            rs.next();
            txt_id_cliente.setText(String.valueOf(rs.getString("id_cliente")));
            txtStock.setText(String.valueOf(rs.getString("cantidad")));
            a=Integer.parseInt(txtStock.getText());
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_comboProductosActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            b=Integer.parseInt(txtAgregarQuitar.getText());
            a=a+b;
            Connection cn=conexion.conectar();
            PreparedStatement pst=cn.prepareStatement("update clientes set cantidad='"+a+"' where id_cliente='"+txt_id_cliente.getText()+"'");
            pst.executeUpdate();
            mostrarDatos("");
            JOptionPane.showMessageDialog(null,"Datos agregados con exito al stock");
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int stock;
        int cantidad;
        stock=Integer.parseInt(txtStock.getText());
        cantidad=Integer.parseInt(txtAgregarQuitar.getText());
        if(stock>cantidad){
            try {
                a=stock-cantidad;
                Connection cn=conexion.conectar();
                PreparedStatement pst=cn.prepareStatement("update clientes set cantidad = '"+a+"' where id_cliente= '"+txt_id_cliente.getText()+"'");
                pst.executeUpdate();
                mostrarDatos("");
                JOptionPane.showMessageDialog(null,"cantidad retirada del stock con exito");
                
            } catch (Exception e) {
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"no se puede quitar cantidad no existe");
            txtAgregarQuitar.setText("");
            txtAgregarQuitar.requestFocus();
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

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
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertarRegistro;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox<String> comboClientes;
    private javax.swing.JComboBox<String> comboProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lbliva;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTextField txtAgregarQuitar;
    private javax.swing.JTextArea txtAreaProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodigoClientes;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtPrecioTotal;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txt_id_cliente;
    // End of variables declaration//GEN-END:variables
}
