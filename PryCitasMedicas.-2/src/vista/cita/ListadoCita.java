
package vista.cita;

import controlador.CitaControlador;
import controlador.PacienteControlador;
import javax.swing.table.DefaultTableModel;
import modelo.CitaModelo;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import vista.PantallaPrincipal;


public class ListadoCita extends javax.swing.JInternalFrame {
public DefaultTableModel tableModel = new DefaultTableModel();
    CitaControlador controlador = new CitaControlador();
private PantallaPrincipal pantallaPrincipal;
    public ListadoCita(PantallaPrincipal pantallaPrincipal) {
         this.pantallaPrincipal = pantallaPrincipal;
        initComponents();
        tbl_ListadoCita.setModel(tableModel);
        String columnas[] = {"FECHA", "HORA",  "DOCTOR"};
        tableModel.setColumnIdentifiers(columnas);
        listar();
        
       tbl_ListadoCita.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filaSeleccionada = tbl_ListadoCita.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        String fechaSeleccionada = tbl_ListadoCita.getValueAt(filaSeleccionada, 0).toString();
                        String horaSeleccionada = tbl_ListadoCita.getValueAt(filaSeleccionada, 1).toString();
                        pantallaPrincipal.setFechaSeleccionada(fechaSeleccionada);
                        String pacienteSeleccionada = null;
                        pantallaPrincipal.setPacienteSeleccionado(horaSeleccionada);
                        System.out.println("Fecha seleccionada: " + fechaSeleccionada);
                        System.out.println("Hora seleccionada: " + horaSeleccionada);
                    }
                }
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ListadoCita = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        txt_hora = new javax.swing.JTextField();

        tbl_ListadoCita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_ListadoCita);

        jLabel1.setText("BUSCAR CITA POR FECHA:");

        jLabel2.setText("BUSCAR CITA POR HORA:");

        txt_fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_fechaKeyReleased(evt);
            }
        });

        txt_hora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_horaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_fecha)
                    .addComponent(txt_hora))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_fechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fechaKeyReleased
         buscarCitas();
    }//GEN-LAST:event_txt_fechaKeyReleased

    private void txt_horaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_horaKeyReleased
       buscarCitas();

    }//GEN-LAST:event_txt_horaKeyReleased
public void listar() {
        tableModel.setRowCount(0);
        for (CitaModelo cita : controlador.obtenerCitas()) {
            Object[] fila = {
                cita.getFecha(),
                cita.getHora(),
                cita.getDoctor().getNombre()
            };
            tableModel.addRow(fila);
        }
    }

    


    private void buscarCitas() {
        String fecha = txt_fecha.getText().trim();
        String hora = txt_hora.getText().trim();
        tableModel.setRowCount(0);

        if (fecha.isEmpty() && hora.isEmpty()) {

            listar();
        } else if (!fecha.isEmpty() && hora.isEmpty()) {

            for (CitaModelo cita : controlador.buscarCitasPorFecha(fecha)) {
                Object[] fila = {
                    cita.getFecha(),
                    cita.getHora(),
                    cita.getDoctor().getNombre()
                };
                tableModel.addRow(fila);
            }
        } else if (fecha.isEmpty() && !hora.isEmpty()) {

            for (CitaModelo cita : controlador.buscarCitasPorHora(hora)) {
                Object[] fila = {
                    cita.getFecha(),
                    cita.getHora(),
                    cita.getDoctor().getNombre()
                };
                tableModel.addRow(fila);
            }
        } else {

            for (CitaModelo cita : controlador.buscarCitasPorFechaYHora(fecha, hora)) {
                Object[] fila = {
                    cita.getFecha(),
                    cita.getHora(),
                    cita.getDoctor().getNombre()
                };
                tableModel.addRow(fila);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_ListadoCita;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_hora;
    // End of variables declaration//GEN-END:variables
}
