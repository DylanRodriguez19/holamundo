
package controlador;

import java.util.ArrayList;
import modelo.CitaModelo;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;

public class CitaControlador {
    ArrayList<CitaModelo> CitaLista;
    
private static CitaControlador instancia;    

        private CitaControlador() {
        this.CitaLista = new ArrayList<>();
    }
    
 public static CitaControlador getInstancia(){
     if(instancia==null){
         instancia = new CitaControlador();
     }
     return instancia;
 }


    
  public CitaModelo agregarCita(
          PacienteModelo paciente, 
          EspecialidadModelo especialidad, 
          MedicoModelo medico,String asunto , 
          String fecha, 
          String hora){
CitaModelo cita = new CitaModelo(paciente, especialidad, medico, asunto, fecha, hora);
CitaLista.add(cita);
return cita;
        }
    
    
    public ArrayList<CitaModelo> ListaCompletaCita(){
  return CitaLista;
        
    }
    

    
}
