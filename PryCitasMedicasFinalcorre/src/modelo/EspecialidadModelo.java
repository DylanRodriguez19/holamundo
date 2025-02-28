
package modelo;


public class EspecialidadModelo {
  
String nombre;    

    public EspecialidadModelo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
            

}