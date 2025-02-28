
package prysingletarea;

import java.util.Scanner;

public class PrySingleTarea {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("  Menu de Tareas Singleton    ");
            System.out.println("1. Gestor de Usuarios");
            System.out.println("2. Mostrador de notificaciones");
            System.out.println("3. Iniciar sesion de usuarios");
            System.out.println("4. Controlador de musica");
            System.out.println("5. Carrito de compras electronicas");
            System.out.println("6. Salir");
            System.out.print("Seleccione la Tarea que quiera observar: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                 GestorUsuarios gestor = GestorUsuarios.getInstancia();
                    System.out.println("------------------------------");
                    
                 gestor.agregarUsuario("Carlos");
                  System.out.println("------------------------------");
                  
                 gestor.agregarUsuario("Ana");
                  System.out.println("------------------------------");
                  
                 gestor.agregarUsuario("Luis");
                  System.out.println("------------------------------");
                  
                 gestor.agregarUsuario("Joaquin");
                  System.out.println("------------------------------");
                  
                 gestor.mostrarUsuarios();
                  System.out.println("------------------------------");
                  
                 gestor.eliminarUsuario("Ana");
                  System.out.println("------------------------------");
                  
                 gestor.mostrarUsuarios();
                  System.out.println("------------------------------");
                    break;

                case 2:
                    Notificador notificador = Notificador.getInstancia();
                     System.out.println("------------------------------");
                    notificador.enviarNotificacion("Bienvenido a la aplicacion");
                     System.out.println("------------------------------");
                     
                    notificador.enviarNotificacion("Tienes un nuevo mensaje");
                     System.out.println("------------------------------");
                     
                    notificador.enviarNotificacion("Tienes un nuevo chat");
                     System.out.println("------------------------------");

                    notificador.mostrarHistorial();
                     System.out.println("------------------------------");
                    break;

                case 3:
                    SesionUsuario sesion = SesionUsuario.getInstancia();
                        System.out.println("------------------------------");
                    sesion.mostrarEstado();
                        System.out.println("------------------------------");
                        
                    sesion.iniciarSesion("Juan Perez");
                        System.out.println("------------------------------");
                        
                    sesion.mostrarEstado();
                        System.out.println("------------------------------");
                        
                    sesion.cerrarSesion();
                        System.out.println("------------------------------");
                        
                    sesion.iniciarSesion("Carlos Pastor");
                        System.out.println("------------------------------");
                        
                    sesion.mostrarEstado();
                        System.out.println("------------------------------");
                        
                    sesion.cerrarSesion();
                        System.out.println("------------------------------");
                        
                    sesion.mostrarEstado();
                        System.out.println("------------------------------");
                    break;

                case 4:
                    ControladorMusica musica = ControladorMusica.getInstancia();
                     System.out.println("------------------------------");
                    musica.mostrarEstado();
                     System.out.println("------------------------------");
                     
                    musica.reproducir("Bohemian Rhapsody - Queen");
                     System.out.println("------------------------------");
                     
                     musica.mostrarEstado();
                     System.out.println("------------------------------");
                     
                     musica.detener();
                     System.out.println("------------------------------");
                     
                    musica.reproducir("24/SIEMPRE - C.R.O");
                     System.out.println("------------------------------");
                     
                    musica.mostrarEstado(); 
                     System.out.println("------------------------------");
                     
                    musica.detener();
                     System.out.println("------------------------------");
                     
                    musica.mostrarEstado();
                     System.out.println("------------------------------");
                    break;

                case 5:
                    CarritoCompras carrito = CarritoCompras.getInstancia();
                     System.out.println("------------------------------");
                    carrito.agregarProducto("Laptop");
                     System.out.println("------------------------------");
                     
                    carrito.agregarProducto("Tablet");
                     System.out.println("------------------------------");
                     
                    carrito.agregarProducto("Smartphone");  
                     System.out.println("------------------------------");
                     
                    carrito.mostrarCarrito();
                     System.out.println("------------------------------");
                     
                    carrito.eliminarProducto("Laptop");
                     System.out.println("------------------------------");
                 
                    carrito.mostrarCarrito();
                     System.out.println("------------------------------");
                    break;

                case 6:
                   
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 6);

    }
    }
    

