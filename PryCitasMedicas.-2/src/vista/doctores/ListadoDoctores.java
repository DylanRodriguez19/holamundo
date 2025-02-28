
package vista.doctores;

import controlador.EspecialidadDoctorControlador;
import javax.swing.table.DefaultTableModel;
import modelo.MedicoModelo;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import vista.PantallaPrincipal;


public class ListadoDoctores extends javax.swing.JInternalFrame {

    public DefaultTableModel tableModel = new DefaultTableModel();
    private PantallaPrincipal pantallaPrincipal;
    
    EspecialidadDoctorControlador controlador = new EspecialidadDoctorControlador();
    public ListadoDoctores(PantallaPrincipal pantallaPrincipal) {
        this.pantallaPrincipal = pantallaPrincipal;
        initComponents();
        tbl_ListaDoctores.setModel(tableModel);
        String columnas[] = {"NOMBRE", "ESPECIALIDAD"};
        tableModel.setColumnIdentifiers(columnas);
        listar();
        
        tbl_ListaDoctores.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filaSeleccionada = tbl_ListaDoctores.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        String doctorSeleccionado = tbl_ListaDoctores.getValueAt(filaSeleccionada, 0).toString();
                        pantallaPrincipal.setDoctorSeleccionado(doctorSeleccionado);
                        System.out.println("Doctor seleccionado: " + doctorSeleccionado);
                    }
                }
            }
        });
    }
    public void listar() {
         tableModel.setRowCount(0);
        for (MedicoModelo medico : controlador.obtenerMedicos()) {
            Object[] fila = {medico.getNombre(), medico.getEspecialidad()};
            tableModel.addRow(fila);
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ListaDoctores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_Especialidad = new javax.swing.JTextField();

        tbl_ListaDoctores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_ListaDoctores);

        jLabel1.setText("BUSCAR POR ESPECIALIDA:");

        txt_Especialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_EspecialidadKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Especialidad)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_EspecialidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_EspecialidadKeyReleased
        String especialidad = txt_Especialidad.getText().trim();
        tableModel.setRowCount(0); 
        
        if (especialidad.isEmpty()) {
            listar();
        } else {
            for (MedicoModelo medico : controlador.listadoCompletoPorEspecialidad(especialidad)) {
                Object[] fila = {medico.getNombre(), medico.getEspecialidad()};
                tableModel.addRow(fila);
            }
        }
    }//GEN-LAST:event_txt_EspecialidadKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_ListaDoctores;
    private javax.swing.JTextField txt_Especialidad;
    // End of variables declaration//GEN-END:variables
}
