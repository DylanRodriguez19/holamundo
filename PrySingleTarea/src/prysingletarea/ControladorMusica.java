
package prysingletarea;
public class ControladorMusica{
    private static ControladorMusica instancia;
    private String cancionActual;
    private boolean enReproduccion;

    private ControladorMusica() {
        this.cancionActual = "Ninguna";
        this.enReproduccion = false;
    }

    public static ControladorMusica getInstancia() {
        if (instancia == null) {
            instancia = new ControladorMusica();
        }
        return instancia;
    }

    public void reproducir(String cancion) {
        this.cancionActual = cancion;
        this.enReproduccion = true;
        System.out.println("Reproduciendo: " + cancion);
    }

    public void detener() {
        this.enReproduccion = false;
        System.out.println("Reproduccion detenida");
    }

    public void mostrarEstado() {
        System.out.println("Cancion actual: " + cancionActual);
        if (enReproduccion) {
        System.out.println("Estado: En reproduccion");
        } else {
    System.out.println("Estado: Detenido");
        }
    }
    
}
