package com.univpm.EsameOOP.Service;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.univpm.EsameOOP.GetApi.TicketMasterApi;
import com.univpm.EsameOOP.Model.Event;

@Service
public class JSONParsing {
	
	public  ArrayList<Event> Parsing() throws IOException,JSONException{

		JSONObject parser = TicketMasterApi.ApiData();
		JSONArray data= parser.getJSONObject("_embedded").getJSONArray("events");
	
		ArrayList<Event> eventi = new ArrayList<Event>();
	
		for(int i=0;i<data.length();i++) {
			
			Event evento = new Event();
			JSONObject obj = data.getJSONObject(i);
			evento.setId(obj.getString("id"));
			evento.setSito(obj.getString("url"));
			evento.setTipo(obj.getString("type"));
			evento.setNome(obj.getString("name"));
			try {
				evento.setLuogo(obj.getJSONObject("dates").getString("timezone"));
			} catch(JSONException e) {
				evento.setLuogo("Unavailable");
			}
			try {
				evento.setPrezzo_range(String.valueOf(obj.getJSONArray("priceRanges").getJSONObject(0).getInt("min"))+"$/"+obj.getJSONArray("priceRanges").getJSONObject(0).getInt("max")+"$");
			} catch(JSONException e) {
				evento.setPrezzo_range("Unavailable");
			}
			try {
				evento.setData(obj.getJSONObject("dates").getJSONObject("start").getString("localDate")+" "+obj.getJSONObject("dates").getJSONObject("start").getString("localTime"));
			} catch(JSONException e) {
				evento.setData("Unavailable");
			}
			try {
				System.out.println(obj.getJSONObject("sales").getJSONArray("presales"));
				evento.setPresale(obj.getJSONObject("sales").getJSONArray("presales"));
			} catch(JSONException e) {
				evento.setPresale(null);
			}
			try {
				evento.setPromotore(obj.getJSONObject("promoter").getString("name"));
			} catch(JSONException e) {
				evento.setPromotore("Unavailable");
			}
			evento.setSale(obj.getJSONObject("sales").getJSONObject("public").getString("startDateTime"));
			eventi.add(evento);
		}
		return eventi;
	}

}
