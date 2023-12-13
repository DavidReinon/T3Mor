package es.florida.hibernate;

import java.time.LocalTime;

public class Canco {

	private int id;
	private String nom;
	private String artista;
	private String duraçio;
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

	public void setDuraçio(String dur) {
		duraçio = dur;
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

	public String getDuraçio() {
		return duraçio;
	}

	public int getAny() {
		return any;
	}

	public Canco() {
		// TODO Auto-generated constructor stub
	}
}
