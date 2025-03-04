
package controlador;

import java.util.ArrayList;
import modelo.EspecialidadModelo;

public class EspecialidadControlador {
    ArrayList<EspecialidadModelo> especialidadModelos;
    private static EspecialidadControlador instancia;

    private EspecialidadControlador() {
        this.especialidadModelos = new ArrayList<>();
    }
    
    public static EspecialidadControlador getInstancia(){
        if(instancia==null){
            instancia=new EspecialidadControlador();
        }
        return instancia;
    }
    
    
    public EspecialidadModelo guardar(String nombre){
        EspecialidadModelo modelo=new EspecialidadModelo(nombre);
        especialidadModelos.add(modelo);
        return modelo;
    }
    
    
    public ArrayList<EspecialidadModelo> listado(){
        return especialidadModelos;
    }
    
    public EspecialidadModelo obtenerPorNombre(String nombre){
        for (EspecialidadModelo especialidadModelo : especialidadModelos) {
            if(especialidadModelo.getNombre().equals(nombre)){
                return especialidadModelo;
            }
        }
        
        return null;
    }
}
