package vista.Citas;

import controlador.CitaControlador;
import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import controlador.PacienteControlador;
import javax.swing.JOptionPane;
import modelo.CitaModelo;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;

public class Ingresar extends javax.swing.JInternalFrame {
    
    PacienteControlador pc = PacienteControlador.getInstancia();
    EspecialidadControlador ec = EspecialidadControlador.getInstancia();
    MedicoControlador mc = MedicoControlador.getInstancia();
    CitaControlador cc = CitaControlador.getInstancia();
    public Ingresar() {
        initComponents();

        //carguen en nuestros cbx pacientes ña carga 
        agregarPacienteAutomaticamente();
        agregarEspecialidad();
        
        boxEspecialidad.addActionListener(e-> {
            
      String   nombreEspecialidad = boxEspecialidad.getSelectedItem().toString();
         if(!nombreEspecialidad.equals("INGRESE UNA ESPECIALIDAD")){
        agregarMedico(nombreEspecialidad);

             System.out.println(nombreEspecialidad);
   
         }
      
        
        
        });
        
        
    }
    
    public void agregarPacienteAutomaticamente() {
        for (PacienteModelo pm : pc.listadoCompleto()) {
            boxPaciente.addItem(pm.getCedula() + " " + pm.getNombres());
        }
        
    }
    
    public void agregarEspecialidad() {
                boxEspecialidad.addItem("INGRESE UNA ESPECIALIDAD");

 
        for (EspecialidadModelo em : ec.RetornarListarEspecialidad()) {
            boxEspecialidad.addItem(em.getNombre());
        }
        
    }
    
    public void agregarMedico(String nombre) {
        boxMedico.removeAllItems();
        for (MedicoModelo mm : mc.ListadoPorEspecialidad(nombre)) {
            boxMedico.addItem(mm.getCedula() + " " + mm.getNombres());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boxPaciente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        boxEspecialidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        boxMedico = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtAsunto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        jLabel1.setText("SELECCIONAR PACIENTE:");

        jLabel2.setText("SELECCIONAR ESPECIALIDAD");

        jLabel3.setText("SELECCIONE EL MEDICO:");

        jLabel4.setText("ASUNTO DE LA CITA MEDICA");

        txtAsunto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAsuntoKeyTyped(evt);
            }
        });

        jLabel5.setText("FECHA:");

        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaKeyTyped(evt);
            }
        });

        jLabel6.setText("HORA:");

        txtHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraKeyTyped(evt);
            }
        });

        jLabel7.setText("DD/MM/AA");

        jLabel8.setText("HH:MM");

        btnGuardar.setText("GENERAR TURNO");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(boxPaciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boxEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boxMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtHora, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(boxPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(boxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(boxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(32, 32, 32)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       String nombrePaciente= boxPaciente.getSelectedItem().toString();
       String pacientePartes[]= nombrePaciente.split(" ");
       String cedula = pacientePartes[0];
       PacienteModelo pm= pc.obtenerCedula(cedula);
       
       String nombreMedico= boxMedico.getSelectedItem().toString();
       String MedicoPartes[]= nombreMedico.split(" ");
       String cedulaMedico = MedicoPartes[0];
       MedicoModelo mm= mc.obtenerCedulaMedico(cedulaMedico);
       
        EspecialidadModelo em = mm.getEspecialidad();
        CitaModelo cm =cc.agregarCita(pm, em, mm, txtAsunto.getText(), txtFecha.getText(), txtHora.getText());
       JOptionPane.showMessageDialog(this,"CITA INGRESADA PARA EL DIA "+cm.getFecha()+
               " PARA LAS " +cm.getHora() + 
               " CON EL MEDICO " + cm.getMedico().getNombres()+ 
               " PARA LA ESPECIALIDAD " + cm.getEspecialidad().getNombre());
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtAsuntoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAsuntoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsuntoKeyTyped

    private void txtFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyTyped
char c =evt.getKeyChar();  
if(!Character.isDigit(c) && c !='/' ){
  evt.consume();
}
if(txtFecha.getText().length()>=10){
    evt.consume();
}

    }//GEN-LAST:event_txtFechaKeyTyped

    private void txtHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraKeyTyped
char c =evt.getKeyChar();  
if(!Character.isDigit(c) && c !=':' ){
  evt.consume();
}
if(txtHora.getText().length()>=5){
    evt.consume();
}


    }//GEN-LAST:event_txtHoraKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxEspecialidad;
    private javax.swing.JComboBox<String> boxMedico;
    private javax.swing.JComboBox<String> boxPaciente;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    // End of variables declaration//GEN-END:variables
}
