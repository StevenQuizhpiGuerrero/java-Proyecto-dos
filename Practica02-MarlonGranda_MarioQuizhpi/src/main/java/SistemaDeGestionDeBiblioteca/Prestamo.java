package SistemaDeGestionDeBiblioteca;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import ec.edu.ups.borrador_marlon.Libro;
import ec.edu.ups.borrador_marlon.Usuario;

public class Prestamo {
	private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int calcularDiasPrestamo() {
        long tiempoPrestamo = new Date().getTime() - this.fechaPrestamo.getTime();
        return (int) (tiempoPrestamo / (1000 * 60 * 60 * 24)); // Convertir milisegundos a días
    }

    public boolean esPrestamoVigente() {
        return this.fechaDevolucion == null;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
