package com.univpm.EsameOOP.Model;

import java.util.ArrayList;

import org.json.JSONArray;

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
		String type = null;
		String subType = null;
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
			try {
				type = jsonArray.getJSONObject(0).getJSONObject("type").getString("name");
			} catch(Exception e) {
				type = "";
			}
			try {
				subType = jsonArray.getJSONObject(0).getJSONObject("subType").getString("name");
			} catch(Exception e) {
				subType = "";
			}
			this.generi.add(segment+", "+genre+", "+subGenre+", "+type+", "+subType);
		}
	}

}
