package biblioteca;
// Generated 09-ene-2020 18:15:25 by Hibernate Tools 4.3.1.Final

/**
 * Biblioteca generated by hbm2java
 */
public class Biblioteca implements java.io.Serializable {

	private int idBiblioteca;
	private String nom;

	public Biblioteca() {
	}

	public Biblioteca(int idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}

	public Biblioteca(int idBiblioteca, String nom) {
		this.idBiblioteca = idBiblioteca;
		this.nom = nom;
	}

	public int getIdBiblioteca() {
		return this.idBiblioteca;
	}

	public void setIdBiblioteca(int idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
