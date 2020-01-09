
package ventanas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeriesCollection;

public class graficas extends javax.swing.JFrame {

    
    public graficas() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbConsultas = new javax.swing.JComboBox<>();
        rb3D = new javax.swing.JRadioButton();
        rb2D = new javax.swing.JRadioButton();
        rbBarras = new javax.swing.JRadioButton();
        rbCircular = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();
        btnejecutar = new javax.swing.JButton();
        btngraficar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbConsultas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-seleccione una consulta-", "mostrar tabla personas", "agrupar personas", "mostrar tabla genero" }));

        rb3D.setText("3 D");

        rb2D.setText("2 D");

        rbBarras.setText("barras");

        rbCircular.setText("circular");

        tblConsultas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblConsultas);

        btnejecutar.setText("ejecutar");
        btnejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnejecutarActionPerformed(evt);
            }
        });

        btngraficar.setText("graficar");
        btngraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngraficarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(rb3D, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(rb2D, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(rbBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbCircular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnejecutar, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(btngraficar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(562, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(cmbConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rb3D)
                                    .addComponent(rb2D)
                                    .addComponent(rbBarras)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(rbCircular)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btngraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(164, 164, 164))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnejecutarActionPerformed
        DefaultTableModel miModelo;
        
        Dgraficar miGrafica = new Dgraficar();
        int op=cmbConsultas.getSelectedIndex();
        switch(op){
            case 1:
                
                miModelo=miGrafica.mostrarpersona();
                tblConsultas.setModel(miModelo);
                
                break;
                
            case 2:
                
                miModelo=miGrafica.agruparpersona();
                 tblConsultas.setModel(miModelo);
                
                 break;
                 
             case 3:
                
                miModelo=miGrafica.mostrargenero();
                 tblConsultas.setModel(miModelo);
                
                 break; 
             default:
                 JOptionPane.showMessageDialog(rootPane,"seleccione una opcion del combo");
               
            
        
        
        
        
        
        
        
        
        
        
        
        }
        
        
    }//GEN-LAST:event_btnejecutarActionPerformed

    private void btngraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngraficarActionPerformed
        if (rb3D.isSelected() && rbBarras.isSelected()) {
        
            DefaultCategoryDataset dtsc = new DefaultCategoryDataset();
            for (int i=0;i<tblConsultas.getRowCount();i++){
                dtsc.setValue(Integer.parseInt(tblConsultas.getValueAt(i,0).toString()), tblConsultas.getValueAt(i,1).toString(),tblConsultas.getValueAt(i,2).toString());
                
                
            }
            JFreeChart ch=ChartFactory.createBarChart3D("Grafica de barras en 3D","Cantidad","dias",dtsc,PlotOrientation.VERTICAL,true,true,false);
            ChartPanel cp=new ChartPanel(ch);
            add(cp);
            cp.setBounds(600,100,500,500);
            
        }
         if (rb2D.isSelected() && rbBarras.isSelected()) {
        
            DefaultCategoryDataset dtsc = new DefaultCategoryDataset();
            for (int i=0;i<tblConsultas.getRowCount();i++){
                dtsc.setValue(Integer.parseInt(tblConsultas.getValueAt(i,0).toString()), tblConsultas.getValueAt(i,1).toString(),tblConsultas.getValueAt(i,2).toString());
                
                
            }
            JFreeChart ch=ChartFactory.createBarChart("Grafica de barras en 2D","Cantidad","dias",dtsc,PlotOrientation.VERTICAL,true,true,false);
            ChartPanel cp=new ChartPanel(ch);
            add(cp);
            cp.setBounds(600,100,500,500);
            
        }
          if (rb3D.isSelected() && rbCircular.isSelected()) {
        
            DefaultPieDataset dtsc = new DefaultPieDataset();
            for (int i=0;i<tblConsultas.getRowCount();i++){
                dtsc.setValue(tblConsultas.getValueAt(i,0).toString(),Integer.parseInt( tblConsultas.getValueAt(i,1).toString()));
                
                
            }
            JFreeChart ch=ChartFactory.createPieChart3D("Grafica de barras en 3D",dtsc,true,true,false);
            ChartPanel cp=new ChartPanel(ch);
            add(cp);
            cp.setBounds(600,100,500,500);
            
        }
          if (rb2D.isSelected() && rbCircular.isSelected()) {
        
            DefaultPieDataset dtsc = new DefaultPieDataset();
            for (int i=0;i<tblConsultas.getRowCount();i++){
                dtsc.setValue(tblConsultas.getValueAt(i,0).toString(),Integer.parseInt( tblConsultas.getValueAt(i,1).toString()));
                
                
            }
            JFreeChart ch=ChartFactory.createPieChart("Grafica de barras en 2D",dtsc,true,true,false);
            ChartPanel cp=new ChartPanel(ch);
            add(cp);
            cp.setBounds(600,100,500,500);
            
        }
        
    }//GEN-LAST:event_btngraficarActionPerformed

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
            java.util.logging.Logger.getLogger(graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new graficas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnejecutar;
    private javax.swing.JButton btngraficar;
    private javax.swing.JComboBox<String> cmbConsultas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb2D;
    private javax.swing.JRadioButton rb3D;
    private javax.swing.JRadioButton rbBarras;
    private javax.swing.JRadioButton rbCircular;
    private javax.swing.JTable tblConsultas;
    // End of variables declaration//GEN-END:variables
}
