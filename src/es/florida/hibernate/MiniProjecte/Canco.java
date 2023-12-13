package es.florida.hibernate.MiniProjecte;

import java.time.LocalTime;

public class Canco {

	private int id;
	private String nom;
	private String artista;
	private String duracio;
	private int any;

	public void setId(int i) {
		id = i;
	}

	public void setNom(String nombre) {
		nom = nombre;
	}

	public void setArtista(String artist) {
		artista = artist;
	}

	public void setDuracio(String dur) {
		duracio = dur;
	}

	public void setAny(int an) {
		any = an;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getArtista() {
		return artista;
	}

	public String getDuracio() {
		return duracio;
	}

	public int getAny() {
		return any;
	}

	public Canco() {
		// TODO Auto-generated constructor stub
	}

	public Canco(String nom, String artista, String duracio, int any) {
		super();
		this.nom = nom;
		this.artista = artista;
		this.duracio = duracio;
		this.any = any;
	}

	@Override
	public String toString() {
		return id + " - " + nom + " - " + artista + " - " + duracio + " - " + any;
	}
}
