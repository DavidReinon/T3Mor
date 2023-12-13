package es.florida.hibernate;

import java.time.LocalTime;

public class Canço {

	private int id;
	private String nom;
	private String artista;
	private String duraçio;
	private int any;

	public void setNom(String nombre) {
		nom = nombre;
	}

	public void setArtista(String artist) {
		artista = artist;
	}

	public void setDuraçio(String dur) {
		duraçio = dur;
	}

	public void setAnyo(int an) {
		any = an;
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

	public int getAnyo() {
		return any;
	}

	public Canço() {
		// TODO Auto-generated constructor stub
	}
}
