package SistemaDeGestionDeBiblioteca;

import java.util.ArrayList;
import java.util.Date;

import ec.edu.ups.borrador_marlon.Libro;
import ec.edu.ups.borrador_marlon.Prestamo;

public class Usuario extends Persona {
	private String correo;
    private ArrayList<Prestamo> listaPrestamos;

    public Usuario(String nombre, String identificacion, String correo) {
        super(nombre, identificacion);
        this.correo = correo;
        this.listaPrestamos = new ArrayList<>();
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Identificación: " + this.getIdentificacion());
        System.out.println("Correo: " + correo);
    }

    public void solicitarPrestamo(Libro libro) {
        if (libro.isDisponible()) {
            Prestamo nuevoPrestamo = new Prestamo(libro, this, new Date(), null);
            this.getListaPrestamos().add(nuevoPrestamo);
            libro.setDisponible(false);
            System.out.println("Préstamo realizado correctamente.");
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    public void devolverLibro(Libro libro) {
        for (Prestamo prestamo : this.getListaPrestamos()) {
            if (prestamo.getLibro().equals(libro)) {
                prestamo.setFechaDevolucion(new Date());
                libro.setDisponible(true);
                System.out.println("Libro devuelto correctamente.");
                return;
            }
        }
        System.out.println("El usuario no tiene este libro prestado.");
    }

    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }
}
