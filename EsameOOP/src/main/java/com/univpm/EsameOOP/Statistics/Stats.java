package com.univpm.EsameOOP.Statistics;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.univpm.EsameOOP.Filters.Filters;
import com.univpm.EsameOOP.Filters.FiltersBodyClass;
import com.univpm.EsameOOP.GetApi.TicketMasterApi;
import com.univpm.EsameOOP.Model.Events;
import com.univpm.EsameOOP.Model.StatsClass;
import com.univpm.EsameOOP.Service.GetEvents;

@Service
public class Stats {
	
	public StatsClass Statistics(FiltersBodyClass body) throws JSONException, IOException, ParseException {
		
		JSONObject data = TicketMasterApi.ApiData("events");
		
		StatsClass stat = new StatsClass();
		GetEvents get_events = new GetEvents();
		ArrayList<Events> events = new ArrayList<>();
		ArrayList<Events> venues = new ArrayList<>();
		ArrayList<Events> attractions = new ArrayList<>();
		ArrayList<Events> filter_genere = new ArrayList<>();
		ArrayList<Events> filter_luogo = new ArrayList<>();
		
		events = get_events.Parsing("events");
		venues = get_events.Parsing("venues");
		attractions = get_events.Parsing("attractions");
		
		stat.setNumEvents(events.size());
		stat.setNumVenues(venues.size());
		stat.setNumAttractions(attractions.size());
		stat.setNumTotale(stat.getNumAttractions()+stat.getNumEvents()+stat.getNumVenues());
		
		Filters filter = new Filters();
		
		HashMap<String,Integer> genere;
		if (body.getGenere() != "" && body.getGenere() != null) {
			filter_genere = filter.filterGenere(body, events);
			genere = new HashMap<>();
			genere.put(body.getGenere(), filter_genere.size());
			stat.setNumPerGenere(genere);
		}
		else {
			String generi;
			genere = new HashMap<>();
			for(int i=0;i<data.getJSONObject("_embedded").getJSONArray("events").length();i++) {
				try {
					generi = data.getJSONObject("_embedded").getJSONArray("events").getJSONObject(i).getJSONArray("classifications").getJSONObject(0).getJSONObject("genre").getString("name");
				} catch (Exception e) {
					generi = "Unavailable";
				}
				if (genere.containsKey(generi)) {
					genere.put(generi,genere.get(generi)+1);
				}
				else
					genere.put(generi,1);
			}
			stat.setNumPerGenere(genere);
		}
		
		HashMap<String,Integer> luogo;
		if (body.getLuogo() != "" && body.getLuogo() != null) {
			filter_luogo = filter.filterLuogo(body, events);
			luogo = new HashMap<>();
			luogo.put(body.getLuogo(), filter_luogo.size());
			stat.setNumPerLuogo(luogo);
		}
		else {
			String luoghi;
			luogo = new HashMap<>();
			for(int i=0;i<data.getJSONObject("_embedded").getJSONArray("events").length();i++) {
				try {
					luoghi = data.getJSONObject("_embedded").getJSONArray("events").getJSONObject(i).getJSONObject("dates").getString("timezone");
				} catch (Exception e) {
					luoghi = "Unavailable";
				}
				if (luogo.containsKey(luoghi)) {
					luogo.put(luoghi,luogo.get(luoghi)+1);
				}
				else
					luogo.put(luoghi,1);
			}
			stat.setNumPerLuogo(luogo);
		}
		
		return stat;
	}
}
