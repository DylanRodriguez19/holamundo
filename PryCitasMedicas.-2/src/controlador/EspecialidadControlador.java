package controlador;

import java.util.ArrayList;
import modelo.EspecialidadModel;

public class EspecialidadControlador {
    ArrayList<EspecialidadModel> listaEspecialidad;
    
    private static EspecialidadControlador instancia;

    private EspecialidadControlador() {
    this.listaEspecialidad = new ArrayList<>();
    }
        public static EspecialidadControlador getInstancia(){
               if (instancia == null){
                   instancia =new EspecialidadControlador();
               }
               return instancia;
        }
        public EspecialidadModel AgregarEspecialidad(String nombre){
            EspecialidadModel modeloEspe = new EspecialidadModel(nombre);
            listaEspecialidad.add(modeloEspe);
            return modeloEspe;
        }
        public ArrayList<EspecialidadModel> listadoCompleto(){
            return listaEspecialidad;
        }
        
       public ArrayList<EspecialidadModel> listadoCompletoPorEspecialidad(String nombre){
           ArrayList<EspecialidadModel> nuevaListaEspe= new ArrayList<>();
           for (EspecialidadModel especialidadModel : listaEspecialidad) {
               if(especialidadModel.getNombre().contains(nombre)){
                   nuevaListaEspe.add(especialidadModel);
               }
           }
           return nuevaListaEspe;
       }
       public EspecialidadModel obtenerNombre(String nombre){
           for (EspecialidadModel especialidadModel : listaEspecialidad) {
               if(especialidadModel.getNombre().equals(nombre)){
                   return especialidadModel;
               }
           }
           return null;
       }
}
