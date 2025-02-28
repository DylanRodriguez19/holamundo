
package prysingletarea;

import java.util.ArrayList;
public class GestorUsuarios {
   private static GestorUsuarios instancia;
    private     ArrayList<String> lista;

    private GestorUsuarios() {
        this.lista = new ArrayList<>();
    }

    public static GestorUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    public void agregarUsuario(String usuario) {
        if (!lista.contains(usuario)) {
            lista.add(usuario);
            System.out.println("Usuario agregado: " + usuario);
        } else {
            System.out.println("El usuario ya esta conectado: " + usuario);
        }
    }

    public void eliminarUsuario(String usuario) {
        if (lista.remove(usuario)) {
            System.out.println("Usuario eliminado: " + usuario);
        } else {
            System.out.println("El usuario no estaba conectado: " + usuario);
        }
    }

    public void mostrarUsuarios() {
        System.out.println("Usuarios conectados: " + lista);
    } 
}
