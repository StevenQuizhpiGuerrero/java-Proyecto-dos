package SistemaDeGestionDeBiblioteca;

import java.util.ArrayList;

import ec.edu.ups.borrador_marlon.Libro;
import ec.edu.ups.borrador_marlon.Usuario;

public class Biblioteca {
	
	private String nombre;
    private String direccion;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Usuario> listaUsuarios;

    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaLibros = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
        System.out.println("Libro agregado a la biblioteca: " + libro.getTitulo());
    }

    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    public Libro buscarLibro(String titulo) {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarLibroPorAutor(String autor) {
        for (Libro libro : listaLibros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarLibroPorAnio(int año) {
        for (Libro libro : listaLibros) {
            if (libro.getAño() == año) {
                return libro;
            }
        }
        return null;
    }  
}
