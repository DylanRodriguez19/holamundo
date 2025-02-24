
package vista.especialidad;

import controlador.EspecialidadControlador;
import javax.swing.JOptionPane;
import modelo.EspecialidadModel;

public class Ingresar extends javax.swing.JInternalFrame {

    EspecialidadControlador especialidadControlador = EspecialidadControlador.getInstancia();
    public Ingresar() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_especialidad = new javax.swing.JTextField();
        btn_guardad = new javax.swing.JButton();

        jLabel1.setText("ESPECIALIDAD:");

        btn_guardad.setText("GUARDAD");
        btn_guardad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_especialidad)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(btn_guardad)
                .addContainerGap(174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btn_guardad)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardadActionPerformed
       String nombre = txt_especialidad.getText();

EspecialidadModel especialidadModelo = new EspecialidadModel(nombre);
especialidadControlador.AgregarEspecialidad(nombre);
JOptionPane.showMessageDialog(this, especialidadModelo.getNombre()+"INGRESADO EXITOSAMENTE");
txt_especialidad.setText("");
    }//GEN-LAST:event_btn_guardadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_especialidad;
    // End of variables declaration//GEN-END:variables
}
