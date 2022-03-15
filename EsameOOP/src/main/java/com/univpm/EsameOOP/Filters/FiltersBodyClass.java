package com.univpm.EsameOOP.Filters;

/**
 * Classe utilizzata per inserire i dati e ottenere filtri e statistiche.
 * @author Gianluca Ciarlariello
 * @author Gianmarco Di Renzo
 *
 */

public class FiltersBodyClass {
	
	private String luogo;
	private String data;
	private String genere;
	
	public FiltersBodyClass(String luogo, String data, String genere) {
		this.setLuogo(luogo);
		this.setData(data);
		this.setGenere(genere);
	}
	
	/**
	 * Metodi di get e set per tutti gli attributi della classe
	 */

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
	
}
