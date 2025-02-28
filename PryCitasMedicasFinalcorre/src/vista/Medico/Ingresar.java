
package vista.Medico;

import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import vista.pacientes.*;
import controlador.PacienteControlador;
import javax.swing.JOptionPane;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;


public class Ingresar extends javax.swing.JInternalFrame {

    
    
    MedicoControlador medico = MedicoControlador.getInstancia();
    EspecialidadControlador especialidad = EspecialidadControlador.getInstancia();
    public Ingresar() {
        initComponents();
        especialidad.RetornarListarEspecialidad();
        
        
        for(EspecialidadModelo espec : especialidad.RetornarListarEspecialidad()){
            boxEspecialidad.addItem(espec.getNombre());
            
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_edad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbx_sexo = new javax.swing.JComboBox<>();
        btn_guardardatos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        boxEspecialidad = new javax.swing.JComboBox<>();

        jLabel1.setText("CEDULA");

        txt_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cedulaKeyTyped(evt);
            }
        });

        jLabel2.setText("NOMBRES");

        txt_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombresKeyTyped(evt);
            }
        });

        jLabel3.setText("EDAD");

        txt_edad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_edadKeyTyped(evt);
            }
        });

        jLabel4.setText("SEXO");

        cbx_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOMBRE", "MUJER" }));

        btn_guardardatos.setText("GUARDAR DATOS");
        btn_guardardatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardardatosActionPerformed(evt);
            }
        });

        jLabel5.setText("DATOS PERSONALES");

        jLabel6.setText("ESPECIALIDAD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_guardardatos, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 130, Short.MAX_VALUE))
                            .addComponent(txt_cedula)
                            .addComponent(txt_nombres)
                            .addComponent(txt_edad)
                            .addComponent(cbx_sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(boxEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(boxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btn_guardardatos)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardardatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardardatosActionPerformed
        String cedula = txt_cedula.getText();
        String nombres = txt_nombres.getText();
        int edad = Integer.parseInt(txt_edad.getText());
        boolean sexo= cbx_sexo.getSelectedItem().toString().equals("HOMBRE");

        String nombre=boxEspecialidad.getSelectedItem().toString();
EspecialidadControlador especontrolador = EspecialidadControlador.getInstancia();        
        EspecialidadModelo espemodelo = especontrolador.obtenerPorNombre(nombre);
        
        MedicoControlador medicontrol = MedicoControlador.getInstancia();
        MedicoModelo medic = medicontrol.agregarMedico(espemodelo, cedula, nombres, edad, sexo);
        
        
        
        
        JOptionPane.showMessageDialog(this, "MEDICO AGREGADO CORRECTAMENTE: "+medic.getNombres());
txt_cedula.setText("");
txt_edad.setText("");
txt_nombres.setText("");
    }//GEN-LAST:event_btn_guardardatosActionPerformed

    private void txt_cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cedulaKeyTyped
char c = evt.getKeyChar();

if(!Character.isDigit(c)){
    evt.consume();
}
    }//GEN-LAST:event_txt_cedulaKeyTyped

    private void txt_nombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombresKeyTyped
char c = evt.getKeyChar();

if(Character.isDigit(c)){
    evt.consume();
}
    }//GEN-LAST:event_txt_nombresKeyTyped

    private void txt_edadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_edadKeyTyped
char c = evt.getKeyChar();

if(!Character.isDigit(c)){
    evt.consume();
}
    }//GEN-LAST:event_txt_edadKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxEspecialidad;
    private javax.swing.JButton btn_guardardatos;
    private javax.swing.JComboBox<String> cbx_sexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_nombres;
    // End of variables declaration//GEN-END:variables
}