package com.univpm.EsameOOP.Model;

import java.util.ArrayList;

import org.json.JSONArray;

/**
 * Classe che estende Events e modella le attrazioni.
 * @author Gianluca Ciarlariello
 * @author Gianmarco Di Renzo
 *
 */

public class Attraction extends Events {
	
	private ArrayList<String> generi;
	
	public Attraction() {
		super();
		generi = new ArrayList<>();
	}
	
	public ArrayList<String> getGeneri() {
		return generi;
	}
	
	public void setGeneri(JSONArray jsonArray) {
		String segment = null;
		String genre = null;
		String subGenre = null;
		if(jsonArray != null) {
			try {
				segment = jsonArray.getJSONObject(0).getJSONObject("segment").getString("name");
			} catch(Exception e) {
				segment = "";
			}
			try {
				genre = jsonArray.getJSONObject(0).getJSONObject("genre").getString("name");
			} catch(Exception e) {
				genre = "";
			}
			try {
				subGenre = jsonArray.getJSONObject(0).getJSONObject("subGenre").getString("name");
			} catch(Exception e) {
				subGenre = "";
			}
			this.generi.add(segment+", "+genre+", "+subGenre);
		}
	}

}
