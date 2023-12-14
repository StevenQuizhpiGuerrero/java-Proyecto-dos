package SistemaDeGestionDeBiblioteca;

import java.util.Scanner;

import ec.edu.ups.borrador_marlon.Biblioteca;
import ec.edu.ups.borrador_marlon.Libro;
import ec.edu.ups.borrador_marlon.Usuario;

public class Main {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "123 Calle Principal");
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Buscar Libro");
            System.out.println("4. Prestar Libro");
            System.out.println("5. Devolver Libro");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    
                    System.out.println("Ingrese el título del libro:");
                    String tituloLibro = scanner.nextLine();
                    System.out.println("Ingrese el autor del libro:");
                    String autorLibro = scanner.nextLine();
                    System.out.println("Ingrese el año del libro:");
                    int añoLibro = scanner.nextInt();
                    Libro nuevoLibro = new Libro(tituloLibro, autorLibro, añoLibro);
                    biblioteca.agregarLibro(nuevoLibro);
                    System.out.println("Libro agregado exitosamente.");
                    break;
                case 2:
                    
                    System.out.println("Ingrese el nombre del usuario:");
                    String nombreUsuario = scanner.nextLine();
                    System.out.println("Ingrese la identificación del usuario:");
                    String idUsuario = scanner.nextLine();
                    System.out.println("Ingrese el correo del usuario:");
                    String correoUsuario = scanner.nextLine();
                    Usuario nuevoUsuario = new Usuario(nombreUsuario, idUsuario, correoUsuario);
                    biblioteca.registrarUsuario(nuevoUsuario);
                    System.out.println("Usuario registrado exitosamente.");
                    break;
                case 3:
                    
                    System.out.println("Ingrese el título del libro a buscar:");
                    String tituloBuscar = scanner.nextLine();
                    Libro libroEncontrado = biblioteca.buscarLibro(tituloBuscar);
                    if (libroEncontrado != null) {
                        libroEncontrado.mostrarInformacion();
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del libro a prestar: ");
                    String titulo = scanner.nextLine();
                    Libro libroEncon = biblioteca.buscarLibro(titulo);
                    if(libroEncon != null){
                        libroEncon.mostrarInformacion();
                        System.out.println("Se puede proceder a prestar el Libro");
                        System.out.println("Libro prestado correctamente");
                    }else{
                        System.out.println("Libro no disponible, no se puede realizar el prestamo");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
            }
        } while (opcion != 6);
        scanner.close();

	}
}
