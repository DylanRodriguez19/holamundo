
package vista.citas;

import controlador.CitasController;
import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import controlador.PacienteCoontrolador;
import javax.swing.JOptionPane;
import modelo.CitaModelo;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;

public class Ingresar extends javax.swing.JInternalFrame {

    PacienteCoontrolador  pc=PacienteCoontrolador.getInstacia();
    EspecialidadControlador ec=EspecialidadControlador.getInstancia();
    MedicoControlador mc =MedicoControlador.getInstacia();
    String Estado= "NO ATENDIDO";
    
    CitasController cc=CitasController.getInstancia();
    
    public Ingresar() {
        initComponents();
        
        cargarPacienteAutoaticamente();
        cargarEspecialidadAutoaticamente();
        
        // carga de medicos por especialidad
        cbx_especialidades.addActionListener(e -> {
           String nombreEspecialidad= cbx_especialidades.getSelectedItem().toString();
            
            if (!nombreEspecialidad.equals("SELECIONE ESPECIALIDAD")){
                cargarAutomaticamenteMedicos(nombreEspecialidad);
            }
            
        });
        
        
    }

    private void cargarAutomaticamenteMedicos(String ne){
        cbx_medicos.removeAllItems();
        for (MedicoModelo medicoModelo : mc.listadoPorEspecialidad(ne)) {
            cbx_medicos.addItem(medicoModelo.getCedula()+ " "+medicoModelo.getNombres());
        }
    }
    
    
    private void cargarPacienteAutoaticamente(){
        // carguen en nuestoer cbx_pacientes la carga automatica
        cbx_pacientes.addItem("SELECCIONE PACIENTE");
        for (PacienteModelo pm : pc.listadoCompleto()) {
            cbx_pacientes.addItem(pm.getCedula()+" "+ pm.getNombres());
        }
    }
    
    private void cargarEspecialidadAutoaticamente(){
        cbx_especialidades.addItem("SELECIONE ESPECIALIDAD");
        for (EspecialidadModelo pm : ec.listado()) {
            cbx_especialidades.addItem(pm.getNombre());
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbx_pacientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbx_especialidades = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbx_medicos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_hora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();

        jLabel1.setText("SELECIONA PACIENTE");

        jLabel2.setText("SELECION ESPECIALIDAD");

        jLabel3.setText("SELECIONE MEDICO");

        jLabel4.setText("¿ PARA QUE NECESITA LA CITA ?");

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane1.setViewportView(txt_descripcion);

        jLabel5.setText("FECHA");

        txt_fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_fechaKeyTyped(evt);
            }
        });

        jLabel6.setText("HORA");

        txt_hora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_horaKeyTyped(evt);
            }
        });

        jLabel7.setText("DD/MM/AA");

        jLabel8.setText("HH:MM");

        btn_guardar.setText("GENERAR TURNO");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_pacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbx_especialidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbx_medicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_fecha)
                            .addComponent(txt_hora))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)))
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbx_pacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbx_especialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbx_medicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btn_guardar)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
         if (cbx_pacientes.getSelectedIndex() == 0 || 
        cbx_especialidades.getSelectedIndex() == 0 || 
        cbx_medicos.getSelectedItem() == null || 
        txt_descripcion.getText().trim().isEmpty() || 
        txt_fecha.getText().trim().isEmpty() || 
        txt_hora.getText().trim().isEmpty()) {
        
        JOptionPane.showMessageDialog(
    this,
    "Todos los campos son obligatorios. Por favor, complete toda la información requerida.",
    "Error: Campos incompletos",
    JOptionPane.ERROR_MESSAGE
);;
        return;
    }
        

        // paciente
        String nombrePaciente=cbx_pacientes.getSelectedItem().toString();
        String pacientePartes[]=nombrePaciente.split(" ");
        String cedula=pacientePartes[0];
        PacienteModelo pm = pc.obtenerCedula(cedula);
        
        // medico
        String nombreMedico=cbx_medicos.getSelectedItem().toString();
        String medicosPartes[]=nombreMedico.split(" ");
        String cedula_m=medicosPartes[0];
        MedicoModelo mm = mc.obtenerCedula(cedula_m);
        
        // especialidad
        EspecialidadModelo em =  mm.getEspecialidadModelo();
        
        CitaModelo cm= cc.guardar(
                pm, 
                mm, 
                em,
     txt_descripcion.getText(),
          txt_fecha.getText(),
           txt_hora.getText(),
           Estado
        );
        
        String mensaje = String.format(
    "CITA INGRESADA PARA:\n" +
    "Fecha: %s\n" +
    "Hora: %s\n" +
    "Médico: %s\n" +
    "Especialidad: %s",
    cm.getFecha(),
    cm.getHora(),
    cm.getMm().getNombres(),
    cm.getEm().getNombre()
);

JOptionPane.showMessageDialog(this, mensaje);
        
       cbx_especialidades.setSelectedIndex(0); 
       cbx_pacientes.setSelectedIndex(0); 
       cbx_medicos.removeAllItems();
       txt_descripcion.setText("");
       txt_fecha.setText("");
       txt_hora.setText("");
        
        
    }//GEN-LAST:event_btn_guardarActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cbx_especialidades;
    private javax.swing.JComboBox<String> cbx_medicos;
    private javax.swing.JComboBox<String> cbx_pacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_hora;
    // End of variables declaration//GEN-END:variables
}
