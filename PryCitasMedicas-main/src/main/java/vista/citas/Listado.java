package vista.citas;

import controlador.CitasController;
import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import controlador.PacienteCoontrolador;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import modelo.CitaModelo;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;

public class Listado extends javax.swing.JInternalFrame {

    PacienteCoontrolador paContro = PacienteCoontrolador.getInstacia();
    EspecialidadControlador esContro = EspecialidadControlador.getInstancia();
    MedicoControlador meContro = MedicoControlador.getInstacia();
    CitasController ciContro = CitasController.getInstancia();
    
    DefaultTableModel tableModel = new DefaultTableModel();
            
    public Listado() {
        initComponents();
        
        
         cargarPacienteAutoaticamente();
        cargarEspecialidadAutoaticamente();
        cargarEstadoAutomaticamente();
        
        
        // carga de medicos por especialidad
       cbx_especialidad.addActionListener(e -> {
    String nombreEspecialidad = cbx_especialidad.getSelectedItem().toString();

    if (nombreEspecialidad.equals("SELECIONE ESPECIALIDAD")) {
        // Limpiar el ComboBox de médicos
        cbx_medico.removeAllItems();
    } else {
        // Cargar los médicos correspondientes a la especialidad seleccionada
        cargarAutomaticamenteMedicos(nombreEspecialidad);
    }
});
        
        // Conectar eventos de filtrado
    cbx_paciente.addActionListener(e -> filtrarCitas());
    cbx_especialidad.addActionListener(e -> filtrarCitas());
    cbx_medico.addActionListener(e -> filtrarCitas());
    cbx_estado.addActionListener(e -> filtrarCitas());
    txt_fecha.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            filtrarCitas();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            filtrarCitas();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            filtrarCitas();
        }
    });
    txt_hora.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            filtrarCitas();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            filtrarCitas();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            filtrarCitas();
        }
    });
        
         tbl_listadoCitas.setModel(tableModel);
        
        String columnas[]={"FECHA","HORA","ESPECIALIDAD","NOMBRE MEDICO","CEDULA MEDICO","NOMBRE PACIENTE","CEDULA PACIENTE","ESTADO"};
        tableModel.setColumnIdentifiers(columnas);
               cargarListado();
       
    }
    
     private void cargarAutomaticamenteMedicos(String ne){
        cbx_medico.removeAllItems();
        for (MedicoModelo medicoModelo : meContro.listadoPorEspecialidad(ne)) {
            cbx_medico.addItem(medicoModelo.getCedula()+ " "+medicoModelo.getNombres());
        }
         if (meContro.listadoPorEspecialidad(ne).isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "NO HAY CITAS CON ESE MEDICO" + ne,
            "Sin citas",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    }
    
    
    private void cargarPacienteAutoaticamente(){
        // carguen en nuestoer cbx_pacientes la carga automatica
        cbx_paciente.addItem("SELECCIONE PACIENTE");
        for (PacienteModelo pm : paContro.listadoCompleto()) {
            cbx_paciente.addItem(pm.getCedula()+" "+ pm.getNombres());      
        }
         if (paContro.listadoCompleto().isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "NO HAY CITAS CON ESE PACIENTE",
            "Sin citas",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    }
    
    private void cargarEspecialidadAutoaticamente(){
        cbx_especialidad.addItem("SELECIONE ESPECIALIDAD");
        for (EspecialidadModelo pm : esContro.listado()) {
            cbx_especialidad.addItem(pm.getNombre());
        }
         if (esContro.listado().isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "NO HAY CITAS CON ESA ESPECIALIDAD ",
            "Sin citas",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
       
    }
    
   private void cargarEstadoAutomaticamente() {
    // Limpiar el ComboBox antes de cargar nuevos estados
    cbx_estado.removeAllItems();

    // Agregar la opción por defecto
    cbx_estado.addItem("SELECCIONE ESTADO");

    // Agregar las opciones de estado únicas
    cbx_estado.addItem("ATENDIDO");
    cbx_estado.addItem("NO ATENDIDO");
}
    
    private void cargarListado(){
        tableModel.setRowCount(0); // Limpiar la tabla
    for (CitaModelo cm : ciContro.listadoCompleto()) {
        Object[] fila = {
            cm.getFecha(), 
            cm.getHora(),
            cm.getEm().getNombre(),
            cm.getMm().getNombres(),
            cm.getMm().getCedula(),
            cm.getPm().getNombres(),
            cm.getPm().getCedula(),
            cm.getEstado()
        };
        tableModel.addRow(fila);
    }
    }
   private void filtrarCitas() {
    tableModel.setRowCount(0); // Limpiar la tabla antes de aplicar el filtro

    // Obtener los valores seleccionados o ingresados
    String pacienteSeleccionado = cbx_paciente.getSelectedItem() != null ? cbx_paciente.getSelectedItem().toString() : "";
    String especialidadSeleccionada = cbx_especialidad.getSelectedItem() != null ? cbx_especialidad.getSelectedItem().toString() : "";
    String medicoSeleccionado = cbx_medico.getSelectedItem() != null ? cbx_medico.getSelectedItem().toString() : "";
    String estadoSeleccionado = cbx_estado.getSelectedItem() != null ? cbx_estado.getSelectedItem().toString() : "";
    String fecha = txt_fecha.getText().trim();
    String hora = txt_hora.getText().trim();

    // Validar que los campos de fecha y hora estén completos
    boolean fechaCompleta = validarFormatoFecha(fecha);
    boolean horaCompleta = validarFormatoHora(hora);

    // Si los campos de fecha y hora no están completos, no mostrar el mensaje
    if ((!fecha.isEmpty() && !fechaCompleta) || (!hora.isEmpty() && !horaCompleta)) {
        return;
    }

    // Variable para contar las citas que coinciden con los filtros
    int citasEncontradas = 0;

    for (CitaModelo cm : ciContro.listadoCompleto()) {
        // Obtener la cédula del paciente seleccionado (si hay uno)
        String cedulaPaciente = pacienteSeleccionado.isEmpty() || pacienteSeleccionado.equals("SELECCIONE PACIENTE")
            ? "" : pacienteSeleccionado.split(" ")[0];

        // Obtener la cédula del médico seleccionado (si hay uno)
        String cedulaMedico = medicoSeleccionado.isEmpty() ? "" : medicoSeleccionado.split(" ")[0];

        // Aplicar los filtros
        boolean coincideEstado = estadoSeleccionado.isEmpty() ||
            estadoSeleccionado.equals("SELECCIONE ESTADO") ||    
            cm.getEstado().equals(estadoSeleccionado);
        
        boolean coincidePaciente = cedulaPaciente.isEmpty() ||
            pacienteSeleccionado.equals("SELECCIONE PACIENTE") ||    
            cm.getPm().getCedula().equals(cedulaPaciente);
        
        boolean coincideEspecialidad = especialidadSeleccionada.isEmpty() || 
            especialidadSeleccionada.equals("SELECIONE ESPECIALIDAD") || 
            cm.getEm().getNombre().equals(especialidadSeleccionada);
        
        boolean coincideMedico = cedulaMedico.isEmpty() || 
            cm.getMm().getCedula().equals(cedulaMedico);
        boolean coincideFecha = fecha.isEmpty() || cm.getFecha().equals(fecha);
        boolean coincideHora = hora.isEmpty() || cm.getHora().equals(hora);

        // Si todos los filtros coinciden, agregar la cita a la tabla
        if (coincideEstado && coincidePaciente && coincideEspecialidad && coincideMedico && coincideFecha && coincideHora) {
            Object[] fila = {
                cm.getFecha(), 
                cm.getHora(),
                cm.getEm().getNombre(),
                cm.getMm().getNombres(),
                cm.getMm().getCedula(),
                cm.getPm().getNombres(),
                cm.getPm().getCedula(),
                cm.getEstado()
            };
            tableModel.addRow(fila);
            citasEncontradas++; 
        }
    }

    if (citasEncontradas == 0 && (fechaCompleta || horaCompleta)) {
        JOptionPane.showMessageDialog(
    this,
    "No se encontraron citas agendadas para los criterios seleccionados.",
    "Sin resultados",
    JOptionPane.INFORMATION_MESSAGE
);
    }
}
    
    
    private boolean validarFormatoFecha(String fecha) {
    return fecha.matches("^\\d{2}/\\d{2}/\\d{2}$");
}

private boolean validarFormatoHora(String hora) {
    return hora.matches("^\\d{2}:\\d{2}$");
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbx_paciente = new javax.swing.JComboBox<>();
        cbx_especialidad = new javax.swing.JComboBox<>();
        cbx_medico = new javax.swing.JComboBox<>();
        txt_hora = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_listadoCitas = new javax.swing.JTable();
        btn_limpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        cbx_estado = new javax.swing.JComboBox<>();

        jLabel1.setText("FILTRAR  POR PACIENTE:");

        jLabel2.setText("FILTRAR POR ESPECIALIDAD:");

        jLabel3.setText("FILTRAR POR MEDICO:");

        jLabel4.setText("FILTRAR POR HORA:");

        jLabel5.setText("FILTRAR POR FECHA:");

        txt_hora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_horaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_horaKeyTyped(evt);
            }
        });

        tbl_listadoCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_listadoCitas);

        btn_limpiar.setText("LIMPIAR FILTROS");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        jLabel6.setText("FILTRAR ESTADO:");

        txt_fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_fechaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_fechaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 92, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbx_estado, javax.swing.GroupLayout.Alignment.LEADING, 0, 520, Short.MAX_VALUE)
                    .addComponent(txt_hora, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbx_paciente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbx_medico, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbx_especialidad, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_limpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btn_limpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbx_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbx_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbx_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cbx_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed

    cbx_especialidad.setSelectedIndex(0);
    cbx_paciente.setSelectedIndex(0); 
    cbx_especialidad.setSelectedIndex(0); 
    cbx_medico.removeAllItems();

    txt_fecha.setText("");
    txt_hora.setText("");

    cargarListado();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txt_horaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_horaKeyReleased

    tableModel.setRowCount(0);
    String hora = txt_hora.getText().trim();

    if (hora.isEmpty()) {
        cargarListado(); 
        return; 
    }

    if (hora.length() != 5) {
        return;
    }

    if (!validarFormatoHora(hora)) {
        JOptionPane.showMessageDialog(
    this,
    "Formato de hora inválido.\nPor favor, use el formato: HH:MM",
    "Error de formato",
    JOptionPane.ERROR_MESSAGE
);
        txt_hora.setText("");
        return; 
    }

    for (CitaModelo cm : ciContro.ListadoPorHora(hora)) {
        Object[] fila = {
            cm.getFecha(), 
            cm.getHora(),
            cm.getEm().getNombre(),
            cm.getMm().getNombres(),
            cm.getMm().getCedula(),
            cm.getPm().getNombres(),
            cm.getPm().getCedula(),
            cm.getEstado()
        };
        tableModel.addRow(fila);
    }

    if (ciContro.ListadoPorHora(hora).isEmpty()) {
        txt_hora.setText("");
        JOptionPane.showMessageDialog(
    this,
    "No hay citas agendadas para la hora: " + hora,
    "Sin citas",
    JOptionPane.INFORMATION_MESSAGE
);

    }   
    
    }//GEN-LAST:event_txt_horaKeyReleased

    private void txt_horaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_horaKeyTyped
         char c = evt.getKeyChar();
    String texto = txt_hora.getText();

    if (!Character.isDigit(c) && c != ':') {
        evt.consume(); 
    }

    if (texto.length() >= 5) { 
        evt.consume();
    }

    }//GEN-LAST:event_txt_horaKeyTyped

    private void txt_fechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fechaKeyReleased

    tableModel.setRowCount(0);

    String fecha = txt_fecha.getText().trim();
    if (fecha.isEmpty()) {
        cargarListado(); 
        return; 
    }


    if (fecha.length() != 8) {
        return; 
    }

    if (!validarFormatoFecha(fecha)) {
        JOptionPane.showMessageDialog(
    this,
    "Formato de fecha inválido.\nPor favor, use el formato: DD/MM/AA",
    "Error de formato",
    JOptionPane.ERROR_MESSAGE
);
        txt_fecha.setText("");
        return; 
    }

    for (CitaModelo cm : ciContro.ListadoPorFecha(fecha)) {
        Object[] fila = {
            cm.getFecha(), 
            cm.getHora(),
            cm.getEm().getNombre(),
            cm.getMm().getNombres(),
            cm.getMm().getCedula(),
            cm.getPm().getNombres(),
            cm.getPm().getCedula(),
            cm.getEstado()
        };
        tableModel.addRow(fila);
    }

    if (ciContro.ListadoPorFecha(fecha).isEmpty()) {
                txt_fecha.setText("");
        JOptionPane.showMessageDialog(
    this,
    "No hay citas agendadas para la fecha: " + fecha,
    "Sin citas",
    JOptionPane.INFORMATION_MESSAGE
);

    }
    }//GEN-LAST:event_txt_fechaKeyReleased

    private void txt_fechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fechaKeyTyped
                                
         char c = evt.getKeyChar();
    String texto = txt_fecha.getText();

    if (!Character.isDigit(c) && c != '/') {
        evt.consume(); 
    }

    if (texto.length() >= 8) { 
        evt.consume(); 
    }
    }//GEN-LAST:event_txt_fechaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cbx_especialidad;
    private javax.swing.JComboBox<String> cbx_estado;
    private javax.swing.JComboBox<String> cbx_medico;
    private javax.swing.JComboBox<String> cbx_paciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_listadoCitas;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_hora;
    // End of variables declaration//GEN-END:variables
}
