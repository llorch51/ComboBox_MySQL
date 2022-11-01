/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;

import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.Estados;
import modelo.Localidades;
import modelo.Municipios;

public class ComboBox_1 extends javax.swing.JFrame {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Conexion conexion = new Conexion();
    
    public ComboBox_1() {
        initComponents();
        //llenarComboBox();
        Estados cc = new Estados();
        DefaultComboBoxModel modeloEstado = new DefaultComboBoxModel(cc.mostrarEstados());
        cbEstados.setModel(modeloEstado);
    }


    public void llenarComboBox(){
        Connection con = conexion.getConnection();
        
        try {
            String sql = "select * from t_estado";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbEstados.addItem("Seleccione estado");
            while(rs.next()){
                cbEstados.addItem(rs.getString("estado"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbEstados = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbMunicipios = new javax.swing.JComboBox<>();
        cbLocalidades = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDatos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Estado:");

        cbEstados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEstadosItemStateChanged(evt);
            }
        });

        jLabel2.setText("Municipios:");

        jLabel3.setText("Localidades:");

        cbMunicipios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMunicipiosItemStateChanged(evt);
            }
        });

        cbLocalidades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLocalidadesItemStateChanged(evt);
            }
        });

        txtDatos.setColumns(20);
        txtDatos.setRows(5);
        jScrollPane1.setViewportView(txtDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbEstados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMunicipios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMunicipios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbEstadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstadosItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            Estados estado = (Estados) cbEstados.getSelectedItem();
            Municipios municipio = new Municipios();
            DefaultComboBoxModel modMunicipio = new DefaultComboBoxModel(municipio.mostrarMunicipios(estado.getId()));
            cbMunicipios.setModel(modMunicipio);
            cbLocalidades.removeAllItems();
        }
    }//GEN-LAST:event_cbEstadosItemStateChanged

    private void cbLocalidadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLocalidadesItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            Estados estado = (Estados) cbEstados.getSelectedItem();
            Municipios municipio = (Municipios) cbMunicipios.getSelectedItem();
            Localidades localidad = (Localidades)cbLocalidades.getSelectedItem();
            txtDatos.setText("Estado: "+estado.getNombre()+ "\nMunicipio: "+municipio.getNombre()+"\nLocalidad: "+localidad.getNombre());
        }
    }//GEN-LAST:event_cbLocalidadesItemStateChanged

    private void cbMunicipiosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMunicipiosItemStateChanged
         if(evt.getStateChange() == ItemEvent.SELECTED){
            Municipios municipio = (Municipios) cbMunicipios.getSelectedItem();
            Localidades localidad = new Localidades();
            DefaultComboBoxModel modLocalidad = new DefaultComboBoxModel(localidad.mostrarLocalidades(municipio.getId()));
            cbLocalidades.setModel(modLocalidad);
        }
    }//GEN-LAST:event_cbMunicipiosItemStateChanged

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ComboBox_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComboBox_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComboBox_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComboBox_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComboBox_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbEstados;
    private javax.swing.JComboBox<String> cbLocalidades;
    private javax.swing.JComboBox<String> cbMunicipios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDatos;
    // End of variables declaration//GEN-END:variables
}
