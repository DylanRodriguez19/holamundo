
package controlador;

import java.util.ArrayList;
import modelo.CitaModelo;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;

public class CitasController {
    public ArrayList<CitaModelo> citaModelos;
    private static CitasController instancia;
    
    private CitasController(){
        citaModelos=new ArrayList<>();
    }
    
    public static CitasController getInstancia(){
        if(instancia==null){
            instancia=new CitasController();
        }
        return instancia;
    };
    
    
    public CitaModelo guardar(
        PacienteModelo pm,
        MedicoModelo mm, 
        EspecialidadModelo em, 
        String descripcion,
        String fecha,
        String hora,
        String estado // Nuevo parámetro: ATENDIDO o NO ATENDIDO
) {
    // Crear una nueva cita con el estado proporcionado
    CitaModelo cm = new CitaModelo(pm, mm, em, descripcion, fecha, hora, estado);
    
    // Agregar la cita a la lista de citas
    citaModelos.add(cm);
    
    // Retornar la cita creada
    return cm;
}
      public ArrayList<CitaModelo> listadoCompleto(){
        return citaModelos;
    }
      public ArrayList<CitaModelo> ListadoPorFecha(String fecha) {
    ArrayList<CitaModelo> nuevoListado = new ArrayList<>();

    for (CitaModelo citaModelo : citaModelos) {
        
        if (citaModelo.getFecha().equals(fecha)) {
            nuevoListado.add(citaModelo);
        }
    }
    return nuevoListado;
}
      
      public ArrayList<CitaModelo> ListadoPorHora(String hora) {
    ArrayList<CitaModelo> nuevoListado = new ArrayList<>();

    for (CitaModelo citaModelo : citaModelos) {
        
        if (citaModelo.getHora().equals(hora)) {
            nuevoListado.add(citaModelo);
        }
    }
    return nuevoListado;
}
public ArrayList<CitaModelo> ListadoPorEstado(String estado) {

    ArrayList<CitaModelo> nuevoListado = new ArrayList<>();

    for (CitaModelo citaModelo : citaModelos) {
        // Comparar los estados (ignorando mayúsculas/minúsculas)
        if (citaModelo.getEstado().equalsIgnoreCase(estado)) {
            nuevoListado.add(citaModelo);
        }
    }
    // Retornar la lista filtrada
    return nuevoListado;
}
   public ArrayList<CitaModelo> listadoPorPaciente(String cedulaPaciente) {
    ArrayList<CitaModelo> citasDelPaciente = new ArrayList<>();

    for (CitaModelo cita : citaModelos) {
        if (cita.getPm().getCedula().equals(cedulaPaciente)) {
            citasDelPaciente.add(cita);
        }
    }

    return citasDelPaciente;
}
}
