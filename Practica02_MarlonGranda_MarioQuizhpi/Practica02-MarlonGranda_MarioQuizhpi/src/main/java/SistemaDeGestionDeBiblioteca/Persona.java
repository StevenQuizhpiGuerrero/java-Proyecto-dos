package SistemaDeGestionDeBiblioteca;

public abstract class Persona {

	protected  String nombre;
	protected String identificacion;
	
	public Persona(String nombre, String identificacion) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
	}
	public abstract void mostrarInformacion();
}
