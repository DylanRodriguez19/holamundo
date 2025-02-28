
package vista.Especialidades;

import controlador.EspecialidadControlador;
import javax.swing.JOptionPane;
import modelo.EspecialidadModelo;

public class Ingresar extends javax.swing.JInternalFrame {

    EspecialidadControlador controlador = EspecialidadControlador.getInstancia();
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtNombreEspecialidad = new javax.swing.JTextField();

        jLabel6.setText("jLabel6");

        jLabel1.setText("ESPECIALIDAD");

        jLabel2.setText("NOMBRE");

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtNombreEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEspecialidadActionPerformed(evt);
            }
        });
        txtNombreEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreEspecialidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(btnGuardar)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEspecialidadActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

controlador.AgregarEspecialidad(txtNombreEspecialidad.getText());
        JOptionPane.showMessageDialog(this, "ESPECIALIDAD AGREGADA EXITOSAMENTE: "+txtNombreEspecialidad.getText());
txtNombreEspecialidad.setText("");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreEspecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEspecialidadKeyTyped
char c = evt.getKeyChar();

if(Character.isDigit(c)){
    evt.consume();
}
    }//GEN-LAST:event_txtNombreEspecialidadKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtNombreEspecialidad;
    // End of variables declaration//GEN-END:variables
}
