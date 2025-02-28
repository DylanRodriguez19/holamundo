package vista;

import javax.swing.JOptionPane;
import modelo.GuardarCita;
import vista.cita.ListadoCita;
import vista.doctores.ListadoDoctores;
import vista.pacientes.Ingresar;
import vista.Turno.ListadoTurno;
import vista.pacientes.Listado;


public class PantallaPrincipal extends javax.swing.JFrame {
    private String pacienteSeleccionado;
    private String doctorSeleccionado;
    private String fechaSeleccionada;
    private String horaSeleccionada;
    
    
    private Ingresar ingresar;
    private Listado listado;
    private ListadoDoctores listadoDoctores;
    private ListadoCita listadoCita;
    private ListadoTurno listadoTurno;
GuardarCita citaSeleccionada = new GuardarCita(pacienteSeleccionado, fechaSeleccionada,horaSeleccionada, doctorSeleccionado);

    public PantallaPrincipal() {
        initComponents();
         ingresar = new Ingresar();
        listado = new Listado(this);
        listadoDoctores = new ListadoDoctores(this);
        listadoCita = new ListadoCita(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor_Principal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menu_IngresarPaciente = new javax.swing.JMenuItem();
        menu_ListadoPaciente = new javax.swing.JMenuItem();
        menu_ListadoDoctores = new javax.swing.JMenu();
        menu_ListadoDoctoress = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menu_ListadoCitas = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menu_ListadoTurno = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(617, 480));

        contenedor_Principal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenedor_PrincipalLayout = new javax.swing.GroupLayout(contenedor_Principal);
        contenedor_Principal.setLayout(contenedor_PrincipalLayout);
        contenedor_PrincipalLayout.setHorizontalGroup(
            contenedor_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        contenedor_PrincipalLayout.setVerticalGroup(
            contenedor_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );

        jMenu1.setText("INICIO");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("PACIENTES");

        menu_IngresarPaciente.setText("INGRESO");
        menu_IngresarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_IngresarPacienteActionPerformed(evt);
            }
        });
        jMenu2.add(menu_IngresarPaciente);

        menu_ListadoPaciente.setText("LISTADO");
        menu_ListadoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ListadoPacienteActionPerformed(evt);
            }
        });
        jMenu2.add(menu_ListadoPaciente);

        jMenuBar1.add(jMenu2);

        menu_ListadoDoctores.setText("ESPECIALIDAD");

        menu_ListadoDoctoress.setText("LISTADO");
        menu_ListadoDoctoress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ListadoDoctoressActionPerformed(evt);
            }
        });
        menu_ListadoDoctores.add(menu_ListadoDoctoress);

        jMenuBar1.add(menu_ListadoDoctores);

        jMenu6.setText("CITAS");

        menu_ListadoCitas.setText("LISTADO");
        menu_ListadoCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ListadoCitasActionPerformed(evt);
            }
        });
        jMenu6.add(menu_ListadoCitas);

        jMenuBar1.add(jMenu6);

        jMenu3.setText("TURNO");

        menu_ListadoTurno.setText("LISTADO");
        menu_ListadoTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ListadoTurnoActionPerformed(evt);
            }
        });
        jMenu3.add(menu_ListadoTurno);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor_Principal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor_Principal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_IngresarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_IngresarPacienteActionPerformed
    mostrarPantalla(ingresar);
        
    }//GEN-LAST:event_menu_IngresarPacienteActionPerformed

    private void menu_ListadoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ListadoPacienteActionPerformed
         mostrarPantalla(listado);
    }//GEN-LAST:event_menu_ListadoPacienteActionPerformed

    private void menu_ListadoDoctoressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ListadoDoctoressActionPerformed
        mostrarPantalla(listadoDoctores);

    }//GEN-LAST:event_menu_ListadoDoctoressActionPerformed

    private void menu_ListadoCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ListadoCitasActionPerformed
         mostrarPantalla(listadoCita);
         
    }//GEN-LAST:event_menu_ListadoCitasActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
       contenedor_Principal.removeAll();
       contenedor_Principal.revalidate();
       contenedor_Principal.repaint();
       
    }//GEN-LAST:event_jMenu1MouseClicked

    private void menu_ListadoTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ListadoTurnoActionPerformed

      mostrarListadoTurnos();
            
    }//GEN-LAST:event_menu_ListadoTurnoActionPerformed

     private void mostrarPantalla(javax.swing.JInternalFrame pantalla) {
        contenedor_Principal.removeAll();
        contenedor_Principal.add(pantalla); 
        pantalla.setVisible(true);
        contenedor_Principal.revalidate();
        contenedor_Principal.repaint();
    }
       private void mostrarListadoTurnos() {
        if (pacienteSeleccionado == null || doctorSeleccionado == null || fechaSeleccionada == null || horaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Seleccione todos los datos antes de continuar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        listadoTurno = new ListadoTurno(citaSeleccionada);

        contenedor_Principal.removeAll(); 
        contenedor_Principal.add(listadoTurno);
        contenedor_Principal.revalidate();
        contenedor_Principal.repaint(); 

        listadoTurno.setVisible(true);
    }

    public void setPacienteSeleccionado(String pacienteSeleccionado) {
        this.pacienteSeleccionado = pacienteSeleccionado;
    }

    public void setDoctorSeleccionado(String doctorSeleccionado) {
        this.doctorSeleccionado = doctorSeleccionado;
    }

    public void setFechaSeleccionada(String fechaSeleccionada) {
        this.fechaSeleccionada = fechaSeleccionada;
    }

    public void setHoraSeleccionada(String horaSeleccionada) {
        this.horaSeleccionada = horaSeleccionada;
    }

    public String getPacienteSeleccionado() {
        return pacienteSeleccionado;
    }

    public String getDoctorSeleccionado() {
        return doctorSeleccionado;
    }

    public String getFechaSeleccionada() {
        return fechaSeleccionada;
    }

    public String getHoraSeleccionada() {
        return horaSeleccionada;
    }
    
    

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane contenedor_Principal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menu_IngresarPaciente;
    private javax.swing.JMenuItem menu_ListadoCitas;
    private javax.swing.JMenu menu_ListadoDoctores;
    private javax.swing.JMenuItem menu_ListadoDoctoress;
    private javax.swing.JMenuItem menu_ListadoPaciente;
    private javax.swing.JMenuItem menu_ListadoTurno;
    // End of variables declaration//GEN-END:variables
}
