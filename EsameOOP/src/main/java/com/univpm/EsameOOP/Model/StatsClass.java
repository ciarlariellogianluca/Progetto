package com.univpm.EsameOOP.Model;

import java.util.HashMap;

/**
 * Classe che modella le statistiche degli eventi filtrati
 * @author Gianluca Ciarlariello
 * @author Gianmarco Di Renzo
 *
 */

public class StatsClass {
	
	private int numTotale;
	private HashMap<String, Integer> numEventForMese;
	private String media;
	private int numEvents;
	private HashMap<String, Integer> numPerLuogo;
	private HashMap<String, Integer> numPerGenere;
	
	public StatsClass() {
		this.numTotale = 0;
		this.numEventForMese = new HashMap<>();
		this.media = null;
		this.numEvents = 0;
		this.numPerLuogo = new HashMap<>();
		this.numPerGenere = new HashMap<>();
	}

	/**
	 * Metodi get e set per tutti gli attributi
	 */
	
	public int getNumTotale() {
		return numTotale;
	}
	
	public void setNumTotale(int numTotale) {
		this.numTotale = numTotale;
	}
	
	public HashMap<String, Integer> getNumEventForMese() {
		return numEventForMese;
	}

	public void setNumEventForMese(HashMap<String, Integer> numEventForMese) {
		this.numEventForMese = numEventForMese;
	}
	
	public int getNumEvents() {
		return numEvents;
	}
	
	public void setNumEvents(int numEvents) {
		this.numEvents = numEvents;
	}
	
	public HashMap<String, Integer> getNumPerLuogo() {
		return numPerLuogo;
	}

	public void setNumPerLuogo(HashMap<String, Integer> numPerLuogo) {
		this.numPerLuogo = numPerLuogo;
	}

	public HashMap<String, Integer> getNumPerGenere() {
		return numPerGenere;
	}

	public void setNumPerGenere(HashMap<String, Integer> numPerGenere) {
		this.numPerGenere = numPerGenere;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}
	
}
