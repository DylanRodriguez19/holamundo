package prycitasmedicas.pkg2;

import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import controlador.PacienteControlador;
import modelo.EspecialidadModelo;
import vista.PantallaPrincipal;

public class PryCitasMedicas2 {

    public static void main(String[] args) {
        
        PacienteControlador pc =PacienteControlador.getInstancia();
        pc.AgregarPaciente("050505", "LUIS ARTURO", 20, true);
        pc.AgregarPaciente("25151", "MARCOS TITUAÑA",44, true);
        pc.AgregarPaciente("2616", "MARIA ACUÑA", 64, false);
        
        EspecialidadControlador ec= EspecialidadControlador.getInstancia();
        EspecialidadModelo em1= ec.AgregarEspecialidad("PEDIATRIA");
        EspecialidadModelo em2= ec.AgregarEspecialidad("GENERAL");
        EspecialidadModelo em3= ec.AgregarEspecialidad("VETERINAIA");
        EspecialidadModelo em4= ec.AgregarEspecialidad("ODONTOLOGIA");
        
        MedicoControlador mc= MedicoControlador.getInstancia();
        mc.agregarMedico(em1, "1515", "MATIAS TORRES", 64, true);
        mc.agregarMedico(em2, "2616", "MARILUNA DARQUEA", 42, true);
        mc.agregarMedico(em3, "1415", "MARIA ANTONELLA", 34, false);
        mc.agregarMedico(em4, "1620", "ANITA PEREZ", 29, false);
        
        
        PantallaPrincipal pantalla = new PantallaPrincipal();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
    }
    
}
