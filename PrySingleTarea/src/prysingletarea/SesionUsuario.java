
package prysingletarea;

public class SesionUsuario {
     private static SesionUsuario instancia;
    private String usuarioActual;
    private boolean estaAutenticado;

    private SesionUsuario() {
        this.usuarioActual = "Invitado";
        this.estaAutenticado = false;
    }

    public static SesionUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SesionUsuario();
        }
        return instancia;
    }

    public void iniciarSesion(String usuario) {
        this.usuarioActual = usuario;
        this.estaAutenticado = true;
        System.out.println("Sesion iniciada para: " + usuario);
    }

    public void cerrarSesion() {
        this.usuarioActual = "Invitado";
        this.estaAutenticado = false;
        System.out.println("Sesion cerrada");
    }

    public void mostrarEstado() {
        System.out.println("Usuario actual: " + usuarioActual);
        if (estaAutenticado) {
        System.out.println("Estado: Autenticado");
        } else {
    System.out.println("Estado: No Autenticado");
        }
    }

    }

