
package controlador;

import java.util.ArrayList;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;


public class MedicoControlador {
  
    ArrayList<MedicoModelo> MedicoLista ;
    
 private static MedicoControlador instancia;

    public MedicoControlador() {
        this.MedicoLista = new ArrayList<>();
    }
    
public static  MedicoControlador getInstancia(){
    if(instancia==null){
        instancia = new MedicoControlador();
    }
    return instancia;
}
 
public MedicoModelo agregarMedico(EspecialidadModelo especialidad, String cedula, String nombres, int edad, boolean sexo){
MedicoModelo medico = new MedicoModelo(especialidad, cedula, nombres, edad, sexo);
    MedicoLista.add(medico);
    return medico;
}

public  ArrayList<MedicoModelo> RetornarListaMedico(){
  return MedicoLista;    
}

  public ArrayList<MedicoModelo> ListadoCompletoPorCedula(String cedula){
        ArrayList<MedicoModelo> nuevaListaMedico = new ArrayList<>();
        for (MedicoModelo medic : MedicoLista) {
            if(medic.getCedula().contains(cedula)){
                nuevaListaMedico.add(medic);
            }
        }
        return nuevaListaMedico;
    }


  public ArrayList<MedicoModelo> ListadoPorEspecialidad(String nombreEspecialidad){
        ArrayList<MedicoModelo> nuevaListaMedico = new ArrayList<>();
        for (MedicoModelo medicom : MedicoLista) {
            if(medicom.getEspecialidad().getNombre().contains(nombreEspecialidad)){
                nuevaListaMedico.add(medicom);
            }
        }
        return nuevaListaMedico;
    }
      public MedicoModelo  obtenerCedulaMedico (String cedula){
          for (MedicoModelo medicoModelo : MedicoLista) {
             if(medicoModelo.getCedula().equals(cedula))
               return medicoModelo; 
          }   
        return null;
    }
  }
  
  


