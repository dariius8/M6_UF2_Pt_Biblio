package biblioteca;
// Generated 09-ene-2020 18:15:25 by Hibernate Tools 4.3.1.Final

/**
 * Llibres generated by hbm2java
 */
public class Llibres implements java.io.Serializable {

	private int idLlibre;
	private Autor autor;
	private String nomLlibre;
	private String editoria;

	public Llibres() {
	}

	public Llibres(int idLlibre) {
		this.idLlibre = idLlibre;
	}

	public Llibres(int idLlibre, Autor autor, String nomLlibre, String editoria) {
		this.idLlibre = idLlibre;
		this.autor = autor;
		this.nomLlibre = nomLlibre;
		this.editoria = editoria;
	}

	public int getIdLlibre() {
		return this.idLlibre;
	}

	public void setIdLlibre(int idLlibre) {
		this.idLlibre = idLlibre;
	}

	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getNomLlibre() {
		return this.nomLlibre;
	}

	public void setNomLlibre(String nomLlibre) {
		this.nomLlibre = nomLlibre;
	}

	public String getEditoria() {
		return this.editoria;
	}

	public void setEditoria(String editoria) {
		this.editoria = editoria;
	}

}
