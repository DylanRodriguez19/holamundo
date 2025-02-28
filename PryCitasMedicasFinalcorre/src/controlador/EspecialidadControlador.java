package controlador;

import java.util.ArrayList;
import modelo.EspecialidadModelo;
import modelo.PacienteModelo;

public class EspecialidadControlador {

    ArrayList<EspecialidadModelo> ListaEspecialidad;
    private static EspecialidadControlador instancia;

    private EspecialidadControlador() {
        this.ListaEspecialidad = new ArrayList<>();
    }

    public static EspecialidadControlador getInstancia() {

  if (instancia == null) {
instancia = new EspecialidadControlador();
        }
return instancia;
    }
        
    public EspecialidadModelo AgregarEspecialidad(String nombre){
        EspecialidadModelo especialidad = new EspecialidadModelo(nombre);
    ListaEspecialidad.add(especialidad);
    return especialidad;
    }
    
    public ArrayList<EspecialidadModelo> RetornarListarEspecialidad(){
        return ListaEspecialidad;
    }
       
 
    public ArrayList<EspecialidadModelo> ListadoCompletoPorNombre(String nombre){
        ArrayList<EspecialidadModelo> nuevaListaEspecialidad = new ArrayList<>();
        for (EspecialidadModelo especialidad : ListaEspecialidad) {
            if(especialidad.getNombre().contains(nombre)){
                nuevaListaEspecialidad.add(especialidad);
            }
        }
        return nuevaListaEspecialidad;
    }
  
        public EspecialidadModelo obtenerPorNombre(String nombre){
        for (EspecialidadModelo especialidadModelo : ListaEspecialidad) {
            if(especialidadModelo.getNombre().equalsIgnoreCase(nombre)){
                return especialidadModelo;
            }
        }
    return null;
    }

}
