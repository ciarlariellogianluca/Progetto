package com.univpm.EsameOOP.Model;

import java.util.HashMap;

public class StatsClass {
	
	private int numTotale;
	private int numEvents;
	private int numAttractions;
	private int numVenues;
	private HashMap<String, Integer> numPerLuogo;
	private HashMap<String, Integer> numPerGenere;
	private int numMaxEvents;
	private int numMinEvents;
	private float numAvgEvents;
	
	public StatsClass() {
		this.numTotale = 0;
		this.numEvents = 0;
		this.numAttractions = 0;
		this.numVenues = 0;
		this.numPerLuogo = new HashMap<>();
		this.numPerGenere = new HashMap<>();
		this.numMaxEvents = 0;
		this.numMinEvents = 0;
		this.numAvgEvents = 0;
	}
	
	public int getNumTotale() {
		return numTotale;
	}
	public void setNumTotale(int numTotale) {
		this.numTotale = numTotale;
	}
	public int getNumEvents() {
		return numEvents;
	}
	public void setNumEvents(int numEvents) {
		this.numEvents = numEvents;
	}
	public int getNumAttractions() {
		return numAttractions;
	}
	public void setNumAttractions(int numAttractions) {
		this.numAttractions = numAttractions;
	}
	public int getNumVenues() {
		return numVenues;
	}
	public void setNumVenues(int numVenues) {
		this.numVenues = numVenues;
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

	public int getNumMaxEvents() {
		return numMaxEvents;
	}
	public void setNumMaxEvents(int numMaxEvents) {
		this.numMaxEvents = numMaxEvents;
	}
	public int getNumMinEvents() {
		return numMinEvents;
	}
	public void setNumMinEvents(int numMinEvents) {
		this.numMinEvents = numMinEvents;
	}
	public float getNumAvgEvents() {
		return numAvgEvents;
	}
	public void setNumAvgEvents(float numAvgEvents) {
		this.numAvgEvents = numAvgEvents;
	}
	
}
