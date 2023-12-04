package SistemaDeGestionDeBiblioteca;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Prestamo {

	private Libro libro;
	private Usuario usuario;
	private Date fechaPrestamo;
	private Date fechaDevolucion;
	public Prestamo(Libro libro, Usuario usuario) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.fechaPrestamo=new Date();
		this.fechaDevolucion=new Date();
	}
	public Libro getLibro() {
		return libro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public int calcularDiasPrestamo() {
		LocalDate fechaActual=LocalDate.now();
		LocalDate fechaPrestamoLocalDate=fechaPrestamo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		long diasPrestamo=ChronoUnit.DAYS.between(fechaPrestamoLocalDate, fechaActual);
		return Math.toIntExact(diasPrestamo);
	}
	public boolean esPrestamoVigente() {
		int diasMaximosPrestamo=15;/*los dias maximos de entrega son 15*/
		int diasPrestamo=calcularDiasPrestamo();
		return diasPrestamo<=diasMaximosPrestamo;
	}
}
