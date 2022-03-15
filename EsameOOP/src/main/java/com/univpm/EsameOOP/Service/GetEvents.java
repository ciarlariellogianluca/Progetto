package com.univpm.EsameOOP.Service;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.univpm.EsameOOP.GetApi.TicketMasterApi;
import com.univpm.EsameOOP.Model.Attraction;
import com.univpm.EsameOOP.Model.Event;
import com.univpm.EsameOOP.Model.Events;
import com.univpm.EsameOOP.Model.Venue;

/**
 * Classe che restituisce eventi, attrazioni o sedi in base ad un parametro events passato.
 * @author Gianluca Ciarlariello
 * @author Gianmarco Di Renzo
 *
 */

@Service
public class GetEvents {
	
	/**
	 * Metodo per restituire la lista degli eventi, attrazioni o sedi.
	 * @param events
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	
	public ArrayList<Events> Parsing(String events) throws IOException,JSONException{

		JSONObject parser = TicketMasterApi.ApiData(events);
		ArrayList<Events> eventi = new ArrayList<>();
		
		if(events.equals("events")) {
			eventi = GetEvent(parser);
		}
		
		if(events.equals("attractions")) {
			eventi = GetAttraction(parser);
		}
		
		if(events.equals("venues")) {
			eventi = GetVenue(parser);
		}
		
		return eventi;
	}
	
	/**
	 * Metodo per restituire le attrazioni.
	 * @param parser
	 * @return
	 */
	
	private static ArrayList<Events> GetAttraction(JSONObject parser) {
		JSONArray data = parser.getJSONObject("_embedded").getJSONArray("attractions");
		Events evento;
		ArrayList<Events> events = new ArrayList<>();
		
		for(int i=0;i<data.length();i++) {
			evento = new Attraction();
			JSONObject obj = data.getJSONObject(i);
			evento.setId(obj.getString("id"));
			evento.setSito(obj.getString("url"));
			evento.setTipo(obj.getString("type"));
			evento.setNome(obj.getString("name"));
			((Attraction) evento).setGeneri(obj.getJSONArray("classifications"));
			
			events.add(evento);
		}
		
		return events;
	}
	
	/**
	 *  Metodo per restituire le sedi.
	 * @param parser
	 * @return
	 */

	private static ArrayList<Events> GetVenue(JSONObject parser) {
		JSONArray data = parser.getJSONObject("_embedded").getJSONArray("venues");
		Events evento;
		ArrayList<Events> events = new ArrayList<>();
		
		for(int i=0;i<data.length();i++) {
			evento = new Venue();
			JSONObject obj = data.getJSONObject(i);
			evento.setId(obj.getString("id"));
			try {
			evento.setSito(obj.getString("url"));
			} catch(JSONException e) {
				((Venue) evento).setSito("Unavailable");
			}
			evento.setTipo(obj.getString("type"));
			evento.setNome(obj.getString("name"));
			((Venue) evento).setLuogo(obj.getString("timezone"));
			((Venue) evento).setCitta(obj.getJSONObject("city").getString("name"));
			((Venue) evento).setIndirizzo(obj.getJSONObject("address").getString("line1"));
			try {
			((Venue) evento).setNumero(obj.getJSONObject("ada").getString("adaPhones"));
			} catch(JSONException e) {
				((Venue) evento).setNumero("Unavailable");
			}
			try {
			((Venue) evento).setInfo_pagamento(obj.getJSONObject("boxOfficeInfo").getString("acceptedPaymentDetail"));
			} catch(JSONException e) {
				((Venue) evento).setInfo_pagamento("Unavailable");
			}
			events.add(evento);
		}
		
		return events;
	}
	
	/**
	 *  Metodo per restituire gli eventi.
	 * @param parser
	 * @return
	 */

	private static ArrayList<Events> GetEvent(JSONObject parser) {
		JSONArray data = parser.getJSONObject("_embedded").getJSONArray("events");
		Events evento;
		ArrayList<Events> events = new ArrayList<>();
		
		for(int i=0;i<data.length();i++) {
			evento = new Event();
			JSONObject obj = data.getJSONObject(i);
			evento.setId(obj.getString("id"));
			evento.setSito(obj.getString("url"));
			evento.setTipo(obj.getString("type"));
			evento.setNome(obj.getString("name"));
			try {
				((Event) evento).setLuogo(obj.getJSONObject("dates").getString("timezone"));
			} catch(JSONException e) {
				((Event) evento).setLuogo("Unavailable");
			}
			try {
				((Event) evento).setPrezzo_range(String.valueOf(obj.getJSONArray("priceRanges").getJSONObject(0).getInt("min"))+"$/"+obj.getJSONArray("priceRanges").getJSONObject(0).getInt("max")+"$");
			} catch(JSONException e) {
				((Event) evento).setPrezzo_range("Unavailable");
			}
			try {
				((Event) evento).setData(obj.getJSONObject("dates").getJSONObject("start").getString("localDate")+" "+obj.getJSONObject("dates").getJSONObject("start").getString("localTime"));
			} catch(JSONException e) {
				((Event) evento).setData("Unavailable");
			}
			try {
				((Event) evento).setPresale(obj.getJSONObject("sales").getJSONArray("presales"));
			} catch(JSONException e) {
				((Event) evento).setPresale(null);
			}
			try {
				((Event) evento).setPromotore(obj.getJSONObject("promoter").getString("name"));
			} catch(JSONException e) {
				((Event) evento).setPromotore("Unavailable");
			}
			((Event) evento).setSale(obj.getJSONObject("sales").getJSONObject("public").getString("startDateTime"));
			((Event) evento).setGeneri(obj.getJSONArray("classifications"));
			
			events.add(evento);
		}
		
		return events;
	}

}
