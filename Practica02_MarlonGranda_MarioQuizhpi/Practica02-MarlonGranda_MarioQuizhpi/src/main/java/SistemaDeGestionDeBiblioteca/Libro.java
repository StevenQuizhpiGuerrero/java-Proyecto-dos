package SistemaDeGestionDeBiblioteca;

public class Libro implements Prestable {

	private String titulo;
	private String autor;
	private int anio;
	private boolean disponible;
	
	public Libro(String titulo, String autor, int anio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.anio = anio;
		this.disponible=true;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public void mostrarInfomacion() {
		System.out.println("titulo:"+ titulo);
		System.out.println("autor:"+ autor);
		System.out.println("anio:"+ anio);
		System.out.println("disponible:"+ disponible);
	}
	public void prestar() {
		disponible=false;
		
	}
	public void devolver() {
		disponible=true;
		
	}
	
}
