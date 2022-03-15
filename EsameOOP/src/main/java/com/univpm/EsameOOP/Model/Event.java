package com.univpm.EsameOOP.Model;
import java.util.ArrayList;

import org.json.JSONArray;

/**
 * Classe che estende Events e modella gli eventi.
 * @author Gianluca Ciarlariello
 * @author Gianmarco Di Renzo
 *
 */

public class Event extends Events{
	
	private String luogo;
	private String prezzo_range;
	private String data;
	private String sale;
	private ArrayList<String> presale;
	private String promotore;
	private String generi;
	
	public Event() {
		super();
		this.luogo = null;
		this.prezzo_range = null;
		this.data = null;
		this.sale = null;
		this.presale = new ArrayList<String>();
		this.promotore = null;
		this.generi = null;
	}
	
	public Event(String luogo, String prezzo_range, String data, String sale, JSONArray presale, String promotore, JSONArray genere) {
		super();
		this.setLuogo(luogo);
		this.setPrezzo_range(prezzo_range);
		this.setData(data);
		this.setSale(sale);
		this.setPresale(presale);
		this.setPromotore(promotore);
		this.setGeneri(genere);
	}
	
	/**
	 * Metodi get e set di tutti gli attributi
	 * @return
	 */
	
	public String getLuogo() {
		return luogo;
	}
	
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	
	public String getPrezzo_range() {
		return prezzo_range;
	}
	
	public void setPrezzo_range(String prezzo_range) {
		this.prezzo_range = prezzo_range;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getSale() {
		return sale;
	}
	
	public void setSale(String sale) {
		this.sale = sale;
	}
	
	public ArrayList<String> getPresale() {
		return presale;
	}
	
	public void setPresale(JSONArray jsonArray) {
		if(jsonArray != null)
			for(int i=0;i<jsonArray.length();i++)
				this.presale.add(jsonArray.getJSONObject(i).getString("name")+", Inizio : "+jsonArray.getJSONObject(i).getString("startDateTime")+", Fine : "
						+jsonArray.getJSONObject(i).getString("endDateTime"));
	}
	
	public String getPromotore() {
		return promotore;
	}
	
	public void setPromotore(String promotore) {
		this.promotore = promotore;
	}
	
	public String getGeneri() {
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
			this.generi = segment+", "+genre+", "+subGenre;
		}
	}
	
	
}
