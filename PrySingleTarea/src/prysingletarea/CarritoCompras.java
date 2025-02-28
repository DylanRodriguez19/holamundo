
package prysingletarea;

import java.util.ArrayList;

public class CarritoCompras {
    private static CarritoCompras instancia;
    private ArrayList<String> lista;

    private CarritoCompras() {
        this.lista = new ArrayList<>();
    }

    public static CarritoCompras getInstancia() {
        if (instancia == null) {
            instancia = new CarritoCompras();
        }
        return instancia;
    }

    public void agregarProducto(String producto) {
        lista.add(producto);
        System.out.println("Producto agregado: " + producto);
    }

    public void eliminarProducto(String producto) {
        if (lista.remove(producto)) {
            System.out.println("Producto eliminado: " + producto);
        } else {
            System.out.println("Producto no encontrado en el carrito");
        }
    }

    public void mostrarCarrito() {
        System.out.println(" Productos en el carrito: " + lista);
    }
}
