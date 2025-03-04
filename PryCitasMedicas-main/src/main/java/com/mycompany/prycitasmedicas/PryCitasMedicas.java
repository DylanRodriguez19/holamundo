package com.mycompany.prycitasmedicas;

import controlador.CitasController;
import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import controlador.PacienteCoontrolador;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;
import vista.PantallaPrincipal;

public class PryCitasMedicas {

    public static void main(String[] args) {
        
        PacienteCoontrolador pc=PacienteCoontrolador.getInstacia();
        PacienteModelo pm1 = pc.guardarDatos("050212515", "LUIS ARIAS", 20, true);
        PacienteModelo pm2 = pc.guardarDatos("215151", "FELIPE", 20, true);
        PacienteModelo pm3 = pc.guardarDatos("2125121","ANA", 20, false);
        
        EspecialidadControlador ec=EspecialidadControlador.getInstancia();
        EspecialidadModelo em1 = ec.guardar("MEDICINA GENERAL");
        EspecialidadModelo em2 = ec.guardar("PEDIATRIA");
        EspecialidadModelo em3 = ec.guardar("ODONTOLOGIA");
        
        MedicoControlador mc=MedicoControlador.getInstacia();
        MedicoModelo mm1 = mc.guardar(em1, "21250215", "JORGE", 30, true);
        MedicoModelo mm2 = mc.guardar(em2, "25451215145", "GEORGINA", 30, false);
        MedicoModelo mm3 = mc.guardar(em3, "11512", "PEDRO", 30, true);
        
        CitasController cc = CitasController.getInstancia();
        cc.guardar(pm1, mm1, em1, "DOLOR DE CABEZA", "04/03/24", "13:00","ATENDIDO");
        cc.guardar(pm2, mm2, em2, "DOLOR ESTOMAGO", "06/03/25", "16:00", "NO ATENDIDO");
        
        cc.guardar(pm3, mm3, em3, "DOLOR DE BRAZO", "01/03/25", "22:00", "ATENDIDO");
        cc.guardar(pm1, mm2, em2, "ENSIA SANGRA", "18/03/25", "10:00", "NO ATENDIDO");
        
        cc.guardar(pm1, mm3, em3, "DIENTE SUELTO", "12/05/25", "19:00", "NO ATENDIDO");
        cc.guardar(pm2, mm1, em1, "DOLOR ESOFAGO", "03/03/25", "16:00", "ATENDIDO");
        
        cc.guardar(pm2, mm3, em3, "DOLOR PULMONAR", "06/03/25", "16:00", "NO ATENDIDO");
        cc.guardar(pm3, mm1, em1, "DOLOR DE ANTEBRAZO", "09/03/25", "22:00", "NO ATENDIDO");
        
        cc.guardar(pm3, mm2, em2, "DOLOR DE ARTICULAR", "01/03/25", "19:00", "ATENDIDO");
        
        
        PantallaPrincipal pp= new PantallaPrincipal();
        pp.setVisible(true);
        pp.setLocationRelativeTo(null);
    }
}
