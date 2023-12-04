package SistemaDeGestionDeBiblioteca;

import java.util.ArrayList;

public class Usuario extends Persona {

	private String correo;
	protected ArrayList<Prestamo>listaPrestamos;
	
	public Usuario(String nombre, String identificacion,String correo) {
		super(nombre, identificacion);
		this.correo=correo;
		this.listaPrestamos=new ArrayList<>();
	}
	@Override
	public void mostrarInformacion() {
		System.out.println("nombre:"+ nombre );
		System.out.println("identificacion:"+ identificacion);
		System.out.println("correo:"+ correo);
	}
	public void solicitarPrestamo(Libro libro) {
		Prestamo prestamo = new Prestamo(libro, this);
		listaPrestamos.add(prestamo);
		libro.prestar();
		System.out.println("el prestamo se a realizado correctamente");
	}
	public void devolverLibro(Libro libro) {
		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.getLibro()==libro) {
				listaPrestamos.remove(prestamo);
				libro.devolver();
				System.out.println("la devulocion del libro se a realizado correctamente");
				return;
			}
		}
		System.out.println("libro no asido prestado por este usuario");
	}
}
