
package vista.Especialidades;

import controlador.EspecialidadControlador;
import javax.swing.table.DefaultTableModel;
import modelo.EspecialidadModelo;
import modelo.PacienteModelo;


public class Listado extends javax.swing.JInternalFrame {

    EspecialidadControlador controlador = EspecialidadControlador.getInstancia();
    DefaultTableModel tableModel = new DefaultTableModel();
    
    
    public Listado() {
        initComponents();
   tblListado.setModel(tableModel);
    String columna[]={"ESPECIALIDAD"};
    tableModel.setColumnIdentifiers(columna);
    
        listar();
    }

    public void listar(){
      for(EspecialidadModelo modelo : controlador.RetornarListarEspecialidad()){
        Object[] fila ={modelo.getNombre()};
    tableModel.addRow(fila);
    }   
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();

        jLabel1.setText("BUSCAR POR NOMBRE");

        jLabel2.setText("ESPECIALIDAD");

        txtNombreBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreBuscarKeyTyped(evt);
            }
        });

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblListado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addComponent(txtNombreBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel2)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBuscarKeyReleased
String nombre = txtNombreBuscar.getText();
tableModel.setRowCount(0);
controlador.ListadoCompletoPorNombre(nombre);
 for (EspecialidadModelo especialidad :  controlador.ListadoCompletoPorNombre(nombre)) {
            Object[] fila={especialidad};
            tableModel.addRow(fila);
        }


    }//GEN-LAST:event_txtNombreBuscarKeyReleased

    private void txtNombreBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBuscarKeyTyped
char c = evt.getKeyChar();

if(Character.isDigit(c)){
    evt.consume();
}
    }//GEN-LAST:event_txtNombreBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtNombreBuscar;
    // End of variables declaration//GEN-END:variables
}
