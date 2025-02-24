package vista.especialidad;

import controlador.EspecialidadControlador;
import javax.swing.table.DefaultTableModel;
import modelo.EspecialidadModel;
import modelo.PacienteModelo;

public class Listado extends javax.swing.JInternalFrame {

    EspecialidadControlador ec = EspecialidadControlador.getInstancia();
    DefaultTableModel defaultTable = new DefaultTableModel();
    public Listado() {
        initComponents();
        tbl_listadoEspecialidad.setModel(defaultTable);
        String columnas []= {"ESPECIALIDAD"};
    defaultTable.setColumnIdentifiers(columnas);
    listar();
    }
    public void listar(){
    for (EspecialidadModel espeModelo :  ec.listadoCompleto()) {
            Object[] fila={espeModelo.getNombre()};
            defaultTable.addRow(fila);
        }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_listadoEspecialidad = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_ListadoEspecialidad = new javax.swing.JTextField();

        tbl_listadoEspecialidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_listadoEspecialidad);

        jLabel1.setText("BUSCAR POR NOMBRE");

        txt_ListadoEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ListadoEspecialidadKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_ListadoEspecialidad)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_ListadoEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ListadoEspecialidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ListadoEspecialidadKeyReleased
     String nombre = txt_ListadoEspecialidad.getText();
     defaultTable.setRowCount(0);
        ec.listadoCompletoPorEspecialidad(nombre);
        for (EspecialidadModel especialidadModel : ec.listadoCompletoPorEspecialidad(nombre)) {
            Object[] fila={especialidadModel.getNombre()};
            defaultTable.addRow(fila);
        }
    }//GEN-LAST:event_txt_ListadoEspecialidadKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_listadoEspecialidad;
    private javax.swing.JTextField txt_ListadoEspecialidad;
    // End of variables declaration//GEN-END:variables
}
