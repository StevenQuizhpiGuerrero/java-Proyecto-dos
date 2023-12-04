package SistemaDeGestionDeBiblioteca;

import java.util.ArrayList;

public class Biblioteca {

	private static final int MAX_PRESTAMOS_USUARIO = 0;
	private String nombre;
	private String direccion;
	private ArrayList<Libro>lista_libros;
	private ArrayList<Usuario>listaUsuarios;
	
	public Biblioteca(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.lista_libros=new ArrayList<>();
		this.listaUsuarios=new ArrayList<>();
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
	public ArrayList<Libro> getLista_libros() {
		return lista_libros;
	}
	public void setLista_libros(ArrayList<Libro> lista_libros) {
		this.lista_libros = lista_libros;
	}
	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuario(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public void agregarLibro(Libro libro) {
		lista_libros.add(libro);
	}
	public void registrarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
	}
	public Libro buscarLibro(String titulo) {
		for(Libro libro : lista_libros) {
			if (libro.getAutor().equalsIgnoreCase(titulo)&& libro.isDisponible()) {
			return libro;
			}
		}
		return null;
	}
	public void pretarlibro(Libro libro,Usuario usuario) {
		if (libro.isDisponible()) {
			Prestamo prestamo=new Prestamo(libro,usuario);
			if (usuario.listaPrestamos.size()<MAX_PRESTAMOS_USUARIO) {
				usuario.solicitarPrestamo(libro);
				listaUsuarios.add(usuario);
				libro.prestar();
				System.out.println("el libro"+libro.getTitulo()+"asido prestado a"+usuario.nombre);
			}else {
				System.out.println("el usuario a alcanzo el limite de prestamos");
			}
		}else {
			System.out.println("el libro no esta disponible en este momento");
		}
	}
}
