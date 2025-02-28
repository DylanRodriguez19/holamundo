
package prysingletarea;

import java.util.ArrayList;

public class Notificador {
     private static Notificador instancia;
    private ArrayList<String> lista;

    private Notificador() {
        this.lista = new ArrayList<>();
    }

    public static Notificador getInstancia() {
        if (instancia == null) {
            instancia = new Notificador();
        }
        return instancia;
    }

    public void enviarNotificacion(String mensaje) {
        lista.add(mensaje);
        System.out.println("Nueva notificacion: " + mensaje);
    }

    public void mostrarHistorial() {
        System.out.println("Historial de lista de notificaciones:");
        for (String notificacion : lista) {
            System.out.println("- " + notificacion);
        }
    }
}
